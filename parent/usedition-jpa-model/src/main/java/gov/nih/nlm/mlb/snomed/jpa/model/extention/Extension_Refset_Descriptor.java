package gov.nih.nlm.mlb.snomed.jpa.model.extention;

import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Table(name = "extension_refsetdescriptor")
public class Extension_Refset_Descriptor {
	
	@EmbeddedId
	private Component_Refset_Id Id;
	@Column(nullable = false, unique = false, length = 18)
	private long attributeDescription;
	@Column(nullable = false, unique = false, length = 18)
	private long attributeType;
	@Column(nullable = false, unique = false, length = 18)
	private long attributeOrder;
	
	public long getAttributeDescription() {
		return attributeDescription;
	}
	public void setAttributeDescription(long attributeDescription) {
		this.attributeDescription = attributeDescription;
	}
	public long getAttributeType() {
		return attributeType;
	}
	public void setAttributeType(long attributeType) {
		this.attributeType = attributeType;
	}
	public long getAttributeOrder() {
		return attributeOrder;
	}
	public void setAttributeOrder(long attributeOrder) {
		this.attributeOrder = attributeOrder;
	}
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((Id == null) ? 0 : Id.hashCode());
		result = prime * result
				+ (int) (attributeDescription ^ (attributeDescription >>> 32));
		result = prime * result
				+ (int) (attributeOrder ^ (attributeOrder >>> 32));
		result = prime * result
				+ (int) (attributeType ^ (attributeType >>> 32));
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
		Extension_Refset_Descriptor other = (Extension_Refset_Descriptor) obj;
		if (Id == null) {
			if (other.Id != null)
				return false;
		} else if (!Id.equals(other.Id))
			return false;
		if (attributeDescription != other.attributeDescription)
			return false;
		if (attributeOrder != other.attributeOrder)
			return false;
		if (attributeType != other.attributeType)
			return false;
		return true;
	}
	public void setId(Component_Refset_Id id) {
		Id = id;
	}
	
}
