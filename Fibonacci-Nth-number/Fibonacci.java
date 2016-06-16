/*********************************************************************
 Purpose/Description: <Calculate the Nth number of the Fibonacci serie using 
                        an O(log N) algorithm>
 Certification:
 I hereby certify that this work is my own and none of it is the work of
 any other person.
 ********************************************************************/ 
package fibonacci;

import java.math.BigInteger;
import java.util.Scanner;


public class Fibonacci {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        System.out.println(fib(250).toString().equals("7896325826131730509282738943634332893686268675876375"));
        Scanner input =  new Scanner(System.in);
        boolean quit = false;
        while(!quit){
            System.out.println("Enter the index of the number ");
            String answer = input.nextLine();
            if(answer.matches("\\d+")) System.out.println(fib(Integer.valueOf(answer)));
            else quit = true;
        }
        System.out.println("Bye!!");
    }
    
    /**
     * Calculate the number in the series
     * @param num index in Fibonacci series
     * @return Fibonacci number
     */
    public static BigInteger fib(int num){
        BigInteger[][] fibMatrix = {    
            {BigInteger.ONE,BigInteger.ONE},
            {BigInteger.ONE,BigInteger.ZERO}
        };
        BigInteger[][] retMatrix = {    
            {BigInteger.ONE,BigInteger.ZERO},
            {BigInteger.ZERO,BigInteger.ONE}
        };
        while(num >0){
            if(num%2 !=0) retMatrix = MultiplyMatrixes( retMatrix, fibMatrix);
            num /=2;
            fibMatrix = MultiplyMatrixes(fibMatrix,fibMatrix);
        }
        return (retMatrix[0][1]);
    }

    /**
     * Multiply the matrixes 
     * @param matrix1
     * @param matrix2
     * @return the product
     */
    public static BigInteger[][] MultiplyMatrixes(BigInteger[][] matrix1, BigInteger[][] matrix2){
        return new BigInteger[][]{
            {matrix1[0][0].multiply(matrix2[0][0]).add( matrix1[0][1].multiply(matrix2[1][0])) ,     // m[0,0]
             matrix1[0][0].multiply(matrix2[0][1]).add( matrix1[0][1].multiply(matrix2[1][1]))},     // m[0,1]
            {matrix1[1][0].multiply(matrix2[0][0]).add( matrix1[1][1].multiply(matrix2[1][0])) ,     // m[1,0]
             matrix1[1][0].multiply(matrix2[0][1]).add( matrix1[1][1].multiply(matrix2[1][1]))}      // m[1,1]
        };  
    }

    
    
    
}
