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
        this.idSchedule = "";
        this.train = null;
        this.stationAsal = null;
        this.stationTujuan = null;
        this.tanggalBerangkat = null;
    }

    public Schedule(String idSchedule, Train train, Station stationAsal, Station stationTujuan, LocalDate tanggalBerangkat) {
        this.idSchedule = idSchedule;
        this.train = train;  // Agregasi: Train dapat hidup mandiri
        this.stationAsal = stationAsal;  // Agregasi: Station asal dapat hidup mandiri
        this.stationTujuan = stationTujuan;  // Agregasi: Station tujuan dapat hidup mandiri
        this.tanggalBerangkat = tanggalBerangkat;
    }

    public String getIdSchedule() {
        return idSchedule;
    }

    public void setIdSchedule(String idSchedule) {
        this.idSchedule = idSchedule;
    }

    public Train getTrain() {
        return train;
    }

    public void setTrain(Train train) {
        this.train = train;
    }

    public Station getStationAsal() {
        return stationAsal;
    }

    public void setStationAsal(Station stationAsal) {
        this.stationAsal = stationAsal;
    }

    public Station getStationTujuan() {
        return stationTujuan;
    }

    public void setStationTujuan(Station stationTujuan) {
        this.stationTujuan = stationTujuan;
    }

    public LocalDate getTanggalBerangkat() {
        return tanggalBerangkat;
    }

    public void setTanggalBerangkat(LocalDate tanggalBerangkat) {
        this.tanggalBerangkat = tanggalBerangkat;
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
        if (train != null && stationAsal != null && stationTujuan != null) {
            System.out.println("ID Schedule: " + idSchedule);
            System.out.println("Kereta: " + train.getNamaTrain());
            System.out.println("Dari: " + stationAsal.getNama() + " -> Ke: " + stationTujuan.getNama());
            System.out.println("Tanggal: " + tanggalBerangkat);
        }
    }
}
