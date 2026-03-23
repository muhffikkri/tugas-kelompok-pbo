/* Nama File    : ScheduleConflictException.java
 * Deskripsi    : Custom exception untuk jadwal yang telah terisi 
 * Tanggal      : 23 Maret 2026
 */
package exception;

/**
 * Exception untuk menangani kondisi jadwal yang telah terisi oleh perjalanan kereta 
 *
 * TODO Tim:
 * 1. Tentukan trigger lempar exception saat terjadi proses pengajuan jadwal
 * 2. Uji condition pengajuan jadwal ketika jadwal sudah terisi
 */
public class ScheduleConflictException extends Exception {
    /************ATRIBUT************/

	/************METHOD************/
	public ScheduleConflictException() {
	}

	public ScheduleConflictException(String message) {
		super(message);
	} 
}
