/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package views;

import java.io.IOException;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javazoom.jl.decoder.JavaLayerException;
import model.Audio;
import model.MySQLDatabase;

/**
 *
 * @author Phongthien
 */
public class MyThreadMySQL extends Thread{
    String value;
    MySQLDatabase a;

    public MyThreadMySQL() throws SQLException {
        this.a = MySQLDatabase.getInstance("jdbc:mysql://localhost:3306/SINHVIEN","non-root","123" );
    }
    
    public void run() {
        try {
            a.selectWord(value);
        } catch (SQLException ex) {
            Logger.getLogger(MyThreadMySQL.class.getName()).log(Level.SEVERE, null, ex);
        }
       
   }
}
