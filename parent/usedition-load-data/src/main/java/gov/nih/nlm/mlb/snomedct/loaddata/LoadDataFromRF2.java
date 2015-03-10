package gov.nih.nlm.mlb.snomedct.loaddata;



import gov.nih.nlm.mlb.snomedct.config.ConfigUtility;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Properties;

import org.apache.log4j.Logger;

import com.mysql.jdbc.Connection;
import com.mysql.jdbc.Statement;

public class LoadDataFromRF2 {

	Logger logger = Logger.getLogger(this.getClass()+" Setting Logger ofr LoadDataFromRF2");

	public Connection openConnection(final Properties props)
	{
		Connection conn = null;
		{
			try{
				logger.info("Opening Connection to upload release data");
				conn = (Connection) DriverManager.getConnection(props.getProperty("javax.persistence.jdbc.url"), props.getProperty("javax.persistence.jdbc.user")
						, props.getProperty("javax.persistence.jdbc.password"));
			}catch(SQLException sqlE)
			{
				logger.error(sqlE.getMessage());
				sqlE.printStackTrace();
			}
		}
		return conn;
	}
	public void close(Connection conn){
		if(conn !=null){
			try{
				conn.close();
			}catch(SQLException sqlE)
			{
				logger.error(sqlE.getMessage());
				sqlE.printStackTrace();
			}
		}
	}
	public void importConceptFileData(Connection conn, String filename, String tableName)
	{
		Statement stmt;
		String query;
		logger.debug("Passed File Name parameter: " + filename);
		try{
			stmt =  (Statement) conn.createStatement(ResultSet.TYPE_SCROLL_SENSITIVE, ResultSet.CONCUR_UPDATABLE);
			query = "LOAD DATA LOCAL INFILE '" + filename + "' INTO TABLE "+ tableName +
					" LINES TERMINATED BY '\r\n' IGNORE 1 LINES " +
					"(@id,@effectiveTime,@active,@moduleId,@definitionStatusId) " +
					"SET id = @id, effectiveTime = @effectiveTime, active = @active, moduleId = @moduleId, definitionStatusId = @definitionStatusId;";
			logger.debug("Running query: " + query);
			int inserted = stmt.executeUpdate(query);
			logger.info( inserted + " records effected in "+ tableName);
		}catch(Exception e)
		{
			logger.error(e.getMessage());
			e.printStackTrace();
			stmt=null;
		}
	}

	public void importDescriptionFileData(Connection conn, String filename, String tableName)
	{
		Statement stmt;
		String query;
		logger.debug("Passed File Name parameter: " + filename);
		try{
			stmt =  (Statement) conn.createStatement(ResultSet.TYPE_SCROLL_SENSITIVE, ResultSet.CONCUR_UPDATABLE);
			query = "LOAD DATA LOCAL INFILE '" + filename + "' INTO TABLE "+ tableName +
					" LINES TERMINATED BY '\r\n' IGNORE 1 LINES " +
					"(@id,@effectiveTime,@active,@moduleId,@conceptId,@languageCode,@typeId,@term,@caseSignificanceId) " +
					"SET id = @id, effectiveTime = @effectiveTime, active = @active, moduleId = @moduleId, conceptId = @conceptId, "
					+ "languageCode = @languageCode, typeId = @typeId, term = @term, caseSignificanceId=@caseSignificanceId;";
			logger.debug("Running query: " + query);
			int inserted = stmt.executeUpdate(query);
			logger.info( inserted + " records effected in "+ tableName);
		}catch(Exception e)
		{
			logger.error(e.getMessage());
			e.printStackTrace();
			stmt=null;
		}
	}

	public void importIdentifierFileData(Connection conn, String filename, String tableName)
	{
		Statement stmt;
		String query;
		logger.debug("Passed File Name parameter: " + filename);
		try{
			stmt =  (Statement) conn.createStatement(ResultSet.TYPE_SCROLL_SENSITIVE, ResultSet.CONCUR_UPDATABLE);
			query = "LOAD DATA LOCAL INFILE '" + filename + "' INTO TABLE "+ tableName +
					" LINES TERMINATED BY '\r\n' IGNORE 1 LINES " +
					"(@identifierSchemeId,@alternateIdentifier,@effectiveTime,@active,@moduleId,@referencedComponentId) " +
					"SET identifierSchemeId = @identifierSchemeId, alternateIdentifier = @alternateIdentifier, effectiveTime = @effectiveTime, "
					+ "active = @active, moduleId = @moduleId, referencedComponentId = @referencedComponentId;";
			logger.debug("Running query: " + query);
			int inserted = stmt.executeUpdate(query);
			logger.info( inserted + " records effected in "+ tableName);
		}catch(Exception e)
		{
			logger.error(e.getMessage());
			e.printStackTrace();
			stmt=null;
		}
	}

