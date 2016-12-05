package hrs.client.UI.HotelUI.OfflineRecordUI.Listener;

import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.ArrayList;
import java.util.List;

import hrs.client.UI.HotelUI.OfflineRecordUI.OfflineRecordUIPanel;
import hrs.common.VO.OfflineRecordVO;

public class SearchListener implements MouseListener{

	private OfflineRecordUIPanel jpRecord;
	
	public SearchListener(OfflineRecordUIPanel jpRecord){
		this.jpRecord = jpRecord;
	}
	
	/**
	 * 通过线下入住记录编号查询相应的线下入住记录
	 */
	@Override
	public void mouseClicked(MouseEvent e) {
		// TODO Auto-generated method stub
		
		jpRecord.recordNotSelected();
		
		int id = jpRecord.getID();
		List<OfflineRecordVO> record = new ArrayList<OfflineRecordVO>();
		record = jpRecord.searchRecordByID(id);
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
