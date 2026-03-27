/* Nama File    : ExecutiveTrain.java
 * Deskripsi    : Kelas turunan Train untuk kereta eksekutif
 * Tanggal      : 23 Maret 2026
 */
package model;

//Merepresentasikan kereta kelas eksekutif.

public class ExecutiveTrain extends Train {
    //ATRIBUT
    private String fasilitas;
    private double surchargeRate;
    

    //METHOD
    public ExecutiveTrain() {
        super();
        this.fasilitas = "";
        this.surchargeRate = 0.0;
    }

    public ExecutiveTrain(String idTrain, String namaTrain, int kapasitas, double discountRate, String fasilitas) {
        this(idTrain, namaTrain, kapasitas, discountRate, fasilitas, 0.0);
    }

    public ExecutiveTrain(String idTrain, String namaTrain, int kapasitas, double discountRate, String fasilitas, double surchargeRate) {
        super(idTrain, namaTrain, kapasitas, discountRate);
        this.fasilitas = fasilitas;
        this.surchargeRate = surchargeRate;
    }

    public String getFasilitas() {
        return fasilitas;
    }

    public void setFasilitas(String fasilitas) {
        this.fasilitas = fasilitas;
    }

    public double getSurchargeRate() {
        return surchargeRate;
    }

    public void setSurchargeRate(double surchargeRate) {
        this.surchargeRate = surchargeRate;
    }

    @Override
    public double hitungTarif() {
        return getTarifDasar() + surchargeRate - (getTarifDasar() * getDiscountRate());
    }

    @Override
    public void printInfo() {
        super.printInfo();
        System.out.println("===== Kelas: Eksekutif =====");
        System.out.println("Fasilitas: " + fasilitas);
        System.out.println("Tarif: " + hitungTarif());
    }
}
