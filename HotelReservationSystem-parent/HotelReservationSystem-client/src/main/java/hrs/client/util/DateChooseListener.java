package hrs.client.util;

import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;

public class DateChooseListener implements ItemListener {
	private DateChoosePanel panel;
	public DateChooseListener(DateChoosePanel panel){
		this.panel = panel;
	}
	@Override
	public void itemStateChanged(ItemEvent e) {
		if(e.getStateChange()== ItemEvent.SELECTED){
			panel.change();
		}

	}

}