	public void importRelationshipFileData(Connection conn, String filename, String tableName)
	{
		Statement stmt;
		String query;
		logger.debug("Passed File Name parameter: " + filename);
		try{
			stmt =  (Statement) conn.createStatement(ResultSet.TYPE_SCROLL_SENSITIVE, ResultSet.CONCUR_UPDATABLE);
			query = "LOAD DATA LOCAL INFILE '" + filename + "' INTO TABLE "+ tableName +
					" LINES TERMINATED BY '\r\n' IGNORE 1 LINES " +
					"(@id,@effectiveTime,@active,@moduleId,@sourceId,@destinationId,@relationshipGroup,@typeId,@characteristicTypeId,@modifierId) " +
					"SET id = @id, effectiveTime = @effectiveTime, active = @active, moduleId = @moduleId, sourceId = @sourceId, destinationId = @destinationId, "
					+ "relationshipGroup = @relationshipGroup, typeId = @typeId, characteristicTypeId = @characteristicTypeId, modifierId = @modifierId;";
			logger.debug("Running query: " + query);
			int inserted = stmt.executeUpdate(query);
			logger.info( inserted + " records effected in "+ tableName);
		}catch(Exception e)
		{
			logger.error(e.getMessage());
			e.printStackTrace();
			stmt=null;
		}
	}

	public void importStatedRelationshipFileData(Connection conn, String filename, String tableName)
	{
		Statement stmt;
		String query;
		logger.debug("Passed File Name parameter: " + filename);
		try{
			stmt =  (Statement) conn.createStatement(ResultSet.TYPE_SCROLL_SENSITIVE, ResultSet.CONCUR_UPDATABLE);
			query = "LOAD DATA LOCAL INFILE '" + filename + "' INTO TABLE "+ tableName +
					" LINES TERMINATED BY '\r\n' IGNORE 1 LINES " +
					"(@id,@effectiveTime,@active,@moduleId,@sourceId,@destinationId,@relationshipGroup,@typeId,@characteristicTypeId,@modifierId) " +
					"SET id = @id, effectiveTime = @effectiveTime, active = @active, moduleId = @moduleId, sourceId = @sourceId, destinationId = @destinationId,"
					+ " relationshipGroup = @relationshipGroup, typeId = @typeId, characteristicTypeId = @characteristicTypeId,modifierId = @modifierId;";
			logger.debug("Running query: " + query);
			int inserted = stmt.executeUpdate(query);
			logger.info( inserted + " records effected in "+ tableName);
		}catch(Exception e)
		{
			logger.error(e.getMessage());
			e.printStackTrace();
			stmt=null;
		}
	}

	public void importTextdefinitionFileData(Connection conn, String filename, String tableName)
	{
		Statement stmt;
		String query;
		logger.debug("Passed File Name parameter: " + filename);
		try{
			stmt =  (Statement) conn.createStatement(ResultSet.TYPE_SCROLL_SENSITIVE, ResultSet.CONCUR_UPDATABLE);
			query = "LOAD DATA LOCAL INFILE '" + filename + "' INTO TABLE "+ tableName +
					" LINES TERMINATED BY '\r\n' IGNORE 1 LINES " +
					"(@id,@effectiveTime,@active,@moduleId,@conceptId,@languageCode,@typeId,@term,@caseSignificanceId) " +
					"SET id = @id, effectiveTime = @effectiveTime, active = @active, moduleId = @moduleId, conceptId = @conceptId, languageCode = @languageCode, typeId = @typeId,term = @term, caseSignificanceId = @caseSignificanceId;";
			logger.debug("Running query: " + query);
			int inserted = stmt.executeUpdate(query);
			logger.info( inserted + " records effected in "+ tableName);
		}catch(Exception e)
		{
			logger.error(e.getMessage());
			e.printStackTrace();
			stmt=null;
		}
	}

