package test.server.DAO;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import java.text.ParseException;
import java.util.List;

import javax.persistence.Transient;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.transaction.annotation.Transactional;

import hrs.common.POJO.HotelPO;
import hrs.common.POJO.RoomPO;
import hrs.common.util.type.RoomType;
import hrs.server.DAO.Interface.RoomDAO;
import hrs.server.util.DateFormatter;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = { "classpath:applicationContext.xml" })
public class TestRoomDAO {
	@Autowired
	private RoomDAO dao;

	@Transactional
	@Test
	public void testAdd() {
		HotelPO hotel = new HotelPO();
		hotel.setId(4);
		RoomPO po = new RoomPO(hotel, RoomType.Business, 20, 400);
		dao.add(po);
		List<RoomPO> list = dao.findByHotelID(4);
		assertTrue(list.contains(po));
	}

	@Transactional
	@Test
	public void testUpdate() {
		List<RoomPO> list = dao.findByHotelID(4);
		RoomPO room = null;
		for (RoomPO po : list) {
			if (po.getType() == RoomType.Single) {
				room = po;
			}
		}
		room.setRoomNum(10);
		dao.update(room);

		list = dao.findByHotelID(4);
		for (RoomPO po : list) {
			if (po.getType() == RoomType.Single) {
				assertEquals(po.getRoomNum(), 10);
			}
		}
	}

	@Transactional
	@Test
	public void testFindByHotelID1() {
		List<RoomPO> list = dao.findByHotelID(4);
		for (RoomPO po : list) {
			assertEquals(po.getHotel().getId(), 4);
		}
	}

	@Transactional
	@Test
	public void testFindByHotelID2() {
		List<RoomPO> list = dao.findByHotelID(7);
		for (RoomPO po : list) {
			assertEquals(po.getHotel().getId(), 7);
		}
	}

	@Transactional
	@Test
	public void testFindAvailableRoom() throws ParseException {
		assertEquals(dao.findAvailableRoom(1, RoomType.Single, DateFormatter.parse("2016-10-27 00:00:00", true)), 8);
	}

	@Transactional
	@Test
	public void testFindByHotelAndType() {
		assertEquals(dao.findByHotelAndType(1, RoomType.Single).getRoomNum(),8);
	}
}
