/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package carrental;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.PrintWriter;
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
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javax.swing.JOptionPane;
/**
 *
 * @author 20002104
 */
public class FXMLDocumentController implements Initializable {
    
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
    @FXML
    private TextField lastServiceKMField;
    @FXML
    private TextField serviceDateField;
    @FXML
    private TextField fuelEcoField;
    @FXML
    private TextField revField;
    
    public ArrayList<Vehicles> carList = new ArrayList<>();
    
    Service serv = new Service();
    RentalCost rent = new RentalCost();
    FuelPurchase fuelP = new FuelPurchase();
    
    @FXML
    private Button btnRentDay;
    @FXML
    private Button btnDetails;
    @FXML
    private TextField numDaysField;
    @FXML
    private Button btnRentKm;
    @FXML
    private TextArea txtcarDetail;
    @FXML
    private TextField kmField;
    @FXML
    private TextField serviceCountField;
    
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
                int servCount = serv.getTotalScheduledServices();
                String reqService = inFile.next();
                int lastServKM = Integer.parseInt(inFile.next());
                String date = inFile.next();       
                double fuelEco = Double.parseDouble(inFile.next());
                double revenue = Double.parseDouble(inFile.next());
              
                carList.add(new Vehicles(manufacturer, model, year, registrationNo, odemeterReading, tankCapacity,
                                         servCount, reqService, lastServKM, date, fuelEco, revenue));
            }
        }
        catch (FileNotFoundException ex) {
            JOptionPane.showMessageDialog(null, "File not found");
        } 
        
        ObservableList<Vehicles> vehicles = FXCollections.observableArrayList(carList);        
        vehicleTable.setItems(vehicles);
    }    
/**
 * this takes the car details that the users inputs into the text fields
 * and puts it into the table
 * @param event 
 */
    @FXML
    private void addCar(ActionEvent event) {
            //carList.add(new Vehicles(
            String manufacturer = manufacurerField.getText();
            String model = modelField.getText();
            int year = Integer.parseInt(yearField.getText());
            String registrationNo = regNoField.getText();
            double odemeterReading = Double.parseDouble(odemeterField.getText());
            int tankCapacity = Integer.parseInt(tankField.getText());
            int servCount = Integer.parseInt(serviceCountField.getText());
            String reqService = requiresServField.getText();
            int lastServKM = Integer.parseInt(lastServiceKMField.getText());
            String date = serviceDateField.getText();
            double fuelEco = Double.parseDouble(fuelEcoField.getText());
            double revenue = Double.parseDouble(revField.getText());
                    
                 carList.add(new Vehicles(manufacturer, model, year, registrationNo, odemeterReading, tankCapacity,
                                         servCount, reqService, lastServKM, date, fuelEco, revenue));
        //));
        
        ObservableList<Vehicles> vehicles = FXCollections.observableArrayList(carList);
        vehicleTable.setItems(vehicles);
    }
/**
 * This event is connected to the rent by day button
 * This is if the user wants to rent the car by a certain amount of days
 * @param event 
 */
    @FXML
    private void RentByDay(ActionEvent event) {
        rent.setamount(Double.parseDouble(numDaysField.getText()));
        rent.getRentDayCost();
        JOptionPane.showMessageDialog(null, "Rent Cost: $" + rent.getRentDayCost());
    }
/**
 * This event is connected to the rent by km button
 * This is if the user wants to rent the car by how many km they will use
 * @param event 
 */
    @FXML
    private void RentByKm(ActionEvent event) throws FileNotFoundException {
        rent.setamount(Double.parseDouble(kmField.getText()));
        rent.getRentKmCost();
       JOptionPane.showMessageDialog(null, "Rent Cost: $" + rent.getRentKmCost());
    }
/**
 * Event connected to a button that when pressed and a car in the table is selected 
 * it will view the details on the selected car
 * If no car is selected a message will come up
 * @param event 
 */
    @FXML
    private void viewDetails(ActionEvent event) {
        try{
        int v = vehicleTable.getSelectionModel().getSelectedIndex();
        txtcarDetail.setText("Manufacturer: " + carList.get(v).getManufacturer() + "\n " +  
                           "Model: " + carList.get(v).getModel() + "\n " +
                           "Year: " + carList.get(v).getYear()+ "\n " +
                           "Registration No: " + carList.get(v).getRegistrationNo() + "\n " + 
                           "Odemeter Reading: " + carList.get(v).getOdemeterReading()+ "\n " +
                           "Tank Capacity: " + carList.get(v).getTankCapacity() + "\n " +  
                           "Service Count: " + carList.get(v).serv.getServiceCount() + "\n " +
                           "Requires Service: " + carList.get(v).getRequiresService() + "\n " +     
                           "Last Service Km: " + carList.get(v).serv.getLastServiceOdometerKm() + "\n " +  
                           "Date of Last Service: " + carList.get(v).serv.getServiceDate() + "\n " +
                           "Fuel Economy: " + carList.get(v).fuel.getFuelEconomy() + "\n " +
                           "Revenue: " + carList.get(v).getRevenue());
        }
        catch (Exception ex) {
            JOptionPane.showMessageDialog(null, "No vehicle selected, please select vehicle from table");
        } 
        
    }
    
}
