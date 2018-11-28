/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package carrental;

/**
 *
 * @author 20002104
 */
public class RentalCost {
    private double days = 100;
    private double km = 1.50;
    private double amount;
    
    public double getamount(){
    return this.amount;
    }
    
    public void setamount(double vAmount){
    this.amount = vAmount;
    }
    
    public  double getRentDayCost(){
    return amount * days;
    }
    
    public double getRentKmCost(){
    return amount * km;
    }
    
    public double getTotal(double vmade){
    return vmade += amount;
    }
    
    public static double RentKmCost(double amount, double km){
    return amount * km;
    }
    
    public  static double RentDayCost(double amount, double days){
    return amount * days;
    }
    
}
