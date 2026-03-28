/* Nama File    : InvalidBookingException.java
 * Deskripsi    : Custom exception untuk data booking tidak valid
 * Tanggal      : 23 Maret 2026
 */
package exception;

/**
 * Exception untuk menangani kondisi data pemesanan tidak memenuhi aturan.
 *
 */
public class InvalidBookingException extends Exception {
	/************ATRIBUT************/

	/************METHOD************/
	public InvalidBookingException() {
	}

	// method overloading dengan parameter message
	public InvalidBookingException(String message) {
		super(message);
	}
}
