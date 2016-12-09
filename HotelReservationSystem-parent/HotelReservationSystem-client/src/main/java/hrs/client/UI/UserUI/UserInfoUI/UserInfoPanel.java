package hrs.client.UI.UserUI.UserInfoUI;

import java.awt.Dimension;
import java.awt.Font;
import java.text.ParseException;
import java.util.Calendar;
import java.util.Date;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JTextField;

import hrs.client.UI.UserUI.Components.CommonPanel;
import hrs.client.UI.UserUI.UserInfoUI.UserInfoListener.CancelListener;
import hrs.client.UI.UserUI.UserInfoUI.UserInfoListener.ConfirmListener;
import hrs.client.util.ControllerFactory;
import hrs.client.util.HRSButton;
import hrs.client.util.UIConstants;
import hrs.common.Controller.UserController.IUserController;
import hrs.common.Exception.UserService.UserNotFoundException;
import hrs.common.VO.OrderVO;
import hrs.common.VO.UserVO;
import hrs.common.util.DateHelper;

public class UserInfoPanel extends CommonPanel {

	private JLabel userLabel = new UserInfoLabel("用户名");
	private JLabel nameLabel = new UserInfoLabel("真实姓名");
	private JLabel birthLabel = new UserInfoLabel("生日");
	private JLabel contactLabel = new UserInfoLabel("联系方式");
	private JLabel enterpriseLabel = new UserInfoLabel("企业名称");
	private JLabel creditLabel = new UserInfoLabel("信用值");

	private JTextField userTextField = new UserInfoText();// 用户名文本框
	private JTextField nameTextField = new UserInfoText();// 真实姓名
	private JTextField contactTextField = new UserInfoText();// 联系方式
	private JTextField enterpriseField = new UserInfoText();// 企业
	private JLabel creditJL;

	private JComboBox<String> yearBox ;// 出生年份选框
	private JComboBox<String> monthBox ;// 出生月份选框
	private JComboBox<String> dayBox ;// 出生日期选框

	private static int COMP_HEIGHT = 60;//标签宽度，也即每行高度
	private static int TEXT_HEIGHT = 40;//文本框高度
	private static int GAP_WIDTH = 60;//左边空隙宽度
	private static int TEXT_X = 130 + GAP_WIDTH;//文本框起始x坐标
	
	private String username;
	private Calendar calendar;
//	private Date date;
	private IUserController controller = ControllerFactory.getUserController();

	private UserVO user;
	
	Font font = UIConstants.JLABEL_FONT;

	public UserInfoPanel(String username) {
//		setFont(font);
		this.username = username;
		
		//初始化
		init();

//		setLayout(null);
//		setBackground(new Color(211, 237, 249));
//		setSize(1043, 688);

		
	}

	@Override
	public void init() {

		// 从数据库获得用户信息
		getInfo();

		// 设置信息标签
		setLabel();

		// 信息展示
		setInfo();
		
		//设置按钮
		setButton();
	}

	

	private void setButton() {
		HRSButton  cancelJB = new HRSButton("取消");
//		cancelJB.setPreferredSize(new Dimension(180, 80));
//		cancelJB.setFont(font);
		cancelJB.setBounds(160, 500, 150, 60);
		cancelJB.addActionListener(new CancelListener(this));
		this.add(cancelJB);

		HRSButton confirmJB = new HRSButton("确认");
//		confirmJB.setPreferredSize(new Dimension(180, 80));
//		confirmJB.setFont(font);
		confirmJB.setBounds(560, 500, 150, 60);
		confirmJB.addActionListener(new ConfirmListener(this,user));
		this.add(confirmJB);
	}

	/*
	 * 从数据库获得真实姓名，生日，联系方式，企业，信用值
	 */
	private void getInfo() {
		try {
			user = controller.findUserByUsername(username);
			userTextField.setText(user.username);
			userTextField.setEnabled(false);
			nameTextField.setText(user.name);
			contactTextField.setText(user.phone);
			enterpriseField.setText(user.enterprise);
			creditJL = new JLabel("" + user.credit);
		} catch (UserNotFoundException e) {
			
		}

		creditJL.setFont(font);
		creditJL.setPreferredSize(new Dimension(100, 60));
		
		calendar = Calendar.getInstance();
		Date d = user.birthDate;
		calendar.setTime(d);
		
	}

