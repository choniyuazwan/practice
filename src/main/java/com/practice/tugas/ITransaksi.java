package com.practice.tugas;

import java.util.List;

public interface ITransaksi {
	void tambahData(Transaksi transaksi);
	List<Transaksi> getListTransaksi();
	void beliData(String id);
}
