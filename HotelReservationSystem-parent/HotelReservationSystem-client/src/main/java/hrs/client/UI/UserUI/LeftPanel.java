package hrs.client.UI.UserUI;

import java.awt.BorderLayout;
import java.awt.CardLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;

import javax.swing.BorderFactory;
import javax.swing.JLabel;
import javax.swing.JPanel;

import hrs.common.util.constants;

public class LeftPanel extends JPanel {
	Font font = constants.jlabelChinese;
	Color color = new Color(83, 83, 214);
	JPanel menuJP = new MenuPanel();
	
	JLabel infoLabel = new JLabel("个人中心",JLabel.CENTER);
	
	JPanel userPanel = new JPanel();
	
	JLabel userJL = new JLabel();
	JLabel nameJL = new JLabel();
	
	private final int LABEL_WIDTH = 260;
	private final int LABEL_HEIGHT = 40;
	
	
	public LeftPanel(){
		setLayout(null);
		//宽203，高768
		setBounds(0,0,263,768);
		//边界框
		setBorder(BorderFactory.createLineBorder(new Color(145, 189, 214),3));
		//放置菜单面板；置于(0,140)处
		add(menuJP);
		
		labelInit();
		
		userPanelInit();
		
		add(infoLabel);
		add(userPanel);
	}
	
	
	private void userPanelInit() {
		// TODO Auto-generated method stub
		userPanel.setLayout(null);
		userPanel.add(userJL);
		userPanel.add(nameJL);
		userPanel.setBackground(new Color(211, 237, 249));
		//宽260，高100；置于(0,40)处
		userPanel.setBounds(0, 40, 260, 100);
	}


	private void labelInit() {
		//个人信息标签
		infoLabel.setFont(font);
		infoLabel.setForeground(Color.BLACK);
		infoLabel.setPreferredSize(new Dimension(260,40)); 
		infoLabel.setOpaque(true);
		infoLabel.setBackground(new Color(145, 179, 179));
		infoLabel.setBounds(0,0,LABEL_WIDTH,LABEL_HEIGHT);
		
		//用户标签；置于userPanel (20,10)处
		userJL.setFont(font);
		userJL.setPreferredSize(new Dimension(LABEL_WIDTH,30)); 
		userJL.setText("用户");
		userJL.setBounds(20,10,LABEL_WIDTH,30);
//		userJL.setOpaque(true);
		
		//用户昵称标签；置于userPanel(20,50)处
		nameJL.setFont(font);
		nameJL.setPreferredSize(new Dimension(260,30)); 
		nameJL.setText("NewSong");
		nameJL.setBounds(20,50,LABEL_WIDTH,30);
//		nameJL.setOpaque(true);
		
		
		
		
	}
	
	
	
}
