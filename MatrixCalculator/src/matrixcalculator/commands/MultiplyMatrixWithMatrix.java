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
public class MultiplyMatrixWithMatrix implements Command {

    private Map<String, Matrix> matrices;
    private Scanner scn;

    public MultiplyMatrixWithMatrix(Map<String, Matrix> matrices, Scanner scn) {
        this.matrices = matrices;
        this.scn = scn;
    }

    @Override
    public boolean run() {
        System.out.print("Ensimmäisen matriisin tunniste: ");
        String identA = scn.nextLine();
        if (!matrices.containsKey(identA)) {
            System.out.println("Tuntematon matriisi");
        }

        System.out.print("Toisen matriisin tunniste: ");
        String identB = scn.nextLine();
        if (!matrices.containsKey(identB)) {
            System.out.println("Tuntematon matriisi");
        }

        Matrix A = matrices.get(identA);
        Matrix B = matrices.get(identB);

        Matrix C = A.multiply(B);

        if (C == null) {
            System.out.println("Kertolasku ei määritelty");
        } else {
            System.out.println(C);
        }

        return true;
    }

    @Override
    public String getDescription() {
        return "Kerro matriisia matriisilla";
    }
}
