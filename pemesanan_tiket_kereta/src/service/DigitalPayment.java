/* Nama File    : DigitalPayment.java
 * Deskripsi    : Implementasi metode pembayaran digital
 * Tanggal      : 23 Maret 2026
 */
package service;

/**
 * Implementasi awal metode pembayaran digital.
 *
 * TODO Tim:
 * 1. Implement logic processPayment dan validasi amount.
 * 2. Hubungkan status pembayaran ke PaymentRecord.
 * 3. Uji skenario nominal valid/invalid dan idempotency pembayaran.
 */
public class DigitalPayment implements PaymentMethod {
    /************ATRIBUT************/
    private String providerName;

    /************METHOD************/
    public DigitalPayment() {
    }

    public DigitalPayment(String providerName) {
    }

    public String getProviderName() {
        return null;
    }

    public void setProviderName(String providerName) {
    }

    @Override
    public void processPayment(double amount) {
    }
}
