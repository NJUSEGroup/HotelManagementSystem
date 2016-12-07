package hrs.client.UI.UserUI.HotelSearchUI;

import java.util.List;

import javax.swing.event.TableModelListener;
import javax.swing.table.TableModel;

import hrs.common.VO.HotelDiscountVO;
import hrs.common.VO.WebDiscountVO;

public class DiscountTableModel implements TableModel {
	List<WebDiscountVO> webDiscounts;
	List<HotelDiscountVO> hotelDiscounts;
	private int webSize ;
	private int hotelSize ;
	public DiscountTableModel(List<WebDiscountVO> webDiscounts,List<HotelDiscountVO> hotelDiscounts) {
		this.webDiscounts = webDiscounts;
		this.hotelDiscounts = hotelDiscounts;
		
		webSize = webDiscounts.size();
		hotelSize = hotelDiscounts.size();
	}
	
	@Override
	public int getRowCount() {
		// TODO Auto-generated method stub
		return webDiscounts.size()+hotelDiscounts.size();
	}

	@Override
	public int getColumnCount() {
		// TODO Auto-generated method stub
		return 5;
	}

	@Override
	public String getColumnName(int columnIndex) {
		String[] l = {"该订单享受优惠","优惠策略","折扣金额","",""};
		return l[columnIndex];
	}

	@Override
	public Class<?> getColumnClass(int columnIndex) {
		return String.class;
	}

	@Override
	public boolean isCellEditable(int rowIndex, int columnIndex) {
		
		return false;
	}

	@Override
	public Object getValueAt(int rowIndex, int columnIndex) {
		if(rowIndex<=webSize){
			WebDiscountVO webDiscount = webDiscounts.get(rowIndex);
			String[] result = {"网站促销",webDiscount.type};
		}
		return null;
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
