package hrs.client.UI.LoginUI;



public class RegisterJL extends LoginJL {
	public RegisterJL(LoginFrame frame, String s) {
		super(frame, s);
		init();
		
	}

	@Override
	protected void addListener() {
		addMouseListener(new RegisterLabelListener(frame));
	}
	
	

}
