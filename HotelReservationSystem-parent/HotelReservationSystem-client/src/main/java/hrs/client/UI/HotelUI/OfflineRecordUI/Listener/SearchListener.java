package hrs.client.UI.HotelUI.OfflineRecordUI.Listener;

import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import hrs.client.UI.HotelUI.OfflineRecordUI.OfflineRecordUIPanel;
import hrs.common.VO.OfflineRecordVO;

public class SearchListener implements MouseListener{

	private OfflineRecordUIPanel jpRecord;
	
	public SearchListener(OfflineRecordUIPanel jpRecord){
		this.jpRecord = jpRecord;
	}
	
	@Override
	public void mouseClicked(MouseEvent e) {
		// TODO Auto-generated method stub
		
		OfflineRecordVO record = jpRecord.search();
		jpRecord.refresh(record);
	}

	@Override
	public void mousePressed(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseReleased(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseEntered(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseExited(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

}
