package gov.nih.nlm.mlb.snomed.jpa.model.extention;

import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Table(name = "extension_textdefinition")
public class Extension_Text_Definition {
	@EmbeddedId
	private Component_Id Id;
	@Column(nullable = false, unique = false, length = 18)
	private long conceptId;
	@Column(nullable = false, unique = false, length = 2)
	private String languageCode;
	@Column(nullable = false, unique = false, length = 18)
	private long typeId;
	@Column(nullable = false, unique = false, length = 1024)
	private String term;
	@Column(nullable = false, unique = false, length = 18)
	private long caseSignificanceId;
	
	public long getConceptId() {
		return conceptId;
	}
	public void setConceptId(long conceptId) {
		this.conceptId = conceptId;
	}
	public String getLanguageCode() {
		return languageCode;
	}
	public void setLanguageCode(String languageCode) {
		this.languageCode = languageCode;
	}
	public long getTypeId() {
		return typeId;
	}
	public void setTypeId(long typeId) {
		this.typeId = typeId;
	}
	public String getTerm() {
		return term;
	}
	public void setTerm(String term) {
		this.term = term;
	}
	public long getCaseSignificanceId() {
		return caseSignificanceId;
	}
	public void setCaseSignificanceId(long caseSignificanceId) {
		this.caseSignificanceId = caseSignificanceId;
	}
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((Id == null) ? 0 : Id.hashCode());
		result = prime * result
				+ (int) (caseSignificanceId ^ (caseSignificanceId >>> 32));
		result = prime * result + (int) (conceptId ^ (conceptId >>> 32));
		result = prime * result
				+ ((languageCode == null) ? 0 : languageCode.hashCode());
		result = prime * result + ((term == null) ? 0 : term.hashCode());
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
		Extension_Text_Definition other = (Extension_Text_Definition) obj;
		if (Id == null) {
			if (other.Id != null)
				return false;
		} else if (!Id.equals(other.Id))
			return false;
		if (caseSignificanceId != other.caseSignificanceId)
			return false;
		if (conceptId != other.conceptId)
			return false;
		if (languageCode == null) {
			if (other.languageCode != null)
				return false;
		} else if (!languageCode.equals(other.languageCode))
			return false;
		if (term == null) {
			if (other.term != null)
				return false;
		} else if (!term.equals(other.term))
			return false;
		if (typeId != other.typeId)
			return false;
		return true;
	}
	public void setId(Component_Id id) {
		Id = id;
	}
}
