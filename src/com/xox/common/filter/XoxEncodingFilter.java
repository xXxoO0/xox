package com.xox.common.filter;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
/**
 * 拦截所有的请求 进行转码 统一改成UTF-8
 * @author zhuw
 * @version date 2013-5-19
 */
public class XoxEncodingFilter implements Filter{
	private String encoding;
	@Override
	public void destroy() {
		
	}

	@Override
	public void doFilter(ServletRequest request, ServletResponse response,
			FilterChain chain) throws IOException, ServletException {
		if(request.getCharacterEncoding()==null){
				request.setCharacterEncoding("UTF-8");
				response.setContentType("text/html; charset=UTF-8");  
		}else{
				request.setCharacterEncoding(getEncoding());
				response.setContentType("text/html; charset="+encoding);  
		}
		try{
				chain.doFilter(request, response);
		}catch (Exception e) {
				e.printStackTrace();
		}
	}

	@Override
	public void init(FilterConfig filterConfig) throws ServletException {
		setEncoding(filterConfig.getInitParameter("encoding"));
	}
	
	public String getEncoding() {
		return encoding;
	}

	public void setEncoding(String encoding) {
		this.encoding = encoding;
	}


}
