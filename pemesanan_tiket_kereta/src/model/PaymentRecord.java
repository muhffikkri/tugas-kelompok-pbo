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
    }

    public PaymentRecord(LocalDateTime waktu, String status, double jumlah) {
    }

    public LocalDateTime getWaktu() {
        return null;
    }

    public void setWaktu(LocalDateTime waktu) {
    }

    public String getStatus() {
        return null;
    }

    public void setStatus(String status) {
    }

    public double getJumlah() {
        return 0;
    }

    public void setJumlah(double jumlah) {
    }

    @Override
    public void printInfo() {
    }
}
