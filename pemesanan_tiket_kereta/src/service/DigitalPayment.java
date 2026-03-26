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
    public void processPayment(double amount) {
        // Validasi nominal pembayaran
        if (amount <= 0) {
            System.out.println("❌ ERROR: Nominal pembayaran harus lebih dari 0");
            return;
        }

        // Simulasi proses pembayaran digital
        System.out.println("💳 Memproses pembayaran digital...");
        System.out.println("   Provider: " + providerName);
        System.out.println("   Nominal: Rp " + String.format("%.2f", amount));

        try {
            // Simulasi delay processing
            Thread.sleep(1000);

            // Simulasi hasil pembayaran (90% berhasil)
            boolean success = Math.random() > 0.1;

            if (success) {
                System.out.println("✅ Pembayaran berhasil diproses!");
                System.out.println("   Status: COMPLETED");
            } else {
                System.out.println("❌ Pembayaran gagal!");
                System.out.println("   Status: FAILED");
            }
        } catch (InterruptedException e) {
            System.out.println("❌ Proses pembayaran terputus: " + e.getMessage());
        }
    }
}
