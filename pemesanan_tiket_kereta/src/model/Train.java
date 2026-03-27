/* Nama File    : Train.java
 * Deskripsi    : Kelas abstrak sebagai dasar data kereta
 * Tanggal      : 23 Maret 2026
 */
package model;

import service.PrintableInfo;

/**
 * Abstraksi data kereta untuk tipe kereta yang berbeda.
 * Menyediakan kontrak perhitungan tarif berdasarkan jarak.
 *
 * TODO Tim:
 * 1. Konfirmasi atribut minimum kereta pada class diagram final.
 * 2. Implement constructor, getter, dan setter.
 * 3. Lengkapi assertion kapasitas > 0 pada constructor/setter.
 * 4. Tambahkan pengujian assertion aktif dengan flag -ea.
 */
public abstract class Train implements PrintableInfo {
    /************ATRIBUT************/
    private String idTrain;
    private String namaTrain;
    private int kapasitas;

    public static int TrainCounter;

    /************METHOD************/
    protected Train() {
        this.idTrain = "";
        this.namaTrain = "";
        this.kapasitas = 0;
    }

    protected Train(String idTrain, String namaTrain, int kapasitas) {
        assert kapasitas > 0 : "Kapasitas kereta harus lebih dari 0";
        this.idTrain = idTrain;
        this.namaTrain = namaTrain;
        this.kapasitas = kapasitas;
        TrainCounter++;
    }

    public String getIdTrain() {
        return idTrain;
    }

    public void setIdTrain(String idTrain) {
        this.idTrain = idTrain;
    }

    public String getNamaKereta() {
        return namaTrain;
    }

    public void setNamaKereta(String namaTrain) {
        this.namaTrain = namaTrain;
    }

    public int getKapasitas() {
        return kapasitas;
    }

    public void setKapasitas(int kapasitas) {
        assert kapasitas > 0 : "Kapasitas kereta harus lebih dari 0";
        this.kapasitas = kapasitas;
    }

    public abstract double hitungTarif(int jarak);

    @Override
    public void printInfo() {
    }
}
