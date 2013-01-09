/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package matrixcalculator.logic;

import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author jalagus
 */
public class MatrixReducedRowEchelonFormTest {
    
    public MatrixReducedRowEchelonFormTest() {
    }

    @Test
    public void redusoituPorrasmuotoRakentuuOikein() {
        double[][] matA = {{1, 2, 0}, {0, 2, 1}, {1, 2, 1}};
        double[][] matB = {{1, 0, 0}, {0, 1, 0}, {0, 0, 1}};

        Matrix A = new MatrixReducedRowEchelonForm(matA).rref();
        Matrix B = new Matrix(matB);

        assertEquals(B, A);
    }
}
