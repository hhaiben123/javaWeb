package com.hhb.app.controller;

import java.io.File;
import java.io.IOException;
import java.util.Date;



import org.springframework.stereotype.Controller;
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
	public boolean fileUpload(@RequestParam ("file") MultipartFile file ) throws IOException{
		 // 判断文件是否为空 
		if (!file.isEmpty()) {
			// 文件保存路径 
			String filePath="F:/"+new Date().getTime()+ file.getOriginalFilename();
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
