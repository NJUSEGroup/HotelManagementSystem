package hrs.StubAndDriver.DAO.HotelDiscountDAO;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import hrs.common.POJO.EnterprisePO;
import hrs.common.util.ResultMessage;
import hrs.server.DAO.Interface.PromotionDAO.EnterpriseDAO;

public class EnterpriseDAOStub implements EnterpriseDAO {
	private Map<Integer, EnterprisePO> map;

	public EnterpriseDAOStub() {
		map = new HashMap<>();
		map.put(0, new EnterprisePO(0, "21"));
	}

	@Override
	public List<EnterprisePO> findAll() {
		List<EnterprisePO> list = new ArrayList<>();
		EnterprisePO po = null;
		for (Integer i : map.keySet()) {
			po = map.get(i);
			list.add(po);
		}
		return list;
	}

	@Override
	public ResultMessage add(EnterprisePO po) {
		map.put(po.getId(), po);
		return ResultMessage.SUCCESS;
	}

}
