package hrs.client.UI.HotelUI.HotelUI;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ItemListener;
import java.awt.event.MouseListener;
import java.util.List;

import javax.swing.DefaultComboBoxModel;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.border.EmptyBorder;

import hrs.client.UI.HotelUI.HotelUI.Listener.CancelListener;
import hrs.client.UI.HotelUI.HotelUI.Listener.CityListener;
import hrs.client.UI.HotelUI.HotelUI.Listener.EditListener;
import hrs.client.util.ControllerFactory;
import hrs.common.Controller.HotelController.IHotelController;
import hrs.common.Controller.UserController.IUserHotelController;
import hrs.common.VO.CommercialCircleVO;
import hrs.common.VO.HotelVO;
import hrs.common.VO.LocationVO;

public class HotelUIPanel extends JPanel {

	private JPanel jpHotelInfo;
	private JPanel jpButton;
	private JScrollPane jspIntro;
	private JScrollPane jspService;
	private JLabel jlHotelName;
	private JLabel jlCity;
	private JLabel jlCircle;
	private JLabel jlAddress;
	private JLabel jlIntro;
	private JLabel jlService;
	private JLabel jlStar;
	private JLabel jlScore;
	private JTextField jtfHotelName;
	private JTextField jtfAddress;
	private JTextField jtfScore;
	private JComboBox<String> jcbCity;
	private JComboBox<String> jcbCircle;
	private JTextArea jtaIntro;
	private JTextArea jtaService;
	private JComboBox jcbStar;
	private JButton jbEdit;
	private JButton jbCancel;
	private EditListener editListener;
	private CancelListener cancelListener;
	private CityListener cityListener;
	private HotelVO hotel;
	private IHotelController hotelController;
	private List<LocationVO> city;
	List<CommercialCircleVO> circle;
	
	/**
	 * 初始化酒店信息界面面板
	 */
	public HotelUIPanel(HotelVO hotel) {
		init(hotel);
		showHotelInfo();
	}

