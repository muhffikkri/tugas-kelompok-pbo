/* Nama File    : Schedule.java
 * Deskripsi    : Kelas untuk data jadwal
 * Tanggal      : 23 Maret 2026
 */
package model;

import service.PrintableInfo;
import exception.SeatUnavailableException;
import java.time.LocalDateTime;
import java.time.Duration;

/** 
 * Kelas yang merepresentasikan jadwal perjalanan kereta api. 
 */
public class Schedule implements PrintableInfo {
    /************ATRIBUT************/
    private String scheduleId;
    private Train train;
    private Stasion departureStasion;
    private Stasion arrivalStasion;
    private LocalDateTime departureTime;
    private LocalDateTime arrivalTime;
    private boolean[] seats;

	/************METHOD************/
    // Menginisialisasi jadwal dengan nilai default.
    public Schedule() {
        this.scheduleId = "";
        this.train = null;
        this.departureStasion = null;
        this.arrivalStasion = null;
        this.departureTime = LocalDateTime.now();
        this.arrivalTime = LocalDateTime.now();
        this.seats = new boolean[0];
    }

    // Menginisialisasi jadwal beserta alokasi kursi berdasarkan kapasitas kereta.
    public Schedule(String scheduleId, Train train, Stasion departureStasion, Stasion arrivalStasion, LocalDateTime departureTime, LocalDateTime arrivalTime) {
        if (scheduleId == null || scheduleId.trim().isEmpty()) {
            throw new IllegalArgumentException("ID jadwal tidak boleh kosong");
        }
        if (train == null) {
            throw new IllegalArgumentException("Kereta tidak boleh null");
        }
        if (departureStasion == null || arrivalStasion == null) {
            throw new IllegalArgumentException("Stasiun asal dan tujuan tidak boleh null");
        }
        if (departureTime == null || arrivalTime == null) {
            throw new IllegalArgumentException("Waktu berangkat/tiba tidak boleh null");
        }
        if (arrivalTime.isBefore(departureTime)) {
            throw new IllegalArgumentException(
                "Waktu tiba tidak boleh sebelum waktu berangkat"
            );
        }
        this.scheduleId = scheduleId;
        this.train = train;
        this.departureStasion = departureStasion;
        this.arrivalStasion = arrivalStasion;
        this.departureTime = departureTime;
        this.arrivalTime = arrivalTime;
        int kapasitas = train.getKapasitas();
        this.seats = new boolean[kapasitas];
        for (int i = 0; i < kapasitas; i++) {
            this.seats[i] = true; 
        }
    }

    // Mengambil ID jadwal.
    public String getScheduleId() {
        return scheduleId;
    }

    // Mengatur ID jadwal agar tidak kosong.
    public void setScheduleId(String scheduleId) {
        if (scheduleId == null || scheduleId.trim().isEmpty()) {
            throw new IllegalArgumentException("ID jadwal tidak boleh kosong");
        }
        this.scheduleId = scheduleId;
    }

    // Mengambil data kereta pada jadwal.
    public Train getTrain() {
        return train;
    }

    // Mengatur data kereta dengan validasi tidak null.
    public void setTrain(Train train) {
        if (train == null) {
            throw new IllegalArgumentException("Kereta tidak boleh null");
        }
        this.train = train;
    }

    // Mengambil stasiun keberangkatan.
    public Stasion getDepartureStasion() {
        return departureStasion;
    }

    // Mengatur stasiun keberangkatan dengan validasi tidak null.
    public void setDepartureStasion(Stasion departureStasion) {
        if (departureStasion == null) {
            throw new IllegalArgumentException("Stasiun asal tidak boleh null");
        }
        this.departureStasion = departureStasion;
    }

    // Mengambil stasiun tujuan.
    public Stasion getArrivalStasion() {
        return arrivalStasion;
    }

    // Mengatur stasiun tujuan dengan validasi tidak null.
    public void setArrivalStasion(Stasion arrivalStasion) {
        if (arrivalStasion == null) {
            throw new IllegalArgumentException("Stasiun tujuan tidak boleh null");
        }
        this.arrivalStasion = arrivalStasion;
    }

