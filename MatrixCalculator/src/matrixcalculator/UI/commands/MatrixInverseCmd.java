package matrixcalculator.UI.commands;

import java.util.Map;
import java.util.Scanner;
import matrixcalculator.logic.Matrix;
import matrixcalculator.logic.MatrixInverse;

public class MatrixInverseCmd extends MatrixReader implements Command {

    public MatrixInverseCmd(Map<String, Matrix> matrices, Scanner scn) {
        super(matrices, scn);
    }

    @Override
    public boolean run() {
        try {
            Matrix invertedMatrix = new MatrixInverse(getMatrixById().getValues()).inverse();
            System.out.println(invertedMatrix);
        } catch (Exception ex) {
            System.out.println("Virhe: " + ex.getMessage());
        }

        return true;
    }

    @Override
    public String getDescription() {
        return "Laske käänteismatriisi";
    }
}
