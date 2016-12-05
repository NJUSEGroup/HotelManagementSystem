package hrs.client.UI.UserUI.HotelSearchUI.Listener;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import hrs.client.UI.UserUI.HotelSearchUI.HotelSearchPanel;

public class detailListener implements ActionListener {
	private HotelSearchPanel panel;
	public detailListener(HotelSearchPanel panel) {
		this.panel = panel;
	}
	@Override
	public void actionPerformed(ActionEvent e) {
		panel.showDetail();

	}

}
