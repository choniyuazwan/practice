package com.practice.tugas;

public class Main {

	public static void main(String[] args) {
//		deklarasi class implement
		IBuku bukuService = new BukuImpl();
		ITransaksi transaksiService = new TransaksiImpl();
		
//		tambah data buku pertama
		Buku buku1 = new Buku();
		buku1.setId("b001");
		buku1.setJudul("laskar pelangi");
		buku1.setPenulis("andrea hirata");
		buku1.setPenerbit("bintang pustaka");
		buku1.setHarga(60000);
		buku1.setStok(10);
		bukuService.tambahData(buku1);

//		tambah data buku kedua
		Buku buku2 = new Buku();
		buku2.setId("b002");
		buku2.setJudul("matematika");
		buku2.setPenulis("budi hartono");
		buku2.setPenerbit("airlangga");
		buku2.setHarga(50000);
		buku2.setStok(10);
		bukuService.tambahData(buku2);
		
//		tambah data buku ketiga
		Buku buku3 = new Buku();
		buku3.setId("b003");
		buku3.setJudul("python");
		buku3.setPenulis("Guido van Rossum");
		buku3.setPenerbit("tidak tahu");
		buku3.setHarga(80000);
		buku3.setStok(10);
		bukuService.tambahData(buku3);
		
		
		
		System.out.println("Data Buku yang Awal");
		// Print Header Table
		System.out.println("| " + padRight("No", 5) + "| " + padRight("Id", 8) + "| " + padRight("Judul", 20) + "|" + padRight("Penulis", 20) 
		+ "|" + padRight("Penerbit", 20) + "|" + padRight("Harga", 10) + "|" + padRight("Stok", 5) + "|");
		
		// Initiate Number of Row
		int i = 1;

//		print data buku
		for (Buku buku : bukuService.getListBuku()) {
			System.out.println("| " + padRight("" + i, 5) + "| " + padRight(buku.getId(), 8) + "| "
					+ padRight(buku.getJudul(), 20) + "|" + padRight("" + buku.getPenulis(), 20) + "|" 
					+ padRight("" + buku.getPenerbit(), 20) + "|" + padRight("" + buku.getHarga(), 10) + "|"
					+ padRight("" + buku.getStok(), 5) + "|");

			// next row number
			i += 1;
		}
		
		
		
		
//		lihat detail data buku
		bukuService.detailData("b002");

		
		
		
//		menambah data transaksi	dan update stok
		String[][] barang = {{"b003","3"},{"b001","4"}};
		
		int stokBaru=0;
		for(int x=0; x<barang.length; x++) {
			i = 0;
			boolean found = false;
			for (Buku buku : bukuService.getListBuku()) {			
				if (buku.getId() == barang[x][0]) {
					found = true;
					break;
				}	
				i += 1;
			}		
			if (found){
				Transaksi transaksi = new Transaksi();
				transaksi.setId(bukuService.getListBuku().get(i).getId());
				transaksi.setJudul(bukuService.getListBuku().get(i).getJudul());
				transaksi.setJumlah(Integer.parseInt(barang[x][1]));
				transaksi.setHarga(bukuService.getListBuku().get(i).getHarga());
				transaksiService.tambahData(transaksi);
				stokBaru = bukuService.getListBuku().get(i).getStok()-transaksi.getJumlah();
				bukuService.getListBuku().get(i).setStok(stokBaru);
			} else {
				System.out.println("\nkoding transaksi masih salah");
			}
		}
		
		
		
		
//		menampilkan data transaksi
		i = 1;
		int totalHarga = 0;
		System.out.println("\nData Transaksi");
		for (Transaksi transaksi : transaksiService.getListTransaksi()) {

			// print data mahasiswa
			System.out.println("|" + padRight("" + i, 3) + "| " + padRight(transaksi.getId(), 8) + "| "
					+ padRight("" + transaksi.getJudul(), 20) + "| " + padRight(""+transaksi.getJumlah(), 8) + "| "
					+ padRight("" + transaksi.getHarga(), 3) + "| ");
			totalHarga += transaksi.getHarga();
			// next row number
			i += 1;
		}
		
		System.out.println("Total Harga : " + padRight("" + totalHarga, 20));

		
		
//		print data buku yang baru
		i = 1;
		System.out.println("\nData buku yang baru");
		for (Buku buku : bukuService.getListBuku()) {
			System.out.println("|" + padRight("" + i, 3) + "| " + padRight(buku.getId(), 8) + "| "
					+ padRight(buku.getJudul(), 20) + "|" + padRight("" + buku.getPenulis(), 20) + "|" 
					+ padRight("" + buku.getPenerbit(), 20) + "|" + padRight("" + buku.getHarga(), 10) + "|"
					+ padRight("" + buku.getStok(), 5) + "|");

			// next row number
			i += 1;
		}
		
//		transaksiService.beliData("b003");

	}
	
	public static String padRight(String inputString, int length) {
		return String.format("%1$-" + length + "s", inputString);

	}
}
