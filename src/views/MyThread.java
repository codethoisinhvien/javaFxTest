/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package views;

import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javazoom.jl.decoder.JavaLayerException;
import model.Audio;

/**
 *
 * @author Phongthien
 */
public class MyThread extends Thread{
    String value;
    Audio a = Audio.getInstance();
    
    public void run() {
        try {
            a.play(a.Speech(this.value, "en"));
        } catch (IOException ex) {
            Logger.getLogger(MyThread.class.getName()).log(Level.SEVERE, null, ex);
        } catch (JavaLayerException ex) {
            Logger.getLogger(MyThread.class.getName()).log(Level.SEVERE, null, ex);
        }
       
   }
}
