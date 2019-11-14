package co.Zee5.api.helper;

import java.io.FileInputStream;
import java.util.Properties;
import java.util.logging.Logger;

import co.Zee5.api.config.Constants;

/**
 * Gets the values from properties files
 */
public class PropertyReader implements Constants{
	private static String sourceClass = PropertyReader.class.getName();
	private static String sourceMethod;
	static Logger LOGGER = Logger.getLogger(sourceClass);

	/**
	 * Gets the values from properties files
	 * 
	 * @param path
	 * @param key
	 * @return propertyValue
	 */
	public static String getProperty(String path, String key) {
		sourceMethod = "getProperty";
		LOGGER.entering(sourceClass, sourceMethod);

		LOGGER.info("key " + key);
		String propertyValue = "";
		try {
			Properties p = new Properties();
			p.load(new FileInputStream(path));
			propertyValue = p.getProperty(key);

		} catch (Exception e) {
			e.printStackTrace();
		}
		LOGGER.info("propertyValue " + propertyValue);

		LOGGER.exiting(sourceClass, sourceMethod);
		return propertyValue;
	}
	
	/**
	 * getPropertyValue - Gets propertyValue for the given propertyPath and propertyKey 
	 * 
	 * @author Ooviya
	 * @param propertyKey
	 * @return propertyValue
	 */
	public static String getPropertyValue(String propertyPath, String propertyKey) {
		sourceMethod = "getPropertyValue";
		LOGGER.entering(sourceClass, sourceMethod);

		LOGGER.info("propertyKey " + propertyKey);

		String propertyValue = PropertyReader.getProperty(propertyPath,
				propertyKey + "_" + ENVIRONMENT);
		LOGGER.info("propertyValue " + propertyValue);

		LOGGER.exiting(sourceClass, sourceMethod);

		return propertyValue;
	}
}