	public void importAssociationReferenceFileData(Connection conn, String filename, String tableName)
	{
		Statement stmt;
		String query;
		logger.debug("Passed File Name parameter: " + filename);
		try{
			stmt =  (Statement) conn.createStatement(ResultSet.TYPE_SCROLL_SENSITIVE, ResultSet.CONCUR_UPDATABLE);
			query = "LOAD DATA LOCAL INFILE '" + filename + "' INTO TABLE "+ tableName +
					" LINES TERMINATED BY '\r\n' IGNORE 1 LINES " +
					"(@id,@effectiveTime,@active,@moduleId,@refsetId,@referencedComponentId,@targetComponent) " +
					"SET id = @id, effectiveTime = @effectiveTime, active = @active, moduleId = @moduleId, refsetId = @refsetId, referencedComponentId = @referencedComponentId, targetComponent = @targetComponent;";
			logger.debug("Running query: " + query);
			int inserted = stmt.executeUpdate(query);
			logger.info( inserted + " records effected in "+ tableName);
		}catch(Exception e)
		{
			logger.error(e.getMessage());
			e.printStackTrace();
			stmt=null;
		}
	}

	public void importAttributeValueFileData(Connection conn, String filename, String tableName)
	{
		Statement stmt;
		String query;
		logger.debug("Passed File Name parameter: " + filename);
		try{
			stmt =  (Statement) conn.createStatement(ResultSet.TYPE_SCROLL_SENSITIVE, ResultSet.CONCUR_UPDATABLE);
			query = "LOAD DATA LOCAL INFILE '" + filename + "' INTO TABLE "+ tableName +
					" LINES TERMINATED BY '\r\n' IGNORE 1 LINES " +
					"(@id,@effectiveTime,@active,@moduleId,@refsetId,@referencedComponentId,@valueId) " +
					"SET id = @id, effectiveTime = @effectiveTime, active = @active, moduleId = @moduleId, refsetId = @refsetId, referencedComponentId = @referencedComponentId, valueId = @valueId;";
			logger.debug("Running query: " + query);
			int inserted = stmt.executeUpdate(query);
			logger.info( inserted + " records effected in "+ tableName);
		}catch(Exception e)
		{
			logger.error(e.getMessage());
			e.printStackTrace();
			stmt=null;
		}
	}

	public void importSimpleFileData(Connection conn, String filename, String tableName)
	{
		Statement stmt;
		String query;
		logger.debug("Passed File Name parameter: " + filename);
		try{
			stmt =  (Statement) conn.createStatement(ResultSet.TYPE_SCROLL_SENSITIVE, ResultSet.CONCUR_UPDATABLE);
			query = "LOAD DATA LOCAL INFILE '" + filename + "' INTO TABLE "+ tableName +
					" LINES TERMINATED BY '\r\n' IGNORE 1 LINES " +
					"(@id,@effectiveTime,@active,@moduleId,@refsetId,@referencedComponentId) " +
					"SET id = @id, effectiveTime = @effectiveTime, active = @active, moduleId = @moduleId, refsetId = @refsetId, referencedComponentId = @referencedComponentId;";
			logger.debug("Running query: " + query);
			int inserted = stmt.executeUpdate(query);
			logger.info( inserted + " records effected in "+ tableName);
		}catch(Exception e)
		{
			logger.error(e.getMessage());
			e.printStackTrace();
			stmt=null;
		}
	}

	public void importComplexMapFileData(Connection conn, String filename, String tableName)
	{
		Statement stmt;
		String query;
		logger.debug("Passed File Name parameter: " + filename);
		try{
			stmt =  (Statement) conn.createStatement(ResultSet.TYPE_SCROLL_SENSITIVE, ResultSet.CONCUR_UPDATABLE);
			query = "LOAD DATA LOCAL INFILE '" + filename + "' INTO TABLE "+ tableName +
					" LINES TERMINATED BY '\r\n' IGNORE 1 LINES " +
					"(@id,@effectiveTime,@active,@moduleId,@refsetId,@referencedComponentId,@mapGroup,@mapPriority,@mapRule,@mapAdvice,@mapTarget,@correlationId) " +
					"SET id = @id, effectiveTime = @effectiveTime, active = @active, moduleId = @moduleId, refsetId = @refsetId, referencedComponentId = @referencedComponentId, "
					+ "mapGroup = @mapGroup, mapPriority = @mapPriority, mapRule = @mapRule, mapAdvice = @mapAdvice, mapTarget = @mapTarget, correlationId = @correlationId;";
			logger.debug("Running query: " + query);
			int inserted = stmt.executeUpdate(query);
			logger.info( inserted + " records effected in "+ tableName);
		}catch(Exception e)
		{
			logger.error(e.getMessage());
			e.printStackTrace();
			stmt=null;
		}
	}

