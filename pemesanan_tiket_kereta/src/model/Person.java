/* Nama File    : Person.java
 * Deskripsi    : Kelas abstrak sebagai basis data individu
 * Tanggal      : 23 Maret 2026
 */
package model;

import service.PrintableInfo;
import exception.InvalidNIKException;

/**
 * Abstraksi umum untuk seluruh entitas individu pada sistem.
 * Menyimpan atribut dasar person dan kontrak method informasi.
 *
 * TODO Tim:
 * 1. Finalisasi atribut wajib berdasarkan class diagram.
 * 2. Lengkapi constructor, getter, dan setter.
 * 3. Tambahkan validasi dasar pada setter.
 */
public abstract class Person implements PrintableInfo {
    /************ATRIBUT************/
    private String namaLengkap;
    private String nik;
    private String noTelp;

    /************METHOD************/
    protected Person() {
        this.namaLengkap = "";
        this.nik = "";
        this.noTelp = "";
    }

    protected Person(String namaLengkap, String nik, String noTelp) {
        this.namaLengkap = namaLengkap;
        this.nik = nik;
        this.noTelp = noTelp;
    }

    public String getNamaLengkap() {
        return namaLengkap;
    }

    public void setNamaLengkap(String namaLengkap) {
        this.namaLengkap = namaLengkap;
    }

    public String getNik() {
        return nik;
    }

    public void setNik(String nik) throws InvalidNIKException {
        if (nik == null || nik.length() != 16 || !nik.matches("\\d{16}")) {
            throw new InvalidNIKException("NIK harus terdiri dari 16 digit angka");
        }
        this.nik = nik;
    }

    public String getNoTelp() {
        return noTelp;
    }

    public void setNoTelp(String noTelp) {
        this.noTelp = noTelp;
    }

    public abstract void printInfo();
}
