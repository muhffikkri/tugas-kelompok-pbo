/* Nama File    : Passenger.java
 * Deskripsi    : Kelas turunan Person untuk data penumpang
 * Tanggal      : 23 Maret 2026
 */
package model;

import exception.InvalidNIKException;
import java.util.ArrayList;
import java.util.List;

/**
 * Merepresentasikan penumpang kereta sebagai turunan dari Person.
 */
public class Passenger extends Person {
	/************ATRIBUT************/
    private String passengerId;
    private String email;
    private List<Ticket> tickets;

	/************METHOD************/
    // Menginisialisasi data penumpang dengan nilai default.
    public Passenger() {
        super();
        this.passengerId = "";
        this.email = "";
        this.tickets = new ArrayList<>();
    }

    // Menginisialisasi data penumpang dengan data lengkap.
    public Passenger(String namaLengkap, String nik, String noTelp, String email, String passengerId) throws InvalidNIKException {
        super(namaLengkap, nik, noTelp);
        this.passengerId = passengerId;
        this.email = (email == null) ? "" : email;
        this.tickets = new ArrayList<>();
    }

    // Mengambil ID unik penumpang.
    public String getPassengerId() {
        return passengerId;
    }

    // Mengatur ID unik penumpang.
    public void setPassengerId(String passengerId) {
        this.passengerId = (passengerId == null) ? "" : passengerId;
    }

    // Mengambil email penumpang.
    public String getEmail() {
        return email;
    }

    // Mengatur email penumpang.
    public void setEmail(String email) {
        this.email = (email == null) ? "" : email;
    }

    // Mengambil salinan daftar tiket milik penumpang.
    public List<Ticket> getTickets() {
        return new ArrayList<>(tickets);
    }

    // Mengatur daftar tiket penumpang dengan salinan data baru.
    public void setTickets(List<Ticket> tickets) {
        this.tickets = (tickets == null) ? new ArrayList<>() : new ArrayList<>(tickets);
    }

    // Membuat objek tiket baru yang terhubung ke jadwal dan penumpang ini.
    public Ticket bookTickets(Schedule s) {
        if (s == null) {
            throw new IllegalArgumentException("Jadwal tidak boleh null");
        }

        Ticket t = new Ticket();
        t.setSchedule(s);
        t.setPassenger(this);
        this.tickets.add(t);
        return t;
    }

    // Membatalkan tiket berdasarkan ID tiket milik penumpang.
    public void cancelTicket(String ticketId) {
        if (ticketId == null || ticketId.trim().isEmpty()) {
            return;
        }

        this.tickets.removeIf(t -> {
            if (!ticketId.equals(t.getTicketId())) {
                return false;
            }

            Schedule schedule = t.getSchedule();
            int seatIndex = parseSeatIndex(t.getSeatNumber());
            if (schedule != null && seatIndex >= 0) {
                schedule.releaseSeat(seatIndex);
            }
            return true;
        });
    }

    // Mengonversi format kursi (mis. A6) menjadi indeks kursi berbasis nol.
    private int parseSeatIndex(String seatNumber) {
        if (seatNumber == null) {
            return -1;
        }

        String digits = seatNumber.replaceAll("[^0-9]", "");
        if (digits.isEmpty()) {
            return -1;
        }

        int seatNo = Integer.parseInt(digits);
        return (seatNo > 0) ? seatNo - 1 : -1;
    }

    @Override
    // Menampilkan informasi penumpang dan jumlah tiket aktif.
    public void printInfo() {
        System.out.println("ID Penumpang: " + passengerId);
        System.out.println("Nama Penumpang: " + getNamaLengkap());
        System.out.println("NIK: " + getNik());
        System.out.println("No. Telepon: " + getNoTelp());
        System.out.println("Email: " + email);
        System.out.println("Jumlah Tiket: " + tickets.size());
    }
}
