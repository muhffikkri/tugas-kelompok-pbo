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

/**
 * Kelas utama untuk menjalankan simulasi alur pemesanan dari awal hingga akhir.
 *
 * TODO Tim:
 * 1. Susun skenario simulasi normal dan skenario gagal.
 * 2. Inisialisasi objek model dan service sesuai flow sistem.
 * 3. Isi proses pencarian jadwal, booking, dan pembayaran.
 * 4. Pastikan penanganan exception terstruktur.
 */
public class RailwayApp {
    /************ATRIBUT************/

    /************METHOD************/
    public static void main(String[] args) {
        try {
            System.out.println("===== SIMULASI NORMAL =====");
            simulateNormalBookingFlow();

            System.out.println("\n===== SIMULASI GAGAL =====");
            simulateFailureFlow();
        } catch (InvalidNIKException e) {
            System.err.println("[ERROR NIK] " + e.getMessage());
        } catch (SeatAlreadyBookedException e) {
            System.err.println("[ERROR KURSI] " + e.getMessage());
        } catch (InvalidBookingException e) {
            System.err.println("[ERROR BOOKING] " + e.getMessage());
        } catch (ScheduleConflictException e) {
            System.err.println("[ERROR JADWAL] " + e.getMessage());
        } catch (Exception e) {
            System.err.println("[ERROR UMUM] " + e.getMessage());
            e.printStackTrace();
        }
    }

    private static void simulateNormalBookingFlow()
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

    private static void simulateFailureFlow() {
        // 1) Gagal validasi NIK
        try {
            new Passenger("Salah NIK", "12345", "0800000000", "gagal@mail.com", "PS002");
        } catch (InvalidNIKException e) {
            System.out.println("[EXPECTED] InvalidNIKException: " + e.getMessage());
        }

        // 2) Gagal booking karena kursi sudah dibooking
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

            bookSeatOrThrowAlreadyBooked(jadwal, 1);
            bookSeatOrThrowAlreadyBooked(jadwal, 1);
        } catch (SeatAlreadyBookedException e) {
            System.out.println("[EXPECTED] SeatAlreadyBookedException: " + e.getMessage());
        }

        // 3) Gagal generate tiket karena data booking tidak valid
        try {
            Ticket invalidTicket = new Ticket();
            invalidTicket.generateTicket();
        } catch (InvalidBookingException e) {
            System.out.println("[EXPECTED] InvalidBookingException: " + e.getMessage());
        }
    }

    private static void bookSeatOrThrowAlreadyBooked(Schedule schedule, int seatIndex) throws SeatAlreadyBookedException {
        try {
            schedule.bookSeat(seatIndex);
        } catch (SeatUnavailableException e) {
            throw new SeatAlreadyBookedException("Kursi nomor " + (seatIndex + 1) + " sudah dipesan/tidak tersedia.");
        }
    }
}