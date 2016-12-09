package hrs.client.UI.UserUI.HotelSearchUI;

import java.awt.Color;
import java.awt.Font;
import java.util.Calendar;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.swing.BorderFactory;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;

import hrs.client.UI.UserUI.Components.CommonLabel;
import hrs.client.UI.UserUI.Components.CommonPanel;
import hrs.client.UI.UserUI.Components.CommonTable;
import hrs.client.UI.UserUI.HotelSearchUI.Listener.BackListener;
import hrs.client.UI.UserUI.HotelSearchUI.Listener.OrderButtonListener;
import hrs.client.UI.UserUI.HotelSearchUI.Listener.OrderDocumentListener;
import hrs.client.UI.UserUI.HotelSearchUI.Listener.OrderItemListener;
import hrs.client.UI.UserUI.HotelSearchUI.Listener.OrderRoomItemListener;
import hrs.client.util.ControllerFactory;
import hrs.client.util.EnumHelper;
import hrs.client.util.HMSBlueButton;
import hrs.client.util.UIConstants;
import hrs.common.Controller.UserController.IUserOrderController;
import hrs.common.VO.HotelDiscountVO;
import hrs.common.VO.HotelVO;
import hrs.common.VO.OrderVO;
import hrs.common.VO.RoomVO;
import hrs.common.VO.UserVO;
import hrs.common.VO.WebDiscountVO;
import hrs.common.util.DateHelper;
import hrs.common.util.type.OrderStatus;
import hrs.common.util.type.RoomType;

/**
 * 下单界面
 * @author 涵
 *
 */
public class PlaceOrderPanel extends CommonPanel {
	/**
	 * 
	 */
	private static final long serialVersionUID = 3247142230539015939L;
	
	private static int JL_HEIGHT = 40;//所有标签的高度均为40
	private static int JL_WIDTH = 126;//标签的宽度均为105
	private static int TEXT_H = 30;//输入域高度为30
	private static int GAP = (JL_HEIGHT-TEXT_H)/2;//输入域保持对齐的位置偏移
	
	private static int LEFTJL_X = 10;//左侧一列标签的起始x位置
	private static int RIGHTJL_X = 510;//右侧一列标签的起始x位置
	
	private static int LEFTIN_X = LEFTJL_X+JL_WIDTH;//左侧一列输入域的起始x位置
	private static int RIGHTIN_X = RIGHTJL_X+JL_WIDTH;//右侧一列输入域的起始x位置
	
	
	Font font = UIConstants.JLABEL_FONT;
	
	private CommonTable table;
	private HotelVO hotel;
	private List<RoomVO> rooms;
	private BeginAndLeaveTime orderTime;
	private HotelPanel hotelPanel;
	private JPanel infoPanel;
	private UserVO user;
	private IUserOrderController controller;
	private OrderVO order;
	
	private JComboBox<String> roomTypeBox;
	private JComboBox<String> arriveTmBox;
	private JComboBox<String> hasChildBox;
	
	private JTextField roomNumField;
	private JTextField peopleNumField;
	
	private JLabel initValue;
	private JLabel actualValue;
	private JLabel discountValue;
	private Double roomValue;
	
	public PlaceOrderPanel(HotelVO hotel,List<RoomVO> rooms,BeginAndLeaveTime orderTime,UserVO user){
		controller = ControllerFactory.getUserOrderController();
		this.user =user;
		this.hotel = hotel;
		this.rooms = rooms;
		this.orderTime = orderTime;
		init();
	}
	
	@Override
	public void init() {
		infoPanel = new JPanel();
		infoPanel.setBackground(UIConstants.JFRAME);
		infoPanel.setLayout(null);
		infoPanel.setBounds(30, 20, this.getWidth()-30, 650);
		infoPanel.setBorder(BorderFactory.createLineBorder(new Color(145, 189, 214),2));
		add(infoPanel);
		
		JLabel infoJL = new CommonLabel("订单信息", JLabel.LEFT);
		infoJL.setBackground(new Color(145, 179, 179));
		infoJL.setOpaque(true);
		infoJL.setBounds(0, 0, this.getWidth(), JL_HEIGHT);
		infoPanel.add(infoJL);
		
		setInfoPanel();
		setCancelButton();
		setOrderButton();
	}

	private void setInfoPanel() {
		setLeftLabel();
		setRigthLabel();
		
		setLeftInfo();
		setRightInfo();
		setDiscountTable();
		setValueLabel();
	}

