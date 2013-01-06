package matrixcalculator.logic;

public class MatrixAddition extends Matrix {
    
    public MatrixAddition(double[][] matrix) {
        super(matrix);
    }
    
    /**
     * Laskee kaksi matriisia yhteen ja palauttaa tuloksen Matrix-tyypin oliona.
     *
     * @param mat matriisi jonka kanssa yhteenlasku suoritetaan
     * @return Matrix-olion, jossa on yhteenlaskun tulos
     */
    public Matrix add(Matrix mat) {
        if (this.rows != mat.rows || this.columns != mat.columns) {
            return null;
        }

        double[][] retMatrix = new double[rows][columns];
        double[][] matB = mat.getValues();
        double[][] matA = this.getValues();
        

        for (int i = 0; i < rows; i++) {
            for (int a = 0; a < columns; a++) {
                retMatrix[i][a] = matA[i][a] + matB[i][a];
            }
        }

        return new Matrix(retMatrix);
    }    
}
