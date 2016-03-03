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

/**
 *
 * @author
 */
import java.util.*;

/**
 * 
 */

public class PhoneBookSimulation {
    
      

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        //create an array list
        ArrayList myFriends = new ArrayList();
        myFriends = BuildTheList();//Adds the 5 friend to the list
        ChangeFirstPhoneNumber(myFriends);//Changes first phone number 
        RemoveLastFriend(myFriends);//Removes the last friend
        DisplayAllFriends(myFriends,"Third exercise: My friends list");//Displays all the list
    }
    
    /**
     *
     * Creates the list of friend
     * @return The new list of friends 
     */
    private static ArrayList BuildTheList() {
        System.out.print("Entering the five friends:");
        ArrayList Friends = new ArrayList();
        Friends.add(new Friend("John","Smith","(305)453-7865"));
        Friends.add(new Friend("Paul","Bael","(305)412-8165"));
        Friends.add(new Friend("Sara","Palmer","(786)675-0465"));
        Friends.add(new Friend("Ron","Handler","(954)998-0065"));
        Friends.add(new Friend("Gina","Lange","(754)333-1235"));
        DisplayAllFriends(Friends,"");
        return Friends;
    }
    
    /**
     * Changes the phone number of the first friend in the list
     * @param Friends Contains the list of friends
     * 
     */
    private static void ChangeFirstPhoneNumber(ArrayList Friends) {
        System.out.println("First exercise: Changing phone number of the my first friend");
        //Gets the first friend
        Friend FirstFriend = (Friend)Friends.get(0);
        //Gets the new phone number
        Scanner in = new Scanner(System.in);
        boolean validated;
        do {
            System.out.print("Please, enter the new phone number (###)-###-####: ");
            String newPhoneNumber = in.next();
            validated = FirstFriend.ValidatePhoneNumber(newPhoneNumber);// Is it a valid phone number
            /*
                If it is valid the number is changed
            else a message of error is displayed
            */
            if (validated) FirstFriend.SetPhoneNumber(newPhoneNumber); //
            else System.out.println("The phone number has to be in this format: (###)-###-####");
            /*  Continues in the cycle until a valid
                phone number is entered
            */
        }while (!validated);
        DisplayAllFriends(Friends,"First friend's phone number changed");
    }
    
    
    /**
     * Removes the last occurrence of the friend's list
     * @param Friends Contains the list of friends
     * 
     */
    private static void RemoveLastFriend(ArrayList Friends) {
        System.out.print("Second exercise: Removing the last friend");
        if (!Friends.isEmpty()) Friends.remove(Friends.size()-1);
        DisplayAllFriends(Friends,"");
        }

    /**
     * Displays the list of friends
     * @param Friends Contains the list of Friends
     * @param Message message header
     * 
     */
    private static void DisplayAllFriends(ArrayList Friends, String Message) {
        System.out.println(Message);
        int index = 0;
        while (!Friends.isEmpty() && index<Friends.size()){
            System.out.println(Friends.get(index).toString());
            index++;
        }
        System.out.println();
    }
}
