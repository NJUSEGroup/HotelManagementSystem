package hrs.client.UI.WebMarketUI;

import java.awt.Color;
import java.awt.Font;

import javax.swing.BorderFactory;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

import hrs.client.UI.WebMarketUI.CreditChargeUI.CreditChargePanel;

public class MenulistPanel extends JPanel{
	private JLabel jlZone=new JLabel("网站营销中心",JLabel.CENTER);
	private JLabel jlIdentity=new JLabel("网站营销人员",JLabel.CENTER);
	private JLabel jlUsername=new JLabel("BStaff",JLabel.CENTER);
	private JLabel jlPromotion=new JLabel("促销策略",JLabel.CENTER);
	private JLabel jlAbnormal=new JLabel("异常订单",JLabel.CENTER);
	private JLabel jlCreditCharge=new JLabel("信用充值",JLabel.CENTER);
	hrs.client.UI.WebMarketUI.Listener.MenulistPanelMouseListener jpMenulistMouseListener=new hrs.client.UI.WebMarketUI.Listener.MenulistPanelMouseListener();
	
	public MenulistPanel(){
		setBounds(10, 11, 263, 714);
		setLayout(null);
		setBackground(new Color(211, 237, 249));
	    setBorder(BorderFactory.createLineBorder(new Color(145, 189, 214), 3));
	  
	    jlZone.setBounds(3, 3, 257, 79);
		jlZone.setFont(new Font("Arial Unicode MS", Font.PLAIN, 25));
		jlZone.setOpaque(true);
		jlZone.setBackground(new Color(145, 179, 179));
		
		jlIdentity.setBounds(3, 90, 257, 29);
		jlIdentity.setFont(new Font("Arial Unicode MS", Font.PLAIN, 21));
		
		jlUsername.setBounds(3, 119, 257, 29);
		jlUsername.setFont(new Font("Arial Unicode MS", Font.PLAIN, 21));
		
		jlPromotion.setBounds(3, 148, 257, 65);
		jlPromotion.setFont(new Font("Arial Unicode MS", Font.PLAIN, 21));
		jlPromotion.setForeground(Color.WHITE);
		jlPromotion.setOpaque(true);
		jlPromotion.setBackground(new Color(0, 160, 233));
		jlPromotion.addMouseListener(jpMenulistMouseListener);
		
		jlAbnormal.setBounds(3, 213, 257, 65);
		jlAbnormal.setFont(new Font("Arial Unicode MS", Font.PLAIN, 21));
		jlAbnormal.setForeground(Color.WHITE);
		jlAbnormal.setOpaque(true);
		jlAbnormal.setBackground(new Color(0, 160, 233));
		jlAbnormal.addMouseListener(jpMenulistMouseListener);
		
		jlCreditCharge.setBounds(3, 278, 257, 65);
		jlCreditCharge.setFont(new Font("Arial Unicode MS", Font.PLAIN, 21));
		jlCreditCharge.setForeground(Color.WHITE);
		jlCreditCharge.setOpaque(true);
		jlCreditCharge.setBackground(new Color(0, 160, 233));
		jlCreditCharge.addMouseListener(jpMenulistMouseListener);
		
		add(jlZone);
		add(jlIdentity);
		add(jlUsername);
		add(jlPromotion);
		add(jlAbnormal);
		add(jlCreditCharge);
	}
}
