package com.practice3.main;

import java.util.ArrayList;
import java.util.List;

public class BookImpl implements IBook{

	List<Book> lstBook = new ArrayList<>();
	
	@Override
	public List<Book> getListBook() {
		return lstBook;
	}

	@Override
	public void addBook(Book book) {
		lstBook.add(book);		
	}

	@Override
	public Book getDetail(String id) {
		Book result = null;
		for (Book book : lstBook) {
			if (book.getId() == id){
				result = book;
			}
		}
		
		return result;
	}

	@Override
	public void updateStock(String id, int qty) {
		for (Book book : lstBook) {
			if (book.getId() == id){
				int oldStock = book.getStok();
				int newStock = oldStock - qty;
				book.setStok(newStock);
			}
		}		
	}

}
