package site.khouya.EX2;

import site.khouya.EX1.TropViteException;
import site.khouya.EX1.Vehicule;

public class Calculateur {
    Calculateur() {}
    public void testRacineCarree(int entier) throws RacineCarreeException {
        if (entier < 0) {
            throw new RacineCarreeException(entier);
        }
    }

    public static void main(String[] args) {
        Calculateur calculateur = new Calculateur();

        try {
            // Test avec un entier positif
            calculateur.testRacineCarree(25);
            System.out.println("Entier 25 : Pas d'exception");

            // Test avec un entier negatif
            calculateur.testRacineCarree(-5);
        } catch (RacineCarreeException e) {
            // Affiche la pile d'appel de l'exception
            e.printStackTrace();
        }
    }
}
