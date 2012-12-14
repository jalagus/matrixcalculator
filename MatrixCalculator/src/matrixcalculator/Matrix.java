package matrixcalculator;

public class Matrix {
    final private int m;
    final private int n;
    final private double[][] values;
    
    public Matrix(double[][] matrix) {
        this.m = matrix.length;
        this.n = matrix[0].length;
        this.values = matrix;
    }
    
    public Matrix add(Matrix mat) {
        return null;
    }
    
    public Matrix multiply(Matrix mat) {
        return null;
    }
    
    public Matrix multiply(int coefficent) {        
        return null;
    }
    
    public int determinant() {
        return 0;
    }
    
    public Matrix inverse() {
        return null;
    }    
    
    // Reduced row echelon form
    public Matrix rref() {
        return null;
    }
    
    @Override
    public String toString() {
        String ret = "";
        
        for (int i = 0; i < values.length; i++) {
            for (int a = 0; a < values[0].length; a++) {
                ret += values[i][a] + " ";
            }
            ret += "\n";
        }
        
        return ret;
    }
}