	/*
	 * 展示信息：
	 * 
	 * 用户名，真实姓名，企业，联系方式为文本框 生日按年，月，日为选框形式 信用值为标签，不可更改
	 * 
	 */
	private void setInfo() {
		yearBox = new JComboBox<>();
		monthBox = new JComboBox<>();
		dayBox = new JComboBox<>();
		JLabel yearJL = new DateLabel("年");
		JLabel monthJL = new DateLabel("月");
		JLabel dayJL = new DateLabel("日");
		// 设置位置
		userTextField.setBounds(TEXT_X, COMP_HEIGHT+10, 180, TEXT_HEIGHT);
		nameTextField.setBounds(TEXT_X, COMP_HEIGHT*2+10, 180, TEXT_HEIGHT);
		contactTextField.setBounds(TEXT_X, COMP_HEIGHT*4+10, 180, TEXT_HEIGHT);
		enterpriseField.setBounds(TEXT_X, COMP_HEIGHT*5+10, 180, TEXT_HEIGHT);
		creditJL.setBounds(TEXT_X, COMP_HEIGHT*6, 100, COMP_HEIGHT);
		
		yearBox.setBounds(TEXT_X, COMP_HEIGHT*3+10, 120, TEXT_HEIGHT);
		yearJL.setBounds(TEXT_X+130, COMP_HEIGHT*3+10, 40, TEXT_HEIGHT);
		monthBox.setBounds(310+GAP_WIDTH, COMP_HEIGHT*3+10, 80, TEXT_HEIGHT);
		monthJL.setBounds(390+GAP_WIDTH, COMP_HEIGHT*3+10, 40, TEXT_HEIGHT);
		dayBox.setBounds(430+GAP_WIDTH, COMP_HEIGHT*3+10, 80, TEXT_HEIGHT);
		dayJL.setBounds(510+GAP_WIDTH, COMP_HEIGHT*3+10, 40, TEXT_HEIGHT);

		
		int year = calendar.get(Calendar.YEAR);
		int month = calendar.get(Calendar.MONTH);
		int day = calendar.get(Calendar.DATE);
		yearBox.setFont(font);
		monthBox.setFont(font);
		dayBox.setFont(font);

		// 年份可选值，从1960-2010
		// TODO
		for (int i = 0; i < 50; i++) {
			int y = 1960 + i;
			String s = "" + y;
			yearBox.addItem(s);
		}

		// 月份可选值
		for (int i = 1; i < 13; i++) {
			String s = "" + i;
			monthBox.addItem(s);
		}

		// 日期可选值
		for (int i = 1; i < 32; i++) {
			String s = "" + i;
			dayBox.addItem(s);
		}

//		yearBox.setPreferredSize(new Dimension(120, 40));
//		monthBox.setPreferredSize(new Dimension(80, 40));
//		dayBox.setPreferredSize(new Dimension(80, 40));
//		String birth = DateHelper.format(user.birthDate);
//		String[] strs = birth.split("-");

		yearBox.setSelectedItem(year+"");
		monthBox.setSelectedItem(month+"");
		dayBox.setSelectedItem(day+"");

		this.add(userTextField);
		this.add(nameTextField);
		this.add(contactTextField);
		this.add(enterpriseField);
		this.add(creditJL);
		this.add(yearBox);
		this.add(monthBox);
		this.add(dayBox);
		this.add(yearJL);
		this.add(monthJL);
		this.add(dayJL);
		

	}

	/**
	 * 设置信息标签 即： 用户名 真实姓名 生日 联系方式 企业名称 信用值
	 *
	 */
	private void setLabel() {
		userLabel.setBounds(GAP_WIDTH, COMP_HEIGHT, 100, 60);
		nameLabel.setBounds(GAP_WIDTH, COMP_HEIGHT*2, 100, COMP_HEIGHT);
		birthLabel.setBounds(GAP_WIDTH, COMP_HEIGHT*3, 100, COMP_HEIGHT);
		contactLabel.setBounds(GAP_WIDTH, COMP_HEIGHT*4, 100, COMP_HEIGHT);
		enterpriseLabel.setBounds(GAP_WIDTH, COMP_HEIGHT*5, 100, COMP_HEIGHT);
		creditLabel.setBounds(GAP_WIDTH, COMP_HEIGHT*6, 100, COMP_HEIGHT);

		this.add(userLabel);
		this.add(nameLabel);
		this.add(birthLabel);
		this.add(contactLabel);
		this.add(enterpriseLabel);
		this.add(creditLabel);
	}
	
	
	
	public String getUsername() {
		System.out.println(userTextField.getText());
		return userTextField.getText();
	}
	
	//得到生日信息
	public Date getBirth() {
		String year = yearBox.getSelectedItem().toString();
		String month = monthBox.getSelectedItem().toString();
		String day = dayBox.getSelectedItem().toString();
		String birthDate = year + '-' + month + '-' + day;
		Date date = null;
		try {
			date = DateHelper.parse(birthDate);
			
		} catch (ParseException e) {
			
			e.printStackTrace();
		}
		return date;
	}

	//从文本框内得到企业信息
	public String getEnterprise() {
		
		return enterpriseField.getText();
	}

	public String getPhone() {
		
		return contactTextField.getText();
	}
	
	public String getRealName() {
		
		return nameTextField.getText();
	}
	
	public void update(){
		user.birthDate = getBirth();
		user.username = getUsername();
		user.enterprise = getEnterprise();
		user.name = getRealName();
		user.phone = getPhone();
		

		
		controller.updateUser(user);
		init();
	}
}
