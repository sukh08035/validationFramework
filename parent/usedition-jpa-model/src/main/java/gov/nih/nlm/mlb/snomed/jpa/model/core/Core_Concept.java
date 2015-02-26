package gov.nih.nlm.mlb.snomed.jpa.model.core;

import gov.nih.nlm.mlb.snomed.jpa.model.extention.Component_Id;

import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Table(name = "core_concept")
public class Core_Concept {

	/** The id. id	effectiveTime	active	moduleId	definitionStatusId*/
	@EmbeddedId
	private Component_Id Id;
	@Column(nullable = false, unique = false, length = 18)
	private long definitionStatusId;
	
	
	public long getDefinitionStatusId() {
		return definitionStatusId;
	}
	public void setDefinitionStatusId(long definitionStatusId) {
		this.definitionStatusId = definitionStatusId;
	}
	public Component_Id getId() {
		return Id;
	}
	public void setId(Component_Id id) {
		Id = id;
	}
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((Id == null) ? 0 : Id.hashCode());
		result = prime * result
				+ (int) (definitionStatusId ^ (definitionStatusId >>> 32));
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
		Core_Concept other = (Core_Concept) obj;
		if (Id == null) {
			if (other.Id != null)
				return false;
		} else if (!Id.equals(other.Id))
			return false;
		if (definitionStatusId != other.definitionStatusId)
			return false;
		return true;
	}
	

}
