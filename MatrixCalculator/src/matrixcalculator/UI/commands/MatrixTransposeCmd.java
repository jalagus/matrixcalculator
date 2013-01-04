/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package matrixcalculator.UI.commands;

import java.util.Map;
import java.util.Scanner;
import matrixcalculator.logic.Matrix;
import matrixcalculator.logic.MatrixTranspose;

/**
 *
 * @author jalagus
 */
public class MatrixTransposeCmd implements Command {

    private Map<String, Matrix> matrices;
    private Scanner scn;

    public MatrixTransposeCmd(Map<String, Matrix> matrices, Scanner scn) {
        this.matrices = matrices;
        this.scn = scn;
    }

    @Override
    public boolean run() {
        System.out.print("Tunniste: ");
        String ident = scn.nextLine();

        if (matrices.containsKey(ident)) {
            Matrix transposeM = new MatrixTranspose(matrices.get(ident).getValues()).transpose();

            System.out.println(transposeM);
        }

        return true;
    }

    @Override
    public String getDescription() {
        return "Laske matriisin transpoosi";
    }
}
