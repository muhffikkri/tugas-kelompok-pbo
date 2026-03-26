/* Nama File    : Person.java
 * Deskripsi    : Kelas abstrak sebagai basis data individu
 * Tanggal      : 23 Maret 2026
 */
package model;

import service.PrintableInfo;

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
    private String nama;
    private String nik;
    private String noTelp;

    /************METHOD************/
    protected Person() {
        this.nama = "";
        this.nik = "";
        this.noTelp = "";
    }

    protected Person(String nama, String nik, String noTelp) {
        this.nama = nama;
        this.nik = nik;
        this.noTelp = noTelp;
    }

    public String getNama() {
        return nama;
    }

    public void setNama(String nama) {
        this.nama = nama;
    }

    public String getNik() {
        return nik;
    }

    public void setNik(String nik) {
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
