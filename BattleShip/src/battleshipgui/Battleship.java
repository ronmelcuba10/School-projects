////////////////////////////////////////////////////////////////////////////////

// Title:            Battleship
// Files:            (list of source files)
// Semester:         COP3337 Fall 2015
//
// Author:           1657691
// Lecturer's Name:  Cristy Charters
//
// Battleship game
//
////////////////////////////////////////////////////////////////////////////////
package battleshipgui;
import java.awt.Point;
import java.util.Random;
import java.util.*;

/**
 *
 * @author cristy
 */
public class Battleship {
    
    private static final String BLANK_CHAR = "_";
    private static final String SHIP_CHAR = "S";
    private static final String MISS_CHAR = "M";
    private static final String HIT_CHAR = "H";
    public final int BOARD_LINES = 8;
    public final int BOARD_LINES_W_LEGEND = 13;
    boolean ship_locations[][] = new boolean[5][5];
    boolean guess_locations[][] = new boolean[5][5];
    int totalShipsSunk;
    int totalMisses;
    
    
    /**
     * Creates the battleship
     */
    public Battleship() {
        clear_ship_locations();
        clear_guess_locations();
        initialize_ship_locations();
        
    }
    
    /**
     * Places 5 ships in the battlefield
     */
    public void initialize_ship_locations() {
        int ships_located = 0;
        Random random_generator = new Random();
        while(ships_located < 7){                     //will repeat until 4 ships have been located
            int row = random_generator.nextInt(5);    // this will generate a random number 0..4
            int col = random_generator.nextInt(5);
            if (!ship_locations[row][col]){           //if it is an empty slot
                 ship_locations[row][col] = true;     //locate the ship in that slot
                ships_located++;                      //one more ship is located
            }
        }         
    }
    
    /**
     * all the array is set to false
     */
    public void clear_ship_locations() {
        for (int row=0; row<5; row++) 
            for (int col=0; col<5; col++ )
            ship_locations[row][col] = false;
    }
    
    /**
     * all the array is set to false
     */
    private void clear_guess_locations() {
        for (int row=0; row<5; row++) 
            for (int col=0; col<5; col++ )
            guess_locations[row][col] = false;
    }
    
    
    /**
     * 
     * @param row
     * @param col
     * @return 
     */
    public boolean process_user_guess(int row, int col) {
        guess_locations[row][col] = true;
        boolean hit_it= guess_locations[row][col] == ship_locations[row][col];
        if (hit_it) totalShipsSunk++;
        else totalMisses++;
        return hit_it;
    }
    
    public boolean cell_taken(int row, int col){
        return guess_locations[row][col];
    }
    
    /**
     * Returns if the user won
     * @return true if user won
     */
    public boolean userWon() {
        return (totalShipsSunk == 7);    
    }
    
    
    /**
     * Returns true if it is a blank cell
     * @param col coordinate
     * @param row coordinate
     * @return true if is a blank cell
     */
    private boolean Blank_cell(int row, int col) {
        return !ship_locations[row][col] && !guess_locations[row][col];
        }
    
    /**
     * Returns true if it is a cell with a ship
     * @param col coordinate
     * @param row coordinate
     * @return true if it is a cell with a ship
     */
    private boolean Ship_cell(int row, int col) {
        return ship_locations[row][col] && !guess_locations[row][col];
        }
    
    /**
     * Returns true if it is a blank cell bombed
     * @param col coordinate
     * @param row coordinate
     * @return true if it is a blank cell bombed
     */
    private boolean Miss_cell(int row, int col) {
        return !ship_locations[row][col] && guess_locations[row][col];
        }

    /**
     * Returns true if a ship was bombed
     * @param col coordinate
     * @param row coordinate
     * @return true if a ship bombed
     */
    private boolean Hit_cell(int row, int col) {
        return ship_locations[row][col] && guess_locations[row][col];
        }
    
    /**
     * Build the game board 
     * @return The board in 5 lines of text
     */
    public String[] Get_Board_Status() {
        String[] Board = new String[8];
        Board[0] = "#,0,1,2,3,4,";
        for (int row=1; row<6; row++){
            String Line = "";
            Line = Line + Integer.toString(row-1);
            for (int col=0; col<5; col++ ){
                if (Blank_cell(row-1,col)) Line = Line + "," + BLANK_CHAR; 
                if (Ship_cell(row-1,col))  Line = Line + "," + SHIP_CHAR;
                if (Miss_cell(row-1,col))  Line = Line + "," + MISS_CHAR;
                if (Hit_cell(row-1,col))   Line = Line + "," + HIT_CHAR;
            }
            Board[row] = Line + ",";
        }
        Board[6] = "Hits    -> " + totalShipsSunk;
        Board[7] = "Misses  -> " + totalMisses;
        return Board;
    }

    /**
     * Prints the legend
     */
    void Show_legend() {
        System.out.println("Legend : ");
        System.out.println("Blank cell -> " + BLANK_CHAR);
        System.out.println("Ship cell -> " + SHIP_CHAR);
        System.out.println("Miss shot -> " + MISS_CHAR);
        System.out.println("Hit ship -> " + HIT_CHAR);
    }
    
    /**
     * Returns the board with the legend
     * @return 
     */
    public String[] Get_Board_StatuswithLegend() {
        String[] Board = new String[13];
        for (int i=0;i<8;i++){
            Board[i] = Get_Board_Status()[i];
        }
        Board[8] = "Legend : ";
        Board[9] = "Blank cell -> " + BLANK_CHAR;
        Board[10] = "Ship cell -> " + SHIP_CHAR;
        Board[11] = "Miss shot -> " + MISS_CHAR;
        Board[12] = "Hit ship -> " + HIT_CHAR;
        return Board;
    }

    /**
     * Builds a list with the positions of the survivors 
     * @return
     */
    public Point[] remaining_Ships() {
        Point[] ships = {new Point(6,6),new Point(6,6),new Point(6,6),new Point(6,6),
                         new Point(6,6),new Point(6,6),new Point(6,6),new Point(6,6)};
        int ships_counter = 0;
        for(int i=0;i<5;i++)
            for(int j=0;j<5;j++) 
                if (ship_locations[i][j] && !guess_locations[i][j]){
                    ships[ships_counter].x = i;
                    ships[ships_counter].y = j;
                    ships_counter++;
                } 
        return ships;
    }
}