package hrs.server.Service.Interface.OfflineRecordService;

import hrs.common.Exception.OfflineRecordService.OfflineRecordNotFoundException;
import hrs.common.VO.OfflineRecordVO;
import hrs.common.util.ResultMessage;

public interface OfflineRecordService {
	OfflineRecordVO findByID(int id) throws OfflineRecordNotFoundException;
	void checkin(OfflineRecordVO offlinerecordvo);
	void checkout(OfflineRecordVO offlinerecordvo);
}
