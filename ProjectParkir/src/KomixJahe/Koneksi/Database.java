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
    public static int insertQueryGetKarcis(String query){
        bukaKoneksi();
        int num=0;
        int result=-1;
            try {
                Statement st=koneksi.createStatement();
                num=st.executeUpdate(query,Statement.RETURN_GENERATED_KEYS);
                ResultSet rs= st.getGeneratedKeys();
               
                if(rs.next()){
                    result=rs.getInt(1);
                }
               rs.close();
               st.close();
        } catch (Exception e) {
           e.printStackTrace();
           result=-1;
        }
            return result;
    }
    
    public static boolean executeQuery(String query){
        bukaKoneksi();
        boolean result=false;
        
        try{
            Statement st= koneksi.createStatement();
            st.executeUpdate(query);
            result=true;
            st.close();
        }catch(Exception e){
            e.printStackTrace();
        }
        return result;
    }
    
    public static ResultSet selectQuery(String query){
        bukaKoneksi();
        ResultSet rs= null;
        
        try {
            Statement st= koneksi.createStatement();
            rs=st.executeQuery(query);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return rs;
    }
    
    public static void main(String[] args) {
        try {
            bukaKoneksi();
            JOptionPane.showMessageDialog(null, "Koneksi Berhasil");
        } catch (Exception e) {
            System.out.println("Gagal");
        }
    }
    
}
