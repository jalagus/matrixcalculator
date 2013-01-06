package matrixcalculator.logic;

public class MatrixMultiplication extends Matrix {
    
    public MatrixMultiplication(double[][] matrix) {
        super(matrix);
    }
    
    /**
     * Laskee kahden matriisin kertolaskun ja palauttaa tuloksen Matrix-tyypin oliona. 
     * Matriiseille on oltava kertolasku määritely, eli parametrina annetun matriisin
     * rivimäärä on sama kuin sarakemäärä kerrottavassa matriisissa.
     *
     * @param mat   Matrix-olio, jonka kanssa kertolasku suoritetaan. Rivimäärä oltava 
     *              sama kuin kertomisen kohteen sarakemäärä
     * 
     * @return      Matrix-olio, jossa on kertolaskun tulos
     */
    public Matrix multiply(Matrix mat) {
        if (this.columns != mat.rows) {
            return null;
        }

        double[][] resultMatrix = new double[this.rows][mat.columns];
        double[][] matrixA = mat.getValues();
        double[][] matrixB = this.getValues();

        for (int i = 0; i < resultMatrix.length; i++) {
            for (int a = 0; a < resultMatrix[0].length; a++) {
                resultMatrix[i][a] = rowColumnMultiplicationSum(a, i, matrixB, matrixA);
            }
        }

        return new Matrix(resultMatrix);
    }

    // Matriisikertolaskun apumetodi, joka laskee yhden rivin ja yhden 
    // sarakkeen kertolaskut ja palauttaa sen
    private double rowColumnMultiplicationSum(int col, int row, double[][] mat1, double[][] mat2) {
        double sum = 0;

        for (int i = 0; i < mat2.length; i++) {
            sum += mat1[row][i] * mat2[i][col];
        }

        return sum;

    }

    /**
     * Kertoo matriisia kertoimella ja palauttaa tuloksen Matrix-tyypin oliona.
     *
     * @param coefficent    kerroin, jolla matriisia kerrotaan
     * 
     * @return              Matrix-olio, jossa kertolaskun tulos
     */
    public Matrix multiply(double coefficent) {
        double[][] matrix = new double[rows][columns];
        double[][] values = this.getValues();
        
        for (int i = 0; i < rows; i++) {
            for (int a = 0; a < columns; a++) {
                matrix[i][a] = values[i][a] * coefficent;
            }
        }

        return new Matrix(matrix);
    }    
}
