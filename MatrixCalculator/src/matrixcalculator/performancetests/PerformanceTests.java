/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package matrixcalculator.performancetests;

import java.io.BufferedReader;
import java.io.DataInputStream;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import matrixcalculator.logic.Matrix;
import matrixcalculator.logic.MatrixDeterminant;

/**
 *
 * @author jalagus
 */
public class PerformanceTests {
    public static void main(String[] args) {
        TestDeterminant();
    }
    
    public static void TestDeterminant() {
        Matrix A = lataaMatriisiTiedostosta("../Dokumentit/Testfiles/100x100.txt");   
        MatrixDeterminant DetTest = new MatrixDeterminant(A.getValues());
        
        
        System.out.println("Starting test...");
        for (int i = 0; i < 10000; i++) {
            double det = DetTest.determinant();
        }        
        System.out.println("Finished in: ");
    }
    
    public static Matrix lataaMatriisiTiedostosta(String filename) {
        
        int matrixSize = 0;
        
        try {
            FileInputStream fstream = new FileInputStream(filename);

            DataInputStream in = new DataInputStream(fstream);
            BufferedReader br = new BufferedReader(new InputStreamReader(in));
            
            String strLine;
            String wholeMatrix = "";
            while ((strLine = br.readLine()) != null) {
                matrixSize = strLine.split("\\s+").length;
                wholeMatrix += " " + strLine;
            }   
            
            
            String[] splitRow = wholeMatrix.trim().split("\\s+");
            double[][] matrix = new double[matrixSize][splitRow.length / matrixSize];
            
            int x = 0;
            
            for (String val : splitRow) {
                matrix[x / matrixSize][x % matrixSize] = Double.parseDouble(val);
                x++;
            }
            
            return new Matrix(matrix);
        }
        catch (Exception ex) {
            System.out.println(ex.getMessage());
            return null;
        }
        
    }    
}
