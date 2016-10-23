package hrs.server.Service.Impl.UserService;

import org.springframework.beans.BeanUtils;
import org.springframework.transaction.annotation.Transactional;

import hrs.common.VO.UserVO;
import hrs.common.util.ResultMessage;
import hrs.server.DAO.Interface.UserDAO;
import hrs.server.POJO.UserPO;
import hrs.server.Service.Interface.UserService.UserService;
import hrs.server.util.SpringUtils;

public class UserServiceImpl implements UserService {
	private UserDAO dao;

	public UserDAO getDao() {
		return dao;
	}

	public void setDao(UserDAO dao) {
		this.dao = dao;
	}

	@Transactional
	@Override
	public UserVO findByUsername(String username) {
		UserVO vo = new UserVO();
		BeanUtils.copyProperties(dao.findByUserName(username), vo);
		return vo;
	}

	@Transactional
	@Override
	public ResultMessage register(UserVO uservo) {
		UserPO po = new UserPO();
		BeanUtils.copyProperties(uservo, po);
		return dao.add(po);
	}

	@Transactional
	@Override
	public ResultMessage update(UserVO uservo) {
		UserPO po = new UserPO();
		BeanUtils.copyProperties(uservo, po);
		return dao.update(po);
	}

	@Transactional
	@Override
	public UserVO login(String username, String password) {
		UserPO po = dao.findByUserName(username);
		if (po == null || !po.getPassword().equals(password)) {
			return null;
		} else {
			UserVO vo = new UserVO();
			BeanUtils.copyProperties(po, vo);
			return vo;
		}
	}

	public static void main(String[] args) {
		UserService userService = SpringUtils.getBean("userService");
		System.out.println(userService.findByUsername("admin").password);
	}
}