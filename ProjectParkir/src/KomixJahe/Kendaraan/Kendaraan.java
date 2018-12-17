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
    protected String noKarcis;
    protected String noPolisi;
    
    public Kendaraan(String noParkir,String noKarcis) {
        this.noPolisi = noPolisi;
        this.noKarcis=noKarcis;
    }

    public String getNoPolisi() {
        return noPolisi;
    }

    public void setnoKarcis(String noKarcis) {
        this.noKarcis=noKarcis;
    }

    public String getnoKarcis() {
        return noKarcis;
    }

    public void setnoKarkir(String noKarcis) {
        this.noKarcis = noKarcis;
    }
    
    
}
