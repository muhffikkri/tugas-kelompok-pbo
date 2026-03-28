/* Nama File    : RailwayApp.java
 * Deskripsi    : Entry point simulasi alur pemesanan tiket kereta
 * Tanggal      : 23 Maret 2026
 */

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;

import exception.InvalidBookingException;
import exception.InvalidNIKException;
import exception.ScheduleConflictException;
import exception.SeatAlreadyBookedException;
import exception.SeatUnavailableException;
import model.EconomyTrain;
import model.Passenger;
import model.Schedule;
import model.Stasion;
import model.Ticket;
import model.Train;
import service.DigitalPayment;
import service.ScheduleService;

public class RailwayApp {
    /************ATRIBUT************/

    /************METHOD************/
    public static void main(String[] args) {
        try {
            System.out.println("===== SKENARIO BERHASIL (1) =====");
            scenarioBerhasil();

            System.out.println("\n===== SKENARIO EXCEPTION (5) =====");
            scenarioInvalidNIK();
            scenarioScheduleConflict();
            scenarioSeatAlreadyBooked();
            scenarioSeatUnavailable();
            scenarioInvalidBooking();
        } catch (Exception e) {
            System.err.println("[ERROR UMUM] " + e.getMessage());
            e.printStackTrace();
        }
    }

    private static void scenarioBerhasil()
            throws InvalidNIKException, InvalidBookingException, ScheduleConflictException, SeatAlreadyBookedException {
        // Inisialisasi data master
        Stasion gambir = new Stasion("ST001", "Gambir", "Jakarta");
        Stasion bandung = new Stasion("ST002", "Bandung", "Bandung");

        Train ekonomi = new EconomyTrain("TR001", "Argo Parahyangan", 120, 20, 0.10);
        ekonomi.setTarifDasar(150_000);

        ScheduleService scheduleService = new ScheduleService();
        Schedule jadwal1 = new Schedule(
                "SCH001",
                ekonomi,
                gambir,
                bandung,
                LocalDateTime.now().plusDays(1).withHour(8).withMinute(0).withSecond(0).withNano(0),
                LocalDateTime.now().plusDays(1).withHour(11).withMinute(0).withSecond(0).withNano(0));
        scheduleService.addSchedule(jadwal1);

        // Pencarian jadwal
        List<Schedule> hasilCari = scheduleService.searchSchedule("Jakarta", "Bandung", LocalDate.now().plusDays(1));
        if (hasilCari.isEmpty()) {
            throw new InvalidBookingException("Jadwal tidak ditemukan untuk rute Jakarta-Bandung.");
        }

        Schedule jadwalDipilih = hasilCari.get(0);
        System.out.println("Jadwal ditemukan: " + jadwalDipilih.getScheduleId() + " - " + jadwalDipilih.getTrain().getNamaTrain());

        // Booking penumpang
        Passenger passenger = new Passenger("Budi Santoso", "1234567890123456", "081234567890", "budi@mail.com", "PS001");
        int seatIndex = 5;
        bookSeatOrThrowAlreadyBooked(jadwalDipilih, seatIndex);

        Ticket tiket = new Ticket("TK001", "A" + (seatIndex + 1), jadwalDipilih, passenger);
        tiket.generateTicket();

        // Pembayaran
        DigitalPayment payment = new DigitalPayment("QRIS", tiket.getPaymentRecord());
        payment.processPayment(jadwalDipilih.getTrain().hitungTarif());

        System.out.println("Status pembayaran: " + tiket.getPaymentRecord().getStatus());
        tiket.printInfo();
    }

    // 1) InvalidNIKException
    private static void scenarioInvalidNIK() {
        try {
            String nama = "Salah NIK";
            String nik = "12345";
            String noTelp = "0800000000";
            String email = "gagal@mail.com";
            String passengerId = "PS002";

            System.out.println("- Input InvalidNIK: nama=" + nama + ", nik=" + nik + ", noTelp=" + noTelp + ", email=" + email + ", passengerId=" + passengerId);
            new Passenger(nama, nik, noTelp, email, passengerId);
        } catch (InvalidNIKException e) {
            System.out.println("[1/5] InvalidNIKException: " + e.getMessage());
        }
    }

