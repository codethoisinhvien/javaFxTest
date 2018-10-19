/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package views;

import java.io.IOException;
import java.net.URL;
import java.sql.SQLException;
import java.util.Observable;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.event.Event;
import javafx.event.EventHandler;
import javafx.event.EventType;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.ListView;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.input.KeyEvent;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.StackPane;
import javafx.stage.Stage;
import javazoom.jl.decoder.JavaLayerException;
import model.Audio;
import model.MySQLDatabase;
import model.UrlGoogle;

/**
 *
 * @author Phongthien
 */
public class MainViewController implements Initializable {
    Audio a = Audio.getInstance();
   MySQLDatabase b;
 MyThread speakThread = new MyThread();
 MyThreadMySQL mySQL = new MyThreadMySQL();
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
    private Button btDelete;
    @FXML
    private Button btspeakers;
    @FXML
    private TextArea txtDefine;

    public MainViewController() throws SQLException {
        this.b = MySQLDatabase.getInstance("jdbc:mysql://localhost:3306/SINHVIEN","non-root","123" );
    }
    @FXML
    private void handleButtonAction(ActionEvent event) {
        
        
   
    }
   
    
     
      
    
    
    
   
    
    
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
        System.out.println("views.MainViewController.handleButtonAction()");
        txtSearch.addEventHandler(KeyEvent.KEY_RELEASED,new EventHandler<KeyEvent>(){
            @Override
            public void handle(KeyEvent event) {
                System.out.println(".handle()");
                try {
                    if(txtSearch.getText().length()>0)
                    listView.setItems( b.liketWord(txtSearch.getText()));
                    //listView.refresh();

                } catch (SQLException ex) {
                    Logger.getLogger(MainViewController.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
            
        });
        txtSearch.addEventHandler(KeyEvent.KEY_RELEASED,new EventHandler<KeyEvent>(){
            @Override
            public void handle(KeyEvent event) {
                System.out.println(".handle()");
                try {
                    if(txtSearch.getText().length()>0)
                    listView.setItems( b.liketWord(txtSearch.getText()));
                    //listView.refresh();
                   
                } catch (SQLException ex) {
                    Logger.getLogger(MainViewController.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
            
        });
         
        
        
       
       btSearch.setOnMouseClicked(new EventHandler<MouseEvent>(){

            @Override
            public void handle(MouseEvent event) {
                try {
                    
                    if(txtSearch.getText().length()>0){
                    txtDefine.setText(b.selectWord(txtSearch.getText()));
                    listView.focusTraversableProperty().unbind();
                     if(b.selectWord(txtSearch.getText()).length()==0){
                        txtDefine.setText(  UrlGoogle.tranlateText(txtSearch.getText()));
                     }
                    if(txtDefine.getText().length()>0)
                      
                   
                        speakThread.value=txtSearch.getText();
                         speakThread.run();
                   // a.play(a.Speech(txtSearch.getText(), "en"));
                    }
                } catch (SQLException ex) {
                    Logger.getLogger(MainViewController.class.getName()).log(Level.SEVERE, null, ex);
                } catch (IOException ex) {
                    Logger.getLogger(MainViewController.class.getName()).log(Level.SEVERE, null, ex);

                }
            }

       });
       btUpdate.setOnMouseClicked(new EventHandler<MouseEvent>(){

            @Override
            public void handle(MouseEvent event) {
               Parent root = null;
        
            try {
                root = FXMLLoader.load(getClass().getResource("UpdateView.fxml"));
            } catch (IOException ex) {
                Logger.getLogger(MainViewController.class.getName()).log(Level.SEVERE, null, ex);
            }
            
            
            
            
            Scene scene = new Scene(root);
            Stage newWindow = new Stage();
            newWindow.setTitle("Update Stage");
            newWindow.setScene(scene);
            newWindow.show();
 
            }

       });
       btInsert.setOnMouseClicked(new EventHandler<MouseEvent>(){

            @Override
            public void handle(MouseEvent event) {
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
            }

       });
       btDelete.setOnMouseClicked(new EventHandler<MouseEvent>(){

            @Override
            public void handle(MouseEvent event) {
                 Parent root = null;
        
            try {
                root = FXMLLoader.load(getClass().getResource("DeleteView.fxml"));
                
            } catch (IOException ex) {
                Logger.getLogger(MainViewController.class.getName()).log(Level.SEVERE, null, ex);
            }
            
            
            
            
            Scene scene = new Scene(root);
            Stage newWindow = new Stage();
            newWindow.setTitle("Insert Stage");
            newWindow.setScene(scene);
            newWindow.show();
            }

       });
       btspeakers.setOnMouseClicked(new EventHandler<MouseEvent>(){
            @Override
            public void handle(MouseEvent event) {
                System.out.println("Noi");
                try {
                    if(txtSearch.getText().length()>0)
                    a.play(a.Speech(txtSearch.getText(),"en"));
                } catch (JavaLayerException ex) {
                    Logger.getLogger(MainViewController.class.getName()).log(Level.SEVERE, null, ex);
                } catch (IOException ex) {
                    Logger.getLogger(MainViewController.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
           
       });
       
       
       
   
  
   listView.getSelectionModel().selectedIndexProperty().addListener((ObservableValue<? extends Number> observable, Number oldValue, Number newValue) -> {
       if(listView.getSelectionModel().getSelectedItem()!=null){
       //    txtSearch.setText(listView.getSelectionModel().getSelectedItem());
       // txtSearch.clear();
           try {
               txtDefine.setText(b.selectWord(listView.getSelectionModel().getSelectedItem()));
               
           } catch (SQLException ex) {
               Logger.getLogger(MainViewController.class.getName()).log(Level.SEVERE, null, ex);
           }
           speakThread.value=txtSearch.getText();
           speakThread.run();
       }
       
       });
    }    
    
}