	private void setRightInfo() {
		JLabel hotelName = new CommonLabel(hotel.name, JLabel.LEFT);
		hotelName.setBounds(RIGHTJL_X+JL_WIDTH, JL_HEIGHT, JL_WIDTH, JL_HEIGHT);
		infoPanel.add(hotelName);
		
		roomTypeBox = new JComboBox<>();
		for(int i = 0;i<rooms.size();i++){
			roomTypeBox.addItem(RoomType.toRoomName(rooms.get(i).type));
		}
		roomTypeBox.setBounds(RIGHTJL_X+JL_WIDTH, JL_HEIGHT*2+GAP, JL_WIDTH, TEXT_H);
		roomTypeBox.setFont(font);
		roomTypeBox.addItemListener(new OrderRoomItemListener(this));
		infoPanel.add(roomTypeBox);
		
		roomNumField = new JTextField("1");
		roomNumField.setFont(font);
		roomNumField.setBounds(RIGHTJL_X+JL_WIDTH, JL_HEIGHT*3+GAP, JL_WIDTH, TEXT_H);
		roomNumField.getDocument().addDocumentListener(new OrderDocumentListener(this));
		infoPanel.add(roomNumField);
		
		peopleNumField = new JTextField("1");
		peopleNumField.setText("1");
		peopleNumField.setFont(font);
		peopleNumField.setBounds(RIGHTJL_X+JL_WIDTH, JL_HEIGHT*4+GAP, JL_WIDTH, TEXT_H);
		peopleNumField.getDocument().addDocumentListener(new OrderDocumentListener(this));
		infoPanel.add(peopleNumField);
	}

	private void setLeftInfo() {
		JLabel placeTm = new CommonLabel(DateHelper.format(Calendar.getInstance().getTime()), JLabel.LEFT);
		placeTm.setBounds(LEFTJL_X+JL_WIDTH+GAP, JL_HEIGHT, JL_WIDTH, JL_HEIGHT);
		infoPanel.add(placeTm);
		
		JLabel checkInTm = new CommonLabel(DateHelper.format(orderTime.beginTime), JLabel.LEFT);
		checkInTm.setBounds(LEFTJL_X+JL_WIDTH+GAP, JL_HEIGHT*2, JL_WIDTH, JL_HEIGHT);
		infoPanel.add(checkInTm);
		
		
		arriveTmBox = new JComboBox<>();
		for(int i = 1;i<=24;i++){
			arriveTmBox.addItem(i+":00");
		}
		arriveTmBox.setBounds(LEFTJL_X+JL_WIDTH+GAP, JL_HEIGHT*3+GAP, JL_WIDTH, TEXT_H);
		arriveTmBox.setFont(font);
		arriveTmBox.addItemListener(new OrderItemListener(this));
		infoPanel.add(arriveTmBox);
		
		JLabel checkOutTm = new CommonLabel(DateHelper.format(orderTime.endTime), JLabel.LEFT);
		checkOutTm.setBounds(LEFTJL_X+JL_WIDTH+GAP, JL_HEIGHT*4, JL_WIDTH, JL_HEIGHT);
		infoPanel.add(checkOutTm);
		
		hasChildBox = new JComboBox<>();
		hasChildBox.addItem("无");
		hasChildBox.addItem("有");
		hasChildBox.setBounds(LEFTJL_X+JL_WIDTH+GAP, JL_HEIGHT*5+GAP, JL_WIDTH, TEXT_H);
		hasChildBox.setFont(font);
		hasChildBox.addItemListener(new OrderItemListener(this));
		infoPanel.add(hasChildBox);
	}

	/**
	 * 显示原价格和折扣后价格
	 */
	private void setValueLabel() {
		JLabel initValueJL = new CommonLabel("原价格",JLabel.LEFT);
		initValueJL.setBounds(this.getWidth() - 700,540,100,JL_HEIGHT);
		infoPanel.add(initValueJL);
		
		initValue = new CommonLabel(roomValue +"",JLabel.LEFT);
		initValue.setBounds(this.getWidth() - 500,540,100,JL_HEIGHT);
		infoPanel.add(initValue);
		
		JLabel discountJL = new CommonLabel("折扣金额",JLabel.LEFT);
		discountJL.setBounds(this.getWidth() - 700,570,100,JL_HEIGHT);
		infoPanel.add(discountJL);
		
		discountValue = new CommonLabel(order.value-roomValue+"",JLabel.LEFT);
		discountValue.setBounds(this.getWidth() - 500,570,100,JL_HEIGHT);
		infoPanel.add(discountValue);
		
		JLabel actualValueJL = new CommonLabel("最终价格",JLabel.LEFT);
		actualValueJL.setBounds(this.getWidth() - 700,600,100,JL_HEIGHT);
		infoPanel.add(actualValueJL);
		
		actualValue = new CommonLabel(order.value+"",JLabel.LEFT);
		actualValue.setBounds(this.getWidth() - 500,600,100,JL_HEIGHT);
		infoPanel.add(actualValue);
	}

