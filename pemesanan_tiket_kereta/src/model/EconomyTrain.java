/* Nama File    : EconomyTrain.java
 * Deskripsi    : Kelas turunan Train untuk kereta ekonomi
 * Tanggal      : 23 Maret 2026
 */
package model;

/**
 * Merepresentasikan kereta kelas ekonomi.
 *
 */
public class EconomyTrain extends Train {
	/************ATRIBUT************/
    private int luggageLimit;

	/************METHOD************/
    // Menginisialisasi kereta ekonomi dengan nilai default.
    public EconomyTrain() {
        super();
        this.luggageLimit = 0;
    }

    // Menginisialisasi kereta ekonomi dengan data lengkap.
    public EconomyTrain(String idTrain, String namaTrain, int kapasitas, int luggageLimit, double discountRate) {
        super(idTrain, namaTrain, kapasitas, discountRate);
            setLuggageLimit(luggageLimit);
    }

    // Mengambil batas bagasi untuk penumpang kereta ekonomi.
    public int getLuggageLimit() {
        return luggageLimit;
    }

    // Mengatur batas bagasi agar tidak bernilai negatif.
    public void setLuggageLimit(int luggageLimit) {
        if (luggageLimit < 0) {
            throw new IllegalArgumentException("Batas bagasi tidak boleh negatif");
        }
        this.luggageLimit = luggageLimit;
    }

    @Override
    // Menghitung tarif kereta ekonomi berdasarkan tarif dasar dan diskon.
    public double hitungTarif() {
        return getTarifDasar() - (getTarifDasar() * getDiscountRate());
    }

    @Override
    // Menampilkan data kereta ekonomi ke konsol.
    public void printInfo() {
        super.printInfo();
        System.out.println("===== Kelas: Ekonomi =====");
        System.out.println("Batas Bagasi: " + luggageLimit + " kg");
        System.out.println("Tarif: Rp." + hitungTarif());
    }
}
