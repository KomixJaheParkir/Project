/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package KomixJahe.Koneksi;
import java.sql.*;
import javax.swing.JOptionPane;
/**
 *
 * @author ASUS 10.1
 */
public class Database {
    private static Connection koneksi;
    
    public static Connection bukaKoneksi(){
        if(koneksi==null){
            try {
                String url="jdbc:mysql://localhost:3306/parkir";
                String user="root";
                String password="";
                DriverManager.registerDriver(new com.mysql.jdbc.Driver());
                koneksi=DriverManager.getConnection(url,user,password);
            } catch (SQLException e) {
                System.out.println("Koneksi Gagal");
            }  
        }
         return koneksi;
    }
    //Qwery DataBase
    
    public static void main(String[] args) {
        try {
            bukaKoneksi();
            JOptionPane.showMessageDialog(null, "Koneksi Berhasil");
        } catch (Exception e) {
            System.out.println("Gagal");
        }
    }
    
}
