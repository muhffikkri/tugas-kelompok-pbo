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
    }

    public Station(String id, String nama, String kota) {
    }

    public String getId() {
        return null;
    }

    public void setId(String id) {
    }

    public String getNama() {
        return null;
    }

    public void setNama(String nama) {
    }

    public String getKota() {
        return null;
    }

    public void setKota(String kota) {
    }

    @Override
    public void printInfo() {
    }
}
