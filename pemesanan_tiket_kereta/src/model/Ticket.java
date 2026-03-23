/* Nama File    : Ticket.java
 * Deskripsi    : Representasi tiket yang berelasi dengan Passenger, Schedule, dan PaymentRecord
 * Tanggal      : 23 Maret 2026
 */
package model;

import service.PrintableInfo;

/**
 * Menyimpan data tiket pemesanan.
 * Kelas ini menerapkan komposisi dengan PaymentRecord dan asosiasi dengan Passenger serta Schedule.
 *
 * TODO Tim:
 * 1. Lengkapi constructor, getter, setter, dan identitas tiket.
 * 2. Hubungkan tiket dengan logika perhitungan total harga.
 * 3. Tambahkan validasi status pembayaran.
 * 4. Uji lifecycle PaymentRecord mengikuti lifecycle Ticket.
 */
public class Ticket implements PrintableInfo {
    /************ATRIBUT************/
    private String idTicket;
    private Passenger passenger;
    private Schedule schedule;
    private PaymentRecord paymentRecord;

    /************METHOD************/
    public Ticket() {
        this.paymentRecord = new PaymentRecord();
    }

    public Ticket(String idTicket, Passenger passenger, Schedule schedule) {
        this.paymentRecord = new PaymentRecord();
    }

    public String getIdTicket() {
        return null;
    }

    public void setIdTicket(String idTicket) {
    }

    public Passenger getPassenger() {
        return null;
    }

    public void setPassenger(Passenger passenger) {
    }

    public Schedule getSchedule() {
        return null;
    }

    public void setSchedule(Schedule schedule) {
    }

    public PaymentRecord getPaymentRecord() {
        return null;
    }

    @Override
    public void printInfo() {
    }
}
