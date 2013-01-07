package matrixcalculator.logic;

public class MatrixLUDecomposition extends Matrix {

    /**
     * Luo uuden MatrixLUDecomposition-olion, jolla voidaan suorittaa matriisin 
     * LU-hajotus. Perii luokan Matrix.
     *
     * @param matrix matriisin arvot kaksiulotteisena double-taulukkona
     */
    public MatrixLUDecomposition(double[][] matrix) {
        super(matrix);
    }
    
    /**
     * Laskee LU-hajoituksen matriisille käyttäen Doolittlen algoritmia ja 
     * palauttaa tuloksen Matrix-tyypin oliona. Tätä käytetään mm. determinantin
     * laskennassa.
     * 
     * <b>Huom!</b> Tulos ei ole täysin tarkka pyöristysten takia.
     * 
     * @return Matrix-olio, jossa LU-hajotettu matriisi yhtenä matriisina
     */
    public Matrix decompose() {
        if (this.rows != this.columns) {
            return null;
        }
        
        double[][] A = this.getValues();
                
        int n = A.length;
        
        double sum = 0;
        
        // Laske ylä- ja alakolmiomatriisit alkuperäiseen taulukkoon
        for (int i = 0; i < n; i++) {
            for (int j = i; j < n; j++) {
                sum = 0;
                
                for (int k = 0; k < i; k++) {
                    sum += A[i][k] * A[k][j];
                }
                
                A[i][j] -= sum;
            }
            for (int j = i + 1; j < n; j++) {
                sum = 0;
                
                for (int k = 0; k < i; k++) {
                    sum += A[j][k] * A[k][i];
                }
                
                // Vältetään nollalla jakaminen
                if (A[i][i] == 0) {
                    return null;
                }
                
                A[j][i] = (A[j][i] - sum) / A[i][i];
            }            
        }
               
        return new Matrix(A);
    }    
    
    
    /**
     * Laskee matriisin LU-hajotelman yläkolmiomatriisin ja palauttaa tuloksen Matrix-tyypin oliona.
     * 
     * @return Matrix-olio, jossa yläkolmiomatriisi
     */
    public Matrix LU_UpperTriangle() {
        double[][] U = this.decompose().getValues();
        
        int n = U.length;
        
        for (int i = 1; i < n; i++) {
            for (int j = 0; j < i; j++) {
                U[i][j] = 0;
            }
        }
        
        return new Matrix(U);
    }
    
    /**
     * Laskee matriisin LU-hajotelman alakolmiomatriisin  ja palauttaa tuloksen Matrix-tyypin oliona.
     * 
     * @return Matrix-olio, jossa alakolmiomatriisi
     */
    public Matrix LU_LowerTriangle() {
        double[][] L = this.decompose().getValues();
        
        int n = L.length;
        
        for (int i = 0; i < n; i++) {
            for (int j = i; j < n; j++) {
                if (i == j) {
                    L[i][j] = 1;
                }
                else {
                    L[i][j] = 0;
                }
            }
        }
        
        return new Matrix(L);        
    } 
}
