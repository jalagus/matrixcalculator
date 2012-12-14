/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package matrixcalculator.commands;

/**
 *
 * @author jalagus
 */
public class Dummy implements Command {
    @Override
    public void run() {
        System.out.println("Heijjaa!");
    }
    
    @Override
    public String getDescription() {
        return "Hieno juttu";
    }
}
