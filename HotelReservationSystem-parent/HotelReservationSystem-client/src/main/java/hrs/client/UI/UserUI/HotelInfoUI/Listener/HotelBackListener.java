package hrs.client.UI.UserUI.HotelInfoUI.Listener;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import hrs.client.UI.UserUI.Components.ComHotelDetail;
import hrs.client.UI.UserUI.HotelInfoUI.DetailPanel;

public class HotelBackListener implements ActionListener {
	private ComHotelDetail panel;
	public HotelBackListener(ComHotelDetail panel){
		this.panel = panel;
	}
	
	@Override
	public void actionPerformed(ActionEvent e) {
		panel.back();

	}

}
