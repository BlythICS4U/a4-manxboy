/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package problem3;

/**
 *
 * @author manxboy
 */
public class BinaryCoefficient {
    
    /**
     * Calculates the binary coefficient based on n and r
     * 
     *    n!
     * --------
     * r!(n-r)!
     * 
     * @param n the variable n in the equation
     * @param r the variable r in the equation
     * @return the coefficient
     */
    public static int calcuateCoefficent(int n, int r) {
        return factorial(n) / (factorial(r) * factorial(n - r));
    }
    
    /**
     * Calculates the factorial of a number 
     * @param n the number to 
     * @return 
     */
    public static int factorial(int n) {
        int sum = 1;
        
        for (int i = 2; i <= n; i++) {
            sum *= i;
        }
        
        return sum;
    }
}
