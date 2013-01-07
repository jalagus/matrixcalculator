package matrixcalculator.logic;

public class MatrixAddition extends Matrix {
    
    /**
     * Luo uuden MatrixAddition-olion, jolla voidaan suorittaa matriisien 
     * yhteenlaskuja. Perii luokan Matrix.
     *
     * @param matrix matriisin arvot kaksiulotteisena double-taulukkona
     */
    public MatrixAddition(double[][] matrix) {
        super(matrix);
    }
    
    /**
     * Laskee kaksi matriisia yhteen ja palauttaa tuloksen Matrix-tyypin oliona.
     *
     * @param matrix matriisi jonka kanssa yhteenlasku suoritetaan
     * @return Matrix-olion, jossa on yhteenlaskun tulos
     */
    public Matrix add(Matrix matrix) {
        if (this.rows != matrix.rows || this.columns != matrix.columns) {
            return null;
        }

        double[][] resultMatrix = new double[rows][columns];
        double[][] matrixB = matrix.getValues();
        double[][] matrixA = this.getValues();
        

        for (int i = 0; i < rows; i++) {
            for (int a = 0; a < columns; a++) {
                resultMatrix[i][a] = matrixA[i][a] + matrixB[i][a];
            }
        }

        return new Matrix(resultMatrix);
    }    
}
