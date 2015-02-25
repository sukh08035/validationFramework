package gov.nih.nlm.mlb.jpa.service;

import gov.nih.nlm.mlb.snomed.jpa.model.Extension_Concept;

public class Testing extends InitEntityManager{

	public Testing() throws Exception {
		super();
	}
	public static void main(String[] args) throws Exception {
		Testing tm = new Testing();
	     
	  
		Extension_Concept extConcept= new Extension_Concept();
        extConcept.setActive("1");
        extConcept.setId(123421);
        extConcept.setDefinitionStatusId(23);
        extConcept.setEffectiveTime("20150213");
        extConcept.setModuleId(123145);
        tm.save(extConcept);
        tm.closeEntityManager();
        tm.closeFactory();
   
	}
}
