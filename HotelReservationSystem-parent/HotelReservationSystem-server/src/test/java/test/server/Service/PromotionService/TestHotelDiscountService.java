package test.server.Service.PromotionService;

import static org.junit.Assert.*;

import java.text.ParseException;
import java.util.Date;
import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import hrs.common.VO.HotelDiscountVO;
import hrs.common.VO.HotelVO;
import hrs.common.util.type.HotelDiscountType;
import hrs.server.Service.Impl.PromotionService.HotelDiscountService.HotelDiscount;
import hrs.server.Service.Interface.PromotionService.HotelDiscountService;
import hrs.server.util.DateHelper;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = { "classpath:applicationContext.xml" })
public class TestHotelDiscountService {
	@Autowired
	private HotelDiscountService service;

	@Test
	public void testAdd1() {
		HotelVO hotel = new HotelVO();
		hotel.id = 4;
		HotelDiscountVO vo = new HotelDiscountVO(hotel, 0.95, HotelDiscountType.Birthday, null, 0, null,null);
		service.add(vo);
		List<HotelDiscountVO> vos = service.findAllByHotelID(4);
		for(HotelDiscountVO v:vos){
			if(v.type == HotelDiscountType.Birthday){
				System.out.println(v);
				return;
			}
		}
		fail();
	}
	@Test
	public void testAdd2() throws ParseException {
		HotelVO hotel = new HotelVO();
		hotel.id = 4;
		Date begin = DateHelper.parseWithHMS("2016-10-01 08:18:12");
		Date end = DateHelper.parseWithHMS("2016-10-23 20:24:09");
		HotelDiscountVO vo = new HotelDiscountVO(hotel, 0.95, HotelDiscountType.SpecialPeriod, null, 0, begin,end);
		service.add(vo);
		List<HotelDiscountVO> vos = service.findAllByHotelID(4);
		for(HotelDiscountVO v:vos){
			if(v.type == HotelDiscountType.SpecialPeriod){
				System.out.println(v);
				return;
			}
		}
		fail();
	}

	@Test
	public void testUpdate() {
		HotelDiscountVO vo = service.findAllByHotelID(1).get(0);
		vo.discount = 0.22;
		service.update(vo);
		vo = service.findAllByHotelID(1).get(0);
		assertEquals(vo.discount,0.22,0.01);
	}

	@Test
	public void testDelete() {
		int deletedID  = service.findAllByHotelID(1).get(0).id;
		service.delete(deletedID);
		for(HotelDiscountVO vo:service.findAllByHotelID(1)){
			if(vo.id == deletedID){
				fail();
			}
		}
	}

	@Test
	public void testFindAllByHotelID() {
		List<HotelDiscountVO> list = service.findAllByHotelID(1);
		for (HotelDiscountVO vo : list) {
			System.out.println(vo);
			assertEquals(vo.hotel.id, 1);
		}
	}
	
	@Test
	public void testCreateAllStrategies(){
		List<HotelDiscount> strategies = service.createAllStrategies(1);
		for(HotelDiscount disc:strategies){
			System.out.println(disc.getClass().getName());
		}
		assertNotNull(strategies);
	}
}
