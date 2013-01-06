package matrixcalculator.logic;

public class MatrixTranspose extends Matrix {

    public MatrixTranspose(double[][] matrix) {
        super(matrix);
    }    
    
    /**
     * Laskee matriisin transpoosin ja palauttaa tuloksen Matrix-tyypin oliona.
     *
     * @return Matrix-olio, jossa matriisin transpoosi
     */
    public Matrix transpose() {
        double[][] retM = new double[this.columns][this.rows];
        double[][] values = this.getValues();
        
        for (int i = 0; i < this.rows; i++) {
            for (int a = 0; a < this.columns; a++) {
                retM[a][i] = values[i][a];
            }
        }

        return new Matrix(retM);
    }    
}
