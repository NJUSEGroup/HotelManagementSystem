package hrs.client.UI.WebMarketUI.WebDiscountUI.WebDiscountListener;

import java.awt.Color;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import javax.swing.JButton;
import javax.swing.JOptionPane;

import hrs.client.UI.WebMarketUI.WebDiscountUI.WebDiscountPanel;
import hrs.client.util.UIConstants;
import hrs.common.VO.WebDiscountVO;
import hrs.common.util.type.WebsiteDiscountType;

public class OKListener implements MouseListener{
	private JButton jbButton;
	WebDiscountPanel jpWebDiscount;
	AddWebDiscountDialog jdAddWebDiscount;
//	WebDiscountVO vo;
	public OKListener(WebDiscountPanel jpWebDiscount ,AddWebDiscountDialog  jdAddWebDiscount) {
		// TODO Auto-generated constructor stub
		this.jpWebDiscount=jpWebDiscount;
		this.jdAddWebDiscount=jdAddWebDiscount;
	}

	@Override
	public void mouseClicked(MouseEvent e) {
		// TODO Auto-generated method stub
		jpWebDiscount.addWebDiscount();//从vo显示到界面上,vo????
		JOptionPane.showMessageDialog(null, "促销策略成功添加！", "Success", JOptionPane.PLAIN_MESSAGE, null);
		jdAddWebDiscount.dispose();
		jdAddWebDiscount.refresh();
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
