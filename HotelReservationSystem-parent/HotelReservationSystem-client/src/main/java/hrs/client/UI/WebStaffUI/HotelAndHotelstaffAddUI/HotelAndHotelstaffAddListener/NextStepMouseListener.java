package hrs.client.UI.WebStaffUI.HotelAndHotelstaffAddUI.HotelAndHotelstaffAddListener;

import java.awt.Color;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import javax.swing.JButton;

import hrs.client.UI.WebStaffUI.WebStaffFrame;
import hrs.client.UI.WebStaffUI.HotelAndHotelstaffAddUI.HotelAddUIPanel;
import hrs.client.util.UIConstants;

public class NextStepMouseListener implements MouseListener{
	private JButton jbButton;
	private HotelAddUIPanel hotelAddUIPanel;
//	private WebStaffFrame webStaffFrame;
	public NextStepMouseListener(HotelAddUIPanel hotelAddUIPanel/*,WebStaffFrame webStaffFrame*/) {
		// TODO Auto-generated constructor stub
		this.hotelAddUIPanel=hotelAddUIPanel;
//		this.webStaffFrame=webStaffFrame;
	}
	@Override
	public void mouseClicked(MouseEvent e) {
		// TODO Auto-generated method stub
		if(hotelAddUIPanel.getHotelName()!=null){
//			webStaffFrame.showHotelStaffAddUIPanel();
			hotelAddUIPanel.showHotalStaffAddUIPanel();
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
		 jbButton.setBackground(UIConstants.jlabel);
		 jbButton.setForeground(Color.white);
	}
}
