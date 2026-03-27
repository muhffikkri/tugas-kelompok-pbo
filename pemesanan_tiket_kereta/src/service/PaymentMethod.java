/* Nama File    : PaymentMethod.java
 * Deskripsi    : Interface untuk metode pembayaran
 * Tanggal      : 23 Maret 2026
 */
package model;

/**
 * Interface yang menyediakan metode processPayment() untuk memproses pembayaran.
 */
public interface PaymentMethod {
    void processPayment(double amount);
}
