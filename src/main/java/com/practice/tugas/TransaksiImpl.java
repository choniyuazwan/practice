package com.practice.tugas;

import java.util.ArrayList;
import java.util.List;

public class TransaksiImpl implements ITransaksi {
	private List<Transaksi> listTransaksi = new ArrayList<>();
	private List<Buku> listBuku = new ArrayList<>();
	
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
			ITransaksi transaksiService = new TransaksiImpl();
			Transaksi transaksi = new Transaksi();
			transaksi.setId(listBuku.get(i).id);
			transaksi.setJudul(listBuku.get(i).judul);
			transaksi.setJumlah(1);
			transaksi.setHarga(listBuku.get(i).harga);
			transaksiService.tambahData(transaksi);
		}
	}
}
