package matrixcalculator;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.Map.Entry;

public class UI {
    
    public class Command {
        String desc;
        
        public Command(String desc) {
            this.desc = desc;
        }
        
        public void run() {
            System.out.println("Running: " + this.desc);
        }
        
    }
    
    ArrayList<Matrix> matrices = new ArrayList<Matrix>();
    
    Map<String, String> commands = new HashMap<String, String>();
    
    public UI() {
        
    }
    
    public void start() {
        System.out.println("Matriisilaskin v0.1");
        System.out.println("---");
        System.out.println("Toiminnot: ");
        for (Entry<String, String> command : commands.entrySet()) {
            System.out.println(command.getKey());
        }
        
    }
}
