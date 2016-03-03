////////////////////////////////////////////////////////////////////////////////

// Title:            Phone book emulator Arraylist
// Files:            (list of source files)
// Semester:         COP3337 Fall 2015
//
// Author:           1657691
// Lecturer's Name:  Cristy Charters
//
// Create a list of five friends
// Change the phone number of the first one
// Remove the last one
// Display the whole list
//
////////////////////////////////////////////////////////////////////////////////

package phonebooksimulation;

import java.util.regex.Pattern;

/**
 * Domain class
 * Contains the friend's varibles and methods
 * @author
 */
public class Friend {
    private static int friendNumber = 0;
    private String firstName;
    private String lastName;
    private String cellPhoneNumber;
    public int friendIdNumber;

    
    public Friend (String aFirstName, String aLastName, String aCellPhoneNumber){
        firstName = aFirstName;
        lastName = aLastName;
        cellPhoneNumber = aCellPhoneNumber;
        friendNumber++;
        friendIdNumber = friendNumber;
    }
    
    /**
     *
     *  
     * @return the string with all the attributes
     */
    public String toString( ){   
         return friendIdNumber + " " +  firstName + " " + lastName + " " + cellPhoneNumber;
    }

    /**
     * updates friend's phone number
     * @param newPhoneNumber new phone number 
     */
    public void SetPhoneNumber(String newPhoneNumber) {
        cellPhoneNumber = newPhoneNumber;
        }
    
    /**
     * validates the format of the phone number
     * @param newPhoneNumber
     * @return true if it meets this template (###)-###-####"
     */
    public boolean ValidatePhoneNumber(String newPhoneNumber) {
        boolean validated = Pattern.matches("\\(\\d{3}\\)-\\d{3}-\\d{4}",newPhoneNumber); 
        return validated;
        }
}