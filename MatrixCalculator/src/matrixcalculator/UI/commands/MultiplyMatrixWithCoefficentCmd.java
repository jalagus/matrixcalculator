/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package matrixcalculator.UI.commands;

import java.util.Map;
import java.util.Scanner;
import matrixcalculator.logic.Matrix;
import matrixcalculator.logic.MatrixMultiplication;

/**
 *
 * @author jalagus
 */
public class MultiplyMatrixWithCoefficentCmd implements Command {

    private Map<String, Matrix> matrices;
    private Scanner scn;

    public MultiplyMatrixWithCoefficentCmd(Map<String, Matrix> matrices, Scanner scn) {
        this.matrices = matrices;
        this.scn = scn;
    }

    @Override
    public boolean run() {
        System.out.print("Tunniste: ");
        String ident = scn.nextLine();

        System.out.print("Kerroin: ");
        double coefficent = Double.parseDouble(scn.nextLine());

        if (matrices.containsKey(ident)) {
            Matrix multiM = new MatrixMultiplication(matrices.get(ident).getValues()).multiply(coefficent);
            
            System.out.println(multiM);
        }

        return true;
    }

    @Override
    public String getDescription() {
        return "Kerro matriisia kertoimella";
    }
}