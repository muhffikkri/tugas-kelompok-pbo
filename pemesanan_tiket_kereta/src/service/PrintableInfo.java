/* Nama File    : PrintableInfo.java
 * Deskripsi    : Interface kontrak untuk menampilkan informasi objek model
 * Tanggal      : 23 Maret 2026
 */
package service;

/*
 * Kontrak umum untuk seluruh kelas pada package model 
 * yang wajib menyediakan method printInfo().*/
public interface PrintableInfo {
	/************ATRIBUT************/

	/************METHOD************/
    // Menampilkan informasi utama objek ke output konsol.
    void printInfo();
}
