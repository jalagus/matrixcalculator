package matrixcalculator;

import java.util.Arrays;

public class Matrix {

    /**
     * Matriisin korkeus
     */
    final public int m;
    /**
     * Matriisin leveys
     */
    final public int n;
    final private double[][] values;

    /**
     * Muodostaa matriisin annetun kaksiulotteisen double-taulukon pohjalta
     *
     * @param matrix
     */
    public Matrix(double[][] matrix) {
        this.m = matrix.length;
        this.n = matrix[0].length;
        this.values = matrix;
    }

    /**
     * Laske kaksi matriisia yhteen
     *
     * @param mat matriisi jonka kanssa yhteenlasku suoritetaan
     * @return Matrix-olion, jossa on yhteenlaskun tulos
     */
    public Matrix add(Matrix mat) {
        if (!checkDimensions(this, mat)) {
            return null;
        }

        double[][] retMatrix = new double[m][n];
        double[][] matrix = mat.getValues();

        for (int i = 0; i < m; i++) {
            for (int a = 0; a < n; a++) {
                retMatrix[i][a] = values[i][a] + matrix[i][a];
            }
        }

        return new Matrix(retMatrix);
    }

    /**
     * Laske kahden matriisin kertolasku
     *
     * @param mat - matriisi jonka kanssa kertolasku suoritetaan
     * @return Matrix-olio, jossa on kertolaskun tulos
     */
    public Matrix multiply(Matrix mat) {
        if (this.n != mat.m) {
            return null;
        }

        double[][] retMatrix = new double[this.m][mat.n];
        double[][] matrix = mat.getValues();

        for (int i = 0; i < retMatrix.length; i++) {
            for (int a = 0; a < retMatrix[0].length; a++) {
                retMatrix[i][a] = matrixPosSum(a, i, values, matrix);
            }
        }

        return new Matrix(retMatrix);
    }

    private double matrixPosSum(int col, int row, double[][] mat1, double[][] mat2) {
        double sum = 0;

        for (int i = 0; i < mat2.length; i++) {
            sum += mat1[row][i] * mat2[i][col];
        }

        return sum;

    }

    /**
     * Kertoo matriisia kertoimella
     *
     * @param coefficent kerroin, jolla matriisia kerrotaan
     * @return Matrix-olio, jossa kertolaskun tulos
     */
    public Matrix multiply(double coefficent) {
        double[][] matrix = new double[m][n];

        for (int i = 0; i < m; i++) {
            for (int a = 0; a < n; a++) {
                matrix[i][a] = values[i][a] * coefficent;
            }
        }

        return new Matrix(matrix);
    }

    /**
     * Laskee matriisin determinantin
     *
     * @return Matriisin determinantti double-tyyppisenä
     * @throws Exception
     */
    public double determinant() {
        if (this.m != this.n) {
            throw new IllegalArgumentException();
        }

        return detHelper(this.values);
    }

    private double detHelper(double mat[][]) {
        if (mat.length == 2 && mat[0].length == 2) {
            return det2x2(mat);
        }

        double sum = 0;

        for (int i = 0; i < mat[0].length; i++) {
            if (i % 2 == 1) {
                mat[0][i] *= -1;
                sum += mat[0][i] * detHelper(stripRow(mat, i));
            } else {
                sum += mat[0][i] * detHelper(stripRow(mat, i));
            }

        }

        return sum;
    }

    private double[][] stripRow(double mat[][], int index) {
        double[][] retMatrix = new double[mat.length - 1][mat[0].length - 1];

        int x = 0;

        for (int i = 0; i < mat[0].length; i++) {
            if (i != index) {
                for (int a = 1; a < mat.length; a++) {
                    retMatrix[a - 1][x] = mat[a][i];
                }
                x++;
            }
        }

        return retMatrix;
    }

    private double det2x2(double[][] matrix) {
        return (matrix[0][0] * matrix[1][1]) - (matrix[1][0] * matrix[0][1]);
    }

