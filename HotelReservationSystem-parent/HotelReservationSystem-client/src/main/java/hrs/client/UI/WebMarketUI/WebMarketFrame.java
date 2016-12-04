package hrs.client.UI.WebMarketUI;

import java.awt.BorderLayout;
import java.awt.CardLayout;
import java.awt.Color;
import java.awt.Component;
import java.awt.EventQueue;
import java.awt.Graphics;
import java.awt.Insets;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.Border;
import javax.swing.border.EmptyBorder;

import hrs.client.UI.WebMarketUI.CreditChargeUI.CreditChargePanel;
import hrs.client.UI.WebMarketUI.Listener.MenulistPanelMouseListener;
import hrs.client.UI.WebMarketUI.WebDiscountUI.WebDiscountPanel;
import hrs.client.UI.WebMarketUI.WebOrderUI.WebOrderPanel;

import javax.swing.BorderFactory;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.LayoutStyle.ComponentPlacement;

public class WebMarketFrame extends JFrame {

	private JPanel contentPane;
    MenulistPanel jpMenulist;
    MenulistPanelMouseListener listener=new MenulistPanelMouseListener();
    WebDiscountPanel jpWebDiscount=new WebDiscountPanel();
    CreditChargePanel jpCreditCharge=new CreditChargePanel();
    WebOrderPanel jpWebOrder=new WebOrderPanel();
    
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					WebMarketFrame frame = new WebMarketFrame();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}
	

	/**
	 * Create the frame.
	 */
	public WebMarketFrame() {

		setTitle("酒店管理系统");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setSize(1366,768);
		setLocationRelativeTo(null);
		setResizable(false);
		
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setBackground(new Color(211, 237, 249));
		setContentPane(contentPane);
		
		JPanel jpCard = new JPanel();
		jpCard.setBackground(new Color(211, 237, 249));
		jpCard.setBorder(BorderFactory.createLineBorder(new Color(145, 189, 214), 3));

		GroupLayout gl_contentPane = new GroupLayout(contentPane);
		gl_contentPane.setHorizontalGroup(
			gl_contentPane.createParallelGroup(Alignment.TRAILING)
				.addGroup(gl_contentPane.createSequentialGroup()
					.addContainerGap(283, Short.MAX_VALUE)
					.addComponent(jpCard, GroupLayout.PREFERRED_SIZE, 1067, GroupLayout.PREFERRED_SIZE)
					.addContainerGap())
		);
		gl_contentPane.setVerticalGroup(
			gl_contentPane.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_contentPane.createSequentialGroup()
					.addContainerGap()
					.addComponent(jpCard, GroupLayout.PREFERRED_SIZE, 714, GroupLayout.PREFERRED_SIZE)
					.addContainerGap(16, Short.MAX_VALUE))
		);
		CardLayout cardLayout=new CardLayout();
		
		jpCard.setLayout(cardLayout);
		jpCard.add( jpWebDiscount,"促销策略");
		jpCard.add( jpWebOrder,"异常订单");
		jpCard.add( jpCreditCharge,"信用充值");
		cardLayout.show(jpCard, "促销策略");
		
		listener.setCard(cardLayout,jpCard);
		
		jpMenulist=new MenulistPanel();
		
		contentPane.setLayout(gl_contentPane);
		contentPane.add(jpMenulist);
	}
}
