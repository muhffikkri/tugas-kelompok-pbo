
/* Nama File    : Stasion.java
 * Deskripsi    : Kelas untuk data stasiun
 * Tanggal      : 23 Maret 2026
 */
package model;
import service.PrintableInfo;

//Kelas yang merepresentasikan data stasiun kereta api.

public class Stasion implements PrintableInfo {
    //ATRIBUT
    private String idStasion;
    private String namaStasion;
    private String kota;

    //METHOD
    public Stasion() {
        this.idStasion = "";
        this.namaStasion = "";
        this.kota = "";
    }

    public Stasion(String idStasion, String namaStasion, String kota) {
        this.idStasion = idStasion;
        this.namaStasion = namaStasion;
        this.kota = kota;
    }

    public String getIdStasion() {
        return idStasion;
    }

    public void setIdStasion(String idStasion) throws IllegalArgumentException{
        if (idStasion == null || idStasion.isEmpty()) {
            throw new IllegalArgumentException("ID Stasiun tidak boleh kosong.");
    }
        this.idStasion = idStasion;
    }

    public String getNamaStasion() {
        return namaStasion;
    }

    public void setNamaStasion(String namaStasion) {
        this.namaStasion = namaStasion;
    }

    public String getKota() {
        return kota;
    }

    public void setKota(String kota) {
        this.kota = kota;
    }

    @Override
    public void printInfo() {
        System.out.println("ID Stasiun: " + idStasion);
        System.out.println("Nama Stasiun: " + namaStasion);
        System.out.println("Kota: " + kota);
    }
}
