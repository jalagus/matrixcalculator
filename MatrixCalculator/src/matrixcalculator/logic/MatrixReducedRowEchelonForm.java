package matrixcalculator.logic;

public class MatrixReducedRowEchelonForm extends Matrix {
    
    public MatrixReducedRowEchelonForm(double[][] matrix) {
        super(matrix);
    }
    
    /**
     * Laskee matriisin redusoidun porrasmuodon ja palauttaa tuloksen Matrix-tyypin oliona.
     * Laskennassa käytetään Gauss-Jordanin menetelmää.
     *
     * @return Matrix-olio, jossa matriisi redusoidussa porrasmuodossa
     */    
    public Matrix rref() {
        MatrixGaussianEliminationUtils gaussianUtils = new MatrixGaussianEliminationUtils();
        
        double[][] matrix = this.getValues();

        int rowWithMaxPivotValue = 0;

        for (int k = 0; k < matrix.length; k++) {
            rowWithMaxPivotValue = k;

            // Pivotoidaan suurimman alkion mukaan
            for (int i = k; i < matrix.length; i++) {
                if (matrix[i][k] > matrix[rowWithMaxPivotValue][k]) {
                    rowWithMaxPivotValue = i;
                }
            }

            gaussianUtils.swapRows(matrix, k, rowWithMaxPivotValue);

            // Muutetaan yläkolmiomuotoon
            for (int i = k + 1; i < matrix.length; i++) {
                for (int j = k + 1; j < matrix[k].length; j++) {
                    matrix[i][j] = matrix[i][j] - matrix[k][j] * (matrix[i][k] / matrix[k][k]);
                }
                matrix[i][k] = 0;
            }
        }

        // Nollataan kaikki nollattavissa olevat arvot yläkolmiomatriisista
        for (int k = matrix.length - 1; k >= 0; k--) {
            int pivotIndex = gaussianUtils.findRowPivot(matrix[k]);

            for (int i = 0; i < k; i++) {
                double multiplier = matrix[i][pivotIndex] / matrix[k][pivotIndex];
                gaussianUtils.substractRowWithMultiplier(matrix[k], matrix[i], multiplier);
            }
            double pivot = matrix[k][pivotIndex];

            for (int i = pivotIndex; i < matrix[k].length; i++) {
                matrix[k][i] /= pivot;
            }
        }

        return new Matrix(matrix);
    }
}
