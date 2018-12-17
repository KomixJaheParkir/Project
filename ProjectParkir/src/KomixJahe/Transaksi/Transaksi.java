/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package KomixJahe.Transaksi;

import KomixJahe.Kendaraan.*;
import java.util.ArrayList;

/**
 *
 * @author ASUS 10.1
 */
public class Transaksi {
    private  ArrayList<Kendaraan>kendaraan;
    private double biaya;
    private int durasi;
    
    public Transaksi(ArrayList kendaraan, double biaya, int durasi) {
        this.kendaraan = kendaraan;
        this.biaya = biaya;
        this.durasi = durasi;
    }

    public double getBiaya() {
        return biaya;
    }

    public void setBiaya(double biaya) {
        this.biaya = biaya;
    }

    public int getDurasi() {
        return durasi;
    }

    public void setDurasi(int durasi) {
        this.durasi = durasi;
    }
    
    
    
    
}
