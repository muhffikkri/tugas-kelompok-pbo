/* Nama File    : PaymentRecord.java
 * Deskripsi    : Menyimpan rekam jejak transaksi pembayaran tiket
 * Tanggal      : 23 Maret 2026
 */
package model;


import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import service.PrintableInfo;

//Menyimpan detail transaksi pembayaran sebagai bagian komposisi dari Ticket.

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
        setWaktu(waktu);
        setStatus(status);
        setJumlah(jumlah);
    }

    public LocalDateTime getWaktu() {
        return waktu;
    }

    public void setWaktu(LocalDateTime waktu) {
        if (waktu == null) {
            throw new IllegalArgumentException("Waktu transaksi tidak boleh null");
        }
        this.waktu = waktu;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
    status = (status == null) ? "" : status.toUpperCase();

    if (!(status.equals("PENDING") || 
          status.equals("COMPLETED") || 
          status.equals("FAILED"))) {
        throw new IllegalArgumentException("Status tidak valid");
    }

    this.status = status;
}

    public double getJumlah() {
        return jumlah;
    }

    public void setJumlah(double jumlah) {
        if (Double.isNaN(jumlah) || Double.isInfinite(jumlah) || jumlah < 0) {
            throw new IllegalArgumentException("Jumlah pembayaran tidak valid");
        }
        this.jumlah = jumlah;
    }

    /*
     * Sinkronisasi status pembayaran.
     * Digunakan saat proses pembayaran digital berhasil atau gagal.*/
    public void syncPayment(String newStatus, double amount) {
        setStatus(newStatus);
        setJumlah(amount);
        setWaktu(LocalDateTime.now());
    }

    @Override
    public void printInfo() {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd-MM-yyyy HH:mm:ss");
        System.out.println("--- Detail Pembayaran ---");
        System.out.println("Waktu Transaksi : " + waktu.format(formatter));
        System.out.println("Status          : " + status);
        System.out.println("Jumlah          : Rp " + String.format("%,.2f", jumlah));
    }
}
