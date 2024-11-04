package site.khouya.EX1;

public class TropViteException extends Exception {
    TropViteException(int vitesse) {
        super("C'est une exception de type TropViteException. Vitesse en cause : " + vitesse);
    }
}
