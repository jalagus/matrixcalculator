package matrixcalculator;

import java.util.Scanner;

public class MatrixCalculator {

    public static void main(String[] args) {

        double[][] matA = {{11, 9, 24, 2}, {1, 5, 2, 6}, {3, 17, 18, 1}, {2, 5, 7, 1}};

        //double[][] matA = {{2, -1, -2}, {-4, 6, 3}, {-4, -2, 8}};

        
        Matrix A = new Matrix(matA);
                
        double det = 1;
        double[][] mat = A.decompose().getValues();
        for (int i = 0; i < A.m; i++) {
            det *= mat[i][i];
        }
        
        System.out.println(det);
        System.out.println(A.determinant());
        
        //System.out.println(A.rref());
        /*
        System.out.println("Det: " + A.determinant());
        
        Matrix[] LUP = A.LUDecomposition(A);
        
        System.out.println(LUP[0]);
        System.out.println(LUP[1]);
        
        System.out.println(LUP[0].multiply(LUP[1]));

        /*UI ui = new UI(new Scanner(System.in));

         ui.start();*/

    }
}
