package hrs.client.UI.UserUI.Components;

import java.awt.Color;
import java.awt.Font;
import java.util.List;

import javax.swing.JButton;
import javax.swing.JScrollPane;
import javax.swing.border.EmptyBorder;

import org.dom4j.tree.BackedList;

import hrs.client.UI.UserUI.HotelInfoUI.HotelDetailInfoPanel;
import hrs.client.UI.UserUI.HotelInfoUI.Listener.DetailInfoListener;
import hrs.client.UI.UserUI.HotelInfoUI.Listener.HotelBackListener;
import hrs.client.UI.UserUI.OrderInfoUI.OrderTableModel;
import hrs.client.util.ControllerFactory;
import hrs.client.util.UIConstants;
import hrs.common.Controller.UserController.IUserHotelController;
import hrs.common.Exception.OrderService.OrderNotFoundException;
import hrs.common.VO.HotelVO;
import hrs.common.VO.OrderVO;
import hrs.common.VO.RoomVO;
import hrs.common.VO.UserVO;

public class ComHotelDetail extends CommonPanel {
	protected ComNeedBackPanel panel;
	protected HotelDetailInfoPanel detailInfoPanel;
	protected IUserHotelController controller;
	protected UserVO user;
	protected HotelVO hotel;
	protected List<RoomVO> rooms;
	protected JScrollPane orderScrollPane;
	Font font = UIConstants.JLABEL_FONT;

	public ComHotelDetail(HotelVO hotel, UserVO user) {
		this.user = user;
		this.hotel = hotel;
	}

	public ComHotelDetail(HotelVO hotel, List<RoomVO> rooms, UserVO user) {
		this.hotel = hotel;
		this.rooms = rooms;
		this.user = user;
	}

	public void setPanel(ComNeedBackPanel panel) {
		this.panel = panel;
	}

	@Override
	public void init() {

	}

	protected void setBackButton() {

		JButton backJB = new JButton("返回");
		backJB.setFont(font);
		backJB.setBounds(this.getWidth() - 150, detailInfoPanel.getHeight() + 360, 100, 40);
		backJB.addActionListener(new HotelBackListener(this));
		add(backJB);

	}

	protected void setDetailInfo() {
		detailInfoPanel = new HotelDetailInfoPanel(hotel);
		detailInfoPanel.setBounds(30, 30, detailInfoPanel.getWidth(), detailInfoPanel.getHeight());
		add(detailInfoPanel);

	}

	public void back() {
		panel.back();

	}

	protected void setOrderTable() {
		CommonTable orderTable = new CommonTable();
		controller = ControllerFactory.getUserHotelController();

		orderScrollPane = new JScrollPane();
		orderScrollPane.setViewportView(orderTable);
		orderScrollPane.setBounds(30, detailInfoPanel.getHeight()+180, detailInfoPanel.getWidth(), 120);
		orderScrollPane.setBorder(new EmptyBorder(0, 0, 0, 0));
		// scrollPane.setBorder(BorderFactory.createLineBorder(new Color(145,
		// 189, 214), 2));
		orderScrollPane.getViewport().setBackground(new Color(211, 237, 249));
		orderScrollPane.setOpaque(true);

		List<OrderVO> list = null;
		try {
			list = controller.findOrderByHotelAndUsername(hotel.id, user.username);
		} catch (OrderNotFoundException e) {
			System.out.println("无历史订单");
		}
		OrderTableModel model = new OrderTableModel(list);
		orderTable.setModel(model);
		add(orderScrollPane);

	}

}
