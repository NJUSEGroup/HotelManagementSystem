package hrs.client.UI.WebStaffUI.WebUserUI.WebUserListener;

import java.awt.Color;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import javax.swing.JButton;

import hrs.client.UI.WebStaffUI.WebUserUI.ShowUserInfoPanel;
import hrs.client.UI.WebStaffUI.WebUserUI.WebUserUIPanel;
import hrs.client.util.UIConstants;
import hrs.common.VO.UserVO;

public class SearchUserConfirmMouseListener implements MouseListener{
	private JButton jbButton=new JButton();
	private WebUserUIPanel webUserUIPanel;
//	private ShowUserInfoPanel showUserInfoPanel;
	
	public SearchUserConfirmMouseListener(WebUserUIPanel webUserUIPanel) {
		// TODO Auto-generated constructor stub
		this.webUserUIPanel=webUserUIPanel;
//		this.showUserInfoPanel=showUserInfoPanel;	    
	}
	
	@Override
	public void mouseClicked(MouseEvent e) {
		// TODO Auto-generated method stub		
		webUserUIPanel.showUserinfo();	
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
