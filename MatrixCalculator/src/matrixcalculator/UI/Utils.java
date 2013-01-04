package matrixcalculator.UI;

public class Utils {

    /**
     * Sisentää tekstiä halutun määrän oikealta
     * @param s sisennettävä teksti
     * @param n sisennyksen määrä
     * @return String-olio, jossa sisennetty teksti
     */
    public static String padRight(String s, int n) {
        return String.format("%1$-" + n + "s", s);
    }
    
    public static double round(double number, int places) {
        
        for (int i = 0; i < places; i++) {
            number *= 10;
        }
        
        number = Math.round(number);
        
        for (int i = 0; i < places; i++) {
            number /= 10;
        }        
        
        
        return number;
    }
}
