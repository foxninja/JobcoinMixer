package com.gemini.jobcoin;

import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

public class JobcoinProperties {
	private static final String PROP_FILE_NAME = "config.properties";
	private final Properties properties;

	public JobcoinProperties() {
		this.properties = getProperties();
	}

	private Properties getProperties() {
		InputStream inputStream = null;
		Properties prop = new Properties();
		try {
			inputStream = getClass().getClassLoader().getResourceAsStream(PROP_FILE_NAME);

			if (inputStream != null) {
				prop.load(inputStream);
			} else {
				throw new IllegalStateException("property file '" + PROP_FILE_NAME + "' not found in the classpath");
			}
		} catch (Exception e) {
			System.out.println();
		} finally {
			if (inputStream != null) {
				try {
					inputStream.close();
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
		}

		return prop;
	}

	public String getProperty(String property) {
		return properties.getProperty(property);
	}
}
