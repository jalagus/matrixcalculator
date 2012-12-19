/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package matrixcalculator.commands;

import java.util.Map;

/**
 *
 * @author jalagus
 */
public class PrintHelp implements Command {

    Map<String, Command> commands;

    public PrintHelp(Map<String, Command> commands) {
        this.commands = commands;
    }

    @Override
    public boolean run() {
        System.out.println("Toiminnot: ");

        for (Map.Entry<String, Command> commandEntry : commands.entrySet()) {
            Command command = commandEntry.getValue();
            System.out.println(commandEntry.getKey() + ") " + command.getDescription());
        }

        return true;
    }

    @Override
    public String getDescription() {
        return "Tulosta ohje";
    }
}
