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
import hrs.client.util.UIConstants;

import javax.swing.BorderFactory;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.LayoutStyle.ComponentPlacement;

public class WebMarketFrame extends JFrame {

	private JPanel contentPane;
	private JPanel jpCard;
	private MenulistPanel jpMenulist;
	private WebOrderPanel jpWebOrder;
	private WebDiscountPanel jpWebDiscount;
	private CreditChargePanel jpCreditCharge;
	private MenulistPanelMouseListener listener;

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
		setSize(1366, 768);
		setLocationRelativeTo(null);
		setResizable(false);

		contentPane = new JPanel();
		contentPane.setBackground(UIConstants.JZONE);
		setContentPane(contentPane);

		jpCard = new JPanel();
		jpCard.setBounds(273, 5, 1080, 722);
		jpCard.setBackground(UIConstants.JFRAME);

		GroupLayout gl_contentPane = new GroupLayout(contentPane);
		gl_contentPane.setHorizontalGroup(gl_contentPane.createParallelGroup(Alignment.TRAILING)
				.addGroup(gl_contentPane.createSequentialGroup().addContainerGap(283, Short.MAX_VALUE)
						.addComponent(jpCard, GroupLayout.PREFERRED_SIZE, 1067, GroupLayout.PREFERRED_SIZE)
						.addContainerGap()));
		gl_contentPane.setVerticalGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_contentPane.createSequentialGroup().addContainerGap()
						.addComponent(jpCard, GroupLayout.PREFERRED_SIZE, 714, GroupLayout.PREFERRED_SIZE)
						.addContainerGap(16, Short.MAX_VALUE)));
		CardLayout cardLayout = new CardLayout();

		jpWebOrder = new WebOrderPanel();
		jpWebDiscount = new WebDiscountPanel();
		jpCreditCharge = new CreditChargePanel();

		jpCard.setLayout(cardLayout);
		jpCard.add(jpWebDiscount, "促销策略");
		jpCard.add(jpWebOrder, "异常订单");
		jpCard.add(jpCreditCharge, "信用充值");
		cardLayout.show(jpCard, "促销策略");

		listener = new MenulistPanelMouseListener(jpWebOrder);
		listener.setCard(cardLayout, jpCard);

		jpMenulist = new MenulistPanel();
		jpMenulist.setBounds(5, 5, 263, 722);

		contentPane.setLayout(gl_contentPane);
		contentPane.add(jpMenulist);
	}
}
