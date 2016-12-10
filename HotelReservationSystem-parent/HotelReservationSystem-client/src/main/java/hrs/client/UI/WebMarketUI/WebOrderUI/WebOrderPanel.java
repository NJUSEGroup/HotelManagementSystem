package hrs.client.UI.WebMarketUI.WebOrderUI;

import java.awt.Dimension;
import java.awt.Font;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.border.EmptyBorder;
import javax.swing.table.JTableHeader;

import hrs.client.UI.WebMarketUI.WebOrderUI.WebOrderListener.RevokeMouseListener;
import hrs.client.UI.WebMarketUI.WebOrderUI.WebOrderListener.SearchConfirmMouseListener;
import hrs.client.util.ControllerFactory;
import hrs.client.util.HMSBlueButton;
import hrs.client.util.UIConstants;
import hrs.common.Controller.WebMarketController.IWebOrderController;
import hrs.common.Exception.OrderService.OrderNotFoundException;
import hrs.common.VO.OrderVO;
import hrs.common.util.type.OrderStatus;
import hrs.common.util.type.RestoreValueType;

import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.JComboBox;
import javax.swing.JTextField;
import javax.swing.DefaultComboBoxModel;

public class WebOrderPanel extends JPanel {
	/**
	 * 
	 */
	private static final long serialVersionUID = 6007121701597459920L;
	private WebOrderModel model;
	private IWebOrderController orderController = ControllerFactory.getWebOrderController();
	private JTextField textField;
	private JTable jTable;
	private JTableHeader jTableHeader;
	private JScrollPane scrollPane;
	private List<OrderVO> orderList;
	private JLabel jlNumberOfPO;
	private JLabel jlSearch;
	@SuppressWarnings("rawtypes")
	private JComboBox comboBox;
	private HMSBlueButton jbRevoke, jbSearchConfirm;

	/**
	 * Create the panel.
	 */
	public WebOrderPanel() {
		init();
	}

	@SuppressWarnings({ "unchecked", "rawtypes" })
	public void init() {
		setSize(1080, 722);
		setBackground(UIConstants.JFRAME);

		orderList = getAbnormalOrder();
		// System.out.println(orderList);

		jbRevoke = new HMSBlueButton("撤销");
		jbRevoke.addMouseListener(new RevokeMouseListener(this));

		jlNumberOfPO = new JLabel("共" + orderList.size() + "条记录");
		jlNumberOfPO.setFont(UIConstants.JLABEL_NUMBER_OF_INFO);

		jlSearch = new JLabel("搜索");
		jlSearch.setFont(UIConstants.FONT_21);

		comboBox = new JComboBox();
		comboBox.setModel(new DefaultComboBoxModel(new String[] { "用户名", "订单号" }));

		textField = new JTextField();
		textField.setColumns(10);

		jbSearchConfirm = new HMSBlueButton("确认");
		jbSearchConfirm.setFont(UIConstants.FONT_14);
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
		jTable.setBackground(UIConstants.JFRAME);
		jTable.setFont(UIConstants.FONT_18);
		jTable.setRowHeight(40);
		jTable.setShowVerticalLines(false);
		jTable.setShowHorizontalLines(true);

		// 设置表头
		jTableHeader = jTable.getTableHeader();
		jTableHeader.setPreferredSize(new Dimension(jTableHeader.getWidth(), 30));
		jTableHeader.setBackground(UIConstants.JTABLEHEADER_COLOR);
		jTableHeader.setEnabled(false);
		jTableHeader.setBorder(new EmptyBorder(0, 0, 0, 0));
		jTableHeader.setFont(UIConstants.FONT_18);

		scrollPane = new JScrollPane();
		scrollPane.setViewportView(jTable);
		scrollPane.setBounds(3, 70, 1050, 560);
		scrollPane.setBorder(new EmptyBorder(0, 0, 0, 0));
		scrollPane.getViewport().setBackground(UIConstants.JFRAME);
		scrollPane.setOpaque(true);
		add(scrollPane);
	}

	public void refresh() {
		orderList = getAbnormalOrder();
		model = new WebOrderModel(orderList);
		jTable.setModel(model);
		jlNumberOfPO.setText("共 " + orderList.size() + " 条记录");
		jlNumberOfPO.setFont(UIConstants.JLABEL_NUMBER_OF_INFO);
	}

	public List<OrderVO> getAbnormalOrder() {
		try {
			orderList = orderController.findOrderByOrderStatus(OrderStatus.Abnormal);
			// System.out.println(list.get(0).user.username);
		} catch (OrderNotFoundException e) {
			JOptionPane.showMessageDialog(this, "此时异常订单为空！", "NullAbnormalOrder", JOptionPane.INFORMATION_MESSAGE);

		}
		return orderList;
	}

	public void revokeFull(OrderVO vo) {
		orderController.revokeOrder(vo, RestoreValueType.Full);
		refresh();
	}

	public void revokeHalf(OrderVO vo) {
		orderController.revokeOrder(vo, RestoreValueType.Half);
		refresh();
	}

	public void search() {
		String input = textField.getText();
		switch ((String) comboBox.getSelectedItem()) {
		case "用户名":
			if (input.equals("")) {
				JOptionPane.showMessageDialog(this, "请填写用户名！", "Error", JOptionPane.ERROR_MESSAGE);
			} else {
				try {
					List<OrderVO> orderVoList = orderController.findOrderByUsernameAndStatus(input,
							OrderStatus.Abnormal);
					model = new WebOrderModel(orderVoList);
					jTable.setModel(model);
					jlNumberOfPO.setText("共 " + orderVoList.size() + " 条记录");
					jlNumberOfPO.setFont(UIConstants.JLABEL_NUMBER_OF_INFO);
				} catch (OrderNotFoundException e) {
					// TODO Auto-generated catch block
					List<OrderVO> list = new ArrayList<>();
					model = new WebOrderModel(list);
					jTable.setModel(model);
					jlNumberOfPO.setText("共 0 条记录");
					jlNumberOfPO.setFont(UIConstants.JLABEL_NUMBER_OF_INFO);
					JOptionPane.showMessageDialog(this, "不存在该用户的异常订单！", "Error", JOptionPane.ERROR_MESSAGE);
				}
			}
			break;
		case "订单号":
			if (input.equals("")) {
				JOptionPane.showMessageDialog(this, "请填写订单号！", "Error", JOptionPane.ERROR_MESSAGE);
			} else {
				try {
					OrderVO orderVO = orderController.findOrderByID(Integer.parseInt(input));
					if (!orderVO.status.equals(OrderStatus.Abnormal)) {
						JOptionPane.showMessageDialog(this, "不存在该异常订单！", "Error", JOptionPane.ERROR_MESSAGE);
					} else {
						List<OrderVO> list = new ArrayList<>();
						list.add(orderVO);
						model = new WebOrderModel(list);
						jTable.setModel(model);
						jlNumberOfPO.setText("共 " + list.size() + " 条记录");
						jlNumberOfPO.setFont(UIConstants.JLABEL_NUMBER_OF_INFO);
					}
				} catch (OrderNotFoundException e) {
					// TODO Auto-generated catch block
					List<OrderVO> list = new ArrayList<>();
					model = new WebOrderModel(list);
					jTable.setModel(model);
					jlNumberOfPO.setText("共 0 条记录");
					jlNumberOfPO.setFont(UIConstants.JLABEL_NUMBER_OF_INFO);
					JOptionPane.showMessageDialog(this, "不存在该异常订单！", "Error", JOptionPane.ERROR_MESSAGE);
				}
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
}
