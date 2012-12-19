/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package matrixcalculator;

/**
 *
 * @author jalagus
 */
public class Utils {

    public static String padRight(String s, int n) {
        return String.format("%1$-" + n + "s", s);
    }
}
