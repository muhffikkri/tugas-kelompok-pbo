/* Nama File    : Person.java
 * Deskripsi    : Kelas abstrak sebagai basis data individu
 * Tanggal      : 23 Maret 2026
 */
package model;

import service.PrintableInfo;
import exception.InvalidNIKException;

//Abstraksi umum untuk seluruh entitas individu pada sistem.
//ATRIBUT
public abstract class Person implements PrintableInfo {
    private String nama;
    private String nik;
    private String noTelp;

    //METHOD
    public Person() {
        this.nama = "";
        this.nik = "";
        this.noTelp = "";
    }

    public Person(String nama, String nik, String noTelp) throws InvalidNIKException {
        this.nama = nama;
        setNik(nik);
        this.noTelp = noTelp;
    }

    public String getNamaLengkap() {
        return nama;
    }

    public void setNamaLengkap(String nama) {
        this.nama = nama;
    }

    public String getNik() {
        return nik;
    }

    public void setNik(String nik) throws InvalidNIKException {
        if (nik.length() != 16) {
            throw new InvalidNIKException("NIK harus berjumlah 16 digit.");
        }
        this.nik = nik;
    }

    public String getNoTelp() {
        return noTelp;
    }

    public void setNoTelp(String noTelp) {
        this.noTelp = noTelp;
    }

    @Override
    public abstract void printInfo();
}
