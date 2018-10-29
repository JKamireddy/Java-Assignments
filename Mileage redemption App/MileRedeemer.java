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

import java.util.Arrays; 
import java.util.Collections; 
import java.util.Scanner; 
import java.util.ArrayList;
import java.io.IOException; 

class MileRedeemer {
 
    // declaring Variables
    int remainingMiles=0; // Intializeed it to 0
    String record; // Store each line from the file
    // ArrayList of type Destination is created
    ArrayList<Destination>destinationList = new ArrayList<Destination>(); 
    
    // Function to read lines from the file
    public void readDestinations(Scanner fileScanner) throws IOException {
      
        
        // If file has a newline then continue else stop
        while(fileScanner.hasNext()) {
          
          // declaring Variables
          int normalMiles, FrequentFlyerMiles, additionalMiles, startMonth, endMonth; 
          String destinationCity; 
          record = fileScanner.nextLine(); 
          
          // Spliting the records in the file 
          String[] array1 = record.split(";"); // To Split the record when semi-colon is found
          String[] array2 = array1[4].split("-"); // To Split the record when hipen is found with it's position is 4
   
          // Adding  the record into variables as Array
          destinationCity = array1[0]; 
          //converting strings to int using Integer.parse 
          normalMiles = Integer.parseInt(array1[1]);
          FrequentFlyerMiles = Integer.parseInt(array1[2]);
          additionalMiles = Integer.parseInt(array1[3]);
          startMonth = Integer.parseInt(array2[0]);
          endMonth = Integer.parseInt(array2[1]);
   
          // Creating  new object of Destination class with those objects
          Destination obj = new Destination(normalMiles,FrequentFlyerMiles,additionalMiles,startMonth,endMonth,destinationCity);
   
          // making it as ArrayList
          destinationList.add(obj);
   
        }
      }
      
    
    // getCityNames is a method which returns a String array containing Cities
    public String[] getCityNames() {
      int i = 0; 
      String[] cityNames = new String[destinationList.size()]; //String array cityNmaes is created store cityNames
      
      // cityNames is allocated with city names using for each loop   
      for(Destination d: destinationList) {
        cityNames[i] = d.getDestinationCity();
        i++;
      }
      
      Arrays.sort(cityNames); // cityNames is sorted in Ascending order
      return cityNames; // String array is returned
    }    
    
    // Method to return details about the destination city in sorted order
    public String[] redeemMiles(int miles,int month) {
      int tempMiles = miles; // Storing miles into a temp variable
      
      // ArrayLists
      ArrayList<Destination> dlist = new ArrayList<Destination>(); 
      ArrayList<String> slist = new ArrayList<String>();
     
      // Sort destinationList in descending order of Normal miles
      Collections.sort(destinationList, new MileageComparator()); 
      
      // Enhanced For Loop to parse through destination list     
      for(Destination d: destinationList) {
        
        // If the month is less that start month or greater than endmonth then if is executed
        if(month < d.getStartMonth() || month > d.getEndMonth()) {
          
          // If miles is greater than Normal miles then this object is added into abc arrayList 
          if(tempMiles > d.getNormalMiles()) {   
            dlist.add(d);
            tempMiles-= d.getNormalMiles(); // Miles are decreased by normal miles of the current instance
          }
        }
        
        // If month is in super saver miles then execute this
        else if(month >= d.getStartMonth() && month <= d.getEndMonth()) {
          
         // If miles is greter than super saver then the miles is decresed by super saver ad the current instance of Destiantion is added into array list abc
          if(tempMiles > d.getFrequentFlyerMiles()) {
            
            dlist.add(d); 
            tempMiles -= d.getFrequentFlyerMiles();
          }
        }
      }
 
      for(Destination d: dlist) {
       // If the miles is greater than additional miles then ticket is redeemed to first class and miles is decreased by additional miles 
        
        if(tempMiles > d.getAdditionalMiles()) {
          slist.add("* A trip to "+d.getDestinationCity()+" in first class"); //Adding string into slist 
          tempMiles -= d.getAdditionalMiles();
        }
        
        // If miles is less than additional miles then economy class ticket is recommended
        else {
          slist.add("* A trip to "+d.getDestinationCity()+" in economy class"); // Displaying economy class with destination city
        }
      }
      
      if(slist.size() < 1) {
          slist.add("*** Your client has not accumulated enough Frequent Flyer Miles ***");
      }
      
        remainingMiles = tempMiles; // Fill remainingMiles with mile left
        String[] details = new String[slist.size()]; // String array is created with size of slist
        details = slist.toArray(details); // Populated with arraylist of type string
        
     return details; // Return the details
    }
    
    // Getter: Returns the remaining miles
    public int getRemainingMiles() {
     return remainingMiles; 
    }
    
}

