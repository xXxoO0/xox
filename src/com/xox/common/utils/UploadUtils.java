package com.xox.common.utils;

import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.util.Iterator;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.apache.commons.io.FileUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.MultipartHttpServletRequest;

public class UploadUtils {
	private static final Logger log = LoggerFactory.getLogger(UploadUtils.class);
	/**
	 * 处理上传
	 * @param request
	 * @param maxSize
	 * @return
	 */
	public static final void doWithUploadFiles(HttpServletRequest request) throws UploadException{
		//确认是否是文件上传
		if (request instanceof MultipartHttpServletRequest) {
			 MultipartHttpServletRequest requestWrapper = (MultipartHttpServletRequest) request; 
			Iterator<String> e = requestWrapper.getFileNames();
			while(e.hasNext()){
				String fieldName = String.valueOf(e.next());
				log.info(fieldName);
				List<MultipartFile> files  = requestWrapper.getFiles(fieldName);
				for(MultipartFile file:files){
					log.info(file.getOriginalFilename());
					log.info(file.getContentType());
					try {
						saveFile(file.getInputStream(),request);
					} catch (IOException e1) {
						e1.printStackTrace();
					}
				}
			}
		}else{
			throw new UploadException(" 确认是否已加入\"enctype=\"multipart/form-data\"该属性.\n");
		}
	}
	
	public static final void saveFile(InputStream inputStream,HttpServletRequest request) throws IOException{
		String path = StoreUtils.getImageStorePath(request)+File.separator+GuidUtils.generateHex()+".jpg";
		log.info(path);
		FileUtils.copyInputStreamToFile(inputStream, new File(path));
    }          
	/**
	 * 自定义异常类 用于抛出上传异常
	 */
	public static final class UploadException extends Exception{
		private static final long serialVersionUID = 2519569675415407608L;
		
		private String error="";
		public UploadException(String error){
			this.error=error;
		}
		@Override
		public String getMessage() {
			return this.error;
		}
	}
}
