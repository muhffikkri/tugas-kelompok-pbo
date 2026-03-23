/* Nama File    : ExecutiveTrain.java
 * Deskripsi    : Turunan Train untuk layanan kereta eksekutif
 * Tanggal      : 23 Maret 2026
 */
package model;

/**
 * Merepresentasikan kereta kelas eksekutif.
 * Menyediakan placeholder perhitungan tarif khusus executive.
 *
 * TODO Tim:
 * 1. Tentukan formula tarif executive (base fare + surcharge).
 * 2. Isi constructor dengan parameter turunan yang dibutuhkan.
 */
public class ExecutiveTrain extends Train {
    /************ATRIBUT************/
    private double surchargeRate;

    /************METHOD************/
    public ExecutiveTrain() {
    }

    public ExecutiveTrain(String idTrain, String namaTrain, int kapasitas, double surchargeRate) {
        super(idTrain, namaTrain, kapasitas);
    }

    public double getSurchargeRate() {
        return 0;
    }

    public void setSurchargeRate(double surchargeRate) {
    }

    @Override
    public double hitungTarif(int jarak) {
        // TODO : Menghitung tarif untuk kereta eksekutif
        return 0;
    }

    @Override
    public void printInfo() {
    }
}
