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
		
		// Print Header Table
		System.out.println("| " + padRight("Id", 3) + "| " + padRight("Judul", 8) + "| " + padRight("Penulis", 20) 
		+ "| " + padRight("Penerbit", 3) + "|" + padRight("Harga", 3) + "|" + padRight("Stok", 3) + "|");
		
		// Initiate Number of Row
		int i = 1;

//		print data buku
		for (Buku buku : bukuService.getListBuku()) {
			System.out.println("|" + padRight("" + i, 3) + "| " + padRight(buku.getId(), 8) + "| "
					+ padRight(buku.getJudul(), 20) + "|" + padRight("" + buku.getPenulis(), 20) + "|" 
					+ padRight("" + buku.getPenerbit(), 20) + "|" + padRight("" + buku.getHarga(), 10) + "|"
					+ padRight("" + buku.getStok(), 5) + "|");

			// next row number
			i += 1;
		}
		
//		lihat detail data buku
		bukuService.detailData("b002");

//		menambah data transaksi
		
//		String[][] barang = {{"b001","3"},{"b002","4"}};
//		
//		for(i=0; i<barang.length; i++) {
//			
//		}
	
		i = 0;
		boolean found = false;
		for (Buku buku : bukuService.getListBuku()) {			
			if (buku.getId() == "b002") {
				found = true;
				break;
			}	
			i += 1;
		}
		
		if (found){
			System.out.println("\nData Transaksi");
			Transaksi transaksi = new Transaksi();
			transaksi.setId(bukuService.getListBuku().get(i).getId());
			transaksi.setJudul(bukuService.getListBuku().get(i).getJudul());
			transaksi.setJumlah(1);
			transaksi.setHarga(bukuService.getListBuku().get(i).getHarga());
			transaksiService.tambahData(transaksi);
		} else {
			System.out.println("\nkoding transaksi masih salah");
		}
		
//		menampilkan data transaksi
		i = 0;
		for (Transaksi transaksi : transaksiService.getListTransaksi()) {

			// print data mahasiswa
			System.out.println("|" + padRight("" + i, 3) + "| " + padRight(transaksi.getId(), 8) + "| "
					+ padRight("" + transaksi.getJudul(), 3) + "| " + padRight(""+transaksi.getJumlah(), 8) + "| "
					+ padRight("" + transaksi.getHarga(), 3) + "| ");

			// next row number
			i += 1;
		}
		
//		update data stok buku
		int stokBaru;
		i = 0;
		for (Transaksi transaksi : transaksiService.getListTransaksi()) {
			stokBaru = bukuService.getListBuku().get(i).getStok()-transaksi.getJumlah();
			bukuService.getListBuku().get(i).setStok(stokBaru);
			// next row number
			i += 1;
		}
		
//		print data buku
		System.out.println("\nData buku yang baru");
		for (Buku buku : bukuService.getListBuku()) {
			System.out.println("|" + padRight("" + i, 3) + "| " + padRight(buku.getId(), 8) + "| "
					+ padRight(buku.getJudul(), 20) + "|" + padRight("" + buku.getPenulis(), 20) + "|" 
					+ padRight("" + buku.getPenerbit(), 20) + "|" + padRight("" + buku.getHarga(), 10) + "|"
					+ padRight("" + buku.getStok(), 5) + "|");

			// next row number
			i += 1;
		}

	}
	
	public static String padRight(String inputString, int length) {
		return String.format("%1$-" + length + "s", inputString);

	}
}
