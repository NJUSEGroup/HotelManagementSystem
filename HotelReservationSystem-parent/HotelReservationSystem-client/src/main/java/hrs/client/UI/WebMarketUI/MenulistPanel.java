package hrs.client.UI.WebMarketUI;

import java.awt.Color;
import java.awt.Font;

import javax.swing.BorderFactory;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

import hrs.client.UI.WebMarketUI.CreditChargeUI.CreditChargePanel;
import hrs.client.UI.WebMarketUI.Listener.MenulistPanelMouseListener;
import hrs.client.util.UIConstants;

public class MenulistPanel extends JPanel{
	private JLabel jlZone;
	private JLabel jlIdentity;
	private JLabel jlUsername;
	private JLabel jlPromotion;
	private JLabel jlAbnormal;
	private JLabel jlCreditCharge;
	private MenulistPanelMouseListener jpMenulistMouseListener=new MenulistPanelMouseListener();
	private Color jlabel_color=UIConstants.JLABEL;
	private Font jlabel_font=UIConstants.JLABEL_FONT;
	
	public MenulistPanel(){
		init();
	}
	public void init(){
		setBounds(10, 11, 263, 714);
		setLayout(null);
		setBackground(new Color(211, 237, 249));
	    setBorder(BorderFactory.createLineBorder(new Color(145, 189, 214), 3));
	  
	    jlZone=new JLabel("网站营销中心",JLabel.CENTER);
	    jlZone.setBounds(3, 3, 257, 79);
		jlZone.setFont(UIConstants.JZONE_FONT);
		jlZone.setOpaque(true);
		jlZone.setForeground(UIConstants.JZONE_FONT_COLOR);
		jlZone.setBackground(UIConstants.JZONE);
		
		jlIdentity=new JLabel("网站营销人员",JLabel.CENTER);
		jlIdentity.setBounds(3, 90, 257, 29);
		jlIdentity.setFont(new Font("Arial Unicode MS", Font.PLAIN, 21));
		
		jlUsername=new JLabel("BStaff",JLabel.CENTER);
		jlUsername.setBounds(3, 119, 257, 29);
		jlUsername.setFont(new Font("Arial Unicode MS", Font.PLAIN, 21));
		
		jlPromotion=new JLabel("促销策略",JLabel.CENTER);
		jlPromotion.setBounds(3, 148, 257, 65);
		jlPromotion.setFont(jlabel_font);
		jlPromotion.setForeground(Color.WHITE);
		jlPromotion.setOpaque(true);
		jlPromotion.setBackground(jlabel_color);
		jlPromotion.addMouseListener(jpMenulistMouseListener);
		
		jlAbnormal=new JLabel("异常订单",JLabel.CENTER);
		jlAbnormal.setBounds(3, 213, 257, 65);
		jlAbnormal.setFont(jlabel_font);
		jlAbnormal.setForeground(Color.WHITE);
		jlAbnormal.setOpaque(true);
		jlAbnormal.setBackground(jlabel_color);
		jlAbnormal.addMouseListener(jpMenulistMouseListener);
		
		jlCreditCharge=new JLabel("信用充值",JLabel.CENTER);
		jlCreditCharge.setBounds(3, 278, 257, 65);
		jlCreditCharge.setFont(jlabel_font);
		jlCreditCharge.setForeground(Color.WHITE);
		jlCreditCharge.setOpaque(true);
		jlCreditCharge.setBackground(jlabel_color);
		jlCreditCharge.addMouseListener(jpMenulistMouseListener);
		
		add(jlZone);
		add(jlIdentity);
		add(jlUsername);
		add(jlPromotion);
		add(jlAbnormal);
		add(jlCreditCharge);
	}
}
