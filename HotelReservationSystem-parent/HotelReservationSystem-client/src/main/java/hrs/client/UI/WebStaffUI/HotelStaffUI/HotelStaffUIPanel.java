package hrs.client.UI.WebStaffUI.HotelStaffUI;

import javax.swing.JPanel;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JComboBox;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JTextField;

import hrs.client.UI.WebStaffUI.HotelStaffUI.HotelStaffListener.SearchConfirmMouseListener;
import hrs.client.util.ControllerFactory;
import hrs.client.util.HMSBlueButton;
import hrs.client.util.UIConstants;
import hrs.common.Controller.WebStaffController.IWebStaffController;
import hrs.common.Exception.StaffService.StaffNotFoundExceptioon;
import hrs.common.VO.StaffVO;
import hrs.client.UI.WebStaffUI.HotelStaffUI.HotelStaffListener.ModifyHotelStaffMouseListener;

public class HotelStaffUIPanel extends JPanel {
	/**
	 * 
	 */
	private static final long serialVersionUID = -8596027990923031324L;
	private JTextField jtextInput;
	private JLabel jlPassword;
	private JLabel jlHotelStaffUsername;
	private JLabel jlSearchHotelStaff;
	@SuppressWarnings("rawtypes")
	private JComboBox jcomboBoxType;
	private JLabel jlHotelName;
	private JTextField jtextPassword;
	private JTextField jtextRealName;
	private HMSBlueButton jbSearchHotelStaffConfirm;
	private HMSBlueButton jbModifyHotelStaff;
	private SearchConfirmMouseListener confirmMouseListener;
	private ModifyHotelStaffMouseListener modifyHotelStaffMouseListener;
	private IWebStaffController controller = ControllerFactory.getWebStaffController();
	private StaffVO selection = new StaffVO();
	private JLabel jlHotelNameShow;
	private JLabel jlUsernameShow;
	private JLabel jlRealName;

	/**
	 * Create the panel.
	 */
	public HotelStaffUIPanel() {
		init();
	}

