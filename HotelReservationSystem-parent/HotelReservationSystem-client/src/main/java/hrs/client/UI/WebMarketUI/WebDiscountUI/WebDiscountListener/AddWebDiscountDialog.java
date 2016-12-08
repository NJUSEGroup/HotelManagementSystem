package hrs.client.UI.WebMarketUI.WebDiscountUI.WebDiscountListener;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Font;

import javax.swing.JDialog;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import hrs.client.UI.WebMarketUI.WebDiscountUI.WebDiscountPanel;
import hrs.client.util.ControllerFactory;
import hrs.client.util.HRSButton;
import hrs.client.util.UIConstants;
import hrs.common.Controller.WebMarketController.IWebDiscountController;
import hrs.common.VO.CommercialCircleVO;
import hrs.common.VO.LocationVO;
import hrs.common.VO.WebDiscountVO;
import hrs.common.util.DateHelper;
import hrs.common.util.type.WebsiteDiscountType;

import javax.swing.DefaultComboBoxModel;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.JTextField;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.text.ParseException;
import java.util.Date;
import java.util.List;

public class AddWebDiscountDialog extends JDialog {

	/**
	 * 
	 */
	private static final long serialVersionUID = -5923810422972507715L;

	private final JPanel jpAdd = new JPanel();
	private JTextField jtextBegintime;
	private JTextField jtextEndtime;
	private JTextField jtextDiscount;

	private JLabel jlBeginTime;
	private JLabel jlEndTime;
	private JLabel jlLocation;
	private JLabel jlCommercialCircle;
	private JLabel jlPromotionType;
	private JLabel jlVIPLevel;
	private JLabel jlDiscount;
	// private JButton jbOK;
	// private JButton jbCancel;
	private HRSButton jbOK, jbCancel;

	private WebDiscountPanel jpWebDiscount;
	private WebDiscountVO addVO;
	private OKListener listener;
	private CancelAddListener cancelAddListener;

	private JComboBox jcomboBoxType = new JComboBox<>();
	private JComboBox jcomboBoxCommercialCircle = new JComboBox<>();
	private JComboBox jcomboBoxLocation = new JComboBox<>();
	private JComboBox jcomboBoxVIPLevel = new JComboBox<>();

	private LocationVO location;
	private CommercialCircleVO commercialCircle;
	private IWebDiscountController controller = ControllerFactory.getWebDiscountController();
	private List<LocationVO> locs;
	private List<CommercialCircleVO> commercialCircleList;
	private int locationIndex;

	/**
	 * Launch the application.
	 */

	/**
	 * Create the dialog.
	 */
	@SuppressWarnings("unchecked")
	public AddWebDiscountDialog(WebDiscountPanel panel) {
		jpWebDiscount = panel;
		jcomboBoxType.addItem("会员等级折扣");
		jcomboBoxType.addItem("特定期间折扣");
		jcomboBoxType.addItem("特定商圈专属折扣");
		jcomboBoxType.setSelectedIndex(-1);

		for (int i = 0; i < locToName().length; i++) {
			jcomboBoxLocation.addItem(locToName()[i]);
		}
		jcomboBoxLocation.setSelectedIndex(-1);

		jcomboBoxVIPLevel.addItem("1");
		jcomboBoxVIPLevel.addItem("2");
		jcomboBoxVIPLevel.addItem("3");
		jcomboBoxVIPLevel.addItem("4");
		jcomboBoxVIPLevel.addItem("5");
		jcomboBoxVIPLevel.setSelectedIndex(-1);

		init();
	}

