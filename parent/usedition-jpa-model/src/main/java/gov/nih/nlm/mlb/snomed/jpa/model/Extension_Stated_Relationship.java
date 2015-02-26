package gov.nih.nlm.mlb.snomed.jpa.model;

import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Table(name = "extension_statedrelationship")
public class Extension_Stated_Relationship {

	@EmbeddedId
	private Component_Id Id;
	@Column(nullable = false, unique = false, length = 18)
	private long sourceId;
	@Column(nullable = false, unique = false, length = 18)
	private long destinationId;
	@Column(nullable = false, unique = false, length = 1)
	private int relationshipGroup;
	@Column(nullable = false, unique = false, length = 18)
	private long typeId;
	@Column(nullable = false, unique = false, length = 18)
	private long characteristicTypeId;
	@Column(nullable = false, unique = false, length = 18)
	private long modifierId;
	
	public long getSourceId() {
		return sourceId;
	}
	public void setSourceId(long sourceId) {
		this.sourceId = sourceId;
	}
	public long getDestinationId() {
		return destinationId;
	}
	public void setDestinationId(long destinationId) {
		this.destinationId = destinationId;
	}
	public int getRelationshipGroup() {
		return relationshipGroup;
	}
	public void setRelationshipGroup(int relationshipGroup) {
		this.relationshipGroup = relationshipGroup;
	}
	public long getTypeId() {
		return typeId;
	}
	public void setTypeId(long typeId) {
		this.typeId = typeId;
	}
	public long getCharacteristicTypeId() {
		return characteristicTypeId;
	}
	public void setCharacteristicTypeId(long characteristicTypeId) {
		this.characteristicTypeId = characteristicTypeId;
	}
	public long getModifierId() {
		return modifierId;
	}
	public void setModifierId(long modifierId) {
		this.modifierId = modifierId;
	}
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((Id == null) ? 0 : Id.hashCode());
		result = prime * result
				+ (int) (characteristicTypeId ^ (characteristicTypeId >>> 32));
		result = prime * result
				+ (int) (destinationId ^ (destinationId >>> 32));
		result = prime * result + (int) (modifierId ^ (modifierId >>> 32));
		result = prime * result + relationshipGroup;
		result = prime * result + (int) (sourceId ^ (sourceId >>> 32));
		result = prime * result + (int) (typeId ^ (typeId >>> 32));
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
		Extension_Stated_Relationship other = (Extension_Stated_Relationship) obj;
		if (Id == null) {
			if (other.Id != null)
				return false;
		} else if (!Id.equals(other.Id))
			return false;
		if (characteristicTypeId != other.characteristicTypeId)
			return false;
		if (destinationId != other.destinationId)
			return false;
		if (modifierId != other.modifierId)
			return false;
		if (relationshipGroup != other.relationshipGroup)
			return false;
		if (sourceId != other.sourceId)
			return false;
		if (typeId != other.typeId)
			return false;
		return true;
	}
	public Component_Id getId() {
		return Id;
	}
	public void setId(Component_Id id) {
		Id = id;
	}

}
