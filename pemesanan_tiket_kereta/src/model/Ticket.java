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
 * Ticket <*>----- PaymentRecord  (solid diamond = KOMPOSISI/strong ownership)
 * Ticket ----- Passenger         (plain line = ASOSIASI/weak)
 * Ticket ----- Schedule          (plain line = ASOSIASI/weak)
 *
 * TODO :
 * 1. Lengkapi constructor, getter, setter, dan identitas tiket.
 * 2. Hubungkan tiket dengan logika perhitungan total harga.
 * 3. Tambahkan validasi status pembayaran.
 * 4. Uji lifecycle PaymentRecord mengikuti lifecycle Ticket.
 */
public class Ticket implements PrintableInfo {
    /****** RELASI DI TICKET ******
     * 
    *          Ticket
    *       <*> |  -
    *   Komposisi  Asosiasi
    *        |        |
    *   +----+---+----+----+
    *   v        v         v
    * Payment  Passenger  Schedule
    * Record   (mandiri)  (mandiri)
     * (child:
     *  hidup
     *  jika
     *  parent
     *  ada)
     * 
    * <*> KOMPOSISI: Lifecycle dependent
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
    private String idTiket;
    
    /** ─ ASOSIASI: Passenger dapat hidup mandiri tanpa Ticket */
    private Passenger passenger;
    
    /** ─ ASOSIASI: Schedule dapat hidup mandiri tanpa Ticket */
    private Schedule schedule;
    
    /****** KOMPOSISI PAYMENT RECORD ******
     * 
    * <*> KOMPOSISI -> PaymentRecord
     * 
     * Parent: Ticket
     * Child: PaymentRecord
     * 
     * Ciri Komposisi (Strong Ownership):
     * 1. PaymentRecord HANYA ada jika Ticket ada
     * 2. Ticket CREATE & OWN PaymentRecord sepenuhnya
     * 3. Jika Ticket dihapus → PaymentRecord IKUT DIHAPUS
     * 4. Lifecycle PaymentRecord bergantung TOTAL pada Ticket
     * 5. 1 PaymentRecord hanya untuk 1 Ticket (1:1)
     *******************************************/
    /** <*> KOMPOSISI: PaymentRecord hanya ada jika Ticket ada (lifecycle dependent) */
    private PaymentRecord paymentRecord;

    /************METHOD************/
    public Ticket() {
        this.idTiket = "";
        this.passenger = null;
        this.schedule = null;
        
        // KOMPOSISI PAYMENTRECORD 
        // Ticket CREATE PaymentRecord otomatis (parent owns child)
        // PaymentRecord baru dibuat saat Ticket dibuat
        // Tidak ada PaymentRecord yang berdiri sendiri
        this.paymentRecord = new PaymentRecord();
    }

    public Ticket(String idTiket, Passenger passenger, Schedule schedule) {
        setIdTiket(idTiket);
        
        // ASOSIASI (bukan komposisi):
        this.passenger = passenger;  // Passenger bisa hidup TANPA Ticket
        this.schedule = schedule;    // Schedule bisa hidup TANPA Ticket
        
        //KOMPOSISI PAYMENTRECORD 
        // Ticket SELALU membuat PaymentRecord baru (strong ownership)
        // PaymentRecord lifecycle bergantung TOTAL pada Ticket
        // Jika Ticket dihapus → PaymentRecord IKUT DIHAPUS (not orphaned)
        this.paymentRecord = new PaymentRecord();
    }

    public String getIdTiket() {
        return idTiket;
    }

    public void setIdTiket(String idTiket) {
        if (idTiket == null || idTiket.isBlank()) {
            throw new IllegalArgumentException("ID tiket tidak boleh kosong");
        }
        assert !idTiket.isBlank() : "ID tiket harus terisi";
        this.idTiket = idTiket;
    }

    public Passenger getPassenger() {
        return passenger;
    }

    public void setPassenger(Passenger passenger) {
        if (passenger == null) {
            throw new IllegalArgumentException("Passenger tidak boleh null");
        }
        this.passenger = passenger;
    }

    public Schedule getSchedule() {
        return schedule;
    }

    public void setSchedule(Schedule schedule) {
        if (schedule == null) {
            throw new IllegalArgumentException("Schedule tidak boleh null");
        }
        this.schedule = schedule;
    }

    public PaymentRecord getPaymentRecord() {
        return paymentRecord;
    }

    @Override
    public void printInfo() {
        System.out.println("========== TIKET KERETA ==========");
        System.out.println("ID Tiket: " + idTiket);
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
