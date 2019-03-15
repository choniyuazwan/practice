package com.practice.tugas;

import java.util.ArrayList;
import java.util.List;

public class TransaksiImpl implements ITransaksi {
	private List<Transaksi> listTransaksi = new ArrayList<>();
//	IBuku bukuService = new BukuImpl();
	
	@Override
	public void tambahData(Transaksi transaksi) {
		listTransaksi.add(transaksi);
	}

	@Override
	public List<Transaksi> getListTransaksi() {
		return listTransaksi;
	}

	@Override
	public void beliData(String id) {
//		int i = 0;
//		boolean found = false;
//		for (Buku buku : bukuService.getListBuku()) {			
//			if (buku.getId() == id) {
//				found = true;
//				break;
//			}	
//			i += 1;
//		}
//		
//		if (found){
//			System.out.println("\nkoding transaksi benar");
//		} else {
//			System.out.println("\nkoding transaksi masih salah");
//		}
	}
}
