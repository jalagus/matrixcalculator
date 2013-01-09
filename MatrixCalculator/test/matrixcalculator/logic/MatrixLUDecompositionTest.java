package matrixcalculator.logic;

import org.junit.Test;
import static org.junit.Assert.*;

public class MatrixLUDecompositionTest {
    
    public MatrixLUDecompositionTest() {
    }
    
    @Test
    public void LUDecompositionHajottaaMatriisinOikein() {
        double[][] matA = {{2,-1,-2},{-4,6,3},{-4,-2,8}};
        double[][] matB = {{2,-1,-2},{-2,4,-1},{-2,-1,3}};

        Matrix A = new MatrixLUDecomposition(matA).decompose();
        Matrix B = new Matrix(matB);

        assertEquals(B, A);
    }
    
    @Test
    public void LUDecompositionEiYritaJakaaNollalla() {
        double[][] matA = {{0,0,0},{0,0,0},{0,0,0}};

        Matrix A = new MatrixLUDecomposition(matA).decompose();

        assertEquals(null, A);
    }
    
    @Test
    public void LUDecompositionPalauttaaNullJosEiOleNelioMatriisi() {
        double[][] matA = {{2,-1,-2},{-4,6,3},{-4,-2,8},{1,2,3}};

        Matrix A = new MatrixLUDecomposition(matA).decompose();

        assertEquals(null, A);
    }
    
    @Test
    public void YlakolmiomatriisinJaAlakolmiomatriisinYhteenlaskuOnAlkuperainenMatriisi() {
        double[][] matA = {{2,-1,-2},{-4,6,3},{-4,-2,8}};

        Matrix A = new Matrix(matA);
        Matrix U = new MatrixLUDecomposition(matA).LU_UpperTriangle();
        Matrix L = new MatrixLUDecomposition(matA).LU_LowerTriangle();
        
        MatrixMultiplication multiM = new MatrixMultiplication(L.getValues());

        assertEquals(A, multiM.multiply(U));   
    }
}
