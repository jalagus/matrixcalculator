package matrixcalculator.commands;

import java.util.Map;
import matrixcalculator.Matrix;

public class EndProgram implements Command {

    public EndProgram() {
    }

    @Override
    public boolean run() {
        return false;
    }

    @Override
    public String getDescription() {
        return "Lopettaa ohjelman";
    }
}