	public void init(HotelVO hotel){
		this.hotel = hotel;
		this.setSize(1080, 722);
		this.setLayout(null);
		
		hotelController = ControllerFactory.getHotelController();
		
		jpHotelInfo = new JPanel();
		jpHotelInfo.setBounds(0, 0, 1080, 642);
		jpHotelInfo.setBackground(new Color(211, 237, 249));
		jpHotelInfo.setLayout(null);
		
		jpButton = new JPanel();
		jpButton.setBounds(0, 642, 1080, 80);
		jpButton.setBackground(new Color(211, 237, 249));
		jpButton.setLayout(null);
		
		jlHotelName = new JLabel();
		jlHotelName.setBounds(30, 20, 90, 30);
		jlHotelName.setText("酒店名称");
		jlHotelName.setHorizontalAlignment(SwingConstants.CENTER);
		jlHotelName.setFont(new Font("方正兰亭超细黑简体", Font.PLAIN, 19));
		
		jlCity = new JLabel();
		jlCity.setBounds(30, 70, 90, 30);
		jlCity.setText("城市");
		jlCity.setHorizontalAlignment(SwingConstants.CENTER);
		jlCity.setFont(new Font("方正兰亭超细黑简体", Font.PLAIN, 19));
		
		jlCircle = new JLabel();
		jlCircle.setBounds(30, 120, 90, 30);
		jlCircle.setText("商圈");
		jlCircle.setHorizontalAlignment(SwingConstants.CENTER);
		jlCircle.setFont(new Font("方正兰亭超细黑简体", Font.PLAIN, 19));
		
		jlAddress = new JLabel();
		jlAddress.setBounds(30, 170, 90, 30);
		jlAddress.setText("地址");
		jlAddress.setHorizontalAlignment(SwingConstants.CENTER);
		jlAddress.setFont(new Font("方正兰亭超细黑简体", Font.PLAIN, 19));
		
		jlIntro = new JLabel();
		jlIntro.setBounds(30, 220, 90, 30);
		jlIntro.setText("简介");
		jlIntro.setHorizontalAlignment(SwingConstants.CENTER);
		jlIntro.setFont(new Font("方正兰亭超细黑简体", Font.PLAIN, 19));
		
		jlService = new JLabel();
		jlService.setBounds(30, 420, 90, 30);
		jlService.setText("设施服务");
		jlService.setHorizontalAlignment(SwingConstants.CENTER);
		jlService.setFont(new Font("方正兰亭超细黑简体", Font.PLAIN, 19));
		
		jlStar = new JLabel();
		jlStar.setBounds(30, 550, 90, 30);
		jlStar.setText("星级");
		jlStar.setHorizontalAlignment(SwingConstants.CENTER);
		jlStar.setFont(new Font("方正兰亭超细黑简体", Font.PLAIN, 19));
		
		jlScore = new JLabel();
		jlScore.setBounds(30, 600, 90, 30);
		jlScore.setText("评分");
		jlScore.setHorizontalAlignment(SwingConstants.CENTER);
		jlScore.setFont(new Font("方正兰亭超细黑简体", Font.PLAIN, 19));
		
		jtfHotelName = new JTextField();
		jtfHotelName.setBounds(150, 20, 359, 30);
		jtfHotelName.setFont(new Font("方正兰亭超细黑简体", Font.PLAIN, 19));
		jtfHotelName.setEditable(true);
		
		cityListener = new CityListener(this);
		
		jcbCity = new JComboBox();
		jcbCity.setBounds(150, 70, 172, 30);
		jcbCity.setFont(new Font("方正兰亭超细黑简体", Font.PLAIN, 19));
		jcbCity.setOpaque(true);
		jcbCity.setBackground(Color.WHITE);
		jcbCity.setEditable(false);
		jcbCity.addItemListener((ItemListener) cityListener);
		
		jcbCircle = new JComboBox();
		jcbCircle.setBounds(150, 120, 172, 30);
		jcbCircle.setFont(new Font("方正兰亭超细黑简体", Font.PLAIN, 19));
		jcbCircle.setOpaque(true);
		jcbCircle.setBackground(Color.WHITE);
		jcbCircle.setEditable(false);
		
		city = hotelController.findAllLocations();
		circle = hotelController.findCircleByLoc(hotel.location.id);
		int citySize = city.size();
		int circleSize = circle.size();
		String[] citys = new String[citySize];
		String[] circles = new String[circleSize];
		
		for(int i=0;i<citySize;i++){
			citys[i] = city.get(i).name;
			jcbCity.addItem(citys[i]);
		}
		for(int i=0;i<circleSize;i++){
			circles[i] = circle.get(i).name;
			jcbCircle.addItem(circles[i]);
		}
		
		jtfAddress = new JTextField();
		jtfAddress.setBounds(150, 170, 853, 30);
		jtfAddress.setFont(new Font("方正兰亭超细黑简体", Font.PLAIN, 19));
		jtfAddress.setEditable(true);
		
		jtaIntro = new JTextArea();
		jtaIntro.setFont(new Font("方正兰亭超细黑简体", Font.PLAIN, 19));
		jtaIntro.setEditable(true);
		jtaIntro.setLineWrap(true);
		
		jspIntro = new JScrollPane(jtaIntro);
		jspIntro.setBounds(150, 220, 853, 180);
		jspIntro.setHorizontalScrollBarPolicy(JScrollPane.HORIZONTAL_SCROLLBAR_AS_NEEDED);
		
		jtaService = new JTextArea();
		jtaService.setFont(new Font("方正兰亭超细黑简体", Font.PLAIN, 19));
		jtaService.setEditable(true);
		jtaService.setLineWrap(true);
		
		jspService = new JScrollPane(jtaService);
		jspService.setBounds(150, 420, 853, 110);
		jspService.setHorizontalScrollBarPolicy(JScrollPane.HORIZONTAL_SCROLLBAR_AS_NEEDED);
		
		jcbStar = new JComboBox(new DefaultComboBoxModel(new String[] {"1", "2", "3", "4", "5"}));
		jcbStar.setBounds(150, 550, 105, 30);
		jcbStar.setFont(new Font("方正兰亭超细黑简体", Font.PLAIN, 19));
		jcbStar.setOpaque(true);
		jcbStar.setBackground(Color.WHITE);
		jcbStar.setEditable(false);
		
		jtfScore = new JTextField();
		jtfScore.setBounds(150, 600, 105, 30);
		jtfScore.setFont(new Font("方正兰亭超细黑简体", Font.PLAIN, 19));
		jtfScore.setBorder(new EmptyBorder(0, 0, 0, 0));
		jtfScore.setBackground(new Color(211, 237, 249));
		jtfScore.setEditable(false);
		
		editListener = new EditListener(this);

		cancelListener = new CancelListener(this);
		
		jbEdit = new JButton();
		jbEdit.setBounds(251, 17, 110, 50);
		jbEdit.setText("修改");
		jbEdit.setFont(new Font("方正兰亭超细黑简体", Font.PLAIN, 19));
		jbEdit.addMouseListener(editListener);
		
		jbCancel = new JButton();
		jbCancel.setBounds(606, 17, 110, 50);
		jbCancel.setText("取消");
		jbCancel.setFont(new Font("方正兰亭超细黑简体", Font.PLAIN, 19));
		jbCancel.addMouseListener(cancelListener);
		
		jpHotelInfo.add(jlHotelName);
		jpHotelInfo.add(jlCity);
		jpHotelInfo.add(jlCircle);
		jpHotelInfo.add(jlAddress);
		jpHotelInfo.add(jlIntro);
		jpHotelInfo.add(jlService);
		jpHotelInfo.add(jlStar);
		jpHotelInfo.add(jlScore);
		jpHotelInfo.add(jtfHotelName);
		jpHotelInfo.add(jcbCity);
		jpHotelInfo.add(jcbCircle);
		jpHotelInfo.add(jtfAddress);
		jpHotelInfo.add(jspIntro);
		jpHotelInfo.add(jspService);
		jpHotelInfo.add(jcbStar);
		jpHotelInfo.add(jtfScore);
		
		jpButton.add(jbEdit);
		jpButton.add(jbCancel);
		
		this.add(jpHotelInfo);
		this.add(jpButton);
	}
	
