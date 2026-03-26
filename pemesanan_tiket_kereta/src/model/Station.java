/* Nama File    : Station.java
 * Deskripsi    : Representasi data stasiun kereta
 * Tanggal      : 23 Maret 2026
 */
package model;

import service.PrintableInfo;

/**
 * Menyimpan informasi stasiun asal/tujuan pada jadwal perjalanan.
 *
 * TODO Tim:
 * 1. Lengkapi constructor, getter, dan setter.
 * 2. Tambahkan validasi format ID stasiun.
 */
public class Station implements PrintableInfo {
    /************ATRIBUT************/
    private String id;
    private String nama;
    private String kota;

    /************METHOD************/
    public Station() {
        this.id = "";
        this.nama = "";
        this.kota = "";
    }

    public Station(String id, String nama, String kota) {
        this.id = id;
        this.nama = nama;
        this.kota = kota;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getNama() {
        return nama;
    }

    public void setNama(String nama) {
        this.nama = nama;
    }

    public String getKota() {
        return kota;
    }

    public void setKota(String kota) {
        this.kota = kota;
    }

    @Override
    public void printInfo() {
        System.out.println("Stasiun: " + nama + " (" + id + ") - " + kota);
    }
}
