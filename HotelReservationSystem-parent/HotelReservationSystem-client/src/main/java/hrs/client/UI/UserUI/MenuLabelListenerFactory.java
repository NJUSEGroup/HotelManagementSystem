package hrs.client.UI.UserUI;

public class MenuLabelListenerFactory {
	private static MenuLabelListener listener;

	static {
		try {
			listener = new MenuLabelListener();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public static MenuLabelListener getListener() {
		return listener;
	}
}
