package com.xox.common.utils;

import java.io.IOException;
import java.io.Writer;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletResponse;

import net.sf.json.JSONArray;
import net.sf.json.JSONException;
import net.sf.json.JSONObject;

import com.xox.test.entity.User;

/**
 * json处理工具类
 * @author zhuw
 * @version date 2013-5-23
 */
public final class JosnUtil {
	/**
	 * 将java对象(String等)转化成JSONObject 向客户端输出
	 * @param obj
	 * @param response
	 */
	public static void writeObj(Object obj,HttpServletResponse response){
		try {
			Writer wirter;
			wirter = response.getWriter();
			JSONObject josn = JSONObject.fromObject(obj);
			josn.write(wirter);
		} catch (IOException e) {
			e.printStackTrace();
		} catch (JSONException e) {
			e.printStackTrace();
		}
	}
	/**
	 * 将传过来的json请求转化成对应的beanclass的javabean对象
	 * @param josnstr
	 * @param beanclass
	 * @return
	 */
	public static Object jsonToObj(String josnstr,Class<?> beanclass){
		JSONObject obj = JSONObject.fromObject(josnstr);
		return JSONObject.toBean(obj, beanclass);
	}
	/**
	 * 将collection对象转化成jsonarray对象 向客户端输出
	 * @param obj
	 * @param response
	 */
	public static void writeCollection(Object obj,HttpServletResponse response){
		try {
			Writer wirter;
			wirter = response.getWriter();
			JSONArray array = JSONArray.fromObject(obj);
			array.write(wirter);
		} catch (IOException e) {
			e.printStackTrace();
		} catch (JSONException e) {
			e.printStackTrace();
		}
	}
	/**
	 * 将客户端传过来的jsonArray转化成list
	 * @param jsonstr jsonArray对象
	 * @param T javabean对象
	 * @return
	 */
	@SuppressWarnings("unchecked")
	public static <T> List<T> jsonToArray(JSONArray jsonstr,Class<?> T){
		return (List<T>) JSONArray.toCollection(jsonstr, T);
	}
	
	public static void main(String[] args) {
		Map<String,User> uMap = new HashMap<String,User>();
		uMap.put("zw", new User("zw","pwd"));
		uMap.put("zw1", new User("zw1","pwd1"));
		List<User> list = jsonToArray(JSONArray.fromObject("[{\"userName\":\"zw\"},{\"userName\":\"zw1\"}]"),User.class);
		for(User u:list){
			System.out.println(u.getUserName());
		}
	}
	
}