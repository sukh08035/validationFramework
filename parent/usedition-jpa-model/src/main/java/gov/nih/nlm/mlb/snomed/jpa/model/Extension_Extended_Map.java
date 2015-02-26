package gov.nih.nlm.mlb.snomed.jpa.model;

import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.Table;
@Entity
@Table(name = "extension_extendedmap")
public class Extension_Extended_Map {

	@EmbeddedId
	private Component_Refset_Id Id;
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
	@Column(nullable = false, unique = false, length = 18)
	private long mapCategoryId;

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
	public long getMapCategoryId() {
		return mapCategoryId;
	}
	public void setMapCategoryId(long mapCategoryId) {
		this.mapCategoryId = mapCategoryId;
	}
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((Id == null) ? 0 : Id.hashCode());
		result = prime * result
				+ (int) (correlationId ^ (correlationId >>> 32));
		result = prime * result
				+ ((mapAdvice == null) ? 0 : mapAdvice.hashCode());
		result = prime * result
				+ (int) (mapCategoryId ^ (mapCategoryId >>> 32));
		result = prime * result + mapGroup;
		result = prime * result + mapPriority;
		result = prime * result + ((mapRule == null) ? 0 : mapRule.hashCode());
		result = prime * result
				+ ((mapTarget == null) ? 0 : mapTarget.hashCode());
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
		Extension_Extended_Map other = (Extension_Extended_Map) obj;
		if (Id == null) {
			if (other.Id != null)
				return false;
		} else if (!Id.equals(other.Id))
			return false;
		if (correlationId != other.correlationId)
			return false;
		if (mapAdvice == null) {
			if (other.mapAdvice != null)
				return false;
		} else if (!mapAdvice.equals(other.mapAdvice))
			return false;
		if (mapCategoryId != other.mapCategoryId)
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
		return true;
	}
	public void setId(Component_Refset_Id id) {
		Id = id;
	}
}
