/* Nama File    : ScheduleService.java
 * Deskripsi    : Layanan untuk mengelola dan mencari jadwal perjalanan
 * Tanggal      : 23 Maret 2026
 */

package service;

import model.Schedule;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import exception.ScheduleConflictException;

/**
 * Kelas service untuk menyimpan master jadwal dan menyediakan operasi pencarian.
 * Semua fitur pencarian jadwal dipusatkan di sini (bukan di class model Schedule).
 */
public class ScheduleService {
    /************ATRIBUT************/
    // List ini berperan seperti tabel jadwal 
    private List<Schedule> masterJadwal = new ArrayList<>();

    /************METHOD************/
    public void addSchedule(Schedule s) throws ScheduleConflictException {
        if (s == null) {
            throw new IllegalArgumentException("Schedule tidak boleh null");
        }
        if (s.getStationAsal() == null || s.getStationTujuan() == null || s.getTanggalBerangkat() == null) {
            throw new IllegalArgumentException("Station asal/tujuan dan tanggal berangkat wajib diisi");
        }
        List<Schedule> existing = searchSchedule(
                s.getStationAsal().getNamaStasiun(),
                s.getStationTujuan().getNamaStasiun(),
                s.getTanggalBerangkat());
        if (!existing.isEmpty()) {
            throw new ScheduleConflictException("Jadwal sudah terisi dengan keberangkatan kereta lain");
        }
        masterJadwal.add(s);
    }

    // --- IMPLEMENTASI METHOD OVERLOADING ---

    // ======= Pindahan dari Schedule (skeleton) =======
    public Schedule cariJadwalById(String idSchedule) {
        if (idSchedule == null || idSchedule.isBlank()) {
            throw new IllegalArgumentException("idSchedule tidak boleh kosong");
        }
        assert !idSchedule.isBlank() : "idSchedule harus terisi";
        // Skeleton method: boundary checks saja.
        throw new UnsupportedOperationException("cariJadwalById belum diimplementasikan");
    }

    public Schedule cariJadwal(String kotaAsal, String kotaTujuan) {
        if (kotaAsal == null || kotaAsal.isBlank() || kotaTujuan == null || kotaTujuan.isBlank()) {
            throw new IllegalArgumentException("kotaAsal dan kotaTujuan tidak boleh kosong");
        }
        assert !kotaAsal.isBlank() && !kotaTujuan.isBlank() : "kotaAsal/kotaTujuan harus terisi";
        // Skeleton method: boundary checks saja.
        throw new UnsupportedOperationException("cariJadwal belum diimplementasikan");
    }

    public Schedule cariJadwal(String kotaAsal, String kotaTujuan, LocalDate tanggalBerangkat) {
        if (kotaAsal == null || kotaAsal.isBlank() || kotaTujuan == null || kotaTujuan.isBlank() || tanggalBerangkat == null) {
            throw new IllegalArgumentException("kotaAsal, kotaTujuan, dan tanggalBerangkat wajib diisi");
        }
        assert tanggalBerangkat != null : "tanggalBerangkat wajib diisi";
        // Skeleton method: boundary checks saja.
        throw new UnsupportedOperationException("cariJadwal belum diimplementasikan");
    }

    // Cari berdasarkan stasiun tujuan saja
    public List<Schedule> searchSchedule(String tujuan) {
        if (tujuan == null || tujuan.isBlank()) {
            throw new IllegalArgumentException("Tujuan tidak boleh kosong");
        }
        List<Schedule> hasil = new ArrayList<>();
        for (Schedule s : masterJadwal) {
            if (s.getStationTujuan() != null && s.getStationTujuan().getNamaStasiun().equalsIgnoreCase(tujuan)) {
                hasil.add(s);
            }
        }
        return hasil;
    }

    // Cari berdasarkan asal DAN tujuan (Overloading)
    public List<Schedule> searchSchedule(String asal, String tujuan) {
        if (asal == null || asal.isBlank() || tujuan == null || tujuan.isBlank()) {
            throw new IllegalArgumentException("Asal dan tujuan tidak boleh kosong");
        }
        List<Schedule> hasil = new ArrayList<>();
        for (Schedule s : masterJadwal) {
            if (s.getStationAsal() != null && s.getStationTujuan() != null
                    && s.getStationAsal().getNamaStasiun().equalsIgnoreCase(asal)
                    && s.getStationTujuan().getNamaStasiun().equalsIgnoreCase(tujuan)) {
                hasil.add(s);
            }
        }
        return hasil;
    }

    // Cari berdasarkan asal, tujuan, dan tanggal (Overloading)
    public List<Schedule> searchSchedule(String asal, String tujuan, java.time.LocalDate tanggalBerangkat) {
        if (asal == null || asal.isBlank() || tujuan == null || tujuan.isBlank() || tanggalBerangkat == null) {
            throw new IllegalArgumentException("Asal, tujuan, dan tanggal berangkat wajib diisi");
        }
        List<Schedule> hasil = new ArrayList<>();
        for (Schedule s : masterJadwal) {
            if (s.getStationAsal() != null && s.getStationTujuan() != null && s.getTanggalBerangkat() != null
                    && s.getStationAsal().getNamaStasiun().equalsIgnoreCase(asal)
                    && s.getStationTujuan().getNamaStasiun().equalsIgnoreCase(tujuan)
                    && s.getTanggalBerangkat().equals(tanggalBerangkat)) {
                hasil.add(s);
            }
        }
        return hasil;
    }
}