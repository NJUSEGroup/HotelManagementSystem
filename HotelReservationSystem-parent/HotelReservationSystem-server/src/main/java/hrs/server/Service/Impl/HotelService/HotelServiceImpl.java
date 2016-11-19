package hrs.server.Service.Impl.HotelService;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import hrs.common.Exception.HotelService.HotelNotFoundException;
import hrs.common.Exception.HotelService.HotelQueryNotExecutedException;
import hrs.common.Exception.OrderService.OrderNotFoundException;
import hrs.common.Exception.RoomService.AvailableRoomNotFoundException;
import hrs.common.POJO.HotelPO;
import hrs.common.VO.HotelVO;
import hrs.common.VO.OrderVO;
import hrs.common.VO.RoomVO;
import hrs.common.util.FilterCondition.FilterCondition;
import hrs.common.util.type.OrderRule;
import hrs.server.DAO.Interface.HotelDAO.HotelDAO;
import hrs.server.Service.Interface.HotelService.HotelService;
import hrs.server.Service.Interface.OrderService.OrderSearchService;
import hrs.server.Service.Interface.RoomService.RoomService;
@Service
public class HotelServiceImpl implements HotelService {
	@Autowired
	private HotelDAO dao;
	@Autowired
	private RoomService roomService;
	@Autowired
	private OrderSearchService orderSearchService;
	
	private AvailableHotel hotel = new AvailableHotel();
	
	@Transactional
	@Override
	public HotelVO findByID(int hotelID) {
		HotelPO po = dao.findByID(hotelID);
		if(po == null){
			throw new HotelNotFoundException();
		}else{
			return new HotelVO(po);
		}
	}

	@Transactional
	@Override
	public void update(HotelVO hotelvo) {
		dao.update(new HotelPO(hotelvo));
	}

	@Transactional
	@Override
	public void add(HotelVO hotelvo) {
		dao.add(new HotelPO(hotelvo));
	}

	/**
	 * 
	 * @Title: findOrderedHotelAndOrder 
	 * @Description 查找已预订的酒店和订单列表
	 * @param @param username
	 * @param @return     
	 * @return Map<HotelVO,List<OrderVO>>     
	 * @throws
	 */
	@Transactional
	@Override
	public Map<HotelVO, List<OrderVO>> findOrderedHotelAndOrder(String username) {
		Map<HotelVO, List<OrderVO>> map = new HashMap<>();
		List<OrderVO> orders = orderSearchService.findByUsername(username);
		if (orders.size() == 0) {
			throw new OrderNotFoundException();
		}
		List<OrderVO> orderWithCertainHotel = null;
		for (OrderVO order : orders) {
			if (map.containsKey(order.hotel)) {
				map.get(order.hotel).add(order);
			} else {
				orderWithCertainHotel = new ArrayList<>();
				orderWithCertainHotel.add(order);
				map.put(order.hotel, orderWithCertainHotel);
			}
		}
		return map;
	}
	
	/**
	 * 
	 * @Title: find 
	 * @Description 按照城市、商圈、开始结束时间进行查询
	 * @param @param loc
	 * @param @param circle
	 * @param @param begin
	 * @param @param end
	 * @param @return     
	 * @return Map<HotelVO,List<RoomVO>>     
	 * @throws
	 */
	@Transactional
	@Override
	public Map<HotelVO, List<RoomVO>> find(int loc, int circle, Date begin, Date end,String username) {
		List<HotelPO> pos = dao.find(loc, circle);
		if (pos.size() == 0) {
			throw new HotelNotFoundException();
		}
		Map<HotelVO, List<RoomVO>> map = new HashMap<>();
		HotelVO vo = null;
		List<RoomVO> rooms = null;
		
		for (HotelPO po : pos) {
			//获得酒店所对应的房间列表
			try{
				rooms = roomService.findAvailableByHotelID(po.getId(), begin, end);
			}catch(AvailableRoomNotFoundException e){
				//如果没有的话，那么不将该酒店加入到结果集
				continue;
			}
			System.out.println(rooms.size());
			vo = new HotelVO(po);
			//设置该酒店对应房间的价格区间
			vo.lowValue = Collections.min(rooms).roomValue;
			vo.highValue = Collections.max(rooms).roomValue;
			
			//获得酒店的相关订单类型的集合
			for(OrderVO order:orderSearchService.findByHotelAndUsername(vo.id, username)){
				vo.status.add(order.status);
			}
			map.put(vo, rooms);
		}
		hotel.setData(map);
		return map;
	}

	@Transactional
	@Override
	public Map<HotelVO, List<RoomVO>> filter(List<FilterCondition> conditions) {
		return hotel.filter(conditions);
	}
	
	/**
	 * 
	 * @Title: getRoomDetail 
	 * @Description 获得某个酒店的房间详细信息
	 * @param hotelID
	 * @return 
	 * @see hrs.server.Service.Interface.HotelService.HotelService#getRoomDetail(int)
	 */
	@Transactional
	@Override
	public List<RoomVO> getRoomDetail(int hotelID) {
		if(hotel.getData() == null){
			throw new HotelQueryNotExecutedException();
		}
		Map<HotelVO,List<RoomVO>> map = hotel.getData();
		for (HotelVO vo : map.keySet()) {
			if (vo.id == hotelID) {
				return map.get(vo);
			}
		}
		throw new HotelNotFoundException();
	}

	
	@Transactional
	@Override
	public Map<HotelVO, List<RoomVO>> order(OrderRule rule, boolean isDecrease) {
		return hotel.order(rule, isDecrease);
	}
	
	@Transactional
	@Override
	public void addRemark(HotelVO hotel, int score) {
		hotel.score = (hotel.score*hotel.remarkNum+score)/(hotel.remarkNum+1);
		update(hotel);
	}

}
