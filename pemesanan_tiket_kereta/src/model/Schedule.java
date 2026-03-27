/* Nama File    : Schedule.java
 * Deskripsi    : Kelas untuk data jadwal
 * Tanggal      : 23 Maret 2026
 */
package model;
import service.PrintableInfo;
import java.time.LocalDateTime;
import java.time.Duration;

//Kelas yang merepresentasikan jadwal perjalanan kereta api.
public class Schedule implements PrintableInfo {
    //ATRIBUT
    private String scheduleId;
    private Train train;
    private Stasion departureStasion;
    private Stasion arrivalStasion;
    private LocalDateTime departureTime;
    private LocalDateTime arrivalTime;
    private boolean[] seats;

    //METHOD
    public Schedule() {
        this.scheduleId = "";
        this.train = null;
        this.departureStasion = null;
        this.arrivalStasion = null;
        this.departureTime = LocalDateTime.now();
        this.arrivalTime = LocalDateTime.now();
        this.seats = new boolean[0];
    }

    public Schedule(String scheduleId, Train train, Stasion departureStasion, Stasion arrivalStasion, LocalDateTime departureTime, LocalDateTime arrivalTime) {
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
        int kapasitas = train.getKapasitas() ;
        seats = new boolean[kapasitas];
        for (int i = 0; i < kapasitas; i++) {
            this.seats[i] = true; // true artinya tersedia
        }
    }

    public String getScheduleId() {
        return scheduleId;
    }

    public void setScheduleId(String scheduleId) {
        this.scheduleId = scheduleId;
    }

    public Train getTrain() {
        return train;
    }

    public void setTrain(Train train) {
        this.train = train;
    }

    public Stasion getDepartureStasion() {
        return departureStasion;
    }

    public void setDepartureStasion(Stasion departureStasion) {
        this.departureStasion = departureStasion;
    }

    public Stasion getArrivalStasion() {
        return arrivalStasion;
    }

    public void setArrivalStasion(Stasion arrivalStasion) {
        this.arrivalStasion = arrivalStasion;
    }

    public LocalDateTime getDepartureTime() {
        return departureTime;
    }

    public void setDepartureTime(LocalDateTime departureTime) {
        if (arrivalTime != null && arrivalTime.isBefore(departureTime)) {
            throw new IllegalArgumentException("Waktu berangkat tidak valid");
        }
        this.departureTime = departureTime;
    }

    public LocalDateTime getArrivalTime() {
        return arrivalTime;
    }

    public void setArrivalTime(LocalDateTime arrivalTime) {
        if (departureTime != null && arrivalTime.isBefore(departureTime)) {
            throw new IllegalArgumentException("Waktu tiba tidak valid");
        }
        this.arrivalTime = arrivalTime;
    }

    public long getDuration() {
        if (departureTime != null && arrivalTime != null) {
            return Duration.between(departureTime, arrivalTime).toMinutes();
        }
        return 0;
    }

    public boolean[] getSeats() {
        return seats;
    }

    public void setSeats(boolean[] seats) {
        this.seats = seats;
    }

    public int getAvailableSeat() {
        int count = 0;
        for (boolean s : seats) {
            if (s) count++;
        }
        return count;
    }

    public int getBookedSeat() {
        return seats.length - getAvailableSeat();
    }

    //kursi pilih sendiri
    public void bookSeat(int seatIndex) throws exception.SeatUnavailableException {
        if (index < 0 || index >= seats.length || !seats[index]) {
            throw new exception.SeatUnavailableException("Kursi tidak tersedia!");
        }
        seats[index] = false;
    }

    //Kursi dipilih sistem automatis
    public int bookFirstAvailableSeat() throws exception.SeatUnavailableException {
        for (int i = 0; i < seats.length; i++) {
            if (seats[i]) {
                seats[i] = false;
                return i;
            }
        }
        throw new exception.SeatUnavailableException("Kursi sudah habis!");
    }

    @Override
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
