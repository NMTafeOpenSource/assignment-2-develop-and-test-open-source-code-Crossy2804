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
    private Button btnRent;
    @FXML
    private TableView<Vehicles> vehicleTable;
     @FXML
    private TableColumn<Vehicles, String> Manufacturer;
    @FXML
    private TableColumn<Vehicles, String> Model;
    @FXML
    private TableColumn<Vehicles, Integer> Year;
    @FXML
    private TableColumn<Vehicles, String> RegistrationNo;
    @FXML
    private TableColumn<Vehicles, Integer> Odemeter;
    @FXML
    private TableColumn<Vehicles, Integer> Tank;
    @FXML
    private TableColumn<Vehicles, Integer> ServiceCount;
    @FXML
    private TableColumn<Vehicles, String> RequiresService;
    @FXML
    private TextField manufacurerField;
    @FXML
    private TextField modelField;
    @FXML
    private TextField yearField;
    @FXML
    private TextField regNoField;
    @FXML
    private TextField odemeterField;
    @FXML
    private TextField tankField;
    @FXML
    private TextField requiresServField;
    
    public ArrayList<Vehicles> carList = new ArrayList<>();
    
    Service serv = new Service();
    RentalCost rent = new RentalCost();
    FuelPurchase fuelP = new FuelPurchase();
   
    
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
                
            while(inFile.hasNext()){
            
                String manufacturer = inFile.next();
                String model = inFile.next();
                int year = Integer.parseInt(inFile.next());
                String registrationNo = inFile.next();
                double odemeterReading = Double.parseDouble(inFile.next());
                int tankCapacity = Integer.parseInt(inFile.next());
                int lastServKM = Integer.parseInt(inFile.next());
                String date = inFile.next();
                int servCount = Integer.parseInt(inFile.next());
                String reqService = inFile.next();       
                double fuelEco = Double.parseDouble(inFile.next());
                double revenue = Double.parseDouble(inFile.next());
              
                carList.add(new Vehicles(manufacturer, model, year, registrationNo, odemeterReading, tankCapacity,
                                         lastServKM, date, servCount, reqService, fuelEco, revenue));
            }
        }
        catch (FileNotFoundException ex) {
            JOptionPane.showMessageDialog(null, "File not found");
        } 
        
        ObservableList<Vehicles> vehicleList = FXCollections.observableArrayList(carList);
        vehicleTable.setItems(vehicleList);
    }    
    /**
     * this tells the user the car has been rented and prints a receipt out
     * A message will come up telling user order has been sent
     * @param event 
     */
    @FXML
    private void rentCar(ActionEvent event) {
        JOptionPane.showMessageDialog(null, "Rent order has been sent");
    }
/**
 * this takes the car details that the users inputs into the text fields
 * and puts it into the table
 * @param event 
 */
    @FXML
    private void addCar(ActionEvent event) {
       
    }
    
}
