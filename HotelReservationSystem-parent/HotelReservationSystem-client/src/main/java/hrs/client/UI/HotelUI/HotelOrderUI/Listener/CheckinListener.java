package hrs.client.UI.HotelUI.HotelOrderUI.Listener;

import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import javax.swing.JOptionPane;

import hrs.client.UI.HotelUI.HotelOrderUI.HotelOrderUIPanel;
import hrs.common.VO.OrderVO;
import hrs.common.util.type.OrderStatus;

public class CheckinListener implements MouseListener{

	private HotelOrderUIPanel jpHotelOrder;
	
	public CheckinListener(HotelOrderUIPanel jpHotelOrder){
		this.jpHotelOrder = jpHotelOrder;
	}
	
	@Override
	public void mouseClicked(MouseEvent e) {
		// TODO Auto-generated method stub
		if(jpHotelOrder.isButtonEnable("入住")){
			int row = jpHotelOrder.getSelectedRow();
			OrderVO order = jpHotelOrder.getSelectedOrder(row);
			jpHotelOrder.checkin(order);
			jpHotelOrder.refreshOrderList(jpHotelOrder.getAllOrders());
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
