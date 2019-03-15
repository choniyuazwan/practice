package com.practice.tugas;

import java.util.ArrayList;
import java.util.List;

public class BukuImpl implements IBuku {

	private List<Buku> listBuku = new ArrayList<>();
	
	@Override
	public void tambahData(Buku buku) {
		listBuku.add(buku);		
	}

	@Override
	public List<Buku> getListBuku() {
		return listBuku;
	}

	@Override
	public void detailData(String id) {
		int i = 0;
		boolean found = false;
		for (Buku buku : listBuku) {			
			if (buku.getId() == id) {
				found = true;
				break;
			}	
			i += 1;
		}
		
		if (found){
			System.out.println("\nDetail Buku");
			System.out.println("| " + padRight("Id", 15) + ": " + padRight(listBuku.get(i).id, 15) + "|");
			System.out.println("| " + padRight("Judul", 15) + ": " + padRight(listBuku.get(i).judul, 15) + "|");
			System.out.println("| " + padRight("Penulis", 15) + ": " + padRight(listBuku.get(i).penulis, 15) + "|");
			System.out.println("| " + padRight("Penerbit", 15) + ": " + padRight(listBuku.get(i).penerbit, 15) + "|");
			System.out.println("| " + padRight("Harga", 15) + ": " + padRight(""+listBuku.get(i).harga, 15) + "|");
			System.out.println("| " + padRight("Stok", 15) + ": " + padRight(""+listBuku.get(i).stok, 15) + "|");
		}		
	}
	
	public static String padRight(String inputString, int length) {
		return String.format("%1$-" + length + "s", inputString);

	}

}
