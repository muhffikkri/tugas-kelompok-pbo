/* Nama File    : SeatAlreadyBookedException.java
 * Deskripsi    : Custom exception untuk kursi sudah dipesan orang lain
 * Tanggal      : 23 Maret 2026
 */
package exception;

/**
 * Exception untuk menangani kondisi kursi sudah dipesan orang lain
 *
 * TODO :
 * 1. Tentukan trigger lempar exception saat pemesanan kursi.
 * 2. Uji race condition pemesanan kursi pada jadwal yang sama.
 */
public class SeatAlreadyBookedException extends Exception {
	/************ATRIBUT************/

	/************METHOD************/
	public SeatAlreadyBookedException() {
	}

	public SeatAlreadyBookedException(String message) {
		super(message);
	}
}

