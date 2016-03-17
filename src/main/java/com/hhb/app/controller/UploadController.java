package com.hhb.app.controller;

import java.io.File;
import java.io.IOException;
import java.text.Format;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.servlet.ServletRequest;
import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;


@Controller
@RequestMapping(value="/uploadController")
public class UploadController {
	 
	
	
	/*** 
     * 上传文件 用@RequestParam注解来指定表单上的file为MultipartFile 
     * @param file 
     * @return 
     */
	@RequestMapping(value="fileUpload",method=RequestMethod.POST)
	public boolean fileUpload(@RequestParam ("file") MultipartFile file, HttpServletRequest request) throws IOException{
		// 判断文件是否为空 
		if (!file.isEmpty()) {
			//判断文件夹是否存在，不存在则创建
			String os = System.getProperties().getProperty("os.name");
			String pathcxh=null;
			if (os.startsWith("win") || os.startsWith("Win")) {
				 pathcxh = "D:/glusterfsConsume/";
			}else {
				 pathcxh ="/glusterfsConsume/";
			}
			Format format = new SimpleDateFormat("yyyy-MM-dd");
			String date = format.format(new Date());
			File filepath =new File(pathcxh+date);    
			//如果文件夹不存在则创建    
			if  (!filepath.exists()  && !filepath.isDirectory())      
			{       
				filepath.mkdir();
			} 
			//文件的扩展名
			String fileName = file.getOriginalFilename();
			String exd = fileName.substring(fileName.lastIndexOf(".")+1);
			String filePath=filepath+ "/"+"1111111"+"." + exd;
			// 转存文件  
			file.transferTo(new File(filePath));
			return true;
			
		}
		return false;
	}
	
	/*** 
     * 保存文件 
     * @param file 
     * @return 
     */  
    private boolean saveFile(MultipartFile file) {  
        // 判断文件是否为空  
        if (!file.isEmpty()) {
            try {  
                // 文件保存路径  
                String filePath ="F:/"+new Date().getTime()+ file.getOriginalFilename();  
                // 转存文件  
                file.transferTo(new File(filePath));  
                return true;  
            } catch (Exception e) {  
                e.printStackTrace();  
            }  
        }  
        return false;  
    }  
    /**
     * 多文件上传
     * @param files
     * @return
     */
    @RequestMapping("filesUpload")  
    public String filesUpload(@RequestParam("files") MultipartFile[] files) {  
        //判断file数组不能为空并且长度大于0  
        if(files!=null&&files.length>0){  
            //循环获取file数组中得文件  
            for(int i = 0;i<files.length;i++){  
                MultipartFile file = files[i];  
                //保存文件  
                saveFile(file);  
            }  
        }  
        // 重定向  
        return "redirect:/list.html";  
    }  

}
