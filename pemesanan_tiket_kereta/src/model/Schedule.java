/* Nama File    : Schedule.java
 * Deskripsi    : Jadwal perjalanan yang berelasi agregasi dengan Train dan Station
 * Tanggal      : 23 Maret 2026
 */
package model;

import java.time.LocalDate;
import service.PrintableInfo;

/**
 * Menyimpan informasi jadwal perjalanan kereta.
 * Kelas ini menerapkan agregasi terhadap Train, Station asal, dan Station tujuan.
 *
 * TODO Tim:
 * 1. Pastikan relasi agregasi terdokumentasi di class diagram.
 * 2. Implement method overloading pencarian jadwal.
 * 3. Lengkapi constructor, getter, setter, dan validasi tanggal.
 * 4. Uji pencarian jadwal berdasarkan beberapa kombinasi parameter.
 */
public class Schedule implements PrintableInfo {
    /************ATRIBUT************/
    private String idSchedule;
    private Train train;
    private Station stationAsal;
    private Station stationTujuan;
    private LocalDate tanggalBerangkat;

    /************METHOD************/
    public Schedule() {
    }

    public Schedule(String idSchedule, Train train, Station stationAsal, Station stationTujuan, LocalDate tanggalBerangkat) {
    }

    public String getIdSchedule() {
        return null;
    }

    public void setIdSchedule(String idSchedule) {
    }

    public Train getTrain() {
        return null;
    }

    public void setTrain(Train train) {
    }

    public Station getStationAsal() {
        return null;
    }

    public void setStationAsal(Station stationAsal) {
    }

    public Station getStationTujuan() {
        return null;
    }

    public void setStationTujuan(Station stationTujuan) {
    }

    public LocalDate getTanggalBerangkat() {
        return null;
    }

    public void setTanggalBerangkat(LocalDate tanggalBerangkat) {
    }

    public Schedule searchSchedule(String idSchedule) {
        return null;
    }

    public Schedule searchSchedule(String kotaAsal, String kotaTujuan) {
        return null;
    }

    public Schedule searchSchedule(String kotaAsal, String kotaTujuan, LocalDate tanggalBerangkat) {
        return null;
    }

    @Override
    public void printInfo() {
    }
}
