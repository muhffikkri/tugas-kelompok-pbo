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
    private String namaProvider;

    /************METHOD************/
    public DigitalPayment() {
        this.namaProvider = "";
    }
    
    public DigitalPayment(String providerName) {
        this.namaProvider = providerName;
    }

    public String getNamaProvider() {
        return namaProvider;
    }

    public void setNamaProvider(String namaProvider) {
        this.namaProvider = namaProvider;
    }

    @Override
    public void processPayment(double amount) throws InvalidBookingException {
        if (namaProvider == null || namaProvider.isBlank()) {
            throw new InvalidBookingException("Provider pembayaran digital tidak boleh kosong");
        }
        if (Double.isNaN(amount) || Double.isInfinite(amount) || amount <= 0) {
            throw new InvalidBookingException("Nominal pembayaran harus lebih dari 0");
        }
        assert amount > 0 : "Nominal pembayaran harus > 0";

        // Skeleton method: hanya boundary & exception.
        // TODO Tim: implement integrasi pembayaran dan update PaymentRecord.
        throw new UnsupportedOperationException("processPayment belum diimplementasikan");
    }
}
