package carrental;

public class FuelPurchase {
	private double	fuelEconomy;
        private double litres = 0;
        private double cost = 0;

	public double getFuelEconomy() {
		return fuelEconomy;
            //return this.cost / this.litres;
	}
        
        public double getFuel(){
            return this.litres;
        }
        
        public void setFuel(double vLitres) {
		this.litres = vLitres;
	}
        
        public double getCost(){
            return this.cost;
        }
        
        public void setCost(double vCost) {
		this.cost = vCost;
	}
        
	public void setFuelEconomy(double fuelEconomy) {
		this.fuelEconomy = fuelEconomy;
	}
        public void purchaseFuel(double amount,double price){
            this.litres += amount;
            this.cost += price;
        }
}
