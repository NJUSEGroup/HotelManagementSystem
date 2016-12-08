package hrs.client.UI.WebMarketUI.WebDiscountUI.WebDiscountListener;

import java.awt.Color;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import javax.swing.JButton;

import hrs.client.UI.WebMarketUI.WebDiscountUI.WebDiscountPanel;
import hrs.client.util.UIConstants;

public class AddMouseListener implements MouseListener{
	private JButton jbButton=new JButton();
	WebDiscountPanel jpWebDiscount;
//	AddWebDiscountDialog jdAddWebDiscount;
	public AddMouseListener(WebDiscountPanel jpWebDiscount) {
		this.jpWebDiscount = jpWebDiscount;
	}

	@Override
	public void mouseClicked(MouseEvent e) {
		jpWebDiscount.showAddDialog();
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
