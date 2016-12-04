package hrs.client.UI.HotelUI.HotelOrderUI.Listener;

import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.ArrayList;
import java.util.List;

import hrs.client.UI.HotelUI.HotelOrderUI.HotelOrderUIPanel;
import hrs.common.Exception.OrderService.OrderNotFoundException;
import hrs.common.VO.OrderVO;

public class SearchByIdOrUsernameListener implements MouseListener{

	HotelOrderUIPanel jpHotelOrder;
	
	public SearchByIdOrUsernameListener(HotelOrderUIPanel jpHotelOrder){
		this.jpHotelOrder = jpHotelOrder;
	}
	
	@Override
	public void mouseClicked(MouseEvent e) {
		// TODO Auto-generated method stub
		
		List<OrderVO> orderList = new ArrayList<OrderVO>();
		OrderVO order;
		String username;
		int id;
		
		String searchInfo = jpHotelOrder.getSearchInfo();
		
		if(searchInfo.equals("用户名")){
			username = jpHotelOrder.getUsername();
			orderList = jpHotelOrder.searchByUsername(username);
		}
		else{
			id = Integer.valueOf(jpHotelOrder.getOrderID());
			orderList = jpHotelOrder.searchByOrderID(id);
		}
		
		jpHotelOrder.refreshOrderList(orderList);
	}

	@Override
	public void mousePressed(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseReleased(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseEntered(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseExited(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

}