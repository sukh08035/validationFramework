package gov.nih.nlm.mlb.jpa.service.utility;

import java.util.ResourceBundle;


public class ConfigUtility {

	protected static ResourceBundle config;
	public synchronized static ResourceBundle getConfigProperties() throws Exception {
		if (config == null) {
			 config=ResourceBundle.getBundle("config");
		}
		return config;
	}

}
