package hrs.client.UI.UserUI.CreditInfoUI;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.swing.event.TableModelListener;
import javax.swing.table.TableModel;

import org.omg.CosNaming.NamingContextExtPackage.StringNameHelper;

import aj.org.objectweb.asm.Type;
import hrs.common.VO.CreditRecordVO;
import hrs.common.util.DateHelper;
import hrs.common.util.type.CreditRecordType;

public class CreditTableModel implements TableModel {
	private List<CreditRecordVO> creditList;

	public CreditTableModel(List<CreditRecordVO> creditList) {
		this.creditList = creditList;
	}

	@Override
	// 表格的行数（有几个对象就有几行）
	public int getRowCount() {
		// TODO Auto-generated method stub
		return creditList.size();
	}

	@Override
	// 每个creditVO对象有5个值，所以有5列
	public int getColumnCount() {
		// TODO Auto-generated method stub
		return 5;
	}

	// 取每一列的列名
	@Override
	public String getColumnName(int columnIndex) {
		// TODO Auto-generated method stub
		List<String> l = new ArrayList<>();
		l.add("时间");
		l.add("订单号");
		l.add("动作");
		l.add("信用值变化");
		l.add("当前信用值");
		return l.get(columnIndex);
	}

	// 得到某列的数据类型
	@Override
	public Class<?> getColumnClass(int columnIndex) {
		// TODO Auto-generated method stub
		return String.class;

	}

	@Override
	// 全部不可编辑
	public boolean isCellEditable(int rowIndex, int columnIndex) {
		// TODO Auto-generated method stub
		return false;
	}

	// 得到第rowIndex行，第columnIndex列数据
	@Override
	public Object getValueAt(int rowIndex, int columnIndex) {
		
		CreditRecordVO info = creditList.get(rowIndex);
		
		List<String> list = new ArrayList<>();
		list.add(DateHelper.format(info.date));// 第一列为日期
		list.add(info.order.id+"");// 第二列为id
		list.add(info.type.toString());// 第三列为动作
		list.add(info.variation+"");// 第四列为信用值变化值
		list.add(info.currCredit+"");// 第五列为当前信用值
		return list.get(columnIndex);
	}

	@Override
	public void setValueAt(Object aValue, int rowIndex, int columnIndex) {
		// TODO Auto-generated method stub

	}

	@Override
	public void addTableModelListener(TableModelListener l) {
		// TODO Auto-generated method stub

	}

	@Override
	public void removeTableModelListener(TableModelListener l) {
		// TODO Auto-generated method stub

	}

}
