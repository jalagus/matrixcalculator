package matrixcalculator.performancetests;

import java.io.BufferedReader;
import java.io.DataInputStream;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import matrixcalculator.logic.*;

public class PerformanceTests {
    
    public static void main(String[] args) {
        
        int testCases = 1000;
        
        testAddition(testCases, "../Dokumentit/Testfiles/100x100.txt");
        System.out.println("");
        
        testMultiplication(testCases, "../Dokumentit/Testfiles/100x100.txt");
        System.out.println("");
        
        testRREF(testCases, "../Dokumentit/Testfiles/100x100.txt");
        System.out.println("");
        
        testDeterminant(testCases, "../Dokumentit/Testfiles/100x100.txt");
        System.out.println("");
        
        testInversion(testCases, "../Dokumentit/Testfiles/100x100.txt");
        System.out.println("");
        
        testTranspose(testCases, "../Dokumentit/Testfiles/100x100.txt");
        System.out.println("");
        
        testLUDecomposition(testCases, "../Dokumentit/Testfiles/100x100.txt");
    }
    
    public static void testDeterminant(int loops, String filename) {
        Matrix A = loadMatrixFromFile(filename);
        MatrixDeterminant DetM = new MatrixDeterminant(A.getValues());
        
        System.out.println("Starting determinant test...");
        
        long startTime = System.currentTimeMillis();
        
        for (int i = 0; i < loops; i++) {
            DetM.determinant();
        }
        
        long endTime = System.currentTimeMillis();
        
        System.out.println("Finished " + loops + " testcases in " + (endTime - startTime) + " ms");
        System.out.println("Average per case is: " + ((endTime - startTime) / loops) + " ms");
    }
    
    public static void testAddition(int loops, String filename) {
        Matrix A = loadMatrixFromFile(filename);
        
        MatrixAddition addition = new MatrixAddition(A.getValues());
        
        System.out.println("Starting addition test...");
        
        long startTime = System.currentTimeMillis();
        
        for (int i = 0; i < loops; i++) {
            addition.add(A);
        }
        
        long endTime = System.currentTimeMillis();
        
        System.out.println("Finished " + loops + " testcases in " + (endTime - startTime) + " ms");
        System.out.println("Average per case is: " + ((endTime - startTime) / loops) + " ms");
    }
    
    public static void testMultiplication(int loops, String filename) {
        Matrix A = loadMatrixFromFile(filename);
        
        MatrixMultiplication multiplication = new MatrixMultiplication(A.getValues());
        
        System.out.println("Starting multiplication test...");
        
        long startTime = System.currentTimeMillis();
        
        for (int i = 0; i < loops; i++) {
            multiplication.multiply(A);
        }
        
        long endTime = System.currentTimeMillis();
        
        System.out.println("Finished " + loops + " testcases in " + (endTime - startTime) + " ms");
        System.out.println("Average per case is: " + ((endTime - startTime) / loops) + " ms");
    }
    
    public static void testRREF(int loops, String filename) {
        Matrix A = loadMatrixFromFile(filename);
        
        MatrixReducedRowEchelonForm rref = new MatrixReducedRowEchelonForm(A.getValues());
        
        System.out.println("Starting RREF test...");
        
        long startTime = System.currentTimeMillis();
        
        
        for (int i = 0; i < loops; i++) {
            rref.rref();
        }
        
        long endTime = System.currentTimeMillis();
        
        System.out.println("Finished " + loops + " testcases in " + (endTime - startTime) + " ms");
        System.out.println("Average per case is: " + ((endTime - startTime) / loops) + " ms");
    }
    
    public static void testInversion(int loops, String filename) {
        Matrix A = loadMatrixFromFile(filename);
        
        MatrixInverse inversion = new MatrixInverse(A.getValues());
        
        System.out.println("Starting inverse test...");
        
        long startTime = System.currentTimeMillis();
        
        for (int i = 0; i < loops; i++) {
            inversion.inverse();
        }
        
        long endTime = System.currentTimeMillis();
        
        System.out.println("Finished " + loops + " testcases in " + (endTime - startTime) + " ms");
        System.out.println("Average per case is: " + ((endTime - startTime) / loops) + " ms");
    }
    
    public static void testTranspose(int loops, String filename) {
        Matrix A = loadMatrixFromFile(filename);
        
        MatrixTranspose transpose = new MatrixTranspose(A.getValues());
        
        System.out.println("Starting transposition test...");
        
        long startTime = System.currentTimeMillis();
        
        for (int i = 0; i < loops; i++) {
            transpose.transpose();
        }
        
        long endTime = System.currentTimeMillis();
        
        System.out.println("Finished " + loops + " testcases in " + (endTime - startTime) + " ms");
        System.out.println("Average per case is: " + ((endTime - startTime) / loops) + " ms");
    }
    
    public static void testLUDecomposition(int loops, String filename) {
        Matrix A = loadMatrixFromFile(filename);
        
        MatrixLUDecomposition decomposition = new MatrixLUDecomposition(A.getValues());
        
        System.out.println("Starting decomposition test...");
        
        long startTime = System.currentTimeMillis();
        
        for (int i = 0; i < loops; i++) {
            decomposition.decompose();
        }
        
        long endTime = System.currentTimeMillis();
        
        System.out.println("Finished " + loops + " testcases in " + (endTime - startTime) + " ms");
        System.out.println("Average per case is: " + ((endTime - startTime) / loops) + " ms");
    }
    
    public static Matrix loadMatrixFromFile(String filename) {
        
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
        } catch (Exception ex) {
            System.out.println(ex.getMessage());
            return null;
        }
        
    }
}
