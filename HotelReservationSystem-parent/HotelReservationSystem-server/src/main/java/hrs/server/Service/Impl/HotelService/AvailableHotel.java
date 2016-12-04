package hrs.server.Service.Impl.HotelService;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;

import hrs.common.VO.HotelVO;
import hrs.common.VO.RoomVO;
import hrs.common.util.FilterCondition.FilterCondition;
import hrs.common.util.type.OrderRule;
import hrs.server.Service.Impl.HotelService.HotelComparator.HotelComparator;
import hrs.server.Service.Impl.HotelService.HotelFilter.HotelFilter;
import hrs.server.util.SpringUtils;

/**
 * 
 * @ClassName: AvailableHotel
 * @Description: TODO
 * @author NewSong
 * @date 2016年11月19日 下午10:03:33
 *
 */
public class AvailableHotel {
	/**
	 * 存储一个酒店和房间列表的键值对
	 */

	/**
	 * 
	 * @Title: filter @Description: 过滤酒店和房间 @param conditions @param @return
	 * Map<HotelVO,List<RoomVO>> @throws
	 */
	public Map<HotelVO, List<RoomVO>> filter(Map<HotelVO, List<RoomVO>> data,List<FilterCondition> conditions) {
		Map<HotelVO, List<RoomVO>> res = new HashMap<>();
		res.putAll(data);
		HotelFilter filter = null;
		for (FilterCondition condition : conditions) {
			System.out.println(condition);
			filter = SpringUtils.getBean(condition.getType().toString() + "Filter");
			filter.setFilterCondition(condition);
			filter.doFilter(res);
		}
		System.out.println(res.size());
		return res;
	}

	/**
	 * 
	 * @Title: order @Description: 按照给定的排序规则和升降序对酒店进行排序 @param rule @param
	 * isDecrease @return Map<HotelVO,List<RoomVO>> @throws
	 */
	public Map<HotelVO, List<RoomVO>> order(Map<HotelVO, List<RoomVO>> data,OrderRule rule, boolean isDecrease) {
		HotelComparator comp = SpringUtils.getBean(rule.toString()+"Comparator");
		comp.setDecrease(isDecrease);
		Map<HotelVO, List<RoomVO>> res = new TreeMap<>(comp);
		res.putAll(data);
		return res;
	}
	
}
