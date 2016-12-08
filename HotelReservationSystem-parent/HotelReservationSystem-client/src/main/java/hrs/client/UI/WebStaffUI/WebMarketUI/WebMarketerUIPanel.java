package hrs.client.UI.WebStaffUI.WebMarketUI;

import java.awt.Color;
import java.awt.Font;

import javax.swing.JPanel;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;

import hrs.client.UI.WebMarketUI.WebOrderUI.WebOrderListener.SearchConfirmMouseListener;
import hrs.client.UI.WebStaffUI.WebMarketUI.WebMarketListener.AddWebMarketerMouseListener;
import hrs.client.UI.WebStaffUI.WebMarketUI.WebMarketListener.ModifyWebMarketerMouseListener;
import hrs.client.UI.WebStaffUI.WebMarketUI.WebMarketListener.SearchWebMarketerConfirmMouseListener;
import hrs.client.util.ControllerFactory;
import hrs.client.util.HRSButton;
import hrs.client.util.UIConstants;
import hrs.common.Controller.WebStaffController.IWebStaffController;
import hrs.common.Exception.StaffService.StaffExistedException;
import hrs.common.Exception.StaffService.StaffNotFoundExceptioon;
import hrs.common.VO.StaffVO;
import hrs.common.util.type.StaffType;
import net.sf.ehcache.transaction.TransactionTimeoutException;

import javax.swing.JButton;

public class WebMarketerUIPanel extends JPanel {
	private JLabel jlWebMarketerSearch;
	private JLabel jlWebMarketerUsername;
	private JLabel jlWebMarketerPassword;
	private JLabel jlWebMarketerRealName;
	private JTextField jtextWebMarketerUsername;
	private JTextField jtextPassword;
	private JTextField jtextWebMarketerRealName;
	private HRSButton jbSearchWebMarketerConfirm;
	private HRSButton jbModifyWebMarketer;
	private HRSButton jbAddWebMarketer;
	private IWebStaffController controller = ControllerFactory.getWebStaffController();
	private StaffVO webMarketerVO;
	private SearchWebMarketerConfirmMouseListener searchWebMarketerConfirmMouseListener;
	private ModifyWebMarketerMouseListener modifyWebMarketerMouseListener;
	private AddWebMarketerMouseListener addWebMarketerMouseListener;
	private AddWebMarketerDialog addWebMarketerDialog=new AddWebMarketerDialog(this);
	private JLabel jlUsernameShow;

	/**
	 * Create the panel.
	 */
	public WebMarketerUIPanel() {
		init();
	}

