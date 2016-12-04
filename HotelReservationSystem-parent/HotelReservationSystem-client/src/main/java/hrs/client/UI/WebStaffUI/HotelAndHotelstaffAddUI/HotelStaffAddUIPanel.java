package hrs.client.UI.WebStaffUI.HotelAndHotelstaffAddUI;

import java.awt.Color;
import java.awt.Font;

import javax.swing.JPanel;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JLabel;
import javax.swing.SwingConstants;

import hrs.client.UI.WebStaffUI.WebStaffFrame;
import hrs.client.UI.WebStaffUI.HotelAndHotelstaffAddUI.HotelAndHotelstaffAddListener.LastStepMouseListener;

import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.LayoutStyle.ComponentPlacement;

public class HotelStaffAddUIPanel extends JPanel {
	private JTextField jtextHotelStaffUsrname;
	private JPanel jpHotelAdd;
	private JPanel jpHotelStaffAdd;
	private JLabel jlpanelIN;
	private JLabel lblNewLabel;
	private JButton jbConfirm;
	private JButton jbLastStep;
	private JLabel jlPassword;
	private JLabel jlPasswordConfirm;
	private JLabel jlHotelStaffRealName;
	private JTextField jtextPassword;
	private JTextField jtextPasswordConfirm;
	private JTextField jtextRealName;
	private LastStepMouseListener lastStepMouseListener;
	private WebStaffFrame webStaffFrame;

