package hrs.client.UI.WebStaffUI.WebStaffListener;

import java.awt.CardLayout;
import java.awt.Color;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import javax.swing.JLabel;
import javax.swing.JPanel;

import android.R.string;
import hrs.client.UI.WebStaffUI.MenulistPanel;

public class WebStaffMenulistMouseListener implements MouseListener{
	private JLabel jLabel;
	private JLabel jlUserInfo;
	private MenulistPanel menulistPanel;
	private static CardLayout cardLayout;
	private static JPanel jPanel;
	public void setCard(CardLayout cardLayout,JPanel jPanel){
		this.cardLayout=cardLayout;
		this.jPanel=jPanel;
	}
	
//	public WebStaffMenulistMouseListener(MenulistPanel menulistPanel) {
//		// TODO Auto-generated constructor stub
//		this.menulistPanel=menulistPanel;
//	}
	@Override
	public void mouseClicked(MouseEvent e) {
		// TODO Auto-generated method stub
		jLabel=(JLabel)e.getSource();
		String string=jLabel.getText();
		if(string.equals("•用户              ")){
//			System.out.println("wowowowowowo");
			cardLayout.show(jPanel, "用户");
		}else if(string.equals("•酒店工作人员")){
			cardLayout.show(jPanel, "酒店工作人员");
		}else if(string.equals("•网站营销人员")){
			cardLayout.show(jPanel, "网站营销人员");
		}else if(string.equals("酒店信息添加")){
			cardLayout.show(jPanel, "酒店添加");
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
//	public void mouseEnteredDouble(MouseEvent me){
//
//		this.jlUserInfo=menulistPanel.jlUserInfo();
//		jLabel=(JLabel)me.getSource();
//		String string=jLabel.getText();
//		if(string.equals("•用户              ")||string.equals("•酒店工作人员")||string.equals("•网站营销人员")){
//			jlUserInfo.setBackground(Color.WHITE);
//			jlUserInfo.setForeground(Color.BLACK);
//			jLabel.setForeground(new Color(145, 179, 179));
//			}
//	}
//	
//	public void mouseExitedDouble(MouseEvent me){
//		this.jlUserInfo=menulistPanel.jlUserInfo();
//		jLabel=(JLabel)me.getSource();
//		String string=jLabel.getText();
//		if(string.equals("•用户              ")||string.equals("•酒店工作人员")||string.equals("•网站营销人员")){
//			jlUserInfo.setBackground(new Color(0, 160, 233));
//			jlUserInfo.setForeground(Color.white);
//			jLabel.setForeground(Color.BLACK);
//			}
//	}

	public void mouseEntered(MouseEvent me){
		jLabel=(JLabel)me.getSource();
		String string=jLabel.getText();
		if(string.equals("酒店信息添加")){
		jLabel.setBackground(Color.WHITE);
		jLabel.setForeground(Color.GRAY);
		}
	}

	 public void mouseExited(MouseEvent e){
		 jLabel = (JLabel)e.getSource();
		 String string=jLabel.getText();
			if(string.equals("酒店信息添加")){
		 jLabel.setBackground(new Color(0, 160, 233));
		 jLabel.setForeground(Color.white);
			}
	 } 
	

}
