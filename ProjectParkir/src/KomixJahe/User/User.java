/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package KomixJahe.User;

/**
 *
 * @author ASUS 10.1
 */
public class User {
    protected String username; 
    protected String password;
    
    public User(String username,String password) {
        this.username = username;
        this.password=password;
    }

    public User() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    public String getId() {
        return username;
    }

    public void setId(String id) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
    
}
