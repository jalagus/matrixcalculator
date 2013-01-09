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
     * Laskee matriisin determinantin LU-hajotelman avulla ja palauttaa sen
     * double-tyyppisenä. <b>Huom!</b> Laskettu determinantti ei ole täysin
     * luotettava pyöristysten takia.
     *
     * @return double-tyypin muuttuja, jossa matriisin determinantti
     */
    public double determinant() {
        if (this.rows != this.columns) {
            throw new IllegalArgumentException("Matriisi ei ole neliämatriisi");
        }

        MatrixLUDecomposition LUdecomposition = new MatrixLUDecomposition(this.getValues());

        double[][] decomposedMatrix = LUdecomposition.decompose().getValues();

        double determinant = 1;

        // Determinantti on LU-hajotelman diagonaalin lukujen kertolaskujen summa
        for (int i = 0; i < decomposedMatrix.length; i++) {
            determinant *= decomposedMatrix[i][i];
        }

        return determinant;
    }

    /**
     * Laskee matriisin determinantin rekursiivisesti ja palauttaa sen
     * double-tyyppisenä. Antaa tarkemman tuloksen kuin LU-hajoitelman avulla
     * determinantin laskeminen, mutta on huomattavasti hitaampi.
     *
     * @return double-tyypin muuttuja, jossa matriisin determinantti
     *
     * @throws Heittää IllegalArgumentException-poikkeuksen, jos matriisi ei ole
     * neliömatriisi
     */
    public double recursiveDeterminant() {
        if (this.rows != this.columns) {
            throw new IllegalArgumentException();
        }

        return determinantHelper(this.getValues());
    }

    // Apumetodi determinantin rekursiiviseen laskemiseen käyttäen
    // divide-and-conquer -menetelmää jakaen matriisia, kunnes se on 2x2
    // matriisi ja laskee tämän jälkeen kaikki tulokset yhteen
    private double determinantHelper(double matrix[][]) {
        if (matrix.length == 2 && matrix[0].length == 2) {
            // 2x2 determinantti
            return (matrix[0][0] * matrix[1][1]) - (matrix[1][0] * matrix[0][1]);
        }

        double sum = 0;

        for (int i = 0; i < matrix[0].length; i++) {
            if (i % 2 == 1) {
                matrix[0][i] *= -1;
                sum += matrix[0][i] * determinantHelper(removeColumn(matrix, i));
            } else {
                sum += matrix[0][i] * determinantHelper(removeColumn(matrix, i));
            }

        }

        return sum;
    }

    // Poistaa halutun indeksin mukaisen sarakkeen taulukosta
    private double[][] removeColumn(double matrix[][], int index) {
        double[][] resultMatrix = new double[matrix.length - 1][matrix[0].length - 1];

        int x = 0;

        for (int i = 0; i < matrix[0].length; i++) {
            if (i != index) {
                for (int a = 1; a < matrix.length; a++) {
                    resultMatrix[a - 1][x] = matrix[a][i];
                }
                x++;
            }
        }

        return resultMatrix;
    }
}
