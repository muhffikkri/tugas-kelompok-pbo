/* Nama File    : ExecutiveTrain.java
 * Deskripsi    : Kelas turunan Train untuk kereta eksekutif
 * Tanggal      : 23 Maret 2026
 */
package model;

/**
 * Merepresentasikan kereta kelas eksekutif.
 *
 */
public class ExecutiveTrain extends Train {
	/************ATRIBUT************/
    private String fasilitas;
    private double surchargeRate;
    
	/************METHOD************/
    // Menginisialisasi kereta eksekutif dengan nilai default.
    public ExecutiveTrain() {
        super();
        this.fasilitas = "";
        this.surchargeRate = 0.0;
    }

    // Menginisialisasi kereta eksekutif tanpa surcharge tambahan.
    public ExecutiveTrain(String idTrain, String namaTrain, int kapasitas, double discountRate, String fasilitas) {
        this(idTrain, namaTrain, kapasitas, discountRate, fasilitas, 0.0);
    }

    // Menginisialisasi kereta eksekutif dengan data lengkap.
    public ExecutiveTrain(String idTrain, String namaTrain, int kapasitas, double discountRate, String fasilitas, double surchargeRate) {
        super(idTrain, namaTrain, kapasitas, discountRate);
        setFasilitas(fasilitas);
        setSurchargeRate(surchargeRate);
    }

    // Mengambil deskripsi fasilitas kereta eksekutif.
    public String getFasilitas() {
        return fasilitas;
    }

    // Mengatur deskripsi fasilitas kereta eksekutif.
    public void setFasilitas(String fasilitas) {
        this.fasilitas = (fasilitas == null) ? "" : fasilitas;
    }

    // Mengambil nilai surcharge untuk kelas eksekutif.
    public double getSurchargeRate() {
        return surchargeRate;
    }

    // Mengatur surcharge pada rentang 0 sampai 1.
    public void setSurchargeRate(double surchargeRate) {
        if (Double.isNaN(surchargeRate) || Double.isInfinite(surchargeRate) || surchargeRate < 0 || surchargeRate > 1) {
            throw new IllegalArgumentException("Surcharge rate harus pada rentang 0 sampai 1");
        }
        this.surchargeRate = surchargeRate;
    }

    @Override
    // Menghitung tarif eksekutif dari tarif dasar, surcharge berbasis rate, dan diskon.
    public double hitungTarif() {
        return getTarifDasar() + (getTarifDasar() * getSurchargeRate()) - (getTarifDasar() * getDiscountRate());
    }

    @Override
    // Menampilkan data kereta eksekutif ke konsol.
    public void printInfo() {
        super.printInfo();
        System.out.println("===== Kelas: Eksekutif =====");
        System.out.println("Fasilitas: " + fasilitas);
        System.out.println("Tarif: " + hitungTarif());
    }
}