	public void importExtendedMapFileData(Connection conn, String filename, String tableName)
	{
		Statement stmt;
		String query;
		logger.debug("Passed File Name parameter: " + filename);
		try{
			stmt =  (Statement) conn.createStatement(ResultSet.TYPE_SCROLL_SENSITIVE, ResultSet.CONCUR_UPDATABLE);
			query = "LOAD DATA LOCAL INFILE '" + filename + "' INTO TABLE "+ tableName +
					" LINES TERMINATED BY '\r\n' IGNORE 1 LINES " +
					"(@id,@effectiveTime,@active,@moduleId,@refsetId,@referencedComponentId,@mapGroup,@mapPriority,@mapRule,@mapAdvice,@mapTarget,@correlationId,@mapCategoryId) " +
					"SET id = @id, effectiveTime = @effectiveTime, active = @active, moduleId = @moduleId, refsetId = @refsetId, referencedComponentId = @referencedComponentId,"
					+ " mapGroup = @mapGroup, mapPriority = @mapPriority, mapRule = @mapRule, mapAdvice = @mapAdvice, mapTarget = @mapTarget, correlationId = @correlationId, mapCategoryId = @mapCategoryId;";
			logger.debug("Running query: " + query);
			int inserted = stmt.executeUpdate(query);
			logger.info( inserted + " records effected in "+ tableName);
		}catch(Exception e)
		{
			logger.error(e.getMessage());
			e.printStackTrace();
			stmt=null;
		}
	}

	public void importSimpleMapFileData(Connection conn, String filename, String tableName)
	{
		Statement stmt;
		String query;
		logger.debug("Passed File Name parameter: " + filename);
		try{
			stmt =  (Statement) conn.createStatement(ResultSet.TYPE_SCROLL_SENSITIVE, ResultSet.CONCUR_UPDATABLE);
			query = "LOAD DATA LOCAL INFILE '" + filename + "' INTO TABLE "+ tableName +
					" LINES TERMINATED BY '\r\n' IGNORE 1 LINES " +
					"(@id,@effectiveTime,@active,@moduleId,@refsetId,@referencedComponentId,@mapTarget) " +
					"SET id = @id, effectiveTime = @effectiveTime, active = @active, moduleId = @moduleId, refsetId = @refsetId, referencedComponentId = @referencedComponentId, mapTarget = @mapTarget;";
			logger.debug("Running query: " + query);
			int inserted = stmt.executeUpdate(query);
			logger.info( inserted + " records effected in "+ tableName);
		}catch(Exception e)
		{
			logger.error(e.getMessage());
			e.printStackTrace();
			stmt=null;
		}
	}

	public void importLanguageFileData(Connection conn, String filename, String tableName)
	{
		Statement stmt;
		String query;
		logger.debug("Passed File Name parameter: " + filename);
		try{
			stmt =  (Statement) conn.createStatement(ResultSet.TYPE_SCROLL_SENSITIVE, ResultSet.CONCUR_UPDATABLE);
			query = "LOAD DATA LOCAL INFILE '" + filename + "' INTO TABLE "+ tableName +
					" LINES TERMINATED BY '\r\n' IGNORE 1 LINES " +
					"(@id,@effectiveTime,@active,@moduleId,@refsetId,@referencedComponentId,@acceptabilityId) " +
					"SET id = @id, effectiveTime = @effectiveTime, active = @active, moduleId = @moduleId, refsetId = @refsetId, referencedComponentId = @referencedComponentId, acceptabilityId = @acceptabilityId;";
			logger.debug("Running query: " + query);
			int inserted = stmt.executeUpdate(query);
			logger.info( inserted + " records effected in "+ tableName);
		}catch(Exception e)
		{
			logger.error(e.getMessage());
			e.printStackTrace();
			stmt=null;
		}
	}

