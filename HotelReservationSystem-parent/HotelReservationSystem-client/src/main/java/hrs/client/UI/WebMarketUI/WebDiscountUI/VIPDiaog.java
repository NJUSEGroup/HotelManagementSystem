package hrs.client.UI.WebMarketUI.WebDiscountUI;

import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import hrs.client.UI.WebMarketUI.WebDiscountUI.WebDiscountListener.ConfirmModifyVIPListener;
import hrs.common.VO.WebDiscountVO;
import hrs.common.util.type.WebsiteDiscountType;

import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JComboBox;
import javax.swing.DefaultComboBoxModel;

public class VIPDiaog extends JDialog {

	private final JPanel contentPanel = new JPanel();
	private JTextField jtextDiscount;
	private JLabel jlDiscount;
	private JLabel jlVIP;
	private JComboBox jcomboBoxVIP;
	private JButton jbComfirmModify;
	private JButton jbCancelModify;
	private WebDiscountPanel webDiscountPanel;
	private WebDiscountVO webDiscountVO;
	private ConfirmModifyVIPListener listener;

	/**
	 * Create the dialog.
	 */
	public VIPDiaog(WebDiscountPanel webDiscountPanel) {
		this.webDiscountPanel = webDiscountPanel;
		init();
	}

	public void init() {
		webDiscountVO = webDiscountPanel.getSelected();

		setTitle("VIP专属折扣修改");
		setBounds(100, 100, 420, 280);
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

		jcomboBoxVIP = new JComboBox();
		jcomboBoxVIP.setModel(new DefaultComboBoxModel(new String[] { "1", "2", "3", "4", "5" }));
		jcomboBoxVIP.setBounds(185, 47, 130, 27);
		getContentPane().add(jcomboBoxVIP);
		jcomboBoxVIP.setSelectedIndex(webDiscountVO.VIPlevel - 1);

		jbComfirmModify = new JButton("确认修改");
		jbComfirmModify.setBounds(102, 157, 84, 29);
		getContentPane().add(jbComfirmModify);
		listener=new ConfirmModifyVIPListener(webDiscountPanel, this);
		jbComfirmModify.addMouseListener(listener);

		jbCancelModify = new JButton("取消修改");
		jbCancelModify.setBounds(206, 157, 84, 29);
		getContentPane().add(jbCancelModify);
	}

	public WebDiscountVO getModifyVO() {
		int newVIPLevel = (int) jcomboBoxVIP.getSelectedItem();
		double newDiscount = Double.parseDouble(jtextDiscount.getText());
		WebDiscountVO newVO = new WebDiscountVO(newDiscount, WebsiteDiscountType.VIP, null, null, null, null,
				newVIPLevel);
		System.out.println(newVO);
		return newVO;
	}

}
