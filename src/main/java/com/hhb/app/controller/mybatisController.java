package com.hhb.app.controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.hhb.app.service.MybatisService;

@Controller
@RequestMapping(value = "/mybatisController")
public class mybatisController {
	
	@Autowired
	private MybatisService mybatisService;
	
	
	@RequestMapping(value="mybatisTest", method=RequestMethod.GET) 
	private void mybatisTest(HttpServletRequest request, HttpServletResponse response)
	throws IOException{
		mybatisService.insertTest();
		PrintWriter pw;
		pw = response.getWriter();
		pw.print("<html> <body> <h1> Hello,mybatis!</h1> </body> </html>");
		
	}
}
