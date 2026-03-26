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
        super();
        this.email = "";
    }

    public Passenger(String nama, String nik, String noTelp, String email) throws InvalidNIKException {
        super(nama, nik, noTelp);
        validateNIK(nik);  // Validasi NIK saat pembuatan object
        this.email = email;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void validateNIK(String nik) throws InvalidNIKException {
        // Validasi NIK harus 16 digit
        if (nik == null || nik.length() != 16 || !nik.matches("\\d{16}")) {
            throw new InvalidNIKException("NIK harus terdiri dari 16 digit angka");
        }
    }

    @Override
    public void printInfo() {
        System.out.println("Nama Penumpang: " + getNama());
        System.out.println("NIK: " + getNik());
        System.out.println("No. Telepon: " + getNoTelp());
        System.out.println("Email: " + email);
    }
}
