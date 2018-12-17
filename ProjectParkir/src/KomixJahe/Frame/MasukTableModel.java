/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package KomixJahe.Frame;
import javax.swing.table.*;
/**
 *
 * @author ASUS 10.1
 */
public class MasukTableModel extends DefaultTableModel{
    String []kolom;
    public MasukTableModel() {
        this.kolom = new String[]{       
            "No.Tiket" , "Plat Nomer" , "Tanggal Masuk","Jam Masuk"
        };
    }
    
    // kolom getter
    public String[] getNamaKolom() {
        return this.kolom;
    }

    @Override
    public void setRowCount(int rowCount) {
        super.setRowCount(rowCount); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void addRow(Object[] os) {
        super.addRow(os); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void removeRow(int i) {
       super.removeRow(i); //To change body of generated methods, choose Tools | Templates.
    }
    
    
}



