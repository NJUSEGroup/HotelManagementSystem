package hrs.client.UI.UserUI.OrderInfoUI;

import java.awt.Color;
import java.awt.Dialog.ModalityType;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.border.EmptyBorder;

import hrs.client.UI.UserUI.CommonComponents.CommonLabel;
import hrs.client.UI.UserUI.CommonComponents.CommonPanel;
import hrs.client.UI.UserUI.OrderInfoUI.Listener.DetailButtonLisener;
import hrs.client.UI.UserUI.OrderInfoUI.Listener.EvalueButtonListener;
import hrs.client.UI.UserUI.OrderInfoUI.Listener.StatusBoxListener;
import hrs.client.UI.UserUI.OrderInfoUI.Listener.revokeListener;
import hrs.client.util.ControllerFactory;
import hrs.client.util.EnumHelper;
import hrs.client.util.UIConstants;
import hrs.common.Controller.UserController.IUserOrderController;
import hrs.common.Exception.OrderService.OrderNotFoundException;
import hrs.common.VO.OrderVO;
import hrs.common.VO.UserVO;
import hrs.common.util.type.OrderStatus;

public class OrderShowPanel extends CommonPanel {
	/**
	* @Fields serialVersionUID : TODO
	*/ 
	private static final long serialVersionUID = -1738046961448085289L;
	
	private UserVO userVO;
	
	private IUserOrderController controller = ControllerFactory.getUserOrderController();
	JComboBox<String> statusBox;
	private OrderTable table;
	
	private JButton evalueButton;
	private JButton detailButton;
	private JButton revokeButton;
	
	private OrderInfoPanel panel;
	Font font = UIConstants.jlabelChinese;
	private JScrollPane scrollPane;
	
	private static int GAP_WIDTH = 30;
	public OrderShowPanel(UserVO userVO,OrderInfoPanel panel) {
		this.userVO = userVO;
		this.panel = panel;
		//选框设置
		setCombox();
		
		Init();
	}
	
	@Override
	public void Init() {
		
		
		//标签设置
		setLabel();
		
		//设置表格
		SetTable();
		// TODO Auto-generated method stub

		//设置按钮
		setButton();
	}

	private void setButton() {
		//查看详细按钮
		detailButton = new JButton("查看详细");
		detailButton.setFont(font);
		detailButton.setBounds(550, 640, 150, 40);
		detailButton.addActionListener(new DetailButtonLisener(this));
		
		//评价按钮
		evalueButton = new JButton("评价");
		evalueButton.setFont(font);
		evalueButton.setBounds(730, 640, 120, 40);
		evalueButton.addActionListener(new EvalueButtonListener(this));
		
		//撤销按钮
		revokeButton = new JButton("撤销");
		revokeButton.setFont(font);
		revokeButton.setBounds(880, 640, 120, 40);
		revokeButton.addActionListener(new revokeListener(this));
		
		add(revokeButton);
		add(detailButton);
		add(evalueButton);
		
//		evalueButton.setEnabled(false);
//		revokeButton.setEnabled(false);
//		detailButton.setEnabled(false);
		
		//当列表没有选中项时，按钮应不可点击
		//用线程监测列表选中状态
		buttonThread();
		
		
	}

	
	