	/**
	 * 显示折扣信息
	 * 以初始信息生成订单信息
	 */
	private void setDiscountTable() {
		String selectedType = (String) roomTypeBox.getSelectedItem();
		RoomType type = EnumHelper.toRoomType(selectedType);
		order = new OrderVO();
		
		//设置订单的抵达时间，具体时刻默认为1:00
		Calendar calendar = Calendar.getInstance();
		calendar.setTime(orderTime.beginTime);
		calendar.set(Calendar.HOUR, 01);
		calendar.set(Calendar.MINUTE,00);
		order.execTime = calendar.getTime();
		order.expectedCheckoutTime = orderTime.endTime;
		
		//设置订单里的初始值
		order.hasChild = false;
		order.status = OrderStatus.Unexecuted;
		order.hotel = hotel;
		order.roomNum = 1;
		order.peopleNum = 1;
		order.placeTime = Calendar.getInstance().getTime();
		order.user = user;
		String roomstr = (String)roomTypeBox.getSelectedItem();
		RoomType roomType = RoomType.getRoomType(roomstr);
		order.type = roomType;
		
		//得到当前选中的房间信息
		RoomVO roomVO = new RoomVO();
		for(int i = 0;i<rooms.size();i++){
			if(rooms.get(i).type.equals(roomType)){
				roomVO = rooms.get(i);
				break;
			}
		}

		//订单价值设为选中房间的价格
		roomValue = roomVO.roomValue;
		order.value = roomValue;
		
		//设置订单，将可以享受的优惠加入订单中
		order = controller.placeOrder(order);
		
		//设置表格显示享受的优惠及折扣额度
		table = new CommonTable();
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setViewportView(table);
		scrollPane.setBounds(10, 300, this.getWidth()-60, 200);
		scrollPane.setBorder(new EmptyBorder(0, 0, 0, 0));
		scrollPane.getViewport().setBackground(new Color(211, 237, 249));
		scrollPane.setOpaque(true);
		
		Map<WebDiscountVO, Double> webdiscounts = order.webDiscounts;
		Map<HotelDiscountVO, Double> hoteldiscounts = order.hotelDiscounts;
		
		
		table.setModel(new DiscountTableModel(webdiscounts, hoteldiscounts));
		infoPanel.add(scrollPane);
	}

	private void setRigthLabel() {
		JLabel hotelNameJL = new CommonLabel("酒店名称", JLabel.LEFT);
		hotelNameJL.setBounds(RIGHTJL_X, JL_HEIGHT, JL_WIDTH, JL_HEIGHT);
		infoPanel.add(hotelNameJL);
		
		JLabel roomTypeJL = new CommonLabel("房间类型", JLabel.LEFT);
		roomTypeJL.setBounds(RIGHTJL_X, JL_HEIGHT*2, JL_WIDTH, JL_HEIGHT);
		infoPanel.add(roomTypeJL);
		
		JLabel roomNumJL = new CommonLabel("房间数量", JLabel.LEFT);
		roomNumJL.setBounds(RIGHTJL_X, JL_HEIGHT*3, JL_WIDTH, JL_HEIGHT);
		infoPanel.add(roomNumJL);
		
		JLabel peopleNumJL = new CommonLabel("入住人数", JLabel.LEFT);
		peopleNumJL.setBounds(RIGHTJL_X, JL_HEIGHT*4, JL_WIDTH, JL_HEIGHT);
		infoPanel.add(peopleNumJL);
	}

