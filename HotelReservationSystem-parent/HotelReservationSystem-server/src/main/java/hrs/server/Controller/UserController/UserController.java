package hrs.server.Controller.UserController;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import hrs.common.Controller.UserController.IUserController;
import hrs.common.Exception.CreditRecordService.CreditRecordNotFoundException;
import hrs.common.VO.CreditRecordVO;
import hrs.common.VO.UserVO;
import hrs.server.Service.Interface.CreditRecordService.CreditRecordService;
import hrs.server.Service.Interface.UserService.UserService;

@Controller
public class UserController implements IUserController{
	@Autowired
	private UserService userService;
	@Autowired
	private CreditRecordService creditRecordService;
	
	@Override
	public void updateUser(UserVO uservo) {
		userService.update(uservo);
	}
	
	@Override
	public UserVO findUserByUsername(String username) {
		return userService.findByUsername(username);
	}
	@Override
	
	public List<CreditRecordVO> findCreditRecordByUsername(String username) throws CreditRecordNotFoundException {
		return creditRecordService.findByUsername(username);
	}
	
	
}
