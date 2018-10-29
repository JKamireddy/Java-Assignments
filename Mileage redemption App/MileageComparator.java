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

import java.util.Comparator; 

class MileageComparator implements Comparator<Destination> {
    @Override
    
    // To Compare attributes of two instances of Destinations 
    public int compare(Destination d1, Destination d2) {
      
      // Comparing  normal miles between two intstances
      if(d1.getNormalMiles() > d2.getNormalMiles()) {
        return -1;
      }
      
      // Condition for if normal miles of second instance is greater than first
      else if(d1.getNormalMiles() < d2.getNormalMiles()) {
        return 1;
      }
      
      else return 0;
    }
}