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

public class DeleteMouseListener implements MouseListener {
	private JButton jbButton = new JButton();
	WebDiscountPanel jpwebDiscount;

	public DeleteMouseListener(WebDiscountPanel jpWebDiscount) {
		// TODO Auto-generated constructor stub
		this.jpwebDiscount = jpWebDiscount;
	}

	@Override
	public void mouseClicked(MouseEvent e) {
		// TODO Auto-generated method stub
		int result = JOptionPane.showConfirmDialog(null, "是否确定删除？", "提示", JOptionPane.YES_NO_OPTION,
				JOptionPane.INFORMATION_MESSAGE);
		if (result == 0) {
			try {
				jpwebDiscount.deleteWebDiscount(jpwebDiscount.getSelected());
				JOptionPane.showConfirmDialog(null, "促销策略删除成功", "删除成功", JOptionPane.PLAIN_MESSAGE,
						JOptionPane.INFORMATION_MESSAGE);
			} catch (NullPointerException exception) {
				// TODO: handle exception
				JOptionPane.showMessageDialog(this.jpwebDiscount, "请选中要删除的促销策略！", "Error", JOptionPane.ERROR_MESSAGE);
			}
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
		jbButton = (JButton) e.getSource();
		// 鼠标在标签上时更换背景及字体色
		jbButton.setBackground(Color.WHITE);
		jbButton.setForeground(Color.GRAY);
	}

	@Override
	public void mouseExited(MouseEvent e) {
		// TODO Auto-generated method stub
		jbButton = (JButton) e.getSource();
		// 鼠标离开标签时更换背景及字体色
		jbButton.setBackground(Color.RED);
		jbButton.setForeground(Color.white);
	}

}
