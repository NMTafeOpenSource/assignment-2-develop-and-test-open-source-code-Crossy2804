/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package carrental;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.net.URL;
import java.util.ArrayList;
import java.util.Random;
import java.util.ResourceBundle;
import java.util.Scanner;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javax.swing.JOptionPane;
/**
 *
 * @author 20002104
 */
public class FXMLDocumentController implements Initializable {
    
    @FXML
    private Button btnAdd;
    @FXML
    private Button btnRent;
    @FXML
    private TableView<Vehicles> vehicleTable;
    @FXML
    private TextField regNoField;
    @FXML
    private TextField totalKmField;
    @FXML
    private TextField vehicleField;
    @FXML
    private TextField totalSerField;
    @FXML
    private TextField requiresSerField;
    
    private ArrayList<Vehicles> vehicleList = new ArrayList<>();
    @FXML
    private TableColumn<?, ?> vehicle;
    /**
     * this read the vehicles in the text file and places them into the table
     * @param url
     * @param rb 
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        try {
            Scanner inFile = new Scanner(
                new FileReader("vehicles.txt"));
            String line;
            while(inFile.hasNext()){
                
            String vehicles = inFile.next();
            String regNo = inFile.next();
            String totalKm = inFile.next();
            String totalServices = inFile.next();
            String requiresService = inFile.next();
              
            vehicleList.add(new Vehicles(vehicles, regNo, totalKm, totalServices, requiresService));
            }
        }
        catch (FileNotFoundException ex) {
            JOptionPane.showMessageDialog(null, "File not found");
        } 
        
        ObservableList<Vehicles> vehicle = FXCollections.observableArrayList(vehicleList);
        vehicleTable.setItems(vehicle);
    }    
/**
 * this takes the car details that the users inputs into the text fields
 * and puts it into the table
 * @param event 
 */
    @FXML
    private void addCar(ActionEvent event) {
      vehicleList.add(new Vehicles(
        vehicleField.getText(),
        regNoField.getText(),
        totalKmField.getText(),
        totalSerField.getText(),
        requiresSerField.getText()
       ));
      
      ObservableList<Vehicles> vehicle = FXCollections.observableArrayList(vehicleList);
        vehicleTable.setItems(vehicle);
        
        vehicleField.setText("");
        regNoField.setText("");
        totalKmField.setText("");
        totalSerField.setText(""); 
        requiresSerField.setText(""); 
    }
    /**
     * this tells the user the car has been rented and print a receipt out
     * @param event 
     */
    @FXML
    private void rentCar(ActionEvent event) {
        JOptionPane.showMessageDialog(null, "Rent order has been sent");
    }
    
}
