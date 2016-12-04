package hrs.client.UI.LoginUI;

import java.util.Locale;
import java.util.ResourceBundle;

public class TestInternationalization {
	ResourceBundle rb = ResourceBundle.getBundle("hotel", Locale.getDefault());
	public TestInternationalization() {
		System.out.println(rb.getString("Room.Single"));
	}
	public static void main(String[] args) {
		new TestInternationalization();
	}
}
