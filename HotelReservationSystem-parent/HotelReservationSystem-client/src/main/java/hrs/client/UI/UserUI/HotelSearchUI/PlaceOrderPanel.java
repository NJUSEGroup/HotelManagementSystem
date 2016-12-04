package hrs.client.UI.UserUI.HotelSearchUI;

import hrs.client.UI.UserUI.ComComponents.CommonPanel;
import hrs.common.VO.OrderVO;

public class PlaceOrderPanel extends CommonPanel {
	private OrderVO order;
	public PlaceOrderPanel(OrderVO order){
		this.order = order;
		Init();
	}
	@Override
	public void Init() {
		// TODO Auto-generated method stub

	}

}
