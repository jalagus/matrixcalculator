package matrixcalculator;

public class Matrix {
    final public int m;
    final public int n;
    final private double[][] values;
    
    public Matrix(double[][] matrix) {
        this.m = matrix.length;
        this.n = matrix[0].length;
        this.values = matrix;
    }
    
    // Add two matrices
    public Matrix add(Matrix mat) {
        if (this.m != mat.m || this.n != mat.n) {
            return null;
        }
        
        if (this.m != mat.m || this.n != mat.n) {
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
    
    // Multiply with other matrix
    public Matrix multiply(Matrix mat) {
        double[][] retMatrix = new double[m][n];
        double[][] matrix = mat.getValues();
        
        for (int i = 0; i < m; i++) {
            for (int a = 0; a < n; a++) {
                retMatrix[i][a] = matrixPosSum(a, i, matrix, values);
            }
        }         
        
        return new Matrix(retMatrix);
    }
    
    private double matrixPosSum(int col, int row, double[][] mat1, double[][] mat2) {
        double sum = 0;
        
        for (int i = 0; i < mat1.length; i++) {
            sum += mat1[i][col] * mat2[row][i];
        }
        
        return sum;

    }
    
    // Multiply with coefficent
    public Matrix multiply(double coefficent) {
        double[][] matrix = new double[m][n];
        
        for (int i = 0; i < m; i++) {
            for (int a = 0; a < n; a++) {
                matrix[i][a] = values[i][a] * coefficent;
            }
        }        
        
        return new Matrix(matrix);
    }
    
    // Calculate determinant
    public int determinant() {
        if (this.m != this.n) {
            return 0;
        }
        return 4;
    }
    
    // Return inverse matrix
    public Matrix inverse() {
        
        int det = this.determinant();
        
        double[][] matrix = this.multiply((1 / (double) det)).getValues();
        
        return new Matrix(matrix);
    }    
    
    // Reduced row echelon form
    public Matrix rref() {
        return null;
    }
    
    public int[] eigenvalues() {
        return new int[2];
    }

    public int[] eigenvectors() {
        return new int[2];
    }    
    
    public double[][] getValues() {
        return values;
    }
    
    @Override
    public String toString() {
        String ret = "";
        
        int padding = 6;
        
        for (int i = 0; i < m; i++) {
            ret += "| ";
            for (int a = 0; a < n; a++) {
                if (values[i][a] < 0) {
                    ret += Utils.padRight(values[i][a] + "", padding);
                }
                else {
                    ret += Utils.padRight(" " + values[i][a], padding);
                }
            }
            ret += "|\n";
        }
        
        return ret;
    }
}
