package com.hhb.app.service;

import java.util.Date;
import java.util.List;

import org.apache.ibatis.session.RowBounds;
import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.github.pagehelper.Page;
import com.github.pagehelper.PageInfo;
import com.hhb.app.dao.BookMapper;
import com.hhb.app.dto.BookCount;
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
	
	public List<Book> mybatisHelper(){
		 String bookName = "童话故事";
		 //RowBounds分页
		 List<Book> books = bookMapper.selectByBookName(bookName,new RowBounds(2, 3));
		 //获取总数
		 PageInfo<Book> page = new PageInfo<Book>(books);
		 Long sum = page.getTotal();
		return books;
	}
	
	public BookCount mybatisHelper2(){
		
		 String bookName = "童话故事";
		 BookCount bookCount = bookMapper.selectCount(bookName,new RowBounds(1, 0));

		 return bookCount;
	}
	

}
