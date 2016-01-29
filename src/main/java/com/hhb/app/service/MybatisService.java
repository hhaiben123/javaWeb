package com.hhb.app.service;

import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

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

}
