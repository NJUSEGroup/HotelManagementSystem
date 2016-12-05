package hrs.client.UI.WebStaffUI.HotelAddUI.HotelAddListener;

import java.awt.Color;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import javax.swing.JButton;
import javax.swing.JOptionPane;

import hrs.client.UI.WebStaffUI.HotelAddUI.HotelStaffAddUIPanel;
import hrs.client.util.UIConstants;

public class ConfirmMouseListener implements MouseListener {
	private JButton jbButton;
	private HotelStaffAddUIPanel hotelStaffAddUIPanel;
	public ConfirmMouseListener(HotelStaffAddUIPanel hotelStaffAddUIPanel) {
		// TODO Auto-generated constructor stub
		this.hotelStaffAddUIPanel=hotelStaffAddUIPanel;
	}

	@Override
	public void mouseClicked(MouseEvent e) {
		// TODO Auto-generated method stub
//		System.out.println(hotelStaffAddUIPanel.passwordValid());
		if(hotelStaffAddUIPanel.passwordValid()==1){
			hotelStaffAddUIPanel.addHotelStaff();
//			JOptionPane.showMessageDialog(hotelStaffAddUIPanel, "添加酒店成功！");
		}else{
			JOptionPane.showMessageDialog(hotelStaffAddUIPanel, "两次密码不符，请重新输入！", "Error", JOptionPane.ERROR_MESSAGE);
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
		jbButton = (JButton)e.getSource();
		//鼠标在标签上时更换背景及字体色
		jbButton.setBackground(Color.WHITE);
		jbButton.setForeground(Color.BLACK);
	}

	@Override
	public void mouseExited(MouseEvent e) {
		// TODO Auto-generated method stub
		jbButton = (JButton)e.getSource(); 
		//鼠标离开标签时更换背景及字体色
		 jbButton.setBackground(UIConstants.JLABEL);
		 jbButton.setForeground(Color.white);
	}

}
