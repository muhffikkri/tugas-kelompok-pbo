/* Nama File    : Train.java
 * Deskripsi    : Kelas abstrak untuk data kereta
 * Tanggal      : 23 Maret 2026
 */

package model;

import service.PrintableInfo;

/**
 * Kelas abstrak yang merepresentasikan data dasar kereta api. 
 */
public abstract class Train implements PrintableInfo {
    /************ATRIBUT************/
    private String idTrain;
    private String namaTrain;
    private int kapasitas;
    private double discountRate;
    private double tarifDasar;

	/************METHOD************/
    // Menginisialisasi objek kereta dengan nilai default.
    public Train() {
        this.idTrain = "";
        this.namaTrain = "";
        this.kapasitas = 0;
        this.discountRate = 0.0;
        this.tarifDasar = 0.0;
    }

    // Menginisialisasi objek kereta dengan data utama.
    public Train(String idTrain, String namaTrain, int kapasitas, double discountRate) {
        setIdTrain(idTrain);
        setNamaTrain(namaTrain);
        setKapasitas(kapasitas);
        setDiscountRate(discountRate);
        this.tarifDasar = 0.0;
    }

    // Mengambil ID kereta.
    public String getIdTrain() {
        return idTrain;
    }

    // Mengatur ID kereta dengan validasi tidak kosong.
    public void setIdTrain(String idTrain) {
        if (idTrain == null || idTrain.trim().isEmpty()) {
            throw new IllegalArgumentException("ID kereta tidak boleh kosong");
        }
        this.idTrain = idTrain;
    }

    // Mengambil nama kereta.
    public String getNamaTrain() {
        return namaTrain;
    }

    // Mengatur nama kereta dengan validasi tidak kosong.
    public void setNamaTrain(String namaTrain) {
        if (namaTrain == null || namaTrain.trim().isEmpty()) {
            throw new IllegalArgumentException("Nama kereta tidak boleh kosong");
        }
        this.namaTrain = namaTrain;
    }

    // Mengambil kapasitas kursi kereta.
    public int getKapasitas() {
        return kapasitas;
    }

    // Mengatur kapasitas kereta agar selalu lebih dari nol.
    public void setKapasitas(int kapasitas) {
        if (kapasitas <= 0) {
            throw new IllegalArgumentException("Kapasitas kereta harus lebih dari 0");
        }
        this.kapasitas = kapasitas;
    }

    // Mengambil nilai diskon kereta.
    public double getDiscountRate() {
        return discountRate;
    }

    // Mengatur diskon pada rentang 0 sampai 1.
    public void setDiscountRate(double discountRate) {
        if (Double.isNaN(discountRate) || Double.isInfinite(discountRate) || discountRate < 0 || discountRate > 1) {
            throw new IllegalArgumentException("Discount rate harus pada rentang 0 sampai 1");
        }
        this.discountRate = discountRate;
    }

    // Mengambil tarif dasar kereta sebelum diskon/surcharge.
    public double getTarifDasar() {
        return tarifDasar;
    }

    // Mengatur tarif dasar agar tidak bernilai negatif.
    public void setTarifDasar(double tarifDasar) {
        if (Double.isNaN(tarifDasar) || Double.isInfinite(tarifDasar) || tarifDasar < 0) {
            throw new IllegalArgumentException("Tarif dasar tidak valid");
        }
        this.tarifDasar = tarifDasar;
    }

    // Menghitung tarif akhir sesuai kebijakan kelas kereta.
    public abstract double hitungTarif();

    @Override
    // Menampilkan data utama kereta ke konsol.
    public void printInfo() {
        System.out.println("ID Kereta: " + idTrain);
        System.out.println("Nama Kereta: " + namaTrain);
        System.out.println("Kapasitas: " + kapasitas);
        System.out.println("Discount Rate: " + discountRate);
    }
}
