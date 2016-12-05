package hrs.client.UI.UserUI.HotelSearchUI;

import java.awt.Color;
import java.awt.Font;
import java.util.List;

import javax.swing.JButton;
import javax.swing.JScrollPane;
import javax.swing.border.EmptyBorder;

import hrs.client.UI.UserUI.Components.ComNeedBackPanel;
import hrs.client.UI.UserUI.Components.CommonPanel;
import hrs.client.UI.UserUI.Components.CommonTable;
import hrs.client.UI.UserUI.HotelInfoUI.HotelDetailInfoPanel;
import hrs.client.UI.UserUI.HotelSearchUI.Listener.BackListener;
import hrs.client.UI.UserUI.HotelSearchUI.Listener.PlaceOrderListener;
import hrs.client.UI.UserUI.OrderInfoUI.OrderTableModel;
import hrs.client.util.ControllerFactory;
import hrs.client.util.UIConstants;
import hrs.common.Controller.UserController.IUserHotelController;
import hrs.common.Controller.UserController.IUserOrderController;
import hrs.common.Exception.OrderService.OrderNotFoundException;
import hrs.common.VO.HotelVO;
import hrs.common.VO.OrderVO;
import hrs.common.VO.RoomVO;
import hrs.common.VO.UserVO;

/**
 * 酒店详细信息显示界面
 * 含有HotelDetailInfoPanel,RoomTable,OrderTable
 * 
 * @author 涵
 *
 */
public class HotelDetailPanel extends CommonPanel {
	private static final long serialVersionUID = 7566236145344049160L;
	private HotelVO hotel;
	private List<RoomVO> rooms;
	private HotelDetailInfoPanel detailInfoPanel;
	private UserVO user;
	private IUserHotelController controller;
	private ComNeedBackPanel panel;
	Font font = UIConstants.JLABEL_FONT;
	public HotelDetailPanel(HotelVO hotel,List<RoomVO> rooms,UserVO user){
		controller = ControllerFactory.getUserHotelController();
		this.hotel = hotel;
		this.rooms = rooms;
		this.user = user;
		init();
	}
	public void setHotelPanel(HotelPanel panel){
		this.panel = panel;
	}
	@Override
	public void init() {
		setDetailInfo();
		setRoomTable();
		setOrderTable();
		setBackButton();

	}
	
	private void setBackButton() {
		
		JButton backJB = new JButton("返回");
		backJB.setFont(font);
		backJB.setBounds(this.getWidth() - 150, detailInfoPanel.getHeight()+300, 100, 40);
		backJB.addActionListener(new BackListener(this));
		add(backJB);	
		
	}
	
	public void setOrderButton(){
		JButton orderJB = new JButton("返回");
		orderJB.setFont(font);
		orderJB.setBounds(this.getWidth() - 280, detailInfoPanel.getHeight()+300, 100, 40);
		orderJB.addActionListener(new PlaceOrderListener(this));
		add(orderJB);	
	}
	private void setOrderTable() {
		CommonTable orderTable = new CommonTable();
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setViewportView(orderTable);
		scrollPane.setBounds(30,detailInfoPanel.getHeight()+160, detailInfoPanel.getWidth(), 120);
		 scrollPane.setBorder(new EmptyBorder(0, 0, 0, 0));
//		scrollPane.setBorder(BorderFactory.createLineBorder(new Color(145, 189, 214), 2));
		scrollPane.getViewport().setBackground(new Color(211, 237, 249));
		scrollPane.setOpaque(true);
		
		List<OrderVO> list = null;
		try {
			list = controller.findOrderByHotelAndUsername(hotel.id, user.username);
		} catch (OrderNotFoundException e) {
			System.out.println("无历史订单");
		}
		OrderTableModel model = new OrderTableModel(list);
		orderTable.setModel(model);
		add(scrollPane);
		
		
	}

	private void setDetailInfo() {
		detailInfoPanel = new HotelDetailInfoPanel(hotel);
		detailInfoPanel.setBounds(30, 30, detailInfoPanel.getWidth(), detailInfoPanel.getHeight());
		add(detailInfoPanel);
	}
	
	private void setRoomTable(){
		CommonTable roomTable = new CommonTable();
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setViewportView(roomTable);
		scrollPane.setBounds(30,detailInfoPanel.getHeight()+40, detailInfoPanel.getWidth(), 120);
		 scrollPane.setBorder(new EmptyBorder(0, 0, 0, 0));
//		scrollPane.setBorder(BorderFactory.createLineBorder(new Color(145, 189, 214), 2));
		scrollPane.getViewport().setBackground(new Color(211, 237, 249));
		scrollPane.setOpaque(true);
		
		RoomTableModel model = new RoomTableModel(rooms);
		roomTable.setModel(model);
		add(scrollPane);
	}
	public void back() {
		panel.back();
		
	}
	public void placeOrder() {
		panel.placeOrder();
		
	}
	

}
