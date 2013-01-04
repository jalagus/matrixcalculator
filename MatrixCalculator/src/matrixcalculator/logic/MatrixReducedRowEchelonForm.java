package matrixcalculator.logic;

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

        // Muodostetaan ensin yläkolmiomatriisi
        for (int i = 0; i < row.length; i++) {
            row = sortRowsByLeadingIndex(row);
            
            int leadingIndex = findLeadingIndex(row, i);
            if (leadingIndex == -1) {
                continue;
            }
            
            double leadingMultiplier = (1 / row[i][leadingIndex]);

            // Kerrotaan arvoja siten, että johtoalkio on 1
            for (int a = leadingIndex; a < row[i].length; a++) {
                row[i][a] *= leadingMultiplier;
            }
            row[i][leadingIndex] = 1;

            for (int a = i + 1; a < row.length; a++) {
                int secLead = findLeadingIndex(row, a);

                double rowMultiplier = row[a][secLead] / row[i][leadingIndex];

                for (int k = secLead; k < row[a].length; k++) {
                    row[a][k] -= row[i][k] * rowMultiplier;
                }
            }
        }
        
        // Yritetään nollat kaikki mahdolliset arvot yläkolmiomatriisista
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

        // Etsitään jokaisen rivin johtava alkio
        for (int i = 0; i < rows.length; i++) {
            leadingCol[i] = findLeadingIndex(rows, i);
        }

        int x = 0;

        double[][] retRows = new double[rows.length][rows[0].length];

        // Järjestetään rivit johtavien alkioiden paikan perusteella
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
