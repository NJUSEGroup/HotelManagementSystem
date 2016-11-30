package hrs.client.UI.UserUI.CreditInfoUI;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.JTableHeader;

import hrs.client.UI.UserUI.CommonComp.CommonPanel;
import hrs.client.util.ControllerFactory;
import hrs.common.Controller.UserController.IUserController;
import hrs.common.Exception.CreditRecordService.CreditRecordNotFoundException;
import hrs.common.VO.CreditRecordVO;
import hrs.common.util.constants;

public class creditInfoPanel extends CommonPanel {
	private IUserController controller = ControllerFactory.getUserController();
	
	private String username;
	private JScrollPane scrollPane;
	
	Font font = constants.jlabelChinese;
	
	public creditInfoPanel(String username){
		
		this.username = username;
		
		Init();
		
		
	}
	
	@Override
	public void Init(){
		//创建表格
				JTable table = new JTable();
				List<CreditRecordVO> creditList = getCreditList();//需要显示的数据
				creditTableModel model = new creditTableModel(creditList);
				table.setModel(model);
				table.setBackground(new Color(211, 237, 249));//背景色
				table.setFont(font);//字体
				table.setRowHeight(40);//行高
				table.setShowVerticalLines(false);//不显示数列线
				table.setShowHorizontalLines(false);

				
				
				//设置表头
				JTableHeader tableHeader = table.getTableHeader(); 
				tableHeader.setPreferredSize(new Dimension(tableHeader.getWidth(),40)); //设定表头高度
				tableHeader.setBackground(new Color(222, 237, 249));//设定表头背景色
				tableHeader.setEnabled(false);//设置表头不可编辑
				tableHeader.setBorder(new EmptyBorder(0,0,0,0));
				tableHeader.setFont(font);
				((DefaultTableCellRenderer)tableHeader.getDefaultRenderer()).setHorizontalAlignment(JLabel.LEFT); 
				

				scrollPane = new JScrollPane();
				scrollPane.setViewportView(table);
				scrollPane.setBounds(30, 0, 1043,600);
				scrollPane.setBorder(new EmptyBorder(0,0,0,0));
				scrollPane.getViewport().setBackground(new Color(211, 237, 249));
				scrollPane.setOpaque(true);



				
				add(scrollPane);
	}

	private List<CreditRecordVO> getCreditList() {
		List<CreditRecordVO> list = new ArrayList<>();
		try {
			list = controller.findCreditRecordByUsername(this.username);
			if(list.isEmpty())
			System.out.println("空");
		} catch (CreditRecordNotFoundException e) {
			System.out.println("搜索信用记录发生错误");
			e.printStackTrace();
		}
		return list;
	}
}