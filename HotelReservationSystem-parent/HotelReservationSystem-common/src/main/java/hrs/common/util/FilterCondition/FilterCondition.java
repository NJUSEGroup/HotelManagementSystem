package hrs.common.util.FilterCondition;

import java.io.Serializable;

import hrs.common.util.type.FilterType;

public abstract class FilterCondition implements Serializable{
	private FilterType type;
	public FilterType getType() {
		return type;
	}
	public void setType(FilterType type) {
		this.type = type;
	}
	public FilterCondition(FilterType type) {
		this.type = type;
	}
}
