package com.hhb.app.service;

import java.io.IOException;
import java.io.PrintWriter;
import java.text.DateFormat;
import java.util.Date;
import java.util.Locale;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.alibaba.fastjson.JSON;
import com.hhb.app.dao.UserDao;
import com.hhb.app.entil.User;

/**
 * Handles requests for the application home page.
 */
@Controller
public class HomeController {
	
	private static final Logger logger = LoggerFactory.getLogger(HomeController.class);
	@Autowired
	private UserDao useDto;
	/**
	 * Simply selects the home view to render by returning its name.
	 */
	@RequestMapping(value = "/", method = RequestMethod.GET)
	public String home(HttpServletRequest request,Locale locale, Model model) {
		logger.info("Welcome home! The client locale is {}.", locale);
		
		Date date = new Date();
		DateFormat dateFormat = DateFormat.getDateTimeInstance(DateFormat.LONG, DateFormat.LONG, locale);
		
		String formattedDate = dateFormat.format(date);
		
		model.addAttribute("serverTime", formattedDate );
		Cookie[] cookies = request.getCookies();
		for(Cookie cookie:cookies){
			System.out.println(cookie.getName()+":"+cookie.getValue());
		}
		return "home";
	}
	
	
	
	@RequestMapping(value = "cookieTest", method = RequestMethod.GET)
	public void cookieTest(HttpServletRequest request, HttpServletResponse response)  throws IOException{
		logger.info("Welcome home! The client locale is {}.", request);
		logger.info("Welcome home! The client locale is {}.", response);
		//获取Cookie
		Cookie[] cookies = request.getCookies();
		for(Cookie cookie:cookies){
			System.out.println(cookie.getName()+":"+cookie.getValue());
		}
		//创建Cookie
		Cookie cookie = new Cookie("hhb", "hhbCookies");
		response.addCookie(cookie);
		PrintWriter pw;

		pw = response.getWriter();
		pw.print("<html> <body> <h1> Hello,Cookie!</h1> </body> </html>");

	}
	
	
	@RequestMapping(value = "sessionTest", method = RequestMethod.GET)
	public void sessionTest(HttpServletRequest request, HttpServletResponse response) throws IOException{
		logger.info("Welcome home! The client locale is {}.", request);
		logger.info("Welcome home! The client locale is {}.", response);
//		//获取Cookie
//		Cookie[] cookies = request.getCookies();
//		for(Cookie cookie:cookies){
//			System.out.println("cookie:"+cookie.getName()+":"+cookie.getValue());
//		}

		
		HttpSession session = request.getSession();
		String sessionId = session.getId();
		session.setAttribute("hhbSeesion", "hhbSeesion_test");
		
		//创建Cookie
		Cookie cookie = new Cookie("H_H_b", "hhbSession");
		response.addCookie(cookie);
		
		PrintWriter pw;

		pw = response.getWriter();
		pw.print("<html> <body> <h1> Hello,Cookie!</h1> </body> </html>");
		
		// 如果HttpSeesion是新建的话
		if (session.isNew()) {
			pw.println("Hello,HttpSession! <br>The first response - SeesionId="
                    + sessionId + " <br>");
			pw.println("Hello,HttpSession! <br>The first response - SeesionId="
                    + session.getAttribute("hhbSeesion") + " <br>");
        } else {
        	pw.println("Hello,HttpSession! <br>The second response - SeesionId="
                    + sessionId + " <br>");
        	session.removeAttribute("hhbSeesion"); 
        	pw.println("Hello,HttpSession! <br>The first response - SeesionId="
                    + session.getAttribute("hhbSeesion") + " <br>");
        }
	}
	
	
	@RequestMapping(value = "redisTest", method = RequestMethod.GET)
	public void redisTest(HttpServletRequest request, HttpServletResponse response) throws IOException{
		User user = new User();
		user.setUserId("1111");
		user.setUserName("hhb");
		user.setUserAdd("福建市");
		useDto.saveUser(user);

		PrintWriter pw = response.getWriter();
		pw.print("<html> <body> <h1> Hello Cookies </h1> </body> </html>");
		System.out.println(JSON.toJSONString(useDto.read("1111")));

	}
}
