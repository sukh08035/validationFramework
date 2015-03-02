package gov.nih.nlm.mlb.snomedct.loaddata;



import gov.nih.nlm.mlb.snomedct.config.ConfigUtility;

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
		Properties config = ConfigUtility.getJpaPropterties();
		LoadDataFromRF2 load = new LoadDataFromRF2();
		Connection con = load.openConnection(config);
		load.importConceptFileData(con, "C:/Users/singhs12/Desktop/sct2_Concept_Snapshot_US1000124_20150301.txt", "extension_concept");
		load.close(con);
		
	}

}
