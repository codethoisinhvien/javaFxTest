/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package views;

import java.net.URL;
import java.sql.SQLException;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import model.MySQLDatabase;

/**
 *
 * @author Phongthien
 */
public class UpdateViewController implements Initializable {
 MySQLDatabase b;
    @FXML
    private Label label;
    private Button btInsert;
    @FXML
    private TextField txtWord;
    @FXML
    private TextArea txtDetail;
    @FXML
    private Button btDetail;
    @FXML
    private Button btWorrd;
    @FXML
    private TextArea txtDetail1;
    @FXML
    private TextField txtWord1;

    public UpdateViewController() throws SQLException {
        this.b = MySQLDatabase.getInstance("jdbc:mysql://localhost:3306/SINHVIEN","non-root","123" );
    }
    
    
   
  public void handleButtonAction(ActionEvent event) {
       
      btWorrd.setOnAction((ActionEvent event1) -> {
        
          try {
              b.updatetID(txtWord.getText(), "word", txtWord1.getText(), txtDetail.getText());
          } catch (SQLException ex) {
              Logger.getLogger(UpdateViewController.class.getName()).log(Level.SEVERE, null, ex);
          }
      });
      btDetail.setOnAction((ActionEvent event1) -> {
        
          try {
              b.updatetID(txtWord.getText(), "detail", txtDetail1.getText(), txtDetail.getText());
          } catch (SQLException ex) {
              Logger.getLogger(UpdateViewController.class.getName()).log(Level.SEVERE, null, ex);
          }
      });
      

  
    }
   
    
     
      
    
    
    
   
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    
    
}
