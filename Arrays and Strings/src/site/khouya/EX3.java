package site.khouya;

import java.util.Scanner;

public class EX3 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int choix;
        StringBuilder chaine = new StringBuilder();
        boolean quit;
        do {
            System.out.println(
"""
        ******************************************** Menu *****************                
        1. saisir : lire une chaîne de caractères à partir du clavier et 
            la stocker dans une variable.
        2. afficher : afficher la chaîne saisie.
        3. inverser : inverser la chaîne saisie.
        4. Nombre de mots : compter le nombre de mots de la chaîne.
            On considère le caractère ‘ ’ (blanc) comme le caractère séparateur
            de mots. Il peut y avoir plusieurs blancs consécutifs dans la chaîne.
        ***********************************************************************""");
            System.out.print("choisir une opération à effectuer (1, 2, 3 ou 4) :");
            choix = scanner.nextInt();
            scanner.nextLine();
            switch (choix) {
                case 1:
                    // Saisie de chaine
                    System.out.print("Entrez une chaine de caractères quelconque : ");
                    chaine = new StringBuilder(scanner.nextLine().trim());
                    break;
                case 2:
                    // Afficher la chaine saisie
                    System.out.println("la chaine saisie: " + chaine);
                    break;
                case 3:
                    // Inverser la chaîne saisie
                    System.out.println("L'inverse de chaine saisie: " + chaine.reverse());
                    break;
                case 4:
                    // Nombre de mots
                    int nbr = chaine.toString().split("\\s+").length;
                    System.out.println("Le nombre de mots: " + nbr);
                    break;
                default:
                    System.out.println("Choix invalide. Veuillez réessayer.");
                    break;

            }
            // tapper la lettre q pour quitter
            quit = false;
            System.out.println("Frappez une touche pour revenir au menu (q pour quitter)");
            if (scanner.nextLine().trim().equals("q")) {
                quit = true;
            }

        } while (!quit);

        scanner.close();
    }
}
