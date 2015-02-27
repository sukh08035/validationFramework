package gov.nih.nlm.mlb.snomedct.config;

import java.io.File;
import java.io.FileReader;
import java.util.Properties;
import java.util.ResourceBundle;

import org.apache.log4j.Logger;


public class ConfigUtility {

	protected static ResourceBundle config;
	protected static Properties configProp;
	public synchronized static ResourceBundle getConfigProperties() throws Exception {
		if (config == null) {
			 config=ResourceBundle.getBundle("config");
		}
		return config;
	}
	  
	public synchronized static Properties getJpaPropterties() throws Exception {
		    if (configProp == null) {
		      String configFileName = "src/main/resources/config.properties";
		      Logger.getLogger(ConfigUtility.class.getName()).info(
		          "  run.config = " + configFileName);
		      configProp = new Properties();
		      FileReader in = new FileReader(new File(configFileName));
		      configProp.load(in);
		      in.close();
		      Logger.getLogger(ConfigUtility.class).info("  properties = " + config);
		    }
		    return configProp;
		  }

}
