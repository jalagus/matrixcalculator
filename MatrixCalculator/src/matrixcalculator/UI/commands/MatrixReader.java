package matrixcalculator.UI.commands;

import java.util.Map;
import java.util.Scanner;
import matrixcalculator.logic.Matrix;

abstract class MatrixReader {
    
    private Map<String, Matrix> matrices;
    private Scanner scn;
    
    public MatrixReader(Map<String, Matrix> matrices, Scanner scn) {
        this.matrices = matrices;
        this.scn = scn;
    }
    
    public Matrix getMatrixById() throws Exception {
        System.out.print("Tunniste: ");
        String ident = scn.nextLine();

        if (matrices.containsKey(ident)) {
            return matrices.get(ident);
        }        
        else {
            throw new IllegalArgumentException("Syötettyä tunnistetta ei löydy");
        }
    }
    
}
