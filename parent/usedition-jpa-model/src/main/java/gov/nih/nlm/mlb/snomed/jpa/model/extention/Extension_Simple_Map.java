package gov.nih.nlm.mlb.snomed.jpa.model.extention;

import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Table(name = "extension_simplemap")
public class Extension_Simple_Map {

	@EmbeddedId
	private Component_Refset_Id Id;
	@Column(nullable = false, unique = false, length = 100)
	private String mapTarget;
	
	public String getMapTarget() {
		return mapTarget;
	}
	public void setMapTarget(String mapTarget) {
		this.mapTarget = mapTarget;
	}
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((Id == null) ? 0 : Id.hashCode());
		result = prime * result
				+ ((mapTarget == null) ? 0 : mapTarget.hashCode());
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
		Extension_Simple_Map other = (Extension_Simple_Map) obj;
		if (Id == null) {
			if (other.Id != null)
				return false;
		} else if (!Id.equals(other.Id))
			return false;
		if (mapTarget == null) {
			if (other.mapTarget != null)
				return false;
		} else if (!mapTarget.equals(other.mapTarget))
			return false;
		return true;
	}
	public void setId(Component_Refset_Id id) {
		Id = id;
	}
}
