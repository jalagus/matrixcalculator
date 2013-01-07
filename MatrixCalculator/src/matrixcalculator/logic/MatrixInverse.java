package matrixcalculator.logic;

public class MatrixInverse extends Matrix {
    
    /**
     * Luo uuden MatrixInverse-olion, jolla voidaan laskea matriisin 
     * käänteismatriisi. Perii luokan Matrix.
     *
     * @param matrix matriisin arvot kaksiulotteisena double-taulukkona
     */
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
        
        // Ei yritetä laskea käänteismariisia, mikäli matriisi ei ole
        // neliömatriisi tai matriisin determinantti on 0
        if (this.rows != this.columns) {
            return null;
        }
        else if (new MatrixDeterminant(this.getValues()).determinant() == 0) {
            return null;
        }
        
        double[][] matrix = addIdentityMatrix(this.getValues());

        Matrix rrefMatrix = new MatrixReducedRowEchelonForm(matrix).rref();

        matrix = rrefMatrix.getValues();
        
        return new Matrix(splitInverseMatrix(matrix));
    }

    // Apumetodi, joka erottaa käänteismatriisin matriisista
    private double[][] splitInverseMatrix(double[][] matrix) {
        double[][] inverseMatrix = new double[matrix.length][matrix.length];

        for (int i = 0; i < matrix.length; i++) {
            for (int j = matrix[i].length / 2; j < matrix[i].length; j++) {
                inverseMatrix[i][j - matrix.length] = matrix[i][j];
            }
        }
        
        return inverseMatrix;
    }
    
    // Apumetodi, joka lisää matriisiin identiteettimatriisin
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
