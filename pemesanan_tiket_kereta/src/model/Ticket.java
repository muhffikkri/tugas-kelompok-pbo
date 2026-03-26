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
 * RELASI DI TICKET:
 * ================
 * Ticket ●────── PaymentRecord   (solid diamond = KOMPOSISI/strong ownership)
 * Ticket ───── Passenger         (plain line = ASOSIASI/weak)
 * Ticket ───── Schedule          (plain line = ASOSIASI/weak)
 *
 * TODO Tim:
 * 1. Lengkapi constructor, getter, setter, dan identitas tiket.
 * 2. Hubungkan tiket dengan logika perhitungan total harga.
 * 3. Tambahkan validasi status pembayaran.
 * 4. Uji lifecycle PaymentRecord mengikuti lifecycle Ticket.
 */
public class Ticket implements PrintableInfo {
    /****** RELASI DI TICKET ******
     * 
     *          Ticket
     *       ●  │  ─
     *   Komposisi Asosiasi
     *       │       │
     *   ┌───┴──┬────┴───┐
     *   ▼      ▼        ▼
     * Payment Passenger Schedule
     * Record  (mandiri) (mandiri)
     * (child:
     *  hidup
     *  jika
     *  parent
     *  ada)
     * 
     * ● KOMPOSISI: Lifecycle dependent
     * - PaymentRecord HANYA ada jika Ticket ada
     * - Parent CREATE & OWN child sepenuhnya
     * - Jika Ticket dihapus → PaymentRecord IKUT DIHAPUS
     * 
     * ─ ASOSIASI: Lifecycle independent
     * - Passenger bisa hidup TANPA Ticket
     * - Schedule bisa hidup TANPA Ticket
     * - Jika Ticket dihapus → Passenger/Schedule TETAP ADA
     *****************************/
    
    /************ATRIBUT************/
    private String idTicket;
    
    /** ─ ASOSIASI: Passenger dapat hidup mandiri tanpa Ticket */
    private Passenger passenger;
    
    /** ─ ASOSIASI: Schedule dapat hidup mandiri tanpa Ticket */
    private Schedule schedule;
    
    /** ● KOMPOSISI: PaymentRecord hanya ada jika Ticket ada (lifecycle dependent) */
    private PaymentRecord paymentRecord;

    /************METHOD************/
    public Ticket() {
        this.idTicket = "";
        this.passenger = null;
        this.schedule = null;
        // KOMPOSISI: PaymentRecord HANYA ada jika Ticket ada
        // PaymentRecord dibuat otomatis saat Ticket dibuat
        // Jika Ticket dihapus, PaymentRecord juga IKUT dihapus
        this.paymentRecord = new PaymentRecord();
    }

    public Ticket(String idTicket, Passenger passenger, Schedule schedule) {
        this.idTicket = idTicket;
        this.passenger = passenger;  // ASOSIASI: Passenger mandiri, bisa hidup tanpa Ticket
        this.schedule = schedule;    // ASOSIASI: Schedule mandiri, bisa hidup tanpa Ticket
        
        // KOMPOSISI: PaymentRecord HANYA ada jika Ticket ada
        // PaymentRecord dibuat otomatis saat Ticket dibuat (part-of relationship)
        // Lifecycle PaymentRecord bergantung pada lifecycle Ticket
        // Jika Ticket dihapus, PaymentRecord juga IKUT dihapus
        this.paymentRecord = new PaymentRecord();
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
