package hrs.client.UI.UserUI.HotelSearchUI;

import java.awt.Color;
import java.util.List;

import javax.swing.BorderFactory;
import javax.swing.ButtonModel;
import javax.swing.ImageIcon;
import javax.swing.JCheckBox;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

import android.R.integer;
import hrs.client.UI.UserUI.CommonComponents.CommonLabel;
import hrs.client.util.ControllerFactory;
import hrs.client.util.DateChoosePanel;
import hrs.client.util.UIConstants;
import hrs.common.Controller.UserController.IUserHotelController;
import hrs.common.VO.CommercialCircleVO;
import hrs.common.VO.LocationVO;
/**
 * 查询条件 面板
 * 大小为1000*280
 * @author 涵
 *
 */
public class SearchPanel extends JPanel {
	private IUserHotelController controller = ControllerFactory.getUserHotelController();
	List<LocationVO> locList;
	
	private static int JL_HEIGHT = 40;//所有标签的高度均为40
	private static int JL_WIDTH = 105;//标签的高度均为40
	private static int TEXT_H = 30;//输入域高度为30
	private static int GAP = (JL_HEIGHT-TEXT_H)/2;//输入域保持对齐的位置偏移
	
	private static int LEFTJL_X = 10;//左侧一列标签的起始x位置
	private static int RIGHTJL_X = 510;//右侧一列标签的起始x位置
	
	private static int LEFTIN_X = LEFTJL_X+JL_WIDTH;//左侧一列输入域的起始x位置
	private static int RIGHTIN_X = RIGHTJL_X+JL_WIDTH;//右侧一列输入域的起始x位置
	
	
	private JComboBox<String> cityBox;//城市选择框
	private JComboBox<String> commercialBox;//城市选择框
	private DateChoosePanel checkInDate;//入住时间选择面板
	private DateChoosePanel checkIOutDate;//退房时间选择面板
	private JComboBox<String> roomTypeBox;//房间类型选框
	private JTextField roomNumField;//房间数量
	private TwoFieldPanel valueField;//价格区间
	private TwoFieldPanel scoreField;//评分区间
	private JComboBox<Integer> starBox;//星级选框
	private JTextField hotelNameField;//酒店名称输入区
	private JCheckBox hasOrderedBox;
	
	public SearchPanel(){
		Init();
	}

	private void Init() {
		setSize(1020,286);
		setLayout(null);
		setBackground(UIConstants.jframe);
		setBorder(BorderFactory.createLineBorder(new Color(145, 189, 214),3));
		
		JLabel conditionJL = new CommonLabel("查询条件", JLabel.LEFT);
		conditionJL.setBackground(new Color(145, 179, 179));
		conditionJL.setOpaque(true);
		conditionJL.setBounds(0, 0, this.getWidth(), JL_HEIGHT);
		add(conditionJL);
		
		setLeftLabel();
		setRightLabel();
		setLeftText();//左边输入区域初始化
		setRightText();//右侧输入区域初始化
		
	}

	private void setRightText() {
		commercialBox = new JComboBox<>();
		commercialBox.setBounds(RIGHTIN_X, JL_HEIGHT+GAP, 150, TEXT_H);
		commercialBox.setFont(UIConstants.jlabelChinese);
		LocationVO defauleLoc = controller.findAllLocations().get(0);//将得到的位置列表中第一个设为默认位置
		List<CommercialCircleVO> commercials = controller.findCircleByLoc(defauleLoc.id);
		for(int i = 0;i<commercials.size();i++){
			commercialBox.addItem(commercials.get(i).name);
		}
		add(commercialBox);
		
		checkIOutDate = new DateChoosePanel();
		checkIOutDate.setBounds(RIGHTIN_X, JL_HEIGHT*2, checkInDate.getWidth(), checkInDate.getHeight());
		add(checkIOutDate);
		
		roomNumField = new JTextField();
		roomNumField.setBounds(RIGHTIN_X, JL_HEIGHT*3+GAP, 150, TEXT_H);
		roomNumField.setFont(UIConstants.jlabelChinese);
		add(roomNumField);
		
		scoreField = new TwoFieldPanel();
		scoreField.setBounds(RIGHTIN_X, JL_HEIGHT*4, scoreField.getWidth(), scoreField.getHeight());
		add(scoreField);
		
		hasOrderedBox = new JCheckBox("我曾预订过的酒店");
		hasOrderedBox.setFont(UIConstants.jlabelChinese);
		hasOrderedBox.setBackground(UIConstants.jframe);
		hasOrderedBox.setSelected(false);//默认未选中
		hasOrderedBox.setBounds(RIGHTJL_X, JL_HEIGHT*5, 200, 40);
		add(hasOrderedBox);
	}

