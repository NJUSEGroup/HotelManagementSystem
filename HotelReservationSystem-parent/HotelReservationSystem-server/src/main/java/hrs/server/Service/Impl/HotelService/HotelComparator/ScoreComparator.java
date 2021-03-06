package hrs.server.Service.Impl.HotelService.HotelComparator;

import org.springframework.stereotype.Component;

import hrs.common.VO.HotelVO;
/**
 * 
* @ClassName: ScoreComparator
* @Description: 评分比较器
* @author NewSong
* @date 2016年11月19日 下午10:07:06
*
 */
@Component("ScoreComparator")
public class ScoreComparator extends HotelComparator {
	
	@Override
	public int compare(HotelVO o1, HotelVO o2) {
		if (super.isDecrease) {
			return o1.score <= o2.score ? 1 : -1;
		} else {
			return o1.score >= o2.score ? 1 : -1;
		}
	}

}