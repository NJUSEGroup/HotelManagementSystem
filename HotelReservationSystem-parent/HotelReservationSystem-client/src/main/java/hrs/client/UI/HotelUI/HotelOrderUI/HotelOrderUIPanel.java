package hrs.client.UI.HotelUI.HotelOrderUI;

import java.awt.CardLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.util.ArrayList;
import java.util.List;

import javax.swing.DefaultComboBoxModel;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.border.EmptyBorder;
import javax.swing.plaf.basic.BasicSliderUI.ScrollListener;
import javax.swing.table.JTableHeader;

import hrs.client.UI.HotelUI.Components.OrderListTableModel;
import hrs.client.UI.HotelUI.HotelOrderDetailUI.HotelOrderDetailUIPanel;
import hrs.client.UI.HotelUI.HotelOrderUI.Listener.DetailListener;
import hrs.client.UI.HotelUI.HotelOrderUI.Listener.SearchByIdOrUsernameListener;
import hrs.client.UI.HotelUI.HotelOrderUI.Listener.SearchByOrderTypeListener;
import hrs.client.util.ControllerFactory;
import hrs.common.Controller.HotelController.IHotelOrderController;
import hrs.common.Exception.OrderService.OrderNotFoundException;
import hrs.common.VO.HotelVO;
import hrs.common.VO.OrderVO;
import hrs.common.util.type.OrderStatus;

public class HotelOrderUIPanel extends JPanel {

	private JPanel jpSearch;
	private JPanel jpOrder;
	private JPanel jpButton;
	private JScrollPane jspOrderList;
	private JLabel jlOrderType;
	private JLabel jlSearch;
	private JComboBox jcbOrderType;
	private JComboBox jcbSearch;
	private JTextField jtfSearch;
	private JButton jbConfirm1;
	private JButton jbConfirm2;
	private JButton jbDetail;
	private JButton jbCheckin;
	private JButton jbCheckout;
	private JButton jbDelay;
	private JTable jtOrderList;
	private JTableHeader jthOrderList;
	private OrderListTableModel orderListTableModel;
	private IHotelOrderController hotelOrderController;
	private SearchByOrderTypeListener searchListener1;
	private SearchByIdOrUsernameListener searchListener2;
	private DetailListener detailListener;
	private HotelVO hotel;

	/**
	 * Create the panel.
	 */
	public HotelOrderUIPanel(HotelOrderMainPanel jpMain, HotelVO hotel) {
		init(jpMain, hotel);
	}

