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
                                                      
 
import java.util.Scanner; 
import java.io.File; 
import java.io.IOException; 

public class MileRedemptionApp {
    public static void main(String[] args) throws IOException {
      
      // Storing number of miles and the month of departure
      int numMiles, month; 
      char choice='y'; // Declared variable named choice to know whether user wamts to continue or exit and  Intialized to y

                       
      Scanner inputScan = new Scanner(System.in); // Scanner object created to take input from the console
      System.out.print("Please enter the name of the file: \t"); // Prompts user to enter the filename
          String fileName = inputScan.next(); // Stores the input givn by user

          Scanner fileInput = new Scanner(new File(fileName)); // Scanner object for reading the contents of the file
          MileRedeemer redeemerObj = new MileRedeemer(); // Creates an object of MileRedeemer class

          redeemerObj.readDestinations(fileInput); // Method call to readDestinations function in MileRedeemer
          System.out.println("\n---------------------------------------------------------------\n");
          System.out.println(" WELCOME TO THE JAVA AIRLINES FREQUENT FLYER MILES REDEMPTION APP");
          System.out.println("\n---------------------------------------------------------------\n");
          
          
      
     // A do wile loop to prompt user for recommendtions multiple times
      do { 
        
          choice= 'n'; // Value changed to n
          System.out.println("List of destination cities your client can travel to: ");
          


          
          // Loop to print the city names
          for(String str: redeemerObj.getCityNames()) {
            System.out.println(str);
          }
          
          System.out.println("\n---------------------------------------------");
          
          System.out.print("\nPlease enter your client's accumulated Frequent Flyer Miles:   \t"); // Prompts user          
          numMiles = inputScan.nextInt(); //Stores input
          
          // Checking  if the user input of month is valid using a while loop
          while (true) {
            
            System.out.print("\nPlease enter your client's month of departure (1-12):  \t"); // Prompts user
            month = inputScan.nextInt(); // Stores input
            
            
            if (month < 1 || month > 12) {
              System.out.print("\nPlease input a valid month number \n");
            }
            else {
              break;
            }
          }

          System.out.println("");
          
          // For each loop to print values returned by redeemMiles method
          for(String str:redeemerObj.redeemMiles(numMiles, month)) {
            System.out.println(str);
          }
          
          System.out.println("\nYour client's remaining Frequent Flyer Miles:  "+redeemerObj.getRemainingMiles()); //Displays the remaining miles after recommendations are made
          System.out.println("\n-------------------------------------------------------------------------\n");
          fileInput.close(); //close fileInput object
        
    
        
    
       
          System.out.print("\nDo you want to continue:(y/n)? \t\t"); //Prompts user to select whether he wants to continue or not
          String str = inputScan.next(); // Stores the user input
          System.out.println("\n-------------------------------------------------------------------------\n");
          choice = str.charAt(0); // Converts string into char   
        
}
     
      while(choice=='y'); // If user enters y then he will again be prompted
      
      System.out.println("\n-------------------------------------------------------------------------\n");
      System.out.println("THANK YOU FOR USING THE JAVA AIRLINES FREQUENT FLYER MILES REDEMPTION APP");
      System.out.println("\n-------------------------------------------------------------------------\n");
      inputScan.close(); // Closes the inputScan object
 
    }
}

