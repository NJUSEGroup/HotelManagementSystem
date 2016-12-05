package hrs.client.UI.HotelUI.OfflineRecordUI;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.border.EmptyBorder;
import javax.swing.table.JTableHeader;

import hrs.client.UI.HotelUI.Components.HotelDiscountTableModel;
import hrs.client.UI.HotelUI.Components.OfflineRecordTableModel;
import hrs.client.UI.HotelUI.OfflineRecordUI.Listener.CheckinListener;
import hrs.client.UI.HotelUI.OfflineRecordUI.Listener.CheckoutListener;
import hrs.client.UI.HotelUI.OfflineRecordUI.Listener.RecordSelectedListener;
import hrs.client.UI.HotelUI.OfflineRecordUI.Listener.SearchListener;
import hrs.client.util.ControllerFactory;
import hrs.common.Controller.HotelController.IOfflineRecordController;
import hrs.common.Exception.OfflineRecordService.OfflineRecordNotFoundException;
import hrs.common.Exception.Promotion.HotelDiscountService.HotelDiscountNotFoundException;
import hrs.common.VO.HotelDiscountVO;
import hrs.common.VO.HotelVO;
import hrs.common.VO.OfflineRecordVO;

public class OfflineRecordUIPanel extends JPanel {

	/**
	 * 
	 */
	private static final long serialVersionUID = 2688792422499013247L;
	private JPanel jpSearch;
	private JPanel jpRecord;
	private JPanel jpButton;
	private JScrollPane jspRecord;
	private JLabel jlInput;
	private JTextField jtfInput;
	private JButton jbConfirm;
	private JTable jtRecord;
	private JTableHeader jth;
	private JButton jbCheckin;
	private JButton jbCheckout;
	private OfflineRecordTableModel model;
	private IOfflineRecordController controller;
	private SearchListener searchListener;
	private RecordSelectedListener recordSelectedListener;
	private CheckinListener checkinListener;
	private CheckoutListener checkoutListener;
	
	/**
	 * Create the panel.
	 */
	public OfflineRecordUIPanel(HotelVO hotel) {
		init(hotel);
	}
	
	public void init(HotelVO hotel){
		this.setSize(1080, 722);
		this.setLayout(null);
		
		jpSearch = new JPanel();
		jpSearch.setBounds(0, 0, 1080, 80);
		jpSearch.setBackground(new Color(211, 237, 249));
		jpSearch.setLayout(null);
		
		jpRecord = new JPanel();
		jpRecord.setBounds(0, 80, 1080, 562);
		jpRecord.setBackground(new Color(211, 237, 249));
		jpRecord.setLayout(null);
		
		jpButton = new JPanel();
		jpButton.setBounds(0, 642, 1080, 80);
		jpButton.setBackground(new Color(211, 237, 249));
		jpButton.setLayout(null);
		
		jlInput = new JLabel();
		jlInput.setBounds(30, 20, 120, 30);
		jlInput.setText("请输入编号");
		jlInput.setHorizontalAlignment(SwingConstants.CENTER);
		jlInput.setFont(new Font("方正兰亭超细黑简体", Font.PLAIN, 19));
		
		jtfInput = new JTextField();
		jtfInput.setBounds(180, 20, 140, 30);
		jtfInput.setFont(new Font("方正兰亭超细黑简体", Font.PLAIN, 19));
		jtfInput.setEditable(true);
		
		searchListener = new SearchListener(this);
		
		jbConfirm = new JButton();
		jbConfirm.setBounds(362, 15, 90, 40);
		jbConfirm.setText("确认");
		jbConfirm.setFont(new Font("方正兰亭超细黑简体", Font.PLAIN, 19));
		jbConfirm.addMouseListener(searchListener);
		
		recordSelectedListener = new RecordSelectedListener(this);
		
		controller = ControllerFactory.getOfflineRecordController();
		
		List<OfflineRecordVO> record = new ArrayList<OfflineRecordVO>();
		
		model = new OfflineRecordTableModel(record);
		
		jtRecord = new JTable(model);
		jtRecord.setBackground(new Color(211, 237, 249));
		jtRecord.setFont(new Font("宋体",Font.PLAIN,16));
		jtRecord.setRowHeight(40);
		jtRecord.setShowVerticalLines(false);
		jtRecord.addMouseListener(recordSelectedListener);
		
		jth = jtRecord.getTableHeader(); 
		jth.setPreferredSize(new Dimension(jtRecord.getWidth(),40)); 
		jth.setBackground(new Color(188, 226, 236));
		jth.setEnabled(false);
		jth.setBorder(new EmptyBorder(0,0,0,0));
		jth.setFont(new Font("宋体", Font.PLAIN, 19));
		
		jspRecord = new JScrollPane(jtRecord);
		jspRecord.setBounds(10, 10, 1060, 622);
		jspRecord.setHorizontalScrollBarPolicy(JScrollPane.HORIZONTAL_SCROLLBAR_AS_NEEDED);
		jspRecord.setOpaque(false);
		jspRecord.getViewport().setOpaque(false);
		jspRecord.setBackground(Color.WHITE);
		
		checkinListener = new CheckinListener(this);
		
		jbCheckin = new JButton();
		jbCheckin.setBounds(715, 13, 90, 40);
		jbCheckin.setText("入住");
		jbCheckin.setFont(new Font("方正兰亭超细黑简体", Font.PLAIN, 19));
		jbCheckin.setEnabled(false);
		jbCheckin.addMouseListener(checkinListener);
		
		checkoutListener = new CheckoutListener(this);
		
		jbCheckout = new JButton();
		jbCheckout.setBounds(869, 13, 90, 40);
		jbCheckout.setText("退房");
		jbCheckout.setFont(new Font("方正兰亭超细黑简体", Font.PLAIN, 19));
		jbCheckout.setEnabled(false);
		jbCheckout.addMouseListener(checkoutListener);
		
		jpSearch.add(jlInput);
		jpSearch.add(jtfInput);
		jpSearch.add(jbConfirm);
		
		jpRecord.add(jspRecord);
		
		jpButton.add(jbCheckin);
		jpButton.add(jbCheckout);
		
		this.add(jpSearch);
		this.add(jpRecord);
		this.add(jpButton);
	}
	
