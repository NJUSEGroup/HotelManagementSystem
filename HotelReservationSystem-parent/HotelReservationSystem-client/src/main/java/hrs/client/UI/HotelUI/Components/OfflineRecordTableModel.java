package hrs.client.UI.HotelUI.Components;

import java.util.ArrayList;
import java.util.List;

import javax.swing.event.TableModelListener;
import javax.swing.table.TableModel;

import hrs.common.VO.OfflineRecordVO;
import hrs.common.util.DateHelper;

public class OfflineRecordTableModel implements TableModel{

	private OfflineRecordVO offlineRecord;
	
	public OfflineRecordTableModel(OfflineRecordVO offlineRecord){
		this.offlineRecord = offlineRecord;
	}
	
	@Override
	public int getRowCount() {
		// TODO Auto-generated method stub
		
		return 1;
	}

	@Override
	public int getColumnCount() {
		// TODO Auto-generated method stub
		
		return 6;
	}

	@Override
	public String getColumnName(int columnIndex) {
		// TODO Auto-generated method stub
		
		List<String> tableHeader = new ArrayList<>();
		
		tableHeader.add("ID");
		tableHeader.add("入住时间");
		tableHeader.add("预计离开时间");
		tableHeader.add("退房时间");
		tableHeader.add("房间类型");
		tableHeader.add("房间数量");
		
		return tableHeader.get(columnIndex);
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
		
		//ID
		if (columnIndex == 0) {
			String id = Integer.toString(offlineRecord.id);
			
			return id;
		}
		
		//入住时间
		else if (columnIndex == 1){
			String checkinDate = DateHelper.format(offlineRecord.checkinTime);
			
			return checkinDate;
		}
		
		//预计离开时间
		else if (columnIndex == 2) {
			String expectedCheckoutDate = DateHelper.format(offlineRecord.expectedCheckoutTime);
			
			return expectedCheckoutDate;
		}
		
		//退房时间
		else if (columnIndex == 3){
			String checkoutDate = DateHelper.format(offlineRecord.checkoutTime);
			
			return checkoutDate;
		}
		
		//房间类型
		else if (columnIndex == 4){
			String roomType = offlineRecord.type.toString();
			
			if(roomType.equals("Single")){
				return "单人房";
			}
			else if(roomType.equals("Double")){
				return "双人房";
			}
			else if(roomType.equals("KingSize")){
				return "大床间";
			}
			else if(roomType.equals("Standard")){
				return "标准间";
			}
			else if(roomType.equals("Deluxe")){
				return "豪华间";
			}
			else if(roomType.equals("Business")){
				return "商务标间";
			}
			else{
				return "行政标间";
			}
		}
		
		//房间数量
		else if (columnIndex == 5){
			String roomNum = Integer.toString(offlineRecord.num);
			
			return roomNum;
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
