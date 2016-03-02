////////////////////////////////////////////////////////////////////////////////

// Title:            Reservations
// Files:            (list of source files)
// Semester:         COP3337 Fall 2015
//
// Author:           1657691
// Lecturer's Name:  Cristy Charters
//
// Implementing Linked list and queue 
//
////////////////////////////////////////////////////////////////////////////////

package finalproject;

/**
 *
 * @author Ronny
 */
public interface MyComparator {

    /**
     * Searching condition
     * @param anApp1 
     * @param anApp2
     * @return true if meets the condition
     */
    public int meetCondition(Appointment anApp1,Appointment anApp2);
}
