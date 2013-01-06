package matrixcalculator.UI.commands;

import java.util.Map;
import java.util.Scanner;
import matrixcalculator.logic.Matrix;
import matrixcalculator.logic.MatrixAddition;
import matrixcalculator.logic.MatrixMultiplication;

public class MultiplyMatrixWithMatrixCmd extends MatrixReader implements Command {

    public MultiplyMatrixWithMatrixCmd(Map<String, Matrix> matrices, Scanner scn) {
        super(matrices, scn);
    }

    @Override
    public boolean run() {
        try {
            System.out.print("1. matriisi - ");        
            MatrixMultiplication A = new MatrixMultiplication(getMatrixById().getValues());

            System.out.print("2. matriisi - ");  
            Matrix B = getMatrixById();

            Matrix C = A.multiply(B);
                        
            if (C == null) {
                System.out.println("Kertolasku ei määritelty");
            } else {
                System.out.println(C);
            }
        } catch (Exception ex) {
            System.out.println("Virhe: " + ex.getMessage());
        }
        

        return true;
    }

    @Override
    public String getDescription() {
        return "Kerro matriisia matriisilla";
    }
}
