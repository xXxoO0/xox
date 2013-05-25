package com.xox.common.utils;

import java.io.File;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.servlet.http.HttpServletRequest;

import org.apache.commons.lang.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;


public class StoreUtils {
	private static final Logger log = LoggerFactory.getLogger(StoreUtils.class);
	private static final String COMMON_VALUE_STORE="store";
	/**
	 * 得到存储相对根目录
	 * @return
	 */
	public static final String getStorePath() {
		String storePath = PropertiesUtil.getCommonValue(COMMON_VALUE_STORE);
		if(StringUtils.isBlank(storePath)){
			log.error("未配置store存储目录，请查看global.properties中store.path");
		}
		return storePath;
	}
	/**
	 * 得到绝对根目录
	 * @return
	 */
	public static String getStoreHome(HttpServletRequest request) {
		return request.getServletContext().getRealPath("/")+File.separator +getStorePath();
	}
	/**
	 * 获取图片的存储路径
	 * @param request
	 * @return
	 */
	public static String getImageStorePath(HttpServletRequest request) {
		SimpleDateFormat formart = new SimpleDateFormat("yyyyMMdd");
		String date = formart.format(new Date());
		return getStoreHome(request)+File.separator+date;
	}
	

}
