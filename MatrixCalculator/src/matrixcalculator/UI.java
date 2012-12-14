/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package matrixcalculator;

import java.util.ArrayList;

/**
 *
 * @author jalagus
 */
public class UI {
    
    ArrayList<Matrix> matrices = new ArrayList<Matrix>();
    
    public UI() {
        
    }
    
    public void start() {
        System.out.println("Matriisilaskin v0.1");
        System.out.println("---");
        System.out.println("Toiminnot: ");
        System.out.println("1) Syötä matriisi");
        System.out.println("2) Lataa matriisi/matriisit");
        System.out.println("3) Tulosta nykyiset matriisit");
        
    }
}
