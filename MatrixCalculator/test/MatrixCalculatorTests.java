/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

import matrixcalculator.Matrix;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author jalagus
 */
public class MatrixCalculatorTests {
    
    public MatrixCalculatorTests() {
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

    @Test
    public void matriisienYhteenlaskuPalauttaaOikein() {
        double[][] matA = {{1,2},{2,4}};
        double[][] matB = {{1,2},{2,4}};
        double[][] matC = {{2,4},{4,8}};
        
        Matrix A = new Matrix(matA);
        Matrix B = new Matrix(matB);
        Matrix C = new Matrix(matC);
        
        assertEquals(C, A.add(B));
    }

    
    @Test
    public void matriisinKertolaskuKertoimenKanssaPalauttaaOikein() {
        double[][] matA = {{1,2},{2,4}};
        double[][] matB = {{3,6},{6,12}};
        
        Matrix A = new Matrix(matA);
        Matrix B = new Matrix(matB);
        
        assertEquals(B, A.multiply(3));
    } 
    
    @Test
    public void matriisienKertolaskuPalauttaaOikein() {
        double[][] matA = {{1,4},{1,2}};
        double[][] matB = {{1,2},{6,1}};
        double[][] matC = {{25,6},{13,4}};
        
        Matrix A = new Matrix(matA);
        Matrix B = new Matrix(matB);
        Matrix C = new Matrix(matC);
        
        assertEquals(C, A.multiply(B));
    }
    
    @Test
    public void matriisinDeterminanttiLasketaanOikein() {
        double[][] matA = {{1,4},{1,2}};
        
        Matrix A = new Matrix(matA);
        try {
            assertEquals(A.determinant(), -2);
        }
        catch (Exception ex) {
            
        }
    }
}
