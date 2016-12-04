package hrs.client.UI.WebMarketUI.WebDiscountUI.WebDiscountListener;

import java.awt.Color;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import javax.swing.JButton;

import hrs.client.UI.WebMarketUI.WebDiscountUI.WebDiscountPanel;

public class CancelAddListener implements MouseListener{
	private JButton jbButton=new JButton();
	AddWebDiscountDialog jdAddWebDiscount;
	public CancelAddListener(AddWebDiscountDialog jdAddWebDiscount) {
		// TODO Auto-generated constructor stub
		this.jdAddWebDiscount=jdAddWebDiscount;
	}
		


	@Override
	public void mouseClicked(MouseEvent e) {
		// TODO Auto-generated method stub
//		jdAddWebDiscount.clear();
		jdAddWebDiscount.dispose();
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
		 jbButton.setBackground(Color.RED);
		 jbButton.setForeground(Color.white);
	}

}
