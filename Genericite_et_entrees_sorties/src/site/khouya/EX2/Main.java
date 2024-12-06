package site.khouya.EX2;

import java.io.IOException;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) throws IOException {
        DossierContact dossier = new DossierContact();
        Scanner scanner = new Scanner(System.in);
        int choix;
        String nom;
        boolean quit;
        do {
            System.out.println(
                    """
                            ******************************************** Menu *****************
                            1. Rechercher un numéro de téléphone.
                            2. Ajouter un nouveau contact.
                            3. Supprimer un contact.
                            4. Changer le numéro de téléphone d’un contact.
                            ***********************************************************************""");
            System.out.print("choisir une opération à effectuer (1, 2, 3 ou 4) :");
            choix = scanner.nextInt();
            // pour consommer le retour à la ligne restante Après l'utilisation de Scanner.nextInt()
            scanner.nextLine();
            switch (choix) {
                case 1:
                    // Rechercher un numéro de téléphone.
                    System.out.print("Entrez un nom  : ");
                    nom = scanner.nextLine().trim();
                    System.out.println(dossier.chercherNumero(nom));
                    break;
                case 2:
                    // Ajouter un nouveau contact.
                    System.out.print("Entrez un nom  : ");
                    nom = scanner.nextLine().trim();
                    System.out.print("Entrez un numero  : ");
                    String numero = scanner.nextLine().trim();
                    dossier.ajouterContact(nom, numero);
                    break;
                case 3:
                    // Supprimer un contact.
                    System.out.print("Entrez un nom  : ");
                    nom = scanner.nextLine().trim();
                    dossier.supprimerContact(nom);
                    break;
                case 4:
                    // Changer le numéro de téléphone d’un contact.
                    System.out.print("Entrez un nom  : ");
                    nom = scanner.nextLine().trim();
                    System.out.print("Entrez le nouveau numero  : ");
                    String nouveauNumero = scanner.nextLine().trim();
                    dossier.changerNumero(nom, nouveauNumero);
                    break;
                default:
                    System.out.println("Choix invalide. Veuillez réessayer.");
                    break;

            }
            // tapper la lettre q pour quitter
            quit = false;
            System.out.println("Frappez une touche pour revenir au menu (5 pour sauvegarder et quitter)");
            if (scanner.nextLine().trim().equals("5")) {
                dossier.sauvegarderContacts();
                quit = true;
            }

        } while (!quit);

        scanner.close();
    }


}
