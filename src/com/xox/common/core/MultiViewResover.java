package com.xox.common.core;

import java.util.Locale;
import java.util.Map;

import org.springframework.web.servlet.View;
import org.springframework.web.servlet.ViewResolver;
/**
 * 多视图返回 实现视图接口ViewResolver
 * @author zhuw
 * @version date 2013-5-18
 */
public final class MultiViewResover implements ViewResolver{
	
	private Map<String,ViewResolver> resolvers;  
	  
    public void setResolvers(Map<String, ViewResolver> resolvers) {  
        this.resolvers = resolvers;  
    }   
    
	@Override
	public View resolveViewName(String viewName, Locale locale)
			throws Exception {
		if(resolvers.containsKey(viewName)){
			
		}
		return null;
	}

}
