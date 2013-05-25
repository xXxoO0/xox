package com.xox.common.utils;

import java.io.IOException;
import java.io.InputStream;
import java.util.HashMap;
import java.util.Map;
import java.util.Properties;

public class PropertiesUtil {
	private static final Map<String,String> commonMap = new HashMap<String, String>();
	static{
		Properties prop = new Properties();  
		try {
			InputStream is = PropertiesUtil.class.getResourceAsStream("/global.properties");
			prop.load(is);
			for(Object key:prop.keySet()){
				commonMap.put((String)key, (String)prop.get(key));
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	/**
	 * 获取自定义的Properties文件信息组织成map
	 * @return
	 */
	public static final Map<String,String> getCommonMap(){
		return commonMap;
	}
	/**
	 * 获取自定义的Properties文件中key对应的value
	 * @return
	 */
	public static final String getCommonValue(String key){
		return (commonMap.get(key)==null)?"":commonMap.get(key);
	}
}
