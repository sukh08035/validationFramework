package gov.nih.nlm.mlb.snomed.jpa.model;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Embeddable;

@Embeddable
public class Component_Refset_Id implements Serializable {

	private static final long serialVersionUID = 1L;

	
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
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((active == null) ? 0 : active.hashCode());
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
		Component_Refset_Id other = (Component_Refset_Id) obj;
		if (active == null) {
			if (other.active != null)
				return false;
		} else if (!active.equals(other.active))
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
