/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package KomixJahe.Kendaraan;

import KomixJahe.Koneksi.Koneksi;
import java.sql.ResultSet;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

/**
 *
 * @author ASUS 10.1
 */
public  class Kendaraan {
    private int idkendaraan;
    private String jeniskendaraan;
    private int perjam;
    
     public Kendaraan(){
        
    }
    public Kendaraan(int idkendaraan,String jeniskendaraan,int perjam){
        this.idkendaraan=idkendaraan;
        this.jeniskendaraan=jeniskendaraan;
        this.perjam=perjam;
    }

    public int getIdkendaraan() {
        return idkendaraan;
    }

    public void setIdkendaraan(int idkendaraan) {
        this.idkendaraan = idkendaraan;
    }

    public String getJeniskendaraan() {
        return jeniskendaraan;
    }

    public void setJeniskendaraan(String jeniskendaraan) {
        this.jeniskendaraan = jeniskendaraan;
    }

    public int getPerjam() {
        return perjam;
    }

    public void setPerjam(int perjam) {
        this.perjam = perjam;
    }
    
    public Kendaraan getById(int id){
        Kendaraan jen=new Kendaraan();
        ResultSet rs= Koneksi.selectQuery("SELECT * FROM jeniskendaraan " + " WHERE idkendaraan = '"+ id + "'");
        try{
            while(rs.next()){
                jen=new Kendaraan();
                jen.setIdkendaraan(rs.getInt("idkendaraan"));
                jen.setJeniskendaraan(rs.getString("jeniskendaraan"));
                jen.setPerjam(rs.getInt("perjam"));
            }
        }catch(Exception e){
            e.printStackTrace();
        }
        return jen;
    }
    public ArrayList<Kendaraan> getAll(){
        ArrayList<Kendaraan> Listjenis=new ArrayList();
        ResultSet rs=Koneksi.selectQuery("SELECT * FROM jeniskendaraan");
        try{
            while(rs.next()){
                Kendaraan jen=new Kendaraan();
                jen.setIdkendaraan(rs.getInt("idkendaraan"));
                jen.setJeniskendaraan(rs.getString("jeniskendaraan"));
                jen.setPerjam(rs.getInt("perjam"));
                Listjenis.add(jen);
            }
        }catch(Exception e){
            e.printStackTrace();
        }
        return Listjenis;
    }
    
    public String toString(){
        return jeniskendaraan;
    }
    
    
}
