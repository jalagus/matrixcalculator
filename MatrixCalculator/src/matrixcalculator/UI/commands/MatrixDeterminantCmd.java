package matrixcalculator.UI.commands;

import java.util.Map;
import java.util.Scanner;
import matrixcalculator.logic.Matrix;
import matrixcalculator.logic.MatrixDeterminant;


public class MatrixDeterminantCmd extends MatrixReader implements Command {

    public MatrixDeterminantCmd(Map<String, Matrix> matrices, Scanner scn) {
        super(matrices, scn);
    }

    @Override
    public boolean run() {
        try {
            double determinant = new MatrixDeterminant(getMatrixById().getValues()).determinant();
            System.out.println("Determinantti: " + String.format("%.5f", determinant));
        } catch (Exception ex) {
            System.out.println("Virhe: " + ex.getMessage());
        }

        return true;
    }

    @Override
    public String getDescription() {
        return "Laske determinantti";
    }
}
