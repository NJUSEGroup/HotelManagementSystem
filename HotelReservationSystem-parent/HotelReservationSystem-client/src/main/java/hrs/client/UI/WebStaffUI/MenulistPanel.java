package hrs.client.UI.WebStaffUI;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

import hrs.client.UI.WebStaffUI.WebStaffListener.WebStaffMenulistMouseListener;

public class MenulistPanel extends JPanel{
	private JLabel jlZone=new JLabel("网站管理中心",JLabel.CENTER);
	private JLabel jlIdentity=new JLabel("网站管理人员",JLabel.CENTER);
	private JLabel jlUsername=new JLabel("宋管理",JLabel.CENTER);//要改
	private JLabel jlUserInfo=new JLabel("用户信息管理",JLabel.CENTER);
	private JLabel jlHotelAdd=new JLabel("酒店信息添加",JLabel.CENTER);
	private JLabel jlUser=new JLabel("•用户              ",JLabel.CENTER);
	private JLabel jlHotelStaff=new JLabel("•酒店工作人员",JLabel.CENTER);
	private JLabel jlWebMarketer=new JLabel("•网站营销人员",JLabel.CENTER);
	private WebStaffMenulistMouseListener listener=new WebStaffMenulistMouseListener();
	
	public MenulistPanel(){
		setBackground(new Color(211, 237, 249));
		setLayout(null);

	    jlZone.setBounds(0, 0, 263, 79);
		jlZone.setFont(new Font("Arial Unicode MS", Font.PLAIN, 25));
		jlZone.setOpaque(true);
		jlZone.setBackground(new Color(145, 179, 179));
		
		jlIdentity.setBounds(0, 79, 263, 29);
		jlIdentity.setFont(new Font("Arial Unicode MS", Font.PLAIN, 21));
		
		jlUsername.setBounds(0, 108, 263, 29);
		jlUsername.setFont(new Font("Arial Unicode MS", Font.PLAIN, 21));
		
		jlUserInfo.setBounds(0, 200, 263, 65);
		jlUserInfo.setFont(new Font("Arial Unicode MS", Font.PLAIN, 21));
		jlUserInfo.setForeground(Color.WHITE);
		jlUserInfo.setOpaque(true);
		jlUserInfo.setBackground(new Color(0, 160, 233));
				
		jlUser.setBounds(0, 265, 263, 45);
		jlUser.setFont(new Font("Arial Unicode MS", Font.PLAIN, 21));
		jlUser.addMouseListener(listener);
//		System.out.println("!"+jlUser.getText()+"!");
		jlUser.addMouseListener(new MouseListener() {
			@Override
			public void mouseEntered(MouseEvent e) {
				// TODO Auto-generated method stub
				jlUserInfo.setBackground(Color.WHITE);
				jlUserInfo.setForeground(Color.BLACK);
				jlUser.setForeground(new Color(145, 179, 179));
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
				jlUserInfo.setBackground(new Color(0, 160, 233));
				jlUserInfo.setForeground(Color.white);
				jlUser.setForeground(Color.BLACK);
				
			}
		});
		
		jlHotelStaff.setBounds(0, 310, 263, 45);
		jlHotelStaff.setBackground(new Color(211, 237, 249));
		jlHotelStaff.setFont(new Font("Arial Unicode MS", Font.PLAIN, 21));
		jlHotelStaff.setOpaque(true);
		jlHotelStaff.addMouseListener(listener);
		jlHotelStaff.addMouseListener(new MouseListener() {
			@Override
			public void mouseEntered(MouseEvent e) {
				// TODO Auto-generated method stub
				jlUserInfo.setBackground(Color.WHITE);
				jlUserInfo.setForeground(Color.BLACK);
				jlHotelStaff.setForeground(new Color(145, 179, 179));
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
				jlUserInfo.setBackground(new Color(0, 160, 233));
				jlUserInfo.setForeground(Color.white);
				jlHotelStaff.setForeground(Color.BLACK);
				
			}
		});
		
		jlWebMarketer.setBounds(0, 355, 263, 45);
		jlWebMarketer.setBackground(new Color(211, 237, 249));
		jlWebMarketer.setFont(new Font("Arial Unicode MS", Font.PLAIN, 21));
		jlWebMarketer.setOpaque(true);
		jlWebMarketer.addMouseListener(listener);
		jlWebMarketer.addMouseListener(new MouseListener() {
			@Override
			public void mouseEntered(MouseEvent e) {
				// TODO Auto-generated method stub
				jlUserInfo.setBackground(Color.WHITE);
				jlUserInfo.setForeground(Color.BLACK);
				jlWebMarketer.setForeground(new Color(145, 179, 179));
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
				jlUserInfo.setBackground(new Color(0, 160, 233));
				jlUserInfo.setForeground(Color.white);
				jlWebMarketer.setForeground(Color.BLACK);
				
			}
		});
		
		jlHotelAdd.setBounds(0, 400, 257, 65);
		jlHotelAdd.setFont(new Font("Arial Unicode MS", Font.PLAIN, 21));
		jlHotelAdd.setForeground(Color.WHITE);
		jlHotelAdd.setOpaque(true);
		jlHotelAdd.setBackground(new Color(0, 160, 233));
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
	public JLabel jlUserInfo(){
		return jlUserInfo;
	}
//	public static void main(String[]args){
//		JFrame frame=new JFrame();
//		MenulistPanel panel=new MenulistPanel();
//		frame.add(panel);
//		frame.setVisible(true);
//	}
}
//这里的监听
