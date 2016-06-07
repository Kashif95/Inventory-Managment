package com.sellar.managment.medicine.util;

import java.util.HashMap;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Properties;

import org.springframework.beans.BeansException;
import org.springframework.beans.factory.config.ConfigurableListableBeanFactory;
import org.springframework.beans.factory.config.PropertyPlaceholderConfigurer;

public class ApplicationProperties extends PropertyPlaceholderConfigurer {

	/**
	 * Map to store the key value pair in property file.
	 */
	private static Map<String,String> map = new HashMap<String, String>();
	
	@Override
	protected void processProperties(
			ConfigurableListableBeanFactory beanFactoryToProcess,
			Properties props) throws BeansException {
		super.processProperties(beanFactoryToProcess, props);
		//Loading to map.
		for(Entry<Object, Object> entry:props.entrySet()){
			map.put(entry.getKey().toString(), entry.getValue().toString().trim());
		}
	}
	/**
	 * Method to get the value(path of the file) for the given key.
	 * @param key key value
	 * @return string value
	 */
	public static String getValueFrKey(String key) {
		return map.get(key);
	}
	
	/**
	 * @return the map
	 */
	public static Map<String, String> getMap() {
		return map;
	}

}
