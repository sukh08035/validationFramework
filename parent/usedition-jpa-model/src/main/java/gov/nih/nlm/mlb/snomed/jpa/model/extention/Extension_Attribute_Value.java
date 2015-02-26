package gov.nih.nlm.mlb.snomed.jpa.model.extention;

import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.Table;
@Entity
@Table(name = "extension_attributevalue")
public class Extension_Attribute_Value {

	@EmbeddedId
	private Component_Refset_Id Id;
	@Column(nullable = false, unique = false, length = 18)
	private long valueId;
	
	public long getValueId() {
		return valueId;
	}
	public void setValueId(long valueId) {
		this.valueId = valueId;
	}
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((Id == null) ? 0 : Id.hashCode());
		result = prime * result + (int) (valueId ^ (valueId >>> 32));
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
		Extension_Attribute_Value other = (Extension_Attribute_Value) obj;
		if (Id == null) {
			if (other.Id != null)
				return false;
		} else if (!Id.equals(other.Id))
			return false;
		if (valueId != other.valueId)
			return false;
		return true;
	}
	public void setId(Component_Refset_Id id) {
		Id = id;
	}
	public Component_Refset_Id getId() {
		return Id;
	}
	
}
