/* Nama File    : Stasion.java
 * Deskripsi    : Kelas untuk data stasiun
 * Tanggal      : 23 Maret 2026
 */
package model;

import service.PrintableInfo;

/**
 * Kelas yang merepresentasikan data stasiun kereta api. 
 */
public class Stasion implements PrintableInfo {
    /************ATRIBUT************/
    private String idStasion;
    private String namaStasion;
    private String kota;

	/************METHOD************/
    // Menginisialisasi data stasiun dengan nilai default.
    public Stasion() {
        this.idStasion = "";
        this.namaStasion = "";
        this.kota = "";
    }

    // Menginisialisasi data stasiun dengan parameter lengkap.
    public Stasion(String idStasion, String namaStasion, String kota) {
            setIdStasion(idStasion);
            setNamaStasion(namaStasion);
            setKota(kota);
    }

    // Mengambil ID stasiun.
    public String getIdStasion() {
        return idStasion;
    }

    // Mengatur ID stasiun agar tidak kosong.
    public void setIdStasion(String idStasion) throws IllegalArgumentException{
        if (idStasion == null || idStasion.trim().isEmpty()) {
            throw new IllegalArgumentException("ID Stasiun tidak boleh kosong.");
        }
        this.idStasion = idStasion;
    }

    // Mengambil nama stasiun.
    public String getNamaStasion() {
        return namaStasion;
    }

    // Mengatur nama stasiun agar tidak kosong.
    public void setNamaStasion(String namaStasion) {
        if (namaStasion == null || namaStasion.trim().isEmpty()) {
            throw new IllegalArgumentException("Nama stasiun tidak boleh kosong.");
        }
        this.namaStasion = namaStasion;
    }

    // Mengambil nama kota lokasi stasiun.
    public String getKota() {
        return kota;
    }

    // Mengatur kota stasiun agar tidak kosong.
    public void setKota(String kota) {
        if (kota == null || kota.trim().isEmpty()) {
            throw new IllegalArgumentException("Kota stasiun tidak boleh kosong.");
        }
        this.kota = kota;
    }

    @Override
    // Menampilkan informasi stasiun ke konsol.
    public void printInfo() {
        System.out.println("ID Stasiun: " + idStasion);
        System.out.println("Nama Stasiun: " + namaStasion);
        System.out.println("Kota: " + kota);
    }
}
