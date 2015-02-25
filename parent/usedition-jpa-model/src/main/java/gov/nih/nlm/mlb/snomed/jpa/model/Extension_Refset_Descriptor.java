package gov.nih.nlm.mlb.snomed.jpa.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "extension_refsetdescriptor")
public class Extension_Refset_Descriptor {
	
	@Id
	@Column(nullable = false, unique = false, length = 52)
	private String id;
	@Column(nullable = false, unique = false, length = 8)
	private String effectiveTime;
	@Column(nullable = false, unique = false, length = 1)
	private String active;
	@Column(nullable = false, unique = false, length = 18)
	private long moduleId;
	@Column(nullable = false, unique = false, length = 18)
	private long refsetId;
	@Column(nullable = false, unique = false, length = 18)
	private long referencedComponentId;
	@Column(nullable = false, unique = false, length = 18)
	private long attributeDescription;
	@Column(nullable = false, unique = false, length = 18)
	private long attributeType;
	@Column(nullable = false, unique = false, length = 18)
	private long attributeOrder;
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getEffectiveTime() {
		return effectiveTime;
	}
	public void setEffectiveTime(String effectiveTime) {
		this.effectiveTime = effectiveTime;
	}
	public String getActive() {
		return active;
	}
	public void setActive(String active) {
		this.active = active;
	}
	public long getModuleId() {
		return moduleId;
	}
	public void setModuleId(long moduleId) {
		this.moduleId = moduleId;
	}
	public long getRefsetId() {
		return refsetId;
	}
	public void setRefsetId(long refsetId) {
		this.refsetId = refsetId;
	}
	public long getReferencedComponentId() {
		return referencedComponentId;
	}
	public void setReferencedComponentId(long referencedComponentId) {
		this.referencedComponentId = referencedComponentId;
	}
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
		result = prime * result + ((active == null) ? 0 : active.hashCode());
		result = prime * result
				+ (int) (attributeDescription ^ (attributeDescription >>> 32));
		result = prime * result
				+ (int) (attributeOrder ^ (attributeOrder >>> 32));
		result = prime * result
				+ (int) (attributeType ^ (attributeType >>> 32));
		result = prime * result
				+ ((effectiveTime == null) ? 0 : effectiveTime.hashCode());
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		result = prime * result + (int) (moduleId ^ (moduleId >>> 32));
		result = prime
				* result
				+ (int) (referencedComponentId ^ (referencedComponentId >>> 32));
		result = prime * result + (int) (refsetId ^ (refsetId >>> 32));
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
		if (active == null) {
			if (other.active != null)
				return false;
		} else if (!active.equals(other.active))
			return false;
		if (attributeDescription != other.attributeDescription)
			return false;
		if (attributeOrder != other.attributeOrder)
			return false;
		if (attributeType != other.attributeType)
			return false;
		if (effectiveTime == null) {
			if (other.effectiveTime != null)
				return false;
		} else if (!effectiveTime.equals(other.effectiveTime))
			return false;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		if (moduleId != other.moduleId)
			return false;
		if (referencedComponentId != other.referencedComponentId)
			return false;
		if (refsetId != other.refsetId)
			return false;
		return true;
	}
	
}
