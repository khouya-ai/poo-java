package site.khouya.EX1;

public class Vehicule {

    public void testVitesse(int vitesse) throws TropViteException {
        if (vitesse > 90) {
            throw new TropViteException(vitesse);
        }
    }

    Vehicule() {}

    public static void main(String[] args) {
        Vehicule vehicule = new Vehicule();

        try {
            // Test avec une vitesse en dessous de la limite
            vehicule.testVitesse(80);
            System.out.println("Vitesse 80 : Pas d'exception");

            // Test avec une vitesse au-dessus de la limite
            vehicule.testVitesse(100);
        } catch (TropViteException e) {
            // Affiche la pile d'appel de l'exception
            e.printStackTrace();
        }
    }
}
