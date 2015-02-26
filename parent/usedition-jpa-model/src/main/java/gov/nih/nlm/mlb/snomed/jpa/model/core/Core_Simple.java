package gov.nih.nlm.mlb.snomed.jpa.model.core;

import gov.nih.nlm.mlb.snomed.jpa.model.extention.Component_Refset_Id;

import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.Table;


@Entity
@Table(name = "core_simple")
public class Core_Simple {

	@EmbeddedId
	private Component_Refset_Id Id;
	
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((Id == null) ? 0 : Id.hashCode());
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
		Core_Simple other = (Core_Simple) obj;
		if (Id == null) {
			if (other.Id != null)
				return false;
		} else if (!Id.equals(other.Id))
			return false;
		return true;
	}
	public void setId(Component_Refset_Id id) {
		Id = id;
	}
   
}
