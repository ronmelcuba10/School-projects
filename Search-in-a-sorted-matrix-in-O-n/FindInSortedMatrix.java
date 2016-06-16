/*********************************************************************
 Purpose/Description: <Find a number in a sorted matrix  using a O(n) algorithm>
 Certification:
 I hereby certify that this work is my own and none of it is the work of
 any other person.
 ********************************************************************/ 
package findinsortedmatrix;

import java.util.Scanner;

/**
 * The most important in the solution is to start from a point in which 
 * the comparison with the actual element give us only one choice. For example, 
 * starting from [0,0] is a bad choice, because if the element is less than the current 
 * then both the column and the row need to be checked. However, if we start from [0,N] or 
 * [N,0] we have only one way to go for each condition( in this case <,> and = ). The worst
 * case scenario is when the element is at the end of the diagonal or not present, for which 
 * this algorithm is going to take 2N => O(N)
 */
public class FindInSortedMatrix {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        int[][] matrix = {  
                            {26, 22, 17, 10},
                            {19, 16, 12,  7},
                            {12, 10,  7,  4},
                            { 5,  4,  2,  1}
        };
        
        Scanner input =  new Scanner(System.in);
        boolean quit = false;
        while(!quit){
            for(int i = 0; i < 4; i++)System.out.printf("%-5s %-5s %-5s %-5s\n", matrix[i][0], matrix[i][1], matrix[i][2], matrix[i][3]);
            System.out.println("Enter the number to find ");
            String answer = input.nextLine();
            if(answer.matches("-?\\d+")) System.out.println("Element " + (searchElement(matrix,Integer.valueOf(answer)) ? "FOUND" : "NOT FOUND"));
            else quit = true;
        }
        System.out.println("Bye!!");
        
        
    }

    public static boolean searchElement(int[][] matrix, int el){
        int N = matrix[0].length;                               // matrix must be NxN
        int row = 0, col = N-1;                                 // starting point
        while(row<N && col>=0){                                 // inside the matrix limits
            if(el == matrix[row][col])return true;              // once is found finish and return true
            if(el < matrix[row][col]) row++;                    // going down, the numbers decrease in a column
            else col--;                                         // going left the numbers increase in a row
        }
        return false;                                           // once in this point the element was not found
    }

    
}
