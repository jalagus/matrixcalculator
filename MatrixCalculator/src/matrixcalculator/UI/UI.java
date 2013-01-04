package matrixcalculator.UI;

import matrixcalculator.UI.commands.MultiplyMatrixWithCoefficentCmd;
import matrixcalculator.UI.commands.AddMatrix;
import matrixcalculator.UI.commands.MultiplyMatrixWithMatrixCmd;
import matrixcalculator.UI.commands.PrintHelp;
import matrixcalculator.UI.commands.EndProgram;
import matrixcalculator.UI.commands.MatrixAdditionCmd;
import matrixcalculator.UI.commands.MatrixDeterminantCmd;
import matrixcalculator.UI.commands.MatrixRREFCmd;
import matrixcalculator.UI.commands.MatrixInverseCmd;
import matrixcalculator.UI.commands.MatrixTransposeCmd;
import matrixcalculator.UI.commands.PrintMatrices;
import matrixcalculator.UI.commands.LoadMatricesFromFile;
import matrixcalculator.UI.commands.Command;
import matrixcalculator.logic.Matrix;
import java.util.HashMap;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Scanner;
import java.util.TreeMap;

public class UI {

    Scanner scn;
    private Map<String, Matrix> matrices = new HashMap<String, Matrix>();
    private Map<String, Command> commands = new TreeMap<String, Command>();
    private Command helpCmd;

    public UI(Scanner scn) {
        this.scn = scn;
        this.registerCommands();
    }

    public void registerCommands() {
        helpCmd = new PrintHelp(commands);

        commands.put("1", new AddMatrix(matrices, scn));
        commands.put("2", new LoadMatricesFromFile(matrices, scn));
        commands.put("3", new PrintMatrices(matrices));
        commands.put("4", new MatrixAdditionCmd(matrices, scn));
        commands.put("5", new MatrixDeterminantCmd(matrices, scn));
        commands.put("6", new MatrixInverseCmd(matrices, scn));
        commands.put("7", new MatrixTransposeCmd(matrices, scn));
        commands.put("8", new MultiplyMatrixWithCoefficentCmd(matrices, scn));
        commands.put("9", new MultiplyMatrixWithMatrixCmd(matrices, scn));
        commands.put("0", new MatrixRREFCmd(matrices, scn));

        commands.put("h", helpCmd);

        commands.put("q", new EndProgram());
    }

    public void start() {
        System.out.println("MATRIISILASKIN\n");

        helpCmd.run();

        boolean running = true;

        while (running) {
            System.out.print("> ");
            String command = scn.nextLine();

            if (commands.containsKey(command)) {
                System.out.println("");
                running = commands.get(command).run();
                System.out.println("");
            } else {
                System.out.println("Tuntematon komento");
            }
        }
    }
}
