/* Nama File    : Person.java
 * Deskripsi    : Kelas abstrak sebagai basis data individu
 * Tanggal      : 23 Maret 2026
 */
package model;

import service.PrintableInfo;
import exception.InvalidNIKException;

/**
 * Abstraksi umum untuk seluruh entitas individu pada sistem. 
 */
public abstract class Person implements PrintableInfo {
	/************ATRIBUT************/
    private String nama;
    private String nik;
    private String noTelp;

	/************METHOD************/
    // Menginisialisasi data person dengan nilai default.
    public Person() {
        this.nama = "";
        this.nik = "";
        this.noTelp = "";
    }

    // Menginisialisasi data person dengan validasi NIK.
    public Person(String nama, String nik, String noTelp) throws InvalidNIKException {
        setNamaLengkap(nama);
        setNik(nik);
        setNoTelp(noTelp);
    }

    // Mengambil nama lengkap person.
    public String getNamaLengkap() {
        return nama;
    }

    // Mengatur nama lengkap person dengan validasi tidak kosong.
    public void setNamaLengkap(String nama) {
        if (nama == null || nama.trim().isEmpty()) {
            throw new IllegalArgumentException("Nama tidak boleh kosong");
        }
        this.nama = nama;
    }

    // Mengambil NIK person.
    public String getNik() {
        return nik;
    }

    // Mengatur NIK dengan validasi 16 digit numerik.
    public void setNik(String nik) throws InvalidNIKException {
        if (nik == null || !nik.matches("\\d{16}")) {
            throw new InvalidNIKException("NIK harus terdiri dari 16 digit angka.");
        }
        this.nik = nik;
    }

    // Mengambil nomor telepon person.
    public String getNoTelp() {
        return noTelp;
    }

    // Mengatur nomor telepon person.
    public void setNoTelp(String noTelp) {
        this.noTelp = (noTelp == null) ? "" : noTelp;
    }

    @Override
    // Menampilkan informasi person sesuai implementasi turunan.
    public abstract void printInfo();
}
