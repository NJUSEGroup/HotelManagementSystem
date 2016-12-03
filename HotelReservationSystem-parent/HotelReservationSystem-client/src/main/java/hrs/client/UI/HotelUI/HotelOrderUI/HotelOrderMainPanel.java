package hrs.client.UI.HotelUI.HotelOrderUI;

import java.awt.CardLayout;
import java.awt.Color;
import java.util.List;

import javax.swing.JPanel;

import hrs.client.UI.HotelUI.HotelOrderDetailUI.HotelOrderDetailUIPanel;
import hrs.common.VO.HotelVO;
import hrs.common.VO.OrderVO;

public class HotelOrderMainPanel extends JPanel {

	private CardLayout card;
	private HotelOrderUIPanel jpOrderList;
	private HotelOrderDetailUIPanel jpOrderDetail;
	
	/**
	 * Create the panel.
	 */
	public HotelOrderMainPanel(HotelVO hotel) {
		init(hotel);
	}
	
	public void init(HotelVO hotel){
		card = new CardLayout();
		jpOrderList = new HotelOrderUIPanel(this, hotel);
		jpOrderDetail = new HotelOrderDetailUIPanel(this);
		
		this.setLayout(card);
		this.setSize(1080, 722);
		this.setBackground(new Color(211, 237, 249));
		
		this.add(jpOrderList, "1");
		this.add(jpOrderDetail, "2");
		
	}
	
	public void showList(){
		card.show(this, "1");
	}
	
	public void refresh(){
		jpOrderList.refreshSearchTerms();
		List<OrderVO> orders= jpOrderList.getAllOrders();
		jpOrderList.refreshOrderList(orders);
	}
	
	public void showDetail(OrderVO order){
		card.show(this, "2");
		jpOrderDetail.showDetailInfo(order);
	}
	
	

}
