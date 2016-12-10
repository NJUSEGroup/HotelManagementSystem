package hrs.client.UI.WebStaffUI.WebUserUI;

import java.awt.Color;

import javax.swing.JPanel;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;

import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.text.ParseException;

import javax.swing.JTextField;

import hrs.client.util.UIConstants;
import hrs.common.VO.UserVO;
import hrs.common.util.DateHelper;

public class ShowUserInfoPanel extends JPanel {
	/**
	 * 
	 */
	private static final long serialVersionUID = -5437312933054543396L;
	private JLabel jlUsername;
	private JLabel jlPassword;
	private JLabel jlRealName;
	private JLabel jlBirthday;
	private JLabel jlPhone;
	private JLabel jlEnterpriseName;
	private JLabel jlCredit;
	private JTextField jtextPassword;
	private JTextField jtextRealName;
	private JTextField jtextBirthday;
	private JTextField jtextPhone;
	private JTextField jtextEnterpriseName;
	private JLabel jlCreditvalue;
	private JLabel jlUsernameShow;

	/**
	 * Create the panel.
	 */
	public ShowUserInfoPanel() {
		init();
	}

	public void init() {
		this.setSize(1068, 523);
		this.setBackground(new Color(211, 237, 249));

		jlUsername = new JLabel("用户名");
		jlUsername.setFont(UIConstants.FONT_18);

		jlPassword = new JLabel("密码");
		jlPassword.setFont(UIConstants.FONT_18);

		jlRealName = new JLabel("真实姓名");
		jlRealName.setFont(UIConstants.FONT_18);

		jlBirthday = new JLabel("生日");
		jlBirthday.setFont(UIConstants.FONT_18);

		jlPhone = new JLabel("联系方式");
		jlPhone.setFont(UIConstants.FONT_18);

		jlEnterpriseName = new JLabel("企业名称");
		jlEnterpriseName.setFont(UIConstants.FONT_18);

		jlCredit = new JLabel("信用值");
		jlCredit.setFont(UIConstants.FONT_18);

		jtextPassword = new JTextField();
		jtextPassword.setColumns(10);

		jtextRealName = new JTextField();
		jtextRealName.setColumns(10);

		jtextBirthday = new JTextField();
		jtextBirthday.setColumns(10);

		jtextPhone = new JTextField();
		jtextPhone.setColumns(10);

		jtextEnterpriseName = new JTextField();
		jtextEnterpriseName.setColumns(10);

		jlUsernameShow = new JLabel();
		jlCreditvalue = new JLabel();

		GroupLayout groupLayout = new GroupLayout(this);
		groupLayout.setHorizontalGroup(groupLayout.createParallelGroup(Alignment.LEADING).addGroup(groupLayout
				.createSequentialGroup().addGap(43)
				.addGroup(groupLayout.createParallelGroup(Alignment.TRAILING)
						.addComponent(jlCredit, Alignment.LEADING, GroupLayout.DEFAULT_SIZE, 72, Short.MAX_VALUE)
						.addComponent(jlEnterpriseName, Alignment.LEADING, GroupLayout.DEFAULT_SIZE,
								GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
						.addComponent(jlPhone, Alignment.LEADING, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE,
								Short.MAX_VALUE)
						.addComponent(jlBirthday, Alignment.LEADING, GroupLayout.DEFAULT_SIZE, 72, Short.MAX_VALUE)
						.addComponent(jlRealName, Alignment.LEADING, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE,
								Short.MAX_VALUE)
						.addComponent(jlPassword, Alignment.LEADING, GroupLayout.DEFAULT_SIZE, 72, Short.MAX_VALUE)
						.addComponent(jlUsername, Alignment.LEADING, GroupLayout.DEFAULT_SIZE, 72,
								Short.MAX_VALUE))
				.addGap(56)
				.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
						.addComponent(jlUsernameShow, GroupLayout.DEFAULT_SIZE, 217, Short.MAX_VALUE)
						.addComponent(jlCreditvalue, GroupLayout.DEFAULT_SIZE, 217, Short.MAX_VALUE)
						.addGroup(groupLayout.createParallelGroup(Alignment.LEADING, false)
								.addComponent(jtextEnterpriseName)
								.addComponent(jtextRealName, 217, 217, Short.MAX_VALUE).addComponent(jtextPassword)
								.addComponent(jtextBirthday).addComponent(jtextPhone)))
				.addGap(680)));
		groupLayout.setVerticalGroup(groupLayout.createParallelGroup(Alignment.LEADING).addGroup(groupLayout
				.createSequentialGroup().addGap(36)
				.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
						.addComponent(jlUsername, GroupLayout.PREFERRED_SIZE, 35, GroupLayout.PREFERRED_SIZE)
						.addComponent(jlUsernameShow, GroupLayout.PREFERRED_SIZE, 28, GroupLayout.PREFERRED_SIZE))
				.addGap(18)
				.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
						.addComponent(jlPassword, GroupLayout.PREFERRED_SIZE, 35, GroupLayout.PREFERRED_SIZE)
						.addComponent(jtextPassword, GroupLayout.PREFERRED_SIZE, 38, GroupLayout.PREFERRED_SIZE))
				.addGap(18)
				.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
						.addComponent(jlRealName, GroupLayout.PREFERRED_SIZE, 35, GroupLayout.PREFERRED_SIZE)
						.addComponent(jtextRealName, GroupLayout.PREFERRED_SIZE, 38, GroupLayout.PREFERRED_SIZE))
				.addGap(18)
				.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
						.addComponent(jlBirthday, GroupLayout.PREFERRED_SIZE, 35, GroupLayout.PREFERRED_SIZE)
						.addComponent(jtextBirthday, GroupLayout.PREFERRED_SIZE, 38, GroupLayout.PREFERRED_SIZE))
				.addGap(18)
				.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
						.addComponent(jlPhone, GroupLayout.PREFERRED_SIZE, 35, GroupLayout.PREFERRED_SIZE)
						.addComponent(jtextPhone, GroupLayout.PREFERRED_SIZE, 38, GroupLayout.PREFERRED_SIZE))
				.addGap(18)
				.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
						.addComponent(jlEnterpriseName, GroupLayout.PREFERRED_SIZE, 35, GroupLayout.PREFERRED_SIZE)
						.addComponent(jtextEnterpriseName, GroupLayout.PREFERRED_SIZE, 38, GroupLayout.PREFERRED_SIZE))
				.addGap(18)
				.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
						.addComponent(jlCredit, GroupLayout.PREFERRED_SIZE, 35, GroupLayout.PREFERRED_SIZE)
						.addComponent(jlCreditvalue, GroupLayout.PREFERRED_SIZE, 35, GroupLayout.PREFERRED_SIZE))
				.addContainerGap(110, Short.MAX_VALUE)));
		setLayout(groupLayout);
	}

	// public String getUsername(){
	// return .getText();
	// }
	public String getPassword() {
		return jtextPassword.getText();
	}

	public String getRealName() {
		// System.out.println(jtextRealName.getText());
		return jtextRealName.getText();
	}

	public java.util.Date getBirthday() {
		String string = jtextBirthday.getText();
		// System.out.println(jtextBirthday.getText());
		java.util.Date date = null;
		try {
			date = DateHelper.parse(string);
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			JOptionPane.showMessageDialog(null, "请输入正确的日期格式", "Error", JOptionPane.ERROR_MESSAGE);
			e.printStackTrace();
		}
		return date;
	}

	public String getPhone() {
		// System.out.println(jtextPhone.getText());
		return jtextPhone.getText();
	}

	public String getEnterpriseName() {
		// System.out.println(jtextEnterpriseName.getText());
		return jtextEnterpriseName.getText();
	}
	// public int getCreditValue(){
	//// return Integer.parseInt(jlCreditvalue.getText());
	// return 3500;
	// }

	public void inputInfo(UserVO userVO) {
		jlUsernameShow.setText(userVO.username);
		jtextPassword.setText(userVO.password);
		jtextRealName.setText(userVO.name);
		jtextBirthday.setText(DateHelper.format(userVO.birthDate));
		jtextPhone.setText(userVO.phone);
		jtextEnterpriseName.setText(userVO.enterprise);
		jlCreditvalue.setText(userVO.credit + "");
	}

}
