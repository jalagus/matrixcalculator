package matrixcalculator.UI.commands;

import java.util.Map;
import java.util.Scanner;
import matrixcalculator.logic.Matrix;
import matrixcalculator.logic.MatrixMultiplication;

public class MultiplyMatrixWithCoefficentCmd extends MatrixReader implements Command {    
    
    Scanner scn;
    
    public MultiplyMatrixWithCoefficentCmd(Map<String, Matrix> matrices, Scanner scn) {
        super(matrices, scn);
        
        this.scn = scn;
    }

    @Override
    public boolean run() {
        try {
            MatrixMultiplication multiM = new MatrixMultiplication(getMatrixById().getValues());
            
            System.out.print("Kerroin: ");
            double coefficent = Double.parseDouble(scn.nextLine());            
            
            System.out.println(multiM.multiply(coefficent));
        } catch (Exception ex) {
            System.out.println("Virhe: " + ex.getMessage());
        }

        return true;
    }

    @Override
    public String getDescription() {
        return "Kerro matriisia kertoimella";
    }
}