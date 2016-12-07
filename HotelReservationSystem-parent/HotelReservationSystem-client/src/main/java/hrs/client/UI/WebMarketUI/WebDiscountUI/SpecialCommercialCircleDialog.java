package hrs.client.UI.WebMarketUI.WebDiscountUI;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.util.List;

import javax.swing.DefaultComboBoxModel;
import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import com.mchange.v2.c3p0.impl.WrapperConnectionPoolDataSourceBase;

import hrs.client.UI.WebMarketUI.WebDiscountUI.WebDiscountListener.CancelModifySpecialCommercialListener;
import hrs.client.UI.WebMarketUI.WebDiscountUI.WebDiscountListener.ConfirmModifySpecialCommercialListener;
import hrs.client.UI.WebMarketUI.WebDiscountUI.WebDiscountListener.ConfirmModifySpecialPeriodListener;
import hrs.client.UI.WebStaffUI.HotelAddUI.HotelAddListener.ConfirmMouseListener;
import hrs.client.util.ControllerFactory;
import hrs.client.util.UIConstants;
import hrs.common.Controller.WebMarketController.IWebDiscountController;
import hrs.common.VO.CommercialCircleVO;
import hrs.common.VO.LocationVO;
import hrs.common.VO.WebDiscountVO;

import javax.swing.JLabel;
import javax.swing.JComboBox;
import javax.swing.JTextField;

public class SpecialCommercialCircleDialog extends JDialog {

	private final JPanel contentPanel = new JPanel();
	private JTextField jtextDiscount;
	private WebDiscountPanel webDiscountPanel;
	private WebDiscountVO webDiscountVO;
	private JLabel jlLocation;
	private JLabel jlCommercialCircle;
	private JComboBox jcomboBoxCommercialCircle;
	private JComboBox jcomboBoxLocation;
	private JButton jbConfirmModify;
	private JButton jbCancelModify;
	private JLabel jlDiscount;
	private LocationVO location;
	private List<LocationVO> locs;
	private List<CommercialCircleVO> commercialCircleList;
	private int locationIndex;
	private IWebDiscountController controller = ControllerFactory.getWebDiscountController();
	private ConfirmModifySpecialCommercialListener listener;
	private CancelModifySpecialCommercialListener cancelListener;

	public SpecialCommercialCircleDialog(WebDiscountPanel webDiscountPanel) {
		this.webDiscountPanel = webDiscountPanel;
		init();
	}

	/**
	 * Create the dialog.
	 */
	public void init() {
		webDiscountVO = webDiscountPanel.getSelected();

		getContentPane().setBackground(UIConstants.JFRAME);
		setTitle("特定商圈专属折扣修改");
		setBounds(100, 100, 420, 300);
		getContentPane().setLayout(null);
		contentPanel.setLayout(new FlowLayout());
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel, BorderLayout.CENTER);

		jlLocation = new JLabel("城市");
		jlLocation.setBounds(99, 53, 61, 16);
		getContentPane().add(jlLocation);

		jlCommercialCircle = new JLabel("商圈");
		jlCommercialCircle.setBounds(99, 107, 61, 16);
		getContentPane().add(jlCommercialCircle);

		jlDiscount = new JLabel("折扣信息");
		jlDiscount.setBounds(99, 161, 61, 16);
		getContentPane().add(jlDiscount);

		jbConfirmModify = new JButton("确认修改");
		jbConfirmModify.setBounds(99, 221, 96, 29);
		jbConfirmModify.setBackground(new Color(0, 160, 233));
		jbConfirmModify.setForeground(Color.WHITE);
		jbConfirmModify.setBorderPainted(false);
		jbConfirmModify.setOpaque(true);
		getContentPane().add(jbConfirmModify);
		listener=new ConfirmModifySpecialCommercialListener(webDiscountPanel, this);
		jbConfirmModify.addMouseListener(listener);

		jbCancelModify = new JButton("取消修改");
		jbCancelModify.setBounds(214, 221, 96, 29);
		jbCancelModify.setBackground(new Color(0, 160, 233));
		jbCancelModify.setForeground(Color.WHITE);
		jbCancelModify.setBorderPainted(false);
		jbCancelModify.setOpaque(true);
		getContentPane().add(jbCancelModify);
		cancelListener=new CancelModifySpecialCommercialListener(this);
		jbCancelModify.addMouseListener(cancelListener);

		jcomboBoxLocation = new JComboBox();
		jcomboBoxLocation.setBounds(195, 48, 130, 27);
		getContentPane().add(jcomboBoxLocation);
		for (int i = 0; i < locToName().length; i++) {
			jcomboBoxLocation.addItem(locToName()[i]);
		}
		jcomboBoxLocation.setSelectedItem(webDiscountVO.location.name);

		jcomboBoxCommercialCircle = new JComboBox();
		jcomboBoxCommercialCircle.setBounds(195, 103, 130, 27);
		getContentPane().add(jcomboBoxCommercialCircle);

		commercialCircleList = controller.findCircleByLoc(webDiscountVO.location.id);
		Object[] circleName = new Object[commercialCircleList.size()];

		for (int i = 0; i != commercialCircleList.size(); ++i) {
			circleName[i] = commercialCircleList.get(i).name;
		}

		DefaultComboBoxModel<Object> model = new DefaultComboBoxModel<>(circleName);
		jcomboBoxCommercialCircle.setModel(model);

		jcomboBoxCommercialCircle.setSelectedItem(webDiscountVO.commercialCircle.name);

		jcomboBoxLocation.addItemListener(new ItemListener() {
			@Override
			public void itemStateChanged(ItemEvent e) {
				// TODO Auto-generated method stub
				locationIndex = jcomboBoxLocation.getSelectedIndex();
				location = locs.get(locationIndex);
				commercialCircleList = controller.findCircleByLoc(location.id);
				Object[] circleName = new Object[commercialCircleList.size()];
				for (int i = 0; i != commercialCircleList.size(); ++i) {
					circleName[i] = commercialCircleList.get(i).name;
				}
				DefaultComboBoxModel<Object> model = new DefaultComboBoxModel<>(circleName);
				jcomboBoxCommercialCircle.setModel(model);
			}
		});

		jtextDiscount = new JTextField();
		jtextDiscount.setBounds(195, 156, 130, 26);
		getContentPane().add(jtextDiscount);
		jtextDiscount.setColumns(10);
		jtextDiscount.setText(webDiscountVO.discount + "");
	}

	public WebDiscountVO getModifyVO() {
		double newDiscount=Double.parseDouble(jtextDiscount.getText());
		webDiscountVO.location.name=(String) jcomboBoxLocation.getSelectedItem();
		webDiscountVO.commercialCircle.name=(String) jcomboBoxCommercialCircle.getSelectedItem();
		webDiscountVO.discount=newDiscount;
		return webDiscountVO;
	}

	private Object[] locToName() {
		locs = controller.findAllLocations();
		Object[] names = new Object[locs.size()];
		for (int i = 0; i != names.length; ++i) {
			names[i] = locs.get(i).name;
		}
		return names;
	}
}
