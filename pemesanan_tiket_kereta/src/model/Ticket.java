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
        this.idTicket = "";
        this.passenger = null;
        this.schedule = null;
        this.paymentRecord = new PaymentRecord();  // Komposisi: PaymentRecord tergantung pada Ticket
    }

    public Ticket(String idTicket, Passenger passenger, Schedule schedule) {
        this.idTicket = idTicket;
        this.passenger = passenger;
        this.schedule = schedule;
        this.paymentRecord = new PaymentRecord();  // Komposisi: PaymentRecord dibuat bersamaan dengan Ticket
    }

    public String getIdTicket() {
        return idTicket;
    }

    public void setIdTicket(String idTicket) {
        this.idTicket = idTicket;
    }

    public Passenger getPassenger() {
        return passenger;
    }

    public void setPassenger(Passenger passenger) {
        this.passenger = passenger;
    }

    public Schedule getSchedule() {
        return schedule;
    }

    public void setSchedule(Schedule schedule) {
        this.schedule = schedule;
    }

    public PaymentRecord getPaymentRecord() {
        return paymentRecord;
    }

    @Override
    public void printInfo() {
        System.out.println("========== TIKET KERETA ==========");
        System.out.println("ID Tiket: " + idTicket);
        if (passenger != null) {
            System.out.println("\n--- Data Penumpang ---");
            passenger.printInfo();
        }
        if (schedule != null) {
            System.out.println("\n--- Data Jadwal ---");
            schedule.printInfo();
        }
        if (paymentRecord != null) {
            System.out.println("\n--- Data Pembayaran ---");
            paymentRecord.printInfo();
        }
        System.out.println("==================================");
    }
}
