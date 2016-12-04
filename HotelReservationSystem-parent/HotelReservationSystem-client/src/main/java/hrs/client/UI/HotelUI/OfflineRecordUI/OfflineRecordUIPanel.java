package hrs.client.UI.HotelUI.OfflineRecordUI;

import java.awt.Color;
import java.awt.Font;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.SwingConstants;

import hrs.common.VO.HotelVO;

public class OfflineRecordUIPanel extends JPanel {

	/**
	 * 
	 */
	private static final long serialVersionUID = 2688792422499013247L;
	private JPanel jpSearch;
	private JPanel jpRecord;
	private JPanel jpButton;
	private JLabel jlInput;
	private JTextField jtfInput;
	private JButton jbConfirm;
	private JButton jbCheckin;
	private JButton jbCheckout;
	
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
		
		jbConfirm = new JButton();
		jbConfirm.setBounds(362, 15, 90, 40);
		jbConfirm.setText("确认");
		jbConfirm.setFont(new Font("方正兰亭超细黑简体", Font.PLAIN, 19));
		
		jbCheckin = new JButton();
		jbCheckin.setBounds(715, 13, 90, 40);
		jbCheckin.setText("入住");
		jbCheckin.setFont(new Font("方正兰亭超细黑简体", Font.PLAIN, 19));
		
		jbCheckout = new JButton();
		jbCheckout.setBounds(869, 13, 90, 40);
		jbCheckout.setText("退房");
		jbCheckout.setFont(new Font("方正兰亭超细黑简体", Font.PLAIN, 19));
		
		jpSearch.add(jlInput);
		jpSearch.add(jtfInput);
		jpSearch.add(jbConfirm);
		
		jpButton.add(jbCheckin);
		jpButton.add(jbCheckout);
		
		this.add(jpSearch);
		this.add(jpRecord);
		this.add(jpButton);
	}

}
