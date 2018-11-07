/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package carrental;
import javafx.beans.property.SimpleStringProperty;
/**
 *
 * @author 20002104
 */
public class Vehicles {
    private String manufacturer;
    private String model;
    private int year;
    private String registrationNo;
    private double odemeterReading;
    private int tankCapacity;
    private String requiresService;
    private double revenue;

    public FuelPurchase fuel = new FuelPurchase();
    public Service serv = new Service();
    
    public Vehicles(String manufacturer, String model, int year, String registrationNo, double odemeterReading,
                    int tankCapacity, int lastServKM, String date, int servCount, String reqService, double fuelEco, double revenue) {
        setManufacturer(manufacturer);
        setModel(model);
        setYear(year);
        setRegistrationNo(registrationNo);
        setOdemeterReading(odemeterReading);
        setTankCapacity(tankCapacity);
        serv.recordService(lastServKM, date);
        serv.serviceCount = servCount;
        setRequiresService (reqService);
        fuel.setFuelEconomy(fuelEco);
        setRevenue(revenue);
    }
    
    public String setManufacturer(){
    return this.manufacturer;
    }
    
    public void setManufacturer(String Vmanufacturer){
    this.manufacturer = Vmanufacturer;
    }
    
    public String setModel(){
    return this.model;
    }
    
    public void setModel(String Vmodel){
    this.model = Vmodel;
    }
    
    public int setYear(){
    return this.year;
    }
    
    public void setYear(int Vyear){
    this.year = Vyear;
    }
    
    public String setRegistrationNo(){
    return this.registrationNo;
    }
    
    public void setRegistrationNo(String VregNo){
    this.registrationNo = VregNo;
    }
    
    public double setOdemeterReading(){
    return this.odemeterReading;
    }
    
    public void setOdemeterReading(double Vodemeter){
    this.odemeterReading = Vodemeter;
    }
    
    public int setTankCapacity(){
    return this.tankCapacity;
    }
    
    public void setTankCapacity(int Vtank){
    this.tankCapacity = Vtank;
    }
    
    public String setRequiresService(){
    return this.requiresService;
    }
    
    public void setRequiresService(String VreqServ){
    this.requiresService = VreqServ;
    }
    
    public double setRevenue(){
    return this.revenue;
    }
    
    public void setRevenue(double Vrev){
    this.revenue = Vrev;
    }
    
    public void printDetails() {
		System.out.println("Vehicle: " + registrationNo + " " + year + " " + manufacturer + " " + model);		
                // TODO Display additional information about this vehicle
	}

        public void addKilometers(int totalKm){
        this.odemeterReading += totalKm;
        }

        // adds fuel to the car
        public void addFuel(double litres, double price){            
            fuel.purchaseFuel(litres, price);
        }        
}
