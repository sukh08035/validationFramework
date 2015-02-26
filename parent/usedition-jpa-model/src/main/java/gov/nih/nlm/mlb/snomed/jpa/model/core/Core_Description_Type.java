package gov.nih.nlm.mlb.snomed.jpa.model.core;

import gov.nih.nlm.mlb.snomed.jpa.model.Component_Refset_Id;

import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Table(name = "core_descriptiontype")
public class Core_Description_Type {

	@EmbeddedId
	private Component_Refset_Id Id;
	@Column(nullable = false, unique = false, length = 18)
	private long descriptionFormat;
	@Column(nullable = false, unique = false, length = 1)
	private int descriptionLength;
	
	public long getDescriptionFormat() {
		return descriptionFormat;
	}
	public void setDescriptionFormat(long descriptionFormat) {
		this.descriptionFormat = descriptionFormat;
	}
	public int getDescriptionLength() {
		return descriptionLength;
	}
	public void setDescriptionLength(int descriptionLength) {
		this.descriptionLength = descriptionLength;
	}
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((Id == null) ? 0 : Id.hashCode());
		result = prime * result
				+ (int) (descriptionFormat ^ (descriptionFormat >>> 32));
		result = prime * result + descriptionLength;
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
		Core_Description_Type other = (Core_Description_Type) obj;
		if (Id == null) {
			if (other.Id != null)
				return false;
		} else if (!Id.equals(other.Id))
			return false;
		if (descriptionFormat != other.descriptionFormat)
			return false;
		if (descriptionLength != other.descriptionLength)
			return false;
		return true;
	}
	public void setId(Component_Refset_Id id) {
		Id = id;
	}

}
