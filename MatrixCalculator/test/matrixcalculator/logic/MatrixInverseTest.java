package matrixcalculator.logic;

import org.junit.Test;
import static org.junit.Assert.*;

public class MatrixInverseTest {
    
    public MatrixInverseTest() {
    }

    @Test
    public void matriisinKaanteismatriisiPalauttaaOikein() {
        double[][] matA = {{2, 2}, {1, 2}};
        double[][] matB = {{1, -1}, {-0.5, 1}};

        MatrixInverse A = new MatrixInverse(matA);
        Matrix B = new Matrix(matB);

        assertEquals(B, A.inverse());
    }
    @Test
    public void kaanteismatriisiaEiLasketaJosMatriisiEiOleNeliomatriisi() {
        double[][] matA = {{2, 2}, {1, 2}, {4, 9}};

        Matrix A = new MatrixInverse(matA).inverse();

        assertEquals(null, A);
    }
    
    @Test
    public void suurempiMatriisinKaanteismatriisiPalauttaaOikein() {
        double[][] matA = {{1, 4, 5}, {3, 2, 3}, {7, 3, 3}};
        double[][] matB = {{-0.15, 0.15, 0.1}, {0.6, -1.6, 0.6}, {-0.25, 1.25, -0.5}};

        Matrix A = new MatrixInverse(matA).inverse();
        Matrix B = new Matrix(matB);

        assertEquals(B.toString(), A.toString());
    }

    @Test
    public void matriisinKaanteismatriisiPalauttaaTyhjanJosDeterminanttiOnNolla() {
        double[][] matA = {{2, 2}, {2, 2}};

        MatrixInverse A = new MatrixInverse(matA);

        assertEquals(null, A.inverse());
    }
}
