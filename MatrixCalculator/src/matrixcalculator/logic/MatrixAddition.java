/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package matrixcalculator.logic;

/**
 *
 * @author jalagus
 */
public class MatrixAddition extends Matrix {
    
    public MatrixAddition(double[][] matrix) {
        super(matrix);
    }
    
    /**
     * Laske kaksi matriisia yhteen
     *
     * @param mat matriisi jonka kanssa yhteenlasku suoritetaan
     * @return Matrix-olion, jossa on yhteenlaskun tulos
     */
    public Matrix add(Matrix mat) {
        if (this.m != mat.m || this.n != mat.n) {
            return null;
        }

        double[][] retMatrix = new double[m][n];
        double[][] matB = mat.getValues();
        double[][] matA = this.getValues();
        

        for (int i = 0; i < m; i++) {
            for (int a = 0; a < n; a++) {
                retMatrix[i][a] = matA[i][a] + matB[i][a];
            }
        }

        return new Matrix(retMatrix);
    }    
}
