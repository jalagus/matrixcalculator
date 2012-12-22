/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package matrixcalculator.commands;

import java.util.Map;
import java.util.Scanner;
import matrixcalculator.Matrix;

/**
 *
 * @author jalagus
 */
public class MatrixRREF implements Command {

    private Map<String, Matrix> matrices;
    private Scanner scn;

    public MatrixRREF(Map<String, Matrix> matrices, Scanner scn) {
        this.matrices = matrices;
        this.scn = scn;
    }

    @Override
    public boolean run() {
        System.out.print("Tunniste: ");
        String ident = scn.nextLine();

        if (matrices.containsKey(ident)) {
            System.out.println(matrices.get(ident).rref());
        }
        return true;
    }

    @Override
    public String getDescription() {
        return "Muunna redusoituun porrasmuotoon";
    }
}