package matrixcalculator.UI.commands;

import java.util.Map;
import java.util.Scanner;
import matrixcalculator.logic.Matrix;
import matrixcalculator.logic.MatrixAddition;

public class MatrixAdditionCmd extends MatrixReader implements Command {
    public MatrixAdditionCmd(Map<String, Matrix> matrices, Scanner scn) {
        super(matrices, scn);
    }

    @Override
    public boolean run() {
        try {
            System.out.print("1. matriisi - ");        
            MatrixAddition A = new MatrixAddition(getMatrixById().getValues());

            System.out.print("2. matriisi - ");  
            Matrix B = getMatrixById();
        
            Matrix C = A.add(B);

            if (C == null) {
                System.out.println("Yhteenlasku ei määritelty");
            } else {
                System.out.println(C);
            }
        }
        catch (Exception ex) {
            System.out.println("Virhe: " + ex.getMessage());
        }

        return true;
    }

    @Override
    public String getDescription() {
        return "Laske kaksi matriisia yhteen";
    }
}
