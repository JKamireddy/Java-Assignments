/**********************************************************
 *                                                        *
 *  CSCI-502       Assignment 4       FALL 2018           *
 *                                                        *
 *  NAME: SAHITHI KAMIREDDY                               *
 *                                                        *
 *  Due Date/Time:  10/12/2018                            *
 *  Purpose:  Enhancing the given Program                        *
 *                                                        *
 ***********************************************************/

class AddressBookEntry {
        // Declaring private instance varibles
        private String Name;
        private String email;
        private String CellNumber;
       
        
        // Constructor with 3 arguments taking name,email and cellnumber
       public  AddressBookEntry(String Name,String CellNumber,String email){
            this.Name=Name;
            this.CellNumber=CellNumber;
            this.email = email;
           
       }
          // Setter and Getter for Names
    public void setName(String Name) {
      this.Name = Name;
    }
    public String getName() {
      return Name;
    }
    
     // Setter and Getter for the emails
    public void setEmail(String email) {
      this.email=email;
    }
    public String getEmail() {
      return email;
    }
    
     // Setter and Getter for CellNumber
    public void setCellNumber(String CellNumber) {
      this.CellNumber=CellNumber;
    }
    public String getCellNumber() {
      return CellNumber;
    }
      
        }