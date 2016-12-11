package hrs.client.UI.HotelUI.OfflineRecordUI.Listener;

import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.ArrayList;
import java.util.List;

import hrs.client.UI.HotelUI.OfflineRecordUI.OfflineRecordUIPanel;
import hrs.common.VO.OfflineRecordVO;

public class CheckoutListener implements MouseListener{

	private OfflineRecordUIPanel jpRecord;
	
	public CheckoutListener(OfflineRecordUIPanel jpRecord){
		this.jpRecord = jpRecord;
	}
	
	/**
	 * 执行退房操作
	 */
	@Override
	public void mouseClicked(MouseEvent e) {
		// TODO Auto-generated method stub
		if(jpRecord.isCheckoutEnable()){
			OfflineRecordVO record = new OfflineRecordVO();
			List<OfflineRecordVO> newRecord = new ArrayList<OfflineRecordVO>();
			record = jpRecord.getSelectedRecord();
			jpRecord.checkout(record);
			record = jpRecord.getSelectedRecord();
			newRecord.add(record);
			jpRecord.refreshRecordList(newRecord);
		}
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
