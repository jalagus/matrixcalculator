package matrixcalculator.UI.commands;

import java.util.Map;
import java.util.Scanner;
import matrixcalculator.logic.Matrix;
import matrixcalculator.logic.MatrixReducedRowEchelonForm;

public class MatrixRREFCmd extends MatrixReader implements Command {
    public MatrixRREFCmd(Map<String, Matrix> matrices, Scanner scn) {
        super(matrices, scn);
    }

    @Override
    public boolean run() {
        try {    
            Matrix rrefM = new MatrixReducedRowEchelonForm(getMatrixById().getValues()).rref();
            System.out.println(rrefM);
        } catch (Exception ex) {
            System.out.println("Virhe: " + ex.getMessage());
        }
        
        return true;
    }

    @Override
    public String getDescription() {
        return "Muunna redusoituun porrasmuotoon";
    }
}
