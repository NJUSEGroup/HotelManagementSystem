package hrs.client.UI.HotelUI.RoomUI;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.util.List;

import javax.swing.JButton;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.border.EmptyBorder;
import javax.swing.table.JTableHeader;

import hrs.client.UI.HotelUI.Components.RoomTableModel;
import hrs.client.UI.HotelUI.RoomUI.Listener.AddListener;
import hrs.client.UI.HotelUI.RoomUI.Listener.EditListener;
import hrs.client.util.ControllerFactory;
import hrs.common.Controller.HotelController.IRoomController;
import hrs.common.Exception.RoomService.RoomNotFoundException;
import hrs.common.VO.HotelVO;
import hrs.common.VO.RoomVO;
import hrs.common.util.type.RoomType;

public class RoomUIPanel extends JPanel {

	/**
	 * 
	 */
	private static final long serialVersionUID = -3459435356780911369L;
	private JPanel jpRoom;
	private JPanel jpButton;
	private JScrollPane jspRoom;
	private JTable jtRoom;
	private JTableHeader jthOrderList;
	private RoomTableModel roomTableModel;
	private JButton jbAdd;
	private JButton jbEdit;
	private HotelVO theHotel;
	private IRoomController roomController;
	private AddListener addListener;
	private EditListener editListener;
	List<RoomVO> rooms;
	
	/**
	 * Create the panel.
	 * @throws RoomNotFoundException 
	 */
	public RoomUIPanel(HotelVO theHotel){
		init(theHotel);
	}
	
	public void init(HotelVO theHotel){
		this.theHotel = theHotel;
		this.setSize(1080, 722);
		this.setLayout(null);
		
		jpRoom = new JPanel();
		jpRoom.setBounds(0, 0, 1080, 642);
		jpRoom.setBackground(new Color(211, 237, 249));
		jpRoom.setLayout(null);
		
		jpButton = new JPanel();
		jpButton.setBounds(0, 642, 1080, 80);
		jpButton.setBackground(new Color(211, 237, 249));
		jpButton.setLayout(null);
		
		roomController = ControllerFactory.getRoomController();
		try {
			rooms= roomController.findByHotelID(theHotel.id);
		} catch (RoomNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		roomTableModel = new RoomTableModel(rooms);
		
		jtRoom = new JTable(roomTableModel);
		jtRoom.setBackground(new Color(211, 237, 249));
		jtRoom.setFont(new Font("方正兰亭超细黑简体",Font.PLAIN,16));
		jtRoom.setRowHeight(40);
		jtRoom.setShowVerticalLines(false);
		
		jthOrderList = jtRoom.getTableHeader(); 
		jthOrderList.setPreferredSize(new Dimension(jtRoom.getWidth(),40)); 
		jthOrderList.setBackground(new Color(222, 237, 249));
		jthOrderList.setEnabled(false);
		jthOrderList.setBorder(new EmptyBorder(0,0,0,0));
		jthOrderList.setFont(new Font("方正兰亭超细黑简体", Font.PLAIN, 16));
		
		jspRoom = new JScrollPane(jtRoom);
		jspRoom.setBounds(10, 10, 1060, 622);
		jspRoom.setHorizontalScrollBarPolicy(JScrollPane.HORIZONTAL_SCROLLBAR_AS_NEEDED);
		jspRoom.setOpaque(false);
		jspRoom.getViewport().setOpaque(false);
		jspRoom.setBackground(Color.WHITE);
		
		addListener = new AddListener(this);
		
		jbAdd = new JButton();
		jbAdd.setBounds(736, 13, 90, 40);
		jbAdd.setText("添加");
		jbAdd.setFont(new Font("方正兰亭超细黑简体", Font.PLAIN, 19));
		jbAdd.addMouseListener(addListener);
		
		editListener = new EditListener(this);
		
		jbEdit = new JButton();
		jbEdit.setBounds(905, 13, 90, 40);
		jbEdit.setText("修改");
		jbEdit.setFont(new Font("方正兰亭超细黑简体", Font.PLAIN, 19));
		jbEdit.addMouseListener(editListener);
		
		jpRoom.add(jspRoom);
		
		jpButton.add(jbAdd);
		jpButton.add(jbEdit);
		
		this.add(jpRoom);
		this.add(jpButton);
		
		buttonThread();
	}
	
	public void add(){
		List<RoomType> notAddedRoom = roomController.findNotAddedRoomType(theHotel.id);
		
		AddRoomDialog addRoomDialog = new AddRoomDialog(notAddedRoom, this);
	}
	
	public void addRoom(RoomVO newRoom) {
		newRoom.hotel = theHotel;
		roomController.addRoom(newRoom);
	}
	
	public void edit(){
		EditRoomDialog editRoomDialog = new EditRoomDialog(this);
	}
	
	public void editRoom(RoomVO editRoom){
		editRoom.hotel = theHotel;
		roomController.updateRoom(editRoom);
	}
	
	public String getSelectedRoomType(){
		int row = jtRoom.getSelectedRow();
		String roomType = (String) jtRoom.getValueAt(row, 0);
		
		return roomType;
	}
	
	public void refreshRoomList(){
		try {
			rooms= roomController.findByHotelID(theHotel.id);
		} catch (RoomNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		roomTableModel = new RoomTableModel(rooms);
		jtRoom.setModel(roomTableModel);
	}
	
	private void buttonThread() {
		Thread thread = new Thread(new Runnable() {
			
			@Override
			public void run() {
				while(true){
					if(jtRoom.getSelectedRowCount() == 0){
						jbEdit.setEnabled(false);
				}
					else{
						jbEdit.setEnabled(true);	
					}
					try {
						Thread.sleep(200);
					} catch (InterruptedException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
				}
				}	
		});
		
			thread.start();
			
	}

}
