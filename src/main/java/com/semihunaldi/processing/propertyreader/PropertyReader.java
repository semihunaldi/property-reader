package com.semihunaldi.processing.propertyreader;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.Enumeration;
import java.util.HashMap;
import java.util.Map;
import java.util.Properties;

/**
 * Created by semihunaldi on 9.04.2019
 */
public class PropertyReader {

	private String propertyFileBaseLocation = "";

	private String propertyFileName = "config.properties";

	public PropertyReader() {
	}

	public PropertyReader(String propertyFileBaseLocation) {
		this.propertyFileBaseLocation = propertyFileBaseLocation;
	}

	public PropertyReader(String propertyFileBaseLocation, String propertyFileName) {
		this.propertyFileBaseLocation = propertyFileBaseLocation;
		this.propertyFileName = propertyFileName;
	}

	public Map<String, Property> read() {
		Properties prop = new Properties();
		InputStream input = null;
		Map<String, Property> propertyMap = new HashMap<>();
		try{
			input = new FileInputStream(adjustBasePath() + propertyFileName);
			prop.load(input);
			Enumeration<?> enumeration = prop.propertyNames();
			while(enumeration.hasMoreElements()){
				Object o = enumeration.nextElement();
				propertyMap.put((String) o, new Property(prop.get(o)));
			}
			return propertyMap;
		} catch(IOException ex){
			ex.printStackTrace();
		} finally{
			if(input != null){
				try{
					input.close();
				} catch(IOException e){
					e.printStackTrace();
				}
			}
		}
		return propertyMap;
	}

	private String adjustBasePath() {
		if(propertyFileBaseLocation != null && !propertyFileBaseLocation.isEmpty()){
			if(!propertyFileBaseLocation.endsWith("/")){
				return propertyFileBaseLocation.concat("/");
			}
			return propertyFileBaseLocation;
		}
		return "";
	}
}
