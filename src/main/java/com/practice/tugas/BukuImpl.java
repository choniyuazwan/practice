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

}