	private void setLeftText() {
		cityBox = new JComboBox<>();
		List<LocationVO> locs = controller.findAllLocations();
		for(int i = 0;i<locs.size();i++){
			cityBox.addItem(locs.get(i).name);
		}
		cityBox.setFont(UIConstants.jlabelChinese);
		cityBox.setBounds(LEFTIN_X, JL_HEIGHT+GAP, 150, TEXT_H);
		cityBox.setSelectedItem(locs.get(0).name);
		add(cityBox);
		
		checkInDate = new DateChoosePanel();
		checkInDate.setBounds(LEFTIN_X, JL_HEIGHT*2, checkInDate.getWidth(), checkInDate.getHeight());
		add(checkInDate);
		
		roomTypeBox = new JComboBox<>();
		roomTypeBox.addItem("商务标间");
		roomTypeBox.addItem("豪华房");
		roomTypeBox.addItem("双人房");
		roomTypeBox.addItem("单人房");
		roomTypeBox.addItem("标准房");
		roomTypeBox.addItem("大床房");
		roomTypeBox.addItem("行政标间");
		roomTypeBox.setBounds(LEFTIN_X, JL_HEIGHT*3+GAP, 150, TEXT_H);
		roomTypeBox.setFont(UIConstants.jlabelChinese);
		add(roomTypeBox);
		
		valueField = new TwoFieldPanel();
		valueField.setBounds(LEFTIN_X, JL_HEIGHT*4, valueField.getWidth(), valueField.getHeight());
		add(valueField);
		
		starBox = new JComboBox<>();
		for(Integer i = 1;i<=5;i++){
			starBox.addItem(i);
		}
		starBox.setFont(UIConstants.jlabelChinese);
		starBox.setBounds(LEFTIN_X, JL_HEIGHT*5+GAP, 60, TEXT_H);
		add(starBox);
		
		hotelNameField = new JTextField();
		hotelNameField.setBounds(LEFTIN_X, JL_HEIGHT*6+GAP, 300, TEXT_H);
		hotelNameField.setFont(UIConstants.jlabelChinese);
		add(hotelNameField);
	}

	private void setRightLabel() {
		
		JLabel commercialJL = new CommonLabel("商       圈*", JLabel.LEFT);
		commercialJL.setBounds(RIGHTJL_X, JL_HEIGHT, JL_WIDTH, JL_HEIGHT);
		add(commercialJL);
		
		JLabel checkOutJL = new CommonLabel("退房时间*", JLabel.LEFT);
		checkOutJL.setBounds(RIGHTJL_X, JL_HEIGHT*2, JL_WIDTH, JL_HEIGHT);
		add(checkOutJL);
		
		JLabel roomNumJL = new CommonLabel("房间数量", JLabel.LEFT);
		roomNumJL.setBounds(RIGHTJL_X, JL_HEIGHT*3, JL_WIDTH, JL_HEIGHT);
		add(roomNumJL);
		
		JLabel scoreJL = new CommonLabel("评分区间", JLabel.LEFT);
		scoreJL.setBounds(RIGHTJL_X, JL_HEIGHT*4, JL_WIDTH, JL_HEIGHT);
		add(scoreJL);
		
//		JLabel hasOrderedJL = new CommonLabel("我曾预订过的酒店", JLabel.LEFT);
//		hasOrderedJL.setBounds(RIGHTJL_X, JL_HEIGHT*5,168, JL_HEIGHT);
//		add(hasOrderedJL);
	}

	private void setLeftLabel() {
		
		
		JLabel cityJL = new CommonLabel("城       市*", JLabel.LEFT);
		cityJL.setBounds(LEFTJL_X, JL_HEIGHT, JL_WIDTH, JL_HEIGHT);
		add(cityJL);
		
		JLabel checkInJL = new CommonLabel("入住时间*", JLabel.LEFT);
		checkInJL.setBounds(LEFTJL_X, JL_HEIGHT*2, JL_WIDTH, JL_HEIGHT);
		add(checkInJL);
		
		JLabel roomTypeJL = new CommonLabel("房间类型", JLabel.LEFT);
		roomTypeJL.setBounds(LEFTJL_X, JL_HEIGHT*3, JL_WIDTH, JL_HEIGHT);
		add(roomTypeJL);
		
		JLabel valueJL = new CommonLabel("价格区间", JLabel.LEFT);
		valueJL.setBounds(LEFTJL_X, JL_HEIGHT*4, JL_WIDTH, JL_HEIGHT);
		add(valueJL);
		
		JLabel starJL = new CommonLabel("酒店星级", JLabel.LEFT);
		starJL.setBounds(LEFTJL_X, JL_HEIGHT*5, JL_WIDTH, JL_HEIGHT);
		add(starJL);
		
		JLabel hotelNameJL = new CommonLabel("酒店名称", JLabel.LEFT);
		hotelNameJL.setBounds(LEFTJL_X, JL_HEIGHT*6, JL_WIDTH, JL_HEIGHT);
		add(hotelNameJL);
		
		
	}
	
}
