/* Nama File    : Ticket.java
 * Deskripsi    : Kelas untuk data tiket 
 * Tanggal      : 23 Maret 2026
 */

package model;
import service.PrintableInfo;
import exception.InvalidBookingException;

//Kelas yang merepresentasikan tiket perjalanan kereta api.

public class Ticket implements PrintableInfo {
    //ATRIBUT
    private String ticketId;
    private String seatNumber;
    private Schedule schedule;
    private Passenger passenger;
    private PaymentRecord paymentRecord;

    //METHOD
    public Ticket() {
        this.ticketId = "";
        this.seatNumber = "";
        this.schedule = null;
        this.passenger = null;
        this.paymentRecord = new PaymentRecord("UNPAID");
    }

    public Ticket(String ticketId, String seatNumber, Schedule schedule, Passenger passenger) {
        this.ticketId = ticketId;
        this.seatNumber = seatNumber;
        this.schedule = schedule;
        this.passenger = passenger;
        this.paymentRecord = new PaymentRecord("UNPAID");
    }

    public String getTicketId() {
        return ticketId;
    }

    public void setTicketId(String ticketId) {
        this.ticketId = ticketId;
    }

    public String getSeatNumber() {
        return seatNumber;
    }

    public void setSeatNumber(String seatNumber) {
        this.seatNumber = seatNumber;
    }

    public Schedule getSchedule() {
        return schedule;
    }

    public void setSchedule(Schedule schedule) {
    this.schedule = schedule;
    }

    public Passenger getPassenger() {
        return passenger;
    }

    public PaymentRecord getPaymentRecord() {
        return paymentRecord;
    }

    public void setPaymentRecord(PaymentRecord paymentRecord) {
        this.paymentRecord = paymentRecord;
    }

    public void generateTicket() throws InvalidBookingException {
    if (passenger == null) {
        throw new InvalidBookingException("Penumpang belum diisi.");
    }

    if (schedule == null) {
        throw new InvalidBookingException("Jadwal belum dipilih.");
    }

    if (seatNumber == null || seatNumber.isEmpty()) {
        throw new InvalidBookingException("Nomor kursi tidak valid.");
    }

    System.out.println("Tiket Berhasil Diterbitkan untuk: " + passenger.getNamaLengkap());
}

    @Override
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
        System.out.println("\n--- Data Pembayaran ---");
        paymentRecord.printInfo();
        System.out.println("==================================");
    }
}