	private void setLeftLabel() {
		JLabel placeTmJL = new CommonLabel("下单时间", JLabel.LEFT);
		placeTmJL.setBounds(LEFTJL_X, JL_HEIGHT, JL_WIDTH, JL_HEIGHT);
		infoPanel.add(placeTmJL);
		
		JLabel checkInTmJL = new CommonLabel("入住时间", JLabel.LEFT);
		checkInTmJL.setBounds(LEFTJL_X, JL_HEIGHT*2, JL_WIDTH, JL_HEIGHT);
		infoPanel.add(checkInTmJL);
		
		JLabel arriveTmJL = new CommonLabel("最晚抵店", JLabel.LEFT);
		arriveTmJL.setBounds(LEFTJL_X, JL_HEIGHT*3, JL_WIDTH, JL_HEIGHT);
		infoPanel.add(arriveTmJL);
		
		JLabel checkOutTmJL = new CommonLabel("预计离开时间", JLabel.LEFT);
		checkOutTmJL.setBounds(LEFTJL_X, JL_HEIGHT*4, JL_WIDTH, JL_HEIGHT);
		infoPanel.add(checkOutTmJL);
		
		JLabel hasChildJL = new CommonLabel("有无儿童", JLabel.LEFT);
		hasChildJL.setBounds(LEFTJL_X, JL_HEIGHT*5, JL_WIDTH, JL_HEIGHT);
		infoPanel.add(hasChildJL);
	}

	private void setOrderButton() {
		HMSBlueButton orderButton = new HMSBlueButton("确认下单");
//		orderButton.setFont(font);
		orderButton.setBounds(this.getWidth() - 750, 680, 120, 40);
		orderButton.addActionListener(new OrderButtonListener(this));
		add(orderButton);
		
	}

	private void setCancelButton() {
		HMSBlueButton cancelButton = new HMSBlueButton("取消");
//		cancelButton.setFont(font);
		cancelButton.setBounds(this.getWidth() - 400, 680, 100, 40);
		cancelButton.addActionListener(new BackListener(this));
		add(cancelButton);
		
	}

	public void setPanel(HotelPanel hotelPanel) {
		this.hotelPanel = hotelPanel;
	}

	/**
	 * 返回操作
	 */
	@Override
	public void back() {
		hotelPanel.back();
	}
	
	/*
	 * 下单操作
	 * 
	 */
	public void order() {
		
		int result = JOptionPane.showConfirmDialog(null, "是否确认下单？", "提示", JOptionPane.YES_NO_OPTION);
		if(result == JOptionPane.YES_OPTION){
			controller.addOrder(order);
			JOptionPane.showMessageDialog(null, "您已成功下单！"+"可以随时从订单管理里查看修改您的订单", "提示", JOptionPane.INFORMATION_MESSAGE);
		}
		
		
		
	}
	
	public void setOrderInfo(){
		//修改订单里是否有孩子的选项
		String hasChild = (String)hasChildBox.getSelectedItem();
		if(hasChild.equals("有")){
			order.hasChild = true;
		}
		else{
			order.hasChild = false;
		}
		
		//修改订单里执行时间的小时数字
		String time = (String)arriveTmBox.getSelectedItem();
		String[] arriveTime = time.split(":");
		time = arriveTime[0];
		Calendar calendar = Calendar.getInstance();
		calendar.setTime(order.checkinTime);
		calendar.set(Calendar.HOUR, Integer.parseInt(time));
		order.execTime = calendar.getTime();
		
	}
	
	public void change(){
		
		
		String roomstr = (String)roomTypeBox.getSelectedItem();
		RoomType roomType = RoomType.getRoomType(roomstr);
		order.type = roomType;
		RoomVO roomVO = new RoomVO();
		for(int i = 0;i<rooms.size();i++){
			if(rooms.get(i).type.equals(roomType)){
				roomVO = rooms.get(i);
				break;
			}
		}
		order.value = roomVO.roomValue;
		
		if(isTextValid(roomNumField.getText())){
			order.roomNum = Integer.parseInt(roomNumField.getText());
		}
		if(isTextValid(peopleNumField.getText())){
			order.peopleNum = Integer.parseInt(peopleNumField.getText());
		}
		order.value = roomVO.roomValue * order.roomNum;
		initValue.setText(order.value+"");
		order.hotelDiscounts = new HashMap<>();
		order.webDiscounts = new HashMap<>();
		
		order = controller.placeOrder(order);
		table.setModel(new DiscountTableModel(order.webDiscounts, order.hotelDiscounts));
		
		discountValue.setText(order.value - roomVO.roomValue * order.roomNum+"");
		actualValue.setText(order.value+"");
		
	}
	
	private boolean isTextValid(String str){
		if(str.equals("")){
			return false;
		}
		else
			return true;
	}

}
