package hrs.client.UI.LoginUI;

import java.awt.CardLayout;
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

import hrs.client.UI.LoginUI.LoginPanel.BGPanel;
import hrs.client.UI.LoginUI.LoginPanel.LoginPanel;
import hrs.client.UI.LoginUI.RegisterPanel.RegisterPanel;
import hrs.client.UI.UserUI.UserFrame;
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
	private JLabel jlTest;
	private ImageLoader img = ImageLoader.getInstance();
	private ILoginController loginController = ControllerFactory.getLoginController();
	private int HEIGHT = 536;
	private int WIDTH = 1100;
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
		
		init();

	}

	private void init() {
		setSize(WIDTH, HEIGHT);
		setTitle("登录");
		setLayout(null);
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
		
		
		contentPane.setBounds(530, 100, 508, HEIGHT - 180);
	
		backGroundPanel = new BGPanel();
		backGroundPanel.setOpaque(false);
		backGroundPanel.add(contentPane);
		backGroundPanel.setLayout(null);
		add(backGroundPanel);
		backGroundPanel.setBounds(0, 0, WIDTH, HEIGHT);
		

	}

	private void setLabel() {
		JPanel buttonPanel = new JPanel();
		buttonPanel.setLayout(null);
		buttonPanel.setBackground(UIConstants.JFRAME);
		buttonPanel.setBounds(530, 30, 508, 70);
		backGroundPanel.add(buttonPanel);
		
		LoginJL loginJL = new LoginJL(this, "登录");
		loginJL.setBounds(120,10,130,50);
		buttonPanel.add(loginJL);
		
		RegisterJL registerJL = new RegisterJL(this, "注册");
		registerJL.setBounds(270,10,130,50);
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
		this.dispose();
		
	}

	public void loginStaff(StaffVO staffVO) {
		StaffType type = staffVO.type;
		switch (type) {
		case HotelStaff:
			System.out.println("酒店工作人员");break;
		case WebsiteAdminister:
			System.out.println("网站管理人员");break;
		case WebsiteMarketer:
			System.out.println("网站营销人员");break;
		default:
			break;
		}
		
	}
}
