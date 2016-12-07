package hrs.client.UI.WebMarketUI.WebOrderUI;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.security.KeyStore.PrivateKeyEntry;
import java.util.ArrayList;
import java.util.List;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.border.EmptyBorder;
import javax.swing.table.JTableHeader;

import org.aspectj.weaver.CrosscuttingMembersSet;
import org.junit.validator.PublicClassValidator;

import android.R.string;
import hrs.client.UI.WebMarketUI.WebDiscountUI.WebDiscountModel;
import hrs.client.UI.WebMarketUI.WebDiscountUI.WebDiscountPanel;
import hrs.client.UI.WebMarketUI.WebOrderUI.WebOrderListener.RevokeMouseListener;
import hrs.client.UI.WebMarketUI.WebOrderUI.WebOrderListener.SearchConfirmMouseListener;
import hrs.client.util.ControllerFactory;
import hrs.common.Controller.WebMarketController.IWebOrderController;
import hrs.common.Exception.OrderService.OrderNotFoundException;
import hrs.common.VO.OrderVO;
import hrs.common.VO.WebDiscountVO;
import hrs.common.util.type.OrderStatus;
import hrs.common.util.type.RestoreValueType;

import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JTextField;
import javax.swing.DefaultComboBoxModel;

public class WebOrderPanel extends JPanel {
	private WebOrderModel model;
	private List<OrderVO> webOrderList;
	private IWebOrderController orderController = ControllerFactory.getWebOrderController();
	private JTextField textField;
	private JTable jTable;
	private WebOrderModel revokeModel;
	private JTableHeader jTableHeader;
	private JScrollPane scrollPane;
	private List<OrderVO> orderList;
	private JLabel jlNumberOfPO;
	private JLabel jlSearch;
	private JButton jbRevoke;
	private JComboBox comboBox;
	private JButton jbSearchConfirm;

	/**
	 * Create the panel.
	 */
	public WebOrderPanel() {
		init();
	}

	public void init() {
		setSize(1067, 714);
		setBackground(new Color(211, 237, 249));

		orderList = getAbnormalOrder();
		// System.out.println(orderList);

		jbRevoke = new JButton("撤销");
		jbRevoke.setFont(new Font("Arial Unicode MS", Font.PLAIN, 20));
		jbRevoke.setBackground(new Color(0, 160, 233));
		jbRevoke.setForeground(Color.WHITE);
		jbRevoke.setBorderPainted(false);
		jbRevoke.setOpaque(true);
		jbRevoke.addMouseListener(new RevokeMouseListener(this));

		jlNumberOfPO = new JLabel("共" + orderList.size() + "条记录");
		jlNumberOfPO.setFont(new Font("Arial Unicode MS", Font.PLAIN, 15));

		jlSearch = new JLabel("搜索");
		jlSearch.setFont(new Font("Arial Unicode MS", Font.PLAIN, 20));

		comboBox = new JComboBox();
		comboBox.setModel(new DefaultComboBoxModel(new String[] { "用户名", "订单号" }));

		textField = new JTextField();
		textField.setColumns(10);

		jbSearchConfirm = new JButton("确认");
		jbSearchConfirm.setFont(new Font("Arial Unicode MS", Font.PLAIN, 15));
		jbSearchConfirm.setBackground(new Color(0, 160, 233));
		jbSearchConfirm.setForeground(Color.WHITE);
		jbSearchConfirm.setBorderPainted(false);
		jbSearchConfirm.setOpaque(true);
		jbSearchConfirm.addMouseListener(new SearchConfirmMouseListener(this));

		GroupLayout groupLayout = new GroupLayout(this);
		groupLayout.setHorizontalGroup(groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(groupLayout.createSequentialGroup().addContainerGap(881, Short.MAX_VALUE)
						.addComponent(jbRevoke).addGap(96))
				.addGroup(groupLayout.createSequentialGroup().addGap(43).addComponent(jlNumberOfPO).addContainerGap(950,
						Short.MAX_VALUE))
				.addGroup(groupLayout.createSequentialGroup().addGap(31).addComponent(jlSearch).addGap(18)
						.addComponent(comboBox, GroupLayout.PREFERRED_SIZE, 139, GroupLayout.PREFERRED_SIZE).addGap(18)
						.addComponent(textField, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE,
								GroupLayout.PREFERRED_SIZE)
						.addGap(18).addComponent(jbSearchConfirm).addContainerGap(592, Short.MAX_VALUE)));
		groupLayout.setVerticalGroup(groupLayout.createParallelGroup(Alignment.LEADING).addGroup(groupLayout
				.createSequentialGroup()
				.addGap(23).addGroup(groupLayout.createParallelGroup(Alignment.LEADING).addGroup(groupLayout
						.createSequentialGroup().addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
								.addComponent(comboBox, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE,
										GroupLayout.PREFERRED_SIZE)
								.addComponent(textField, GroupLayout.PREFERRED_SIZE, 28, GroupLayout.PREFERRED_SIZE)
								.addComponent(jbSearchConfirm, GroupLayout.PREFERRED_SIZE, 29,
										GroupLayout.PREFERRED_SIZE))
						.addContainerGap())
						.addGroup(groupLayout.createSequentialGroup().addComponent(jlSearch)
								.addPreferredGap(ComponentPlacement.RELATED, 529, Short.MAX_VALUE)
								.addComponent(jlNumberOfPO).addGap(47).addComponent(jbRevoke).addGap(24)))));
		setLayout(groupLayout);