	public void init(HotelOrderMainPanel jpMain, HotelVO hotel) {
		this.setSize(1080, 722);
		this.setLayout(null);

		this.hotel = hotel;

		hotelOrderController = ControllerFactory.getHotelOrderController();

		searchListener1 = new SearchByOrderTypeListener(this);
		searchListener2 = new SearchByIdOrUsernameListener(this);
		detailListener = new DetailListener(jpMain, this);

		jpSearch = new JPanel();
		jpSearch.setBounds(0, 0, 1080, 170);
		jpSearch.setBackground(new Color(211, 237, 249));
		jpSearch.setLayout(null);

		jpOrder = new JPanel();
		jpOrder.setBounds(0, 170, 1080, 472);
		jpOrder.setBackground(new Color(211, 237, 249));
		jpOrder.setLayout(null);

		jpButton = new JPanel();
		jpButton.setBounds(0, 642, 1080, 80);
		jpButton.setBackground(new Color(211, 237, 249));
		jpButton.setLayout(null);

		jlOrderType = new JLabel();
		jlOrderType.setBounds(20, 20, 90, 30);
		jlOrderType.setText("订单类型");
		jlOrderType.setHorizontalAlignment(SwingConstants.CENTER);
		jlOrderType.setFont(new Font("方正兰亭超细黑简体", Font.PLAIN, 19));

		jlSearch = new JLabel();
		jlSearch.setBounds(20, 100, 90, 30);
		jlSearch.setText("搜索");
		jlSearch.setHorizontalAlignment(SwingConstants.CENTER);
		jlSearch.setFont(new Font("方正兰亭超细黑简体", Font.PLAIN, 19));

		jcbOrderType = new JComboBox(new DefaultComboBoxModel(new String[] { "未执行", "已执行", "异常", "已撤销" }));
		jcbOrderType.setBounds(130, 20, 230, 30);
		jcbOrderType.setFont(new Font("方正兰亭超细黑简体", Font.PLAIN, 19));
		jcbOrderType.setOpaque(true);
		jcbOrderType.setBackground(Color.WHITE);
		jcbOrderType.setEditable(false);

		jcbSearch = new JComboBox(new DefaultComboBoxModel(new String[] { "用户名", "订单号" }));
		jcbSearch.setBounds(130, 100, 230, 30);
		jcbSearch.setFont(new Font("方正兰亭超细黑简体", Font.PLAIN, 19));
		jcbSearch.setOpaque(true);
		jcbSearch.setBackground(Color.WHITE);
		jcbSearch.setEditable(false);

		jtfSearch = new JTextField();
		jtfSearch.setBounds(400, 100, 230, 30);
		jcbSearch.setFont(new Font("方正兰亭超细黑简体", Font.PLAIN, 19));
		jcbSearch.setEditable(true);

		jbConfirm1 = new JButton();
		jbConfirm1.setBounds(681, 15, 90, 40);
		jbConfirm1.setText("确认");
		jbConfirm1.setFont(new Font("方正兰亭超细黑简体", Font.PLAIN, 19));
		jbConfirm1.addMouseListener(searchListener1);

		jbConfirm2 = new JButton();
		jbConfirm2.setBounds(681, 95, 90, 40);
		jbConfirm2.setText("确认");
		jbConfirm2.setFont(new Font("方正兰亭超细黑简体", Font.PLAIN, 19));
		jbConfirm2.addMouseListener(searchListener2);

		jbDetail = new JButton();
		jbDetail.setBounds(410, 13, 110, 40);
		jbDetail.setText("查看详细");
		jbDetail.setFont(new Font("方正兰亭超细黑简体", Font.PLAIN, 19));
		jbDetail.addMouseListener(detailListener);
		jbDetail.setEnabled(false);

		jbCheckin = new JButton();
		jbCheckin.setBounds(550, 13, 110, 40);
		jbCheckin.setText("入住");
		jbCheckin.setFont(new Font("方正兰亭超细黑简体", Font.PLAIN, 19));
		jbCheckin.setEnabled(false);

		jbCheckout = new JButton();
		jbCheckout.setBounds(690, 13, 110, 40);
		jbCheckout.setText("退房");
		jbCheckout.setFont(new Font("方正兰亭超细黑简体", Font.PLAIN, 19));
		jbCheckout.setEnabled(false);

		jbDelay = new JButton();
		jbDelay.setBounds(830, 13, 110, 40);
		jbDelay.setText("延迟入住");
		jbDelay.setFont(new Font("方正兰亭超细黑简体", Font.PLAIN, 19));
		jbDelay.setEnabled(false);

		List<OrderVO> orders = this.searchByOrderType("未执行");
		List<OrderVO> orders1 = this.searchByOrderType("已执行");
		List<OrderVO> orders2 = this.searchByOrderType("异常");
		List<OrderVO> orders3 = this.searchByOrderType("已撤销");
		if (orders1.size() != 0) {
			orders.addAll(orders1);
		}
		if (orders2.size() != 0) {
			orders.addAll(orders2);
		}
		if (orders2.size() != 0) {
			orders.addAll(orders3);
		}

		orderListTableModel = new OrderListTableModel(orders);

		jtOrderList = new JTable(orderListTableModel);
		jtOrderList.setBackground(new Color(211, 237, 249));
		jtOrderList.setFont(new Font("方正兰亭超细黑简体", Font.PLAIN, 16));
		jtOrderList.setRowHeight(40);
		jtOrderList.setShowVerticalLines(false);

		jthOrderList = jtOrderList.getTableHeader();
		jthOrderList.setPreferredSize(new Dimension(jtOrderList.getWidth(), 40));
		jthOrderList.setBackground(new Color(222, 237, 249));
		jthOrderList.setEnabled(false);
		jthOrderList.setBorder(new EmptyBorder(0, 0, 0, 0));
		jthOrderList.setFont(new Font("方正兰亭超细黑简体", Font.PLAIN, 16));

		jspOrderList = new JScrollPane(jtOrderList);
		jspOrderList.setBounds(10, 10, 1060, 452);
		jspOrderList.setHorizontalScrollBarPolicy(JScrollPane.HORIZONTAL_SCROLLBAR_AS_NEEDED);
		jspOrderList.setOpaque(false);
		jspOrderList.getViewport().setOpaque(false);
		jspOrderList.setBackground(Color.WHITE);

		jpSearch.add(jlOrderType);
		jpSearch.add(jlSearch);
		jpSearch.add(jcbOrderType);
		jpSearch.add(jcbSearch);
		jpSearch.add(jtfSearch);
		jpSearch.add(jbConfirm1);
		jpSearch.add(jbConfirm2);

		jpOrder.add(jspOrderList);

		jpButton.add(jbDetail);
		jpButton.add(jbCheckin);
		jpButton.add(jbCheckout);
		jpButton.add(jbDelay);

		this.add(jpSearch);
		this.add(jpOrder);
		this.add(jpButton);

		buttonThread();
	}

