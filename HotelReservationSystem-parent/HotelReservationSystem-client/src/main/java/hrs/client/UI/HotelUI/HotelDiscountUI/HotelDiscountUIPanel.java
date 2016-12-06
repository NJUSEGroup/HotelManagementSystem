package hrs.client.UI.HotelUI.HotelDiscountUI;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JButton;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.border.EmptyBorder;
import javax.swing.table.JTableHeader;

import hrs.client.UI.HotelUI.Components.HotelDiscountTableModel;
import hrs.client.UI.HotelUI.HotelDiscountUI.Listener.AddListener;
import hrs.client.UI.HotelUI.HotelDiscountUI.Listener.DeleteListener;
import hrs.client.UI.HotelUI.HotelDiscountUI.Listener.DiscountSelectedListener;
import hrs.client.UI.HotelUI.HotelDiscountUI.Listener.EditListener;
import hrs.client.util.ControllerFactory;
import hrs.common.Controller.HotelController.IHotelDiscountController;
import hrs.common.Exception.Promotion.HotelDiscountService.HotelDiscountNotFoundException;
import hrs.common.VO.HotelDiscountVO;
import hrs.common.VO.HotelVO;

public class HotelDiscountUIPanel extends JPanel {

	/**
	 * 
	 */
	private static final long serialVersionUID = -6428074559081567803L;
	private JPanel jpDiscount;
	private JPanel jpButton;
	private JScrollPane jspDiscount;
	private JTable jtDiscount;
	private HotelDiscountTableModel model;
	private JTableHeader jth;
	private JButton jbAdd;
	private JButton jbEdit;
	private JButton jbDelete;
	private HotelVO hotel;
	private IHotelDiscountController controller;
	private DiscountSelectedListener discountSelectedListener;
	private AddListener addListener;
	private EditListener editListener;
	private DeleteListener deleteListener;
	private List<HotelDiscountVO> discounts;
	
	
	/**
	 * Create the panel.
	 */
	
	public HotelDiscountUIPanel(HotelVO hotel) {
		init(hotel);
	}

	public void init(HotelVO hotel){
		this.setSize(1080, 722);
		this.setLayout(null);
		
		this.hotel = hotel;
		
		controller = ControllerFactory.getHotelDiscountController();
		
		jpDiscount = new JPanel();
		jpDiscount.setBounds(0, 0, 1080, 642);
		jpDiscount.setBackground(new Color(211, 237, 249));
		jpDiscount.setLayout(null);
		
		jpButton = new JPanel();
		jpButton.setBounds(0, 642, 1080, 80);
		jpButton.setBackground(new Color(211, 237, 249));
		jpButton.setLayout(null);
		
		discounts = new ArrayList<HotelDiscountVO>();
		
		try {
			discounts = controller.findAllByHotelID(hotel.id);
		} catch (HotelDiscountNotFoundException e) {
			// TODO Auto-generated catch block
			JOptionPane.showMessageDialog(this, "您的酒店尚无促销策略", "提示", JOptionPane.INFORMATION_MESSAGE);
		}
		
		discountSelectedListener = new DiscountSelectedListener(this);
		
		model = new HotelDiscountTableModel(discounts);
		
		jtDiscount = new JTable(model);
		jtDiscount.setBackground(new Color(211, 237, 249));
		jtDiscount.setFont(new Font("宋体",Font.PLAIN,16));
		jtDiscount.setRowHeight(40);
		jtDiscount.setShowVerticalLines(false);
		jtDiscount.addMouseListener(discountSelectedListener);
		
		jth = jtDiscount.getTableHeader(); 
		jth.setPreferredSize(new Dimension(jtDiscount.getWidth(),40)); 
		jth.setBackground(new Color(188, 226, 236));
		jth.setEnabled(false);
		jth.setBorder(new EmptyBorder(0,0,0,0));
		jth.setFont(new Font("宋体", Font.PLAIN, 19));
		
		jspDiscount = new JScrollPane(jtDiscount);
		jspDiscount.setBounds(10, 10, 1060, 622);
		jspDiscount.setHorizontalScrollBarPolicy(JScrollPane.HORIZONTAL_SCROLLBAR_AS_NEEDED);
		jspDiscount.setOpaque(false);
		jspDiscount.getViewport().setOpaque(false);
		jspDiscount.setBackground(Color.WHITE);
		
		addListener = new AddListener(this);
		
		jbAdd = new JButton();
		jbAdd.setBounds(570, 13, 90, 40);
		jbAdd.setText("添加");
		jbAdd.setFont(new Font("方正兰亭超细黑简体", Font.PLAIN, 19));
		jbAdd.addMouseListener(addListener);
		
		editListener = new EditListener(this);
		
		jbEdit = new JButton();
		jbEdit.setBounds(710, 13, 90, 40);
		jbEdit.setText("修改");
		jbEdit.setFont(new Font("方正兰亭超细黑简体", Font.PLAIN, 19));
		jbEdit.setEnabled(false);
		jbEdit.addMouseListener(editListener);
		
		
		deleteListener = new DeleteListener(this);
		
		jbDelete = new JButton();
		jbDelete.setBounds(850, 13, 90, 40);
		jbDelete.setText("删除");
		jbDelete.setFont(new Font("方正兰亭超细黑简体", Font.PLAIN, 19));
		jbDelete.setEnabled(false);
		jbDelete.addMouseListener(deleteListener);
		
		jpDiscount.add(jspDiscount);
		
		jpButton.add(jbAdd);
		jpButton.add(jbEdit);
		jpButton.add(jbDelete);
		
		this.add(jpDiscount);
		this.add(jpButton);
	}
	
