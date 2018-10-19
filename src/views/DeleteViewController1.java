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
public class DeleteViewController1 implements Initializable {
  MySQLDatabase b;
  
  
    @FXML
    private Label label;
    private Button btInsert;
    @FXML
    private TextField txtWord;
    @FXML
    private TextArea txtDefine;
    @FXML
    private Button btDelete;

    public DeleteViewController1() throws SQLException {
        this.b = MySQLDatabase.getInstance("jdbc:mysql://localhost:3306/SINHVIEN","non-root","123" );
    }
    
   
    @FXML
  public void handleButtonAction(ActionEvent event) {
       
      btDelete.setOnAction((ActionEvent event1) -> {
          if(txtWord.getText().length()>0){
          try {
              // b.insertWord(txtWord.getText(),txtDefine.getText());
            b.detetetWord(txtWord.getText(), txtDefine.getText());
          } catch (SQLException ex) {
              Logger.getLogger(DeleteViewController1.class.getName()).log(Level.SEVERE, null, ex);
          }
          }else{
              System.out.println("loi");
          }
      });
      

  
    }
   
    
     
      
    
    
    
   
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    
    
}
