package hrs.client.UI.LoginUI;

import java.util.Locale;
import java.util.ResourceBundle;

import javax.swing.JPanel;

public class LoginPanel extends JPanel {

	/**
	* @Fields serialVersionUID : TODO
	*/ 
	private static final long serialVersionUID = 3290076244434286905L;
    ResourceBundle rb = ResourceBundle.getBundle("src/main/resources", Locale.CHINA);
	/**
	 * Create the panel.
	 */
	public LoginPanel() {
		System.out.println(rb.getString("Room.Single"));
	}
	
	public static void main(String[] args) {
		LoginPanel lp = new LoginPanel();
		lp.setVisible(true);
	}

}
