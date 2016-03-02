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
 * Used to compare by date + time
 * @author Ronny
 */
public class ByScheduleComp implements MyComparator{
    @Override
    public int meetCondition(Appointment anApp1,Appointment anApp2){
        return anApp1.getSchedule().compareToIgnoreCase(anApp2.getSchedule());
    }
}
