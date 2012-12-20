package matrixcalculator;

import java.util.HashMap;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Scanner;
import java.util.TreeMap;
import matrixcalculator.commands.*;

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
        commands.put("4", new MatrixAddition(matrices, scn));
        commands.put("5", new MatrixDeterminant(matrices, scn));
        commands.put("6", new MatrixInverse(matrices, scn));
        commands.put("7", new MatrixTranspose(matrices, scn));
        commands.put("8", new MultiplyMatrixWithCoefficent(matrices, scn));
        commands.put("9", new MultiplyMatrixWithMatrix(matrices, scn));
        commands.put("0", new MatrixRREF(matrices, scn));

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
