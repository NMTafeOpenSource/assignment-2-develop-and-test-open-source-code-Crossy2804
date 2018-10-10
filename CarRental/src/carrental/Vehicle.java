package carrental;

import javafx.beans.property.SimpleStringProperty;

public class Vehicle{
	private String	manufacturer;
	private String	model;
	private int	makeYear;
        private int     registrationNum;
        
        // TODO add variable for OdometerReading (in KM), 
        // TODO add variable for TankCapacity (in litres)
               
	private FuelPurchase	fuelPurchase;

	/**
	 * Class constructor specifying name of make (manufacturer), model and year
	 * of make.
	 * @param manufacturer
	 * @param model
	 * @param makeYear
         * @param registrationNum
	 */
	public Vehicle(String manufacturer, String model, int makeYear, int registrationNum) {
		this.manufacturer = manufacturer;
		this.model = model;
		this.makeYear = makeYear;
                this.registrationNum = registrationNum;
		fuelPurchase = new FuelPurchase();
	}

	/**
	 * Prints details for {@link Vehicle}
	 */
	public void printDetails() {
		System.out.println("Vehicle: " + registrationNum + " " + makeYear + " " + manufacturer + " " + model);		
                // TODO Display additional information about this vehicle
	}

        public void addKilometers(){
        
        }
        // TODO Create an addKilometers method which takes a parameter for distance travelled 
        // and adds it to the odometer reading. 

        // adds fuel to the car
        public void addFuel(double litres, double price){            
            fuelPurchase.purchaseFuel(litres, price);
        }        
}
