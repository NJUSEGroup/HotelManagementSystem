package hrs.client.UI.WebMarketUI.WebOrderUI.WebOrderListener;

import java.awt.Color;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import javax.persistence.criteria.CriteriaBuilder.Case;
import javax.swing.JButton;
import javax.swing.JOptionPane;

import hrs.client.UI.WebMarketUI.WebOrderUI.WebOrderPanel;
import hrs.client.util.UIConstants;

public class RevokeMouseListener implements MouseListener{
	private JButton jbButton;
	WebOrderPanel webOrderPanel;
    public RevokeMouseListener(WebOrderPanel webOrderPanel) {
		// TODO Auto-generated constructor stub
    	this.webOrderPanel=webOrderPanel;
	}

	@Override
	public void mouseClicked(MouseEvent e) {
		// TODO Auto-generated method stub
		
//		System.out.println(result);
		try {
			Object []options={"一半","全部"};
		int result=JOptionPane.showOptionDialog(webOrderPanel, "请选择要恢复的信用值", "Restore Credit", JOptionPane.YES_NO_OPTION,JOptionPane.INFORMATION_MESSAGE, null, options,options[0]);
			switch(result){
			case 0:
				webOrderPanel.revokeHalf(webOrderPanel.getSelected());
			    break;
			case 1:
				webOrderPanel.revokeFull(webOrderPanel.getSelected());
				break;				
			}
		} catch (NullPointerException e2) {
			// TODO: handle exception
			JOptionPane.showMessageDialog(this.webOrderPanel, "请选中要撤销的异常订单！","Error",JOptionPane.ERROR_MESSAGE);
		}
		}
//		if(result==1){
//			try {
//				webOrderPanel.revokeFull(webOrderPanel.getSelected());
//			} catch (NullPointerException e2) {
//				// TODO: handle exception
//				JOptionPane.showMessageDialog(this.webOrderPanel, "请选中要撤销的异常订单！","Error",JOptionPane.ERROR_MESSAGE);
//			}
//		}

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
		jbButton.setBackground(UIConstants.JLABEL);
		 jbButton.setForeground(Color.white);
	}

}
