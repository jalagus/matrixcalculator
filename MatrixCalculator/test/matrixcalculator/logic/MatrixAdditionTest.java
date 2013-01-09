package matrixcalculator.logic;

import org.junit.Test;
import static org.junit.Assert.*;

public class MatrixAdditionTest {
    
    public MatrixAdditionTest() {
    }

    @Test
    public void kahdenMatriisinYhteenlaskuPalauttaaOikein() {
        double[][] matA = {{1, 2}, {2, 4}};
        double[][] matB = {{1, 2}, {2, 4}};
        double[][] matC = {{2, 4}, {4, 8}};

        MatrixAddition A = new MatrixAddition(matA);
        Matrix B = new Matrix(matB);
        Matrix C = new Matrix(matC);

        assertEquals(C, A.add(B));
    }

    @Test
    public void useanMatriisinYhteenlaskuPalauttaaOikein() {
        double[][] matA = {{1, 2}, {2, 4}};
        double[][] matB = {{2, 1}, {2, 4}};
        
        double[][] result = {{4, 5}, {6, 12}};

        Matrix B = new Matrix(matB);
        
        Matrix A = new MatrixAddition(matA).add(B);
        
        Matrix C = new MatrixAddition(matA).add(A);
        
        Matrix D = new Matrix(result);

        assertEquals(D, C);
    }

    @Test
    public void vaaranKokoisiaMatriisejaEiLasketaYhteen() {
        double[][] matA = {{1, 2}, {2, 4}};
        double[][] matB = {{2, 1, 5}, {2, 4, 5}};

        MatrixAddition A = new MatrixAddition(matA);
        Matrix B = new Matrix(matB);

        assertEquals(null, A.add(B));
    }
}
