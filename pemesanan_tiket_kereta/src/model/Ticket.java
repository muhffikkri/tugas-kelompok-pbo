/* Nama File    : Ticket.java
 * Deskripsi    : Kelas untuk data tiket 
 * Tanggal      : 23 Maret 2026
 */

package model;

import service.PrintableInfo;
import exception.InvalidBookingException;

/**
 * Kelas yang merepresentasikan tiket perjalanan kereta api. 
 */
public class Ticket implements PrintableInfo {
    /************ATRIBUT************/
    private String ticketId;
    private String seatNumber;
    private Schedule schedule;
    private Passenger passenger;
    private PaymentRecord paymentRecord;

	/************METHOD************/
    // Menginisialisasi tiket kosong dengan payment record default.
    public Ticket() {
        this.ticketId = "";
        this.seatNumber = "";
        this.schedule = null;
        this.passenger = null;
        this.paymentRecord = new PaymentRecord();
    }

    // Menginisialisasi tiket dengan data utama penumpang dan jadwal.
    public Ticket(String ticketId, String seatNumber, Schedule schedule, Passenger passenger) {
        setTicketId(ticketId);
        setSeatNumber(seatNumber);
        setSchedule(schedule);
        setPassenger(passenger);
        this.paymentRecord = new PaymentRecord();
    }

    // Mengambil ID tiket.
    public String getTicketId() {
        return ticketId;
    }

    // Mengatur ID tiket agar tidak bernilai null.
    public void setTicketId(String ticketId) {
        this.ticketId = (ticketId == null) ? "" : ticketId;
    }

    // Mengambil nomor kursi pada tiket.
    public String getSeatNumber() {
        return seatNumber;
    }

    // Mengatur nomor kursi tiket agar tidak bernilai null.
    public void setSeatNumber(String seatNumber) {
        this.seatNumber = (seatNumber == null) ? "" : seatNumber;
    }

    // Mengambil jadwal perjalanan pada tiket.
    public Schedule getSchedule() {
        return schedule;
    }

    // Mengatur jadwal perjalanan tiket.
    public void setSchedule(Schedule schedule) {
        this.schedule = schedule;
    }

    // Mengambil data penumpang pemilik tiket.
    public Passenger getPassenger() {
        return passenger;
    }

    // Mengatur data penumpang pemilik tiket.
    public void setPassenger(Passenger passenger) {
        this.passenger = passenger;
    }

    // Mengambil rekam pembayaran tiket.
    public PaymentRecord getPaymentRecord() {
        return paymentRecord;
    }

    // Mengatur rekam pembayaran tiket dengan validasi tidak null.
    public void setPaymentRecord(PaymentRecord paymentRecord) {
        if (paymentRecord == null) {
            throw new IllegalArgumentException("Payment record tidak boleh null");
        }
        this.paymentRecord = paymentRecord;
    }

    // Memvalidasi data tiket sebelum diterbitkan.
    public void generateTicket() throws InvalidBookingException {
        if (passenger == null) {
            throw new InvalidBookingException("Penumpang belum diisi.");
        }

        if (schedule == null) {
            throw new InvalidBookingException("Jadwal belum dipilih.");
        }

        if (seatNumber == null || seatNumber.trim().isEmpty()) {
            throw new InvalidBookingException("Nomor kursi tidak valid.");
        }

        if (paymentRecord == null) {
            throw new InvalidBookingException("Data pembayaran belum tersedia.");
        }

        System.out.println("Tiket Berhasil Diterbitkan untuk: " + passenger.getNamaLengkap());
    }

    @Override
    // Menampilkan informasi tiket, penumpang, jadwal, dan pembayaran.
    public void printInfo() {
        System.out.println("========== TIKET KERETA ==========");
        System.out.println("ID Tiket: " + ticketId);
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