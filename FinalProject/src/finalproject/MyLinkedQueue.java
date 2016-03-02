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

import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

/**
 * The queue
 * @author Ronny
 */
class MyLinkedQueue {

    

    public void addToWaitingList(Appointment appointment) {
        enqueue(appointment);
    }


    private class Node {

        Appointment element;
        Node next;

        Node(Appointment e, Node n) {
            element = e;
            next = n;
        }
    }

    Node first = null; // head of list, where items are removed
    Node last = null; // last node in list, where items are added

    /**
     * take the first element from the queue
     * update first
     * if queue empty trow an exception
     * @return the element removed
     */
    public Appointment dequeue() {
        if (empty()) {
            throw new IllegalStateException();
        } else {
            Appointment value = first.element;
            first = first.next;
            if (first == null) {
                last = null;
            }
            return value;
        }
    }

    /**
     * add the S element at the end of the queue
     * update last
     * @param s 
     */
    public void enqueue(Appointment s) {
        if (last != null) {
            last.next = new Node(s, null);
            last = last.next;
        } else {
            last = new Node(s, null);
            first = last;
        }
    }

    /**
     * 
     * @return true if the queue is empty
     */
    public boolean empty() {
        return first == null;
    }
    
    /**
     * Builds a string with all the elements in queue
     *
     * @return lines of strings
     */
    public String list() {
        String result = "";
        Node nod = first;
        while (nod != null) {
            result = result.concat(nod.element.toString() + "\n");
            nod = nod.next;
        }
        return result;
    }
    
    void getAppointments(JTable aTable) {
        DefaultTableModel model = (DefaultTableModel) aTable.getModel();
        model.setRowCount(0);
        if (!empty()){
            Node pos = first;
            do{
                model.addRow(pos.element.getrow());
                pos = pos.next;
            } while (pos!= null);
        }
    }
}