	public int getID(){
		return Integer.valueOf(jtfInput.getText());
	}
	
	public List<OfflineRecordVO> searchRecordByID(int id){
		OfflineRecordVO record = new OfflineRecordVO();
		List<OfflineRecordVO> records = new ArrayList<OfflineRecordVO>();
		
		try {
			record = controller.findOfflineRecordByID(id);
			records.add(record);
		} catch (OfflineRecordNotFoundException e) {
			// TODO Auto-generated catch block
			JOptionPane.showMessageDialog(null, "该记录不存在！", "错误", JOptionPane.WARNING_MESSAGE);
		}
		
		return records;
	}
	
	public void refresh(List<OfflineRecordVO> record){
		model = new OfflineRecordTableModel(record);
		jtRecord.setModel(model);
	}
	
	public void recordSelected(){
		if(jtRecord.getSelectedRow() != -1){
			jbCheckin.setEnabled(true);
			jbCheckout.setEnabled(true);
		}
	}
	
	public void recordNotSelected(){
		jbCheckin.setEnabled(false);
		jbCheckout.setEnabled(false);
	}
	
	public OfflineRecordVO getSelectedRecord(){
		int row = jtRecord.getSelectedRow();
		int id = Integer.valueOf((String) jtRecord.getValueAt(row, 0));
		OfflineRecordVO record = searchRecordByID(id).get(0);
		return record;
	}
	
	public void checkin(OfflineRecordVO theRecord){
		controller.offlineCheckin(theRecord);
		JOptionPane.showMessageDialog(null, "线下入住记录已更新！", "更新成功", JOptionPane.INFORMATION_MESSAGE);
	}

	public void checkout(OfflineRecordVO theRecord){
		controller.offlineCheckout(theRecord);
		JOptionPane.showMessageDialog(null, "线下入住记录已更新！", "更新成功", JOptionPane.INFORMATION_MESSAGE);
	}
	
	/**
	 * 获得相应按钮的可用状态
	 */
	public boolean isButtonEnable(String buttonName){
		if(buttonName.equals("入住")){
			return jbCheckin.isEnabled();
		}
		else{
			return jbCheckout.isEnabled();
		}
	}
}
