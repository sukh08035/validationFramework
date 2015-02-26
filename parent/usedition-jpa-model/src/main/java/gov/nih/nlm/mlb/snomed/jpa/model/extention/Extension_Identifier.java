package gov.nih.nlm.mlb.snomed.jpa.model.extention;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "extension_identifier")
public class Extension_Identifier {
	@Id	
	@Column(nullable = false, unique = false, length = 18)
	private long identifierSchemeId;
	@Column(nullable = false, unique = false, length = 255)
	private String alternateIdentifier;
	@Column(nullable = false, unique = false, length = 8)
	private String effectiveTime;
	@Column(nullable = false, unique = false, length = 1)
	private int active;
	@Column(nullable = false, unique = false, length = 18)
	private long moduleId;
	@Column(nullable = false, unique = false, length = 18)
	private long referencedComponentId;
	public long getIdentifierSchemeId() {
		return identifierSchemeId;
	}
	public void setIdentifierSchemeId(long identifierSchemeId) {
		this.identifierSchemeId = identifierSchemeId;
	}
	public String getAlternateIdentifier() {
		return alternateIdentifier;
	}
	public void setAlternateIdentifier(String alternateIdentifier) {
		this.alternateIdentifier = alternateIdentifier;
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
		result = prime * result + active;
		result = prime
				* result
				+ ((alternateIdentifier == null) ? 0 : alternateIdentifier
						.hashCode());
		result = prime * result
				+ ((effectiveTime == null) ? 0 : effectiveTime.hashCode());
		result = prime * result
				+ (int) (identifierSchemeId ^ (identifierSchemeId >>> 32));
		result = prime * result + (int) (moduleId ^ (moduleId >>> 32));
		result = prime
				* result
				+ (int) (referencedComponentId ^ (referencedComponentId >>> 32));
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
		Extension_Identifier other = (Extension_Identifier) obj;
		if (active != other.active)
			return false;
		if (alternateIdentifier == null) {
			if (other.alternateIdentifier != null)
				return false;
		} else if (!alternateIdentifier.equals(other.alternateIdentifier))
			return false;
		if (effectiveTime == null) {
			if (other.effectiveTime != null)
				return false;
		} else if (!effectiveTime.equals(other.effectiveTime))
			return false;
		if (identifierSchemeId != other.identifierSchemeId)
			return false;
		if (moduleId != other.moduleId)
			return false;
		if (referencedComponentId != other.referencedComponentId)
			return false;
		return true;
	}


}
