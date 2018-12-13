/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package KomixJahe.Kendaraan;

/**
 *
 * @author ASUS 10.1
 */
public class Motor extends Kendaraan{
    private String namaKendaraan;
    
    public Motor(String noParkir,String noPolisi,String namaKendaraan) {
        super(noParkir,noPolisi);
        this.namaKendaraan=namaKendaraan;
    }

    public String getNamaKendaraan() {
        return namaKendaraan;
    }

    public void setNamaKendaraan(String namaKendaraan) {
        this.namaKendaraan = namaKendaraan;
    }

    public String getNoPolisi() {
        return noPolisi;
    }

    public void setNoPolisi(String noPolisi) {
        this.noPolisi = noPolisi;
    }
    
}
