package hrs.client.UI.UserUI.HotelSearchUI.Listener;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import hrs.client.UI.UserUI.HotelSearchUI.HotelDetailPanel;
import hrs.client.UI.UserUI.HotelSearchUI.HotelPanel;

public class BackListener implements ActionListener {
	private HotelDetailPanel panel;
	public BackListener(HotelDetailPanel panel){
		this.panel = panel;
	}
	@Override
	public void actionPerformed(ActionEvent e) {
		panel.back();

	}

}
