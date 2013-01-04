package matrixcalculator.commands;

import java.util.Map;
import java.util.Map.Entry;
import matrixcalculator.logic.Matrix;

public class PrintMatrices implements Command {

    private Map<String, Matrix> matrices;

    public PrintMatrices(Map<String, Matrix> matrices) {
        this.matrices = matrices;
    }

    @Override
    public boolean run() {
        for (Entry<String, Matrix> mat : matrices.entrySet()) {
            System.out.println("** " + mat.getKey() + " **");
            System.out.println(mat.getValue());
        }
        return true;
    }

    @Override
    public String getDescription() {
        return "Tulostaa tallennetut matriisit";
    }
}
