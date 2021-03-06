package matrixcalculator.UI.commands;

import java.util.Map;
import java.util.Scanner;
import matrixcalculator.logic.Matrix;

public class AddMatrix implements Command {

    private Map<String, Matrix> matrices;
    private Scanner scn;

    public AddMatrix(Map<String, Matrix> matrices, Scanner scn) {
        this.matrices = matrices;
        this.scn = scn;
    }

    @Override
    public boolean run() {
        try {
            System.out.print("Tunniste: ");
            String ident = scn.nextLine();

            System.out.print("Korkeus: ");
            int height = Integer.parseInt(scn.nextLine());

            System.out.print("Leveys: ");
            int width = Integer.parseInt(scn.nextLine());

            double[][] matrix = new double[height][width];

            System.out.println();
            System.out.println("Syötä rivit (lukujen erottimena välilyönti)");

            for (int i = 0; i < height; i++) {
                System.out.print("Rivi " + (i + 1) + ": ");
                String row = scn.nextLine();

                String[] splitRow = row.split("[,\\s]+", width);

                for (int a = 0; a < width; a++) {
                    matrix[i][a] = Double.parseDouble(splitRow[a]);
                }

            }

            Matrix newMatrix = new Matrix(matrix);
            matrices.put(ident, newMatrix);

            System.out.println();
            System.out.println("** " + ident + " **");
            System.out.println(newMatrix);
        }
        catch (Exception ex) {
            System.out.println("");
            System.out.println("Virhe: " + ex.getMessage());
            System.out.println("Matriisia ei lisätty");
        }
        
        return true;
    }

    @Override
    public String getDescription() {
        return "Lisää matriisi";
    }
}