	@SuppressWarnings({ "unchecked", "rawtypes" })
	public void init() {
		this.setSize(1080, 722);
		this.setBackground(UIConstants.JFRAME);

		jlSearchHotelStaff = new JLabel("搜索酒店工作人员");
		jlSearchHotelStaff.setFont(UIConstants.JLABEL_FONT);

		jcomboBoxType = new JComboBox();
		jcomboBoxType.setModel(new DefaultComboBoxModel(new String[] { "酒店名称", "酒店工作人员名" }));
		jcomboBoxType.setSelectedIndex(-1);

		jtextInput = new JTextField();
		jtextInput.setColumns(10);

		jbSearchHotelStaffConfirm = new HMSBlueButton("确认");
		jbSearchHotelStaffConfirm.setFont(UIConstants.FONT_16);
		confirmMouseListener = new SearchConfirmMouseListener(this);
		jbSearchHotelStaffConfirm.addMouseListener(confirmMouseListener);

		jlHotelStaffUsername = new JLabel("用户名");
		jlHotelStaffUsername.setFont(UIConstants.JLABEL_FONT);

		jlPassword = new JLabel("密码");
		jlPassword.setFont(UIConstants.JLABEL_FONT);

		jlRealName = new JLabel("真实姓名");
		jlRealName.setFont(UIConstants.JLABEL_FONT);

		jlHotelName = new JLabel("酒店名称");
		jlHotelName.setFont(UIConstants.JLABEL_FONT);

		jtextPassword = new JTextField();
		jtextPassword.setColumns(10);

		jtextRealName = new JTextField();
		jtextRealName.setColumns(10);

		jbModifyHotelStaff = new HMSBlueButton("修改");
		jbModifyHotelStaff.setFont(UIConstants.FONT_18);
		modifyHotelStaffMouseListener = new ModifyHotelStaffMouseListener(this);
		jbModifyHotelStaff.addMouseListener(modifyHotelStaffMouseListener);

		jlHotelNameShow = new JLabel();

		jlUsernameShow = new JLabel();

		GroupLayout groupLayout = new GroupLayout(this);
		groupLayout.setHorizontalGroup(groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(groupLayout
						.createSequentialGroup().addGap(55).addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
								.addGroup(groupLayout.createSequentialGroup().addComponent(jlSearchHotelStaff)
										.addGap(18).addComponent(jcomboBoxType, GroupLayout.PREFERRED_SIZE,
												GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
								.addGroup(groupLayout.createSequentialGroup().addGroup(groupLayout
										.createParallelGroup(Alignment.LEADING).addGroup(groupLayout
												.createParallelGroup(Alignment.TRAILING, false)
												.addComponent(jlPassword, Alignment.LEADING, GroupLayout.DEFAULT_SIZE,
														GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
												.addComponent(jlHotelStaffUsername, Alignment.LEADING,
														GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE,
														Short.MAX_VALUE))
										.addComponent(jlRealName).addComponent(jlHotelName))
										.addGap(79)
										.addGroup(groupLayout.createParallelGroup(Alignment.TRAILING)
												.addComponent(jlUsernameShow, GroupLayout.DEFAULT_SIZE, 170,
														Short.MAX_VALUE)
												.addComponent(jlHotelNameShow, GroupLayout.DEFAULT_SIZE, 170,
														Short.MAX_VALUE)
												.addComponent(jtextRealName, Alignment.LEADING,
														GroupLayout.DEFAULT_SIZE, 170, Short.MAX_VALUE)
												.addComponent(jtextPassword, Alignment.LEADING,
														GroupLayout.DEFAULT_SIZE, 170, Short.MAX_VALUE))))
						.addGap(18)
						.addComponent(jtextInput, GroupLayout.PREFERRED_SIZE, 217, GroupLayout.PREFERRED_SIZE)
						.addGap(18).addComponent(jbSearchHotelStaffConfirm).addGap(363))
				.addGroup(groupLayout.createSequentialGroup().addGap(796)
						.addComponent(jbModifyHotelStaff, GroupLayout.PREFERRED_SIZE, 95, GroupLayout.PREFERRED_SIZE)
						.addContainerGap(189, Short.MAX_VALUE)));
		groupLayout.setVerticalGroup(groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(groupLayout.createSequentialGroup().addGap(42)
						.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
								.addComponent(jlSearchHotelStaff, GroupLayout.PREFERRED_SIZE, 35,
										GroupLayout.PREFERRED_SIZE)
								.addComponent(jcomboBoxType, GroupLayout.PREFERRED_SIZE, 40, GroupLayout.PREFERRED_SIZE)
								.addComponent(jtextInput, GroupLayout.PREFERRED_SIZE, 35, GroupLayout.PREFERRED_SIZE)
								.addComponent(jbSearchHotelStaffConfirm, GroupLayout.PREFERRED_SIZE, 34,
										GroupLayout.PREFERRED_SIZE))
						.addGap(43)
						.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE).addComponent(jlHotelStaffUsername)
								.addComponent(jlUsernameShow, GroupLayout.PREFERRED_SIZE, 29,
										GroupLayout.PREFERRED_SIZE))
						.addGap(28)
						.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
								.addComponent(jlPassword).addComponent(jtextPassword, GroupLayout.PREFERRED_SIZE, 35,
										GroupLayout.PREFERRED_SIZE))
						.addGap(28)
						.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
								.addComponent(jlRealName).addComponent(jtextRealName, GroupLayout.PREFERRED_SIZE, 35,
										GroupLayout.PREFERRED_SIZE))
						.addGap(28)
						.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE).addComponent(jlHotelName)
								.addComponent(jlHotelNameShow, GroupLayout.PREFERRED_SIZE, 26,
										GroupLayout.PREFERRED_SIZE))
						.addGap(186)
						.addComponent(jbModifyHotelStaff, GroupLayout.PREFERRED_SIZE, 40, GroupLayout.PREFERRED_SIZE)
						.addContainerGap(141, Short.MAX_VALUE)));
		setLayout(groupLayout);

	}

	public List<StaffVO> search() {
		List<StaffVO> staffVOs = new ArrayList<>();
		String findTypeText = getSearchInput();
		Object findTypeComboBox = jcomboBoxType.getSelectedItem();
		if (getSearchInput().equals("")) {
			clear();
			JOptionPane.showMessageDialog(null, "请输入酒店名称或酒店工作人员名称", "Error", JOptionPane.ERROR_MESSAGE);
		} else {
			if (findTypeComboBox.equals("酒店名称")) {
				try {
					staffVOs = controller.findStaffByHotelName(findTypeText);
				} catch (StaffNotFoundExceptioon e) {
					// TODO Auto-generated catch block
					clear();
					JOptionPane.showMessageDialog(null, "酒店及工作人员不存在！", "Error", JOptionPane.ERROR_MESSAGE);
				}
			}
			if (findTypeComboBox.equals("酒店工作人员名")) {
				try {
					staffVOs.add(controller.findStaffByUsername(findTypeText));
				} catch (StaffNotFoundExceptioon e1) {
					// TODO Auto-generated catch block
					clear();
					JOptionPane.showMessageDialog(null, "此酒店工作人员不存在！", "Error", JOptionPane.ERROR_MESSAGE);
				}
			}
		}
		// System.out.println(staffVOs);
		return staffVOs;
	}

	// list按顺序加到joptionpane里面
	public void selectHotelAndShow() {
		List<StaffVO> toAddStaffVOs = search();
		if (toAddStaffVOs.size() == 1) {
			selection = toAddStaffVOs.get(0);
			jlUsernameShow.setText(selection.username);
			jtextPassword.setText(selection.password);
			jtextRealName.setText(selection.name);
			jlHotelNameShow.setText(selection.hotel.name);
		}
		if (toAddStaffVOs.size() > 1) {
			int index;
			String[] vos = new String[toAddStaffVOs.size()];
			for (int i = 0; i < toAddStaffVOs.size(); i++) {
				vos[i] = toAddStaffVOs.get(i).hotel.name;
			} // 根据用户的选择酒店名称hhhh知道vos[i]的i,get就可以得到了；
				// selection = (StaffVO) JOptionPane.showInputDialog(null,
				// "搜索到多家酒店，请选择一家：\n", "酒店选择",
				// JOptionPane.PLAIN_MESSAGE, null, vos, toAddStaffVOs.get(0));
				// System.out.println(selection);
				// System.out.println(JOptionPane.showInputDialog(null,
				// "搜索到多家酒店，请选择一家：\n", "酒店选择",
				// JOptionPane.PLAIN_MESSAGE, null, vos, toAddStaffVOs.get(0)));
			String userSelected = (String) JOptionPane.showInputDialog(null, "搜索到多家酒店，请选择一家：\n", "酒店选择",
					JOptionPane.PLAIN_MESSAGE, null, vos, toAddStaffVOs.get(0));
			for (index = 0; index < toAddStaffVOs.size(); ++index) {
				if (vos[index].equals(userSelected))
					break;
			}
			selection = toAddStaffVOs.get(index);
			jlUsernameShow.setText(selection.username);
			jtextPassword.setText(selection.password);
			jtextRealName.setText(selection.name);
			jlHotelNameShow.setText(selection.hotel.name);
		}
		toAddStaffVOs = new ArrayList<>();
	}

	public String getSearchInput() {
		return jtextInput.getText();
	}

	public String getUsername() {
		return jlUsernameShow.getText();
	}

	public void modify() {
		String newPassword = jtextPassword.getText();
		String newRealName = jtextRealName.getText();
		selection.password = newPassword;
		selection.name = newRealName;
		selection.hotel = selection.hotel;
		controller.updateStaff(selection);
	}// 酒店名称默认不可修改

	public String getPassword() {
		return jtextPassword.getText();
	}

	public void clear() {
		jlUsernameShow.setText("");
		jtextPassword.setText("");
		jtextRealName.setText("");
		jlHotelNameShow.setText("");
	}

}
