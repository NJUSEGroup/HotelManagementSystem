package test.server.Service.HotelService;

import static org.junit.Assert.assertEquals;

import java.text.ParseException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Map;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import hrs.common.Exception.HotelService.HotelNotFoundException;
import hrs.common.VO.CommercialCircleVO;
import hrs.common.VO.HotelVO;
import hrs.common.VO.LocationVO;
import hrs.common.VO.OrderVO;
import hrs.common.VO.RoomVO;
import hrs.common.util.FilterCondition.FilterCondition;
import hrs.common.util.FilterCondition.NameFilterCondition;
import hrs.common.util.FilterCondition.RoomTypeFilterCondition;
import hrs.common.util.FilterCondition.ScoreFilterCondition;
import hrs.common.util.FilterCondition.StarFilterCondition;
import hrs.common.util.type.FilterType;
import hrs.common.util.type.OrderRule;
import hrs.common.util.type.OrderStatus;
import hrs.common.util.type.RoomType;
import hrs.server.Service.Interface.HotelService.HotelService;
import hrs.server.util.DateHelper;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = { "classpath:applicationContext.xml" })
public class TestHotelService {
	@Autowired
	private HotelService service;

	@Test
	public void testFindByID() throws HotelNotFoundException {
		HotelVO vo = service.findByID(1);
		assertEquals(vo.star, 3);
		System.out.println(vo);
	}

	@Test
	public void testUpdate() throws HotelNotFoundException {
		HotelVO vo = service.findByID(1);
		vo.name = "呼呼呼酒店";
		service.update(vo);
		assertEquals("呼呼呼酒店", service.findByID(1).name);
	}

	@Test
	public void testAdd() throws HotelNotFoundException {
		LocationVO loc = new LocationVO();
		loc.id = 1;
		CommercialCircleVO circle = new CommercialCircleVO();
		circle.id = 1;
		HotelVO vo = new HotelVO("啦啦啦酒店", 2, 0, loc, circle, "简介", "服务优质", "仙林大道", 0);
		service.add(vo);
		vo = service.findByID(7);
		assertEquals(vo.name, "啦啦啦酒店");
		assertEquals(vo.profile, "简介");
		System.out.println(vo);
	}

	@Test
	public void testFindOrderedHotelAndOrder() {
		Map<HotelVO, List<OrderVO>> map = service.findOrderedHotelAndOrder("admin");
		for (HotelVO hotel : map.keySet()) {
			System.out.println(hotel);
			for (OrderVO order : map.get(hotel)) {
				System.out.println(order);
				assertEquals(order.user.username, "admin");
			}
			System.out.println();
		}
	}

	@Test
	public void testFind1() throws ParseException, HotelNotFoundException {
		Date begin = DateHelper.parseWithHMS("2016-10-19 12:00:00");
		Date end = DateHelper.parseWithHMS("2016-10-20 00:00:00");
		Map<HotelVO, List<RoomVO>> map = service.find(1, 2, begin, end, "admin");
		assertEquals(map.size(), 1);
	}

	@Test
	public void testFind2() throws ParseException, HotelNotFoundException {
		Date begin = DateHelper.parseWithHMS("2016-11-27 00:00:00");
		Date end = DateHelper.parseWithHMS("2016-11-29 00:00:00");
		Map<HotelVO, List<RoomVO>> map = service.find(1, 2, begin, end, "admin");
		System.out.println(map.size());
		for (HotelVO vo : map.keySet()) {
			System.out.println(vo);
			for (RoomVO room : map.get(vo)) {
				System.out.println(room);
			}
			System.out.println();
			assertEquals(vo.lowValue, 300.0, 0.01);
			assertEquals(vo.highValue, 500.0, 0.01);
		}
	}

	@Test
	public void testFind3() throws ParseException, HotelNotFoundException {
		Date begin = DateHelper.parseWithHMS("2016-10-27 00:00:00");
		Date end = DateHelper.parseWithHMS("2016-11-19 00:00:00");
		Map<HotelVO, List<RoomVO>> map = service.find(1, 2, begin, end, "admin");
		System.out.println(map.size());
		for (HotelVO vo : map.keySet()) {
			System.out.println(vo);
			for (RoomVO room : map.get(vo)) {
				System.out.println(room);
			}
			System.out.println();
			// assertEquals(vo.lowValue,300.0,0.01);
			// assertEquals(vo.highValue,500.0,0.01);
			for (OrderStatus status : vo.status) {
				System.out.println(status);
			}
			System.out.println();
			System.out.println();
		}
	}

	@Test
	public void testGetRoomDetail1() throws HotelNotFoundException {
		for (RoomVO vo : service.getRoomDetail(1)) {
			System.out.println(vo);
			assertEquals(vo.hotel.id, 1);
		}
	}

