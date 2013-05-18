package com.xox.common.intercept;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;
/**
 * mvc拦截器 实现HandlerInterceptor接口或者继承HandlerInterceptorAdapter都可以 
 * 在实现接口时，即使不需要，也必须实现所有的方法。更好的方法是扩展拦截器适配器类。
 * 这个类默认实现所有的拦截器方法，你可以只覆盖你需要的方法。
 * 需要在spring-mvc.xml里配置
 * @author zhuw
 */
public class TestInterceptor extends HandlerInterceptorAdapter{
	/**
	 * 请求完成之后触发
	 */
	@Override
	public void afterCompletion(HttpServletRequest request,
			HttpServletResponse response, Object handler, Exception ex)
			throws Exception {
		long endTime = System.currentTimeMillis();  
		System.out.println("完成了"+endTime);
	}
	/**
	 * 生成视图之前触发
	 */
	@Override
	public void postHandle(HttpServletRequest request, HttpServletResponse response,
			Object handler, ModelAndView view) throws Exception {
		System.out.println("要到页面了");
	}
	/**
	 * 处理请求之前触发  
	 */
	@Override
	public boolean preHandle(HttpServletRequest request, HttpServletResponse response,
			Object handler) throws Exception {
		long startTime = System.currentTimeMillis();  
		System.out.println("触发之前"+startTime);

		/**
		 * 这里如果返回false 就不会再下去了 true才会往下走
		 */
		return true;
	}

}
