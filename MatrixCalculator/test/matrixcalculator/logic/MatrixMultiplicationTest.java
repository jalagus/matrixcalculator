package matrixcalculator.logic;

import org.junit.Test;
import static org.junit.Assert.*;

public class MatrixMultiplicationTest {
    
    public MatrixMultiplicationTest() {
    }

    @Test
    public void matriisinKertolaskuKertoimenKanssaPalauttaaOikein() {
        double[][] matA = {{1, 2}, {2, 4}};
        double[][] matB = {{3, 6}, {6, 12}};

        MatrixMultiplication A = new MatrixMultiplication(matA);
        Matrix B = new Matrix(matB);

        assertEquals(B, A.multiply(3));
    }

    @Test
    public void matriisienKertolaskuPalauttaaOikein() {
        double[][] matA = {{1, 4}, {1, 2}};
        double[][] matB = {{1, 2}, {6, 1}};
        double[][] matC = {{25, 6}, {13, 4}};

        MatrixMultiplication A = new MatrixMultiplication(matA);
        Matrix B = new Matrix(matB);
        Matrix C = new Matrix(matC);

        assertEquals(C, A.multiply(B));
    }
    
    @Test
    public void vaaranKokoisiaMatriisejaEiYritetaKertoaKeskenaan() {
        double[][] matA = {{10,-1,-2},{-3,2,5},{100,0,8}};
        double[][] matB = {{2}};

        Matrix A = new MatrixMultiplication(matA).multiply(new Matrix(matB));
        
        assertEquals(null, A);
    }
}