	@Test
	public void testGetRoomDetail2() throws ParseException, HotelNotFoundException {
		Date begin = DateHelper.parseWithHMS("2016-10-27 00:00:00");
		Date end = DateHelper.parseWithHMS("2016-11-19 00:00:00");
		service.find(1, 2, begin, end, "admin");
		for (RoomVO vo : service.getRoomDetail(1)) {
			System.out.println(vo);
			assertEquals(vo.hotel.id, 1);
		}
	}

	@Test
	public void testOrderByScore() throws ParseException, HotelNotFoundException {
		Date begin = DateHelper.parseWithHMS("2016-10-27 00:00:00");
		Date end = DateHelper.parseWithHMS("2016-11-19 00:00:00");
		Map<HotelVO, List<RoomVO>> map = service.find(1, 2, begin, end, "admin");
		for (HotelVO vo : map.keySet()) {
			System.out.println(vo);
			for (RoomVO room : map.get(vo)) {
				System.out.println(room);
			}
			System.out.println();
		}
		System.out.println();

		Map<HotelVO, List<RoomVO>> res = service.order(OrderRule.Score, true);
		for (HotelVO vo : res.keySet()) {
			System.out.println(vo);
			for (RoomVO room : map.get(vo)) {
				System.out.println(room);
			}
			System.out.println();
		}
	}

	@Test
	public void testOrderByStar() throws ParseException, HotelNotFoundException {
		Date begin = DateHelper.parseWithHMS("2016-10-27 00:00:00");
		Date end = DateHelper.parseWithHMS("2016-11-19 00:00:00");
		Map<HotelVO, List<RoomVO>> map = service.find(1, 2, begin, end, "admin");
		for (HotelVO vo : map.keySet()) {
			System.out.println(vo);
			for (RoomVO room : map.get(vo)) {
				System.out.println(room);
			}
			System.out.println();
		}
		System.out.println();

		Map<HotelVO, List<RoomVO>> res = service.order(OrderRule.Star, true);
		for (HotelVO vo : res.keySet()) {
			System.out.println(vo);
			for (RoomVO room : map.get(vo)) {
				System.out.println(room);
			}
			System.out.println();
		}
	}

	@Test
	public void testOrderByValue() throws ParseException, HotelNotFoundException {
		Date begin = DateHelper.parseWithHMS("2016-10-27 00:00:00");
		Date end = DateHelper.parseWithHMS("2016-11-19 00:00:00");
		Map<HotelVO, List<RoomVO>> map = service.find(1, 2, begin, end, "admin");
		for (HotelVO vo : map.keySet()) {
			System.out.println(vo);
			for (RoomVO room : map.get(vo)) {
				System.out.println(room);
			}
			System.out.println();
		}
		System.out.println();

		Map<HotelVO, List<RoomVO>> res = service.order(OrderRule.Value, true);
		for (HotelVO vo : res.keySet()) {
			System.out.println(vo);
			for (RoomVO room : map.get(vo)) {
				System.out.println(room);
			}
			System.out.println();
		}
	}

	@Test
	public void testFilterByName() throws ParseException, HotelNotFoundException {
		Date begin = DateHelper.parseWithHMS("2016-10-27 00:00:00");
		Date end = DateHelper.parseWithHMS("2016-11-19 00:00:00");
		Map<HotelVO, List<RoomVO>> map = service.find(1, 2, begin, end, "admin");
		for (HotelVO vo : map.keySet()) {
			System.out.println(vo);
			for (RoomVO room : map.get(vo)) {
				System.out.println(room);
			}
			System.out.println();
		}
		System.out.println();

		List<FilterCondition> list = new ArrayList<>();
		NameFilterCondition fc = new NameFilterCondition(FilterType.Name);
		fc.setHotelName("仙林");
		list.add(fc);
		Map<HotelVO, List<RoomVO>> res = service.filter(list);
		System.out.println(res.size());
		for (HotelVO vo : res.keySet()) {
			System.out.println(vo);
			for (RoomVO room : map.get(vo)) {
				System.out.println(room);
			}
			System.out.println();
		}
	}

	@Test
	public void testFilterByRoomType1() throws ParseException, HotelNotFoundException {
		Date begin = DateHelper.parseWithHMS("2016-10-27 00:00:00");
		Date end = DateHelper.parseWithHMS("2016-11-19 00:00:00");
		Map<HotelVO, List<RoomVO>> map = service.find(1, 2, begin, end, "admin");
		for (HotelVO vo : map.keySet()) {
			System.out.println(vo);
			for (RoomVO room : map.get(vo)) {
				System.out.println(room);
			}
			System.out.println();
		}
		System.out.println();

		List<FilterCondition> list = new ArrayList<>();
		RoomTypeFilterCondition condition = new RoomTypeFilterCondition(FilterType.RoomType);
		condition.setRoomType(RoomType.Single);
		list.add(condition);
		Map<HotelVO, List<RoomVO>> res = service.filter(list);
		System.out.println(res.size());
		for (HotelVO vo : res.keySet()) {
			System.out.println(vo);
			for (RoomVO room : map.get(vo)) {
				assertEquals(room.type,RoomType.Single);
				System.out.println(room);
			}
			System.out.println();
		}
	}

