/* Nama File    : PaymentMethod.java
 * Deskripsi    : Interface untuk metode pembayaran
 * Tanggal      : 23 Maret 2026
 */
package service;

/**
 * Interface yang menyediakan metode processPayment() untuk memproses pembayaran.
 */
public interface PaymentMethod {
	/************ATRIBUT************/

	/************METHOD************/
    // Menjalankan proses pembayaran sesuai implementasi metode yang digunakan.
    void processPayment(double amount);
}
