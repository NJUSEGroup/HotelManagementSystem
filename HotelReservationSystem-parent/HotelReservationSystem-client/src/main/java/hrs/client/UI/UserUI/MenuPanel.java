package hrs.client.UI.UserUI;

import java.awt.CardLayout;
import java.awt.Color;

import javax.swing.BorderFactory;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class MenuPanel extends JPanel {
	private JLabel searchJLabel = new MenuLabel("搜索酒店");
	private JLabel infoJLabel = new MenuLabel("个人信息");
	private JLabel orderJLabel = new MenuLabel("订单信息");
	private JLabel hotelJLabel = new MenuLabel("酒店信息");
	private JLabel creditJLabel = new MenuLabel("信用记录");
	
	private final int LABEL_WIDTH = 260;
	private final int LABEL_HEIGHT = 70;
	
	private MenuLabelListener listener= MenuLabelListenerFactory.getListener();
	public MenuPanel(){
		setBounds(0, 140, 260, 628);
//		jp.setBackground(frameColor);
		setLayout(null);
		setBackground(new Color(211, 237, 249));
		
		searchJLabel.setBounds(0,0,LABEL_WIDTH,LABEL_HEIGHT);
		infoJLabel.setBounds(0,LABEL_HEIGHT,LABEL_WIDTH,LABEL_HEIGHT);
		orderJLabel.setBounds(0,2*LABEL_HEIGHT,LABEL_WIDTH,LABEL_HEIGHT);
		hotelJLabel.setBounds(0,3*LABEL_HEIGHT,LABEL_WIDTH,LABEL_HEIGHT);
		creditJLabel.setBounds(0,4*LABEL_HEIGHT,LABEL_WIDTH,LABEL_HEIGHT);
		
		
		
		add(searchJLabel);
		add(infoJLabel);
		add(orderJLabel);
		add(hotelJLabel);
		add(creditJLabel);
	}
	
	
}
