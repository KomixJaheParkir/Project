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
public class Mobil extends Kendaraan{
    private String namaKendaraan;
    public Mobil(String noKarcis,String noPolisi,String namaKendaraan) {
        super(noKarcis,noPolisi);
        this.namaKendaraan=namaKendaraan;
    }
     public String getNamaKendaraan() {
        return namaKendaraan;
    }

    public void setNamaKendaraan(String namaKendaraan) {
        this.namaKendaraan = namaKendaraan;
    }

    @Override
    public String getNoPolisi() {
        return noPolisi;
    }

   
    public void setNoPolisi(String noPolisi) {
        this.noPolisi = noPolisi;
    }
    
    
}
