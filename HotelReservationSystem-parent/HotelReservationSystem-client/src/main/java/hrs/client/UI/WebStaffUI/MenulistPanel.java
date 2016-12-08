package hrs.client.UI.WebStaffUI;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

import hrs.client.UI.WebStaffUI.WebStaffListener.WebStaffMenulistMouseListener;
import hrs.client.util.UIConstants;

public class MenulistPanel extends JPanel {
	private JLabel jlZone;
	private JLabel jlIdentity;
	private JLabel jlUsername;
	private JLabel jlUserInfo;
	private JLabel jlHotelAdd;
	private JLabel jlUser;
	private JLabel jlHotelStaff;
	private JLabel jlWebMarketer;
	private WebStaffMenulistMouseListener listener;

	public MenulistPanel() {
		init();
	}

	public void init() {
		listener = new WebStaffMenulistMouseListener();
		
		setBackground(UIConstants.JFRAME);
		setLayout(null);

		jlZone = new JLabel("网站管理中心", JLabel.CENTER);
		jlZone.setBounds(0, 0, 263, 79);
		jlZone.setFont(UIConstants.JZONE_FONT);
		jlZone.setOpaque(true);
		jlZone.setBackground(UIConstants.JZONE);
		jlZone.setForeground(UIConstants.JZONE_FONT_COLOR);
		
		jlIdentity = new JLabel("网站管理人员", JLabel.CENTER);
		jlIdentity.setBounds(0, 79, 263, 29);
		jlIdentity.setFont(UIConstants.JLABEL_FONT);

		jlUsername = new JLabel("宋管理", JLabel.CENTER);// 要改
		jlUsername.setBounds(0, 108, 263, 29);
		jlUsername.setFont(UIConstants.JLABEL_FONT);

		jlUserInfo = new JLabel("用户信息管理", JLabel.CENTER);
		jlUserInfo.setBounds(0, 200, 263, 65);
		jlUserInfo.setFont(UIConstants.JLABEL_FONT);
		jlUserInfo.setForeground(Color.WHITE);
		jlUserInfo.setOpaque(true);
		jlUserInfo.setBackground(UIConstants.JLABEL);

		jlUser = new JLabel("•用户              ", JLabel.CENTER);
		jlUser.setBounds(0, 265, 263, 45);
		jlUser.setFont(UIConstants.JLABEL_FONT);
		jlUser.addMouseListener(listener);
		jlUser.addMouseListener(new MouseListener() {
			@Override
			public void mouseEntered(MouseEvent e) {
				// TODO Auto-generated method stub
				jlUserInfo.setBackground(Color.WHITE);
				jlUserInfo.setForeground(Color.GRAY);
				jlUser.setForeground(UIConstants.JZONE_FONT_COLOR);
			}

			@Override
			public void mouseClicked(MouseEvent e) {
				// TODO Auto-generated method stub

			}

			@Override
			public void mousePressed(MouseEvent e) {
				// TODO Auto-generated method stub

			}

			@Override
			public void mouseReleased(MouseEvent e) {
				// TODO Auto-generated method stub

			}

			@Override
			public void mouseExited(MouseEvent e) {
				// TODO Auto-generated method stub
				jlUserInfo.setBackground(UIConstants.JLABEL);
				jlUserInfo.setForeground(Color.white);
				jlUser.setForeground(Color.BLACK);

			}
		});

		jlHotelStaff = new JLabel("•酒店工作人员", JLabel.CENTER);
		jlHotelStaff.setBounds(0, 310, 263, 45);
		jlHotelStaff.setBackground(UIConstants.JFRAME);
		jlHotelStaff.setFont(UIConstants.JLABEL_FONT);
		jlHotelStaff.setOpaque(true);
		jlHotelStaff.addMouseListener(listener);
		jlHotelStaff.addMouseListener(new MouseListener() {
			@Override
			public void mouseEntered(MouseEvent e) {
				// TODO Auto-generated method stub
				jlUserInfo.setBackground(Color.WHITE);
				jlUserInfo.setForeground(Color.GRAY);
				jlHotelStaff.setForeground(UIConstants.JZONE_FONT_COLOR);
			}

			@Override
			public void mouseClicked(MouseEvent e) {
				// TODO Auto-generated method stub

			}

			@Override
			public void mousePressed(MouseEvent e) {
				// TODO Auto-generated method stub

			}

			@Override
			public void mouseReleased(MouseEvent e) {
				// TODO Auto-generated method stub

			}

			@Override
			public void mouseExited(MouseEvent e) {
				// TODO Auto-generated method stub
				jlUserInfo.setBackground(UIConstants.JLABEL);
				jlUserInfo.setForeground(Color.white);
				jlHotelStaff.setForeground(Color.BLACK);

			}
		});

		jlWebMarketer = new JLabel("•网站营销人员", JLabel.CENTER);
		jlWebMarketer.setBounds(0, 355, 263, 45);
		jlWebMarketer.setBackground(UIConstants.JFRAME);
		jlWebMarketer.setFont(UIConstants.JLABEL_FONT);
		jlWebMarketer.setOpaque(true);
		jlWebMarketer.addMouseListener(listener);
		jlWebMarketer.addMouseListener(new MouseListener() {
			@Override
			public void mouseEntered(MouseEvent e) {
				// TODO Auto-generated method stub
				jlUserInfo.setBackground(Color.WHITE);
				jlUserInfo.setForeground(Color.GRAY);
				jlWebMarketer.setForeground(UIConstants.JZONE_FONT_COLOR);
			}

			@Override
			public void mouseClicked(MouseEvent e) {
				// TODO Auto-generated method stub

			}

			@Override
			public void mousePressed(MouseEvent e) {
				// TODO Auto-generated method stub

			}

			@Override
			public void mouseReleased(MouseEvent e) {
				// TODO Auto-generated method stub

			}

			@Override
			public void mouseExited(MouseEvent e) {
				// TODO Auto-generated method stub
				jlUserInfo.setBackground(UIConstants.JLABEL);
				jlUserInfo.setForeground(Color.white);
				jlWebMarketer.setForeground(Color.BLACK);

			}
		});

		jlHotelAdd = new JLabel("酒店信息添加", JLabel.CENTER);
		jlHotelAdd.setBounds(0, 400, 263, 65);
		jlHotelAdd.setFont(UIConstants.JLABEL_FONT);
		jlHotelAdd.setForeground(Color.WHITE);
		jlHotelAdd.setOpaque(true);
		jlHotelAdd.setBackground(UIConstants.JLABEL);
		jlHotelAdd.addMouseListener(listener);

		add(jlZone);
		add(jlIdentity);
		add(jlUsername);
		add(jlUserInfo);
		add(jlUser);
		add(jlHotelStaff);
		add(jlWebMarketer);
		add(jlHotelAdd);
	}

	public JLabel jlUserInfo() {
		return jlUserInfo;
	}
}
