package hrs.client.UI.WebMarketUI.WebDiscountUI.WebDiscountListener;

import java.awt.Color;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import javax.swing.JButton;

import hrs.client.UI.WebMarketUI.WebDiscountUI.WebDiscountPanel;
import hrs.client.util.UIConstants;

public class ModifyMouseListener implements MouseListener{
	private JButton jbButton;
	private WebDiscountPanel webDiscountPanel;
	public ModifyMouseListener(WebDiscountPanel webDiscountPanel) {
		// TODO Auto-generated constructor stub
		this.webDiscountPanel=webDiscountPanel;
	}
	@Override
	public void mouseClicked(MouseEvent e) {
		// TODO Auto-generated method stub
		webDiscountPanel.showModifyDialog();
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
