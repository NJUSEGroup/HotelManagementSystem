package hrs.StubAndDriver.Service.StaffService;

import org.springframework.beans.BeanUtils;

import hrs.StubAndDriver.DAO.StaffDAO.StaffDAOStub;
import hrs.common.POJO.StaffPO;
import hrs.common.VO.StaffVO;
import hrs.common.util.ResultMessage;
import hrs.server.DAO.Interface.StaffDAO;
import hrs.server.Service.Interface.StaffService.StaffService;

public class StaffServiceStub implements StaffService {
	private StaffDAO dao;

	public StaffServiceStub() {
		dao = new StaffDAOStub();
	}

	@Override
	public StaffVO login(String username, String password) {
		StaffPO po = dao.findByUsername(username);
		if (po == null || !po.getPassword().equals(password)) {
			return null;
		}
		StaffVO vo = new StaffVO();
		BeanUtils.copyProperties(po, vo);
		return vo;
	}

	@Override
	public ResultMessage update(StaffVO staffvo) {
		StaffPO po = new StaffPO();
		BeanUtils.copyProperties(staffvo, po);
		return dao.update(po);
	}

	@Override
	public ResultMessage add(StaffVO staffvo) {
		StaffPO po = new StaffPO();
		BeanUtils.copyProperties(staffvo, po);
		return dao.add(po);
	}

	@Override
	public StaffVO findByUsername(String username) {
		StaffPO po = dao.findByUsername(username);
		StaffVO vo = new StaffVO();
		BeanUtils.copyProperties(po, vo);
		return vo;
	}

	@Override
	public StaffVO findByHotelName(String hotelName) {
		StaffPO po = dao.findByHotelName(hotelName);
		StaffVO vo = new StaffVO();
		BeanUtils.copyProperties(po, vo);
		return vo;
	}
}
