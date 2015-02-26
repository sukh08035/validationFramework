package gov.nih.nlm.mlb.snomed.jpa.model.core;

import gov.nih.nlm.mlb.snomed.jpa.model.Component_Refset_Id;

import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Table(name = "core_moduledependency")
public class Core_Module_Dependency {
	@EmbeddedId
	private Component_Refset_Id Id;
	@Column(nullable = false, unique = false, length = 8)
	private String sourceEffectiveTime;
	@Column(nullable = false, unique = false, length = 8)
	private String targetEffectiveTime;
	

	public String getSourceEffectiveTime() {
		return sourceEffectiveTime;
	}
	public void setSourceEffectiveTime(String sourceEffectiveTime) {
		this.sourceEffectiveTime = sourceEffectiveTime;
	}
	public String getTargetEffectiveTime() {
		return targetEffectiveTime;
	}
	public void setTargetEffectiveTime(String targetEffectiveTime) {
		this.targetEffectiveTime = targetEffectiveTime;
	}
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((Id == null) ? 0 : Id.hashCode());
		result = prime
				* result
				+ ((sourceEffectiveTime == null) ? 0 : sourceEffectiveTime
						.hashCode());
		result = prime
				* result
				+ ((targetEffectiveTime == null) ? 0 : targetEffectiveTime
						.hashCode());
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
		Core_Module_Dependency other = (Core_Module_Dependency) obj;
		if (Id == null) {
			if (other.Id != null)
				return false;
		} else if (!Id.equals(other.Id))
			return false;
		if (sourceEffectiveTime == null) {
			if (other.sourceEffectiveTime != null)
				return false;
		} else if (!sourceEffectiveTime.equals(other.sourceEffectiveTime))
			return false;
		if (targetEffectiveTime == null) {
			if (other.targetEffectiveTime != null)
				return false;
		} else if (!targetEffectiveTime.equals(other.targetEffectiveTime))
			return false;
		return true;
	}
	public void setId(Component_Refset_Id id) {
		Id = id;
	}
}
