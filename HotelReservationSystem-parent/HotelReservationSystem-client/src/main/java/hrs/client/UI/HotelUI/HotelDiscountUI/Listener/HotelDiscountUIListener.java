package hrs.client.UI.HotelUI.HotelDiscountUI.Listener;


import java.awt.CardLayout;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import javax.swing.JPanel;

public class HotelDiscountUIListener implements MouseListener{
	CardLayout card;
	JPanel cardPane;
	
	public HotelDiscountUIListener(CardLayout card, JPanel cardPane){
		this.card = card;
		this.cardPane = cardPane;
	}
	@Override
	public void mouseClicked(MouseEvent e) {
		// TODO Auto-generated method stub
		card.show(cardPane,"4");
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