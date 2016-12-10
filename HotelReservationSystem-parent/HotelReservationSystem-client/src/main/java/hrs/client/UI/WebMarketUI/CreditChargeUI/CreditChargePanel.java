package hrs.client.UI.WebMarketUI.CreditChargeUI;

import java.awt.Dimension;

import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;

import javax.swing.SwingConstants;

import javax.swing.JTextField;
import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.border.EmptyBorder;
import javax.swing.table.JTableHeader;

import hrs.client.UI.WebMarketUI.CreditChargeUI.CreditChargeListener.ChargeMouseListener;
import hrs.client.UI.WebMarketUI.CreditChargeUI.CreditChargeListener.ConfirmMouseListener;
import hrs.client.util.ControllerFactory;
import hrs.client.util.HMSBlueButton;
import hrs.client.util.UIConstants;
import hrs.common.Controller.WebMarketController.IWebCreditController;
import hrs.common.Exception.UserService.UserNotFoundException;
import hrs.common.VO.UserVO;

public class CreditChargePanel extends JPanel {
	/**
	 * 
	 */
	private static final long serialVersionUID = 5309610749415781785L;
	private IWebCreditController webCreditController = ControllerFactory.getWebCreditController();
	private JTextField jtUsername;
	private JTextField jtChargeValue;
	private CreditChargeModel model;
	private JScrollPane scrollPane;
	private JLabel jlFindUser;
	private HMSBlueButton jbConfirm, jbChargeValue;
	private JLabel jlChargeValue;
	private JTableHeader jTableHeader;
	private JTable jTable;
	private UserVO userVO;
	private String username;
	private CreditChargeModel creditChargeModel;

	/**
	 * Create the panel.
	 */
	public CreditChargePanel() {
		init();
	}