	public void init() {
		this.setTitle("酒店促销策略添加");
		this.setBounds(100, 100, 450, 320);

		getContentPane().setLayout(new BorderLayout());
		jpAdd.setBorder(new EmptyBorder(5, 5, 5, 5));
		jpAdd.setBackground(UIConstants.JFRAME);
		getContentPane().add(jpAdd, BorderLayout.CENTER);

		jlPromotionType = new JLabel("折扣类型");
		jlBeginTime = new JLabel("开始时间");
		jlEndTime = new JLabel("结束时间");
		jlCommercialCircle = new JLabel("商圈");
		jlVIPLevel = new JLabel("VIP等级");
		jlDiscount = new JLabel("折扣信息");

		jtextBegintime = new JTextField();
		jtextBegintime.setColumns(10);
		jtextBegintime.setText("");

		jtextEndtime = new JTextField();
		jtextEndtime.setColumns(10);
		jtextEndtime.setText("");

		jtextDiscount = new JTextField();
		jtextDiscount.setColumns(10);
		jtextDiscount.setText("");

		jbOK = new HRSButton("确认添加");
		jbOK.setFont(new Font("宋体", Font.PLAIN, 13));
		listener = new OKListener(jpWebDiscount, this);
		jbOK.addMouseListener(listener);

		jbCancel = new HRSButton("取消添加");
		jbCancel.setFont(new Font("宋体", Font.PLAIN, 13));
		cancelAddListener = new CancelAddListener(this);
		jbCancel.addMouseListener(cancelAddListener);

		jlLocation = new JLabel("城市");

		// jcomboBoxCommercialCircle.setSelectedIndex(-1);
		setUnableAndCombox();

		initWebDiscountDialog();

		GroupLayout gl_jpAdd = new GroupLayout(jpAdd);
		gl_jpAdd.setHorizontalGroup(
				gl_jpAdd.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_jpAdd.createSequentialGroup().addGroup(gl_jpAdd
								.createParallelGroup(
										Alignment.LEADING)
								.addGroup(gl_jpAdd.createSequentialGroup().addGap(93).addGroup(gl_jpAdd
										.createParallelGroup(Alignment.LEADING).addComponent(jlDiscount)
										.addGroup(gl_jpAdd.createParallelGroup(Alignment.LEADING, false)
												.addComponent(jlCommercialCircle, GroupLayout.DEFAULT_SIZE,
														GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
												.addComponent(jlLocation, GroupLayout.DEFAULT_SIZE,
														GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
												.addComponent(jlEndTime, GroupLayout.DEFAULT_SIZE, 76, Short.MAX_VALUE)
												.addComponent(jlBeginTime, GroupLayout.DEFAULT_SIZE, 76,
														Short.MAX_VALUE)
												.addComponent(jlPromotionType, GroupLayout.DEFAULT_SIZE, 76,
														Short.MAX_VALUE)
												.addComponent(jlVIPLevel, GroupLayout.DEFAULT_SIZE, 76,
														Short.MAX_VALUE)))
										.addPreferredGap(ComponentPlacement.RELATED, 30, Short.MAX_VALUE)
										.addGroup(gl_jpAdd.createParallelGroup(Alignment.LEADING)
												.addGroup(gl_jpAdd.createParallelGroup(Alignment.LEADING, false)
														.addComponent(jtextDiscount, Alignment.TRAILING)
														.addComponent(jtextEndtime, Alignment.TRAILING)
														.addComponent(jcomboBoxCommercialCircle, Alignment.TRAILING, 0,
																GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
														.addComponent(jcomboBoxLocation, Alignment.TRAILING, 0, 168,
																Short.MAX_VALUE)
														.addComponent(jcomboBoxVIPLevel, Alignment.TRAILING, 0,
																GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
														.addComponent(jtextBegintime))
												.addComponent(jcomboBoxType, GroupLayout.PREFERRED_SIZE, 168,
														GroupLayout.PREFERRED_SIZE))
										.addGap(73))
								.addGroup(gl_jpAdd.createSequentialGroup().addGap(131).addComponent(jbOK).addGap(18)
										.addComponent(jbCancel)))
								.addContainerGap()));
		gl_jpAdd.setVerticalGroup(gl_jpAdd.createParallelGroup(Alignment.LEADING).addGroup(gl_jpAdd
				.createSequentialGroup().addContainerGap()
				.addGroup(gl_jpAdd.createParallelGroup(Alignment.BASELINE).addComponent(jlPromotionType).addComponent(
						jcomboBoxType, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE,
						GroupLayout.PREFERRED_SIZE))
				.addPreferredGap(ComponentPlacement.RELATED)
				.addGroup(gl_jpAdd.createParallelGroup(Alignment.BASELINE).addComponent(jlBeginTime).addComponent(
						jtextBegintime, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE,
						GroupLayout.PREFERRED_SIZE))
				.addPreferredGap(ComponentPlacement.RELATED)
				.addGroup(gl_jpAdd.createParallelGroup(Alignment.BASELINE).addComponent(jlEndTime).addComponent(
						jtextEndtime, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
				.addPreferredGap(ComponentPlacement.RELATED)
				.addGroup(gl_jpAdd.createParallelGroup(Alignment.LEADING).addComponent(jlLocation).addComponent(
						jcomboBoxLocation, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE,
						GroupLayout.PREFERRED_SIZE))
				.addGap(7)
				.addGroup(gl_jpAdd.createParallelGroup(Alignment.BASELINE).addComponent(jlCommercialCircle)
						.addComponent(jcomboBoxCommercialCircle, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE,
								GroupLayout.PREFERRED_SIZE))
				.addPreferredGap(ComponentPlacement.UNRELATED)
				.addGroup(
						gl_jpAdd.createParallelGroup(Alignment.BASELINE)
								.addComponent(jlVIPLevel, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE,
										Short.MAX_VALUE)
								.addComponent(jcomboBoxVIPLevel, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE,
										GroupLayout.PREFERRED_SIZE))
				.addPreferredGap(ComponentPlacement.RELATED)
				.addGroup(gl_jpAdd.createParallelGroup(Alignment.BASELINE).addComponent(jlDiscount).addComponent(
						jtextDiscount, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE,
						GroupLayout.PREFERRED_SIZE))
				.addPreferredGap(ComponentPlacement.UNRELATED)
				.addGroup(gl_jpAdd.createParallelGroup(Alignment.BASELINE).addComponent(jbOK).addComponent(jbCancel))
				.addGap(106)));
		jpAdd.setLayout(gl_jpAdd);
	}

	public void initWebDiscountDialog() {
		jcomboBoxType.addItemListener(new ItemListener() {
			@SuppressWarnings("unchecked")
			@Override
			public void itemStateChanged(ItemEvent e) {
				if (jcomboBoxType.getSelectedItem().toString().equals("特定商圈专属折扣")) {
					// locationIndex = jcomboBoxLocation.getSelectedIndex();
					// location = locs.get(locationIndex);
					jcomboBoxLocation.addItemListener(new ItemListener() {
						@Override
						public void itemStateChanged(ItemEvent e) {
							// TODO Auto-generated method stub
							locationIndex = jcomboBoxLocation.getSelectedIndex();
							location = locs.get(locationIndex);
							commercialCircleList = controller.findCircleByLoc(location.id);
							// System.out.println(commercialCircleList);
							Object[] circleName = new Object[commercialCircleList.size()];
							for (int i = 0; i != commercialCircleList.size(); ++i) {
								circleName[i] = commercialCircleList.get(i).name;
							}
							DefaultComboBoxModel<Object> model = new DefaultComboBoxModel<>(circleName);
							jcomboBoxCommercialCircle.setModel(model);
						}
					});
				}
			}
		});
	}

	public void setUnableAndCombox() {
		jcomboBoxType.addItemListener(new ItemListener() {
			@Override
			public void itemStateChanged(ItemEvent e) {
				// TODO Auto-generated method stub
				switch (jcomboBoxType.getSelectedItem().toString()) {
				case "特定商圈专属折扣":// 需要显示商圈，城市，折扣
					// jcomboBoxLocation = new JComboBox<>(locToName());
					// //显示所有的城市
					// 根据选的城市来显示商圈名
					jcomboBoxVIPLevel.setSelectedIndex(-1);
					jcomboBoxCommercialCircle.setSelectedIndex(-1);
					jcomboBoxLocation.setSelectedIndex(-1);
					jtextBegintime.setText("");
					jtextEndtime.setText("");
					jtextDiscount.setText("");
					jtextBegintime.setBackground(Color.LIGHT_GRAY);
					jtextEndtime.setBackground(Color.LIGHT_GRAY);
					jcomboBoxVIPLevel.setBackground(Color.LIGHT_GRAY);
					jcomboBoxCommercialCircle.setEnabled(true);
					jcomboBoxLocation.setEnabled(true);
					;
					jtextBegintime.setEditable(false);
					jtextEndtime.setEditable(false);
					jcomboBoxVIPLevel.setEnabled(false);
					break;
				case "特定期间折扣":
					jcomboBoxVIPLevel.setSelectedIndex(-1);
					jcomboBoxCommercialCircle.setSelectedIndex(-1);
					jcomboBoxLocation.setSelectedIndex(-1);
					jtextDiscount.setText("");
					jtextBegintime.setBackground(Color.WHITE);
					jtextEndtime.setBackground(Color.WHITE);

					jtextBegintime.setEditable(true);
					jtextEndtime.setEditable(true);
					jcomboBoxCommercialCircle.setEnabled(false);
					jcomboBoxLocation.setEnabled(false);
					jcomboBoxVIPLevel.setEnabled(false);
					break;
				case "会员等级折扣":
					jcomboBoxVIPLevel.setSelectedIndex(-1);
					jcomboBoxVIPLevel.setEnabled(true);
					jtextBegintime.setText("");
					jtextEndtime.setText("");
					jtextDiscount.setText("");
					jcomboBoxVIPLevel.setBackground(Color.WHITE);
					jtextBegintime.setBackground(Color.LIGHT_GRAY);
					jtextEndtime.setBackground(Color.LIGHT_GRAY);
					jtextBegintime.setEditable(false);
					jtextEndtime.setEditable(false);
					jcomboBoxCommercialCircle.setSelectedIndex(-1);
					jcomboBoxLocation.setSelectedIndex(-1);
					jcomboBoxCommercialCircle.setEnabled(false);
					jcomboBoxLocation.setEnabled(false);

					break;
				default:
					break;
				}

			}
		});

	}

	public WebDiscountVO jdaddWebDiscount() {
		switch (jcomboBoxType.getSelectedItem().toString()) {
		case "特定商圈专属折扣":
			double commercialCircleDiscount = Double.parseDouble(jtextDiscount.getText());
			// System.out.println(jcomboBoxLocation);
			locationIndex = jcomboBoxLocation.getSelectedIndex();
			location = locs.get(locationIndex);
			int commercialCircleIndex = jcomboBoxCommercialCircle.getSelectedIndex();
			commercialCircle = commercialCircleList.get(commercialCircleIndex);
			// System.out.println(commercialCircle);
			addVO = new WebDiscountVO(commercialCircleDiscount, WebsiteDiscountType.SpecialCommercialCircle, location,
					commercialCircle, null, null, 0);

			break;
		case "特定期间折扣":
			// System.out.println(jcomboBoxType.getSelectedItem());
			double specialPeriodDiscount = Double.parseDouble(jtextDiscount.getText());
			Date discountBeginTime = null;
			Date discountEndTime = null;
			try {
				discountBeginTime = DateHelper.parse(jtextBegintime.getText());
				discountEndTime = DateHelper.parse(jtextEndtime.getText());
			} catch (ParseException exception) {
				// TODO Auto-generated catch block
				JOptionPane.showMessageDialog(null, "请输入正确的日期格式", "Error", JOptionPane.ERROR_MESSAGE);
			}
			addVO = new WebDiscountVO(specialPeriodDiscount, WebsiteDiscountType.SpecialPeriod, null, null,
					discountBeginTime, discountEndTime, 0);
			break;
		case "会员等级折扣":
			int VIPLevel = Integer.parseInt(jcomboBoxVIPLevel.getSelectedItem().toString());
			double vipDiscount = Double.parseDouble(jtextDiscount.getText());
			addVO = new WebDiscountVO(vipDiscount, WebsiteDiscountType.VIP, null, null, null, null, VIPLevel);
			break;
		default:
			break;
		}
		return addVO;// 从dialog返回一个有数据的vo给jp
	}

	public double getDiscount() {
		return jdaddWebDiscount().discount;
	}

	private Object[] locToName() {
		locs = controller.findAllLocations();
		Object[] names = new Object[locs.size()];
		for (int i = 0; i != names.length; ++i) {
			names[i] = locs.get(i).name;
		}
		return names;
	}

	public void refresh() {
		jtextBegintime.setText("");
		jtextEndtime.setText("");
		jtextDiscount.setText("");
		jcomboBoxType.setSelectedIndex(-1);
		// jcomboBoxCommercialCircle.setSelectedIndex(-1);
		// jcomboBoxLocation.setSelectedIndex(-1);
		// jcomboBoxVIPLevel.setSelectedIndex(-1);
		jcomboBoxCommercialCircle.setSelectedItem(null);
		jcomboBoxLocation.setSelectedItem(null);
		jcomboBoxVIPLevel.setSelectedItem(null);
	}
	// public static void main(String[] args) {
	// AddWebDiscountDialog dialog=new AddWebDiscountDialog();
	// dialog.setVisible(true);
	// }
	// private Object[] commCircleToName(int selectedIndex){
	//
	// }
	// jcomboBoxLocation.addActionListener(new ItemListener() {
	//
}
