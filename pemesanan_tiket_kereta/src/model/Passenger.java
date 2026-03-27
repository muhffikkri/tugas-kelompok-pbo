/* Nama File    : Passenger.java
 * Deskripsi    : Kelas turunan Person untuk data penumpang
 * Tanggal      : 23 Maret 2026
 */
package model;

import exception.InvalidNIKException;
import service.PrintableInfo;
import java.util.ArrayList;
import java.util.List;

// Merepresentasikan penumpang kereta sebagai turunan dari Person.
public class Passenger extends Person {
    //ATRIBUT
    private String passengerId;
    private String email;
    private List<Ticket> tickets;

    //METHOD
    public Passenger() {
        super();
        this.passengerId = "";
        this.email = "";
        this.tickets = new ArrayList<>();
    }

    // Konstruktor lengkap untuk Passenger
    public Passenger(String namaLengkap, String nik, String noTelp, String email, String passengerId) throws InvalidNIKException {
        super(namaLengkap, nik, noTelp);
        this.passengerId = passengerId;
        this.email = email;
        this.tickets = new ArrayList<>();
    }

    public String getPassengerId() {
        return passengerId;
    }

    public void setPassengerId(String passengerId) {
        this.passengerId = passengerId;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public List<Ticket> getTickets() {
        return tickets;
    }

    public void setTickets(List<Ticket> tickets) {
        this.tickets = tickets;
    }

    public Ticket bookTickets(Schedule s) {
        Ticket t = new Ticket();
        t.setSchedule(s);
        t.setPassenger(this);
        this.tickets.add(t);
        return t;
    }

    public void cancelTicket(String ticketId) {
        this.tickets.removeIf(t -> t.getTicketId().equals(ticketId));
    }

    @Override
    public void printInfo() {
        System.out.println("ID Penumpang: " + passengerId);
        System.out.println("Nama Penumpang: " + getNamaLengkap());
        System.out.println("NIK: " + getNik());
        System.out.println("No. Telepon: " + getNoTelp());
        System.out.println("Email: " + email);
        System.out.println("Jumlah Tiket: " + tickets.size());
    }
}