	@Test
	public void testFilterByRoomType2() throws ParseException, HotelNotFoundException {
		Date begin = DateHelper.parseWithHMS("2016-10-27 00:00:00");
		Date end = DateHelper.parseWithHMS("2016-11-19 00:00:00");
		Map<HotelVO, List<RoomVO>> map = service.find(1, 2, begin, end, "admin");
		for (HotelVO vo : map.keySet()) {
			System.out.println(vo);
			for (RoomVO room : map.get(vo)) {
				System.out.println(room);
			}
			System.out.println();
		}
		System.out.println();

		List<FilterCondition> list = new ArrayList<>();
		RoomTypeFilterCondition condition = new RoomTypeFilterCondition(FilterType.RoomType);
		condition.setRoomType(RoomType.Standard);
		list.add(condition);
		Map<HotelVO, List<RoomVO>> res = service.filter(list);
		System.out.println(res.size());
		for (HotelVO vo : res.keySet()) {
			System.out.println(vo);
			for (RoomVO room : map.get(vo)) {
				assertEquals(room.type,RoomType.Standard);
				System.out.println(room);
			}
			System.out.println();
		}
	}

	@Test
	public void testFilterByScore() throws ParseException, HotelNotFoundException {
		Date begin = DateHelper.parseWithHMS("2016-10-27 00:00:00");
		Date end = DateHelper.parseWithHMS("2016-11-19 00:00:00");
		Map<HotelVO, List<RoomVO>> map = service.find(1, 2, begin, end, "admin");
		for (HotelVO vo : map.keySet()) {
			System.out.println(vo);
			for (RoomVO room : map.get(vo)) {
				System.out.println(room);
			}
			System.out.println();
		}
		System.out.println();

		List<FilterCondition> list = new ArrayList<>();
		ScoreFilterCondition condition = new ScoreFilterCondition(FilterType.Score);
		condition.setLow(9);
		condition.setHigh(10);
		list.add(condition);
		Map<HotelVO, List<RoomVO>> res = service.filter(list);
		System.out.println(res.size());
		for (HotelVO vo : res.keySet()) {
			System.out.println(vo);
			for (RoomVO room : map.get(vo)) {
				System.out.println(room);
			}
			System.out.println();
		}
	}

	@Test
	public void testFilterByStar() throws ParseException, HotelNotFoundException {
		Date begin = DateHelper.parseWithHMS("2016-10-27 00:00:00");
		Date end = DateHelper.parseWithHMS("2016-11-19 00:00:00");
		Map<HotelVO, List<RoomVO>> map = service.find(1, 2, begin, end, "admin");
		for (HotelVO vo : map.keySet()) {
			System.out.println(vo);
			for (RoomVO room : map.get(vo)) {
				System.out.println(room);
			}
			System.out.println();
		}
		System.out.println();

		List<FilterCondition> list = new ArrayList<>();
		StarFilterCondition condition = new StarFilterCondition(FilterType.Star);
		condition.setStar(3);
		list.add(condition);
		Map<HotelVO, List<RoomVO>> res = service.filter(list);
		System.out.println(res.size());
		for (HotelVO vo : res.keySet()) {
			assertEquals(vo.star,3);
			System.out.println(vo);
			for (RoomVO room : map.get(vo)) {
				System.out.println(room);
			}
		}
	}
	
	@Test
	public void testMultiFilterCondition() throws ParseException, HotelNotFoundException{
		Date begin = DateHelper.parseWithHMS("2016-10-27 00:00:00");
		Date end = DateHelper.parseWithHMS("2016-11-19 00:00:00");
		Map<HotelVO, List<RoomVO>> map = service.find(1, 2, begin, end, "admin");
		for (HotelVO vo : map.keySet()) {
			System.out.println(vo);
			for (RoomVO room : map.get(vo)) {
				System.out.println(room);
			}
			System.out.println();
		}
		System.out.println();

		List<FilterCondition> list = new ArrayList<>();
		StarFilterCondition c1 = new StarFilterCondition(FilterType.Star);
		c1.setStar(2);
		ScoreFilterCondition c2 = new ScoreFilterCondition(FilterType.Score);
		c2.setLow(9);
		c2.setHigh(10);
		list.add(c1);
		list.add(c2);
		Map<HotelVO, List<RoomVO>> res = service.filter(list);
		assertEquals(res.size(),0);
	}
}
