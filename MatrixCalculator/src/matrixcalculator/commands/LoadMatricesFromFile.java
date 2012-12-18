package matrixcalculator.commands;

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
        return true;
    }
    
    @Override
    public String getDescription() {
        return "Lataa matriisit tiedostosta";
    }   
}
