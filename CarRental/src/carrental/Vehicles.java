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
public class Vehicles implements Comparable<Vehicles>{
    private final SimpleStringProperty vehicle = new SimpleStringProperty("");
    private final SimpleStringProperty registrationNo = new SimpleStringProperty("");
    private final SimpleStringProperty totalKm = new SimpleStringProperty("");
    private final SimpleStringProperty totalServices = new SimpleStringProperty("");
    private final SimpleStringProperty requiresService = new SimpleStringProperty("");
    
    public Vehicles() {
        this("","","","","");
    }
    public Vehicles(String vehicle, String registrationNo, String totalKm, String totalServices, String requiresService) {
        setVehicle(vehicle);
        setRegistrationNo(registrationNo);
        setTotalKm(totalKm);
        setTotalServices(totalServices);
        setRequiresService(requiresService);
    }
     public SimpleStringProperty vehicleProperty() {
        return vehicle;
    }

    public SimpleStringProperty registrationNoProperty() {
        return registrationNo;
    }

    public SimpleStringProperty totalKmProperty() {
        return totalKm;
    }
    
    public SimpleStringProperty totalServicesProperty() {
        return totalServices;
    }
    
    public SimpleStringProperty requiresServiceProperty() {
        return requiresService;
    }
    
     public void setVehicle(String vehicles) {
        vehicle.set(vehicles);
    }

    public void setRegistrationNo(String regNo) {
        registrationNo.set(regNo);
    }

    public void setTotalKm(String totalKms) {
        totalKm.set(totalKms);
    }
    
    public void setTotalServices(String services) {
        totalServices.set(services);
    }
    
    public void setRequiresService(String required) {
        requiresService.set(required);
    }
    
    
     @Override
    public int compareTo(Vehicles v) {
       String name = vehicle.getName();
       if(v!=null)
           return name.compareTo(v.vehicle.toString());
       else
           return 1;
    }  
}