	public void importRefsetDescriptorFileData(Connection conn, String filename, String tableName)
	{
		Statement stmt;
		String query;
		logger.debug("Passed File Name parameter: " + filename);
		try{
			stmt =  (Statement) conn.createStatement(ResultSet.TYPE_SCROLL_SENSITIVE, ResultSet.CONCUR_UPDATABLE);
			query = "LOAD DATA LOCAL INFILE '" + filename + "' INTO TABLE "+ tableName +
					" LINES TERMINATED BY '\r\n' IGNORE 1 LINES " +
					"(@id,@effectiveTime,@active,@moduleId,@refsetId,@referencedComponentId,@attributeDescription,@attributeType,@attributeOrder) " +
					"SET id = @id, effectiveTime = @effectiveTime, active = @active, moduleId = @moduleId, refsetId = @refsetId, referencedComponentId = @referencedComponentId, "
					+ "attributeDescription = @attributeDescription, attributeType = @attributeType, attributeOrder = @attributeOrder;";
			logger.debug("Running query: " + query);
			int inserted = stmt.executeUpdate(query);
			logger.info( inserted + " records effected in "+ tableName);
		}catch(Exception e)
		{
			logger.error(e.getMessage());
			e.printStackTrace();
			stmt=null;
		}
	}

	public void importDescriptionTypeFileData(Connection conn, String filename, String tableName)
	{
		Statement stmt;
		String query;
		logger.debug("Passed File Name parameter: " + filename);
		try{
			stmt =  (Statement) conn.createStatement(ResultSet.TYPE_SCROLL_SENSITIVE, ResultSet.CONCUR_UPDATABLE);
			query = "LOAD DATA LOCAL INFILE '" + filename + "' INTO TABLE "+ tableName +
					" LINES TERMINATED BY '\r\n' IGNORE 1 LINES " +
					"(@id,@effectiveTime,@active,@moduleId,@refsetId,@referencedComponentId,@descriptionFormat,@descriptionLength) " +
					"SET id = @id, effectiveTime = @effectiveTime, active = @active, moduleId = @moduleId, refsetId = @refsetId, "
					+ "referencedComponentId = @referencedComponentId, descriptionFormat = @descriptionFormat, descriptionLength = @descriptionLength;";
			logger.debug("Running query: " + query);
			int inserted = stmt.executeUpdate(query);
			logger.info( inserted + " records effected in "+ tableName);
		}catch(Exception e)
		{
			logger.error(e.getMessage());
			e.printStackTrace();
			stmt=null;
		}
	}

	public void importModuleDependencyFileData(Connection conn, String filename, String tableName)
	{
		Statement stmt;
		String query;
		logger.debug("Passed File Name parameter: " + filename);
		try{
			stmt =  (Statement) conn.createStatement(ResultSet.TYPE_SCROLL_SENSITIVE, ResultSet.CONCUR_UPDATABLE);
			query = "LOAD DATA LOCAL INFILE '" + filename + "' INTO TABLE "+ tableName +
					" LINES TERMINATED BY '\r\n' IGNORE 1 LINES " +
					"(@id,@effectiveTime,@active,@moduleId,@refsetId,@referencedComponentId,@sourceEffectiveTime,@targetEffectiveTime) " +
					"SET id = @id, effectiveTime = @effectiveTime, active = @active, moduleId = @moduleId, refsetId = @refsetId, "
					+ "referencedComponentId = @referencedComponentId, sourceEffectiveTime = @sourceEffectiveTime, targetEffectiveTime = @targetEffectiveTime; ";
			logger.debug("Running query: " + query);
			int inserted = stmt.executeUpdate(query);
			logger.info( inserted + " records effected in "+ tableName);
		}catch(Exception e)
		{
			logger.error(e.getMessage());
			e.printStackTrace();
			stmt=null;
		}
	}


