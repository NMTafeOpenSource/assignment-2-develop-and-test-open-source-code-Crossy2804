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
    @FXML
    private Button btnRentDay;
    @FXML
    private Button btnDetails;
    private TextField numDaysField;
    @FXML
    private Button btnRentKm;
    @FXML
    private TextArea txtcarDetail;
    private TextField kmField;
    @FXML
    private TextField serviceCountField;
    @FXML
    private TextField rentalCostField;
    @FXML
    private Button btnDelete;
    @FXML
    private TextField litresField;
    @FXML
    private TextField fuelCostField;   
    
    public ArrayList<Vehicles> carList = new ArrayList<>();
    
    Service serv = new Service();
    RentalCost rent = new RentalCost();
    FuelPurchase fuel = new FuelPurchase();
    

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
                double odemeterReading = (Double.parseDouble(inFile.next()));
                int tankCapacity = Integer.parseInt(inFile.next());
                int servCount = Integer.parseInt(inFile.next());
                String reqService = inFile.next();
                int lastServKM = (Integer.parseInt(inFile.next()));
                serv.lastServiceOdometerKm = lastServKM;
                String date = inFile.next();       
                double fuelEco = Double.parseDouble(inFile.next());
                fuel.setFuelEconomy(fuelEco);
                double liters = Double.parseDouble(inFile.next());
                fuel.setFuel(liters);
                double cost = Double.parseDouble(inFile.next());
                fuel.setCost(cost);
                double revenue = Double.parseDouble(inFile.next());
              
                carList.add(new Vehicles(manufacturer, model, year, registrationNo, odemeterReading, tankCapacity,
                                         servCount, reqService, lastServKM, date, fuelEco, liters, cost, revenue));
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
            serv.lastServiceOdometerKm = lastServKM;
            String date = serviceDateField.getText();
            double fuelEco = Double.parseDouble(fuelEcoField.getText());
            fuel.setFuelEconomy(fuelEco);
            double liters = Double.parseDouble(litresField.getText());
            fuel.setFuel(Double.parseDouble(rentalCostField.getText()));
            double cost = Double.parseDouble(fuelCostField.getText());
            fuel.setCost(Double.parseDouble(fuelCostField.getText()));
            double revenue = Double.parseDouble(revField.getText());
                    
                 carList.add(new Vehicles(manufacturer, model, year, registrationNo, odemeterReading, tankCapacity,
                                         servCount, reqService, lastServKM, date, fuelEco, liters, cost, revenue));
        manufacurerField.clear();
        modelField.clear();
        yearField.clear();   
        regNoField.clear();   
        odemeterField.clear();
        tankField.clear();
        serviceCountField.clear();
        requiresServField.clear();
        lastServiceKMField.clear();
        serviceDateField.clear();
        fuelEcoField.clear();
        litresField.clear();
        fuelCostField.clear();
        revField.clear();
                
        ObservableList<Vehicles> vehicles = FXCollections.observableArrayList(carList);
        vehicleTable.setItems(vehicles);
        
    }
/**
 * This event is connected to the rent by day button
 * This is if the user wants to rent the car by a certain amount of days
 * @param event 
 */
    @FXML
    private void RentByDay(ActionEvent event) throws FileNotFoundException {
        rent.setamount(Double.parseDouble(rentalCostField.getText()));
        WriteFileDays();
        JOptionPane.showMessageDialog(null, "Receipt has been printed");
    }
