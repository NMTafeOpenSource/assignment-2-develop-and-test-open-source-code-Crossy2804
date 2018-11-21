package carrental;

public class Service {
    
    // Constant to indicate that the vehicle needs to be serviced every 10,000km
    public static final int SERVICE_KILOMETER_LIMIT = 10000;
    
    public int lastServiceOdometerKm=0;
    public int serviceCount=0;
    public String lastServiceDate="No Date";
    
    // return the last service
    public int getLastServiceOdometerKm()
    {
        return this.lastServiceOdometerKm;
    }  
    
    public void setLastServiceOdometerKm(int vOdometerKm){
        this.lastServiceOdometerKm = vOdometerKm;
    }
    
    // return how many services the car has had
    public int getServiceCount()
    {
        return this.serviceCount;
    }
    
    public String getServiceDate(){
    return this.lastServiceDate;
    }
    /**
     * The function recordService expects the total distance traveled by the car, 
     * saves it and increase serviceCount.
     * @param distance 
     */
    public void recordService(int distance, String date)
    {
        this.lastServiceOdometerKm = distance;
        this.serviceCount ++;
        this.lastServiceDate = date;
    }
    /**
     * Calculates the total services by dividing kilometers by
     * {@link #SERVICE_KILOMETER_LIMIT} and floors the value. 
     * 
     * @return the number of services needed per SERVICE_KILOMETER_LIMIT
     */
    public int getTotalScheduledServices() {
            return (int) Math.floor(lastServiceOdometerKm / SERVICE_KILOMETER_LIMIT);
    }
    
}
