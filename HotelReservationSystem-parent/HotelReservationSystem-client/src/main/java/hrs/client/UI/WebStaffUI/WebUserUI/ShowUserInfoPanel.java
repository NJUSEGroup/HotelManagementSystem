package hrs.client.UI.WebStaffUI.WebUserUI;

import java.awt.Color;

import javax.swing.JPanel;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;

import org.hibernate.engine.query.spi.ReturnMetadata;

import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import java.sql.Date;
import java.text.ParseException;

import javax.swing.JTextField;

import android.R.string;
import hrs.client.UI.WebMarketUI.WebDiscountUI.WebDiscountListener.ModifyMouseListener;
import hrs.client.UI.WebStaffUI.WebUserUI.WebUserListener.ModifyUserInfoMouseListener;
import hrs.client.util.ControllerFactory;
import hrs.common.Controller.WebStaffController.IWebUserController;
import hrs.common.Exception.UserService.UserNotFoundException;
import hrs.common.VO.UserVO;
import hrs.common.util.DateHelper;

import javax.swing.JButton;

public class ShowUserInfoPanel extends JPanel {
	private JLabel jlUsername;
	private JLabel jlPassword;
	private JLabel jlRealName;
	private JLabel jlBirthday;
	private JLabel jlPhone;
	private JLabel jlEnterpriseName;
	private JLabel jlCredit;
	private JTextField jtextUsername=new JTextField();
	private JTextField jtextPassword=new JTextField();
	private JTextField jtextRealName=new JTextField();
	private JTextField jtextBirthday=new JTextField();
	private JTextField jtextPhone=new JTextField();
	private JTextField jtextEnterpriseName=new JTextField();
	private JLabel jlCreditvalue=new JLabel();

	/**
	 * Create the panel.
	 */
	public ShowUserInfoPanel() {
		init();
	}
	public void init(){
		this.setSize(1068,523);
		this.setBackground(new Color(211, 237, 249));
		
		jlUsername = new JLabel("用户名");
		jlUsername.setFont(new Font("Arial Unicode MS", Font.PLAIN, 18));
		
		jlPassword = new JLabel("密码");
		jlPassword.setFont(new Font("Arial Unicode MS", Font.PLAIN, 18));
		
		jlRealName = new JLabel("真实姓名");
		jlRealName.setFont(new Font("Arial Unicode MS", Font.PLAIN, 18));
		
		jlBirthday = new JLabel("生日");
		jlBirthday.setFont(new Font("Arial Unicode MS", Font.PLAIN, 18));
		
		jlPhone = new JLabel("联系方式");
		jlPhone.setFont(new Font("Arial Unicode MS", Font.PLAIN, 18));
		
		jlEnterpriseName = new JLabel("企业名称");
		jlEnterpriseName.setFont(new Font("Arial Unicode MS", Font.PLAIN, 18));
		
		jlCredit = new JLabel("信用值");
		jlCredit.setFont(new Font("Arial Unicode MS", Font.PLAIN, 18));
		
		jtextUsername.setColumns(10);
//		jtextUsername.setEditable(false);
		jtextPassword.setColumns(10);
//		jtextPassword.setEnabled(false);
		jtextRealName.setColumns(10);
		
		jtextBirthday.setColumns(10);
		
		jtextPhone.setColumns(10);
		
		jtextEnterpriseName.setColumns(10);
		
		GroupLayout groupLayout = new GroupLayout(this);
		groupLayout.setHorizontalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(groupLayout.createSequentialGroup()
					.addGap(43)
					.addGroup(groupLayout.createParallelGroup(Alignment.TRAILING)
						.addComponent(jlCredit, Alignment.LEADING, GroupLayout.DEFAULT_SIZE, 72, Short.MAX_VALUE)
						.addComponent(jlEnterpriseName, Alignment.LEADING, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
						.addComponent(jlPhone, Alignment.LEADING, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
						.addComponent(jlBirthday, Alignment.LEADING, GroupLayout.DEFAULT_SIZE, 72, Short.MAX_VALUE)
						.addComponent(jlRealName, Alignment.LEADING, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
						.addComponent(jlPassword, Alignment.LEADING, GroupLayout.DEFAULT_SIZE, 72, Short.MAX_VALUE)
						.addComponent(jlUsername, Alignment.LEADING, GroupLayout.DEFAULT_SIZE, 72, Short.MAX_VALUE))
					.addGap(56)
					.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
						.addComponent(jlCreditvalue, GroupLayout.DEFAULT_SIZE, 217, Short.MAX_VALUE)
						.addGroup(groupLayout.createParallelGroup(Alignment.LEADING, false)
							.addComponent(jtextEnterpriseName)
							.addComponent(jtextRealName, 217, 217, Short.MAX_VALUE)
							.addComponent(jtextPassword)
							.addComponent(jtextUsername, GroupLayout.DEFAULT_SIZE, 217, Short.MAX_VALUE)
							.addComponent(jtextBirthday)
							.addComponent(jtextPhone)))
					.addGap(680))
		);
		groupLayout.setVerticalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(groupLayout.createSequentialGroup()
					.addGap(36)
					.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
						.addComponent(jlUsername, GroupLayout.PREFERRED_SIZE, 35, GroupLayout.PREFERRED_SIZE)
						.addComponent(jtextUsername, GroupLayout.PREFERRED_SIZE, 38, GroupLayout.PREFERRED_SIZE))
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
					.addContainerGap(210, Short.MAX_VALUE))
		);
		setLayout(groupLayout);
	}
	public String getUsername(){
		return jtextUsername.getText();
	}
	public String getPassword(){
		return jtextPassword.getText();
	}
	public String getRealName(){
		return jtextRealName.getText();
	}
	public java.util.Date getBirthday(){
		String string=jtextBirthday.getText();
		java.util.Date date = null;
		try {
		   date=DateHelper.parse(string);
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			JOptionPane.showMessageDialog(null, "请输入正确的日期格式", "Error", JOptionPane.ERROR_MESSAGE);
			e.printStackTrace();
		}
		return date;
	}
	public String getPhone(){
		return jtextPhone.getText();
	}
	public String getEnterpriseName(){
		return jtextEnterpriseName.getText();
	}
//	public int getCreditValue(){
////		return Integer.parseInt(jlCreditvalue.getText());
//		return 3500;
//	}

	public void inputInfo(UserVO userVO){
		jtextUsername.setText(userVO.username);
		jtextPassword.setText(userVO.password);
		jtextRealName.setText(userVO.name);
		jtextBirthday.setText(DateHelper.format(userVO.birthDate));
		jtextPhone.setText(userVO.phone);
		jtextEnterpriseName.setText(userVO.enterprise);
		jlCreditvalue.setText(userVO.credit+"");
		jlCreditvalue.setEnabled(false);
	}

}