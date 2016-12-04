package hrs.client.UI.WebStaffUI.HotelStaffUI;

import java.awt.Color;

import javax.swing.JPanel;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.JComboBox;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JTextField;

import hrs.client.UI.WebStaffUI.HotelStaffUI.HotelStaffListener.HotelStaffSearchConfirmMouseListener;
import hrs.client.UI.WebStaffUI.HotelStaffUI.HotelStaffListener.ModifyHotelStaffMouseListener;

import javax.swing.JButton;

public class HotelStaffUIPanel extends JPanel {
	private JTextField jtextInput;
	private JLabel jlPassword;
	private JLabel jlHotelStaffUsername;
	private JLabel jlSearchHotelStaff;
	private JComboBox jcomboBoxType;
	private JButton jbSearchHotelStaffConfirm;
	private JLabel jlHotelName;
	private JTextField jtextHotelStaffUsername;
	private JTextField jtextPassword;
	private JTextField jtextRealName;
	private JTextField jtextHotelName;
	private JButton jbModifyHotelStaff;
	private HotelStaffSearchConfirmMouseListener confirmMouseListener;
	private ModifyHotelStaffMouseListener modifyHotelStaffMouseListener;

	/**
	 * Create the panel.
	 */
	public HotelStaffUIPanel() {
		init();
	}
	public void init(){
		this.setSize(1080, 722);
		this.setBackground(new Color(211, 237, 249));
		
		jlSearchHotelStaff = new JLabel("搜索酒店工作人员");
		jlSearchHotelStaff.setFont(new Font("Arial Unicode MS", Font.PLAIN, 21));
		
		jcomboBoxType = new JComboBox();
		jcomboBoxType.setModel(new DefaultComboBoxModel(new String[] {"酒店名称", "酒店工作人员名"}));
		
		jtextInput = new JTextField();
		jtextInput.setColumns(10);
		
		jbSearchHotelStaffConfirm = new JButton("确认");
		jbSearchHotelStaffConfirm.setFont(new Font("Arial Unicode MS", Font.PLAIN, 16));
		jbSearchHotelStaffConfirm.setBackground(new Color(0, 160, 233));
		jbSearchHotelStaffConfirm.setForeground(Color.WHITE);
		jbSearchHotelStaffConfirm.setBorderPainted(false);
		jbSearchHotelStaffConfirm.setOpaque(true);
		confirmMouseListener=new HotelStaffSearchConfirmMouseListener();
		jbSearchHotelStaffConfirm.addMouseListener(confirmMouseListener);
		
		jlHotelStaffUsername = new JLabel("用户名");
		jlHotelStaffUsername.setFont(new Font("Arial Unicode MS", Font.PLAIN, 21));
		
		jlPassword = new JLabel("密码");
		jlPassword.setFont(new Font("Arial Unicode MS", Font.PLAIN, 21));
		
		JLabel jlRealName = new JLabel("真实姓名");
		jlRealName.setFont(new Font("Arial Unicode MS", Font.PLAIN, 21));
		
		jlHotelName = new JLabel("酒店名称");
		jlHotelName.setFont(new Font("Arial Unicode MS", Font.PLAIN, 21));
		
		jtextHotelStaffUsername = new JTextField();
		jtextHotelStaffUsername.setColumns(10);
		
		jtextPassword = new JTextField();
		jtextPassword.setColumns(10);
		
		jtextRealName = new JTextField();
		jtextRealName.setColumns(10);
		
		jtextHotelName = new JTextField();
		jtextHotelName.setColumns(10);
		
		jbModifyHotelStaff = new JButton("修改");
		jbModifyHotelStaff.setFont(new Font("Arial Unicode MS", Font.PLAIN, 18));
		jbModifyHotelStaff.setBackground(new Color(0, 160, 233));
		jbModifyHotelStaff.setForeground(Color.WHITE);
		jbModifyHotelStaff.setBorderPainted(false);
		jbModifyHotelStaff.setOpaque(true);
		modifyHotelStaffMouseListener=new ModifyHotelStaffMouseListener();
		jbModifyHotelStaff.addMouseListener(modifyHotelStaffMouseListener);
		
		GroupLayout groupLayout = new GroupLayout(this);
		groupLayout.setHorizontalGroup(
			groupLayout.createParallelGroup(Alignment.TRAILING)
				.addGroup(groupLayout.createSequentialGroup()
					.addGap(55)
					.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
						.addGroup(groupLayout.createSequentialGroup()
							.addComponent(jlSearchHotelStaff)
							.addGap(18)
							.addComponent(jcomboBoxType, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
						.addGroup(groupLayout.createSequentialGroup()
							.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
								.addGroup(groupLayout.createParallelGroup(Alignment.TRAILING, false)
									.addComponent(jlPassword, Alignment.LEADING, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
									.addComponent(jlHotelStaffUsername, Alignment.LEADING, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
								.addComponent(jlRealName)
								.addComponent(jlHotelName))
							.addGap(79)
							.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
								.addComponent(jtextHotelName, GroupLayout.PREFERRED_SIZE, 170, GroupLayout.PREFERRED_SIZE)
								.addComponent(jtextRealName, GroupLayout.PREFERRED_SIZE, 170, GroupLayout.PREFERRED_SIZE)
								.addComponent(jtextPassword, GroupLayout.PREFERRED_SIZE, 170, GroupLayout.PREFERRED_SIZE)
								.addComponent(jtextHotelStaffUsername, GroupLayout.DEFAULT_SIZE, 170, Short.MAX_VALUE))))
					.addGap(18)
					.addComponent(jtextInput, GroupLayout.PREFERRED_SIZE, 217, GroupLayout.PREFERRED_SIZE)
					.addGap(18)
					.addComponent(jbSearchHotelStaffConfirm)
					.addGap(363))
				.addGroup(Alignment.LEADING, groupLayout.createSequentialGroup()
					.addGap(796)
					.addComponent(jbModifyHotelStaff, GroupLayout.PREFERRED_SIZE, 95, GroupLayout.PREFERRED_SIZE)
					.addContainerGap(189, Short.MAX_VALUE))
		);
		groupLayout.setVerticalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(groupLayout.createSequentialGroup()
					.addGap(42)
					.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
						.addComponent(jlSearchHotelStaff, GroupLayout.PREFERRED_SIZE, 35, GroupLayout.PREFERRED_SIZE)
						.addComponent(jcomboBoxType, GroupLayout.PREFERRED_SIZE, 40, GroupLayout.PREFERRED_SIZE)
						.addComponent(jtextInput, GroupLayout.PREFERRED_SIZE, 35, GroupLayout.PREFERRED_SIZE)
						.addComponent(jbSearchHotelStaffConfirm, GroupLayout.PREFERRED_SIZE, 34, GroupLayout.PREFERRED_SIZE))
					.addGap(43)
					.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
						.addComponent(jlHotelStaffUsername)
						.addComponent(jtextHotelStaffUsername, GroupLayout.PREFERRED_SIZE, 35, GroupLayout.PREFERRED_SIZE))
					.addGap(28)
					.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
						.addComponent(jlPassword)
						.addComponent(jtextPassword, GroupLayout.PREFERRED_SIZE, 35, GroupLayout.PREFERRED_SIZE))
					.addGap(28)
					.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
						.addComponent(jlRealName)
						.addComponent(jtextRealName, GroupLayout.PREFERRED_SIZE, 35, GroupLayout.PREFERRED_SIZE))
					.addGap(28)
					.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
						.addComponent(jlHotelName)
						.addComponent(jtextHotelName, GroupLayout.PREFERRED_SIZE, 35, GroupLayout.PREFERRED_SIZE))
					.addGap(186)
					.addComponent(jbModifyHotelStaff, GroupLayout.PREFERRED_SIZE, 47, GroupLayout.PREFERRED_SIZE)
					.addContainerGap(134, Short.MAX_VALUE))
		);
		setLayout(groupLayout);
		
	}
	

}
