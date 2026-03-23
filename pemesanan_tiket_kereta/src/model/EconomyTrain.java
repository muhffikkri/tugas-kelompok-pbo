/* Nama File    : EconomyTrain.java
 * Deskripsi    : Turunan Train untuk layanan kereta ekonomi
 * Tanggal      : 23 Maret 2026
 */
package model;

/**
 * Merepresentasikan kereta kelas ekonomi.
 * Menyediakan placeholder perhitungan tarif khusus economy.
 *
 * TODO Tim:
 * 1. Tentukan formula tarif economy.
 * 2. Sinkronisasi atribut dengan kebutuhan Schedule.
 * 3. Uji batas jarak minimum dan maksimum untuk tarif.
 */
public class EconomyTrain extends Train {
    /************ATRIBUT************/
    private double discountRate;

    /************METHOD************/
    public EconomyTrain() {
    }

    public EconomyTrain(String idTrain, String namaTrain, int kapasitas, double discountRate) {
        super(idTrain, namaTrain, kapasitas);
    }

    public double getDiscountRate() {
        return 0;
    }

    public void setDiscountRate(double discountRate) {
    }

    @Override
    public double hitungTarif(int jarak) {
        // TODO : Hitung tarif untuk kereta ekonomi
        return 0;
    }

    @Override
    public void printInfo() {
    }
}
