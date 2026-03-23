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
    }

    protected Person(String nama, String nik, String noTelp) {
    }

    public String getNama() {
        return null;
    }

    public void setNama(String nama) {
    }

    public String getNik() {
        return null;
    }

    public void setNik(String nik) {
    }

    public String getNoTelp() {
        return null;
    }

    public void setNoTelp(String noTelp) {
    }

    public abstract void printInfo();
}
