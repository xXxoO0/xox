package com.xox.test.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.xox.test.service.TestService;
/**
 * 总结 返回的结果 hello 就是web-inf/jsp下的文件 根据名字查找所以jsp命名是不要重复
 * 
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
	
	
}
