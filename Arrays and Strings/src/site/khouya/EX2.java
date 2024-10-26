package site.khouya;

import java.util.Scanner;

public class EX2 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Saisie du verbe
        System.out.print("Entrez un verbe du premier groupe : ");
        String verbe = scanner.nextLine().trim();

        // Vérification si c'est un verbe du premier groupe (se terminant par "er")
        if (verbe.endsWith("er") && verbe.length() > 2) {
            String radicale = verbe.substring(0, verbe.length() - 2);

            // Vérifier si le radical se termine par "g" (exception pour la conjugaison avec "nous")
            String conjugaisonNous = radicale.endsWith("g") ? "nous %seons" : "nous %sons";

            // Modèle de conjugaison avec insertion du radical
            String conjugaison = String.format(
                    "je %se\n" +
                            "tu %ses\n" +
                            "il/elle/on %se\n" +
                            conjugaisonNous + "\n" +
                            "vous %sez\n" +
                            "ils/elles %sent",
                    radicale, radicale, radicale, radicale, radicale, radicale
            );

            // Afficher la conjugaison complète
            System.out.println(conjugaison);
        } else {
            System.out.println("Ce mot n'est pas un verbe du premier groupe !");
        }

        scanner.close();
    }
}
