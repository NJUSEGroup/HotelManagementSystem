package hrs.client.UI.UserUI.HotelSearchUI;

import java.awt.CardLayout;
import java.util.List;

import javax.swing.JPanel;

import hrs.client.UI.UserUI.Components.CommonPanel;
import hrs.client.util.ControllerFactory;
import hrs.common.Controller.UserController.IUserHotelController;
import hrs.common.VO.HotelVO;
import hrs.common.VO.RoomVO;
import hrs.common.VO.UserVO;

public class HotelPanel extends CommonPanel {
	private JPanel hotelCardPanel = new JPanel();
	private CardLayout hotelCard = new CardLayout();
	
	private HotelSearchPanel hotelSearchPanel;
	private PlaceOrderPanel placeOrderPanel;
	private HotelDetailPanel hotelDetailInfoPanel;
	
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
		hotelDetailInfoPanel = new HotelDetailPanel(hotel,rooms,user);
		hotelCardPanel.add("hotelDetailInfo", hotelDetailInfoPanel);
		hotelCard.show(hotelCardPanel, "hotelDetailInfo");
	}

}
