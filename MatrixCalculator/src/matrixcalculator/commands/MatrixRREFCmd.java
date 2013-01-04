/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package matrixcalculator.commands;

import java.util.Map;
import java.util.Scanner;
import matrixcalculator.logic.Matrix;
import matrixcalculator.logic.MatrixReducedRowEchelonForm;

/**
 *
 * @author jalagus
 */
public class MatrixRREFCmd implements Command {

    private Map<String, Matrix> matrices;
    private Scanner scn;

    public MatrixRREFCmd(Map<String, Matrix> matrices, Scanner scn) {
        this.matrices = matrices;
        this.scn = scn;
    }

    @Override
    public boolean run() {
        System.out.print("Tunniste: ");
        String ident = scn.nextLine();

        if (matrices.containsKey(ident)) {
            Matrix rrefM = new MatrixReducedRowEchelonForm(matrices.get(ident).getValues()).rref();

            System.out.println(rrefM);
        }
        return true;
    }

    @Override
    public String getDescription() {
        return "Muunna redusoituun porrasmuotoon";
    }
}
