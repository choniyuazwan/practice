package com.practice.tugas;

public class Transaksi {
	private String id, judul;
	private int jumlah, harga;
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getJudul() {
		return judul;
	}
	public void setJudul(String judul) {
		this.judul = judul;
	}
	public int getJumlah() {
		return jumlah;
	}
	public void setJumlah(int stok) {
		this.jumlah = stok;
	}
	public int getHarga() {
		return harga;
	}
	public void setHarga(int harga) {
		this.harga = harga;
	}
}
