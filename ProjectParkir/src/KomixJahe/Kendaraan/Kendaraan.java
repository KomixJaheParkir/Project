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
public abstract class Kendaraan {
    protected String noParkir;
    protected String noPolisi;
    
    public Kendaraan(String noParkir,String noPolisi) {
        this.noPolisi = noPolisi;
        this.noParkir=noParkir;
    }

    public String getNoPolisi() {
        return noPolisi;
    }

    public void setNoPolisi(String noPolisi) {
        this.noPolisi = noPolisi;
    }

    public String getNoParkir() {
        return noParkir;
    }

    public void setNoParkir(String noParkir) {
        this.noParkir = noParkir;
    }
    
    
}
