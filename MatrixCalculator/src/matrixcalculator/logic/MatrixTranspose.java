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
        double[][] retM = new double[this.n][this.m];
        double[][] values = this.getValues();
        
        for (int i = 0; i < this.m; i++) {
            for (int a = 0; a < this.n; a++) {
                retM[a][i] = values[i][a];
            }
        }

        return new Matrix(retM);
    }    
}
