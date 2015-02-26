package gov.nih.nlm.mlb.snomed.jpa.model.core;

import gov.nih.nlm.mlb.snomed.jpa.model.Component_Refset_Id;

import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.Table;
@Entity
@Table(name = "core_associationreference")
public class Core_Association_Reference {

	@EmbeddedId
	private Component_Refset_Id Id;
	@Column(nullable = false, unique = false, length = 18)
	private long targetComponent;
	
	
	public long getTargetComponent() {
		return targetComponent;
	}
	public void setTargetComponent(long targetComponent) {
		this.targetComponent = targetComponent;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((Id == null) ? 0 : Id.hashCode());
		result = prime * result
				+ (int) (targetComponent ^ (targetComponent >>> 32));
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
		Core_Association_Reference other = (Core_Association_Reference) obj;
		if (Id == null) {
			if (other.Id != null)
				return false;
		} else if (!Id.equals(other.Id))
			return false;
		if (targetComponent != other.targetComponent)
			return false;
		return true;
	}
	public Component_Refset_Id getId() {
		return Id;
	}
	public void setId(Component_Refset_Id id) {
		Id = id;
	}
	
	
}
