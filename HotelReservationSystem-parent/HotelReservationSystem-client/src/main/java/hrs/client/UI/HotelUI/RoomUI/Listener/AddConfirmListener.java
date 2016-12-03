package hrs.client.UI.HotelUI.RoomUI.Listener;

import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import hrs.client.UI.HotelUI.Components.AddRoomDialog;
import hrs.common.Exception.RoomService.RoomNotFoundException;

public class AddConfirmListener implements MouseListener{

	private AddRoomDialog addRoomDialog;
	
	public AddConfirmListener(AddRoomDialog addRoomDialog){
		this.addRoomDialog = addRoomDialog;
	}
	
	@Override
	public void mouseClicked(MouseEvent e) {
		// TODO Auto-generated method stub
		
		try {
			addRoomDialog.addConfirm();
		} catch (RoomNotFoundException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
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