	/**
	 * 获得该酒店所有促销策略
	 */
	public void getAllDiscounts(){
		try {
			discounts = controller.findAllByHotelID(hotel.id);
		} catch (HotelDiscountNotFoundException e) {
			// TODO Auto-generated catch block
			JOptionPane.showMessageDialog(this, "您的酒店尚无促销策略", "提示", JOptionPane.INFORMATION_MESSAGE);
		}
	}
	
	/**
	 * 刷新促销策略列表
	 */
	public void refresh(){
		model = new HotelDiscountTableModel(discounts);
		jtDiscount.setModel(model);
		this.discountNotSelected();
	}
	
	/**
	 * 当表格中的某项促销策略被选中时，修改和删除按钮设置为可用
	 */
	public void discountSelected(){
		if(jtDiscount.getSelectedRow() != -1){
			jbEdit.setEnabled(true);
			jbDelete.setEnabled(true);
		}
	}
	
	/**
	 * 当表格中没有促销策略被选中时，修改和删除按钮设置为不可用
	 */
	public void discountNotSelected(){
		jbEdit.setEnabled(false);
		jbDelete.setEnabled(false);
	}
	
	/**
	 * 获取相应按钮的可用状态
	 * @return
	 */
	public boolean isButtonEnable(String buttonName){
		if(buttonName.equals("修改")){
			return jbEdit.isEnabled();
		}
		else{
			return jbDelete.isEnabled();
		}
	}
	
	/**
	 * 获取被选中的促销策略
	 */
	public HotelDiscountVO getSelectedDiscount(){
		int row = jtDiscount.getSelectedRow();
		
		return discounts.get(row);
	}
	
	public void addDiscount(){
		AddDiscountDialog addDialog = new AddDiscountDialog(hotel, this);
	}
	
	public void editDiscount(){
		EditDiscountDialog editDialog = new EditDiscountDialog(hotel, this);
	}
	
	/**
	 * 删除被选中的促销策略
	 * @param discount
	 */
	public void deleteDiscount(HotelDiscountVO discount){
		controller.delete(discount.id);
	}
}
