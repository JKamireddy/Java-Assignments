/**********************************************************
 *                                                        *
 *       Assignment 4       FALL 2018           *
 *                                                        *
 *                              *
 *                                                        *
 *  Due Date/Time:  10/12/2018                            *
 *  Purpose:  Enhancing the given  Program                        *
 *                                                        *
 ***********************************************************/


import java.io.IOException;
import java.util.Scanner;

public class AddressBookEntryApp{
  
         public static void main(String[] args) throws IOException {
           
           //Declaring instance variable as String
        String Name="";
        String email="";
        String CellNumber="";
        String validname;
        String validemail;
        String validphno;
       
       //Displaying the menu to choose options by user  
        System.out.println("Welcome to the Address Book Application");
        System.out.println("1 - List Entry");
        System.out.println("2 - Add Entries");
        System.out.println("3 - Exit");
        // Declaring scanner named input to take input from users
       Scanner input = new Scanner(System.in);
       AddressBookIO list=new AddressBookIO();
       
        //declaring choice by user as integer 
        int choice;
        //Do while loop to diplay options of menu 
        do {
            System.out.printf("Enter Menu Number : ");
            choice = input.nextInt();
            //Validating the choice entered by user with calling menuvalidate method from Validator class
            //if loop to display error message if choosen option is wrong 
            if((Validator.menuvalidate(choice))==0)
            {
              System.out.println("Please enter valid choice only  from 1-3  :\t ");
            }
            else
              choice = Validator.menuvalidate(choice);
            // Switch case  to display the options 
            switch (choice) 
            {
              //displays the all entries in the file when 1 is choosen 
             case 1:
             System.out.printf(list.getEntriesString());
              break;
              //Prompts user to enter name and validate it 
              case 2:
                //variable validname to validate the name field entered by user 
                //int validname ;
                //inner do while loop for prompting user again if entered name is not valid 
                do
                {
               System.out.printf("Enter name: ");
               //Storing the name entered by user to string name1 
               String inputName = input.next();
               input.nextLine();
               //Calling the namevalidation method to validate the name entered by user 
               validname = Validator.nameValidation(inputName);
               int temp1 = (Integer.parseInt(validname));
      //if loop to print error message if entered wrong else takes the name entered          
     if(temp1 != 0)
     {
       Name = inputName;
     }
     else
     {
       System.out.println("\nInvalid name, please enter the name which has all characters\n");
     }
        }
      //while condition to loop when the name is not valid           
     while((Integer.parseInt(validname))!= 1);
      //inner do loop to validate email entered by user     
     do
     {
     System.out.print("\nEnter email address :");
     String inputEmail = input.next();
     //validating email calling emailvalidation method in class validator 
     validemail = Validator.emailValidation(inputEmail);
     int temp2 = (Integer.parseInt(validemail));
     //if loop to print error message if email is not valid else takes the email entered 
     if(temp2 !=0)
       {
       email = inputEmail;
       }
     else
       {
       System.out.println("\nInvalid email, please enter an email with @ and which has '.com' domain");
       }
     }
     //while condition to validate the email  
     while((Integer.parseInt(validemail))!= 1);
     
     //inner do loop to prompt user agin if entered phmo is not valid 
     do
     {
     System.out.print("\n Enter Cell Number :");
     String inputPhone = input.next();
     //validating phno by calling cellnumber validation method in validator class 
     validphno = Validator.CellNumberValidation(inputPhone);
     //if loop to display error message if entered wrong phno else takes the entered phno 
     int temp3 = (Integer.parseInt(validphno));
     if(temp3 != 0)
       {
       CellNumber = inputPhone;
       }
     else
       {
       System.out.println("\n Please Enter valid phone number with a 10-digit number");
       }
     }
     //while condition to validate the phno 
     while((Integer.parseInt(validphno))!= 1);

        //Creating an object in this class that takes 3 arguments       
       AddressBookEntry entry=new AddressBookEntry(Name,email,CellNumber);
       //if loop that dsipalys if all entries are saved successfully else displays error message 
       if(list.saveEntry(entry)== true)
        {
          System.out.println("The entry has been saved successfully");
        }
          
          else
          {
            System.out.println("The entry has not been saved ");
          }
            break;
                case 3:
                  //when option 3 is choosen prints  goodbye message and then exits 
                  System.out.println("GoodBye");
                    System.exit(0);
                    break;
                
            }
         //main while condition that loops when  choosen option is not 3 
        }while(choice!=3);
        }
    



  }


