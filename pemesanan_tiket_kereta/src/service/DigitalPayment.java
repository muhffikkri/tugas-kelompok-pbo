/* Nama File    : DigitalPayment.java
 * Deskripsi    : Implementasi metode pembayaran digital
 * Tanggal      : 23 Maret 2026
 */
package service;
import model.PaymentRecord;

/**
 * Implementasi awal metode pembayaran digital.
 *
 */
public class DigitalPayment implements PaymentMethod {
	/************ATRIBUT************/
    private String namaProvider;
    private PaymentRecord record;

	/************METHOD************/
    // Menginisialisasi pembayaran digital dengan nilai default.
    public DigitalPayment() {
        this.namaProvider = "";
        this.record = null;
    }

    // Menginisialisasi pembayaran digital dengan provider dan record tertentu.
    public DigitalPayment(String namaProvider, PaymentRecord record) {
        this.namaProvider = namaProvider;
        this.record = record;
    }

    // Mengambil nama provider pembayaran digital.
    public String getNamaProvider() {
        return namaProvider;
    }

    // Mengatur nama provider pembayaran digital.
    public void setNamaProvider(String namaProvider) {
        this.namaProvider = namaProvider;
    }

    // Mengambil rekam pembayaran yang terhubung.
    public PaymentRecord getRecord() {
        return record;
    }

    // Mengatur rekam pembayaran yang akan disinkronkan.
    public void setRecord(PaymentRecord record) {
        this.record = record;
    }

    @Override
    // Memproses pembayaran dan menyinkronkan status transaksi secara aman.
    public void processPayment(double amount) {
        if (amount <= 0) {
            if (record != null) {
                record.syncPayment("FAILED", 0);
            }
            throw new IllegalArgumentException("Jumlah pembayaran harus lebih dari 0");
        }

        if (record == null) {
            throw new IllegalStateException("PaymentRecord belum dihubungkan");
        }

        if (namaProvider == null || namaProvider.trim().isEmpty()) {
            throw new IllegalStateException("Provider pembayaran digital belum diatur");
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
