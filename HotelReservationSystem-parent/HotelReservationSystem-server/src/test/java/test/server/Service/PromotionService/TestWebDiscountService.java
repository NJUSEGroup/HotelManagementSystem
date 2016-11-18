package test.server.Service.PromotionService;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.fail;

import java.text.ParseException;
import java.util.Date;
import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import hrs.common.VO.CommercialCircleVO;
import hrs.common.VO.LocationVO;
import hrs.common.VO.WebDiscountVO;
import hrs.common.util.type.WebsiteDiscountType;
import hrs.server.Service.Impl.PromotionService.WebDiscountService.WebDiscount;
import hrs.server.Service.Interface.PromotionService.WebDiscountService;
import hrs.server.util.DateFormatter;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = { "classpath:applicationContext.xml" })
public class TestWebDiscountService {
	@Autowired
	private WebDiscountService service;

	@Test
	public void testFindAll() {
		List<WebDiscountVO> vos = service.findAll();
		for(WebDiscountVO vo:vos){
			System.out.println(vo);
		}
		assertNotNull(vos);
	}

	@Test
	public void testAdd1() {
		LocationVO loc = new LocationVO();
		loc.id = 1;
		CommercialCircleVO circle = new CommercialCircleVO();
		circle.id = 1;
		WebDiscountVO vo = new WebDiscountVO(0.8, WebsiteDiscountType.SpecialCommercialCircle, loc, circle, null, null, 0);
		service.add(vo);
		for(WebDiscountVO disc:service.findAll()){
			if(disc.type == WebsiteDiscountType.SpecialCommercialCircle ){
				return;
			}
		}
		fail();
	}
	@Test
	public void testAdd2() throws ParseException {
		Date begin = DateFormatter.parseWithHMS("2016-10-01 08:18:12");
		Date end = DateFormatter.parseWithHMS("2016-10-23 20:24:09");
		WebDiscountVO vo = new WebDiscountVO(0.8, WebsiteDiscountType.SpecialPeriod, null, null, begin, end, 0);
		service.add(vo);
		for(WebDiscountVO disc:service.findAll()){
			if(disc.type == WebsiteDiscountType.SpecialPeriod ){
				return;
			}
		}
		fail();
	}
	@Test
	public void testUpdate() {
		WebDiscountVO vo = service.findAll().get(0);
		vo.discount = 0.9;
		service.update(vo);
		assertEquals(service.findAll().get(0), vo);
	}

	@Test
	public void testDelete() {
		service.delete(1);
		for(WebDiscountVO vo:service.findAll()){
			if(vo.id == 1){
				fail();
			}
		}
	}
	
	@Test
	public void testCreateStrategies(){
		List<WebDiscount> list = service.createAllStrategies();
		for(WebDiscount disc:list){
			System.out.println(disc.getClass().getName());
			
		}
	}
}