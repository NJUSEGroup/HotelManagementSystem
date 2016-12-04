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
		
		List<HotelDiscountVO> discounts = new ArrayList<HotelDiscountVO>();
		
		try {
			discounts = controller.findAllByHotelID(hotel.id);
		} catch (HotelDiscountNotFoundException e) {
			// TODO Auto-generated catch block
			JOptionPane.showMessageDialog(this, "您的酒店尚无促销策略", "促销策略不存在", JOptionPane.INFORMATION_MESSAGE);
		}
		
		model = new HotelDiscountTableModel(discounts);
		
		jtDiscount = new JTable(model);
		jtDiscount.setBackground(new Color(211, 237, 249));
		jtDiscount.setFont(new Font("宋体",Font.PLAIN,16));
		jtDiscount.setRowHeight(40);
		jtDiscount.setShowVerticalLines(false);
		
		jth = jtDiscount.getTableHeader(); 
		jth.setPreferredSize(new Dimension(jtDiscount.getWidth(),40)); 
		jth.setBackground(new Color(222, 237, 249));
		jth.setEnabled(false);
		jth.setBorder(new EmptyBorder(0,0,0,0));
		jth.setFont(new Font("宋体", Font.PLAIN, 19));
		
		jspDiscount = new JScrollPane(jtDiscount);
		jspDiscount.setBounds(10, 10, 1060, 622);
		jspDiscount.setHorizontalScrollBarPolicy(JScrollPane.HORIZONTAL_SCROLLBAR_AS_NEEDED);
		jspDiscount.setOpaque(false);
		jspDiscount.getViewport().setOpaque(false);
		jspDiscount.setBackground(Color.WHITE);
		
		jbAdd = new JButton();
		jbAdd.setBounds(570, 13, 90, 40);
		jbAdd.setText("添加");
		jbAdd.setFont(new Font("方正兰亭超细黑简体", Font.PLAIN, 19));
		
		jbEdit = new JButton();
		jbEdit.setBounds(710, 13, 90, 40);
		jbEdit.setText("修改");
		jbEdit.setFont(new Font("方正兰亭超细黑简体", Font.PLAIN, 19));
		
		jbDelete = new JButton();
		jbDelete.setBounds(850, 13, 90, 40);
		jbDelete.setText("删除");
		jbDelete.setFont(new Font("方正兰亭超细黑简体", Font.PLAIN, 19));
		
		jpDiscount.add(jspDiscount);
		
		jpButton.add(jbAdd);
		jpButton.add(jbEdit);
		jpButton.add(jbDelete);
		
		this.add(jpDiscount);
		this.add(jpButton);
	}
	

}
