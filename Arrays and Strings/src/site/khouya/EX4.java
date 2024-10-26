package site.khouya;

import java.util.Scanner;

public class EX4 {
    public static void main(String[] args) {
        //Saisie de la chaine
        System.out.print("Entrez une ligne de texte (max. 100 caractères) : ");
        String text = new Scanner(System.in).nextLine().trim();

        // Compte les occurrences des lettres dans 'text'
        String AZ = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";
        int[] nb_occurrences = new int[26];
        for (int i = 0; i < 26; i++) {
            char c = AZ.charAt(i);
            // compter l'ocurrence de lettre 'c' dans 'text'
            for (int j = 0; j < text.length(); j++) {
                if(text.charAt(j) == c) {
                    nb_occurrences[i]++;
                }
            }
        }
        // Afficher les résultats
        System.out.printf("La chaine \"%s\" contient : \n",text);
        for (int i = 0; i < 26; i++) {
            if(nb_occurrences[i] != 0) {
                System.out.printf("%d fois la lettre '%s'\n", nb_occurrences[i], AZ.charAt(i));
            }
        }

    }
}
