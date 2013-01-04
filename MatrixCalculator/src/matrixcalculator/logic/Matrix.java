package matrixcalculator.logic;

import java.util.Arrays;
import matrixcalculator.Utils;

public class Matrix {

    /**
     * Matriisin korkeus
     */
    final public int m;
    /**
     * Matriisin leveys
     */
    final public int n;
    final private double[][] values;

    /**
     * Muodostaa matriisin, parametrina annetun, kaksiulotteisen double-taulukon pohjalta.
     * 
     * @param matrix kaksiulotteinen double-tyypin taulukko, joka sisältää matriisin arvot
     */
    public Matrix(double[][] matrix) {
        this.m = matrix.length;
        this.n = matrix[0].length;
        this.values = matrix;
    }

    /**
     * Palauttaa matriisin arvot kaksiulotteisena double-taulukkona
     *
     * @return Kaksiulotteinen double-tyypin taulukko
     */
    public double[][] getValues() {
        double[][] retValues = new double[this.values.length][this.values[0].length];

        for (int i = 0; i < retValues.length; i++) {
            for (int a = 0; a < retValues[0].length; a++) {
                retValues[i][a] = this.values[i][a];
            }
        }

        return retValues;
    }
   
    /**
     * Palauttaa matriisin tulostusmuodossa String-tyypin oliona
     *
     * @return Matriisin tulostusmuoto
     */
    @Override
    public String toString() {
        String ret = "";

        int padding = 6;

        for (int i = 0; i < m; i++) {
            ret += "| ";
            for (int a = 0; a < n; a++) {
                if (values[i][a] < 0) {
                    ret += Utils.padRight(values[i][a] + "", padding);
                } else {
                    ret += Utils.padRight(" " + values[i][a], padding);
                }
            }
            ret += "|\n";
        }

        return ret;
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
