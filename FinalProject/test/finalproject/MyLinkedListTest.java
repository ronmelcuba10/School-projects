/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package finalproject;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author Ronny
 */
public class MyLinkedListTest {
    
    public MyLinkedListTest() {
    }
    
    @BeforeClass
    public static void setUpClass() {
    }
    
    @AfterClass
    public static void tearDownClass() {
    }
    
    @Before
    public void setUp() {
    }
    
    @After
    public void tearDown() {
    }

    /**
     * Test of getFirst method, of class MyLinkedList.
     */
    @Test
    public void testGetFirst() {
        System.out.println("getFirst");
        MyLinkedList instance = new MyLinkedList();
        for (int i = 0; i < 20; i++)
        {
            instance.addFirst(null);
        }
    }

    /**
     * Test of removeFirst method, of class MyLinkedList.
     */
    @Test
    public void testRemoveFirst() {
        System.out.println("removeFirst");
        MyLinkedList instance = new MyLinkedList();
        Appointment expResult = null;
        Appointment result = instance.removeFirst();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of addFirst method, of class MyLinkedList.
     */
    @Test
    public void testAddFirst() {
        System.out.println("addFirst");
        Appointment element = null;
        MyLinkedList instance = new MyLinkedList();
        instance.addFirst(element);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of listIterator method, of class MyLinkedList.
     */
    @Test
    public void testListIterator() {
        System.out.println("listIterator");
        MyLinkedList instance = new MyLinkedList();
        MyLinkedList.LinkedListIterator expResult = null;
        MyLinkedList.LinkedListIterator result = instance.listIterator();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }
    
}
