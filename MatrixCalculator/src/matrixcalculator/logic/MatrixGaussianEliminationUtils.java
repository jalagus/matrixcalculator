package matrixcalculator.logic;

public class MatrixGaussianEliminationUtils {

    /**
     * Etsii rivin ensimmäisen nollasta poikkavan alkion, eli johtavan alkion.
     * 
     * @param row rivi, josta alkiota etsitään
     * @return Palauttaa alkion indeksin, jos sellainen löytyy, muuten palautetaan -1
     */
    public int findRowPivot(double[] row) {
        for (int i = 0; i < row.length; i++) {
            if (row[i] != 0) {
                return i;
            }
        }
        return -1;
    }

    /**
     * Vähentää ensimmäisestä rivistä toista riviä multiplier-parametrin lukumäärän verran.
     *
     * @param row1 rivi joka vähennetään
     * @param row2 rivi josta vähennetään
     * @param multiplier kerrat joilla vähennettävää riviä vähennetään
     */
    public void substractRowWithMultiplier(double[] row1, double[] row2, double multiplier) {
        for (int i = 0; i < row1.length; i++) {
            row2[i] -= row1[i] * multiplier;
        }
    }

    /**
     * Vaihtaa kahden rivin paikkaa matriisissa, joka on annettu kaksiulotteisena
     * double-taulukkona.
     * 
     * @param matrix double-taulukko, jossa matriisin arvot
     * @param row1 rivin numero, joka halutaan vaihtaa
     * @param row2 toisen vaihdettavan rivin numero
     */
    public void swapRows(double[][] matrix, int row1, int row2) {
        double[] temp = matrix[row1];
        matrix[row1] = matrix[row2];
        matrix[row2] = temp;
    }    
}
