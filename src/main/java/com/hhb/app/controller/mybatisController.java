package com.hhb.app.controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.alibaba.fastjson.JSON;
import com.hhb.app.dto.BookCount;
import com.hhb.app.entil.Book;
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
	
	@RequestMapping(value="mybatisTest1", method=RequestMethod.GET) 
	private void mybatisTest1(HttpServletRequest request, HttpServletResponse response)
	throws IOException{
		mybatisService.insertTest2();
		PrintWriter pw;
		pw = response.getWriter();
		pw.print("<html> <body> <h1> Hello,mybatis!</h1> </body> </html>");
		
	}
	
	
	@RequestMapping(value="mybatisHelper", method=RequestMethod.GET) 
	private void mybatisHelper(HttpServletRequest request, HttpServletResponse response)
	throws IOException{
		List<Book> books = mybatisService.mybatisHelper();
		String book = JSON.toJSONString(books);
		PrintWriter pw;
		pw = response.getWriter();
		pw.print("<html> <body> <h1> Hello,mybatisHelper!</h1> </body> </html>");
		pw.print(book);
		
	}
	
	
	@RequestMapping(value="mybatisHelper2", method=RequestMethod.GET) 
	private void mybatisHelper2(HttpServletRequest request, HttpServletResponse response)
	throws IOException{
		BookCount books = mybatisService.mybatisHelper2();
		String book = JSON.toJSONString(books);
		PrintWriter pw;
		pw = response.getWriter();
		pw.print("<html> <body> <h1> Hello,mybatisHelper!</h1> </body> </html>");
		pw.print(book);
		
	}
}