	private void buttonThread() {
		Thread thread = new Thread(new Runnable() {
			
			@Override
			public void run() {
				while(true){
					if(table.getSelectedRowCount() == 0){
						evalueButton.setEnabled(false);
						revokeButton.setEnabled(false);
						detailButton.setEnabled(false);	
				}
					else{
						evalueButton.setEnabled(true);
						revokeButton.setEnabled(true);
						detailButton.setEnabled(true);	
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

	
	private void SetTable() {
		table = new OrderTable(getOrderList(OrderStatus.Unexecuted));
		
		
		scrollPane = new JScrollPane();
		scrollPane.setViewportView(table);
		scrollPane.setBounds(30, 80, 1043,500);
		scrollPane.setBorder(new EmptyBorder(0,0,0,0));
		scrollPane.getViewport().setBackground(new Color(211, 237, 249));
		scrollPane.setOpaque(true);
		
		add(scrollPane);
		
	}

	private void setCombox() {
		statusBox = new JComboBox<String>();
		statusBox.setBounds(GAP_WIDTH*2 + 126,10,168,40);
		statusBox.setFont(font);
		statusBox.addItem("未执行");
		statusBox.addItem("已执行");
		statusBox.addItem("异常");
		statusBox.addItem("已撤销");
		statusBox.setSelectedItem("未执行");
		
		
		statusBox.addItemListener(new StatusBoxListener(statusBox, this));
		
		add(statusBox);
	}

	private void setLabel() {
		// TODO Auto-generated method stub
		JLabel label = new CommonLabel();
		label.setText("选择订单类型");
		label.setBounds(GAP_WIDTH, 0, 126, 60);
//		label.setOpaque(true);
		this.add(label);
	}

	//得到表需要显示的订单
	private List<OrderVO> getOrderList(OrderStatus status){
		try {
			return controller.findOrdersByUsernameAndStatus(userVO.username, status);
		} catch (OrderNotFoundException e) {
			
			e.printStackTrace();
		}
		return null;
	}

	public void setStatus(OrderStatus status) {
		
		table.setModel(getOrderList(status));;
			
	}

	public void showDetail() {
		int i = table.getSelectedRow();//选中行
		String status = (String) statusBox.getSelectedItem();
		OrderVO orderVO = getOrderList(EnumHelper.toStatus(status)).get(i);
		panel.showDetail(orderVO);
		
	}

	public void evalue() {
		int i = table.getSelectedRow();//选中行
		String status = (String) statusBox.getSelectedItem();
		OrderVO orderVO = getOrderList(EnumHelper.toStatus(status)).get(i);
		
		//用于评价的弹窗
		JDialog dialog = new JDialog(null, "评价订单",ModalityType.APPLICATION_MODAL);
		dialog.setSize(550, 360);
		dialog.setLocationRelativeTo(null);//居于屏幕正中
		dialog.setLayout(null);
		dialog.getContentPane().setBackground(UIConstants.jframe);
		
		//评分标签
		JLabel scoreJL = new JLabel("评分(0-10):");
		scoreJL.setFont(UIConstants.jlabelChinese);
		scoreJL.setBounds(10, 20, 120, 40);
		dialog.add(scoreJL);
		
		//评价标签
		JLabel remarkJL = new JLabel("评价:");
		remarkJL.setFont(UIConstants.jlabelChinese);
		remarkJL.setBounds(10, 70, 120, 30);
		dialog.add(remarkJL);
		
		//评分选择的JComboBox
		JComboBox<Integer> scoreBox = new JComboBox<>();
		for(int c = 0;c<=10;c++){
			scoreBox.addItem(c);
		}
		scoreBox.setBounds(140, 20, 80, 40);
		scoreBox.setFont(UIConstants.jlabelChinese);
		dialog.add(scoreBox);
		
		//评价的编辑域
		JTextArea remarkArea = new JTextArea();
		remarkArea.setFont(UIConstants.jlabelChinese);
		remarkArea.setLineWrap(true);
		JScrollPane remarkJS = new JScrollPane(remarkArea);
		remarkJS.setBounds(140, 70, 370, 150);
		dialog.add(remarkJS);
		
		//确认评价
		JButton confirmJB = new JButton("确认");
		confirmJB.setFont(UIConstants.jlabelChinese);
		confirmJB.setBounds(400, 250, 80, 30);
		confirmJB.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				controller.remark(orderVO, (int)scoreBox.getSelectedItem(), remarkArea.getText());
				dialog.dispose();
			}
		});
		
		dialog.add(confirmJB);
		
		dialog.setVisible(true);
	}
	
	public void revoke() {
		int i = table.getSelectedRow();//选中行
		String status = (String) statusBox.getSelectedItem();
		OrderVO orderVO = getOrderList(EnumHelper.toStatus(status)).get(i);
		controller.revoke(orderVO);
		
		table.setModel(getOrderList(EnumHelper.toStatus(status)));
	}
}
