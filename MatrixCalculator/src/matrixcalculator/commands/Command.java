package matrixcalculator.commands;

public interface Command {
    public boolean run();
    
    public String getDescription();
}
