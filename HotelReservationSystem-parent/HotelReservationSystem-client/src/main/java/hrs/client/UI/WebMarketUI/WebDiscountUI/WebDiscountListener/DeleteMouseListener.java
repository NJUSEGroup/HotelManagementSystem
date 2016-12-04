package hrs.client.UI.WebMarketUI.WebDiscountUI.WebDiscountListener;

import java.awt.Color;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import org.easymock.internal.ErrorMessage;

import android.R.color;
import hrs.client.UI.WebMarketUI.WebDiscountUI.WebDiscountPanel;

public class DeleteMouseListener implements MouseListener{
	private JButton jbButton=new JButton();
	WebDiscountPanel jpwebDiscount;
    public DeleteMouseListener(WebDiscountPanel jpWebDiscount) {
		// TODO Auto-generated constructor stub
    	this.jpwebDiscount=jpWebDiscount;
	}

	@Override
	public void mouseClicked(MouseEvent e) {
		// TODO Auto-generated method stub
		try {
			jpwebDiscount.deleteWebDiscount(jpwebDiscount.getSelected());
		} catch (NullPointerException exception) {
			// TODO: handle exception
//			JOptionPane pane=new JOptionPane();
			JOptionPane.showMessageDialog(this.jpwebDiscount, "请选中要删除的促销策略！","Error",JOptionPane.ERROR_MESSAGE);
//			pane.setBackground(hrs.client.util.constants.jlabel);
			
		
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
		 jbButton.setBackground(Color.RED);
		 jbButton.setForeground(Color.white);
	}

}
