package com.practice3.main;

import java.util.List;

public interface IBook {
	List<Book> getListBook();
	void addBook(Book book);
	Book getDetail(String id);
	void updateStock(String id, int qty);
}
