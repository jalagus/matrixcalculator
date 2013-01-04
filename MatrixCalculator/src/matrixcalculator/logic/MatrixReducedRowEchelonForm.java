/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package matrixcalculator.logic;

/**
 *
 * @author jalagus
 */
public class MatrixReducedRowEchelonForm extends Matrix {
    
    public MatrixReducedRowEchelonForm(double[][] matrix) {
        super(matrix);
    }
    
    /**
     * Laskee matriisin redusoidun porrasmuodon ja palauttaa tuloksen Matrix-tyypin oliona.
     *
     * @return Matrix-olio, jossa matriisi redusoidussa porramuodossa
     */
    public Matrix rref() {
        double[][] row = this.getValues();

        for (int i = 0; i < row.length; i++) {
            row = sortRowsByLeadingIndex(row);
            int lead = findLeadingIndex(row, i);
            double leadingMultiplier = (1 / row[i][lead]);

            if (lead == -1) {
                continue;
            }

            // Kerrotaan arvoja siten, että johtoalkio on 1
            for (int a = lead; a < row[i].length; a++) {
                row[i][a] *= leadingMultiplier;
            }
            row[i][lead] = 1;

            for (int a = i + 1; a < row.length; a++) {
                int secLead = findLeadingIndex(row, a);

                double rowMultiplier = row[a][secLead] / row[i][lead];

                for (int k = secLead; k < row[a].length; k++) {
                    row[a][k] -= row[i][k] * rowMultiplier;
                }
            }
        }

        for (int i = row.length - 1; i > 0; i--) {
            int leadingIndex = findLeadingIndex(row, i);

            if (leadingIndex != -1) {
                for (int a = 0; a < i; a++) {
                    double multiplier = row[a][leadingIndex] / row[i][leadingIndex];

                    int firstIndex = findLeadingIndex(row, a);
                    if (firstIndex != -1) {
                        for (int k = firstIndex; k < row[a].length; k++) {
                            row[a][k] -= multiplier * row[i][k];
                        }
                    }
                }
            }
        }

        return new Matrix(sortRowsByLeadingIndex(row));
    }

    // Apumetodi, joka etsii rivin johtavan alkion ja palauttaa -1
    // mikäli rivillä ei ole johtavaa alkiota
    private int findLeadingIndex(double[][] rows, int a) {
        for (int i = 0; i < rows[a].length; i++) {
            if (rows[a][i] != 0) {
                return i;
            }
        }

        return -1;
    }

    // Apumetodi joka järjestää rivit siten, että ne tulevat laskevassa 
    // järjestyksessä johtavan alkion paikan mukaan
    private double[][] sortRowsByLeadingIndex(double[][] rows) {
        int[] leadingCol = new int[rows.length];

        for (int i = 0; i < rows.length; i++) {
            for (int a = 0; a < rows[0].length; a++) {
                if (rows[i][a] != 0) {
                    leadingCol[i] = a;
                    break;
                }
            }
        }

        int x = 0;

        double[][] retRows = new double[rows.length][rows[0].length];

        for (int i = 0; i < leadingCol.length; i++) {
            for (int a = 0; a < rows.length; a++) {
                if (leadingCol[a] == i) {
                    retRows[x++] = rows[a];
                }
            }
        }

        return retRows;
    }    
}
