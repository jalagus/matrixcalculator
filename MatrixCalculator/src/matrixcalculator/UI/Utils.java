package matrixcalculator.UI;

public class Utils {

    /**
     * Sisentää tekstiä halutun määrän oikealta
     * @param text sisennettävä teksti
     * @param padding sisennyksen määrä
     * @return String-olio, jossa sisennetty teksti
     */
    public static String padRight(String text, int padding) {
        return String.format("%1$-" + padding + "s", text);
    }
}
