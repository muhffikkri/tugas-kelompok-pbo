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

    public Passenger(String namaLengkap, String nik, String noTelp, String email) throws InvalidNIKException {
        super(namaLengkap, "", noTelp);
        setNik(nik); // Validasi NIK melalui setter Person
        this.email = email;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    @Override
    public void printInfo() {
        System.out.println("Nama Penumpang: " + getNamaLengkap());
        System.out.println("NIK: " + getNik());
        System.out.println("No. Telepon: " + getNoTelp());
        System.out.println("Email: " + email);
    }
}
