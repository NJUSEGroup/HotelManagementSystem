package hrs.client.UI.LoginUI;

import java.awt.CardLayout;
import java.awt.EventQueue;

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

import hrs.client.UI.LoginUI.LoginPanel.LoginPanel;
import hrs.client.UI.LoginUI.RegisterPanel.RegisterPanel;
import hrs.client.util.ControllerFactory;
import hrs.client.util.ImageLoader;
import hrs.common.Controller.LoginController.ILoginController;

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
	private int HEIGHT = 476;
	private int WIDTH = 508;
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
		
		add(contentPane);
		contentPane.setBounds(0, 100, WIDTH, HEIGHT - 100);

	}

	private void setLabel() {
		LoginJL loginJL = new LoginJL(this, "登录");
		loginJL.setBounds(120,20,130,50);
		add(loginJL);
		
		RegisterJL registerJL = new RegisterJL(this, "注册");
		registerJL.setBounds(270,20,130,50);
		add(registerJL);
	}

	public void showRegister() {
		cardLayout.show(contentPane, "register");
	}

	public void showLogin() {
		cardLayout.show(contentPane, "login");
	}
}
