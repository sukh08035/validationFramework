package gov.nih.nlm.mlb.snomed.jpa.model.core;

import gov.nih.nlm.mlb.snomed.jpa.model.extention.Component_Refset_Id;

import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Table;
import javax.persistence.Entity;
@Entity
@Table(name = "core_language")
public class Core_Language {

	@EmbeddedId
	private Component_Refset_Id Id;
	@Column(nullable = false, unique = false, length = 18)
	private long acceptabilityId;
	
	public long getAcceptabilityId() {
		return acceptabilityId;
	}
	public void setAcceptabilityId(long acceptabilityId) {
		this.acceptabilityId = acceptabilityId;
	}
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((Id == null) ? 0 : Id.hashCode());
		result = prime * result
				+ (int) (acceptabilityId ^ (acceptabilityId >>> 32));
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
		Core_Language other = (Core_Language) obj;
		if (Id == null) {
			if (other.Id != null)
				return false;
		} else if (!Id.equals(other.Id))
			return false;
		if (acceptabilityId != other.acceptabilityId)
			return false;
		return true;
	}
	public void setId(Component_Refset_Id id) {
		Id = id;
	}
	
}
