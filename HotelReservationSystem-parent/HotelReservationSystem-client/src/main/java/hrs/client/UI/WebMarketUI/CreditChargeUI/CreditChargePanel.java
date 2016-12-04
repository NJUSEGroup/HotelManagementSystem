package hrs.client.UI.WebMarketUI.CreditChargeUI;

import java.awt.Color;
import java.awt.Dimension;

import javax.print.attribute.standard.RequestingUserName;
import javax.swing.BorderFactory;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import java.awt.Font;
import java.util.ArrayList;
import java.util.List;

import javax.swing.SwingConstants;

import javax.swing.JTextField;
import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.border.EmptyBorder;
import javax.swing.table.JTableHeader;

import hrs.client.UI.UserUI.UserInfoUI.UserInfoListener.ConfirmListener;
import hrs.client.UI.WebMarketUI.CreditChargeUI.CreditChargeListener.ChargeMouseListener;
import hrs.client.UI.WebMarketUI.CreditChargeUI.CreditChargeListener.ConfirmMouseListener;
import hrs.client.UI.WebMarketUI.WebDiscountUI.WebDiscountPanel;
import hrs.client.UI.WebMarketUI.WebOrderUI.WebOrderPanel;
import hrs.client.util.ControllerFactory;
import hrs.common.Controller.WebMarketController.IWebCreditController;
import hrs.common.Exception.UserService.UserNotFoundException;
import hrs.common.VO.UserVO;

import javax.swing.JButton;
import javax.swing.JFrame;

public class CreditChargePanel extends JPanel {
	private IWebCreditController webCreditController = ControllerFactory.getWebCreditController();
	private JTextField jtUsername;
	private JTextField jtChargeValue;
	private CreditChargeModel model;
	private JScrollPane scrollPane;
	private JTable jTable;
	UserVO userVO;

	/**
	 * Create the panel.
	 */
	public CreditChargePanel() {

		// this.username =username;//???

		setSize(1067, 714);
		setBackground(new Color(211, 237, 249));

		JLabel jlFindUser = new JLabel("搜索用户");
		jlFindUser.setHorizontalAlignment(SwingConstants.CENTER);
		jlFindUser.setFont(new Font("Arial Unicode MS", Font.PLAIN, 21));

		jtUsername = new JTextField();
		jtUsername.setColumns(10);

		JButton jbConfirm = new JButton("确认");
		jbConfirm.setFont(new Font("Arial Unicode MS", Font.PLAIN, 20));
		jbConfirm.setBackground(new Color(0, 160, 233));
		jbConfirm.setForeground(Color.WHITE);
		jbConfirm.setBorderPainted(false);
		jbConfirm.setOpaque(true);
		jbConfirm.addMouseListener(new ConfirmMouseListener(this, jtUsername));

		JLabel jlChargeValue = new JLabel("充值额度");
		jlChargeValue.setHorizontalAlignment(SwingConstants.CENTER);
		jlChargeValue.setFont(new Font("Arial Unicode MS", Font.PLAIN, 20));

		jtChargeValue = new JTextField();
		jtChargeValue.setColumns(10);

		JButton jbChargeValue = new JButton("充值");
		jbChargeValue.setFont(new Font("Arial Unicode MS", Font.PLAIN, 20));
		jbChargeValue.setBackground(new Color(0, 160, 233));
		jbChargeValue.setForeground(Color.WHITE);
		jbChargeValue.setBorderPainted(false);
		jbChargeValue.setOpaque(true);
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
		jTable.setBackground(new Color(211, 237, 249));
		jTable.setFont(new Font("Arial Unicode MS", Font.PLAIN, 18));
		jTable.setRowHeight(40);
		jTable.setShowVerticalLines(false);
		jTable.setShowHorizontalLines(false);

		// 设置表头
		JTableHeader jTableHeader = jTable.getTableHeader();
		jTableHeader.setPreferredSize(new Dimension(jTableHeader.getWidth(), 35));
		jTableHeader.setBackground(new Color(222, 237, 249));
		jTableHeader.setEnabled(false);
		jTableHeader.setBorder(new EmptyBorder(0, 0, 0, 0));
		jTableHeader.setFont(new Font("Arial Unicode MS", Font.PLAIN, 18));

		scrollPane = new JScrollPane();
		scrollPane.setViewportView(jTable);
		scrollPane.setBounds(3, 85, 1000, 100);
		scrollPane.setBorder(new EmptyBorder(0, 0, 0, 0));
		scrollPane.getViewport().setBackground(new Color(211, 237, 249));
		scrollPane.setOpaque(true);
		add(scrollPane);

	}
	// public void showInfo(){
	// model=new
	// CreditChargeModel(getUserVOCreditChargeList(jtUsername.getText()));
	// jTable.setModel(model);
	// }

	public UserVO getUserVOAndShow(String username) throws UserNotFoundException {
		username = jtUsername.getText();
//		System.out.println(username);
		userVO = null;
		CreditChargeModel creditChargeModel;
		try {
		userVO = webCreditController.findUserByUsername(username);
		} catch (UserNotFoundException e2) {
			// TODO: handle exception
			JOptionPane.showMessageDialog(this, "用户名不存在", "No Such Username", JOptionPane.ERROR_MESSAGE);
		}
		creditChargeModel = new CreditChargeModel(userVO);
		jTable.setModel(creditChargeModel);

		return userVO;
	}
	public void charge(int value){
		value=Integer.parseInt(jtChargeValue.getText());
		UserVO userVO = null;
		CreditChargeModel creditChargeModel;
		webCreditController=ControllerFactory.getWebCreditController();
		webCreditController.charge(userVO,value);
		creditChargeModel=new CreditChargeModel(userVO);
		jTable.setModel(creditChargeModel);		
	}

//	public static void main(String[] args) {
//		JFrame frame = new JFrame();
//		frame.setSize(1000, 700);
//		CreditChargePanel p = new CreditChargePanel();
//		frame.add(p);
//		frame.setVisible(true);
//	}
}
