package hrs.client.UI.WebStaffUI.WebMarketUI.WebMarketListener;

import java.awt.Color;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import javax.swing.JButton;
import javax.swing.JOptionPane;

import hrs.client.UI.WebStaffUI.WebMarketUI.WebMarketerUIPanel;
import hrs.client.util.UIConstants;

public class jbModifyWebMarketerMouseListener implements MouseListener{
	private JButton jbButton = new JButton();
	private WebMarketerUIPanel WebMarketerUIPanel;
	public jbModifyWebMarketerMouseListener(WebMarketerUIPanel webMarketerUIPanel) {
		// TODO Auto-generated constructor stub
		this.WebMarketerUIPanel=webMarketerUIPanel;
	}
	@Override
	public void mouseClicked(MouseEvent e) {
		// TODO Auto-generated method stub
		int result = JOptionPane.showConfirmDialog(null, "是否确定修改？", "提示", JOptionPane.YES_NO_OPTION,
				JOptionPane.INFORMATION_MESSAGE);
//		System.out.println(result);
		if (result == 0) {
			WebMarketerUIPanel.modify();
			JOptionPane.showConfirmDialog(null, "信息修改成功", "修改成功", JOptionPane.PLAIN_MESSAGE,
					JOptionPane.INFORMATION_MESSAGE);
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
		jbButton.setForeground(Color.BLACK);
	}

	@Override
	public void mouseExited(MouseEvent e) {
		// TODO Auto-generated method stub
		jbButton = (JButton) e.getSource();
		// 鼠标离开标签时更换背景及字体色
		jbButton.setBackground(UIConstants.jlabel);
		jbButton.setForeground(Color.white);
	}

}
