package matrixcalculator.logic;

import org.junit.Test;
import static org.junit.Assert.*;

public class MatrixGaussianEliminationUtilsTest {
    
    public MatrixGaussianEliminationUtilsTest() {
    }

    @Test
    public void findPivotPalauttaaNegatiivisenJosPivotiaEiOle() {
        double[] row = {0,0,0};
        
        int pivot = new MatrixGaussianEliminationUtils().findRowPivot(row);
        
        assertTrue(pivot == -1);
        
    }
    
    @Test(expected = IllegalArgumentException.class)
    public void eriPituisiaRivejaEiVahennetaToisistaanGaussinEliminoinnissa() {
        double[] row1 = {2};
        double[] row2 = {3,7,5};
        
        new MatrixGaussianEliminationUtils().substractRowWithMultiplier(row1, row2, 10);
    }
}
