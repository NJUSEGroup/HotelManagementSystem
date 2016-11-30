package hrs.client.UI.UserUI;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.JLabel;

public class MyLabel extends JLabel {
	Color frameColor = new Color(0, 160, 233);
	private MyLabelListener listener = MyLabelListenerFactory.getListener();
	
	public MyLabel(String s){
		this.setFont(new Font("微软雅黑",Font.PLAIN,24));
		
		//标签固定大小
		setPreferredSize(new Dimension(260,70)); 
		
		this.setText(s);
		this.setOpaque(true);
		
		//初始背景色
		this.setBackground(frameColor);
		//初始字体色
		this.setForeground(Color.white);
		//设置文字居中
		setHorizontalAlignment(JLabel.CENTER);
		
		this.addMouseListener(listener);
	}
	
	
}