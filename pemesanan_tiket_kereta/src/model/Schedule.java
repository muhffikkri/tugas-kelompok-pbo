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
 * RELASI AGREGASI:
 * ================
 * Schedule <>----- Train       (weak ownership - Train mandiri)
 * Schedule <>----- Station     (weak ownership - Station mandiri)
 *
 * TODO :
 * 1. Pastikan relasi agregasi terdokumentasi di class diagram.
 * 2. Implement method overloading pencarian jadwal.
 * 3. Lengkapi constructor, getter, setter, dan validasi tanggal.
 * 4. Uji pencarian jadwal berdasarkan beberapa kombinasi parameter.
 */
public class Schedule implements PrintableInfo {
    /****** RELASI AGREGASI (WEAK OWNERSHIP) ******
     * 
    *    Schedule
    *       <> (diamond = agregasi/weak ownership)
    *   +-----------+------------+
    *   |           |            |
    *   v           v            v
    *  Train     Station(Asal) Station(Tujuan)
     * 
     * Ciri Agregasi:
     * - Child (Train, Station) bisa HIDUP MANDIRI
     * - Parent (Schedule) hanya REFERENSI, tidak CREATE
     * - Jika Schedule dihapus, Train/Station TETAP ADA
     * - 1 Train/Station bisa pakai di MULTIPLE Schedule
     *********************************************/
    
    /************ATRIBUT************/
    private String idSchedule;
    
    /****** AGREGASI TRAIN ******
     * 
    * <> AGREGASI -> Train
     * 
     * Parent: Schedule
     * Child: Train
     * 
     * Ciri Agregasi (Weak Ownership):
     * 1. Train TETAP HIDUP MANDIRI (tidak diciptakan Schedule)
     * 2. Schedule hanya REFERENSI/MENGGUNAKAN Train yang sudah ada
     * 3. Jika Schedule dihapus → Train TETAP ADA (tidak orphaned)
     * 4. 1 Train bisa dipakai di MULTIPLE Schedule
     * 5. Train bisa exist TANPA Schedule
     *****************************/
    /** <> AGREGASI: Train dapat hidup mandiri (digunakan di multiple schedule) */
    private Train train;
    
    /****** AGREGASI STATION ASAL ******
     * 
    * <> AGREGASI -> Station Asal
     * 
     * Parent: Schedule
     * Child: Station (Asal)
     * 
     * Ciri Agregasi (Weak Ownership):
     * 1. Station Asal TETAP HIDUP MANDIRI (tidak diciptakan Schedule)
     * 2. Schedule hanya REFERENSI/MENGGUNAKAN Station yang sudah ada
     * 3. Jika Schedule dihapus → Station Asal TETAP ADA
     * 4. 1 Station bisa dipakai di MULTIPLE Schedule
     * 5. Station bisa exist TANPA Schedule
     *****************************/
    /** <> AGREGASI: Station asal dapat hidup mandiri (digunakan di multiple schedule) */
    private Station stationAsal;
    
    /****** AGREGASI STATION TUJUAN ******
     * 
    * <> AGREGASI -> Station Tujuan
     * 
     * Parent: Schedule
     * Child: Station (Tujuan)
     * 
     * Ciri Agregasi (Weak Ownership):
     * 1. Station Tujuan TETAP HIDUP MANDIRI (tidak diciptakan Schedule)
     * 2. Schedule hanya REFERENSI/MENGGUNAKAN Station yang sudah ada
     * 3. Jika Schedule dihapus → Station Tujuan TETAP ADA
     * 4. 1 Station bisa dipakai di MULTIPLE Schedule
     * 5. Station bisa exist TANPA Schedule
     *****************************/
    /** <> AGREGASI: Station tujuan dapat hidup mandiri (digunakan di multiple schedule) */
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
        this.train = train;
        this.stationAsal = stationAsal;
        this.stationTujuan = stationTujuan;
        
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

    @Override
    public void printInfo() {
        if (train != null && stationAsal != null && stationTujuan != null) {
            System.out.println("ID Schedule: " + idSchedule);
            System.out.println("Kereta: " + train.getNamaKereta());
            System.out.println("Dari: " + stationAsal.getNamaStasiun() + " -> Ke: " + stationTujuan.getNamaStasiun());
            System.out.println("Tanggal: " + tanggalBerangkat);
        }
    }
}
