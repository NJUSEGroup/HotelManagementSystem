package hrs.client.UI.UserUI.HotelSearchUI;

import java.awt.CardLayout;
import java.awt.Panel;
import java.util.List;

import javax.swing.JPanel;

import hrs.client.UI.UserUI.Components.ComNeedBackPanel;
import hrs.client.UI.UserUI.Components.CommonPanel;
import hrs.client.util.ControllerFactory;
import hrs.common.Controller.UserController.IUserHotelController;
import hrs.common.VO.HotelVO;
import hrs.common.VO.RoomVO;
import hrs.common.VO.UserVO;

/**
 * 搜索酒店主界面
 * 由CardLayout布局的JPanel组成
 * @author 涵
 *
 */
public class HotelPanel extends ComNeedBackPanel {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1513105401650788833L;
	private JPanel hotelCardPanel = new JPanel();
	private CardLayout hotelCard = new CardLayout();
	
	private HotelSearchPanel hotelSearchPanel;
	private PlaceOrderPanel placeOrderPanel;
	private HotelDetailPanel hotelDetailPanel;
	
	private UserVO user;
	private IUserHotelController controller = ControllerFactory.getUserHotelController();
	public HotelPanel(UserVO user){
		this.user = user;
		init();
	}
	@Override
	public void init() {
		setCard();
		
	}
	private void setCard() {
		hotelSearchPanel = new HotelSearchPanel(user);
		hotelSearchPanel.setPanel(this);
		hotelCardPanel.setLayout(hotelCard);
		hotelCardPanel.add("hotelSearch", hotelSearchPanel);
		hotelCardPanel.setBounds(0,0,1103,768);
		hotelCard.show(hotelCardPanel, "hotelSearch");
		
		add(hotelCardPanel);
		
	}
	
	public void showDetail(HotelVO hotel,List<RoomVO> rooms){
		hotelDetailPanel = new HotelDetailPanel(hotel,rooms,user);
		hotelDetailPanel.setPanel(this);
		hotelDetailPanel.setOrderButton();
		hotelCardPanel.add("hotelDetail", hotelDetailPanel);
		hotelCard.show(hotelCardPanel, "hotelDetail");
	}
	
	@Override
	public void back(){
		hotelCard.show(hotelCardPanel, "hotelSearch");
	}
	@Override
	public void placeOrder() {
		
	}
	
	
}