	public void init() {
		this.setSize(1080, 722);
		this.setBackground(UIConstants.JFRAME);

		jlWebMarketerSearch = new JLabel("搜索网站营销人员");
		jlWebMarketerSearch.setFont(UIConstants.JLABEL_FONT);

		jlWebMarketerUsername = new JLabel("用户名");
		jlWebMarketerUsername.setFont(UIConstants.JLABEL_FONT);

		jlWebMarketerPassword = new JLabel("密码");
		jlWebMarketerPassword.setFont(UIConstants.JLABEL_FONT);

		jlWebMarketerRealName = new JLabel("真实姓名");
		jlWebMarketerRealName.setFont(UIConstants.JLABEL_FONT);

		jtextWebMarketerUsername = new JTextField();
		jtextWebMarketerUsername.setColumns(10);

		jtextPassword = new JTextField();
		jtextPassword.setColumns(10);

		jtextWebMarketerRealName = new JTextField();
		jtextWebMarketerRealName.setColumns(10);

		jbSearchWebMarketerConfirm = new HRSButton("确认");
		jbSearchWebMarketerConfirm.setFont(new Font("宋体", Font.PLAIN, 18));
		searchWebMarketerConfirmMouseListener = new SearchWebMarketerConfirmMouseListener(this);
		jbSearchWebMarketerConfirm.addMouseListener(searchWebMarketerConfirmMouseListener);

		jbModifyWebMarketer = new HRSButton("修改");
		jbModifyWebMarketer.setFont(new Font("宋体", Font.PLAIN, 21));
		modifyWebMarketerMouseListener = new ModifyWebMarketerMouseListener(this);
		jbModifyWebMarketer.addMouseListener(modifyWebMarketerMouseListener);

		jbAddWebMarketer = new HRSButton("添加");
		addWebMarketerMouseListener = new AddWebMarketerMouseListener(this);
		jbAddWebMarketer.addMouseListener(addWebMarketerMouseListener);
		
		jlUsernameShow = new JLabel();

		GroupLayout groupLayout = new GroupLayout(this);
		groupLayout.setHorizontalGroup(
			groupLayout.createParallelGroup(Alignment.TRAILING)
				.addGroup(groupLayout.createSequentialGroup()
					.addGap(61)
					.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
						.addComponent(jlWebMarketerSearch)
						.addComponent(jlWebMarketerUsername)
						.addComponent(jlWebMarketerPassword)
						.addComponent(jlWebMarketerRealName))
					.addGap(69)
					.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
						.addComponent(jtextWebMarketerRealName, GroupLayout.DEFAULT_SIZE, 211, Short.MAX_VALUE)
						.addComponent(jtextPassword, GroupLayout.DEFAULT_SIZE, 211, Short.MAX_VALUE)
						.addComponent(jtextWebMarketerUsername, GroupLayout.DEFAULT_SIZE, 211, Short.MAX_VALUE)
						.addComponent(jlUsernameShow, Alignment.TRAILING, GroupLayout.DEFAULT_SIZE, 211, Short.MAX_VALUE))
					.addGap(66)
					.addComponent(jbSearchWebMarketerConfirm)
					.addGap(425))
				.addGroup(groupLayout.createSequentialGroup()
					.addContainerGap(691, Short.MAX_VALUE)
					.addComponent(jbModifyWebMarketer)
					.addGap(94)
					.addComponent(jbAddWebMarketer)
					.addGap(123))
		);
		groupLayout.setVerticalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(groupLayout.createSequentialGroup()
					.addGap(53)
					.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
						.addComponent(jlWebMarketerSearch)
						.addComponent(jtextWebMarketerUsername, GroupLayout.PREFERRED_SIZE, 37, GroupLayout.PREFERRED_SIZE)
						.addComponent(jbSearchWebMarketerConfirm, GroupLayout.PREFERRED_SIZE, 32, GroupLayout.PREFERRED_SIZE))
					.addGap(41)
					.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
						.addComponent(jlWebMarketerUsername)
						.addComponent(jlUsernameShow, GroupLayout.PREFERRED_SIZE, 24, GroupLayout.PREFERRED_SIZE))
					.addGap(41)
					.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
						.addComponent(jlWebMarketerPassword)
						.addComponent(jtextPassword, GroupLayout.PREFERRED_SIZE, 37, GroupLayout.PREFERRED_SIZE))
					.addGap(41)
					.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
						.addComponent(jlWebMarketerRealName)
						.addComponent(jtextWebMarketerRealName, GroupLayout.PREFERRED_SIZE, 37, GroupLayout.PREFERRED_SIZE))
					.addGap(190)
					.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
						.addComponent(jbModifyWebMarketer)
						.addComponent(jbAddWebMarketer))
					.addContainerGap(179, Short.MAX_VALUE))
		);
		setLayout(groupLayout);
	}

	public StaffVO searchAndShow() {
		try {
			webMarketerVO = controller.findStaffByUsername(jtextWebMarketerUsername.getText());
		} catch (StaffNotFoundExceptioon e) {
			// TODO Auto-generated catch block
			JOptionPane.showMessageDialog(this, "网站营销人员不存在！", "No Such WebMarketer", JOptionPane.ERROR_MESSAGE);
		}
		jlUsernameShow.setText(webMarketerVO.username);
		jtextPassword.setText(webMarketerVO.password);
		jtextWebMarketerRealName.setText(webMarketerVO.name);
		return webMarketerVO;
	}

	public void modify() {
		String newPassword = jtextPassword.getText();
		String newName = jtextWebMarketerRealName.getText();
		webMarketerVO.password=newPassword;
		webMarketerVO.name=newName;
		controller.updateStaff(webMarketerVO);
	}

	public void add() {
		// if (addWebMarketerDialog.setAddIndex() == 1) {
		StaffVO addStaffVO = addWebMarketerDialog.getInput();
//		System.out.println(addStaffVO);
		int result = JOptionPane.showConfirmDialog(null, "是否确定添加？", "提示", JOptionPane.YES_NO_OPTION,
				JOptionPane.INFORMATION_MESSAGE);
		if (result == 0) {
		try {
			controller.addStaff(addStaffVO);
			JOptionPane.showConfirmDialog(null, "信息添加成功", "添加成功", JOptionPane.PLAIN_MESSAGE,
					JOptionPane.INFORMATION_MESSAGE);
		} catch (StaffExistedException e) {
			// TODO Auto-generated catch block
			JOptionPane.showMessageDialog(this, "网站营销人员已存在！", "Such WebMarketer Existed", JOptionPane.ERROR_MESSAGE);
		}
		}
		addWebMarketerDialog.dispose();
	}
	// }

	public void showDialog() {
//		addWebMarketerDialog.show();
		addWebMarketerDialog.setVisible(true);
		addWebMarketerDialog.setLocationRelativeTo(null);
	}

}
