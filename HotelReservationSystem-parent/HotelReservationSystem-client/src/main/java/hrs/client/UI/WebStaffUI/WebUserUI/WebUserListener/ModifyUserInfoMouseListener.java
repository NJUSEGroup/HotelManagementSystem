package hrs.client.UI.WebStaffUI.WebUserUI.WebUserListener;

import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import javax.swing.JOptionPane;

import hrs.client.UI.WebStaffUI.WebUserUI.WebUserUIPanel;

public class ModifyUserInfoMouseListener implements MouseListener {
	private WebUserUIPanel WebUserUIPanel;

	public ModifyUserInfoMouseListener(WebUserUIPanel webUserUIPanel) {
		// TODO Auto-generated constructor stub
		this.WebUserUIPanel = webUserUIPanel;
	}

	@Override
	public void mouseClicked(MouseEvent e) {
		// TODO Auto-generated method stub
		int result = JOptionPane.showConfirmDialog(null, "是否确定修改？", "提示", JOptionPane.YES_NO_OPTION,
				JOptionPane.INFORMATION_MESSAGE);
		if (result == 0) {
			WebUserUIPanel.modify();
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
	}

	@Override
	public void mouseExited(MouseEvent e) {
		// TODO Auto-generated method stub
	}

}
