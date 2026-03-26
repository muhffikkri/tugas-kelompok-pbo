/* Nama File    : DigitalPayment.java
 * Deskripsi    : Implementasi metode pembayaran digital
 * Tanggal      : 23 Maret 2026
 */
package service;
import exception.InvalidBookingException;

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
        this.providerName = "";
    }
    
    public DigitalPayment(String providerName) {
        this.providerName = providerName;
    }

    public String getProviderName() {
        return providerName;
    }

    public void setProviderName(String providerName) {
        this.providerName = providerName;
    }

    @Override
    public void processPayment(double amount) throws InvalidBookingException {
        if (amount <= 0) {
            throw new InvalidBookingException("Nominal kurang dari nol");
        } else {
            System.out.println("Pembayaran berhasil dilakukan dengan " + getProviderName() + " Sejumlah " + amount);
        }
    }
}
