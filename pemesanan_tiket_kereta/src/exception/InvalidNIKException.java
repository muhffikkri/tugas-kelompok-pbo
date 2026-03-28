/* Nama File    : InvalidNIKException.java
 * Deskripsi    : Custom exception untuk validasi NIK tidak valid
 * Tanggal      : 23 Maret 2026
 */
package exception;

/**
 * Exception untuk menangani kondisi NIK penumpang tidak sesuai format.
 *
 */
public class InvalidNIKException extends Exception {
	/************ATRIBUT************/

	/************METHOD************/
	public InvalidNIKException() {
	}

	public InvalidNIKException(String message) {
		super(message);
	}
}
