package hrs.client.UI.LoginUI;

import java.awt.CardLayout;
import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Graphics;
import java.awt.Panel;

import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;
import javax.swing.border.EmptyBorder;

import org.aspectj.lang.reflect.InitializerSignature;
import org.springframework.web.bind.annotation.InitBinder;

import hrs.client.UI.HotelUI.HotelFrame.HotelFrame;
import hrs.client.UI.LoginUI.LoginPanel.BGPanel;
import hrs.client.UI.LoginUI.LoginPanel.LoginPanel;
import hrs.client.UI.LoginUI.RegisterPanel.RegisterPanel;
import hrs.client.UI.UserUI.UserFrame;
import hrs.client.UI.WebMarketUI.WebMarketFrame;
import hrs.client.UI.WebStaffUI.WebStaffFrame;
import hrs.client.UI.WebStaffUI.WebMarketUI.WebMarketerUIPanel;
import hrs.client.util.ControllerFactory;
import hrs.client.util.ImageLoader;
import hrs.client.util.UIConstants;
import hrs.common.Controller.LoginController.ILoginController;
import hrs.common.VO.StaffVO;
import hrs.common.VO.UserVO;
import hrs.common.util.type.StaffType;

public class LoginFrame extends JFrame {

	/**
	 * @Fields serialVersionUID : TODO
	 */
	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private LoginPanel loginPanel;
	private RegisterPanel registerPanel;
	private int HEIGHT = 506;
	private int WIDTH = 1300;
	private int PANEL_W = 420;
	private int PANEL_X = WIDTH - PANEL_W - 70;
	private BGPanel backGroundPanel;
	private CardLayout cardLayout;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					LoginFrame frame = new LoginFrame();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 * 
	 * @throws UnsupportedLookAndFeelException
	 * @throws IllegalAccessException
	 * @throws InstantiationException
	 * @throws ClassNotFoundException
	 */
	public LoginFrame() throws ClassNotFoundException, InstantiationException, IllegalAccessException,
			UnsupportedLookAndFeelException {
		setSize(WIDTH, HEIGHT);
		backGroundPanel = new BGPanel();
		
		getContentPane().add(backGroundPanel);
		backGroundPanel.setOpaque(true);
		backGroundPanel.setLayout(null);
		init();

	}

	
	private void init() {
		
		setTitle("登录");
		setLocationRelativeTo(null);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setResizable(false);

		setPanel();
		setLabel();

	}

	private void setPanel() {
		cardLayout = new CardLayout();
		contentPane = new JPanel();
		contentPane.setLayout(cardLayout);

		loginPanel = new LoginPanel(this);
		registerPanel = new RegisterPanel(this);
		contentPane.add("login", loginPanel);
		contentPane.add("register", registerPanel);
		cardLayout.show(contentPane, "login");
		
		
		contentPane.setBounds(PANEL_X, 100, PANEL_W, HEIGHT - 170);
	
		backGroundPanel.add(contentPane);
		

		

	}

	private void setLabel() {
		JPanel buttonPanel = new JPanel();
		buttonPanel.setLayout(null);
		buttonPanel.setBackground(Color.white);
		buttonPanel.setBounds(PANEL_X, 40, PANEL_W, 60);
		backGroundPanel.add(buttonPanel);
		
		LoginJL loginJL = new LoginJL(this, "登录");
		loginJL.setBounds(70,10,130,40);
		buttonPanel.add(loginJL);
		
		RegisterJL registerJL = new RegisterJL(this, "注册");
		registerJL.setBounds(210,10,130,40);
		buttonPanel.add(registerJL);
	}

	public void showRegister() {
		cardLayout.show(contentPane, "register");
	}

	public void showLogin() {
		cardLayout.show(contentPane, "login");
	}

	

	public void loginUser(UserVO userVO) {
		UserFrame userFrame = new UserFrame(userVO);
		userFrame.setVisible(true);
		this.dispose();
		
	}

	public void loginStaff(StaffVO staffVO) {
		StaffType type = staffVO.type;
		switch (type) {
		case HotelStaff:
//			HotelFrame hotelFrame = new HotelFrame(staffVO);
//			hotelFrame.setVisible(true);
//			this.dispose();
			break;
		case WebsiteAdminister:
			WebStaffFrame  webStaffFrame= new WebStaffFrame(staffVO);
			webStaffFrame.setVisible(true);
			this.dispose();break;
		case WebsiteMarketer:
			WebMarketFrame webMarketFrame = new WebMarketFrame(staffVO);
			webMarketFrame.setVisible(true);
			this.dispose();break;
		default:
			break;
		}
		
	}
}
