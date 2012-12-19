package matrixcalculator;

public class MatrixCalculator {

    public static void main(String[] args) {
        
        double[][] matA = {{1,2},{3,5}};
        
        Matrix A = new Matrix(matA);
        
        System.out.println(A.rref());
        
        /*
        UI ui = new UI();
        
        ui.start();
        */
    }
}
