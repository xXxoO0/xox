package com.xox.test.controller;

import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.xox.test.entity.User;
import com.xox.test.service.TestService;
/**
 * 总结 返回的结果 hello 就是web-inf/jsp下的文件 根据名字查找所以jsp命名是不要重复
 * 或者同个文件夹下不能有重复的
 * 参考地址
 * http://static.springsource.org/spring/docs/3.2.x/spring-framework-reference/html/mvc.html
 *
 */
@Controller
public class TestController {
	/**
	 * 注解注入service
	 */
	@Autowired
	public TestService testService;
	//************jsp视图
	@RequestMapping("/test/jsp/helloWorld")
    public ModelAndView  jsphelloWorld(HttpServletRequest request,HttpServletResponse response,  
            ModelMap modelMap){
		modelMap.addAttribute("message", testService.getRandom()+"jsp");
        return new ModelAndView("hello",modelMap); 
    }
	
	@RequestMapping("/test/jsp/helloWorld/test")
	public String jsptest(Model model){
		model.addAttribute("message", "jsp测试!");
	    return "hello";
	}
	/** 非常灵活的 url路径上
	@RequestMapping(value="/owners/{ownerId}/pets/{petId}", method=RequestMethod.GET)
	public String findPet(@PathVariable String ownerId, @PathVariable String petId, Model model) {
	  Owner owner = ownerService.findOwner(ownerId);
	  Pet pet = owner.getPet(petId);
	  model.addAttribute("pet", pet);
	  return "displayPet";
	}
	@Controller
	@RequestMapping("/owners/{ownerId}")
	public class RelativePathUriTemplateController {

  		@RequestMapping(value = "/pets/{petId}", method = RequestMethod.GET, params="myParam=myValue")
  		public void findPet(@PathVariable String ownerId, @PathVariable String petId, Model model) {
    	// implementation omitted
  		}
}
	*/
	//**********freemarker视图
	@RequestMapping("/test/ftl/helloWorld")
    public String ftlhelloWorld(Model model){
        model.addAttribute("message", testService.getRandom()+"ftl");
        return "hello.ftl";
    }
	
	@RequestMapping("/test/ftl/helloWorld/test")
	public String ftltest(Model model){
		model.addAttribute("message", "ftl测试!");
	    return "hello.ftl";
	}
	/**
	 * 访问返回错误例子
	 */
	@RequestMapping("/test/error")
	public String getException(Model model) throws Exception {
		throw new Exception("asd");
	}
	@RequestMapping("/test/ajax")
	public String toAjaxTest(){
		return "/test/ajaxtest";
	}
	
	
	/**
	 * ajax测试
	 */
	
	/**
	 * 普通返回string get方式
	 * @return
	 */
	@RequestMapping(value = "/test/ajax/test1",method = RequestMethod.GET)  
	@ResponseBody
	public String ajaxtest1(){
		return "zw你好";
	}
	/**
	 * 普通返回string post方式
	 * @return
	 */
	@RequestMapping(value = "/test/ajax/test2",method = RequestMethod.POST)  
	@ResponseBody
	public String ajaxtest2(HttpServletRequest request){
		String name = (String)request.getParameter("name");
		return name+"你好";
	}
	/**
	 * 表单方式提交
	 * @param request
	 * @return   User是提交表的javabean 
	 * @ModelAttribute("User") User 大小写都没关系
	 */
	@RequestMapping(value = "/test/ajax/test3",method = RequestMethod.POST)  
	@ResponseBody
	public String ajaxtest3(@ModelAttribute("User") User user){
		System.out.println(user.getUserName());
		System.out.println(user.getPassword());
		return "提交成功";
	}
}
