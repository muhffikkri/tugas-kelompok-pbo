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
        super();
        this.discountRate = 0;
    }

    public EconomyTrain(String idTrain, String namaTrain, int kapasitas, double discountRate) {
        super(idTrain, namaTrain, kapasitas);
        this.discountRate = discountRate;
    }

    public double getDiscountRate() {
        return discountRate;
    }

    public void setDiscountRate(double discountRate) {
        this.discountRate = discountRate;
    }

    @Override
    public double hitungTarif(int jarak) {
        // Tarif ekonomi: Rp 1000 per km dengan diskon
        double baseTarif = jarak * 1000;
        double discountedTarif = baseTarif * (1 - discountRate);
        return discountedTarif;
    }

    @Override
    public void printInfo() {
        System.out.println("=== Kereta Ekonomi ===");
        System.out.println("ID: " + getIdTrain());
        System.out.println("Nama: " + getNamaKereta());
        System.out.println("Kapasitas: " + getKapasitas());
        System.out.println("Discount Rate: " + (discountRate * 100) + "%");
    }
}
