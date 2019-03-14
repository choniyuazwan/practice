package com.practice.tugas;

import com.pratice2.main.Mahasiswa2;

public class Main {

	public static void main(String[] args) {
		IBuku bukuService = new BukuImpl();
		
		Buku buku1 = new Buku();
		buku1.setId("b001");
		buku1.setNama("laskar pelangi");
		buku1.setPenulis("andrea hirata");
		buku1.setPenerbit("bintang pustaka");
		buku1.setHarga(60000);
		buku1.setStok(10);
		bukuService.tambahData(buku1);
		
		Buku buku2 = new Buku();
		buku2.setId("b002");
		buku2.setNama("matematika");
		buku2.setPenulis("budi hartono");
		buku2.setPenerbit("airlangga");
		buku2.setHarga(50000);
		buku2.setStok(10);
		bukuService.tambahData(buku2);
		
		Buku buku3 = new Buku();
		buku3.setId("b003");
		buku3.setNama("python");
		buku3.setPenulis("Guido van Rossum");
		buku3.setPenerbit("tidak tahu");
		buku3.setHarga(80000);
		buku3.setStok(10);
		bukuService.tambahData(buku3);
		
		// Print Header Table
		System.out.println("| " + padRight("Id", 3) + "| " + padRight("Judul", 8) + "| " + padRight("Penulis", 20) 
		+ "| " + padRight("Penerbit", 3) + "|" + padRight("Harga", 3) + "|" + padRight("Stok", 3) + "|");
		
		// Initiate Number of Row
		int i = 1;
		
		for (Buku buku : bukuService.getListBuku()) {

			// print data mahasiswa
			System.out.println("|" + padRight("" + i, 3) + "| " + padRight(buku.getId(), 8) + "| "
					+ padRight(buku.getNama(), 20) + "|" + padRight("" + buku.getPenulis(), 3) + "|" 
					+ padRight("" + buku.getPenerbit(), 3) + "|" + padRight("" + buku.getHarga(), 3) + "|"
					+ padRight("" + buku.getStok(), 3) + "|");

			// next row number
			i += 1;
		}
	}
	
	public static String padRight(String inputString, int length) {
		return String.format("%1$-" + length + "s", inputString);

	}

}
