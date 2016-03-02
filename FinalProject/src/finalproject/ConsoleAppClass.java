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
 * The results of my test data using the console
 * this class does the same as the GUI
 * everything is hard-coded
 * @author 
 */
public class ConsoleAppClass {
    MyLinkedList AppList;
    MyLinkedQueue WaitList;
    MyLinkedList.LinkedListIterator myIter;

    public ConsoleAppClass() {
        AppList = new MyLinkedList();
        myIter = AppList.listIterator();
        WaitList = new MyLinkedQueue();
    }

       
    /**
     * makes an app
     * @param anApp 
     */
    private void makeApp(Appointment anApp){
        if (!myIter.makeAppointment(anApp)) WaitList.addToWaitingList(anApp);
        System.out.println("add:  => " + anApp.toString());
    }
    
    /**
     * changes an app
     * @param oldApp
     * @param newApp 
     */
    private void changeApp(Appointment oldApp, Appointment newApp) {
        if (myIter.replaceAppointment(oldApp)) {                        
            if (myIter.makeAppointment(newApp)) {                       
            } else {
                WaitList.addToWaitingList(newApp);                      
            }
        }
        System.out.println("change:  => " + oldApp.toString() + " for " + newApp.toString());
    }
    
    /**
     * Processes the waiting list
     */
    private void processApp() {
        if (!WaitList.empty()) {
            Appointment anApp = WaitList.dequeue();
            if (!myIter.makeAppointment(anApp)) {
                WaitList.addToWaitingList(anApp);
            }
        }
        System.out.println("Preocesing queue");
    }
    
    /**
     * cancels an app
     * @param anApp 
     */
    public void cancelApp(Appointment anApp){
        myIter.replaceAppointment(anApp); 
        System.out.println("cancels:  => " + anApp.toString());
    }
    
    /**
     * shows both list
     */
    public void printLists(){
        System.out.println("APPOINTMENTS");
        System.out.print(myIter.list());
        System.out.println();
        System.out.println("WAITING LIST");
        System.out.print(WaitList.list());
        System.out.println();
    }
    
    /**
     * the line of commands
     */
    public void excecute(){
        int i=0;
        System.out.println("Step " + i++);
        Appointment app1 = new Appointment("John", "Smith", "2015 05 12", 15);
        makeApp(app1);
        printLists();
        System.out.println("Step " + i++);
        Appointment app2 = new Appointment("Mary", "Jones", "2015 05 12", 14);
        makeApp(app2);
        printLists();
        System.out.println("Step " + i++);
        Appointment app21 = new Appointment("Jaime", "Medio", "2015 04 16", 13);
        makeApp(app21);
        printLists();
        System.out.println("Step " + i++);
        Appointment app22 = new Appointment("Raime", "Medio y mas", "2015 04 16", 12);
        makeApp(app22);
        printLists();
        System.out.println("Step " + i++);
        Appointment app3 = new Appointment("Jim", "Hernandez", "2015 05 12", 13);
        makeApp(app3);
        printLists();
        System.out.println("Step " + i++);
        Appointment app31 = new Appointment("Jimmy", "Hoffa", "2015 05 12", 11);
        makeApp(app31);
        printLists();
        System.out.println("Step " + i++);
        changeApp(  new Appointment("Mary", "Jones", "2015 05 12", 14),
                    new Appointment("Mary", "Jones", "2015 05 12", 9));
        printLists();
        System.out.println("Step " + i++);
        Appointment app4 = new Appointment("Ron", "Stevens", "2015 05 12", 10);
        makeApp(app4);
        printLists();
        System.out.println("Step " + i++);
        cancelApp(new Appointment("John", "Smith", "2015 05 12", 15));
        printLists();
        System.out.println("Step " + i++);
        Appointment app5 = new Appointment("Nick", "Hernandez", "2015 05 13", 9);
        makeApp(app5);
        printLists();
        System.out.println("Step " + i++);
        Appointment app6 = new Appointment("Joe", "Kline", "2015 05 13", 9);
        makeApp(app6);
        printLists();
        System.out.println("Step " + i++);
        Appointment app7 = new Appointment("Maria", "Garcia", "2015 05 13", 11);
        makeApp(app7);
        printLists();
        System.out.println("Step " + i++);
        Appointment app8 = new Appointment("Jose", "Gonzalez", "2015 05 13", 11);
        makeApp(app8);
        printLists();
        System.out.println("Step " + i++);
        changeApp(  new Appointment("Maria", "Garcia", "2015 05 13", 11),
                    new Appointment("Maria", "Garcia", "2015 05 14", 11));
        printLists();
        System.out.println("Step " + i++);
        changeApp(  new Appointment("Nick", "Hernandez", "2015 05 13", 9),
                    new Appointment("Nick", "Hernandez", "2015 05 13", 10));
        printLists();
        System.out.println("Step " + i++);
        cancelApp(app3);  
        printLists();
        System.out.println("Step " + i++);
        processApp(); 
        printLists();
        System.out.println("Step " + i++);
        processApp();
        printLists();
    }
    
}
