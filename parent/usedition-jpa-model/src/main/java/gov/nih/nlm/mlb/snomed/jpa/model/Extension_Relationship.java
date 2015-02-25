package gov.nih.nlm.mlb.snomed.jpa.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "extension_relationship")
public class Extension_Relationship {
	@Id
	@Column(nullable = false, unique = false, length = 18)
	private long id;
	@Column(nullable = false, unique = false, length = 8)
	private String effectiveTime;
	@Column(nullable = false, unique = false, length = 1)
	private int active;
	@Column(nullable = false, unique = false, length = 18)
	private long moduleId;
	@Column(nullable = false, unique = false, length = 18)
	private long sourceId;
	@Column(nullable = false, unique = false, length = 18)
	private long destinationId;
	@Column(nullable = false, unique = false, length = 1)
	private long relationshipGroup;
	@Column(nullable = false, unique = false, length = 18)
	private long typeId;
	@Column(nullable = false, unique = false, length = 18)
	private long characteristicTypeId;
	@Column(nullable = false, unique = false, length = 18)
	private long modifierId;
	public long getId() {
		return id;
	}
	public void setId(long id) {
		this.id = id;
	}
	public String getEffectiveTime() {
		return effectiveTime;
	}
	public void setEffectiveTime(String effectiveTime) {
		this.effectiveTime = effectiveTime;
	}
	public int getActive() {
		return active;
	}
	public void setActive(int active) {
		this.active = active;
	}
	public long getModuleId() {
		return moduleId;
	}
	public void setModuleId(long moduleId) {
		this.moduleId = moduleId;
	}
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
	public long getRelationshipGroup() {
		return relationshipGroup;
	}
	public void setRelationshipGroup(long relationshipGroup) {
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
		result = prime * result + active;
		result = prime * result
				+ (int) (characteristicTypeId ^ (characteristicTypeId >>> 32));
		result = prime * result
				+ (int) (destinationId ^ (destinationId >>> 32));
		result = prime * result
				+ ((effectiveTime == null) ? 0 : effectiveTime.hashCode());
		result = prime * result + (int) (id ^ (id >>> 32));
		result = prime * result + (int) (modifierId ^ (modifierId >>> 32));
		result = prime * result + (int) (moduleId ^ (moduleId >>> 32));
		result = prime * result
				+ (int) (relationshipGroup ^ (relationshipGroup >>> 32));
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
		Extension_Relationship other = (Extension_Relationship) obj;
		if (active != other.active)
			return false;
		if (characteristicTypeId != other.characteristicTypeId)
			return false;
		if (destinationId != other.destinationId)
			return false;
		if (effectiveTime == null) {
			if (other.effectiveTime != null)
				return false;
		} else if (!effectiveTime.equals(other.effectiveTime))
			return false;
		if (id != other.id)
			return false;
		if (modifierId != other.modifierId)
			return false;
		if (moduleId != other.moduleId)
			return false;
		if (relationshipGroup != other.relationshipGroup)
			return false;
		if (sourceId != other.sourceId)
			return false;
		if (typeId != other.typeId)
			return false;
		return true;
	}

}
