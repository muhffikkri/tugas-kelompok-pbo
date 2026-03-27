/* Nama File    : Train.java
 * Deskripsi    : Kelas abstrak untuk data kereta
 * Tanggal      : 23 Maret 2026
 */

package model;
import service.PrintableInfo;

//Kelas abstrak yang merepresentasikan data dasar kereta api.
public abstract class Train implements PrintableInfo {
    //ATRIBUT
    private String idTrain;
    private String namaTrain;
    private int kapasitas;
    private double discountRate;
    private double tarifDasar;

    //METHOD
    public Train() {
        this.idTrain = "";
        this.namaTrain = "";
        this.kapasitas = 0;
        this.discountRate = 0.0;
    }

    public Train(String idTrain, String namaTrain, int kapasitas, double discountRate) {
        this.idTrain = idTrain;
        this.namaTrain = namaTrain;
        this.kapasitas = kapasitas;
        this.discountRate = discountRate;
    }

    public String getIdTrain() {
        return idTrain;
    }

    public void setIdTrain(String idTrain) {
        this.idTrain = idTrain;
    }

    public String getNamaTrain() {
        return namaTrain;
    }

    public void setNamaTrain(String namaTrain) {
        this.namaTrain = namaTrain;
    }

    public int getKapasitas() {
        return kapasitas;
    }

    public void setKapasitas(int kapasitas) {
        this.kapasitas = kapasitas;
    }

    public double getDiscountRate() {
        return discountRate;
    }

    public void setDiscountRate(double discountRate) {
        this.discountRate = discountRate;
    }

    public double getTarifDasar() {
        return tarifDasar;
    }

    public void setTarifDasar(double tarifDasar) {
        this.tarifDasar = tarifDasar;
    }


    public abstract double hitungTarif();

    @Override
    public void printInfo() {
        System.out.println("ID Kereta: " + idTrain);
        System.out.println("Nama Kereta: " + namaTrain);
        System.out.println("Kapasitas: " + kapasitas);
        System.out.println("Discount Rate: " + discountRate);
    }
}