	public static void main(String[] args) throws Exception
	{
		File deltaDir = new File("C:/data/delta");
		File editionDir = new File("C:/data/edition");
		String filePath ="C://data//delta//";
		String editionPath = "C://data//edition//";
		File coreDir = new File("C:/data/core");
		String coreFilePath ="C://data//core//";
		if (!deltaDir.exists()) {
		      System.out.println("Specified input dir");
		    }
		String conceptReader, descriptionReader, textDefinitionReader, relationshipReader
		,languageReader, identifierReader, statedRelationshipReader, associatinRefReader, attributeValueReader, simpleReader, 
		extenderMapReader, complexMapReader, simpleMapReader, refDescriptorReader, descriptionTypeReader, moduleDependencyReader;
		
		Properties config = ConfigUtility.getJpaPropterties();
		LoadDataFromRF2 load = new LoadDataFromRF2();
		Connection conn = load.openConnection(config);		
		for(File f:deltaDir.listFiles())
		{
			if (f.getName().contains("_Concept_Delta_")) {
				conceptReader = filePath+f.getName();
				load.importConceptFileData(conn, conceptReader, "extension_delta_concept");	
				System.out.println("loading Concept File Delta");
			}
			else if (f.getName().contains("_Relationship_Delta_")) {
				relationshipReader = filePath+f.getName();
				load.importRelationshipFileData(conn, relationshipReader, "extension_delta_relationship");
				System.out.println("loading Relationship File Delta");
			}
			else if (f.getName().contains("_Description_")) {
				descriptionReader = filePath+f.getName();
				load.importDescriptionFileData(conn, descriptionReader, "extension_delta_description");
				System.out.println("loading Description File Delta");
			}
			else if (f.getName().contains("_TextDefinition_")) {
				textDefinitionReader = filePath+f.getName();
				load.importTextdefinitionFileData(conn, textDefinitionReader, "extension_delta_textdefinition");
				System.out.println("loading Text Definition File Delta");
			}
			else if (f.getName().contains("_Identifier_Delta_")) {
				identifierReader = filePath+f.getName(); 
				load.importIdentifierFileData(conn, identifierReader, "extension_delta_identifier");
				System.out.println("loading Identifier File Delta");
			}
			else if (f.getName().contains("_StatedRelationship_Delta")) {
				statedRelationshipReader = filePath+f.getName();
				load.importStatedRelationshipFileData(conn, statedRelationshipReader, "extension_delta_statedrelationship ");
				System.out.println("loading Stated Relationship File Delta");
			}
			else if (f.getName().contains("_AssociationReferenceDelta_")) {
				associatinRefReader = filePath+f.getName();
				load.importAssociationReferenceFileData(conn, associatinRefReader, "extension__delta_associationreference");
				System.out.println("loading Association Reference File Delta");
			}
			else if (f.getName().contains("_AttributeValueDelta_")) {
				attributeValueReader = filePath+f.getName();
				load.importAttributeValueFileData(conn, attributeValueReader, "extension_delta_attributevalue ");
				System.out.println("loading Attribure Value File Delta");
			}
			else if (f.getName().contains("_SimpleDelta_")) {
				simpleReader = filePath+f.getName();
				load.importSimpleFileData(conn, simpleReader, "extension_delta_simple ");
				System.out.println("loading Simple File Delta");
			}
			else if (f.getName().contains("_LanguageDelta-en")) {
				languageReader = filePath+f.getName();
				load.importLanguageFileData(conn, languageReader, "extension_delta_language");
				System.out.println("loading Language File Delta");
			}
			else if (f.getName().contains("_ExtendedMapDelta_")) {
				extenderMapReader = filePath+f.getName();
				load.importExtendedMapFileData(conn, extenderMapReader, "extension_delta_extendedmap");
				System.out.println("loading Extended Map File Delta");
			}
			else if (f.getName().contains("_ComplexMapDelta_")) {
				complexMapReader = filePath+f.getName();
				load.importComplexMapFileData(conn, complexMapReader, "extension_delta_complexmap");
				System.out.println("loading Complex Map File Delta");
			}
			else if (f.getName().contains("_SimpleMapDelta_")) {
				simpleMapReader = filePath+f.getName();
				load.importSimpleMapFileData(conn, simpleMapReader, "extension_delta_simplemap");
				System.out.println("loading Simple Map File Delta");
			}
			else if (f.getName().contains("_RefsetDescriptorDelta")) {
				refDescriptorReader = filePath+f.getName();
				load.importRefsetDescriptorFileData(conn, refDescriptorReader, "extension_delta_refsetdescriptor ");
				System.out.println("loading Refset Descriptor File Delta");
			}
			else if (f.getName().contains("_DescriptionTypeDelta_")) {
				descriptionTypeReader = filePath+f.getName();
				load.importDescriptionTypeFileData(conn, descriptionTypeReader, "extension_delta_descriptiontype");
				System.out.println("loading Description Type File Delta");
			}		
			else if (f.getName().contains("_ModuleDependencyDelta")) {
				moduleDependencyReader = filePath+f.getName();
				load.importModuleDependencyFileData(conn, moduleDependencyReader, "extension_delta_moduledependency");
				System.out.println("loading Module Dependency File Delta");
			}
		}
		
		//uploading Full Files to the Database:
		
		for(File f:editionDir.listFiles())
		{
			if (f.getName().contains("_Concept_Full_")) {
				conceptReader = editionPath+f.getName();
				load.importConceptFileData(conn, conceptReader, "extension_concept");	
				System.out.println("loading Concept File Edition");
			}
			else if (f.getName().contains("_Relationship_Full_")) {
				relationshipReader = editionPath+f.getName();
				load.importRelationshipFileData(conn, relationshipReader, "extension_relationship");
				System.out.println("loading Relationship File Edition");
			}
			else if (f.getName().contains("_Description_")) {
				descriptionReader = editionPath+f.getName();
				load.importDescriptionFileData(conn, descriptionReader, "extension_description");
				System.out.println("loading Description File Edition");
			}
			else if (f.getName().contains("_TextDefinition_")) {
				textDefinitionReader = editionPath+f.getName();
				load.importTextdefinitionFileData(conn, textDefinitionReader, "extension_textdefinition");
				System.out.println("loading Text Definition File Edition");
			}
			else if (f.getName().contains("_Identifier_Full_")) {
				identifierReader = editionPath+f.getName(); 
				load.importIdentifierFileData(conn, identifierReader, "extension_identifier");
				System.out.println("loading Identifier File Edition");
			}
			else if (f.getName().contains("_StatedRelationship_Full")) {
				statedRelationshipReader = editionPath+f.getName();
				load.importStatedRelationshipFileData(conn, statedRelationshipReader, "extension_statedrelationship ");
				System.out.println("loading Stated Relationship File Edition");
			}
			else if (f.getName().contains("_AssociationReferenceFull_")) {
				associatinRefReader = editionPath+f.getName();
				load.importAssociationReferenceFileData(conn, associatinRefReader, "extension_associationreference");
				System.out.println("loading Association Reference File Edition");
			}
			else if (f.getName().contains("_AttributeValueFull_")) {
				attributeValueReader = editionPath+f.getName();
				load.importAttributeValueFileData(conn, attributeValueReader, "extension_attributevalue ");
				System.out.println("loading Attribure Value File Edition");
			}
			else if (f.getName().contains("_SimpleFull_")) {
				simpleReader = editionPath+f.getName();
				load.importSimpleFileData(conn, simpleReader, "extension_simple ");
				System.out.println("loading Simple File Edition");
			}
			else if (f.getName().contains("_LanguageFull-en")) {
				languageReader = editionPath+f.getName();
				load.importLanguageFileData(conn, languageReader, "extension_language");
				System.out.println("loading Language File Edition");
			}
			else if (f.getName().contains("_ExtendedMapFull_")) {
				extenderMapReader = editionPath+f.getName();
				load.importExtendedMapFileData(conn, extenderMapReader, "extension_extendedmap");
				System.out.println("loading Extended Map File Edition");
			}
			else if (f.getName().contains("_ComplexMapFull_")) {
				complexMapReader = editionPath+f.getName();
				load.importComplexMapFileData(conn, complexMapReader, "extension_complexmap");
				System.out.println("loading Complex Map File Edition");
			}
			else if (f.getName().contains("_SimpleMapFull_")) {
				simpleMapReader = editionPath+f.getName();
				load.importSimpleMapFileData(conn, simpleMapReader, "extension_simplemap");
				System.out.println("loading Simple Map File Edition");
			}
			else if (f.getName().contains("_RefsetDescriptorFull")) {
				refDescriptorReader = editionPath+f.getName();
				load.importRefsetDescriptorFileData(conn, refDescriptorReader, "extension_refsetdescriptor ");
				System.out.println("loading Refset Descriptor File Edition");
			}
			else if (f.getName().contains("_DescriptionTypeFull_")) {
				descriptionTypeReader = editionPath+f.getName();
				load.importDescriptionTypeFileData(conn, descriptionTypeReader, "extension_descriptiontype");
				System.out.println("loading Description Type File Edition");
			}		
			else if (f.getName().contains("_ModuleDependencyFull")) {
				moduleDependencyReader = editionPath+f.getName();
				load.importModuleDependencyFileData(conn, moduleDependencyReader, "extension_moduledependency");
				System.out.println("loading Module Dependency File Edition");
			}
		}
		//uploading Core Files:
		for(File f:coreDir.listFiles())
		{
			if (f.getName().contains("_Concept_Full_")) {
				conceptReader = coreFilePath+f.getName();
				load.importConceptFileData(conn, conceptReader, "core_concept");	
				System.out.println("loading Concept File Core");
			}
			else if (f.getName().contains("_Relationship_Full_")) {
				relationshipReader = coreFilePath+f.getName();
				load.importRelationshipFileData(conn, relationshipReader, "core_relationship");
				System.out.println("loading Relationship File Core");
			}
			else if (f.getName().contains("_Description_")) {
				descriptionReader = coreFilePath+f.getName();
				load.importDescriptionFileData(conn, descriptionReader, "core_description");
				System.out.println("loading Description File Core");
			}
			else if (f.getName().contains("_TextDefinition_")) {
				textDefinitionReader = coreFilePath+f.getName();
				load.importTextdefinitionFileData(conn, textDefinitionReader, "core_textdefinition");
				System.out.println("loading Text Definition File Core");
			}
			else if (f.getName().contains("_Identifier_Full_")) {
				identifierReader = coreFilePath+f.getName(); 
				load.importIdentifierFileData(conn, identifierReader, "core_identifier");
				System.out.println("loading Identifier File Core");
			}
			else if (f.getName().contains("_StatedRelationship_Full")) {
				statedRelationshipReader = coreFilePath+f.getName();
				load.importStatedRelationshipFileData(conn, statedRelationshipReader, "core_statedrelationship ");
				System.out.println("loading Stated Relationship File Core");
			}
			else if (f.getName().contains("_AssociationReferenceFull_")) {
				associatinRefReader = coreFilePath+f.getName();
				load.importAssociationReferenceFileData(conn, associatinRefReader, "core_associationreference");
				System.out.println("loading Association Reference File Core");
			}
			else if (f.getName().contains("_AttributeValueFull_")) {
				attributeValueReader = coreFilePath+f.getName();
				load.importAttributeValueFileData(conn, attributeValueReader, "core_attributevalue ");
				System.out.println("loading Attribure Value File Core");
			}
			else if (f.getName().contains("_SimpleFull_")) {
				simpleReader = coreFilePath+f.getName();
				load.importSimpleFileData(conn, simpleReader, "core_simple ");
				System.out.println("loading Simple File Core");
			}
			else if (f.getName().contains("_LanguageFull-en")) {
				languageReader = coreFilePath+f.getName();
				load.importLanguageFileData(conn, languageReader, "core_language");
				System.out.println("loading Language File Core");
			}
			else if (f.getName().contains("_ExtendedMapFull_")) {
				extenderMapReader = coreFilePath+f.getName();
				load.importExtendedMapFileData(conn, extenderMapReader, "core_extendedmap");
				System.out.println("loading Extended Map File Core");
			}
			else if (f.getName().contains("_ComplexMapFull_")) {
				complexMapReader = coreFilePath+f.getName();
				load.importComplexMapFileData(conn, complexMapReader, "core_complexmap");
				System.out.println("loading Complex Map File Core");
			}
			else if (f.getName().contains("_SimpleMapFull_")) {
				simpleMapReader = coreFilePath+f.getName();
				load.importSimpleMapFileData(conn, simpleMapReader, "core_simplemap");
				System.out.println("loading Simple Map File Core");
			}
			else if (f.getName().contains("_RefsetDescriptorFull")) {
				refDescriptorReader = coreFilePath+f.getName();
				load.importRefsetDescriptorFileData(conn, refDescriptorReader, "core_refsetdescriptor ");
				System.out.println("loading Refset Descriptor File Core");
			}
			else if (f.getName().contains("_DescriptionTypeFull_")) {
				descriptionTypeReader = coreFilePath+f.getName();
				load.importDescriptionTypeFileData(conn, descriptionTypeReader, "core_descriptiontype");
				System.out.println("loading Description Type File Core");
			}		
			else if (f.getName().contains("_ModuleDependencyFull")) {
				moduleDependencyReader = coreFilePath+f.getName();
				load.importModuleDependencyFileData(conn, moduleDependencyReader, "core_moduledependency");
				System.out.println("loading Module Dependency File Core");
			}
		}
		
		load.close(conn);

	}

}
