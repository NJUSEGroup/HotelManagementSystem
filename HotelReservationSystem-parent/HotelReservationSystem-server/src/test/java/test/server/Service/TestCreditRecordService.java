package test.server.Service;

import static org.junit.Assert.*;

import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import hrs.common.VO.CreditRecordVO;
import hrs.common.VO.OrderVO;
import hrs.common.VO.UserVO;
import hrs.common.util.type.CreditRecordType;
import hrs.server.Service.Interface.CreditRecordService.CreditRecordService;
import hrs.server.Service.Interface.UserService.UserService;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = { "classpath:applicationContext.xml" })
public class TestCreditRecordService {
	@Autowired
	private CreditRecordService service;
	@Autowired
	private UserService userService;

	@Test
	public void testfindByUsername() {
		List<CreditRecordVO> vos = service.findByUsername("admin");
		for (CreditRecordVO vo : vos) {
			System.out.println(vo);
			assertEquals(vo.user.username, "admin");
		}
	}

	@Test
	public void testAdd() {
		OrderVO order = new OrderVO();
		order.id = 22;
		UserVO user = userService.findByUsername("admin");
		CreditRecordVO vo = new CreditRecordVO(order, user, CreditRecordType.Execute, 400);
		service.add(vo);
		List<CreditRecordVO> list = service.findByUsername("admin");
		 
		assertEquals(userService.findByUsername("admin").credit,1200);
		assertEquals(userService.findByUsername("admin").VIPLevel,2);
		for(CreditRecordVO record:list){
			if(record.variation == 400 && record.type == CreditRecordType.Execute){
				return;
			}
		}
		fail();
	}

}