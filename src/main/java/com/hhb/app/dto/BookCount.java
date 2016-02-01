package com.hhb.app.dto;

import java.util.List;

import com.hhb.app.entil.Book;

public class BookCount {
	private List<Book> books;
	private int sum;
	public List<Book> getBooks() {
		return books;
	}
	public void setBooks(List<Book> books) {
		this.books = books;
	}
	public int getSum() {
		return sum;
	}
	public void setSum(int sum) {
		this.sum = sum;
	}

	

}
