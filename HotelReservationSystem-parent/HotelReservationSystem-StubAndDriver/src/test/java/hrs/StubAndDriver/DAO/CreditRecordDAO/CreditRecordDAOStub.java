package hrs.StubAndDriver.DAO.CreditRecordDAO;
import java.util.List;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;

import hrs.common.DAO.CreditRecordDAO;
import hrs.common.PO.CreditRecordPO;
import hrs.common.util.ResultMessage;
import hrs.common.util.type.CreditRecordType;

public class CreditRecordDAOStub implements CreditRecordDAO {
	private Map<Integer,CreditRecordPO> map;
	public CreditRecordDAOStub() {
		map = new HashMap<>();
		map.put(0, new CreditRecordPO(0,"admin",CreditRecordType.Execute,10,10));
	}

	@Override
	public ResultMessage add(CreditRecordPO creditrecordpo) {//新增信用记录
		if(findByUsername(creditrecordpo.getUsername()).contains(creditrecordpo)==false){
			map.put(creditrecordpo.getId(), creditrecordpo); 
				return ResultMessage.SUCCESS;
		}else{
			return ResultMessage.EXISTED;
		}
	}

	@Override
	public List<CreditRecordPO> findByUsername (String username){//搜索所有该username的信用记录；
		List<CreditRecordPO> list = new ArrayList<CreditRecordPO>();
		for(Integer i :map.keySet()){
			if(map.get(i).getUsername().equals(username)){
				list.add(map.get(i));
			}
		}
		return list;
	}
	
}