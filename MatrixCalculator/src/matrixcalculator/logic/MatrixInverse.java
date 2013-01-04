package matrixcalculator.logic;

public class MatrixInverse extends Matrix {

    public MatrixInverse(double[][] matrix) {
        super(matrix);
    }    
    
    /**
     * Laskee matriisin käänteismatriisin ja palauttaa tuloksen Matrix-tyypin oliona.
     * Algoritmina käytetään cofactor-matriisin laskemista ja sen transpoosin avulla
     * laskettavaa käänteismatriisia.
     *
     * @return Matrix-olio, jossa käänteismatriisi laskettuna
     */
    public Matrix inverse() {        
        try {

            double[][] matrix = this.getValues();
            
            double det = new MatrixDeterminant( this.getValues() ).determinant();

            if (det == 0) {
                return null;
            }
            
            Matrix result = new MatrixTranspose(cofactorMatrix(matrix)).transpose();
            
            matrix = new MatrixMultiplication(result.getValues()).multiply(1 / det).getValues();
            
            // Etumerkkien muutos + - + -taulukon mukaisesti
            for (int i = 0; i < matrix.length; i++) {
                for (int a = 0; a < matrix[0].length; a++) {
                    if (a % 2 == 0) {
                        if (i % 2 == 1) {
                            matrix[i][a] *= -1;
                        }
                    } else {
                        if (i % 2 == 0) {
                            matrix[i][a] *= -1;
                        }
                    }
                }
            }
            
            return new Matrix(matrix);
        } catch (Exception ex) {
            return null;
        }
    } 
    
    private double[][] cofactorMatrix(double[][] matrix) {
        double[][] resultMatrix = new double[matrix.length][matrix[0].length];

        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[0].length; j++) {
                resultMatrix[i][j] = 
                        new MatrixDeterminant(removeRowAndColumn(matrix, i, j)).determinant();
            }
        }
        
        return resultMatrix;
    }
    
    private double[][] removeRowAndColumn(double[][] matrix, int row, int column) {
        double[][] resultMatrix = new double[matrix.length - 1][matrix[0].length - 1];
        
        int i = 0;
        int j = 0;
        
        for (int x = 0; x < matrix.length; x++) {
            if (x == row) {
                continue;
            }
            
            j = 0;
            for (int y = 0; y < matrix.length; y++) {
                if (y == column) {
                    continue;
                }
                resultMatrix[i][j] = matrix[x][y];
                j++;
            }
            
            i++;
        }
        
        return resultMatrix;
    }
}
