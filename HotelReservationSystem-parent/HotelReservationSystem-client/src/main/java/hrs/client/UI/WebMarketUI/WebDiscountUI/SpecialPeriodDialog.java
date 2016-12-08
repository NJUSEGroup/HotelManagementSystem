package hrs.client.UI.WebMarketUI.WebDiscountUI;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.Font;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import org.hibernate.loader.custom.Return;

import hrs.client.UI.WebMarketUI.WebDiscountUI.WebDiscountListener.CancelModifySpecialPeriodDiscountListener;
import hrs.client.UI.WebMarketUI.WebDiscountUI.WebDiscountListener.ConfirmModifySpecialPeriodListener;
import hrs.client.util.HRSButton;
import hrs.client.util.UIConstants;
import hrs.common.VO.WebDiscountVO;
import hrs.common.util.DateHelper;
import hrs.common.util.type.WebsiteDiscountType;

import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import java.awt.event.ActionListener;
import java.text.ParseException;
import java.util.Date;
import java.awt.event.ActionEvent;

public class SpecialPeriodDialog extends JDialog {

	private final JPanel contentPanel = new JPanel();
	private JTextField jtextBeginTime;
	private JTextField jtextEndTime;
	private JTextField jtextDiscount;
	private HRSButton jbConfirmModify, jbCancalModify;
	private JLabel jlBeginTime;
	private JLabel jlDiscount;
	private JLabel jlEndTime;
	private WebDiscountPanel webDiscountPanel;
	private WebDiscountVO webDiscountVO;
	private ConfirmModifySpecialPeriodListener listener;
	private CancelModifySpecialPeriodDiscountListener cancelListener;

	public SpecialPeriodDialog(WebDiscountPanel webDiscountPanel) {
		this.webDiscountPanel = webDiscountPanel;
		init();
	}

	/**
	 * Create the dialog.
	 */
	public void init() {
		webDiscountVO = webDiscountPanel.getSelected();
		// System.out.println(webDiscountVO);

		// getContentPane().setBackground(UIConstants.JFRAME);
		setTitle("特定期间专属折扣修改");
		setBounds(100, 100, 420, 280);
		getContentPane().setLayout(new BorderLayout());
		contentPanel.setLayout(null);
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPanel.setBackground(UIConstants.JFRAME);
		getContentPane().add(contentPanel, BorderLayout.CENTER);

		jlBeginTime = new JLabel("开始时间");
		jlBeginTime.setBounds(103, 42, 61, 16);
		contentPanel.add(jlBeginTime);

		jlEndTime = new JLabel("结束时间");
		jlEndTime.setBounds(103, 98, 61, 16);
		contentPanel.add(jlEndTime);

		jlDiscount = new JLabel("折扣信息");
		jlDiscount.setBounds(103, 154, 61, 16);
		contentPanel.add(jlDiscount);

		jtextBeginTime = new JTextField();
		jtextBeginTime.setBounds(205, 37, 130, 26);
		contentPanel.add(jtextBeginTime);
		jtextBeginTime.setColumns(10);
		jtextBeginTime.setText(webDiscountVO.beginTime.toString());

		jtextEndTime = new JTextField();
		jtextEndTime.setBounds(205, 93, 130, 26);
		contentPanel.add(jtextEndTime);
		jtextEndTime.setColumns(10);
		jtextEndTime.setText(webDiscountVO.endTime.toString());

		jtextDiscount = new JTextField();
		jtextDiscount.setBounds(205, 149, 130, 26);
		contentPanel.add(jtextDiscount);
		jtextDiscount.setColumns(10);
		jtextDiscount.setText(webDiscountVO.discount + "");

		jbConfirmModify = new HRSButton("确认修改");
		jbConfirmModify.setFont(new Font("宋体", Font.PLAIN, 13));
		jbConfirmModify.setBounds(103, 204, 103, 29);
		listener = new ConfirmModifySpecialPeriodListener(webDiscountPanel, this);
		jbConfirmModify.addMouseListener(listener);
		contentPanel.add(jbConfirmModify);

		jbCancalModify = new HRSButton("取消修改");
		jbCancalModify.setFont(new Font("宋体", Font.PLAIN, 13));
		jbCancalModify.setBounds(218, 204, 103, 29);
		contentPanel.add(jbCancalModify);
		cancelListener = new CancelModifySpecialPeriodDiscountListener(this);
		jbCancalModify.addMouseListener(cancelListener);

	}

	public WebDiscountVO getModifyVO() {
		Date newBeginTime = null;
		Date newEndTime = null;
		try {
			newBeginTime = DateHelper.parse(jtextBeginTime.getText());
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			JOptionPane.showMessageDialog(null, "请输入正确的日期格式", "Error", JOptionPane.ERROR_MESSAGE);
		}
		try {
			newEndTime = DateHelper.parse(jtextEndTime.getText());
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			JOptionPane.showMessageDialog(null, "请输入正确的日期格式", "Error", JOptionPane.ERROR_MESSAGE);
		}
		double newDiscount = Double.parseDouble(jtextDiscount.getText());
		webDiscountVO.beginTime = newBeginTime;
		webDiscountVO.endTime = newEndTime;
		webDiscountVO.discount = newDiscount;
		return webDiscountVO;
	}

	public double getNewDiscount() {
		return getModifyVO().discount;
	}

}
