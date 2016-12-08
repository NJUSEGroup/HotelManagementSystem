package hrs.client.UI.WebStaffUI.WebUserUI;

import java.awt.Color;

import javax.swing.JPanel;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import java.util.Date;

import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.LayoutStyle.ComponentPlacement;

import org.aspectj.weaver.patterns.ThisOrTargetAnnotationPointcut;

import hrs.client.UI.WebMarketUI.WebOrderUI.WebOrderListener.SearchConfirmMouseListener;
import hrs.client.UI.WebStaffUI.WebUserUI.WebUserListener.ModifyUserInfoMouseListener;
import hrs.client.UI.WebStaffUI.WebUserUI.WebUserListener.SearchUserConfirmMouseListener;
import hrs.client.util.ControllerFactory;
import hrs.client.util.HRSButton;
import hrs.client.util.UIConstants;
import hrs.common.Controller.WebStaffController.IWebUserController;
import hrs.common.Exception.UserService.UserNotFoundException;
import hrs.common.VO.UserVO;
import hrs.common.util.DateHelper;

public class WebUserUIPanel extends JPanel {
	private IWebUserController controller = ControllerFactory.getWebUserController();
	private JTextField jtextUsername;
	private JLabel jlUserSearch;
	private HRSButton jbConfirm,jbModify;
	private ShowUserInfoPanel showUserInfoPanel;
	private SearchUserConfirmMouseListener confirmMouseListener;
	private UserVO userVO;
	private ModifyUserInfoMouseListener modifyUserInfoMouseListener;

	/**
	 * Create the panel.
	 */
	public WebUserUIPanel(ShowUserInfoPanel showUserInfoPanel) {
		this.showUserInfoPanel = showUserInfoPanel;
		init();
		this.add(showUserInfoPanel);
		showUserInfoPanel.setBounds(5, 80, 1068, 623);
		// showUserinfo(showUserInfoPanel);
	}

	public void init() {
		this.setSize(1080, 722);
		this.setBackground(UIConstants.JFRAME);

		jlUserSearch = new JLabel("搜索用户");
		jlUserSearch.setFont(UIConstants.JLABEL_FONT);

		jtextUsername = new JTextField();
		jtextUsername.setColumns(10);

		jbConfirm = new HRSButton("确认");
		confirmMouseListener = new SearchUserConfirmMouseListener(this);
		jbConfirm.addMouseListener(confirmMouseListener);
		
		jbModify = new HRSButton("修改");
		modifyUserInfoMouseListener=new ModifyUserInfoMouseListener(this);
		jbModify.addMouseListener(modifyUserInfoMouseListener);

		GroupLayout groupLayout = new GroupLayout(this);
		groupLayout.setHorizontalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(groupLayout.createSequentialGroup()
					.addGap(43)
					.addComponent(jlUserSearch, GroupLayout.PREFERRED_SIZE, 105, GroupLayout.PREFERRED_SIZE)
					.addGap(27)
					.addComponent(jtextUsername, GroupLayout.PREFERRED_SIZE, 217, GroupLayout.PREFERRED_SIZE)
					.addGap(62)
					.addComponent(jbConfirm)
					.addContainerGap())
				.addGroup(Alignment.TRAILING, groupLayout.createSequentialGroup()
					.addContainerGap(800, Short.MAX_VALUE)
					.addComponent(jbModify)
					.addGap(99))
		);
		groupLayout.setVerticalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(groupLayout.createSequentialGroup()
					.addGap(37)
					.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
						.addComponent(jlUserSearch)
						.addComponent(jbConfirm, GroupLayout.PREFERRED_SIZE, 35, GroupLayout.PREFERRED_SIZE)
						.addComponent(jtextUsername, GroupLayout.PREFERRED_SIZE, 38, GroupLayout.PREFERRED_SIZE))
					.addGap(552)
					.addComponent(jbModify)
					.addContainerGap(66, Short.MAX_VALUE))
		);
		setLayout(groupLayout);
	}

	public UserVO searchUserByUsername() {
		String username = jtextUsername.getText();
		try {
			userVO = controller.findUserByUsername(username);
		} catch (UserNotFoundException e) {
			// TODO Auto-generated catch block
			JOptionPane.showMessageDialog(this, "用户不存在！", "No Such User", JOptionPane.ERROR_MESSAGE);
		}
		return userVO;

	}

	public void modify(){     
	     userVO.password=showUserInfoPanel.getPassword();
	     userVO.name=showUserInfoPanel.getRealName();
	     //修改联系方式为什么生日会跟着变啊！！
	     userVO.birthDate=showUserInfoPanel.getBirthday();
	     userVO.phone=showUserInfoPanel.getPhone();
	     userVO.enterprise=showUserInfoPanel.getEnterpriseName();
	     controller.updateUser(userVO);	     
}
	

	public void showUserinfo() {
		showUserInfoPanel.inputInfo(searchUserByUsername());
	}
}
