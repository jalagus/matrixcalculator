package matrixcalculator.logic;

public class MatrixDeterminant extends Matrix {

    /**
     * Luo uuden MatrixDeterminant-olion, jolla voidaan suorittaa matriisien 
     * determinantin laskeminen. Perii luokan Matrix.
     *
     * @param matrix matriisin arvot kaksiulotteisena double-taulukkona
     */    
    public MatrixDeterminant(double[][] matrix) {
        super(matrix);
    }

    /**
     * Laskee matriisin determinantin LU-hajotelman avulla ja palauttaa sen double-tyyppisenä. 
     * <b>Huom!</b> Laskettu determinantti ei ole täysin luotettava pyöristysten takia.
     * 
     * @return double-tyypin muuttuja, jossa matriisin determinantti
     */
    public double determinant() {
        if (this.rows != this.columns) {
            throw new IllegalArgumentException();
        }
        
        MatrixLUDecomposition LUdecomposition = new MatrixLUDecomposition(this.getValues());
        
        double[][] decomposedMatrix = LUdecomposition.decompose().getValues();
        
        double sum = 1;
        
        for (int i = 0; i < decomposedMatrix.length; i++) {
            sum *= decomposedMatrix[i][i];
        }
        
        return sum;
    }
    
    /**
     * Laskee matriisin determinantin rekursiivisesti ja palauttaa sen double-tyyppisenä. 
     * Toimii varmemmin kuin LU-hajoitelman avulla determinantin laskeminen, mutta on
     * huomattavasti hitaampi
     * 
     * @return double-tyypin muuttuja, jossa matriisin determinantti
     * 
     * @throws Heittää IllegalArgumentException-poikkeuksen, jos matriisi ei ole neliömatriisi
     */
    public double recursiveDeterminant() {
        if (this.rows != this.columns) {
            throw new IllegalArgumentException();
        }

        return detHelper(this.getValues());
    }

    // Apumetodi determinantin rekursiiviseen laskemiseen käyttäen
    // divide-and-conquer -menetelmää jakaen matriisia, kunnes se on 2x2
    // matriisi ja laskee tämän jälkeen kaikki tulokset yhteen
    private double detHelper(double mat[][]) {
        if (mat.length == 2 && mat[0].length == 2) {
            // 2x2 determinantti
            return (mat[0][0] * mat[1][1]) - (mat[1][0] * mat[0][1]);
        }

        double sum = 0;

        for (int i = 0; i < mat[0].length; i++) {
            if (i % 2 == 1) {
                mat[0][i] *= -1;
                sum += mat[0][i] * detHelper(removeColumn(mat, i));
            } else {
                sum += mat[0][i] * detHelper(removeColumn(mat, i));
            }

        }

        return sum;
    }

    // Poistaa halutun indeksin mukaisen sarakkeen taulukosta
    private double[][] removeColumn(double mat[][], int index) {
        double[][] retMatrix = new double[mat.length - 1][mat[0].length - 1];

        int x = 0;

        for (int i = 0; i < mat[0].length; i++) {
            if (i != index) {
                for (int a = 1; a < mat.length; a++) {
                    retMatrix[a - 1][x] = mat[a][i];
                }
                x++;
            }
        }

        return retMatrix;
    }    
}
