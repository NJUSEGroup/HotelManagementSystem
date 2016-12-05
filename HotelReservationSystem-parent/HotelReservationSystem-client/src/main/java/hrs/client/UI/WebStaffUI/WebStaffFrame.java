package hrs.client.UI.WebStaffUI;

import java.awt.BorderLayout;
import java.awt.CardLayout;
import java.awt.Color;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import hrs.client.UI.WebStaffUI.HotelAddUI.HotelAddUIPanel;
import hrs.client.UI.WebStaffUI.HotelAddUI.HotelStaffAddUIPanel;
import hrs.client.UI.WebStaffUI.HotelStaffUI.HotelStaffUIPanel;
import hrs.client.UI.WebStaffUI.WebMarketUI.AddWebMarketerDialog;
import hrs.client.UI.WebStaffUI.WebMarketUI.WebMarketerUIPanel;
import hrs.client.UI.WebStaffUI.WebStaffListener.WebStaffMenulistMouseListener;
import hrs.client.UI.WebStaffUI.WebUserUI.ShowUserInfoPanel;
import hrs.client.UI.WebStaffUI.WebUserUI.WebUserUIPanel;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.LayoutStyle.ComponentPlacement;

public class WebStaffFrame extends JFrame {
	/**
	 * 
	 */
	private static final long serialVersionUID = 6293618787121106494L;
	private CardLayout cardLayout;
	MenulistPanel menulistPanel;
	private HotelAddUIPanel jpHotelAdd = new HotelAddUIPanel(this);
	private HotelStaffAddUIPanel jpHotelStaffAdd= new HotelStaffAddUIPanel(this,jpHotelAdd);
	private WebMarketerUIPanel jpWebMarketer= new WebMarketerUIPanel();
//	private AddWebMarketerDialog addWebMarketerDialog=new AddWebMarketerDialog(jpWebMarketer);
	private HotelStaffUIPanel jpHotelStaff= new HotelStaffUIPanel();
	private WebUserUIPanel jpWebUser= new WebUserUIPanel(new ShowUserInfoPanel());
	WebStaffMenulistMouseListener listener = new WebStaffMenulistMouseListener();

	private JPanel contentPane;
	private JPanel jpCard;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					WebStaffFrame frame = new WebStaffFrame();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public WebStaffFrame() {
		setTitle("酒店预订系统");
		init();
	}

	public void init() {
		menulistPanel = new MenulistPanel();
		menulistPanel.setBounds(5, 5, 263, 722);

		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setSize(1366, 768);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(211, 237, 249));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);

		jpCard = new JPanel();
		GroupLayout gl_contentPane = new GroupLayout(contentPane);
		gl_contentPane
				.setHorizontalGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_contentPane.createSequentialGroup()
								.addComponent(menulistPanel, GroupLayout.PREFERRED_SIZE, 263,
										GroupLayout.PREFERRED_SIZE)
								.addPreferredGap(ComponentPlacement.RELATED)
								.addComponent(jpCard, GroupLayout.PREFERRED_SIZE, 1080, GroupLayout.PREFERRED_SIZE)
								.addContainerGap(10, Short.MAX_VALUE)));
		gl_contentPane.setVerticalGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_contentPane.createSequentialGroup()
						.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
								.addComponent(menulistPanel, GroupLayout.PREFERRED_SIZE, 722,
										GroupLayout.PREFERRED_SIZE)
								.addComponent(jpCard, GroupLayout.PREFERRED_SIZE, 722, GroupLayout.PREFERRED_SIZE))
						.addContainerGap(110, Short.MAX_VALUE)));
		contentPane.setLayout(gl_contentPane);
	
		cardLayout = new CardLayout();
		jpCard.setLayout(cardLayout);
		jpCard.setBounds(273, 5, 1080, 722);	
		jpCard.setBackground(new Color(211, 237, 249));
		
		jpCard.add(jpWebUser, "用户");
		jpCard.add(jpHotelStaff, "酒店工作人员");
		jpCard.add(jpWebMarketer, "网站营销人员");
		jpCard.add(jpHotelAdd, "酒店添加");
		jpCard.add(jpHotelStaffAdd, "酒店工作人员添加");
		cardLayout.show(jpCard, "用户");

		listener.setCard(cardLayout, jpCard);
		contentPane.add(jpCard);
	}
	public void showHotelStaffAddUIPanel(){
		cardLayout.show(jpCard, "酒店工作人员添加");		
	}
	public void showHotelAddUIPanel(){
		cardLayout.show(jpCard, "酒店添加");
	}

}
