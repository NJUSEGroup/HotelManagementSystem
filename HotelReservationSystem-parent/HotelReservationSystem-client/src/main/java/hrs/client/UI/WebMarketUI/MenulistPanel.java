package hrs.client.UI.WebMarketUI;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import javax.swing.JLabel;
import javax.swing.JPanel;

import hrs.client.UI.WebMarketUI.Listener.MenulistPanelMouseListener;
import hrs.client.UI.WebMarketUI.WebOrderUI.WebOrderPanel;
import hrs.client.util.UIConstants;

public class MenulistPanel extends JPanel {
	/**
	 * 
	 */
	private static final long serialVersionUID = -617125775570164635L;
	private JLabel jlZone;
	private JLabel jlIdentity;
	private JLabel jlUsername;
	private JLabel jlPromotion;
	private JLabel jlAbnormal;
	private JLabel jlCreditCharge;
	private WebOrderPanel webOrderPanel;
	private MenulistPanelMouseListener jpMenulistMouseListener;
	private Color jlabel_color = UIConstants.JLABEL;
	private Font jlabel_font = UIConstants.JLABEL_FONT;

	public MenulistPanel(WebOrderPanel webOrderPanel) {
		this.webOrderPanel=webOrderPanel;
		init();
	}

	public void init() {
		setBounds(5, 5, 263, 722);
		setLayout(null);
		setBackground(UIConstants.JFRAME);

		jlZone = new JLabel("网站营销中心", JLabel.CENTER);
		jlZone.setBounds(0, 0, 263, 79);
		jlZone.setFont(UIConstants.JZONE_FONT);
		jlZone.setOpaque(true);
		jlZone.setForeground(UIConstants.JZONE_FONT_COLOR);
		jlZone.setBackground(UIConstants.JZONE);

		jlIdentity = new JLabel("网站营销人员", JLabel.CENTER);
		jlIdentity.setBounds(0, 79, 263, 29);
		jlIdentity.setFont(UIConstants.JLABEL_FONT);

		jlUsername = new JLabel("BStaff", JLabel.CENTER);
		jlUsername.setBounds(0, 108, 263, 29);
		jlUsername.setFont(UIConstants.JLABEL_FONT);

		jlPromotion = new JLabel("促销策略", JLabel.CENTER);
		jlPromotion.setBounds(0, 200, 263, 65);
		jlPromotion.setFont(jlabel_font);
		jlPromotion.setForeground(Color.WHITE);
		jlPromotion.setOpaque(true);
		jlPromotion.setBackground(jlabel_color);
		jpMenulistMouseListener = new MenulistPanelMouseListener();
		jlPromotion.addMouseListener(jpMenulistMouseListener);

		jlAbnormal = new JLabel("异常订单", JLabel.CENTER);
		jlAbnormal.setBounds(0, 265, 263, 65);
		jlAbnormal.setFont(jlabel_font);
		jlAbnormal.setForeground(Color.WHITE);
		jlAbnormal.setOpaque(true);
		jlAbnormal.setBackground(jlabel_color);
		jlAbnormal.addMouseListener(jpMenulistMouseListener);
		jlAbnormal.addMouseListener(new MouseAdapter() {
			public void mouseClicked(MouseEvent e) {
				webOrderPanel.refresh();
			}
		});

		jlCreditCharge = new JLabel("信用充值", JLabel.CENTER);
		jlCreditCharge.setBounds(0, 330, 263, 65);
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
