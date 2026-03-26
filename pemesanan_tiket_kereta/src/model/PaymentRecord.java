/* Nama File    : PaymentRecord.java
 * Deskripsi    : Menyimpan rekam jejak transaksi pembayaran tiket
 * Tanggal      : 23 Maret 2026
 */
package model;

import java.time.LocalDateTime;
import service.PrintableInfo;

/**
 * Menyimpan detail transaksi pembayaran sebagai bagian komposisi dari Ticket.
 *
 * TODO Tim:
 * 1. Lengkapi constructor, getter, dan setter.
 * 2. Sinkronkan status pembayaran dengan proses pembayaran digital.
 * 3. Uji format waktu dan perubahan status transaksi.
 */
public class PaymentRecord implements PrintableInfo {
    /************ATRIBUT************/
    private LocalDateTime waktu;
    private String status;
    private double jumlah;

    /************METHOD************/
    public PaymentRecord() {
        this.waktu = LocalDateTime.now();
        this.status = "PENDING";  // Status awal pembayaran
        this.jumlah = 0;
    }

    public PaymentRecord(LocalDateTime waktu, String status, double jumlah) {
        this.waktu = waktu;
        this.status = status;
        this.jumlah = jumlah;
    }

    public LocalDateTime getWaktu() {
        return waktu;
    }

    public void setWaktu(LocalDateTime waktu) {
        this.waktu = waktu;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        // Validasi status pembayaran
        if (status.equals("PENDING") || status.equals("COMPLETED") || status.equals("FAILED")) {
            this.status = status;
        }
    }

    public double getJumlah() {
        return jumlah;
    }

    public void setJumlah(double jumlah) {
        this.jumlah = jumlah;
    }

    @Override
    public void printInfo() {
        System.out.println("Waktu Transaksi: " + waktu);
        System.out.println("Status: " + status);
        System.out.println("Jumlah: Rp " + String.format("%.2f", jumlah));
    }
}
