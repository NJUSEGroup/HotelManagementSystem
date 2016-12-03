package hrs.client.UI.HotelUI.Components;

import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.awt.Font;

import javax.swing.DefaultComboBoxModel;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JSpinner;
import javax.swing.JTextField;
import javax.swing.SpinnerNumberModel;
import javax.swing.border.EmptyBorder;

import hrs.client.UI.HotelUI.RoomUI.RoomUIPanel;
import hrs.client.UI.HotelUI.RoomUI.Listener.AddCancelListener;
import hrs.client.UI.HotelUI.RoomUI.Listener.AddConfirmListener;
import hrs.client.util.ControllerFactory;
import hrs.common.Controller.HotelController.IRoomController;
import hrs.common.Exception.RoomService.RoomNotFoundException;
import hrs.common.VO.HotelVO;
import hrs.common.VO.RoomVO;
import hrs.common.util.type.RoomType;

import java.awt.event.ActionListener;
import java.util.List;
import java.awt.event.ActionEvent;

public class AddRoomDialog extends JDialog {

	private final JPanel contentPanel = new JPanel();
	private JPanel jpRoom;
	private JPanel jpButton;
	private JLabel jlRoomType;
	private JLabel jlRoomNum;
	private JLabel jlRoomMoney;
	private JLabel jlRMB;
	private JComboBox jcbRoomType;
	private JSpinner jsRoomNum;
	private JTextField jtfMoney;
	private JButton jbConfirm;
	private JButton jbCancel;
	private IRoomController roomController;
	private AddCancelListener addCancelListener;
	private AddConfirmListener addConfirmListener;
	private HotelVO theHotel;
	private RoomUIPanel jpRoomUI;

	/**
	 * 初始化添加房间对话框
	 */
	public AddRoomDialog(List<RoomType> roomType, RoomUIPanel jRroomUI) {
		this.jpRoomUI = jpRoomUI;
		setLocationRelativeTo(null);
		setBounds(100, 100, 450, 300);
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
		
		jcbRoomType = new JComboBox();
		jcbRoomType.setBounds(150, 15, 145, 30);
		jcbRoomType.setEditable(false);
		
		int size = roomType.size();
		String roomTypes[] = new String[size];
		
		for(int i=0;i<size;i++){
			if(roomType.get(i).toString().equals("Single")){
				roomTypes[i] =  "单人房";
			}
			else if(roomType.get(i).toString().equals("Double")){
				roomTypes[i] = "双人房";
			}
			else if(roomType.get(i).toString().equals("KingSize")){
				roomTypes[i] = "大床间";
			}
			else if(roomType.get(i).toString().equals("Standard")){
				roomTypes[i] = "标准间";
			}
			else if(roomType.get(i).toString().equals("Deluxe")){
				roomTypes[i] = "豪华间";
			}
			else if(roomType.get(i).toString().equals("Business")){
				roomTypes[i] = "商务标间";
			}
			else if(roomType.get(i).toString().equals("Executive")){
				roomTypes[i] = "行政标间";
			}
			
			jcbRoomType.addItem(roomTypes[i]);
		}
		
		jsRoomNum = new JSpinner();
		jsRoomNum.setBounds(150, 73, 145, 30);
		jsRoomNum.setModel(new SpinnerNumberModel());
		
		jtfMoney = new JTextField();
		jtfMoney.setBounds(150, 131, 145, 30);
		jtfMoney.setEditable(true);
		
		addConfirmListener = new AddConfirmListener(this);
		
		jbConfirm = new JButton();
		jbConfirm.setFont(new Font("宋体", Font.PLAIN, 16));
		jbConfirm.setText("确定");
		jbConfirm.setBounds(92, 13, 70, 40);
		jbConfirm.addMouseListener(addConfirmListener);
		
		jbCancel = new JButton();
		jbCancel.setFont(new Font("宋体", Font.PLAIN, 16));
		jbCancel.setText("取消");
		jbCancel.setBounds(264, 13, 70, 40);
		jbCancel.addMouseListener(addCancelListener);
		
		roomController = ControllerFactory.getRoomController();
		
		jpRoom.add(jlRoomType);
		jpRoom.add(jlRoomNum);
		jpRoom.add(jlRoomMoney);
		jpRoom.add(jlRMB);
		jpRoom.add(jcbRoomType);
		jpRoom.add(jsRoomNum);
		jpRoom.add(jtfMoney);
		
		jpButton.add(jbConfirm);
		jpButton.add(jbCancel);
		
		contentPanel.add(jpRoom);
		contentPanel.add(jpButton);
		
		this.setTitle("请输入新增房间的信息");
		this.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
		this.setVisible(true);
	}
	
	/**
	 * 确认添加房间
	 * @throws RoomNotFoundException 
	 */
	public void addConfirm() throws RoomNotFoundException{
		RoomVO newRoom = new RoomVO();
		
		String newType = (String) jcbRoomType.getSelectedItem();
		if(newType.equals("单人房")){
			newRoom.type = RoomType.Single;
		}
		else if(newType.equals("双人房")){
			newRoom.type = RoomType.Double;
		}
		else if(newType.equals("大床间")){
			newRoom.type = RoomType.KingSize;
		}
		else if(newType.equals("标准间")){
			newRoom.type = RoomType.Standard;
		}
		else if(newType.equals("豪华间")){
			newRoom.type = RoomType.Deluxe;
		}
		else if(newType.equals("商务标间")){
			newRoom.type = RoomType.Business;
		}
		else if(newType.equals("行政标间")){
			newRoom.type = RoomType.Executive;
		}
		
		if(((Integer) jsRoomNum.getValue()).intValue()<0){
			JOptionPane.showMessageDialog(this, "房间数量不能为负数！", "错误", JOptionPane.ERROR_MESSAGE);
		}
		else if(((Integer) jsRoomNum.getValue()).intValue()==0){
			JOptionPane.showMessageDialog(this, "房间数量不能为零！", "错误", JOptionPane.ERROR_MESSAGE);
		}
		else if(Double.valueOf(jtfMoney.getText())<0){
			JOptionPane.showMessageDialog(this, "原始价格不能为负数！", "错误", JOptionPane.ERROR_MESSAGE);
		}
		else{
			newRoom.roomNum = ((Integer) jsRoomNum.getValue()).intValue();
			newRoom.roomValue = Double.valueOf(jtfMoney.getText());
			
			jpRoomUI.refreshRoomList(newRoom);
			
			this.dispose();
		}

	}
	
	/**
	 * 取消添加房间
	 */
	public void addCancel(){
		this.dispose();
	}
	
}
