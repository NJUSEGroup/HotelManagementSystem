package hrs.client.util;

import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.forwardedUrl;

import java.awt.Font;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JPanel;

import hrs.common.util.DateHelper;

/**
 * 日期选择框 年份选项为当年和今年 日期选项根据年份和月份确定 各项均默认为当前日期 大小为260*40
 * 
 * @author 涵
 *
 */
public class DateChoosePanel extends JPanel {
	/**
	 * 
	 */
	private static final long serialVersionUID = 928093702009916231L;
	/**
	 * 
	 */
	private JComboBox<Integer> yearBox;
	private JComboBox<Integer> monthBox;
	private JComboBox<Integer> dayBox;
	private DateChooseListener listener;

	private Calendar currentTm;
	Font font = UIConstants.FONT_17;

	public DateChoosePanel() {
		currentTm = Calendar.getInstance();
		listener = new DateChooseListener(this);
		Init();
	}

	private void Init() {
		setSize(260, 30);
		setLayout(null);
		setBackground(UIConstants.JFRAME);

		setLabel();
		setBox();
	}

	private void setBox() {
		yearBox = new JComboBox<>();
		yearBox.addItem(currentTm.get(Calendar.YEAR));
		yearBox.addItem(currentTm.get(Calendar.YEAR) + 1);
		yearBox.addItemListener(listener);
		yearBox.setFont(font);
		yearBox.setBounds(0, 5, 70, 20);
		yearBox.setSelectedItem(currentTm.get(Calendar.YEAR));
		add(yearBox);

		monthBox = new JComboBox<>();
		for (Integer i = 1; i <= 12; i++) {
			monthBox.addItem(i);
		}
		monthBox.setFont(font);
		monthBox.setBounds(100, 5, 50, 20);
		monthBox.setSelectedItem(currentTm.get(Calendar.MONTH) + 1);
		monthBox.addItemListener(listener);
		add(monthBox);

		dayBox = new JComboBox<>();
		int MaxDay = currentTm.getActualMaximum(Calendar.DATE);
		for (Integer i = 1; i <= MaxDay; i++) {
			dayBox.addItem(i);
		}
		dayBox.setFont(font);
		dayBox.setBounds(180, 5, 50, 20);
		dayBox.setSelectedItem(currentTm.get(Calendar.DATE));
		add(dayBox);

	}

	private void setLabel() {
		JLabel yearJL = new JLabel("年");
		yearJL.setFont(font);
		yearJL.setBounds(70, 0, 30, 30);
		add(yearJL);

		JLabel monthJL = new JLabel("月");
		monthJL.setFont(font);
		monthJL.setBounds(150, 0, 30, 30);
		add(monthJL);

		JLabel dayJL = new JLabel("日");
		dayJL.setFont(font);
		dayJL.setBounds(230, 0, 30, 30);
		add(dayJL);

	}

	public void change() {
		// 只要一项为0，就是不选择
		if ((Integer) yearBox.getSelectedItem() == 0 || (Integer) monthBox.getSelectedItem() == 0
				|| (Integer) dayBox.getSelectedItem() == 0) {
			return;
		}
		currentTm.set(Calendar.YEAR, (Integer) yearBox.getSelectedItem());
		currentTm.set(Calendar.MONTH, (Integer) monthBox.getSelectedItem() - 1);
		dayBox.removeAllItems();
		int MaxDay = currentTm.getActualMaximum(Calendar.DATE);
		for (Integer i = 1; i <= MaxDay; i++) {
			dayBox.addItem(i);
		}

	}

	public void changeTobirth() {
		yearBox.removeAllItems();
		for (int i = 1960; i <= 2015; i++) {
			yearBox.addItem(i);
		}

		yearBox.setSelectedIndex(-1);
		monthBox.setSelectedIndex(-1);
		dayBox.setSelectedIndex(-1);
	}

	/**
	 * 得到当前panel选择的日期
	 * 
	 * @return Date
	 */
	public Date getDate() {
		if ( yearBox.getSelectedIndex()==-1 ||  monthBox.getSelectedIndex()==-1
				||  dayBox.getSelectedIndex() == -1) {
			return null;
		}
		int year = (Integer) yearBox.getSelectedItem();
		int month = (Integer) monthBox.getSelectedItem() - 1;
		int day = (Integer) dayBox.getSelectedItem();
		Calendar calendar = Calendar.getInstance();
		calendar.set(year, month, day, 0, 0, 0);
//		System.out.println(DateHelper.format(calendar.getTime()));
		return calendar.getTime();
	}

	/**
	 * 设置panel显示的时间
	 * 
	 * @param date
	 */
	public void setDate(Date date) {
		String theDate = (new SimpleDateFormat("yyyy/MM/dd")).format(date);
		String[] time = theDate.split("/");

		yearBox.setSelectedItem(Integer.valueOf(time[0]));
		monthBox.setSelectedItem(Integer.valueOf(time[1]));
		dayBox.setSelectedItem(Integer.valueOf(time[2]));
	}

	/**
	 * 设置为不可用
	 */
	public void setUnusable() {
		yearBox.setEnabled(false);
		monthBox.setEnabled(false);
		dayBox.setEnabled(false);
	}

	/**
	 * 设置为可用
	 */
	public void setEnabled() {
		yearBox.setEnabled(true);
		monthBox.setEnabled(true);
		dayBox.setEnabled(true);
	}

}
