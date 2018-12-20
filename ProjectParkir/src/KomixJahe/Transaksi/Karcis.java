/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package KomixJahe.Transaksi;
import KomixJahe.Kendaraan.Kendaraan;
import KomixJahe.Koneksi.Koneksi;
import java.util.ArrayList;
import java.sql.*;

public class Karcis {
    private int nokarcis;
    private String plat;
    private Kendaraan idkendaraan = new Kendaraan();
    private int waktumasuk;


    public int getNokarcis() {
        return nokarcis;
    }

    public void setNokarcis(int nokarcis) {
        this.nokarcis = nokarcis;
    }
        public String getPlat() {
        return plat;
    }

    public void setPlat(String plat) {
        this.plat = plat;
    }

    public Kendaraan getIdkendaraan() {
        return idkendaraan;
    }

    public void setIdkendaraan(Kendaraan idkendaraan) {
        this.idkendaraan = idkendaraan;
    }

    public int getWaktumasuk() {
        return waktumasuk;
    }

    public void setWaktumasuk(int waktumasuk) {
        this.waktumasuk = waktumasuk;
    }

    public Karcis(){
        
    }
    public Karcis (int nokarcis,String plat, Kendaraan idkendaraan, int waktumasuk){
        this.nokarcis=nokarcis;
        this.plat=plat;
        this.idkendaraan=idkendaraan;
        this.waktumasuk=waktumasuk;
    }
    public Karcis getById(int id){
        Karcis kc=new Karcis();
        ResultSet rs= Koneksi.selectQuery("SELECT * " 
                                        + "FROM karcis k "
                                        + "LEFT JOIN jeniskendaraan jk ON k.idkendaraan = jk.idkendaraan "
                                        + "WHERE k.nokarcis = '"+ id + "'");
        try{
            while(rs.next()){
                kc=new Karcis();
                kc.setNokarcis(rs.getInt("nokarcis"));
                kc.setPlat(rs.getString("plat"));
                kc.getIdkendaraan().setIdkendaraan(rs.getInt("idkendaraan"));
                kc.getIdkendaraan().setJeniskendaraan(rs.getString("jeniskendaraan"));
                kc.getIdkendaraan().setPerjam(rs.getInt("perjam"));
                kc.setWaktumasuk(rs.getInt("waktumasuk"));
            }
        }catch(Exception e){
            e.printStackTrace();
        }
        return kc;
    }
    public ArrayList<Karcis> getAll(){
        ArrayList<Karcis> Listkarcis=new ArrayList();
        ResultSet rs= Koneksi.selectQuery("SELECT * " 
                                        + "FROM karcis k "
                                        + "LEFT JOIN jeniskendaraan jk ON k.idkendaraan = jk.idkendaraan "
                                        );
        try{
            while(rs.next()){
                Karcis kc=new Karcis();
                kc=new Karcis();
                kc.setNokarcis(rs.getInt("nokarcis"));
                kc.setPlat(rs.getString("plat"));
                kc.getIdkendaraan().setIdkendaraan(rs.getInt("idkendaraan"));
                kc.getIdkendaraan().setJeniskendaraan(rs.getString("jeniskendaraan"));
                kc.getIdkendaraan().setPerjam(rs.getInt("perjam"));
                kc.setWaktumasuk(rs.getInt("waktumasuk"));
                Listkarcis.add(kc);
            }
        }catch(Exception e){
            e.printStackTrace();
        }
        return Listkarcis;
    }
    public ArrayList<Karcis> search(String keyword){
        ArrayList<Karcis> Listkarcis=new ArrayList();
        ResultSet rs= Koneksi.selectQuery("SELECT * " 
                                        + "FROM karcis k "
                                        + "LEFT JOIN jeniskendaraan jk ON k.idkendaraan = jk.idkendaraan "
                                        + " WHERE k.nokarcis LIKE '%" + keyword + "%' "
                                        );
                                        
        try{
            while(rs.next()){
                Karcis kc=new Karcis();
                kc=new Karcis();
                kc.setNokarcis(rs.getInt("nokarcis"));
                kc.setPlat(rs.getString("plat"));
                kc.getIdkendaraan().setIdkendaraan(rs.getInt("idkendaraan"));
                kc.getIdkendaraan().setJeniskendaraan(rs.getString("jeniskendaraan"));
                kc.getIdkendaraan().setPerjam(rs.getInt("perjam"));
                kc.setWaktumasuk(rs.getInt("waktumasuk"));
                Listkarcis.add(kc);
            }
        }catch(Exception e){
            e.printStackTrace();
        }
        return Listkarcis;
    }
    public void save(){
        if(getById(nokarcis).getNokarcis() == 0){
            String sql= "INSERT INTO karcis (nokarcis, plat, idkendaraan, waktumasuk) VALUES("
                    + " '" + this.nokarcis + "', "
                    + " '" + this.plat + "', "
                    + " '" + this.getIdkendaraan().getIdkendaraan()+ "', "
                    + " '" + this.waktumasuk + "' " 
                    + " )";
            this.nokarcis=Koneksi.insertQueryGetId(sql);
        }
        else{
            String sql = "UPDATE karcis SET " 
                    + " nokarcis = '" + this.nokarcis + "', "
                    + " plat = '" + this.plat + "', "
                    + " idkendaraan = '" + this.getIdkendaraan().getIdkendaraan() + "', "
                    + " waktumasuk = '" + this.waktumasuk + "' " 
                    + " WHERE nokarcis= '"+ this.nokarcis + "' ";
            Koneksi.executeQuery(sql);
        }
    }
    public void delete(int id){
        String sql = "DELETE FROM karcis WHERE nokarcis = '" + id + "'";
        Koneksi.executeQuery(sql);
    }
}
