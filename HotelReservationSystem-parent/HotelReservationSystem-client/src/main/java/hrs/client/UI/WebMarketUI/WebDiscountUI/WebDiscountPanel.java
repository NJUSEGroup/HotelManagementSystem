package hrs.client.UI.WebMarketUI.WebDiscountUI;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.sql.Date;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;
import java.util.ResourceBundle;

import javax.swing.BorderFactory;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.border.EmptyBorder;
import javax.swing.table.JTableHeader;

import org.springframework.beans.factory.annotation.InitDestroyAnnotationBeanPostProcessor;

import hrs.client.UI.WebMarketUI.CreditChargeUI.CreditChargePanel;
import hrs.client.UI.WebMarketUI.WebDiscountUI.WebDiscountListener.AddMouseListener;
import hrs.client.UI.WebMarketUI.WebDiscountUI.WebDiscountListener.DeleteMouseListener;
import hrs.client.UI.WebMarketUI.WebDiscountUI.WebDiscountListener.ModifyMouseListener;
import hrs.client.UI.WebMarketUI.WebDiscountUI.WebDiscountListener.AddWebDiscountDialog;
import hrs.client.util.ControllerFactory;
import hrs.client.util.UIConstants;
import hrs.common.Controller.WebMarketController.IWebDiscountController;
import hrs.common.Exception.Promotion.WebDiscountService.WebDiscountNotFoundException;
import hrs.common.VO.WebDiscountVO;
import hrs.common.util.type.WebsiteDiscountType;

import javax.swing.JLabel;
import javax.swing.JOptionPane;

public class WebDiscountPanel extends JPanel {
	private IWebDiscountController webDiscountController;
	private List<WebDiscountVO> webDiscountList;
	private WebDiscountModel model;
	private WebDiscountModel addModel, modifyModel;
	private JButton jbAdd, jbModify, jbDelete;

	private DeleteMouseListener listener;
	private AddMouseListener addMouseListener;
	private ModifyMouseListener modifyMouseListener;

	private JLabel jlNumberOfPO;
	private JTable jTable;
	private JTableHeader jTableHeader;
	private JScrollPane scrollPane;
	private AddWebDiscountDialog jdAddWebDiscount;
	private WebDiscountVO addVo;
	private SpecialCommercialCircleDialog jdSpecialCommercialCircle;
	private SpecialPeriodDialog jdSpecialPeriod;
	private VIPDiaog jdVIP;
	private Font JTABLE_FONT=new Font("Arial Unicode MS", Font.PLAIN, 18);
	
//	private ResourceBundle rb = ResourceBundle.getBundle("webDiscount", Locale.getDefault());

	/**
	 * Create the panel.
	 */
	public WebDiscountPanel() {
		init();
	}

	public void init() {
		webDiscountController = ControllerFactory.getWebDiscountController();
		webDiscountList = getWebDiscountList();
		model = new WebDiscountModel(webDiscountList);

		this.setSize(1080, 722);
		this.setBackground(UIConstants.JFRAME);

		jbAdd = new JButton("添加");
		jbAdd.setFont(UIConstants.JBUTTON_FONT);
		jbAdd.setBackground(UIConstants.JLABEL);
		jbAdd.setForeground(Color.WHITE);
		jbAdd.setBorderPainted(false);
		jbAdd.setOpaque(true);
		jdAddWebDiscount = new AddWebDiscountDialog(this);// this
		addMouseListener = new AddMouseListener(this);
		jbAdd.addMouseListener(addMouseListener);

		jbModify = new JButton("修改");
		jbModify.setFont(UIConstants.JBUTTON_FONT);
		jbModify.setBackground(UIConstants.JLABEL);
		jbModify.setForeground(Color.WHITE);
		jbModify.setBorderPainted(false);
		jbModify.setOpaque(true);
		modifyMouseListener = new ModifyMouseListener(this);
		jbModify.addMouseListener(modifyMouseListener);

		jbDelete = new JButton("删除");
		jbDelete.setFont(UIConstants.JBUTTON_FONT);
		jbDelete.setBackground(Color.RED);
		jbDelete.setForeground(Color.WHITE);
		jbDelete.setBorderPainted(false);
		jbDelete.setOpaque(true);
		listener = new DeleteMouseListener(this);
		jbDelete.addMouseListener(listener);

		jlNumberOfPO = new JLabel();
		jlNumberOfPO.setText("共 " + webDiscountList.size() + " 条记录");
		jlNumberOfPO.setFont(UIConstants.JLABEL_NUMBER_OF_INFO);

		GroupLayout groupLayout = new GroupLayout(this);
		groupLayout.setHorizontalGroup(groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(groupLayout.createSequentialGroup().addContainerGap(575, Short.MAX_VALUE).addComponent(jbAdd)
						.addGap(61).addComponent(jbModify).addGap(57).addComponent(jbDelete).addGap(116))
				.addGroup(groupLayout.createSequentialGroup().addGap(41)
						.addComponent(jlNumberOfPO, GroupLayout.PREFERRED_SIZE, 85, GroupLayout.PREFERRED_SIZE)
						.addContainerGap(944, Short.MAX_VALUE)));
		groupLayout
				.setVerticalGroup(
						groupLayout.createParallelGroup(Alignment.TRAILING)
								.addGroup(groupLayout.createSequentialGroup().addGap(587).addComponent(jlNumberOfPO)
										.addPreferredGap(ComponentPlacement.RELATED, 38, Short.MAX_VALUE)
										.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
												.addComponent(jbModify).addComponent(jbAdd).addComponent(jbDelete))
										.addGap(26)));
		setLayout(groupLayout);

