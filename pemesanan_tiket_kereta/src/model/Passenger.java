/* Nama File    : Passenger.java
 * Deskripsi    : Kelas turunan Person untuk data penumpang
 * Tanggal      : 23 Maret 2026
 */
package model;

import exception.InvalidNIKException;

/**
 * Merepresentasikan penumpang kereta sebagai turunan dari Person.
 * Menambahkan kebutuhan validasi NIK dan perilaku print informasi.
 *
 * TODO Tim:
 * 1. Implement constructor lengkap sesuai kebutuhan pemesanan.
 * 2. Implement validasi NIK 16 digit.
 * 3. Lempar InvalidNIKException saat data tidak valid.
 * 4. Uji skenario NIK valid dan invalid.
 */
public class Passenger extends Person {
    /************ATRIBUT************/
    private String email;

    /************METHOD************/
    public Passenger() {
    }

    public Passenger(String nama, String nik, String noTelp, String email) throws InvalidNIKException {
    }

    public String getEmail() {
        return null;
    }

    public void setEmail(String email) {
    }

    public void validateNIK(String nik) throws InvalidNIKException {
    }

    @Override
    public void printInfo() {
    }
}
