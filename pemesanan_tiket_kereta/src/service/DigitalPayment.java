/* Nama File    : DigitalPayment.java
 * Deskripsi    : Implementasi metode pembayaran digital
 * Tanggal      : 23 Maret 2026
 */
package service;
import model.PaymentRecord;

/**
 * Implementasi awal metode pembayaran digital.
 *
 * TODO Tim:
 * 1. Implement logic processPayment dan validasi amount.
 * 2. Hubungkan status pembayaran ke PaymentRecord.
 * 3. Uji skenario nominal valid/invalid dan idempotency pembayaran.
 */
public class DigitalPayment implements PaymentMethod {
    //ATRIBUT
    private String namaProvider;
    private PaymentRecord record;

    //METHOD
    public DigitalPayment() {
        this.namaProvider = "";
        this.record = null;
    }

    public DigitalPayment(String namaProvider, PaymentRecord record) {
        this.namaProvider = namaProvider;
        this.record = record;
    }

    public String getNamaProvider() {
        return namaProvider;
    }

    public void setNamaProvider(String namaProvider) {
        this.namaProvider = namaProvider;
    }

    public PaymentRecord getRecord() {
        return record;
    }

    public void setRecord(PaymentRecord record) {
        this.record = record;
    }

    @Override
    public void processPayment(double amount) {
        // 1. Validasi amount
        if (amount <= 0) {
            if (record != null) {
                record.syncPayment("FAILED", 0);
            }
            throw new IllegalArgumentException("Jumlah pembayaran harus lebih dari 0");
        }

        // 2. Hubungkan ke PaymentRecord & Idempotency
        if (record == null) {
            throw new IllegalStateException("PaymentRecord belum dihubungkan");
        }

        if (record.getStatus().equals("COMPLETED")) {
            System.out.println("[IDEMPOTENCY] Pembayaran sudah COMPLETED. Tidak memproses ulang.");
            return;
        }

        //Proses Pembayaran
        System.out.println("Memproses pembayaran digital sebesar Rp " + String.format("%,.2f", amount) + " melalui " + namaProvider);
        record.syncPayment("COMPLETED", amount);
    }
}