/**
 * This event is connected to the rent by km button
 * This is if the user wants to rent the car by how many km they will use
 * @param event 
 */
    @FXML
    private void RentByKm(ActionEvent event) throws FileNotFoundException {
        rent.setamount(Double.parseDouble(rentalCostField.getText()));
        WriteFileKm();
       JOptionPane.showMessageDialog(null, "Receipt has been printed");
    }
    
    /**
     * This method is connected with the rent by Km button that will print a receipt 
     * @throws FileNotFoundException 
     */
    public void WriteFileKm() throws FileNotFoundException{
        int i = vehicleTable.getSelectionModel().getSelectedIndex();
        File print = new File("Receipt.txt");
        
        PrintWriter writer = new PrintWriter(print);
            writer.println("CUSTOMER COPY");
            writer.println("CAR RENTAL RECEIPT");
            writer.println("--------------------------");
            writer.println("Manufacturer: " + carList.get(i).getManufacturer()  );
            writer.println("Model: " + carList.get(i).getModel());
            writer.println("Year: " + carList.get(i).getYear());
            writer.println("Registration No: " + carList.get(i).getRegistrationNo() );
            writer.println("Odemeter Reading: " + carList.get(i).getOdemeterReading());
            writer.println("Tank Capacity: " + carList.get(i).getTankCapacity() );
            writer.println("Service Count: " + carList.get(i).serv.getServiceCount());
            writer.println("Requires Service: " + carList.get(i).getRequiresService()  );  
            writer.println( "Last Service Km: " + carList.get(i).serv.lastServiceOdometerKm );
            writer.println("Date of Last Service: " + carList.get(i).serv.getServiceDate());
            writer.println("Fuel Economy: " + carList.get(i).fuel.getFuelEconomy());
            writer.println("Level of Fuel: " + carList.get(i).fuel.getFuel());
            writer.println("Cost of Fuel: " + carList.get(i).fuel.getCost());
            writer.println("Revenue: " + carList.get(i).getRevenue());
            writer.println(" ");
            writer.println("Rental Cost: $" + rent.getRentKmCost());
            writer.println("--------------------------");
            writer.println("PLEASE RETAIN FOR YOUR RECORD");
            writer.println("THANK YOU FOR RENTING WITH US");
        writer.close();
    }
    
    /**
     * This method is connected with the rent by days button that will print a receipt
     * @throws FileNotFoundException 
     */
    public void WriteFileDays() throws FileNotFoundException{
        int i = vehicleTable.getSelectionModel().getSelectedIndex();
        File print = new File("Receipt.txt");
        
        PrintWriter writer = new PrintWriter(print);
            writer.println("CUSTOMER COPY");
            writer.println("CAR RENTAL RECEIPT");
            writer.println("--------------------------");
            writer.println("Manufacturer: " + carList.get(i).getManufacturer()  );
            writer.println("Model: " + carList.get(i).getModel());
            writer.println("Year: " + carList.get(i).getYear());
            writer.println("Registration No: " + carList.get(i).getRegistrationNo() );
            writer.println("Odemeter Reading: " + carList.get(i).getOdemeterReading());
            writer.println("Tank Capacity: " + carList.get(i).getTankCapacity() );
            writer.println("Service Count: " + carList.get(i).serv.getServiceCount());
            writer.println("Requires Service: " + carList.get(i).getRequiresService()  );  
            writer.println( "Last Service Km: " + carList.get(i).serv.lastServiceOdometerKm );
            writer.println("Date of Last Service: " + carList.get(i).serv.getServiceDate());
            writer.println("Fuel Economy: " + carList.get(i).fuel.getFuelEconomy());
            writer.println("Level of Fuel: " + carList.get(i).fuel.getFuel());
            writer.println("Cost of Fuel: " + carList.get(i).fuel.getCost());
            writer.println("Revenue: " + carList.get(i).getRevenue());
            writer.println(" ");
            writer.println("Rental Cost: $" + rent.getRentDayCost());
            writer.println("--------------------------");
            writer.println("PLEASE RETAIN FOR YOUR RECORD");
            writer.println("THANK YOU FOR RENTING WITH US");
        writer.close();
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
                           "Last Service Km: " + carList.get(v).serv.lastServiceOdometerKm + "\n " +  
                           "Date of Last Service: " + carList.get(v).serv.getServiceDate() + "\n " +
                           "Fuel Economy: " + carList.get(v).fuel.getFuelEconomy() + "\n " +
                           "Level of Fuel: " + carList.get(v).fuel.getFuel() + "\n " +
                           "Cost of Fuel: " + carList.get(v).fuel.getCost() + "\n " +
                           "Revenue: " + carList.get(v).getRevenue());
        }
        catch (Exception ex) {
            JOptionPane.showMessageDialog(null, "No vehicle selected, please select vehicle from table");
        } 
        
    }
/**
 * This action will delete a selected vehicle from the table
 * @param event 
 */
    @FXML
    private void deleteCar(ActionEvent event) {
        Vehicles selectedItem = vehicleTable.getSelectionModel().getSelectedItem();
        carList.remove(selectedItem);
        ObservableList<Vehicles> vehicles = FXCollections.observableArrayList(carList);
        vehicleTable.setItems(vehicles);
    }
    
}
