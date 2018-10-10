/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package views;

import java.io.IOException;
import java.net.URL;
import java.util.Observable;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.ListView;
import javafx.scene.control.TextField;
import javafx.scene.layout.StackPane;
import javafx.stage.Stage;

/**
 *
 * @author Phongthien
 */
public class MainViewController implements Initializable {
 ObservableList<String> items =FXCollections.observableArrayList();
    @FXML
    private Label label;
    @FXML
    private TextField txtSearch  ; 
    @FXML
    private Button btSearch;
    @FXML
    private Button btInsert;
    @FXML
    private Button btUpdate;
    @FXML
    private ListView<String> listView;
    @FXML
    private void handleButtonAction(ActionEvent event) {
        System.out.println("views.InsertViewController.handleButtonAction()");
      //if(event.getSource().equals(btSearch)) System.out.println("javafxapplication3.FXMLDocumentController.handleButtonAction()");
      //if(event.getSource().equals(btInsert)) System.out.println("javafxapplication3.");
       btSearch.setOnAction((ActionEvent event1) -> {
           System.out.println("Hello World!");
       });
        btUpdate.setOnAction((ActionEvent event1) -> {
    Parent root = null;
        
            try {
                root = FXMLLoader.load(getClass().getResource("UpdateViews.fxml"));
            } catch (IOException ex) {
                Logger.getLogger(MainViewController.class.getName()).log(Level.SEVERE, null, ex);
            }
            
            
            
            
            Scene scene = new Scene(root);
            Stage newWindow = new Stage();
            newWindow.setTitle("Update Stage");
            newWindow.setScene(scene);
            newWindow.show();
        listView.setItems(items);
            
       });
        btInsert.setOnAction((ActionEvent event1) -> {
            Parent root = null;
        
            try {
                root = FXMLLoader.load(getClass().getResource("InsertView.fxml"));
            } catch (IOException ex) {
                Logger.getLogger(MainViewController.class.getName()).log(Level.SEVERE, null, ex);
            }
            
            
            
            
            Scene scene = new Scene(root);
            Stage newWindow = new Stage();
            newWindow.setTitle("Insert Stage");
            newWindow.setScene(scene);
            newWindow.show();
       });
   listView.getSelectionModel().selectedIndexProperty().addListener((ObservableValue<? extends Number> observable, Number oldValue, Number newValue) -> {
       System.out.println(listView.getSelectionModel().getSelectedItem());
       });
    }
   
    
     
      
    
    
    
   
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    
    
}
