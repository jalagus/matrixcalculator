package matrixcalculator.logic;

public class MatrixInverse extends Matrix {

    public MatrixInverse(double[][] matrix) {
        super(matrix);
    }

    /**
     * Laskee matriisin käänteismatriisin ja palauttaa tuloksen Matrix-tyypin
     * oliona. Laskentaan käytetään Gauss-Jordanin menetelmää.
     *
     * @return Matrix-olio, jossa käänteismatriisi laskettuna
     */
    public Matrix inverse() {
        if (this.rows != this.columns) {
            return null;
        }
        else if (new MatrixDeterminant(this.getValues()).determinant() == 0) {
            return null;
        }
        
        MatrixGaussianEliminationUtils gaussianUtils = new MatrixGaussianEliminationUtils();

        double[][] matrix = addIdentityMatrix(this.getValues());

        int maxRow = 0;

        for (int k = 0; k < matrix.length; k++) {
            maxRow = k;

            // Pivotoidaan suurimman alkion mukaan
            for (int i = k; i < matrix.length; i++) {
                if (matrix[i][k] > matrix[maxRow][k]) {
                    maxRow = i;
                }
            }
            gaussianUtils.swapRows(matrix, k, maxRow);

            // Muutetaan yläkolmiomuotoon
            for (int i = k + 1; i < matrix.length; i++) {
                double multiplier = matrix[i][k] / matrix[k][k];
                gaussianUtils.substractRowWithMultiplier(matrix[k], matrix[i], multiplier);
                
                matrix[i][k] = 0;
            }
        }

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

        return new Matrix(splitInverseMatrix(matrix));
    }

    private double[][] splitInverseMatrix(double[][] matrix) {
        double[][] inverseMatrix = new double[matrix.length][matrix.length];

        for (int i = 0; i < matrix.length; i++) {
            for (int j = matrix[i].length / 2; j < matrix[i].length; j++) {
                inverseMatrix[i][j - matrix.length] = matrix[i][j];
            }
        }
        
        return inverseMatrix;
    }
    
    private double[][] addIdentityMatrix(double[][] matrix) {
        double[][] combinedMatrix = new double[matrix.length][matrix.length * 2];
        
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix.length; j++) {
                combinedMatrix[i][j] = matrix[i][j];
            }
        }
        for (int i = matrix.length; i < combinedMatrix[0].length; i++) {
            combinedMatrix[i - matrix.length][i] = 1;
        }
        
        return combinedMatrix;
    }
}
