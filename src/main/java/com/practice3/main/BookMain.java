package com.practice3.main;

import java.util.ArrayList;
import java.util.List;

public class BookMain {

	public static void main(String[] args) {
		IBook bookService = new BookImpl();
		
		Book book = new Book();
		book.setId("001");
		book.setJudul("Laskar Pelangi");
		book.setPenulis("Andrea Hirata");
		book.setPenerbit("Bintang Pusaka");
		book.setHarga(60000);
		book.setStok(10);
		bookService.addBook(book);
		
		for (Book item : bookService.getListBook()) {
			System.out.println(item.getId() +  " - " + item.getJudul() + " : " + item.getStok());
		}
		
		System.out.println("================");
		
		Book item  = bookService.getDetail("001");
		System.out.println(item.getId() +  " - " + item.getJudul());
		
		System.out.println("================");
		List<Transaksi> lstTrx = new ArrayList<>();
		
		Transaksi trx = new Transaksi();
		trx.setBook(item);
		trx.setQty(4);
		
		int totalHarga = item.getHarga()*trx.getQty();
		trx.setHarga(totalHarga);
		lstTrx.add(trx);		
		
		for (Transaksi transaksi : lstTrx) {
			bookService.updateStock(transaksi.getBook().getId(), transaksi.getQty());
			
			System.out.println(transaksi.getBook().getId() +  " - " 
						+ transaksi.getBook().getJudul() + " | "
						+ transaksi.getQty() + " | "
						+ transaksi.getHarga() + " | ");
		}
		
		System.out.println("================");
		for (Book item2 : bookService.getListBook()) {
			System.out.println(item2.getId() +  " - " + item2.getJudul() + " : " + item2.getStok());
		}
		
	}

}
