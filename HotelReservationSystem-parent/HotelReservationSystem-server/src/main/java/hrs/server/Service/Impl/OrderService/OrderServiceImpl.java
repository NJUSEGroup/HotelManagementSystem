package hrs.server.Service.Impl.OrderService;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import hrs.common.POJO.OrderPO;
import hrs.common.VO.CreditRecordVO;
import hrs.common.VO.HotelDiscountVO;
import hrs.common.VO.OrderVO;
import hrs.common.util.ResultMessage;
import hrs.common.util.type.CreditRecordType;
import hrs.common.util.type.OrderStatus;
import hrs.common.util.type.RestoreValueType;
import hrs.server.DAO.Interface.OrderDAO;
import hrs.server.Service.Impl.PromotionService.HotelDiscountService.HotelDiscount;
import hrs.server.Service.Interface.CreditRecordService.CreditRecordService;
import hrs.server.Service.Interface.OrderService.OrderService;
import hrs.server.Service.Interface.PromotionService.HotelDiscountService;
import hrs.server.Service.Interface.PromotionService.WebDiscountService;
@Service
public class OrderServiceImpl implements OrderService {
	@Autowired
	private OrderDAO dao;
	@Autowired
	private HotelDiscountService hotelDiscountService;
	@Autowired
	private WebDiscountService webDiscountService;
	@Autowired
	private CreditRecordService creditRecordService;

	
	@Transactional
	@Override
	public OrderVO placeOrder(OrderVO order) {
		// 读取优惠策略，并对订单进行处理
		// hotelDiscountService.findAllByHotelID(ordervo.getHotelID());
		// webDiscountService.findAll();
		// 读取用户的信息：生日、所在企业、原始信用值
		// 合并后进行优惠
		// 每种优惠策略都设置优惠值
		List<HotelDiscount> strategies = hotelDiscountService.createAllStrategies(order.hotel.id);
		for (HotelDiscount strategy : strategies) {
			strategy.discount(order);//这里传入对象是为了保持一致，因为不同策略需要不同的数据
		}
		for (HotelDiscountVO vo : order.hotelDiscounts.keySet()) {
			order.value -= order.hotelDiscounts.get(vo);
		}
		
		return order;
	}

	@Transactional
	@Override
	public ResultMessage add(OrderVO ordervo) {
		return dao.add(new OrderPO(ordervo));
	}
	/**
	 * 
	 * @Title: checkin 
	 * @Description:入住，更新信用记录
	 * @param ordervo
	 * @return ResultMessage
	 * @see hrs.server.Service.Interface.OrderService.OrderService#checkin(hrs.common.VO.OrderVO)
	 */
	@Transactional
	@Override
	public ResultMessage checkin(OrderVO ordervo) {
		ordervo.checkinTime = new Date();
		ordervo.status = OrderStatus.Executed;
		creditRecordService.add(new CreditRecordVO(ordervo, ordervo.user, CreditRecordType.Execute, (int)ordervo.value));
		return dao.update(new OrderPO(ordervo));
	}

	
	@Transactional
	@Override
	public ResultMessage checkout(OrderVO ordervo) {
		ordervo.checkoutTime = new Date();
		return dao.update(new OrderPO(ordervo));
	}
	
	
	@Transactional
	@Override
	public ResultMessage revokeByUser(OrderVO ordervo) {
		ordervo.revokeTime = new Date();
		ordervo.status = OrderStatus.UserRevoked;
		if(isOverTime(ordervo.revokeTime,ordervo.expectedCheckoutTime)){
			creditRecordService.add(new CreditRecordVO(ordervo,ordervo.user,CreditRecordType.Revoke,(int) (ordervo.value/2)));
		}
		return dao.update(new OrderPO(ordervo));
	}
	
	/**
	 * 
	 * @Title: isOverTime 
	 * @Description: 判断是否撤销的订单距离最晚订单执行时间不足6小时 
	 * 				 不存在撤销时间比最晚订单执行时间还晚的情况，因为那个时候订单状态已经被置为异常了，并且只有未执行订单才有撤销选项
	 * @param @param revokeTime
	 * @param @param expectedCheckoutTime
	 * @param @return     
	 * @return boolean     
	 * @throws
	 */
	private boolean isOverTime(Date revokeTime,Date expectedCheckoutTime) {
		return (expectedCheckoutTime.getTime()-revokeTime.getTime()/(60*60*1000)) >= 6;
	}
	
	/**
	 * 
	 * @Title: revokeByWebMarketer 
	 * @Description: 网站营销人员撤销订单
	 * @param ordervo
	 * @param type
	 * @return ResultMessage 
	 * @see hrs.server.Service.Interface.OrderService.OrderService#revokeByWebMarketer(hrs.common.VO.OrderVO, hrs.common.util.type.RestoreValueType)
	 */
	@Transactional
	@Override
	public ResultMessage revokeByWebMarketer(OrderVO ordervo,RestoreValueType type) {
		ordervo.revokeTime = new Date();
		if(type == RestoreValueType.Full){
			ordervo.status = OrderStatus.RevokedFullValue;
			creditRecordService.add(new CreditRecordVO(ordervo,ordervo.user,CreditRecordType.Revoke,(int)ordervo.value));
		}else if(type == RestoreValueType.Half){
			ordervo.status = OrderStatus.RevokedHalfValue;
			creditRecordService.add(new CreditRecordVO(ordervo,ordervo.user,CreditRecordType.Revoke,(int)(ordervo.value/2)));
		}
		return dao.update(new OrderPO(ordervo));
	}
	
	/**
	 * 
	 * @Title: remark 
	 * @Description:前置条件是评价和评分已经set进入order
	 * @param ordervo
	 * @return 
	 * @see hrs.server.Service.Interface.OrderService.OrderService#remark(hrs.common.VO.OrderVO)
	 */
	@Transactional
	@Override
	public ResultMessage remark(OrderVO ordervo,int score, String evaluation) {
		ordervo.score = score;
		ordervo.evaluation = evaluation;
		return dao.update(new OrderPO(ordervo));
	}
	
	/**
	 * 
	 * @Title: delayCheckin 
	 * @Description: 设置用户延迟入住
	 * @param ordervo
	 * @return 
	 * @see hrs.server.Service.Interface.OrderService.OrderService#delayCheckin(hrs.common.VO.OrderVO)
	 */
	@Transactional
	@Override
	public ResultMessage delayCheckin(OrderVO ordervo) {
		ordervo.status = OrderStatus.Executed;
		ordervo.checkinTime = new Date();
		creditRecordService.add(new CreditRecordVO(ordervo,ordervo.user,CreditRecordType.Execute,(int)ordervo.value));
		return dao.update(new OrderPO(ordervo));
	}
	/**
	 * 
	 * @Title: checkAbNormal 
	 * @Description:定期检查是否存在用户的未执行订单超时 
	 * @see hrs.server.Service.Interface.OrderService.OrderService#checkAbNormal()
	 */
	@Transactional
	@Override
	public void checkAbNormal() {
		Date curr = new Date();
		List<OrderPO> pos = dao.findByOrderStatus(OrderStatus.Unexecuted);
		OrderVO vo = null;
		for(OrderPO po:pos){
			if(po.getExecTime().after(curr)){
				po.setStatus(OrderStatus.Abnormal);
				vo = new OrderVO(po);
				creditRecordService.add(new CreditRecordVO(vo,vo.user,CreditRecordType.Overtime,(int)vo.value));
			}
		}
	}
}
