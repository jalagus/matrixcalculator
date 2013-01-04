/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package matrixcalculator.logic;

/**
 *
 * @author jalagus
 */
public class MatrixInverse extends Matrix {

    public MatrixInverse(double[][] matrix) {
        super(matrix);
    }    
    
    /**
     * Laskee matriisin käänteismatriisin ja palauttaa tuloksen Matrix-tyypin oliona.
     *
     * @return Matrix-olio, jossa käänteismatriisi laskettuna
     */
    public Matrix inverse() {        
        try {
            double det = new MatrixDeterminant( this.getValues() ).determinant();

            if (det == 0) {
                return null;
            }

            double[][] matrix = new MatrixMultiplication(this.getValues()).multiply(1 / det).getValues();

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
}
