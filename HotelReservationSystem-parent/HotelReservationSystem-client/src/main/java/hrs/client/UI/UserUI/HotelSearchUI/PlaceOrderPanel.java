package hrs.client.UI.UserUI.HotelSearchUI;

import java.awt.Color;
import java.awt.Font;
import java.util.List;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;

import hrs.client.UI.UserUI.Components.CommonLabel;
import hrs.client.UI.UserUI.Components.CommonPanel;
import hrs.client.UI.UserUI.HotelSearchUI.Listener.BackListener;
import hrs.client.util.UIConstants;
import hrs.common.VO.HotelVO;
import hrs.common.VO.OrderVO;
import hrs.common.VO.RoomVO;

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
	
	private HotelVO hotel;
	private List<RoomVO> rooms;
	private BeginAndLeaveTime orderTime;
	private HotelPanel hotelPanel;
	private JPanel infoPanel;
	
	public PlaceOrderPanel(HotelVO hotel,List<RoomVO> rooms,BeginAndLeaveTime orderTime){
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
		
	}

	private void setRigthLabel() {
		JLabel hotelNameJL = new CommonLabel("酒店名称", JLabel.LEFT);
		hotelNameJL.setBounds(RIGHTJL_X, JL_HEIGHT, JL_WIDTH, JL_HEIGHT);
		infoPanel.add(hotelNameJL);
		
		JLabel RoomTypeJL = new CommonLabel("房间类型", JLabel.LEFT);
		RoomTypeJL.setBounds(RIGHTJL_X, JL_HEIGHT*2, JL_WIDTH, JL_HEIGHT);
		infoPanel.add(RoomTypeJL);
		
		JLabel RoomNumJL = new CommonLabel("房间数量", JLabel.LEFT);
		RoomNumJL.setBounds(RIGHTJL_X, JL_HEIGHT*3, JL_WIDTH, JL_HEIGHT);
		infoPanel.add(RoomNumJL);
		
		JLabel PeopleNumJL = new CommonLabel("入住人数", JLabel.LEFT);
		PeopleNumJL.setBounds(RIGHTJL_X, JL_HEIGHT*4, JL_WIDTH, JL_HEIGHT);
		infoPanel.add(PeopleNumJL);
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
		JButton orderButton = new JButton("确认下单");
		orderButton.setFont(font);
		orderButton.setBounds(this.getWidth() - 700, 680, 120, 40);
		orderButton.addActionListener(new BackListener(this));
		add(orderButton);
		
	}

	private void setCancelButton() {
		JButton cancelButton = new JButton("取消");
		cancelButton.setFont(font);
		cancelButton.setBounds(this.getWidth() - 350, 680, 100, 40);
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
		// TODO Auto-generated method stub
		
	}
	


}
