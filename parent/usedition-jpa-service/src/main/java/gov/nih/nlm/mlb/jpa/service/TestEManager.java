package gov.nih.nlm.mlb.jpa.service;

import gov.nih.nlm.mlb.snomed.jpa.model.ExtensionConcept;

public class TestEManager extends InitEntityManager{

	public TestEManager() throws Exception {
		super();
	}

	public static void main(String[] args) throws Exception {
		TestEManager tm = new TestEManager();
	     
	  
		ExtensionConcept extConcept= new ExtensionConcept();
        extConcept.setActive("1");
       // extConcept.setId(id);
        extConcept.setDefinitionStatusId("23");
        extConcept.setEffectiveTime("20150213");
        extConcept.setModuleId("123145");
        extConcept.setUuid("354654321");
        tm.save(extConcept);
   
	}


}
