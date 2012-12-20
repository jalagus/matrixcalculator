package matrixcalculator;

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
}