		jTable = new JTable();
		model = new WebOrderModel(orderList);
		jTable.setModel(model);
		jTable.setBackground(new Color(211, 237, 249));
		jTable.setFont(new Font("Arial Unicode MS", Font.PLAIN, 18));
		jTable.setRowHeight(40);
		jTable.setShowVerticalLines(false);
		jTable.setShowHorizontalLines(false);

		// 设置表头
		jTableHeader = jTable.getTableHeader();
		jTableHeader.setPreferredSize(new Dimension(jTableHeader.getWidth(), 30));
		jTableHeader.setBackground(new Color(222, 237, 249));
		jTableHeader.setEnabled(false);
		jTableHeader.setBorder(new EmptyBorder(0, 0, 0, 0));
		jTableHeader.setFont(new Font("Arial Unicode MS", Font.PLAIN, 18));

		scrollPane = new JScrollPane();
		scrollPane.setViewportView(jTable);
		scrollPane.setBounds(3, 70, 1050, 560);
		scrollPane.setBorder(new EmptyBorder(0, 0, 0, 0));
		scrollPane.getViewport().setBackground(new Color(211, 237, 249));
		scrollPane.setOpaque(true);
		add(scrollPane);
	}

	public void refresh() {
		List<OrderVO> list = getAbnormalOrder();
		// System.out.println(list);
		model = new WebOrderModel(list);
		jTable.setModel(model);
	}

	public List<OrderVO> getAbnormalOrder() {
		List<OrderVO> list = new ArrayList<>();
		try {
			list = orderController.findOrderByOrderStatus(OrderStatus.Abnormal);
			// System.out.println(list.get(0).user.username);
		} catch (OrderNotFoundException e) {
			JOptionPane.showMessageDialog(this, "此时异常订单为空！", "NullAbnormalOrder", JOptionPane.INFORMATION_MESSAGE);

		}
		return list;
	}

	public void revokeFull(OrderVO vo) {
		orderController.revokeOrder(vo, RestoreValueType.Full);
		webOrderList = getAbnormalOrder();
		revokeModel = new WebOrderModel(webOrderList);
		jTable.setModel(revokeModel);
		jlNumberOfPO.setText("共 " + webOrderList.size() + " 条记录");
		jlNumberOfPO.setFont(new Font("Arial Unicode MS", Font.PLAIN, 15));
	}

	public void revokeHalf(OrderVO vo) {
		orderController.revokeOrder(vo, RestoreValueType.Half);
		webOrderList = getAbnormalOrder();
		revokeModel = new WebOrderModel(webOrderList);
		jTable.setModel(revokeModel);
		jlNumberOfPO.setText("共 " + webOrderList.size() + " 条记录");
		jlNumberOfPO.setFont(new Font("Arial Unicode MS", Font.PLAIN, 15));
	}

	public void search() {
		String input = textField.getText();
		switch (comboBox.getSelectedIndex()) {
		case 0:
			WebOrderModel searchModel;
			try {
				List<OrderVO> orderVoList = orderController.findOrderByUsernameAndStatus(input, OrderStatus.Abnormal);
				searchModel = new WebOrderModel(orderVoList);
				jTable.setModel(searchModel);
				jlNumberOfPO.setText("共 " + orderVoList.size() + " 条记录");
				jlNumberOfPO.setFont(new Font("Arial Unicode MS", Font.PLAIN, 15));
			} catch (OrderNotFoundException e) {
				// TODO Auto-generated catch block
				List<OrderVO> list = new ArrayList<>();
				searchModel = new WebOrderModel(list);
				jTable.setModel(searchModel);
				jlNumberOfPO.setText("共 0 条记录");
				jlNumberOfPO.setFont(new Font("Arial Unicode MS", Font.PLAIN, 15));
				JOptionPane.showMessageDialog(this, "不存在该用户的异常订单！", "Error", JOptionPane.ERROR_MESSAGE);
			}

			break;
		case 1:
			WebOrderModel searchByIDModel;
			try {
				OrderVO orderVO = orderController.findOrderByID(Integer.parseInt(input));
				List<OrderVO> list = new ArrayList<>();
				list.add(orderVO);
				searchByIDModel = new WebOrderModel(list);
				jTable.setModel(searchByIDModel);
				jlNumberOfPO.setText("共 " + list.size() + " 条记录");
				jlNumberOfPO.setFont(new Font("Arial Unicode MS", Font.PLAIN, 15));
			} catch (OrderNotFoundException e) {
				// TODO Auto-generated catch block
				List<OrderVO> list = new ArrayList<>();
				searchByIDModel = new WebOrderModel(list);
				jTable.setModel(searchByIDModel);
				jlNumberOfPO.setText("共 0 条记录");
				jlNumberOfPO.setFont(new Font("Arial Unicode MS", Font.PLAIN, 15));
				JOptionPane.showMessageDialog(this, "不存在该异常订单！", "Error", JOptionPane.ERROR_MESSAGE);
			}
			break;
		default:
			break;
		}
		textField.setText("");
	}

	public OrderVO getSelected() {
		if (jTable.getSelectedRow() != -1) {
			return model.getValue(jTable.getSelectedRow());
		} else
			return null;
	}

	// public static void main(String[] args) {
	// JFrame frame = new JFrame();
	// frame.setSize(1000, 700);
	// WebOrderPanel p = new WebOrderPanel();
	// frame.add(p);
	// frame.setVisible(true);
	// }
}
