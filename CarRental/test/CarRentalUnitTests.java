/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;
import carrental.RentalCost;
import carrental.FuelPurchase;
import static junit.framework.Assert.assertEquals;
/**
 *
 * @author mistr
 */
public class CarRentalUnitTests {
    
    public CarRentalUnitTests() {
    }
    
    @BeforeClass
    public static void setUpClass() {
    }
    
    @AfterClass
    public static void tearDownClass() {
    }
    
    @Before
    public void setUp() {
    }
    
    @After
    public void tearDown() {
    }
    
    @Test 
       public void getRentDayCost(){
       double actual = RentalCost.RentDayCost(20, 100);
       double expected = 2000;
       assertEquals(expected, actual);
       
       actual = RentalCost.RentKmCost(40, 100);
       expected = 4000;
       assertEquals(expected, actual);
       
       actual = RentalCost.RentKmCost(3, 100);
       expected = 300;
       assertEquals(expected, actual);
       }
       
       @Test 
       public void getKmRentCost(){
       double actual = RentalCost.RentKmCost(20, 1.5);
       double expected = 30;
       assertEquals(expected, actual);
       
       actual = RentalCost.RentKmCost(1028, 1.5);
       expected = 1542;
       assertEquals(expected, actual);
       
       actual = RentalCost.RentKmCost(58395, 1.5);
       expected = 87592.5;
       assertEquals(expected, actual);
       }
       
        @Test 
       public void getFuelCost(){
       double actual = FuelPurchase.FuelCost(20, 1.4);
       double expected = 28;
       assertEquals(expected, actual);
       
       actual = FuelPurchase.FuelCost(5, 1.4);
       expected = 7;
       assertEquals(expected, actual);
       
       actual = FuelPurchase.FuelCost(36, 1.4);
       expected = 50.4;
       assertEquals(expected, actual);
       }
}
