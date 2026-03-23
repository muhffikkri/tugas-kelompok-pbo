/* Nama File    : SeatUnavailableException.java
 * Deskripsi    : Custom exception untuk kursi sudah penuh
 * Tanggal      : 23 Maret 2026
 */
package exception;

/**
 * Exception untuk menangani kondisi kursi sudah habis atau tidak tersedia.
 *
 * TODO Tim:
 * 1. Tentukan trigger lempar exception saat pemesanan kursi.
 * 2. Uji race condition pemesanan kursi pada jadwal yang sama.
 */
public class SeatUnavailableException extends Exception {
	/************ATRIBUT************/

	/************METHOD************/
	public SeatUnavailableException() {
	}

	public SeatUnavailableException(String message) {
		super(message);
	}
}
