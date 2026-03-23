/* Nama File    : PaymentMethod.java
 * Deskripsi    : Interface untuk strategi metode pembayaran
 * Tanggal      : 23 Maret 2026
 */
package service;

/**
 * Kontrak interface untuk seluruh metode pembayaran pada sistem.
 *
 * TODO Tim:
 * 1. Finalisasi kontrak processPayment(double amount).
 * 2. Definisikan format nilai amount yang valid.
 * 3. Siapkan mock implementasi untuk pengujian integrasi.
 */
public interface PaymentMethod {
    /************ATRIBUT************/

    /************METHOD************/
    void processPayment(double amount);
}
