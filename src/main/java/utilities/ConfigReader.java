package utilities;

import java.io.FileInputStream;
import java.util.Properties;

public class ConfigReader {
	
	private static Properties properties;
	
	static {
		try (FileInputStream input = new FileInputStream(System.getProperty("user.dir") + "/src/main/resources/config.properties")) {
			properties = new Properties();
			properties.load(input);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	public static String getProperty (String key) {
		String value = System.getProperty(key);
		return (value != null) ? value : properties.getProperty(key);
	}

}
