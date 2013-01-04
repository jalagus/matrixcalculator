/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package matrixcalculator.UI.commands;

import java.util.Map;
import java.util.Scanner;
import matrixcalculator.logic.Matrix;
import matrixcalculator.logic.MatrixInverse;

/**
 *
 * @author jalagus
 */
public class MatrixInverseCmd implements Command {

    private Map<String, Matrix> matrices;
    private Scanner scn;

    public MatrixInverseCmd(Map<String, Matrix> matrices, Scanner scn) {
        this.matrices = matrices;
        this.scn = scn;
    }

    @Override
    public boolean run() {
        System.out.print("Tunniste: ");
        String ident = scn.nextLine();

        if (matrices.containsKey(ident)) {
            Matrix invM = new MatrixInverse(matrices.get(ident).getValues()).inverse();

            System.out.println(invM);
        }

        return true;
    }

    @Override
    public String getDescription() {
        return "Laske käänteismatriisi";
    }
}