	public void init() {
		setSize(1080, 722);
		setBackground(UIConstants.JFRAME);

		jlFindUser = new JLabel("搜索用户");
		jlFindUser.setHorizontalAlignment(SwingConstants.CENTER);
		jlFindUser.setFont(UIConstants.JLABEL_FONT);

		jtUsername = new JTextField();
		jtUsername.setColumns(10);

		jbConfirm = new HMSBlueButton("确认");
		jbConfirm.setFont(UIConstants.FONT_18);
		jbConfirm.addMouseListener(new ConfirmMouseListener(this));

		jlChargeValue = new JLabel("充值额度");
		jlChargeValue.setHorizontalAlignment(SwingConstants.CENTER);
		jlChargeValue.setFont(UIConstants.FONT_20);

		jtChargeValue = new JTextField();
		jtChargeValue.setColumns(10);

		jbChargeValue = new HMSBlueButton("充值");
		jbChargeValue.setFont(UIConstants.FONT_20);
		jbChargeValue.addMouseListener(new ChargeMouseListener(this, jtChargeValue));

		GroupLayout groupLayout = new GroupLayout(this);
		groupLayout.setHorizontalGroup(groupLayout.createParallelGroup(Alignment.LEADING).addGroup(groupLayout
				.createSequentialGroup().addGap(14)
				.addGroup(groupLayout.createParallelGroup(Alignment.LEADING, false)
						.addComponent(jlChargeValue, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE,
								Short.MAX_VALUE)
						.addComponent(jlFindUser, GroupLayout.DEFAULT_SIZE, 114, Short.MAX_VALUE))
				.addPreferredGap(ComponentPlacement.RELATED, 53, Short.MAX_VALUE)
				.addGroup(groupLayout.createParallelGroup(Alignment.TRAILING)
						.addComponent(jtUsername, GroupLayout.PREFERRED_SIZE, 219, GroupLayout.PREFERRED_SIZE)
						.addComponent(jtChargeValue, GroupLayout.PREFERRED_SIZE, 219, GroupLayout.PREFERRED_SIZE))
				.addGap(71).addGroup(groupLayout.createParallelGroup(Alignment.LEADING).addComponent(jbConfirm)
						.addComponent(jbChargeValue))
				.addContainerGap(506, Short.MAX_VALUE)));
		groupLayout.setVerticalGroup(groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(groupLayout
						.createSequentialGroup().addGap(
								23)
						.addGroup(groupLayout.createParallelGroup(Alignment.TRAILING, false)
								.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
										.addComponent(jtUsername, GroupLayout.DEFAULT_SIZE, 36, Short.MAX_VALUE)
										.addComponent(jbConfirm))
								.addComponent(jlFindUser, GroupLayout.PREFERRED_SIZE, 32, Short.MAX_VALUE))
						.addGap(189)
						.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
								.addComponent(jlChargeValue, GroupLayout.PREFERRED_SIZE, 32, Short.MAX_VALUE)
								.addComponent(jtChargeValue, GroupLayout.PREFERRED_SIZE, 36, Short.MAX_VALUE)
								.addComponent(jbChargeValue))
						.addContainerGap(420, Short.MAX_VALUE)));
		setLayout(groupLayout);

		jTable = new JTable();
		model = new CreditChargeModel();
		jTable.setModel(model);
		jTable.setBackground(UIConstants.JFRAME);
		jTable.setFont(UIConstants.FONT_18);
		jTable.setRowHeight(40);
		jTable.setShowVerticalLines(false);
		jTable.setShowHorizontalLines(true);

		// 设置表头
		jTableHeader = jTable.getTableHeader();
		jTableHeader.setPreferredSize(new Dimension(jTableHeader.getWidth(), 35));
		jTableHeader.setBackground(UIConstants.JTABLEHEADER_COLOR);
		jTableHeader.setEnabled(false);
		jTableHeader.setBorder(new EmptyBorder(0, 0, 0, 0));
		jTableHeader.setFont(UIConstants.FONT_18);

		scrollPane = new JScrollPane();
		scrollPane.setViewportView(jTable);
		scrollPane.setBounds(3, 85, 1000, 100);
		scrollPane.setBorder(new EmptyBorder(0, 0, 0, 0));
		scrollPane.getViewport().setBackground(UIConstants.JFRAME);
		scrollPane.setOpaque(true);
		add(scrollPane);
	}

	public UserVO getUserVOAndShow() throws UserNotFoundException {
		userVO = null;
		if (jtUsername.getText().equals("")) {
			JOptionPane.showMessageDialog(this, "请输入用户名！", "Enter The Username", JOptionPane.ERROR_MESSAGE);
		} else {
			username = jtUsername.getText();
			try {
				userVO = webCreditController.findUserByUsername(username);
			} catch (UserNotFoundException e2) {
				// TODO: handle exception
				JOptionPane.showMessageDialog(this, "用户名不存在", "No Such Username", JOptionPane.ERROR_MESSAGE);
				jtUsername.setText("");
			}
			creditChargeModel = new CreditChargeModel(userVO);
			jTable.setModel(creditChargeModel);
			// jbChargeValue.setEnabled(true);
		}
		return userVO;
	}

	public void charge(int value) {
		int result = JOptionPane.showConfirmDialog(null, "是否确定充值？", "提示", JOptionPane.YES_NO_OPTION,
				JOptionPane.INFORMATION_MESSAGE);
		if (result == 0) {
			value = Integer.parseInt(jtChargeValue.getText());
			webCreditController.charge(userVO, value);
			try {
				userVO = webCreditController.findUserByUsername(username);
			} catch (UserNotFoundException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}

			creditChargeModel = new CreditChargeModel(userVO);
			jTable.setModel(creditChargeModel);
			jtChargeValue.setText("");
		}

	}

	public String getUsername() {
		return jtUsername.getText();
	}
	// public static void main(String[] args) {
	// JFrame frame = new JFrame();
	// frame.setSize(1000, 700);
	// CreditChargePanel p = new CreditChargePanel();
	// frame.add(p);
	// frame.setVisible(true);
	// }
}
