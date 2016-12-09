package hrs.client.UI.LoginUI.LoginPanel;

import java.awt.Font;
import java.util.Locale;
import java.util.ResourceBundle;

import javax.swing.JComboBox;
import javax.swing.JPanel;
import javax.swing.JTextField;

import org.hibernate.property.access.spi.SetterFieldImpl;
import org.springframework.web.bind.annotation.InitBinder;

import hrs.client.UI.LoginUI.LoginFrame;
import hrs.client.UI.UserUI.Components.CommonLabel;
import hrs.client.util.UIConstants;

public class LoginPanel extends JPanel {

	/**
	* @Fields serialVersionUID : TODO
	*/ 
	private static final long serialVersionUID = 3290076244434286905L;
	
	Font font = UIConstants.JLABEL_FONT;
	private JComboBox<String> accountType;
	private JTextField accountField;
	private JTextField passwordField;
	
	private int JL_WIDTH = 120;
	private int JL_HEIGHT = 50;
	private int TEXT_WIDTH = 200;
	private int TEXT_HEIGHT = 30;
	private int START_X = 80;
	private int START_Y = 30;
	private LoginFrame frame;
	/**
	 * Create the panel.
	 */
	public LoginPanel(LoginFrame frame) {
		this.frame = frame;
		setSize(508,376);
		setLayout(null);
		init();
	}
	private void init() {
		setLabel();
		setInputField();
		setButton();
		
		
	}
	private void setButton() {
		
		
	}
	private void setInputField() {
		accountType = new JComboBox<>();
		accountType.setFont(font);
		accountType.addItem("用户");
		accountType.addItem("工作人员");
		accountType.setBounds(START_X+JL_WIDTH+30, START_Y+(JL_HEIGHT-TEXT_HEIGHT)/2, TEXT_WIDTH, TEXT_HEIGHT);
		add(accountType);
		
		accountField = new JTextField();
		accountField.setFont(font);
		accountField.setBounds(START_X+JL_WIDTH+30, START_Y+(JL_HEIGHT-TEXT_HEIGHT)/2+JL_HEIGHT, TEXT_WIDTH, TEXT_HEIGHT);
		add(accountField);
		
		passwordField = new JTextField();
		passwordField.setFont(font);
		passwordField.setBounds(START_X+JL_WIDTH+30, START_Y+(JL_HEIGHT-TEXT_HEIGHT)/2+JL_HEIGHT*2, TEXT_WIDTH, TEXT_HEIGHT);
		add(passwordField);
	}
	private void setLabel() {
		CommonLabel accountTypeJL = new CommonLabel("用户类型");
		accountTypeJL.setBounds(START_X, START_Y, JL_WIDTH, JL_HEIGHT);
		add(accountTypeJL);
		
		CommonLabel accountJL = new CommonLabel("用户名");
		accountJL.setBounds(START_X, START_Y+JL_HEIGHT, JL_WIDTH, JL_HEIGHT);
		add(accountJL);
		
		CommonLabel passwordJL = new CommonLabel("用户名");
		passwordJL.setBounds(START_X, START_Y+JL_HEIGHT*2, JL_WIDTH, JL_HEIGHT);
		add(passwordJL);
	}
	
	

}