	public List<OrderVO> getAllOrders() {
		List<OrderVO> orders = this.searchByOrderType("未执行");
		List<OrderVO> orders1 = this.searchByOrderType("已执行");
		List<OrderVO> orders2 = this.searchByOrderType("异常");
		List<OrderVO> orders3 = this.searchByOrderType("已撤销");
		if (orders1.size() != 0) {
			orders.addAll(orders1);
		}
		if (orders2.size() != 0) {
			orders.addAll(orders2);
		}
		if (orders2.size() != 0) {
			orders.addAll(orders3);
		}

		return orders;
	}

	public void refreshOrderList(List<OrderVO> orderList) {
		orderListTableModel = new OrderListTableModel(orderList);
		jtOrderList.setModel(orderListTableModel);
	}

	public void refreshSearchTerms() {
		jcbOrderType.setSelectedIndex(0);
		jcbSearch.setSelectedIndex(0);
		jtfSearch.setText("");
	}

	public String getOrderType() {
		return (String) jcbOrderType.getSelectedItem();
	}

	public String getSearchInfo() {
		return (String) jcbSearch.getSelectedItem();
	}

	public String getUsername() {
		return jtfSearch.getText();
	}

	public String getOrderID() {
		return jtfSearch.getText();
	}

	public OrderVO getSelectedOrder() {
		int row = jtOrderList.getSelectedRow();
		int id = Integer.valueOf((String) jtOrderList.getValueAt(row, 0));
		OrderVO order = this.searchByOrderID(id).get(0);

		return order;
	}

	public List<OrderVO> searchByOrderType(String orderType) {
		List<OrderVO> orderList = new ArrayList<OrderVO>();
		List<OrderVO> orderList1 = new ArrayList<OrderVO>();
		List<OrderVO> orderList2 = new ArrayList<OrderVO>();

		if (orderType.equals("未执行")) {
			try {
				orderList = hotelOrderController.findOrderByHotelAndStatus(hotel.id, OrderStatus.Unexecuted);
			} catch (OrderNotFoundException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		} else if (orderType.equals("已执行")) {
			try {
				orderList = hotelOrderController.findOrderByHotelAndStatus(hotel.id, OrderStatus.Executed);
			} catch (OrderNotFoundException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		} else if (orderType.equals("异常")) {
			try {
				orderList = hotelOrderController.findOrderByHotelAndStatus(hotel.id, OrderStatus.Abnormal);
			} catch (OrderNotFoundException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		} else if (orderType.equals("已撤销")) {
			try {
				orderList = hotelOrderController.findOrderByHotelAndStatus(hotel.id, OrderStatus.RevokedFullValue);
			} catch (OrderNotFoundException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			try {
				orderList1 = hotelOrderController.findOrderByHotelAndStatus(hotel.id, OrderStatus.RevokedHalfValue);
			} catch (OrderNotFoundException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			try {
				orderList2 = hotelOrderController.findOrderByHotelAndStatus(hotel.id, OrderStatus.UserRevoked);
			} catch (OrderNotFoundException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}

			if (orderList1.size() != 0) {
				orderList.addAll(orderList1);
			}
			if (orderList2.size() != 0) {
				orderList.addAll(orderList2);
			}
		}

		return orderList;
	}

	public List<OrderVO> searchByUsername(String username) {
		List<OrderVO> orderList = new ArrayList<OrderVO>();

		try {
			orderList = hotelOrderController.findOrderByHotelAndUsername(hotel.id, username);
		} catch (OrderNotFoundException e) {
			// TODO Auto-generated catch block
			JOptionPane.showMessageDialog(this, "该用户不存在！", "错误", JOptionPane.WARNING_MESSAGE);
		}

		return orderList;
	}

	public List<OrderVO> searchByOrderID(int id) {
		List<OrderVO> orderList = new ArrayList<OrderVO>();
		OrderVO order;

		try {
			order = hotelOrderController.findOrderByID(id);
			orderList.add(order);
		} catch (OrderNotFoundException e) {
			// TODO Auto-generated catch block
			JOptionPane.showMessageDialog(this, "该订单不存在！", "错误", JOptionPane.WARNING_MESSAGE);
		}

		return orderList;
	}

	private void buttonThread() {
		Thread thread = new Thread(new Runnable() {

			@Override
			public void run() {
				while (true) {
					if (jtOrderList.getSelectedRowCount() == 0) {
						jbDetail.setEnabled(false);
						jbCheckin.setEnabled(false);
						jbCheckout.setEnabled(false);
						jbDelay.setEnabled(false);
					} else {
						jbDetail.setEnabled(true);
						jbCheckin.setEnabled(true);
						jbCheckout.setEnabled(true);
						jbDelay.setEnabled(true);
					}
					try {
						Thread.sleep(200);
					} catch (InterruptedException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
				}
			}
		});

		thread.start();

	}

}