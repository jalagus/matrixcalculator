package matrixcalculator.logic;

/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

import static org.junit.Assert.*;
import org.junit.Test;

/**
 *
 * @author jalagus
 */
public class MatrixTest {

    public MatrixTest() {
    }

    @Test
    public void konstruktoriAlustaaOikein() {
        double[][] matA = {{1, 2}, {2, 4}, {3, 4}};

        Matrix A = new Matrix(matA);

        assertEquals(3, A.rows);
        assertEquals(2, A.columns);

        double[][] testMatrix = A.getValues();

        for (int i = 0; i < testMatrix.length; i++) {
            for (int a = 0; a < testMatrix[0].length; a++) {
                assertEquals(testMatrix[i][a], matA[i][a], 2);
            }
        }
    }
    
    @Test
    public void tulostaaMatriisinOikein() {
        double[][] matA = {{1, 2, 0}, {0, 2, 1}, {-1, 2, 1}};
        
        Matrix A = new Matrix(matA);
        
        String output = 
                "|  1.000   2.000   0.000  |\n" +
                "|  0.000   2.000   1.000  |\n" +
                "| -1.000   2.000   1.000  |\n";
        
        assertEquals(output, A.toString());
        
    }
    
    @Test
    public void equalsPalauttaaOikein() {
        double[][] matA = {{2,-1,-2},{-4,6,3},{-4,-2,8}};
        double[][] matB = {{2,-1,-2},{-4,6,3},{-4,-2,8}};
        double[][] matC = {{2,-1,-2},{-4,9,3},{-4,-2,8}};

        Matrix A = new Matrix(matA);
        Matrix B = new Matrix(matB); 
        Matrix C = new Matrix(matC); 
        
        // Kaksi samansisältöistä tunnistetaan samaksi
        assertTrue(A.equals(B));
        
        // Kaksi eri sisältöistä tunnistetaan erilaisiksi
        assertFalse(A.equals(C));
        
        // Eri tyyppinen olio tunnistetaan erilaiseksi
        assertFalse(A.equals("Test"));
    }
    

    

}
