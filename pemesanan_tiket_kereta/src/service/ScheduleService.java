/* Nama File    : ScheduleService.java
 * Deskripsi    : Kelas layanan untuk manajemen jadwal
 * Tanggal      : 23 Maret 2026
 */
package service;

import model.Schedule;
import exception.ScheduleConflictException;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

/**
 * Kelas layanan yang mengelola data master jadwal perjalanan kereta api.
 */
public class ScheduleService {
	/************ATRIBUT************/
    private List<Schedule> masterJadwal;

	/************METHOD************/
    // Membuat service jadwal dengan data master kosong.
    public ScheduleService() {
        this.masterJadwal = new ArrayList<>();
    }

    // Menambahkan jadwal baru jika tidak bentrok dengan jadwal kereta yang sama.
    public void addSchedule(Schedule s) throws ScheduleConflictException {
        if (s == null) {
            throw new IllegalArgumentException("Jadwal tidak boleh null");
        }

        if (s.getTrain() == null || s.getDepartureTime() == null || s.getArrivalTime() == null) {
            throw new IllegalArgumentException("Data jadwal belum lengkap");
        }

        for (Schedule existing : masterJadwal) {
            if (existing.getTrain().getIdTrain().equals(s.getTrain().getIdTrain())) {
                if (s.getDepartureTime().isBefore(existing.getArrivalTime()) && 
                    s.getArrivalTime().isAfter(existing.getDepartureTime())) {
                    throw new ScheduleConflictException("Kereta " + s.getTrain().getNamaTrain() + " sudah memiliki jadwal di waktu tersebut!");
                }
            }
        }
        this.masterJadwal.add(s);
    }

    // Mencari jadwal berdasarkan ID jadwal.
    public Schedule cariJadwalById(String idSchedule) {
        if (idSchedule == null || idSchedule.trim().isEmpty()) {
            return null;
        }

        return masterJadwal.stream()
                .filter(s -> s.getScheduleId().equals(idSchedule))
                .findFirst()
                .orElse(null);
    }

    // Mencari jadwal berdasarkan kota asal dan kota tujuan.
    public List<Schedule> cariJadwal(String kotaAsal, String kotaTujuan) {
        if (kotaAsal == null || kotaTujuan == null) {
            return new ArrayList<>();
        }

        return masterJadwal.stream()
                .filter(s -> s.getDepartureStasion().getKota().equalsIgnoreCase(kotaAsal) &&
                             s.getArrivalStasion().getKota().equalsIgnoreCase(kotaTujuan))
                .collect(Collectors.toList());
    }

    // Mencari jadwal berdasarkan kota asal, kota tujuan, dan tanggal berangkat.
    public List<Schedule> cariJadwal(String kotaAsal, String kotaTujuan, LocalDate tanggalBerangkat) {
        if (kotaAsal == null || kotaTujuan == null || tanggalBerangkat == null) {
            return new ArrayList<>();
        }

        return masterJadwal.stream()
                .filter(s -> s.getDepartureStasion().getKota().equalsIgnoreCase(kotaAsal) &&
                             s.getArrivalStasion().getKota().equalsIgnoreCase(kotaTujuan) &&
                             s.getDepartureTime().toLocalDate().equals(tanggalBerangkat))
                .collect(Collectors.toList());
    }

    // Mencari jadwal berdasarkan kota atau nama stasiun tujuan.
    public List<Schedule> searchSchedule(String tujuan) {
        if (tujuan == null) {
            return new ArrayList<>();
        }

        return masterJadwal.stream()
                .filter(s -> s.getArrivalStasion().getKota().equalsIgnoreCase(tujuan) ||
                             s.getArrivalStasion().getNamaStasion().equalsIgnoreCase(tujuan))
                .collect(Collectors.toList());
    }

    // Mencari jadwal berdasarkan asal dan tujuan (kota atau nama stasiun).
    public List<Schedule> searchSchedule(String asal, String tujuan) {
        if (asal == null || tujuan == null) {
            return new ArrayList<>();
        }

        return masterJadwal.stream()
                .filter(s -> (s.getDepartureStasion().getKota().equalsIgnoreCase(asal) ||
                              s.getDepartureStasion().getNamaStasion().equalsIgnoreCase(asal)) &&
                             (s.getArrivalStasion().getKota().equalsIgnoreCase(tujuan) ||
                              s.getArrivalStasion().getNamaStasion().equalsIgnoreCase(tujuan)))
                .collect(Collectors.toList());
    }

    // Mencari jadwal berdasarkan asal, tujuan, dan tanggal berangkat.
    public List<Schedule> searchSchedule(String asal, String tujuan, LocalDate tanggalBerangkat) {
        if (asal == null || tujuan == null || tanggalBerangkat == null) {
            return new ArrayList<>();
        }

        return masterJadwal.stream()
                .filter(s -> (s.getDepartureStasion().getKota().equalsIgnoreCase(asal) ||
                              s.getDepartureStasion().getNamaStasion().equalsIgnoreCase(asal)) &&
                             (s.getArrivalStasion().getKota().equalsIgnoreCase(tujuan) ||
                              s.getArrivalStasion().getNamaStasion().equalsIgnoreCase(tujuan)) &&
                             s.getDepartureTime().toLocalDate().equals(tanggalBerangkat))
                .collect(Collectors.toList());
    }

    // Mengambil salinan daftar master jadwal agar data internal tetap aman.
    public List<Schedule> getMasterJadwal() {
        return new ArrayList<>(masterJadwal);
    }
}
