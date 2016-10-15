package hrs.client.VO;

import java.io.Serializable;

import hrs.common.util.type.CreditRecordType;

public class CreditRecordVO implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private int id;
	private String username;
	private CreditRecordType type;
	private int variation;
	private int currCredit;
	
	
	public CreditRecordVO() {
		// TODO Auto-generated constructor stub
	}
	
	
	public CreditRecordVO(int id, String username, CreditRecordType type, int variation, int currCredit) {
		super();
		this.id = id;
		this.username = username;
		this.type = type;
		this.variation = variation;
		this.currCredit = currCredit;
	}


	public CreditRecordVO(int id, String username, CreditRecordType type, int variation) {
		super();
		this.id = id;
		this.username = username;
		this.type = type;
		this.variation = variation;
	}


	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public CreditRecordType getType() {
		return type;
	}

	public void setType(CreditRecordType type) {
		this.type = type;
	}

	public int getVariation() {
		return variation;
	}

	public void setVariation(int variation) {
		this.variation = variation;
	}

	public int getCurrCredit() {
		return currCredit;
	}

	public void setCurrCredit(int currCredit) {
		this.currCredit = currCredit;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + currCredit;
		result = prime * result + id;
		result = prime * result + ((type == null) ? 0 : type.hashCode());
		result = prime * result + ((username == null) ? 0 : username.hashCode());
		result = prime * result + variation;
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		CreditRecordVO other = (CreditRecordVO) obj;
		if (currCredit != other.currCredit)
			return false;
		if (id != other.id)
			return false;
		if (type != other.type)
			return false;
		if (username == null) {
			if (other.username != null)
				return false;
		} else if (!username.equals(other.username))
			return false;
		if (variation != other.variation)
			return false;
		return true;
	}
	
}
