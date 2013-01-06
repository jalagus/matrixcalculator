package matrixcalculator.logic;

import java.util.Arrays;
import matrixcalculator.UI.Utils;

public class Matrix {

    /**
     * Matriisin korkeus
     */
    final public int rows;
    /**
     * Matriisin leveys
     */
    final public int columns;
    final private double[][] values;

    /**
     * Muodostaa matriisin, parametrina annetun, kaksiulotteisen double-taulukon pohjalta.
     * 
     * @param matrix kaksiulotteinen double-tyypin taulukko, joka sisältää matriisin arvot
     */
    public Matrix(double[][] matrix) {
        this.rows = matrix.length;
        this.columns = matrix[0].length;
        this.values = matrix;
    }

    /**
     * Palauttaa matriisin arvot kaksiulotteisena double-taulukkona
     *
     * @return Kaksiulotteinen double-tyypin taulukko
     */
    public double[][] getValues() {
        double[][] returnValues = new double[this.values.length][this.values[0].length];

        for (int i = 0; i < returnValues.length; i++) {
            for (int a = 0; a < returnValues[0].length; a++) {
                returnValues[i][a] = this.values[i][a];
            }
        }

        return returnValues;
    }
   
    /**
     * Palauttaa matriisin tulostusmuodossa String-tyypin oliona. 
     * Luvut pyöristetään kahden desimaalin tarkkuuteen
     *
     * @return Matriisin tulostusmuoto
     */
    @Override
    public String toString() {
        String returnString = "";

        int padding = 8;

        for (int i = 0; i < rows; i++) {
            returnString += "| ";
            for (int a = 0; a < columns; a++) {
                if (values[i][a] < 0) {
                    returnString += Utils.padRight( String.format("%.3f", values[i][a]), padding);
                } else {
                    returnString += Utils.padRight(" " + String.format("%.3f", values[i][a]), padding);
                }
            }
            returnString += "|\n";
        }

        return returnString;
    }

    @Override
    public int hashCode() {
        int hash = 3;
        hash = 67 * hash + Arrays.deepHashCode(this.values);
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final Matrix other = (Matrix) obj;

        if (!Arrays.deepEquals(this.values, other.values)) {
            return false;
        }
        return true;
    }
}
