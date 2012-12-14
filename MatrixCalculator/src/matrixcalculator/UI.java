package matrixcalculator;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.Map.Entry;
import matrixcalculator.commands.Command;
import matrixcalculator.commands.Dummy;

public class UI {

    
    private ArrayList<Matrix> matrices = new ArrayList<Matrix>();
    
    private Map<String, Command> commands = new HashMap<String, Command>();
    
    public UI() {
        this.registerCommands();
    }
    
    public void registerCommands() {
        commands.put("1", new Dummy());
    }
    
    public void start() {
        System.out.println("Matriisilaskin v0.1");
        System.out.println("---");
       
        printHelp();
    }
    
    public void printHelp() {

        System.out.println("Toiminnot: ");
        
        for (Entry<String, Command> commandEntry : commands.entrySet()) {
            Command command = commandEntry.getValue();
            System.out.println(commandEntry.getKey() + ") " + command.getDescription());
        }        
    }
}
