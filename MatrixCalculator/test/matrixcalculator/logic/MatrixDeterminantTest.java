package matrixcalculator.logic;

import org.junit.Test;
import static org.junit.Assert.*;

public class MatrixDeterminantTest {
    
    public MatrixDeterminantTest() {
    }

    @Test
    public void matriisin2x2DeterminanttiLasketaanOikein() {
        double[][] matA = {{1, 4}, {1, 2}};

        MatrixDeterminant A = new MatrixDeterminant(matA);
        
        try {
            assertEquals(A.determinant(), -2, 2);
        } catch (Exception ex) {
        }
    }

    @Test
    public void matriisin4x4DeterminanttiLasketaanOikein() {
        double[][] matA = {{2, 3, 1, 4}, {4, 3, 1, 6}, {6, 2, 4, 3}, {6, 5, 1, 7}};

        MatrixDeterminant A = new MatrixDeterminant(matA);

        try {
            assertEquals(A.determinant(), 64, 2);
        } catch (Exception ex) {
        }
    }
    
    @Test
    public void matriisin4x4DeterminanttiLasketaanOikeinRekursiivisellaFunktiolla() {
        double[][] matA = {{2, 3, 1, 4}, {4, 3, 1, 6}, {6, 2, 4, 3}, {6, 5, 1, 7}};

        MatrixDeterminant A = new MatrixDeterminant(matA);

        try {
            assertEquals(A.recursiveDeterminant(), 64, 2);
        } catch (Exception ex) {
        }
    }

    @Test(expected = IllegalArgumentException.class)
    public void matriisinDeterminanttiAntaaVirheenVaaranKokoisellaTaululla() {
        double[][] matA = {{1, 4, 5}, {1, 2, 2}};

        MatrixDeterminant A = new MatrixDeterminant(matA);
        A.determinant();
    }
    
    @Test(expected = IllegalArgumentException.class)
    public void matriisinRekursiivinenDeterminanttiAntaaVirheenVaaranKokoisellaTaululla() {
        double[][] matA = {{1, 4, 5}, {1, 2, 2}};

        MatrixDeterminant A = new MatrixDeterminant(matA);
        A.recursiveDeterminant();
    }
}
