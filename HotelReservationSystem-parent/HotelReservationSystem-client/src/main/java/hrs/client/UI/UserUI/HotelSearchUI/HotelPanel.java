package hrs.client.UI.UserUI.HotelSearchUI;

import java.awt.CardLayout;

import javax.swing.JPanel;

import hrs.client.UI.UserUI.ComComponents.CommonPanel;
import hrs.client.util.ControllerFactory;
import hrs.common.Controller.UserController.IUserHotelController;
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
		Init();
	}
	@Override
	public void Init() {
		setCard();
		
	}
	private void setCard() {
		hotelSearchPanel = new HotelSearchPanel(user);
		hotelCardPanel.setLayout(hotelCard);
		hotelCardPanel.add("hotelSearch", hotelSearchPanel);
		hotelCardPanel.setBounds(0,0,1103,768);
		hotelCard.show(hotelCardPanel, "hotelSearch");
		
		add(hotelCardPanel);
		
	}

}
