package hrs.client.UI.WebMarketUI.WebDiscountUI;

import java.awt.BorderLayout;
import java.awt.FlowLayout;
import javax.swing.JDialog;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import hrs.client.UI.WebMarketUI.WebDiscountUI.WebDiscountListener.CancelModifyVIPListener;
import hrs.client.UI.WebMarketUI.WebDiscountUI.WebDiscountListener.ConfirmModifyVIPListener;
import hrs.client.util.HMSBlueButton;
import hrs.client.util.UIConstants;
import hrs.common.VO.WebDiscountVO;

import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JComboBox;
import javax.swing.DefaultComboBoxModel;

public class VIPDiaog extends JDialog {

	/**
	 * 
	 */
	private static final long serialVersionUID = -2167532987431957999L;
	private final JPanel contentPanel = new JPanel();
	private JTextField jtextDiscount;
	private JLabel jlDiscount;
	private JLabel jlVIP;
	private JComboBox<Object> jcomboBoxVIP;
	private HMSBlueButton jbComfirmModify, jbCancelModify;
	private WebDiscountPanel webDiscountPanel;
	private WebDiscountVO webDiscountVO;
	private ConfirmModifyVIPListener listener;
	private CancelModifyVIPListener cancelListener;

	/**
	 * Create the dialog.
	 */
	public VIPDiaog(WebDiscountPanel webDiscountPanel) {
		this.webDiscountPanel = webDiscountPanel;
		init();
	}

	public void init() {
		webDiscountVO = webDiscountPanel.getSelected();

		getContentPane().setBackground(UIConstants.JFRAME);
		setTitle("VIP专属折扣修改");
		setBounds(100, 100, 420, 280);
		this.setResizable(false);
		getContentPane().setLayout(null);
		contentPanel.setLayout(new FlowLayout());
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel, BorderLayout.CENTER);

		jlVIP = new JLabel("VIP等级");
		jlVIP.setBounds(81, 51, 61, 16);
		getContentPane().add(jlVIP);

		jlDiscount = new JLabel("折扣信息");
		jlDiscount.setBounds(81, 99, 61, 16);
		getContentPane().add(jlDiscount);

		jtextDiscount = new JTextField();
		jtextDiscount.setBounds(185, 94, 130, 26);
		getContentPane().add(jtextDiscount);
		jtextDiscount.setColumns(10);
		jtextDiscount.setText(webDiscountVO.discount + "");

		jcomboBoxVIP = new JComboBox<Object>();
		jcomboBoxVIP.setModel(new DefaultComboBoxModel<Object>(new String[] { "1", "2", "3", "4", "5" }));
		jcomboBoxVIP.setBounds(185, 47, 130, 27);
		getContentPane().add(jcomboBoxVIP);
		jcomboBoxVIP.setSelectedIndex(webDiscountVO.VIPlevel - 1);

		jbComfirmModify = new HMSBlueButton("确认修改");
		jbComfirmModify.setFont(UIConstants.FONT_13);
		jbComfirmModify.setBounds(90, 157, 96, 29);
		getContentPane().add(jbComfirmModify);
		listener = new ConfirmModifyVIPListener(webDiscountPanel, this);
		jbComfirmModify.addMouseListener(listener);

		jbCancelModify = new HMSBlueButton("取消修改");
		jbCancelModify.setFont(UIConstants.FONT_13);
		jbCancelModify.setBounds(206, 157, 96, 29);
		getContentPane().add(jbCancelModify);
		cancelListener = new CancelModifyVIPListener(this);
		jbCancelModify.addMouseListener(cancelListener);
	}

	public WebDiscountVO getModifyVO() {
		int newVIPLevel = Integer.parseInt(jcomboBoxVIP.getSelectedItem().toString());
		double newDiscount = Double.parseDouble(jtextDiscount.getText());
		webDiscountVO.VIPlevel = newVIPLevel;
		webDiscountVO.discount = newDiscount;
		// System.out.println(webDiscountVO);
		return webDiscountVO;
	}

	public double getNewDiscount() {
		return getModifyVO().discount;
	}

}
