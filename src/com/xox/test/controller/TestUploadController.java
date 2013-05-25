package com.xox.test.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.xox.common.utils.UploadUtils;
import com.xox.common.utils.UploadUtils.UploadException;
/**
 * 上传测试
 * @author zhuw
 * @version date 2013-05-25
 */
@Controller
public class TestUploadController {
	@RequestMapping("/test/toupload")
	public String touploadTest(){
		return "upload.ftl";
	}
	@RequestMapping("/test/upload")
	public void uploadTest(HttpServletRequest request,HttpServletResponse response){
		try {
			UploadUtils.doWithUploadFiles(request);
		} catch (UploadException e) {
			e.printStackTrace();
		}
	}
}
