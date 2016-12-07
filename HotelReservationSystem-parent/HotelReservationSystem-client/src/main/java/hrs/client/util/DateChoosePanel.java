package hrs.client.util;

import java.awt.Font;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

import android.R.integer;
import hrs.client.UI.UserUI.HotelSearchUI.SearchPanel;
/**
 * 日期选择框
 * 年份选项为当年和今年
 * 日期选项根据年份和月份确定
 * 各项均默认为当前日期
 * 大小为330*40
 * @author 涵
 *
 */
public class DateChoosePanel extends JPanel {
	/**
	 * 
	 */
	private static final long serialVersionUID = -3090610523432699152L;
	private JComboBox<Integer> yearBox;
	private JComboBox<Integer> monthBox;
	private JComboBox<Integer> dayBox;
	private DateChooseListener listener;
	
	private Calendar currentTm ;
	Font font = UIConstants.JLABEL_FONT;
	public DateChoosePanel(){
		currentTm = Calendar.getInstance();
		listener = new DateChooseListener(this);
		Init();
	}

	private void Init() {
		setSize(330,40);
		setLayout(null);
		setBackground(UIConstants.JFRAME);
		
		setLabel();
		setBox();
	}

	private void setBox() {
		yearBox = new JComboBox<>();
		yearBox.addItem(currentTm.get(Calendar.YEAR));
		yearBox.addItem(currentTm.get(Calendar.YEAR)+1);
		yearBox.addItemListener(listener);
		yearBox.setFont(font);
		yearBox.setBounds(0,5,100,30);
		yearBox.setSelectedItem(currentTm.get(Calendar.YEAR));
		add(yearBox);
		
		monthBox = new JComboBox<>();
		for(Integer i = 1;i<=12;i++){
			monthBox.addItem(i);
		}
		monthBox.setFont(font);
		monthBox.setBounds(130,5,70,30);
		monthBox.setSelectedItem(currentTm.get(Calendar.MONTH)+1);
		monthBox.addItemListener(listener);
		add(monthBox);
		
		dayBox = new JComboBox<>();
		int MaxDay = currentTm.getActualMaximum(Calendar.DATE);
		for(Integer i = 1;i<=MaxDay;i++){
			dayBox.addItem(i);
		}
		dayBox.setFont(font);
		dayBox.setBounds(230,5,70,30);
		dayBox.setSelectedItem(currentTm.get(Calendar.DATE));
		add(dayBox);
		
	}

	private void setLabel() {
		JLabel yearJL = new JLabel("年");
		yearJL.setFont(font);
		yearJL.setBounds(100,0,30,40);
		add(yearJL);
		
		JLabel monthJL = new JLabel("月");
		monthJL.setFont(font);
		monthJL.setBounds(200,0,30,40);
		add(monthJL);
		
		JLabel dayJL = new JLabel("日");
		dayJL.setFont(font);
		dayJL.setBounds(300,0,30,40);
		add(dayJL);
		
	}

	public void change() {
		currentTm.set(Calendar.YEAR, (Integer)yearBox.getSelectedItem());
		currentTm.set(Calendar.MONTH, (Integer)monthBox.getSelectedItem()+1);
		dayBox.removeAllItems();
		int MaxDay = currentTm.getActualMaximum(Calendar.DATE);
		for(Integer i = 1;i<=MaxDay;i++){
			dayBox.addItem(i);
		}
		
		
	}
	
	/**
	 * 得到当前panel选择的日期
	 * @return Date
	 */
	public Date getDate(){
		int year = (Integer)yearBox.getSelectedItem();
		int month = (Integer)monthBox.getSelectedItem();
		int day = (Integer)dayBox.getSelectedItem();

		Calendar cal = Calendar.getInstance();
		
		cal.set(Calendar.YEAR, year);
		cal.set(Calendar.MONTH, month-1);
		cal.set(Calendar.DAY_OF_MONTH, day);
		
		Date date = cal.getTime();
		
		return date;
	}
	
	/**
	 * 设置panel显示的时间
	 * @param date
	 */
	public void setDate(Date date){
		String theDate = (new SimpleDateFormat("yyyy/MM/dd")).format(date);
		String[] time = theDate.split("/");
		
		yearBox.setSelectedItem(Integer.valueOf(time[0]));
		monthBox.setSelectedItem(Integer.valueOf(time[1]));
		dayBox.setSelectedItem(Integer.valueOf(time[2]));
	}
	
	/**
	 * 设置为不可用
	 */
	public void setUnusable(){
		yearBox.setEnabled(false);
		monthBox.setEnabled(false);
		dayBox.setEnabled(false);
	}
	
	/**
	 * 设置为可用
	 */
	public void setEnabled(){
		yearBox.setEnabled(true);
		monthBox.setEnabled(true);
		dayBox.setEnabled(true);
	}
	
}
