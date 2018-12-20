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
/**
 *
 * @author Asus
 */
public class Pembayaran {
    private int idbayar;
    private Karcis karcis = new Karcis();
    private Kendaraan JK = new Kendaraan();
    private int waktukeluar;
    private int totalharga;
    private String Catatan;

    public int getIdbayar() {
        return idbayar;
    }

    public void setIdbayar(int idbayar) {
        this.idbayar = idbayar;
    }

    public Karcis getKarcis() {
        return karcis;
    }

    public void setKarcis(Karcis karcis) {
        this.karcis = karcis;
    }

    public Kendaraan getJK() {
        return JK;
    }

    public void setJK(Kendaraan JK) {
        this.JK = JK;
    }
    
    public int getWaktukeluar() {
        return waktukeluar;
    }

    public void setWaktukeluar(int waktukeluar) {
        this.waktukeluar = waktukeluar;
    }
    
        public int getTotalharga() {
        return totalharga;
    }

    public void setTotalharga(int totalharga) {
        this.totalharga = totalharga;
    }
    
    public String getCatatan() {
        return Catatan;
    }

    public void setCatatan(String catatan) {
        this.Catatan = Catatan;
    }

    public Pembayaran(){
        
    }

    public Pembayaran(int idbayar, Karcis karcis, Kendaraan JK, int waktukeluar, int totalharga,String Catatan) {
        this.idbayar = idbayar;
        this.karcis = karcis;
        this.JK = JK;
        this.waktukeluar = waktukeluar;
        this.totalharga = totalharga;
        this.Catatan = Catatan;
    }
    
    
    
    
    public Pembayaran getById(int id){
        Pembayaran pb=new Pembayaran();
        ResultSet rs= Koneksi.selectQuery("SELECT * " 
                            + "FROM karcis k "
                            + "LEFT JOIN jeniskendaraan jk ON jk.idkendaraan = k.idkendaraan "
                            + "LEFT JOIN pembayaran p ON p.nokarcis = k.nokarcis "
                            + " WHERE idbayar = '"+ id + "'");
        try{
            while(rs.next()){
                pb=new Pembayaran();
                pb.setIdbayar(rs.getInt("idbayar"));
                pb.getKarcis().setNokarcis(rs.getInt("nokarcis"));
                pb.getKarcis().setPlat(rs.getString("plat"));
                pb.getKarcis().setWaktumasuk(rs.getInt("waktumasuk"));
                pb.getJK().setIdkendaraan(rs.getInt("idkendaraan"));
                pb.getJK().setJeniskendaraan(rs.getString("jeniskendaraan"));
                pb.getJK().setPerjam(rs.getInt(rs.getInt("perjam")));
                pb.setWaktukeluar(rs.getInt("waktukeluar"));
                pb.setTotalharga(rs.getInt("totalharga"));
                pb.setCatatan(rs.getString("Catatan"));
            }
        }catch(Exception e){
            e.printStackTrace();
        }
        return pb;
    }
    public ArrayList<Pembayaran> getAll(){
        ArrayList<Pembayaran> Listpembayaran=new ArrayList();
        ResultSet rs=Koneksi.selectQuery("SELECT *"
                            + "FROM karcis k "
                            + "LEFT JOIN jeniskendaraan jk ON jk.idkendaraan = k.idkendaraan "
                            + "LEFT JOIN pembayaran p ON p.nokarcis = k.nokarcis "        
        );
        try{
            while(rs.next()){
                Pembayaran pb=new Pembayaran();
                pb=new Pembayaran();
                pb.setIdbayar(rs.getInt("idbayar"));
                pb.getKarcis().setNokarcis(rs.getInt("nokarcis"));
                pb.getKarcis().setPlat(rs.getString("plat"));
                pb.getKarcis().setWaktumasuk(rs.getInt("waktumasuk"));
                pb.getJK().setIdkendaraan(rs.getInt("idkendaraan"));
                pb.getJK().setJeniskendaraan(rs.getString("jeniskendaraan"));
                pb.getJK().setPerjam(rs.getInt(rs.getInt("perjam")));
                pb.setWaktukeluar(rs.getInt("waktukeluar"));
                pb.setTotalharga(rs.getInt("totalharga"));
                pb.setCatatan(rs.getString("Catatan"));
                Listpembayaran.add(pb);
            }
        }catch(Exception e){
            e.printStackTrace();
        }
        return Listpembayaran;
    }
    
    public void save(){
        if(getById(idbayar).getIdbayar()== 0){
            String sql= "INSERT INTO pembayaran (idbayar,nokarcis,idkendaraan,waktukeluar,totalharga,Catatan) VALUES("
                    + " '" +this.idbayar + "', "
                    + " '" +this.getKarcis().getNokarcis() + "', "
                    + " '" +this.getJK().getIdkendaraan() + "', "
                    + " '" +this.waktukeluar + "', "
                    + " '" +this.totalharga + "', "
                    + " '" +this.Catatan + "' "
                    + " )";
            this.idbayar=Koneksi.insertQueryGetId(sql);
        }
        else{
            String sql = "UPDATE pembayaran SET "
                    + " idbayar = '"+ this.idbayar + "', "
                    + " nokarcis = '"+ this.getKarcis().getNokarcis() + "', "
                    + " idkendaraan = '"+ this.getJK().getIdkendaraan() + "', "
                    + " waktukeluar = '"+ this.waktukeluar + "', "
                    + " totalharga= '" + this.totalharga + "' ,"
                    + " Catatan= '" + this.Catatan + "' "+" WHERE idbayar= '"+ this.idbayar+"' ";
            Koneksi.executeQuery(sql);
        }
    }
 

}
