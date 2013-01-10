package matrixcalculator.UI;

import matrixcalculator.UI.commands.*;
import matrixcalculator.logic.Matrix;
import java.util.HashMap;
import java.util.Map;
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
        
        double[][] testMatrix = {{1,4,2},{4,1,1},{5,3,7}};
        double[][] testMatrix2 = {{1,4,2,4},{4,1,1,100},{5,3,7,3},{4,1,10,32}};
        
        matrices.put("A", new Matrix(testMatrix));
        matrices.put("B", new Matrix(testMatrix2));
        
    }

    public void registerCommands() {
        helpCmd = new PrintHelp(commands);

        commands.put("1", new AddMatrix(matrices, scn));
        commands.put("2", new MatrixAdditionCmd(matrices, scn));
        commands.put("3", new MatrixDeterminantCmd(matrices, scn));
        commands.put("4", new MatrixInverseCmd(matrices, scn));
        commands.put("5", new MatrixTransposeCmd(matrices, scn));
        commands.put("6", new MultiplyMatrixWithCoefficentCmd(matrices, scn));
        commands.put("7", new MultiplyMatrixWithMatrixCmd(matrices, scn));
        commands.put("8", new MatrixRREFCmd(matrices, scn));

        commands.put("h", helpCmd);
        commands.put("l", new LoadMatricesFromFile(matrices, scn));
        commands.put("p", new PrintMatrices(matrices));
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
