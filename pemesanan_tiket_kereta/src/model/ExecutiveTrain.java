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
        super();
        this.surchargeRate = 0;
    }

    public ExecutiveTrain(String idTrain, String namaTrain, int kapasitas, double surchargeRate) {
        super(idTrain, namaTrain, kapasitas);
        this.surchargeRate = surchargeRate;
    }

    public double getSurchargeRate() {
        return surchargeRate;
    }

    public void setSurchargeRate(double surchargeRate) {
        this.surchargeRate = surchargeRate;
    }

    @Override
    public double hitungTarif(int jarak) {
        // Tarif eksekutif: Rp 2000 per km + surcharge
        double baseTarif = jarak * 2000;
        double tarifDenganSurcharge = baseTarif * (1 + surchargeRate);
        return tarifDenganSurcharge;
    }

    @Override
    public void printInfo() {
        System.out.println("=== Kereta Eksekutif ===");
        System.out.println("ID: " + getIdTrain());
        System.out.println("Nama: " + getNamaTrain());
        System.out.println("Kapasitas: " + getKapasitas());
        System.out.println("Surcharge Rate: " + (surchargeRate * 100) + "%");
    }
}
