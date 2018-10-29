/**********************************************************
 *                                                        *
 *  CSCI-502       Assignment 4       FALL 2018           *
 *                                                        *
 *  NAME: SAHITHI KAMIREDDY                               *
 *                                                        *
 *  Due Date/Time:  10/05/2018                            *
 *  Purpose:  Java Console Program                        *
 *                                                        *
 ***********************************************************/
class Destination {
    // declaring Variables
    int normalMiles, FrequentFlyerMiles, additionalMiles, startMonth, endMonth;
    String destinationCity;
    
    // Constructor 
    Destination(int normalMiles, int FrequentFlyerMiles, int additionalMiles, int startMonth, int endMonth, String destinationCity) {
      this.normalMiles = normalMiles;
      this.FrequentFlyerMiles = FrequentFlyerMiles;
      this.additionalMiles = additionalMiles;
      this.startMonth = startMonth;
      this.endMonth = endMonth;
      this.destinationCity = destinationCity;
    }
    
    // Setter and Getter for Normal Miles
    public void setNormalMiles(int normalMiles) {
      this.normalMiles = normalMiles;
    }
    public int getNormalMiles() {
      return normalMiles;
    }
    
     // Setter and Getter for the frequentflyer Miles
    public void setFrequentFlyerMiles(int FrequentFlyerMiles) {
      this.FrequentFlyerMiles = FrequentFlyerMiles;
    }
    public int getFrequentFlyerMiles() {
      return FrequentFlyerMiles;
    }
    
     // Setter and Getter for Additional Miles
    public void setAdditionalMiles(int additionalMiles) {
      this.additionalMiles = additionalMiles;
    }
    public int getAdditionalMiles() {
      return additionalMiles;
    }
    
    // Setter and Getter forthe  Start Month
    public void setStartMonth(int startMonth) {
      this.startMonth = startMonth;
    }
    public int getStartMonth() {
      return startMonth;
    }
    
    // Setter and Getter for the End Month
    public void setEndMonth(int endMonth) {
      this.endMonth = endMonth;
    }
    public int getEndMonth(){
      return endMonth;
    }
    
    // Setter and Getter for Destination City
    public void setDestinationCity(String destinationCity) {
      this.destinationCity = destinationCity;
    }
    public String getDestinationCity() {
      return destinationCity;
    }
}