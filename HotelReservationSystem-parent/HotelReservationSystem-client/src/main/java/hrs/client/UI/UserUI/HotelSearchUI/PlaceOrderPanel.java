package hrs.client.UI.UserUI.HotelSearchUI;

import hrs.client.UI.UserUI.Components.CommonPanel;
import hrs.common.VO.OrderVO;

public class PlaceOrderPanel extends CommonPanel {
	private OrderVO order;
	public PlaceOrderPanel(OrderVO order){
		this.order = order;
		init();
	}
	@Override
	public void init() {
		// TODO Auto-generated method stub

	}

}