	/**
	 * Create the panel.
	 */
	public HotelStaffAddUIPanel(WebStaffFrame webStaffFrame) {
		this.webStaffFrame=webStaffFrame;
		init();

	}
	public void init(){
		this.setSize(1080, 722);
		this.setBackground(new Color(211, 237, 249));
		
		jpHotelAdd = new JPanel();
		jpHotelAdd.setBackground(new Color(176, 224, 230));
		
		jpHotelStaffAdd = new JPanel();
		jpHotelStaffAdd.setBackground(Color.WHITE);
		
		JLabel jlHotelStaffUsername = new JLabel("用户名");
		jlHotelStaffUsername.setHorizontalAlignment(SwingConstants.LEFT);
		jlHotelStaffUsername.setFont(new Font("Arial Unicode MS", Font.PLAIN, 19));
		
		jtextHotelStaffUsrname = new JTextField();
		jtextHotelStaffUsrname.setColumns(10);
		
		jbLastStep = new JButton("上一步");
		jbLastStep.setFont(new Font("Arial Unicode MS", Font.PLAIN, 18));
		jbLastStep.setBackground(new Color(0, 160, 233));
		jbLastStep.setForeground(Color.WHITE);
		jbLastStep.setBorderPainted(false);
		jbLastStep.setOpaque(true);
		lastStepMouseListener=new LastStepMouseListener(this);
		jbLastStep.addMouseListener(lastStepMouseListener);
		
		jbConfirm = new JButton("确认");
		jbConfirm.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		jbConfirm.setFont(new Font("Arial Unicode MS", Font.PLAIN, 18));
		jbConfirm.setBackground(new Color(0, 160, 233));
		jbConfirm.setForeground(Color.WHITE);
		jbConfirm.setBorderPainted(false);
		jbConfirm.setOpaque(true);
		
		jlPassword = new JLabel("密码");
		jlPassword.setHorizontalAlignment(SwingConstants.LEFT);
		jlPassword.setFont(new Font("Arial Unicode MS", Font.PLAIN, 19));
		
		jlPasswordConfirm = new JLabel("确认密码");
		jlPasswordConfirm.setHorizontalAlignment(SwingConstants.LEFT);
		jlPasswordConfirm.setFont(new Font("Arial Unicode MS", Font.PLAIN, 19));
		
		jlHotelStaffRealName = new JLabel("真实姓名");
		jlHotelStaffRealName.setHorizontalAlignment(SwingConstants.LEFT);
		jlHotelStaffRealName.setFont(new Font("Arial Unicode MS", Font.PLAIN, 19));
		
		jtextPassword = new JTextField();
		jtextPassword.setColumns(10);
		
		jtextPasswordConfirm = new JTextField();
		jtextPasswordConfirm.setColumns(10);
		
		jtextRealName = new JTextField();
		jtextRealName.setColumns(10);
		
		GroupLayout groupLayout = new GroupLayout(this);
		groupLayout.setHorizontalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(groupLayout.createSequentialGroup()
					.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
						.addGroup(groupLayout.createSequentialGroup()
							.addGap(60)
							.addComponent(jpHotelAdd, GroupLayout.PREFERRED_SIZE, 202, GroupLayout.PREFERRED_SIZE)
							.addGap(30)
							.addComponent(jpHotelStaffAdd, GroupLayout.PREFERRED_SIZE, 243, GroupLayout.PREFERRED_SIZE))
						.addGroup(groupLayout.createSequentialGroup()
							.addGap(93)
							.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
								.addGroup(groupLayout.createSequentialGroup()
									.addGap(12)
									.addComponent(jbLastStep, GroupLayout.PREFERRED_SIZE, 128, GroupLayout.PREFERRED_SIZE)
									.addGap(82)
									.addComponent(jbConfirm, GroupLayout.PREFERRED_SIZE, 128, GroupLayout.PREFERRED_SIZE))
								.addGroup(groupLayout.createSequentialGroup()
									.addGroup(groupLayout.createParallelGroup(Alignment.TRAILING, false)
										.addComponent(jlPassword, Alignment.LEADING, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
										.addComponent(jlHotelStaffUsername, Alignment.LEADING, GroupLayout.DEFAULT_SIZE, 101, Short.MAX_VALUE)
										.addComponent(jlPasswordConfirm, Alignment.LEADING)
										.addComponent(jlHotelStaffRealName, Alignment.LEADING))
									.addGap(39)
									.addGroup(groupLayout.createParallelGroup(Alignment.LEADING, false)
										.addComponent(jtextRealName)
										.addComponent(jtextPasswordConfirm)
										.addComponent(jtextPassword)
										.addComponent(jtextHotelStaffUsrname, GroupLayout.DEFAULT_SIZE, 231, Short.MAX_VALUE))))))
					.addContainerGap(545, Short.MAX_VALUE))
		);
		groupLayout.setVerticalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(groupLayout.createSequentialGroup()
					.addGap(47)
					.addGroup(groupLayout.createParallelGroup(Alignment.TRAILING)
						.addComponent(jpHotelStaffAdd, Alignment.LEADING, GroupLayout.DEFAULT_SIZE, 47, Short.MAX_VALUE)
						.addComponent(jpHotelAdd, Alignment.LEADING, GroupLayout.PREFERRED_SIZE, 47, GroupLayout.PREFERRED_SIZE))
					.addGap(48)
					.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
						.addComponent(jlHotelStaffUsername, GroupLayout.PREFERRED_SIZE, 36, GroupLayout.PREFERRED_SIZE)
						.addComponent(jtextHotelStaffUsrname, GroupLayout.PREFERRED_SIZE, 41, GroupLayout.PREFERRED_SIZE))
					.addGap(41)
					.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
						.addComponent(jlPassword)
						.addComponent(jtextPassword, GroupLayout.PREFERRED_SIZE, 41, GroupLayout.PREFERRED_SIZE))
					.addGap(41)
					.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
						.addComponent(jlPasswordConfirm)
						.addComponent(jtextPasswordConfirm, GroupLayout.PREFERRED_SIZE, 41, GroupLayout.PREFERRED_SIZE))
					.addGap(41)
					.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
						.addComponent(jlHotelStaffRealName)
						.addComponent(jtextRealName, GroupLayout.PREFERRED_SIZE, 41, GroupLayout.PREFERRED_SIZE))
					.addGap(77)
					.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
						.addComponent(jbLastStep, GroupLayout.PREFERRED_SIZE, 47, GroupLayout.PREFERRED_SIZE)
						.addComponent(jbConfirm, GroupLayout.PREFERRED_SIZE, 47, GroupLayout.PREFERRED_SIZE))
					.addGap(222))
		);
		
		jlpanelIN = new JLabel("添加酒店工作人员");
		jlpanelIN.setHorizontalAlignment(SwingConstants.CENTER);
		jlpanelIN.setFont(new Font("Arial Unicode MS", Font.PLAIN, 20));
		jlpanelIN.setForeground(new Color(128, 138, 235));
		
		GroupLayout gl_jpHotelStaffAdd = new GroupLayout(jpHotelStaffAdd);
		gl_jpHotelStaffAdd.setHorizontalGroup(
			gl_jpHotelStaffAdd.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_jpHotelStaffAdd.createSequentialGroup()
					.addContainerGap()
					.addComponent(jlpanelIN, GroupLayout.DEFAULT_SIZE, 231, Short.MAX_VALUE)
					.addContainerGap())
		);
		gl_jpHotelStaffAdd.setVerticalGroup(
			gl_jpHotelStaffAdd.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_jpHotelStaffAdd.createSequentialGroup()
					.addContainerGap()
					.addComponent(jlpanelIN, GroupLayout.DEFAULT_SIZE, 35, Short.MAX_VALUE)
					.addContainerGap())
		);
		jpHotelStaffAdd.setLayout(gl_jpHotelStaffAdd);
		
		lblNewLabel = new JLabel("添加酒店");
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setFont(new Font("Arial Unicode MS", Font.PLAIN, 20));
		lblNewLabel.setForeground(new Color(128, 138, 235));
		
		GroupLayout gl_jpHotelAdd = new GroupLayout(jpHotelAdd);
		gl_jpHotelAdd.setHorizontalGroup(
			gl_jpHotelAdd.createParallelGroup(Alignment.LEADING)
				.addGroup(Alignment.TRAILING, gl_jpHotelAdd.createSequentialGroup()
					.addContainerGap()
					.addComponent(lblNewLabel, GroupLayout.DEFAULT_SIZE, 190, Short.MAX_VALUE)
					.addContainerGap())
		);
		gl_jpHotelAdd.setVerticalGroup(
			gl_jpHotelAdd.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_jpHotelAdd.createSequentialGroup()
					.addContainerGap()
					.addComponent(lblNewLabel, GroupLayout.DEFAULT_SIZE, 35, Short.MAX_VALUE)
					.addContainerGap())
		);
		jpHotelAdd.setLayout(gl_jpHotelAdd);
		setLayout(groupLayout);
	}
	public void showHotelAddUIPanel(){
		webStaffFrame.showHotelAddUIPanel();
	}

}
