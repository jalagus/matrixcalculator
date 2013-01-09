package matrixcalculator.logic;

import org.junit.Test;
import static org.junit.Assert.*;

public class MatrixTransposeTest {
    
    public MatrixTransposeTest() {
    }
    @Test
    public void matriisinTranspoosiLasketaanOikein() {
        double[][] matA = {{1, 2, 3}, {4, 5, 6}};
        double[][] result = {{1, 4}, {2, 5}, {3, 6}};

        Matrix A = new MatrixTranspose(matA).transpose();
        
        Matrix B = new Matrix(result);

        assertEquals(B, A);

    }

    @Test
    public void transpoosinTranspoosiOnAlkuperainen() {
        double[][] matA = {{1, 2, 3}, {4, 5, 6}};

        Matrix resultMatrix = new Matrix(matA);
        
        Matrix A = new MatrixTranspose(matA).transpose();
        
        Matrix B = new MatrixTranspose(A.getValues()).transpose();
        
        assertEquals(resultMatrix, B);
    }
}
