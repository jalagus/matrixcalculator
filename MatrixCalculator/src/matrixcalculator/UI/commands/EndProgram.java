package matrixcalculator.UI.commands;

import java.util.Map;
import matrixcalculator.logic.Matrix;

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
