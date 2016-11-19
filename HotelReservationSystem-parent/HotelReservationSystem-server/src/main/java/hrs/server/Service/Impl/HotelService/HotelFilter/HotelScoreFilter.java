package hrs.server.Service.Impl.HotelService.HotelFilter;

import java.util.Iterator;
import java.util.List;
import java.util.Map;

import hrs.common.VO.HotelVO;
import hrs.common.VO.RoomVO;
import hrs.common.util.FilterCondition.ScoreFilterCondition;

public class HotelScoreFilter extends HotelFilter {

	@Override
	public void doFilter(Map<HotelVO, List<RoomVO>> hotels) {
		ScoreFilterCondition condition = (ScoreFilterCondition) super.condition;
		Iterator<HotelVO> it = hotels.keySet().iterator();
		HotelVO vo = null;
		while (it.hasNext()) {
			vo = it.next();
			if (vo.score < condition.getLow() || vo.score > condition.getHigh()) {
				it.remove();
			}
		}
	}
}
