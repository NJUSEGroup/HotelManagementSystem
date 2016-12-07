package hrs.client.UI.WebStaffUI.WebMarketUI;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.FlowLayout;

import javax.swing.GroupLayout;
import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import hrs.client.UI.WebStaffUI.WebMarketUI.WebMarketListener.AddWebMarketerDialogConfirmMouseListener;
import hrs.common.VO.StaffVO;
import hrs.common.util.type.StaffType;

import javax.swing.JLabel;
import javax.swing.JTextField;

public class AddWebMarketerDialog extends JDialog {

	private final JPanel jpAddWebMarketer = new JPanel();
	private JTextField jtextUsername;
	private JTextField jtextPassword;
	private JTextField jtextRealName;
	private AddWebMarketerDialogConfirmMouseListener addWebMarketerDialogConfirmMouseListener;
	private WebMarketerUIPanel webMarketerUIPanel;
	private JLabel jlUsername;
	private JLabel jlPassword;
	private JLabel jlRealName;
	private JButton jbConfirm;
	private JButton jbCancel;

//	/**
//	 * Launch the application.
//	 */
//	public static void main(String[] args) {
//		try {
//			AddWebMarketerDialog dialog = new AddWebMarketerDialog();
//			dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
//			dialog.setVisible(true);
//		} catch (Exception e) {
//			e.printStackTrace();
//		}
//	}

	/**
	 * Create the dialog.
	 */
	public AddWebMarketerDialog(WebMarketerUIPanel webMarketerUIPanel) {//panel!
		this.webMarketerUIPanel=webMarketerUIPanel;
		init();
	}

	public void init(){
		setTitle("添加网站营销人员");
		setBounds(100, 100, 400, 280);
		getContentPane().setLayout(null);
		jpAddWebMarketer.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(jpAddWebMarketer, BorderLayout.CENTER);
		
		jlUsername = new JLabel("用户名");
		jlUsername.setBounds(86, 33, 61, 16);
		getContentPane().add(jlUsername);
		
		jlPassword = new JLabel("密码");
		jlPassword.setBounds(86, 77, 61, 16);
		getContentPane().add(jlPassword);
		
		jlRealName = new JLabel("真实姓名");
		jlRealName.setBounds(86, 125, 61, 16);
		getContentPane().add(jlRealName);
		
		jtextUsername = new JTextField();
		jtextUsername.setBounds(181, 28, 130, 26);
		getContentPane().add(jtextUsername);
		jtextUsername.setColumns(10);
		
		jtextPassword = new JTextField();
		jtextPassword.setBounds(181, 72, 130, 26);
		getContentPane().add(jtextPassword);
		jtextPassword.setColumns(10);
		
		jtextRealName = new JTextField();
		jtextRealName.setBounds(181, 120, 130, 26);
		getContentPane().add(jtextRealName);
		jtextRealName.setColumns(10);
		
		jbConfirm = new JButton("确认");
		jbConfirm.setBounds(107, 181, 75, 29);
		jbConfirm.setBackground(new Color(0, 160, 233));
		jbConfirm.setForeground(Color.WHITE);
		jbConfirm.setBorderPainted(false);
		jbConfirm.setOpaque(true);
		getContentPane().add(jbConfirm);
		addWebMarketerDialogConfirmMouseListener=new AddWebMarketerDialogConfirmMouseListener(webMarketerUIPanel);
		jbConfirm.addMouseListener(addWebMarketerDialogConfirmMouseListener);
		
		jbCancel = new JButton("取消");
		jbCancel.setBounds(211, 181, 75, 29);
		jbCancel.setBackground(new Color(0, 160, 233));
		jbCancel.setForeground(Color.WHITE);
		jbCancel.setBorderPainted(false);
		jbCancel.setOpaque(true);
		getContentPane().add(jbCancel);
	}
	public StaffVO getInput(){
		String addUsername=jtextUsername.getText();
		String addPassword=jtextPassword.getText();
		String addRealName=jtextRealName.getText();
		StaffVO addWebMarketerVO=new StaffVO(addUsername, addPassword, addRealName, StaffType.WebsiteMarketer, null);
//		System.out.println(addWebMarketerVO);
		return addWebMarketerVO;
	}
}
