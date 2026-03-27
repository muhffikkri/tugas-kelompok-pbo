/* Nama File    : EconomyTrain.java
 * Deskripsi    : Kelas turunan Train untuk kereta ekonomi
 * Tanggal      : 23 Maret 2026
 */
package model;

//Merepresentasikan kereta kelas ekonomi.

public class EconomyTrain extends Train {
    //ATRIBUT
    private int luggageLimit;

    //METHOD
    public EconomyTrain() {
        super();
        this.luggageLimit = 0;
    }

    public EconomyTrain(String idTrain, String namaTrain, int kapasitas, int luggageLimit, double discountRate) {
        super(idTrain, namaTrain, kapasitas, discountRate);
        this.luggageLimit = luggageLimit;
    }

    public int getLuggageLimit() {
        return luggageLimit;
    }

    public void setLuggageLimit(int luggageLimit) {
        this.luggageLimit = luggageLimit;
    }

    @Override
    public double hitungTarif() {
        return getTarifDasar() - (getTarifDasar() * getDiscountRate());
    }

    @Override
    public void printInfo() {
        super.printInfo();
        System.out.println("===== Kelas: Ekonomi =====");
        System.out.println("Batas Bagasi: " + luggageLimit + " kg");
        System.out.println("Tarif: Rp." + hitungTarif());
    }
}
