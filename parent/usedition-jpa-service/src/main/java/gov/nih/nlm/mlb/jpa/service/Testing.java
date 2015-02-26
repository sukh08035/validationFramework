package gov.nih.nlm.mlb.jpa.service;

import gov.nih.nlm.mlb.snomed.jpa.model.Component_Id;
import gov.nih.nlm.mlb.snomed.jpa.model.Extension_Concept;

public class Testing extends InitEntityManager{

	public Testing() throws Exception {
		super();
	}
	public static void main(String[] args) throws Exception {
		Testing tm = new Testing();
	     
	  
		Extension_Concept extConcept= new Extension_Concept();
		Component_Id id = new Component_Id();
		id.setActive("1");
		id.setId(123421);
		
		id.setEffectiveTime("20150213");
		id.setModuleId(123145);
		extConcept.setId(id);
		extConcept.setDefinitionStatusId(23);
        tm.save(extConcept);
        tm.closeEntityManager();
        tm.closeFactory();
   
	}
}
