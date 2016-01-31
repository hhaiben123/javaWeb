package com.hhb.app.service;

import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.hhb.app.dao.BookMapper;
import com.hhb.app.entil.Book;




@Service
public class MybatisService {
	@Autowired
	private BookMapper bookMapper;
	
	public void insertTest(){
		Book book = new Book();
		book.setId("123");
		book.setBookname("童话故事");
		book.setBookuser("msr.gege");
		book.setPublish(new Date());
		bookMapper.insert(book);
	}
	@Transactional
	public void insertTest2(){
		Book book = new Book();
		book.setId("12345678");
		book.setBookname("童话故事");
		book.setBookuser("msr.gege");
		book.setPublish(new Date());
		bookMapper.insert(book);
		int a = 1 / 0;
		Book book2 = new Book();
		book2.setId("");
		book2.setBookname("童话故事");
		book2.setBookuser("msr.gege");
		book2.setPublish(new Date());
		bookMapper.insert(book2);
		
	}

}