    // 2) ScheduleConflictException
    private static void scenarioScheduleConflict() throws InvalidNIKException {
        try {
            Stasion gambir = new Stasion("ST011", "Gambir", "Jakarta");
            Stasion cirebon = new Stasion("ST012", "Cirebon", "Cirebon");

            Train kereta = new EconomyTrain("TR011", "Ciremai", 80, 20, 0.05);
            kereta.setTarifDasar(100_000);

            ScheduleService scheduleService = new ScheduleService();

            Schedule jadwalA = new Schedule(
                    "SC-A",
                    kereta,
                    gambir,
                    cirebon,
                    LocalDateTime.now().plusDays(1).withHour(8).withMinute(0).withSecond(0).withNano(0),
                    LocalDateTime.now().plusDays(1).withHour(10).withMinute(0).withSecond(0).withNano(0));

            Schedule jadwalB = new Schedule(
                    "SC-B",
                    kereta,
                    gambir,
                    cirebon,
                    LocalDateTime.now().plusDays(1).withHour(9).withMinute(0).withSecond(0).withNano(0),
                    LocalDateTime.now().plusDays(1).withHour(11).withMinute(0).withSecond(0).withNano(0));

            scheduleService.addSchedule(jadwalA);
            System.out.println("\n- Input ScheduleConflict: trainId=" + kereta.getIdTrain() + ", jadwalA=08:00-10:00, jadwalB=09:00-11:00 (overlap)");
            scheduleService.addSchedule(jadwalB);
        } catch (ScheduleConflictException e) {
            System.out.println("[2/5] ScheduleConflictException: " + e.getMessage());
        }
    }

    // 3) SeatAlreadyBookedException
    private static void scenarioSeatAlreadyBooked() {
        try {
            Stasion solo = new Stasion("ST003", "Solo Balapan", "Solo");
            Stasion yk = new Stasion("ST004", "Tugu", "Yogyakarta");
            Train kereta = new EconomyTrain("TR002", "Lodaya", 50, 15, 0.05);
            kereta.setTarifDasar(120_000);

            Schedule jadwal = new Schedule(
                    "SCH002",
                    kereta,
                    solo,
                    yk,
                    LocalDateTime.now().plusDays(2).withHour(9).withMinute(0).withSecond(0).withNano(0),
                    LocalDateTime.now().plusDays(2).withHour(11).withMinute(0).withSecond(0).withNano(0));

            System.out.println("\n- Input SeatAlreadyBooked: seatIndex=1 dibooking 2 kali pada jadwal SCH002");
            bookSeatOrThrowAlreadyBooked(jadwal, 1);
            bookSeatOrThrowAlreadyBooked(jadwal, 1);
        } catch (SeatAlreadyBookedException e) {
            System.out.println("[3/5] SeatAlreadyBookedException: " + e.getMessage());
        }
    }

    // 4) SeatUnavailableException
    private static void scenarioSeatUnavailable() {
        try {
            Stasion tegal = new Stasion("ST021", "Tegal", "Tegal");
            Stasion pekalongan = new Stasion("ST022", "Pekalongan", "Pekalongan");
            Train kereta = new EconomyTrain("TR021", "Kaligung", 1, 10, 0.0);
            kereta.setTarifDasar(70_000);

            Schedule jadwal = new Schedule(
                    "SC-U1",
                    kereta,
                    tegal,
                    pekalongan,
                    LocalDateTime.now().plusDays(2).withHour(7).withMinute(0).withSecond(0).withNano(0),
                    LocalDateTime.now().plusDays(2).withHour(8).withMinute(0).withSecond(0).withNano(0));

            System.out.println("\n- Input SeatUnavailable: kapasitas kereta=1, bookFirstAvailableSeat() dipanggil 2 kali");
            jadwal.bookFirstAvailableSeat();
            jadwal.bookFirstAvailableSeat();
        } catch (SeatUnavailableException e) {
            System.out.println("[4/5] SeatUnavailableException: " + e.getMessage());
        }
    }

    // 5) InvalidBookingException
    private static void scenarioInvalidBooking() {
        try {
            Ticket invalidTicket = new Ticket();
            System.out.println("\n- Input InvalidBooking: Ticket default tanpa passenger, schedule, dan seatNumber");
            invalidTicket.generateTicket();
        } catch (InvalidBookingException e) {
            System.out.println("[5/5] InvalidBookingException: " + e.getMessage());
        }
    }

    // Method untuk booking kursi dan melempar exception ketika kursi sudah dibooking
    private static void bookSeatOrThrowAlreadyBooked(Schedule schedule, int seatIndex) throws SeatAlreadyBookedException {
        try {
            schedule.bookSeat(seatIndex);
        } catch (SeatUnavailableException e) {
            throw new SeatAlreadyBookedException("Kursi nomor " + (seatIndex + 1) + " sudah dipesan/tidak tersedia.");
        }
    }
}