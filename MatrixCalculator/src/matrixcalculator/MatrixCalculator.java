package matrixcalculator;

public class MatrixCalculator {

    public static void main(String[] args) {
        UI ui = new UI();
        
        double[][] matA = {{1,4,4}};
        double[][] matB = {{1},{2},{3}};
        
        double[][] matC = {{1,2,3},{1,2,3},{1,2,3}};
        double[][] matD = {{2,2},{1,2}};
        
        
        Matrix A = new Matrix(matA);
        Matrix B = new Matrix(matB);
        Matrix C = new Matrix(matC);
        Matrix D = new Matrix(matD);
        
        System.out.println(D);
        System.out.println(D.inverse());
        
        //System.out.println(A);
        //System.out.println(A.transpose());
        
        /*System.out.println(A);
        System.out.println(B);
        
        System.out.println(A.multiply(B));
        System.out.println(C.multiply(C));
        //System.out.println(B.multiply(A));
        //ui.start(); */
    }
}
