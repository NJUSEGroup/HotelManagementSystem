package hrs.client.UI.UserUI;

import java.awt.CardLayout;
import java.awt.Color;

import javax.swing.JFrame;
import javax.swing.JPanel;

import hrs.client.UI.UserUI.CreditInfoUI.CreditInfoPanel;
import hrs.client.UI.UserUI.HotelInfoUI.HotelInfoPanel;
import hrs.client.UI.UserUI.HotelSearchUI.HotelPanel;
import hrs.client.UI.UserUI.OrderInfoUI.OrderInfoPanel;
import hrs.client.UI.UserUI.UserInfoUI.UserInfoPanel;
import hrs.client.util.ControllerFactory;
import hrs.common.Controller.UserController.IUserController;
import hrs.common.Exception.UserService.UserNotFoundException;
import hrs.common.VO.UserVO;

public class MainFrame extends JFrame{
	/**
	 * 
	 */
	private static final long serialVersionUID = 2942323300288708231L;
	Color frameColor = new Color(211, 237, 249);
	private int height, width;
	private JPanel leftPanel = new LeftPanel();
	
	private JPanel userInfoPanel ;
	private JPanel creditInfoPanel;
	private JPanel orderInfoPanel;
	private JPanel hotelPanel;
	private JPanel hotelInfoPanel;
	
	JPanel cardPanel = new JPanel();
	
	private UserVO userVO;
	private String username;
	
	public MainFrame(UserVO userVO){
		this.username = userVO.username;
		userInfoPanel = new UserInfoPanel(username);
		creditInfoPanel = new CreditInfoPanel(username);
		orderInfoPanel = new OrderInfoPanel(userVO);
		hotelPanel = new HotelPanel(userVO);
		hotelInfoPanel = new HotelInfoPanel(userVO);
		//初始化操作
		Init();
		
		
		
		CardLayout card=new CardLayout();
		cardPanel.setLayout(card);
		cardPanel.setBounds(263,0,1103,768);
		cardPanel.add("userInfoPanel",userInfoPanel);
		cardPanel.add("creditInfoPanel",creditInfoPanel);
		cardPanel.add("orderInfoPanel",orderInfoPanel);
		cardPanel.add("hotelPanel",hotelPanel);
		cardPanel.add("hotelInfoPanel", hotelInfoPanel);
		card.show(cardPanel, "hotelPanel");
	
		
		MenuLabelListenerFactory.getListener().setCard(card,cardPanel);
		
		//设置左侧面板
		this.add(leftPanel);
		

		this.add(cardPanel);
//		this.add(userInfoPanel);
		
	}
	
	public static void main(String[] args){
		IUserController controller = ControllerFactory.getUserController();
		UserVO vo;
		try {
			vo = controller.findUserByUsername("admin");
			new MainFrame(vo);
		} catch (UserNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	private void Init() {
		height = 768;
		width = 1366;
		this.setSize(width,height);
		this.setLocationRelativeTo(null);
		this.setTitle("酒店预订系统");
		this.setVisible(true);
		this.setDefaultCloseOperation(EXIT_ON_CLOSE);
		//设置背景色
		this.getContentPane().setBackground(frameColor);
		//空布局
		this.setLayout(null);
		
		
		this.setDefaultCloseOperation(EXIT_ON_CLOSE);
		this.setResizable(false);
		
	}
}
