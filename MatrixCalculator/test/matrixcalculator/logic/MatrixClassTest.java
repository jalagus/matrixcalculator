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
public class MatrixClassTest {

    public MatrixClassTest() {
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

    @Test
    public void matriisinKaanteismatriisiPalauttaaOikein() {
        double[][] matA = {{2, 2}, {1, 2}};
        double[][] matB = {{1, -1}, {-0.5, 1}};

        MatrixInverse A = new MatrixInverse(matA);
        Matrix B = new Matrix(matB);

        assertEquals(B, A.inverse());
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

    @Test
    public void redusoituPorrasmuotoRakentuuOikein() {
        double[][] matA = {{1, 2, 0}, {0, 2, 1}, {1, 2, 1}};
        double[][] matB = {{1, 0, 0}, {0, 1, 0}, {0, 0, 1}};

        Matrix A = new MatrixReducedRowEchelonForm(matA).rref();
        Matrix B = new Matrix(matB);

        assertEquals(B, A);
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
    public void LUDecompositionHajottaaMatriisinOikein() {
        double[][] matA = {{2,-1,-2},{-4,6,3},{-4,-2,8}};
        double[][] matB = {{2,-1,-2},{-2,4,-1},{-2,-1,3}};

        Matrix A = new MatrixLUDecomposition(matA).decompose();
        Matrix B = new Matrix(matB);

        assertEquals(B, A);
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
