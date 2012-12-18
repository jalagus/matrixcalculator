package matrixcalculator;

import java.util.HashMap;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Scanner;
import java.util.TreeMap;
import matrixcalculator.commands.*;

public class UI {
    Scanner scn = new Scanner(System.in);
    
    private Map<String, Matrix> matrices = new HashMap<String, Matrix>();
    private Map<String, Command> commands = new TreeMap<String, Command>();
    private Command helpCmd;
    
    public UI() {
        this.registerCommands();
    }
    
    public void registerCommands() {
        helpCmd = new PrintHelp(commands);
        
        commands.put("1", new AddMatrix(matrices, scn));
        commands.put("2", new LoadMatricesFromFile(matrices, scn));
        commands.put("3", new PrintMatrices(matrices));
        commands.put("4", new MatrixAddition(matrices, scn));
        commands.put("5", helpCmd);
        
        commands.put("q", new EndProgram());
    }
    
    public void start() {
        System.out.println("Matriisilaskin v0.1");
        System.out.println("---");
       
        helpCmd.run();
        
        boolean running = true;
        
        while (running) {
            System.out.print("> ");
            String command = scn.nextLine();
            
            if (commands.containsKey(command)) {
                running = commands.get(command).run();
            }
            else {
                System.out.println("Tuntematon komento");
            }
        }
    }
}
