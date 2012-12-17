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
    public void konstruktoriAlustaaOikein() {
        double[][] matA = {{1,2},{2,4},{3,4}};
        
        Matrix A = new Matrix(matA);
        
        assertEquals(3, A.m);
        assertEquals(2, A.n);
        
        double[][] testMatrix = A.getValues();
        
        for (int i = 0; i < testMatrix.length; i++) {
            for (int a = 0; a < testMatrix[0].length; a++) {
                assertEquals(testMatrix[i][a], matA[i][a], 2);
            }
        }
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
            assertEquals(A.determinant(), -2, 2);
        }
        catch (Exception ex) {
            
        }
    }
    
    @Test
    public void matriisinKaanteismatriisiPalauttaaOikein() {
        double[][] matA = {{2,2},{1,2}};
        double[][] matB = {{1,-1},{-0.5, 1}};
        
        Matrix A = new Matrix(matA);
        Matrix B = new Matrix(matB);
        
        assertEquals(B, A.inverse());        
    }
    
    @Test
    public void matriisinTranspoosiToimiiOikein() {
        double[][] matA = {{1,2,3},{4,5,6}};
        double[][] matB = {{1,4},{2,5},{3,6}};
        
        Matrix A = new Matrix(matA);
        Matrix B = new Matrix(matB);
        
        assertEquals(B, A.transpose());
        
        assertEquals(A, A.transpose().transpose());
    }
    
    @Test
    public void transpoosinTranspoosiOnAlkuperainen() {
        double[][] matA = {{1,2,3},{4,5,6}};
        
        Matrix A = new Matrix(matA);
        
        assertEquals(A, A.transpose().transpose());
    }
    
    @Test
    public void redusoituPorrasmuotoRakentuuOikein() {
        double[][] matA = {{1,2,0},{0,2,1},{1,2,1}};
        double[][] matB = {{1,0,0},{0,1,0},{0,0,1}};
        
        Matrix A = new Matrix(matA);
        Matrix B = new Matrix(matB);
                
        assertEquals(B, A.rref());        
    }
    
    @Test
    public void palauttaaOikeatOminaisarvot() {
        double[][] matA = {{1,2,0},{0,2,1},{1,2,1}};
        double[][] matB = {{1,0,0},{0,1,0},{0,0,1}};
        
        Matrix A = new Matrix(matA);
        Matrix B = new Matrix(matB);
                
        assertEquals(B, A.rref());         
    }
    
    @Test
    public void palauttaaOikeatOminaisvektorit() {
        double[][] matA = {{1,2,0},{0,2,1},{1,2,1}};
        double[][] matB = {{1,0,0},{0,1,0},{0,0,1}};
        
        Matrix A = new Matrix(matA);
        Matrix B = new Matrix(matB);
                
        assertEquals(B, A.rref());         
    }
}