    /**
     * Laskee matriisin käänteismatriisin
     *
     * @return Matrix-olio, jossa käänteismatriisi
     */
    public Matrix inverse() {
        try {
            double det = this.determinant();

            if (det == 0) {
                return null;
            }

            double[][] matrix = this.multiply((1 / det)).getValues();

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

    /**
     * Palauttaa matriisin transpoosin
     *
     * @return Matrix-olio, jossa matriisin transpoosi
     */
    public Matrix transpose() {
        double[][] retM = new double[this.n][this.m];

        for (int i = 0; i < this.m; i++) {
            for (int a = 0; a < this.n; a++) {
                retM[a][i] = this.values[i][a];
            }
        }

        return new Matrix(retM);
    }

    /**
     * Laskee matriisin redusoidun porrasmuodon
     *
     * @return Matrix-olio, jossa matriisi on redusoidussa porramuodossa
     */
    public Matrix rref() {

        double[][] row = this.getValues();

        int lead = 0;
        
        for (int i = 0; i < row.length - 1; i++) {
            row = sortRows(row);
            
            for (int a = i; a < row.length; a++) {
                double num = row[a][lead];
                
                for (int k = 0; k < row[a].length; k++) {
                    if (num != 0) {
                        row[a][k] *= (1 / num);
                    }
                }
            }
            
            for (int a = i + 1; a < row.length; a++) {
                if (row[a][lead] != 0) {
                    for (int k = 0; k < row[a].length; k++) {
                        row[a][k] -= row[i][k];
                    }
                }
            }

            
            lead++;
        }

        
        for (int i = row.length - 1; i > 0; i--) {
            int leadingIndex = findLeadingIndex(row, i);
            
            if (leadingIndex > -1) {
                row[i][leadingIndex] = 1;
                for (int a = 0; a < i; a++) {
                    row[a][leadingIndex] = 0;
                }
            }
        }
        
        return new Matrix(fixRrefTable(row));
    }
    
    private int findLeadingIndex(double[][] rows, int a) {
        int index = -1;
        
        for (int i = 0; i < rows[a].length; i++) {
            if (rows[a][i] != 0) {
                if (index != -1) {
                    return -1;
                }
                else {
                    index = i;
                }
            }
            
        }
        
        return index;
    }
    
    private double[][] fixRrefTable(double[][] rows) {
        for (int i = 0; i < rows.length; i++) {
            for (int a = 0; a < rows[i].length; a++) {
                if (rows[i][a] == -0) {
                    rows[i][a] = 0;
                }
            }
            double multiplier = -1;
            for (int a = 0; a < rows[i].length; a++) {
                if (rows[i][a] != 0) {
                    multiplier = rows[i][a];
                    break;
                }
            }
            
            for (int a = 0; a < rows[i].length; a++) {
                rows[i][a] *= (1 / multiplier);
            }
        }
                
        return rows;
    }
    
    private double[][] sortRows(double[][] rows) {
        int[] leadingCol = new int[rows.length];
        
        for (int i = 0; i < rows.length; i++) {
            for (int a = 0; a < rows[0].length; a++) {
                if (rows[i][a] != 0) {
                    leadingCol[i] = a;
                    break;
                }
            }
        }
        
        int x = 0;
        
        double[][] retRows = new double[rows.length][rows[0].length];
        
        for (int i = 0; i < leadingCol.length; i++) {
            for (int a = 0; a < rows.length; a++) {
                if (leadingCol[a] == i) {
                    retRows[x++] = rows[a];
                }
            }
        }
        
        return retRows;
    }
    

    /**
     * Palauttaa matriisin ominaisarvot
     *
     * @return
     */
    public int[] eigenvalues() {
        return new int[2];
    }

    /**
     * Palauttaa matriisin ominaisvektorit
     *
     * @return
     */
    public int[] eigenvectors() {
        return new int[2];
    }

    /**
     * Palauttaa matriisin arvot kaksiulotteisena double-taulukkona
     *
     * @return
     */
    public double[][] getValues() {
        return values;
    }

    private boolean checkDimensions(Matrix m1, Matrix m2) {
        if (m1.m != m2.m || m1.n != m2.n) {
            return false;
        }

        return true;
    }

    /**
     * Palauttaa matriisin tulostusmuodossa
     *
     * @return
     */
    @Override
    public String toString() {
        String ret = "";

        int padding = 6;

        for (int i = 0; i < m; i++) {
            ret += "| ";
            for (int a = 0; a < n; a++) {
                if (values[i][a] < 0) {
                    ret += Utils.padRight(values[i][a] + "", padding);
                } else {
                    ret += Utils.padRight(" " + values[i][a], padding);
                }
            }
            ret += "|\n";
        }

        return ret;
    }

    @Override
    public int hashCode() {
        int hash = 3;
        hash = 67 * hash + Arrays.deepHashCode(this.values);
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final Matrix other = (Matrix) obj;

        if (!Arrays.deepEquals(this.values, other.values)) {
            return false;
        }
        return true;
    }
}
