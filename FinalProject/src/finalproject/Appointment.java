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

import java.text.Format;
import java.text.SimpleDateFormat;

/**
 * The appointment class
 * @author Ronny
 */
public class Appointment implements Comparable<Appointment>{

    

    private String name;
    private String last;
    private String date;
    private int time;

    public Appointment(String name, String last, String date, int time) {
        this.name = name;
        this.last = last;
        this.date = date;
        this.time = time;
    }

    public String getName() {
        return name;
    }

    public String getLast() {
        return last;
    }

    public String getDate() {
        return date;
    }
    
    public String getDatetoStr() {
        Format formatter = new SimpleDateFormat("yyyy-MM-dd");
        String s = formatter.format(date);
        return s;
    }

    public int getTime() {
        return time;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setLast(String last) {
        this.last = last;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public void setTime(int time) {
        this.time = time;
    }
    
    /**
     * To compare the appointments
     * @param anApp
     * @return true if equal
     */
    public boolean equals(Appointment anApp) {
        if (anApp == null) return false;
        if (name.compareToIgnoreCase(anApp.getName())!=0) return false;
        if (last.compareToIgnoreCase(anApp.getLast())!=0) return false;
        if (date.compareTo(anApp.getDate())!=0) return false;
        return time == anApp.getTime();
    }

    /**
     * used to find an available schedule
     * @return the date + time 
     */
    public String getSchedule() {
        String tempTime = String.valueOf(time) ;
        if (time == 9) tempTime = "09"; 
        return date + " " + tempTime;
    }

    /**
     * used to find a person in the appointments list
     * @return name + last
     */
    public String getFullName() {
        return name + " " + last;
    }
    
    /**
     * Used to look for an specific appointment
     * @return 
     */
    
    public String getfullApp() {
        return getSchedule() + " " + getFullName();
    }

    @Override
    public int compareTo(Appointment o) {
        return getfullApp().compareToIgnoreCase(o.getfullApp());
    }
    
    /**
     * to show in the table rows
     * @return 
     */
    public Object[] getrow() {
        Object[] result = { name, last, date, String.valueOf(time)};
        return result; 
    }

    /**
     * to print in the console
     * @return appointment in a line
     */
    @Override
    public String toString() {
        return name + " " + last + " on " + date + " at " + time + " hours";
    }
    
}
