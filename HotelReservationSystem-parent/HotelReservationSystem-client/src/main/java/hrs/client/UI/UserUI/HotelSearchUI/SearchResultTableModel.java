package hrs.client.UI.UserUI.HotelSearchUI;

import java.util.List;
import java.util.Map;

import javax.swing.event.TableModelListener;
import javax.swing.table.TableModel;

import hrs.common.VO.HotelVO;
import hrs.common.VO.RoomVO;

public class SearchResultTableModel implements TableModel {
	private Map<HotelVO, List<RoomVO>> hotels;
	
	
	public SearchResultTableModel(Map<HotelVO, List<RoomVO>> hotels) {
		this.hotels = hotels;
		
	}
	
	@Override
	public int getRowCount() {
		return hotels.size();
	}

	@Override
	public int getColumnCount() {
		//四列：酒店名称，酒店地址，星级，评分
		return 4;
	}

	@Override
	public String getColumnName(int columnIndex) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Class<?> getColumnClass(int columnIndex) {
		// TODO Auto-generated method stub
		return String.class;
	}

	@Override
	public boolean isCellEditable(int rowIndex, int columnIndex) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public Object getValueAt(int rowIndex, int columnIndex) {
		// TODO Auto-generated method stub
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
