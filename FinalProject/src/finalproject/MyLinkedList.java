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
import java.util.NoSuchElementException;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

/**
 * A linked list is a sequence of nodes with efficient element insertion and
 * removal. This class contains a subset of the methods of the standard
 * java.util.LinkedList class.
 */
public class MyLinkedList {

    private Node first;

    /**
     * Constructs an empty linked list.
     */
    public MyLinkedList() {
        first = null;
    }

    /**
     * Returns the first element in the linked list.
     *
     * @return the first element in the linked list
     */
    public Object getFirst() {
        if (first == null) {
            throw new NoSuchElementException();
        }
        return first.data;
    }

    /**
     * Removes the first element in the linked list.
     *
     * @return the removed element
     */
    public Appointment removeFirst() {
        if (first == null) {
            throw new NoSuchElementException();
        }
        Appointment element = first.data;
        first = first.next;
        return element;
    }

    /**
     * Adds an element to the front of the linked list.
     *
     * @param element the element to add
     */
    public void addFirst(Appointment element) {
        Node newNode = new Node();
        newNode.data = element;
        newNode.next = first;
        first = newNode;
    }

    /**
     * Returns an iterator for iterating through this list.
     *
     * @return an iterator for iterating through this list
     */
    public LinkedListIterator listIterator() {
        return new LinkedListIterator();
    }


    class Node {

        public Appointment data;
        public Node next;
    }

    /**
     * To iterate through the list
     */
    class LinkedListIterator implements ListIterator {

        private Node position;
        private Node previous;
        private boolean isAfterNext;

        /**
         * Constructs an iterator that points to the front of the linked list.
         */
        public LinkedListIterator() {
            position = null;
            previous = null;
            isAfterNext = false;
        }

        /**
         * Set the iterator at the beginning
         */
        public void setFirst() {
            position = first;
            previous = null;
            isAfterNext = true;
        }

        /**
         * Moves the iterator past the next element.
         *
         * @return the traversed element
         */
        @Override
        public Appointment next() {
            if (!hasNext()) {
                throw new NoSuchElementException();
            }
            previous = position; // Remember for remove
            isAfterNext = true;
            if (position == null) {
                position = first;
            } else {
                position = position.next;
            }
            return position.data;
        }

        /**
         * Tests if there is an element after the iterator position.
         *
         * @return true if there is an element after the iterator position
         */
        @Override
        public boolean hasNext() {
            if (position == null) {
                return first != null;
            } else {
                return position.next != null;
            }
        }

        /**
         * Adds an element before the iterator position and moves the iterator
         * past the inserted element.
         *
         * @param element the element to add
         */
        @Override
        public void add(Appointment element) {
            if (position == null) {
                addFirst(element);
                position = first;
            } else {
                Node newNode = new Node();
                newNode.data = element;
                newNode.next = position.next;
                position.next = newNode;
                position = newNode;
            }
            isAfterNext = false;
        }

        /**
         * Removes the last traversed element. This method may only be called
         * after a call to the next() method.
         */
        @Override
        public void remove() {
            if (!isAfterNext) {
                throw new IllegalStateException();
            }
            if (position == first) {
                removeFirst();
            } else {
                previous.next = position.next;
            }
            position = previous;
            isAfterNext = false;
        }

        /**
         * Sets the last traversed element to a different value.
         *
         * @param element the element to set
         */
        @Override
        public void set(Appointment element) {
            if (!isAfterNext) {
                throw new IllegalStateException();
            }
            position.data = element;
        }

        /**
         * finds an appointment in the sorted list using different conditions
         * myComparator implements three searching conditions
         *
         * @param anApp
         * @param myComp
         * @return the appointment if found, null if not
         */
        public Appointment find(Appointment anApp, MyComparator myComp) { // to search using different conditions
            setFirst();
            if (position!=null){
                int comp;
                do{
                    comp = myComp.meetCondition(anApp, position.data); 
                    if (comp==0) return position.data;
                    if (!hasNext()) return null;
                    if (comp>0) next();
                } while ( comp > 0);
            }
            return null;
        }

        /**
         * Adds an appointment to the list of sorted appointments
         *
         * @param the appointment to be inserted
         * @return true if added false if is not
         */
        public boolean makeAppointment(Appointment anApp) {
            if(first==null) addFirst(anApp);                                    // now is the first one
            else {                                                              // if the linked list is not empty
                setFirst();                                                     // from the beginning
                ByScheduleComp myComp = new ByScheduleComp();                   // create my comparator
                int Comp = myComp.meetCondition(anApp, position.data);          // -1 or 0 or 1
                if (Comp==0) return false;                                      // is not available
                if (Comp<0) addFirst(anApp);                                    // is the first one
                else {                                                          // not the first one
                    while(hasNext()){                                           // while there are more
                        Comp = myComp.meetCondition(anApp, position.next.data); // -1 or 0 or 1
                        if (Comp==0) return false;                              // schedule is taken
                        if (Comp<0) break;                                      // next is greater exit the loop, the position is found
                        else next();                                            //if minor the go to the next 
                    }
                    add(anApp);                                      // add the apointment
                }
            }
            return true;                                                        //once here the app was added                                                // true                                     
        }

        
        
        /**
         * Removes an appointment that matches in all the fields
         *
         * @param oldApp
         * @return
         */
        public boolean replaceAppointment(Appointment oldApp) {
            if (find(oldApp, new ByAllFieldsComp()) != null) {
                remove();
                return true;
            }
            return false;
        }

              
        /**
         * To use it in the console
         * 
         * @return string lines of appointments
         */
        public String list() {
            setFirst();
            String result = "";
            while (position!=null) {
                result = result.concat(position.data.toString() + "\n");
                position = position.next;
            }
            return result;
        }

        /**
         * Adds all the appointments to the Table passed as parameter
         * 
         * @param the table to be filled up
         */
        public void getAppointmentrows(JTable aTable) {
            DefaultTableModel model = (DefaultTableModel) aTable.getModel();
            model.setRowCount(0);
            setFirst();
            while(position!=null){
                model.addRow(position.data.getrow());
                position = position.next;
            }
        }

    }

}
