package gov.nih.nlm.mlb.snomed.jpa.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
@Entity
@Table(name = "extension_complexmap")
public class Extension_Complex_Map {

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
	@Column(nullable = false, unique = false, length = 1)
	private int mapGroup;
	@Column(nullable = false, unique = false, length = 1)
	private int mapPriority;
	@Column(nullable = false, unique = false, length = 4000)
	private String mapRule;
	@Column(nullable = false, unique = false, length = 4000)
	private String mapAdvice;
	@Column(nullable = false, unique = false, length = 100)
	private String mapTarget;
	@Column(nullable = false, unique = false, length = 18)
	private long correlationId;
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
	public int getMapGroup() {
		return mapGroup;
	}
	public void setMapGroup(int mapGroup) {
		this.mapGroup = mapGroup;
	}
	public int getMapPriority() {
		return mapPriority;
	}
	public void setMapPriority(int mapPriority) {
		this.mapPriority = mapPriority;
	}
	public String getMapRule() {
		return mapRule;
	}
	public void setMapRule(String mapRule) {
		this.mapRule = mapRule;
	}
	public String getMapAdvice() {
		return mapAdvice;
	}
	public void setMapAdvice(String mapAdvice) {
		this.mapAdvice = mapAdvice;
	}
	public String getMapTarget() {
		return mapTarget;
	}
	public void setMapTarget(String mapTarget) {
		this.mapTarget = mapTarget;
	}
	public long getCorrelationId() {
		return correlationId;
	}
	public void setCorrelationId(long correlationId) {
		this.correlationId = correlationId;
	}
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((active == null) ? 0 : active.hashCode());
		result = prime * result
				+ (int) (correlationId ^ (correlationId >>> 32));
		result = prime * result
				+ ((effectiveTime == null) ? 0 : effectiveTime.hashCode());
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		result = prime * result
				+ ((mapAdvice == null) ? 0 : mapAdvice.hashCode());
		result = prime * result + mapGroup;
		result = prime * result + mapPriority;
		result = prime * result + ((mapRule == null) ? 0 : mapRule.hashCode());
		result = prime * result
				+ ((mapTarget == null) ? 0 : mapTarget.hashCode());
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
		Extension_Complex_Map other = (Extension_Complex_Map) obj;
		if (active == null) {
			if (other.active != null)
				return false;
		} else if (!active.equals(other.active))
			return false;
		if (correlationId != other.correlationId)
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
		if (mapAdvice == null) {
			if (other.mapAdvice != null)
				return false;
		} else if (!mapAdvice.equals(other.mapAdvice))
			return false;
		if (mapGroup != other.mapGroup)
			return false;
		if (mapPriority != other.mapPriority)
			return false;
		if (mapRule == null) {
			if (other.mapRule != null)
				return false;
		} else if (!mapRule.equals(other.mapRule))
			return false;
		if (mapTarget == null) {
			if (other.mapTarget != null)
				return false;
		} else if (!mapTarget.equals(other.mapTarget))
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
