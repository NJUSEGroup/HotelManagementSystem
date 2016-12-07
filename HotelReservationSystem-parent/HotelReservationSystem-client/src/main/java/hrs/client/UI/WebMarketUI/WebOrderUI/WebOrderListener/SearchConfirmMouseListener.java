package hrs.client.UI.WebMarketUI.WebOrderUI.WebOrderListener;

import java.awt.Color;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import javax.swing.JButton;

import hrs.client.UI.WebMarketUI.WebOrderUI.WebOrderPanel;
import hrs.client.util.UIConstants;

public class SearchConfirmMouseListener implements MouseListener{
	private JButton jbButton;
	WebOrderPanel webOrderPanel;
	public SearchConfirmMouseListener(WebOrderPanel webOrderPanel) {
		// TODO Auto-generated constructor stub
		this.webOrderPanel=webOrderPanel;
	}

	@Override
	public void mouseClicked(MouseEvent e) {
		// TODO Auto-generated method stub
		webOrderPanel.search();
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
		jbButton.setForeground(Color.GRAY);
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
