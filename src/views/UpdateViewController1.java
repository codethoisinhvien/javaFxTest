/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package views;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;

/**
 *
 * @author Phongthien
 */
public class UpdateViewController1 implements Initializable {

    @FXML
    private Label label;
    @FXML
    private TextField txtSearch;
    @FXML
    private Button btInsert;
    
    
   
  public void handleButtonAction(ActionEvent event) {
       
      btInsert.setOnAction((ActionEvent event1) -> {
          System.out.println("views.InsertViewController.handleButtonAction()");
      });
      

  
    }
   
    
     
      
    
    
    
   
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    
    
}
