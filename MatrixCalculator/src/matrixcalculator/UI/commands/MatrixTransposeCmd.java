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
public class MatrixTransposeCmd extends MatrixReader implements Command {


    public MatrixTransposeCmd(Map<String, Matrix> matrices, Scanner scn) {
        super(matrices, scn);
    }

    @Override
    public boolean run() {
        try {
            Matrix transposeM = new MatrixTranspose(getMatrixById().getValues()).transpose();
            System.out.println(transposeM);
        } catch (Exception ex) {
            System.out.println("Virhe: " + ex.getMessage());
        }

        return true;
    }

    @Override
    public String getDescription() {
        return "Laske matriisin transpoosi";
    }
}
