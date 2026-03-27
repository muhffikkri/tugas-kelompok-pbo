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
    //ATRIBUT
    private List<Schedule> masterJadwal;

    //METHOD
    public ScheduleService() {
        this.masterJadwal = new ArrayList<>();
    }

    public void addSchedule(Schedule s) throws ScheduleConflictException {
        for (Schedule existing : masterJadwal) {
            if (existing.getTrain().getIdTrain().equals(s.getTrain().getIdTrain())) {
                // Check for time overlap
                if (s.getDepartureTime().isBefore(existing.getArrivalTime()) && 
                    s.getArrivalTime().isAfter(existing.getDepartureTime())) {
                    throw new ScheduleConflictException("Kereta " + s.getTrain().getNamaTrain() + " sudah memiliki jadwal di waktu tersebut!");
                }
            }
        }
        this.masterJadwal.add(s);
    }

    public Schedule cariJadwalById(String idSchedule) {
        return masterJadwal.stream()
                .filter(s -> s.getScheduleId().equals(idSchedule))
                .findFirst()
                .orElse(null);
    }

    public List<Schedule> cariJadwal(String kotaAsal, String kotaTujuan) {
        return masterJadwal.stream()
                .filter(s -> s.getDepartureStasion().getKota().equalsIgnoreCase(kotaAsal) &&
                             s.getArrivalStasion().getKota().equalsIgnoreCase(kotaTujuan))
                .collect(Collectors.toList());
    }

    public List<Schedule> cariJadwal(String kotaAsal, String kotaTujuan, LocalDate tanggalBerangkat) {
        return masterJadwal.stream()
                .filter(s -> s.getDepartureStasion().getKota().equalsIgnoreCase(kotaAsal) &&
                             s.getArrivalStasion().getKota().equalsIgnoreCase(kotaTujuan) &&
                             s.getDepartureTime().toLocalDate().equals(tanggalBerangkat))
                .collect(Collectors.toList());
    }

    public List<Schedule> searchSchedule(String tujuan) {
        return masterJadwal.stream()
                .filter(s -> s.getArrivalStasion().getKota().equalsIgnoreCase(tujuan) ||
                             s.getArrivalStasion().getNamaStasion().equalsIgnoreCase(tujuan))
                .collect(Collectors.toList());
    }

    public List<Schedule> searchSchedule(String asal, String tujuan) {
        return masterJadwal.stream()
                .filter(s -> (s.getDepartureStasion().getKota().equalsIgnoreCase(asal) ||
                              s.getDepartureStasion().getNamaStasion().equalsIgnoreCase(asal)) &&
                             (s.getArrivalStasion().getKota().equalsIgnoreCase(tujuan) ||
                              s.getArrivalStasion().getNamaStasion().equalsIgnoreCase(tujuan)))
                .collect(Collectors.toList());
    }

    public List<Schedule> searchSchedule(String asal, String tujuan, LocalDate tanggalBerangkat) {
        return masterJadwal.stream()
                .filter(s -> (s.getDepartureStasion().getKota().equalsIgnoreCase(asal) ||
                              s.getDepartureStasion().getNamaStasion().equalsIgnoreCase(asal)) &&
                             (s.getArrivalStasion().getKota().equalsIgnoreCase(tujuan) ||
                              s.getArrivalStasion().getNamaStasion().equalsIgnoreCase(tujuan)) &&
                             s.getDepartureTime().toLocalDate().equals(tanggalBerangkat))
                .collect(Collectors.toList());
    }

    public List<Schedule> getMasterJadwal() {
        return masterJadwal;
    }
}
