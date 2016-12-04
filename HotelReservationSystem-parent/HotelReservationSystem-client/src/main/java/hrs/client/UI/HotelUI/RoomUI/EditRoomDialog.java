package hrs.client.UI.HotelUI.RoomUI;

import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.awt.Font;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JSpinner;
import javax.swing.JTextField;
import javax.swing.SpinnerNumberModel;
import javax.swing.border.EmptyBorder;

import hrs.client.UI.HotelUI.RoomUI.RoomUIPanel;
import hrs.common.VO.RoomVO;
import hrs.common.util.type.RoomType;

public class EditRoomDialog extends JDialog {

	private final JPanel contentPanel = new JPanel();
	private JPanel jpRoom;
	private JPanel jpButton;
	private JLabel jlRoomType;
	private JLabel jlRoomNum;
	private JLabel jlRoomMoney;
	private JLabel jlRMB;
	private JTextField jtfRoomType;
	private JSpinner jsRoomNum;
	private JTextField jtfRoomMoney;
	private JButton jbConfirm;
	private JButton jbCancel;
	private RoomUIPanel jpRoomUI;

	/**
	 * Create the dialog.
	 */
	public EditRoomDialog(RoomUIPanel jpRoom) {
		init(jpRoom);
	}
	
	public void init(RoomUIPanel jpRoomUI){
		this.jpRoomUI = jpRoomUI;
		setSize(450, 300);
		setLocationRelativeTo(null);
		getContentPane().setLayout(new BorderLayout());
		contentPanel.setLayout(null);
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		
		jpRoom = new JPanel();
		jpRoom.setBounds(0, 0, 432, 181);
		jpRoom.setLayout(null);
		
		jpButton = new JPanel();
		jpButton.setBounds(0, 181, 432, 69);
		jpButton.setLayout(null);
		
		jlRoomType = new JLabel();
		jlRoomType.setFont(new Font("宋体", Font.PLAIN, 18));
		jlRoomType.setText("房间类型");
		jlRoomType.setBounds(25, 13, 80, 30);
		
		jlRoomNum = new JLabel();
		jlRoomNum.setFont(new Font("宋体", Font.PLAIN, 18));
		jlRoomNum.setText("房间数量");
		jlRoomNum.setBounds(25, 71, 80, 30);
		
		jlRoomMoney = new JLabel();
		jlRoomMoney.setFont(new Font("宋体", Font.PLAIN, 18));
		jlRoomMoney.setText("原始价格");
		jlRoomMoney.setBounds(25, 129, 80, 30);
		
		jlRMB = new JLabel();
		jlRMB.setFont(new Font("宋体", Font.PLAIN, 18));
		jlRMB.setText("元");
		jlRMB.setBounds(323, 129, 80, 30);
		
		jtfRoomType = new JTextField();
		jtfRoomType.setText(jpRoomUI.getSelectedRoomType());
		jtfRoomType.setBounds(150, 15, 145, 30);
		jtfRoomType.setEditable(false);
		
		jsRoomNum = new JSpinner();
		jsRoomNum.setBounds(150, 73, 145, 30);
		jsRoomNum.setModel(new SpinnerNumberModel());
		
		jtfRoomMoney = new JTextField();
		jtfRoomMoney.setBounds(150, 131, 145, 30);
		jtfRoomMoney.setEditable(true);
		
		jbConfirm = new JButton();
		jbConfirm.setFont(new Font("宋体", Font.PLAIN, 16));
		jbConfirm.setText("确定");
		jbConfirm.setBounds(92, 13, 70, 40);
	//	jbConfirm.addMouseListener();
		
		jbCancel = new JButton();
		jbCancel.setFont(new Font("宋体", Font.PLAIN, 16));
		jbCancel.setText("取消");
		jbCancel.setBounds(264, 13, 70, 40);
	//	jbCancel.addMouseListener();
		
		jpRoom.add(jlRoomType);
		jpRoom.add(jlRoomNum);
		jpRoom.add(jlRoomMoney);
		jpRoom.add(jlRMB);
		jpRoom.add(jtfRoomType);
		jpRoom.add(jsRoomNum);
		jpRoom.add(jtfRoomMoney);
		
		jpButton.add(jbConfirm);
		jpButton.add(jbCancel);
		
		contentPanel.add(jpRoom);
		contentPanel.add(jpButton);
		
		this.setTitle("请输入修改房间的信息");
		this.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
		this.setVisible(true);
	}
	
	public void editConfirm(){
		RoomVO editRoom = new RoomVO();
		
		String editRoomType = jtfRoomType.getText();
		if(editRoomType.equals("单人房")){
			editRoom.type = RoomType.Single;
		}
		else if(editRoomType.equals("双人房")){
			editRoom.type = RoomType.Double;
		}
		else if(editRoomType.equals("大床间")){
			editRoom.type = RoomType.KingSize;
		}
		else if(editRoomType.equals("标准间")){
			editRoom.type = RoomType.Standard;
		}
		else if(editRoomType.equals("豪华间")){
			editRoom.type = RoomType.Deluxe;
		}
		else if(editRoomType.equals("商务标间")){
			editRoom.type = RoomType.Business;
		}
		else if(editRoomType.equals("行政标间")){
			editRoom.type = RoomType.Executive;
		}
		
		if(((Integer) jsRoomNum.getValue()).intValue()<0){
			JOptionPane.showMessageDialog(this, "房间数量不能为负数！", "错误", JOptionPane.ERROR_MESSAGE);
		}
		else if(((Integer) jsRoomNum.getValue()).intValue()==0){
			JOptionPane.showMessageDialog(this, "房间数量不能为零！", "错误", JOptionPane.ERROR_MESSAGE);
		}
		else if(Double.valueOf(jtfRoomMoney.getText())<0){
			JOptionPane.showMessageDialog(this, "原始价格不能为负数！", "错误", JOptionPane.ERROR_MESSAGE);
		}
		else{
			editRoom.roomNum = ((Integer) jsRoomNum.getValue()).intValue();
			editRoom.roomValue = Double.valueOf(jtfRoomMoney.getText());
			
			jpRoomUI.editRoom(editRoom);
			jpRoomUI.refreshRoomList();
			
			this.dispose();
			
			JOptionPane.showMessageDialog(this, "房间信息已更新", "更新成功", JOptionPane.INFORMATION_MESSAGE);
		}
	}
	
	public void editCancel(){
		this.dispose();
	}
}