    // Mengambil waktu keberangkatan kereta.
    public LocalDateTime getDepartureTime() {
        return departureTime;
    }

    // Mengatur waktu keberangkatan dengan validasi urutan waktu.
    public void setDepartureTime(LocalDateTime departureTime) {
        if (departureTime == null) {
            throw new IllegalArgumentException("Waktu berangkat tidak boleh null");
        }
        if (arrivalTime != null && arrivalTime.isBefore(departureTime)) {
            throw new IllegalArgumentException("Waktu berangkat tidak valid");
        }
        this.departureTime = departureTime;
    }

    // Mengambil waktu kedatangan kereta.
    public LocalDateTime getArrivalTime() {
        return arrivalTime;
    }

    // Mengatur waktu kedatangan dengan validasi urutan waktu.
    public void setArrivalTime(LocalDateTime arrivalTime) {
        if (arrivalTime == null) {
            throw new IllegalArgumentException("Waktu tiba tidak boleh null");
        }
        if (departureTime != null && arrivalTime.isBefore(departureTime)) {
            throw new IllegalArgumentException("Waktu tiba tidak valid");
        }
        this.arrivalTime = arrivalTime;
    }

    // Menghitung durasi perjalanan dalam satuan menit.
    public long getDuration() {
        if (departureTime != null && arrivalTime != null) {
            return Duration.between(departureTime, arrivalTime).toMinutes();
        }
        return 0;
    }

    // Mengambil salinan status ketersediaan seluruh kursi.
    public boolean[] getSeats() {
        return seats.clone();
    }

    // Mengatur status kursi dengan menyalin data agar aman dari mutasi eksternal.
    public void setSeats(boolean[] seats) {
        if (seats == null) {
            throw new IllegalArgumentException("Data kursi tidak boleh null");
        }
        this.seats = seats.clone();
    }

    // Menghitung jumlah kursi yang masih tersedia.
    public int getAvailableSeat() {
        int count = 0;
        for (boolean s : seats) {
            if (s) count++;
        }
        return count;
    }

    // Menghitung jumlah kursi yang sudah terisi.
    public int getBookedSeat() {
        return seats.length - getAvailableSeat();
    }

    // Memesan kursi tertentu berdasarkan indeks jika masih tersedia.
    public void bookSeat(int seatIndex) throws SeatUnavailableException {
        if (seatIndex < 0 || seatIndex >= seats.length || !seats[seatIndex]) {
            throw new SeatUnavailableException("Kursi tidak tersedia!");
        }
        seats[seatIndex] = false;
    }

    // Memesan kursi pertama yang tersedia secara otomatis.
    public int bookFirstAvailableSeat() throws SeatUnavailableException {
        for (int i = 0; i < seats.length; i++) {
            if (seats[i]) {
                seats[i] = false;
                return i;
            }
        }
        throw new SeatUnavailableException("Kursi sudah habis!");
    }

    // Membatalkan pemesanan kursi tertentu agar tersedia kembali.
    public void releaseSeat(int seatIndex) {
        if (seatIndex < 0 || seatIndex >= seats.length) {
            throw new IllegalArgumentException("Indeks kursi tidak valid");
        }
        seats[seatIndex] = true;
    }

    @Override
    // Menampilkan informasi jadwal dan status kursi ke konsol.
    public void printInfo() {
        System.out.println("ID Jadwal: " + scheduleId);
        if (train != null) System.out.println("Kereta: " + train.getNamaTrain());
        if (departureStasion != null) System.out.println("Stasiun Awal: " + departureStasion.getNamaStasion() + " (" + departureStasion.getKota() + ")");
        if (arrivalStasion != null) System.out.println("Stasiun Tujuan: " + arrivalStasion.getNamaStasion() + " (" + arrivalStasion.getKota() + ")");
        System.out.println("Waktu Berangkat: " + departureTime);
        System.out.println("Waktu Tiba: " + arrivalTime);
        System.out.println("Durasi: " + getDuration() + " menit");
        System.out.println("Kursi Tersedia: " + getAvailableSeat());
        System.out.println("Kursi Terisi: " + getBookedSeat());
    }
}
