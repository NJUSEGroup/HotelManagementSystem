package hrs.client.UI.WebStaffUI.WebMarketUI;

import java.awt.Color;
import java.awt.Font;

import javax.swing.JPanel;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;

import hrs.client.UI.WebMarketUI.WebOrderUI.WebOrderListener.searchConfirmMouseListener;
import hrs.client.UI.WebStaffUI.WebMarketUI.WebMarketListener.AddWebMarketerMouseListener;
import hrs.client.UI.WebStaffUI.WebMarketUI.WebMarketListener.ModifyWebMarketerMouseListener;
import hrs.client.UI.WebStaffUI.WebMarketUI.WebMarketListener.SearchWebMarketerConfirmMouseListener;
import hrs.client.util.ControllerFactory;
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
	private JTextField jtextUsername;
	private JTextField jtextPassword;
	private JTextField jtextWebMarketerRealName;
	private JButton jbSearchWebMarketerConfirm;
	private JButton jbModifyWebMarketer;
	private JButton jbAddWebMarketer;
	private IWebStaffController controller = ControllerFactory.getWebStaffController();
	private StaffVO webMarketerVO;
	private SearchWebMarketerConfirmMouseListener searchWebMarketerConfirmMouseListener;
	private ModifyWebMarketerMouseListener modifyWebMarketerMouseListener;
	private AddWebMarketerMouseListener addWebMarketerMouseListener;
	private AddWebMarketerDialog addWebMarketerDialog=new AddWebMarketerDialog(this);

	/**
	 * Create the panel.
	 */
	public WebMarketerUIPanel() {
		init();
	}

	public void init() {
		this.setSize(1080, 722);
		this.setBackground(new Color(211, 237, 249));

		jlWebMarketerSearch = new JLabel("搜索网站营销人员");
		jlWebMarketerSearch.setFont(new Font("Arial Unicode MS", Font.PLAIN, 21));

		jlWebMarketerUsername = new JLabel("用户名");
		jlWebMarketerUsername.setFont(new Font("Arial Unicode MS", Font.PLAIN, 21));

		jlWebMarketerPassword = new JLabel("密码");
		jlWebMarketerPassword.setFont(new Font("Arial Unicode MS", Font.PLAIN, 21));

		jlWebMarketerRealName = new JLabel("真实姓名");
		jlWebMarketerRealName.setFont(new Font("Arial Unicode MS", Font.PLAIN, 21));

		jtextWebMarketerUsername = new JTextField();
		jtextWebMarketerUsername.setColumns(10);

		jtextUsername = new JTextField();
		jtextUsername.setColumns(10);

		jtextPassword = new JTextField();
		jtextPassword.setColumns(10);

		jtextWebMarketerRealName = new JTextField();
		jtextWebMarketerRealName.setColumns(10);

		jbSearchWebMarketerConfirm = new JButton("确认");
		jbSearchWebMarketerConfirm.setFont(new Font("Arial Unicode MS", Font.PLAIN, 18));
		jbSearchWebMarketerConfirm.setBackground(new Color(0, 160, 233));
		jbSearchWebMarketerConfirm.setForeground(Color.WHITE);
		jbSearchWebMarketerConfirm.setBorderPainted(false);
		jbSearchWebMarketerConfirm.setOpaque(true);
		searchWebMarketerConfirmMouseListener = new SearchWebMarketerConfirmMouseListener(this);
		jbSearchWebMarketerConfirm.addMouseListener(searchWebMarketerConfirmMouseListener);

		jbModifyWebMarketer = new JButton("修改");
		jbModifyWebMarketer.setFont(new Font("Arial Unicode MS", Font.PLAIN, 21));
		jbModifyWebMarketer.setBackground(new Color(0, 160, 233));
		jbModifyWebMarketer.setForeground(Color.WHITE);
		jbModifyWebMarketer.setBorderPainted(false);
		jbModifyWebMarketer.setOpaque(true);
		modifyWebMarketerMouseListener = new ModifyWebMarketerMouseListener(this);
		jbModifyWebMarketer.addMouseListener(modifyWebMarketerMouseListener);

		jbAddWebMarketer = new JButton("添加");
		jbAddWebMarketer.setFont(new Font("Arial Unicode MS", Font.PLAIN, 21));
		jbAddWebMarketer.setBackground(new Color(0, 160, 233));
		jbAddWebMarketer.setForeground(Color.WHITE);
		jbAddWebMarketer.setBorderPainted(false);
		jbAddWebMarketer.setOpaque(true);
		addWebMarketerMouseListener = new AddWebMarketerMouseListener(this);
		jbAddWebMarketer.addMouseListener(addWebMarketerMouseListener);

		GroupLayout groupLayout = new GroupLayout(this);
		groupLayout.setHorizontalGroup(groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(groupLayout.createSequentialGroup().addGap(61)
						.addGroup(groupLayout.createParallelGroup(Alignment.LEADING).addComponent(jlWebMarketerSearch)
								.addComponent(jlWebMarketerUsername).addComponent(jlWebMarketerPassword)
								.addComponent(jlWebMarketerRealName))
						.addGap(69)
						.addGroup(
								groupLayout.createParallelGroup(Alignment.LEADING)
										.addComponent(jtextWebMarketerRealName, GroupLayout.DEFAULT_SIZE, 211,
												Short.MAX_VALUE)
										.addComponent(jtextPassword, GroupLayout.DEFAULT_SIZE, 211, Short.MAX_VALUE)
										.addComponent(jtextWebMarketerUsername, GroupLayout.DEFAULT_SIZE, 211,
												Short.MAX_VALUE)
										.addComponent(jtextUsername, GroupLayout.DEFAULT_SIZE, 211, Short.MAX_VALUE))
						.addGap(66).addComponent(jbSearchWebMarketerConfirm).addGap(425))
				.addGroup(Alignment.TRAILING, groupLayout.createSequentialGroup().addContainerGap(629, Short.MAX_VALUE)
						.addComponent(jbModifyWebMarketer).addGap(94).addComponent(jbAddWebMarketer).addGap(123)));
		groupLayout.setVerticalGroup(groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(groupLayout.createSequentialGroup().addGap(53)
						.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE).addComponent(jlWebMarketerSearch)
								.addComponent(jtextWebMarketerUsername, GroupLayout.PREFERRED_SIZE, 37,
										GroupLayout.PREFERRED_SIZE)
								.addComponent(jbSearchWebMarketerConfirm, GroupLayout.PREFERRED_SIZE, 32,
										GroupLayout.PREFERRED_SIZE))
						.addGap(41)
						.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
								.addComponent(jlWebMarketerUsername).addComponent(jtextUsername,
										GroupLayout.PREFERRED_SIZE, 37, GroupLayout.PREFERRED_SIZE))
						.addGap(41)
						.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
								.addComponent(jlWebMarketerPassword).addComponent(jtextPassword,
										GroupLayout.PREFERRED_SIZE, 37, GroupLayout.PREFERRED_SIZE))
						.addGap(41)
						.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
								.addComponent(jlWebMarketerRealName).addComponent(jtextWebMarketerRealName,
										GroupLayout.PREFERRED_SIZE, 37, GroupLayout.PREFERRED_SIZE))
						.addGap(190).addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
								.addComponent(jbModifyWebMarketer).addComponent(jbAddWebMarketer))
						.addContainerGap(143, Short.MAX_VALUE)));
		setLayout(groupLayout);
	}

	public StaffVO searchAndShow() {
		try {
			webMarketerVO = controller.findStaffByUsername(jtextWebMarketerUsername.getText());
		} catch (StaffNotFoundExceptioon e) {
			// TODO Auto-generated catch block
			JOptionPane.showMessageDialog(this, "网站营销人员不存在！", "No Such WebMarketer", JOptionPane.ERROR_MESSAGE);
		}
		jtextUsername.setText(webMarketerVO.username);
		jtextPassword.setText(webMarketerVO.password);
		jtextWebMarketerRealName.setText(webMarketerVO.name);
		return webMarketerVO;
	}

	public void modify() {
		String newUsername = jtextUsername.getText();
		String newPassword = jtextPassword.getText();
		String newName = jtextWebMarketerRealName.getText();
		StaffVO newWebMarketerVO = new StaffVO(newUsername, newPassword, newName, StaffType.WebsiteMarketer, null);
		// System.out.println(newWebMarketerVO);
		controller.updateStaff(newWebMarketerVO);
	}

	public void add() {
		// if (addWebMarketerDialog.setAddIndex() == 1) {
		StaffVO addStaffVO = addWebMarketerDialog.getInput();
		System.out.println(addStaffVO);
		try {
			controller.addStaff(addStaffVO);
		} catch (StaffExistedException e) {
			// TODO Auto-generated catch block
			JOptionPane.showMessageDialog(this, "网站营销人员已存在！", "Such WebMarketer Existed", JOptionPane.ERROR_MESSAGE);
		}
		addWebMarketerDialog.dispose();
	}
	// }

	public void showDialog() {
		addWebMarketerDialog.show();
	}

}
