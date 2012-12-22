package matrixcalculator.commands;

import java.io.BufferedReader;
import java.io.DataInputStream;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.Map;
import java.util.Scanner;
import matrixcalculator.Matrix;

public class LoadMatricesFromFile implements Command {

    private Map<String, Matrix> matrices;
    private Scanner scn;

    public LoadMatricesFromFile(Map<String, Matrix> matrices, Scanner scn) {
        this.matrices = matrices;
        this.scn = scn;
    }

    @Override
    public boolean run() {
        System.out.print("Tiedostonimi: ");
        String filename = scn.nextLine();

        int matrixCount = 0;
        int failCount = 0;

        
        int errorLine = 0;
        
        try {
            FileInputStream fstream = new FileInputStream(filename);

            DataInputStream in = new DataInputStream(fstream);
            BufferedReader br = new BufferedReader(new InputStreamReader(in));
            String strLine;

            while ((strLine = br.readLine()) != null) {
                errorLine++;
                if (parseMatrix(strLine)) {
                    matrixCount++;
                } else {
                    failCount++;
                }
            }

            in.close();
        } catch (Exception e) {
            System.err.println("Virhe rivillä " + errorLine + ": " + e.getMessage());
        }

        System.out.println("Ladattiin " + matrixCount + " matriisia");
        if (failCount > 0) {
            System.out.println("Hylättiin " + failCount + " matriisia");
        }


        return true;
    }

    private boolean parseMatrix(String row) {

        String[] temp = row.split("=", 2);

        String ident = temp[0].trim();

        String temp2 = temp[1].trim();
        temp2 = temp2.substring(1, temp2.length() - 1);

        int rowCount = temp2.split("\\{").length - 1;

        String[] rows = new String[rowCount];

        int a = 0;

        for (int i = 0; i < temp2.length(); i++) {
            if (temp2.charAt(i) == '{') {
                i++;
                rows[a] = "";
                while (temp2.charAt(i) != '}') {
                    rows[a] += temp2.charAt(i++);
                }
                rows[a].trim();
                a++;
            }
        }


        double[][] matrix = new double[rowCount][0];

        int firstRowCount = rows[0].split(",").length;

        for (int i = 0; i < rowCount; i++) {
            String[] temp3 = rows[i].split(",");

            if (temp3.length != firstRowCount) {
                return false;
            }

            matrix[i] = new double[temp3.length];

            for (int b = 0; b < temp3.length; b++) {
                matrix[i][b] = Double.parseDouble(temp3[b]);
            }
        }

        matrices.put(ident, new Matrix(matrix));

        return true;
    }

    @Override
    public String getDescription() {
        return "Lataa matriisit tiedostosta";
    }
}
