/* Nama File    : ScheduleConflictException.java
 * Deskripsi    : Custom exception untuk jadwal yang telah terisi 
 * Tanggal      : 23 Maret 2026
 */
package exception;

/**
 * Exception untuk menangani kondisi jadwal yang telah terisi oleh perjalanan kereta 
 *
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
