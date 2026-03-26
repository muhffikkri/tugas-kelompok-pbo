/* Nama File    : Station.java
 * Deskripsi    : Representasi data stasiun kereta
 * Tanggal      : 23 Maret 2026
 */
package model;

import service.PrintableInfo;

/**
 * Menyimpan informasi stasiun asal/tujuan pada jadwal perjalanan.
 *
 * TODO :
 * 1. Lengkapi constructor, getter, dan setter.
 * 2. Tambahkan validasi format ID stasiun.
 */
public class Station implements PrintableInfo {
    /************ATRIBUT************/
    private String id;
    private String namaStasiun;
    private String kota;

    /************METHOD************/
    public Station() {
        this.id = "";
        this.namaStasiun = "";
        this.kota = "";
    }

    public Station(String id, String nama, String kota) {
        setId(id);
        setNamaStasiun(nama);
        setKota(kota);
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        if (id == null || id.isBlank()) {
            throw new IllegalArgumentException("ID stasiun tidak boleh kosong");
        }
        assert !id.isBlank() : "ID stasiun harus terisi";
        this.id = id;
    }

    public String getNamaStasiun() {
        return namaStasiun;
    }

    public void setNamaStasiun(String namaStasiun) {
        if (namaStasiun == null || namaStasiun.isBlank()) {
            throw new IllegalArgumentException("Nama stasiun tidak boleh kosong");
        }
        assert !namaStasiun.isBlank() : "Nama stasiun harus terisi";
        this.namaStasiun = namaStasiun;
    }

    public String getKota() {
        return kota;
    }

    public void setKota(String kota) {
        if (kota == null || kota.isBlank()) {
            throw new IllegalArgumentException("Kota stasiun tidak boleh kosong");
        }
        assert !kota.isBlank() : "Kota stasiun harus terisi";
        this.kota = kota;
    }

    @Override
    public void printInfo() {
        System.out.println("Stasiun: " + namaStasiun + " (" + id + ") - " + kota);
    }
}
