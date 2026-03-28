/* Nama File    : SeatAlreadyBookedException.java
 * Deskripsi    : Custom exception untuk kursi sudah dipesan orang lain
 * Tanggal      : 23 Maret 2026
 */
package exception;

/**
 * Exception untuk menangani kondisi kursi sudah dipesan orang lain
 *
 */
public class SeatAlreadyBookedException extends Exception {
	/************ATRIBUT************/

	/************METHOD************/
	public SeatAlreadyBookedException() {
	}

	// method overloading dengan parameter message
	public SeatAlreadyBookedException(String message) {
		super(message);
	}
}