		jTable = new JTable();
		jTable.setModel(model);
		// jTable.setEnabled(false);

		jTable.setBackground(UIConstants.JFRAME);
		jTable.setFont(JTABLE_FONT);
		jTable.setRowHeight(40);
		jTable.setShowVerticalLines(false);
		jTable.setShowHorizontalLines(false);

		// 设置表头
		jTableHeader = jTable.getTableHeader();
		jTableHeader.setPreferredSize(new Dimension(jTableHeader.getWidth(), 25));
		jTableHeader.setBackground(UIConstants.JTABLEHEADER_COLOR);
		jTableHeader.setEnabled(false);
		jTableHeader.setBorder(new EmptyBorder(0, 0, 0, 0));
		jTableHeader.setFont(JTABLE_FONT);

		scrollPane = new JScrollPane();
		scrollPane.setViewportView(jTable);
		scrollPane.setBounds(3, 20, 1000, 530);
		scrollPane.setBorder(new EmptyBorder(0, 0, 0, 0));
		scrollPane.getViewport().setBackground(UIConstants.JFRAME);
		scrollPane.setOpaque(true);
		add(scrollPane);
	}

	public List<WebDiscountVO> getWebDiscountList() {
		List<WebDiscountVO> list = new ArrayList<>();
		try {
			list = webDiscountController.findAll();

		} catch (WebDiscountNotFoundException e) {
			JOptionPane.showMessageDialog(this, "此时促销策略为空！", "NullWebDiscount", JOptionPane.INFORMATION_MESSAGE);

		}
		return list;
	}

	public void addWebDiscount() {
		addVo = jdAddWebDiscount.jdaddWebDiscount();
		// System.out.println(addVo);
		webDiscountController.add(addVo);
		webDiscountController = ControllerFactory.getWebDiscountController();
		webDiscountList = getWebDiscountList();
		addModel = new WebDiscountModel(webDiscountList);
		jTable.setModel(addModel);
		jlNumberOfPO.setText("共 " + webDiscountList.size() + " 条记录");
		jlNumberOfPO.setFont(UIConstants.JLABEL_NUMBER_OF_INFO);
	}

	public void deleteWebDiscount(WebDiscountVO vo) {
		webDiscountController.delete(vo.id);
		WebDiscountModel deleteModel;
		webDiscountController = ControllerFactory.getWebDiscountController();
		webDiscountList = getWebDiscountList();
		deleteModel = new WebDiscountModel(webDiscountList);
		jTable.setModel(deleteModel);
		jlNumberOfPO.setText("共 " + webDiscountList.size() + " 条记录");
		jlNumberOfPO.setFont(UIConstants.JLABEL_NUMBER_OF_INFO);
	}

	public void showModifyDialog() {
		if (getSelected() == null) {
			JOptionPane.showMessageDialog(this, "请选中要修改的促销策略！", "Error", JOptionPane.ERROR_MESSAGE);
		} else {
			switch (getSelected().type) {
			case SpecialCommercialCircle:
				jdSpecialCommercialCircle = new SpecialCommercialCircleDialog(this);
				jdSpecialCommercialCircle.setVisible(true);
				jdSpecialCommercialCircle.setLocationRelativeTo(null);
				break;
			case SpecialPeriod:
				// System.out.println("选中了");
				jdSpecialPeriod = new SpecialPeriodDialog(this);
				jdSpecialPeriod.setVisible(true);
				jdSpecialPeriod.setLocationRelativeTo(null);
				break;
			case VIP:
				jdVIP = new VIPDiaog(this);
				jdVIP.setVisible(true);
				jdVIP.setLocationRelativeTo(null);
				break;
			default:
				break;
			}
		}
	}

	public void modifyWebDiscount() {
		WebDiscountVO modifyVO = null;
		switch (getSelected().type) {
		case SpecialCommercialCircle:
			modifyVO = jdSpecialCommercialCircle.getModifyVO();
			break;
		case SpecialPeriod:
			modifyVO = jdSpecialPeriod.getModifyVO();
			break;
		case VIP:
			modifyVO = jdVIP.getModifyVO();
			break;
		default:
			break;
		}
		webDiscountController.update(modifyVO);
		webDiscountController = ControllerFactory.getWebDiscountController();
		webDiscountList = getWebDiscountList();
		modifyModel = new WebDiscountModel(webDiscountList);
		jTable.setModel(modifyModel);
		JOptionPane.showMessageDialog(null, "促销策略成功修改！", "Success", JOptionPane.PLAIN_MESSAGE, null);
	}

	public WebDiscountVO getSelected() {
		if (jTable.getSelectedRow() != -1) {
			return model.getValue(jTable.getSelectedRow());
		} else
			return null;
	}

	public void showAddDialog() {
		jdAddWebDiscount.setVisible(true);
		jdAddWebDiscount.setLocationRelativeTo(null);
	}
}
