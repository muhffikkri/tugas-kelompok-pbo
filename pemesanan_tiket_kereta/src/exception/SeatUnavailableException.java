/* Nama File    : SeatUnavailableException.java
 * Deskripsi    : Custom exception untuk kursi tidak tersedia
 * Tanggal      : 23 Maret 2026
 */
package exception;

/**
 * Exception untuk menangani kondisi kursi sudah habis/tidak tersedia.
 *
 */
public class SeatUnavailableException extends Exception {
	/************ATRIBUT************/

	/************METHOD************/
	public SeatUnavailableException() {
	}

	// method overloading dengan parameter message
	public SeatUnavailableException(String message) {
		super(message);
	}
}
