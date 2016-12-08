package hrs.client.UI.WebStaffUI.HotelStaffUI.HotelStaffListener;

import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import javax.swing.JOptionPane;

import hrs.client.UI.WebStaffUI.HotelStaffUI.HotelStaffUIPanel;

public class ModifyHotelStaffMouseListener implements MouseListener {
	private HotelStaffUIPanel hotelStaffUIPanel;

	public ModifyHotelStaffMouseListener(HotelStaffUIPanel hotelStaffUIPanel) {
		// TODO Auto-generated constructor stub
		this.hotelStaffUIPanel = hotelStaffUIPanel;
	}

	@Override
	public void mouseClicked(MouseEvent e) {
		// TODO Auto-generated method stub
		int result = JOptionPane.showConfirmDialog(null, "是否确定修改？", "提示", JOptionPane.YES_NO_OPTION,
				JOptionPane.INFORMATION_MESSAGE);
//		System.out.println(result);
		if (result == 0) {
			hotelStaffUIPanel.modify();
			JOptionPane.showConfirmDialog(null, "信息修改成功", "修改成功", JOptionPane.PLAIN_MESSAGE,
					JOptionPane.INFORMATION_MESSAGE);
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
