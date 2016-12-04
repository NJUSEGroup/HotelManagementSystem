package hrs.client.UI.UserUI.HotelSearchUI;

import java.util.ArrayList;

import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

import antlr.collections.List;
import hrs.client.UI.UserUI.ComComponents.CommonLabel;
import hrs.client.util.UIConstants;
/**
 * 带有两个输入域
 * 可通过getValue()得到带有两个Integer的ArrayList，第一个为小值，第二个为大值
 * 大小为160*40
 * @author 涵
 *
 */
public class TwoFieldPanel extends JPanel {
	private JTextField lowField;
	private JTextField highField;
	public TwoFieldPanel(){
		lowField = new JTextField();
		highField = new JTextField();
		Init();
	}
	private void Init() {
		setBackground(UIConstants.jframe);
		setLayout(null);
		setSize(160,40);
		
		JLabel jl = new CommonLabel("~");
		jl.setBounds(65, 0, 30, 40);
		add(jl);
		
		lowField.setFont(UIConstants.jlabelChinese);
		lowField.setBounds(0, 5, 65, 30);
		add(lowField);
		
		highField.setFont(UIConstants.jlabelChinese);
		highField.setBounds(95, 5, 65, 30);
		add(highField);
		
	}
	
	public ArrayList<Integer> getValue(){
		ArrayList<Integer> list = new ArrayList<>();
		list.add(Integer.parseInt(lowField.getText()));
		list.add(Integer.parseInt(highField.getText()));
		return list;
	}
}
