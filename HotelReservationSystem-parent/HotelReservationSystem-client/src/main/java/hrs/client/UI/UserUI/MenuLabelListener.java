package hrs.client.UI.UserUI;

import java.awt.CardLayout;
import java.awt.Color;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.JLabel;
import javax.swing.JPanel;

import hrs.client.util.UIConstants;

public class MenuLabelListener extends MouseAdapter {
	Color color = UIConstants.jlabel;
	private JLabel jl = new JLabel();
	private static CardLayout card ;
	private static JPanel panel ;
	
	public void mouseEntered(MouseEvent e){
		jl = (JLabel)e.getSource();
		//鼠标在标签上时更换背景及字体色
		jl.setBackground(Color.WHITE);
		jl.setForeground(Color.BLACK);
	}
	
	 public void mouseClicked(MouseEvent e){
		 jl = (JLabel)e.getSource();
		 String s = jl.getText();
		 if(s.equals("信用记录")){
			 card.show(panel, "creditInfoPanel");
			 
		 }
		 if(s.equals("订单信息")){
			 card.show(panel, "orderInfoPanel");

		 }	 
		 if(s.equals("个人信息"))
			 card.show(panel, "userInfoPanel");
		 if(s.equals("搜索酒店"))
			 card.show(panel, "hotelPanel");
		 System.out.println("已点击"+s);
	 }

	 public void mouseExited(MouseEvent e){
		 jl = (JLabel)e.getSource();
		//鼠标离开标签时更换背景及字体色
		 jl.setBackground(color);
		 jl.setForeground(Color.white);
	 } 
	 
	 public void setCard(CardLayout card,JPanel panel){
		this.card = card; 
		this.panel = panel;
	 }
}