	/**
	 * 显示酒店信息
	 */
	public void showHotelInfo(){
		jtfHotelName.setText(hotel.name);
		jcbCity.setSelectedItem(hotel.location.name);
		jcbCircle.setSelectedItem(hotel.commercialCircle.name);
		jtfAddress.setText(hotel.street);
		jtaIntro.setText(hotel.profile);
		jtaService.setText(hotel.service);
		jcbStar.setSelectedItem(Integer.toString(hotel.star));
		jtfScore.setText(Double.toString(hotel.score));
	}
	
	/**
	 * 更新酒店信息
	 */
	public void updateHotelInfo(){
		int i;
		int citySize = city.size();
		int circleSize = circle.size();
		int value = JOptionPane.showConfirmDialog(this, "您确定要修改酒店信息吗？", "请确认修改", JOptionPane.OK_CANCEL_OPTION, JOptionPane.QUESTION_MESSAGE);
		
		if(value == JOptionPane.OK_OPTION){
			hotel.name = jtfHotelName.getText();
			
			for(i=0;i<citySize;i++){
				if(city.get(i).name.equals(jcbCity.getSelectedItem())){
					hotel.location = city.get(i);
					break;
				}
			}
			
			for(i=0;i<circleSize;i++){
				if(circle.get(i).name.equals(jcbCircle.getSelectedItem())){
					hotel.commercialCircle = circle.get(i);
					break;
				}
			}
			
			hotel.street = jtfAddress.getText();
			hotel.profile = jtaIntro.getText();
			hotel.service = jtaService.getText();
			hotel.star = Integer.valueOf((String) jcbStar.getSelectedItem());
			
			hotelController.updateHotel(hotel);
			
			JOptionPane.showMessageDialog(this, "酒店信息已更新！", "更新成功", JOptionPane.INFORMATION_MESSAGE);
		}
		else if(value == JOptionPane.CANCEL_OPTION){
			this.showHotelInfo();
		}
	}
	
	/**
	 * 酒店所选城市发生改变后，商圈下拉列表框中的选项也要发生改变
	 */
	public void changeCircle(){
		jcbCircle.removeAllItems();
		
		int i, citySize, circleSize;
		String newCity =(String)jcbCity.getSelectedItem();
		LocationVO theNewCity = null;
		
		citySize = city.size();
		
		for(i=0;i<citySize;i++){
			if(city.get(i).name.equals(newCity)){
				theNewCity = city.get(i);
				break;
			}
		}
		
		circle = hotelController.findCircleByLoc(theNewCity.id);
		circleSize = circle.size();
		String[] circles = new String[circleSize];
		for(i=0;i<circleSize;i++){
			circles[i] = circle.get(i).name;
			jcbCircle.addItem(circles[i]);
		}
	}
}
