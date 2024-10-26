package site.khouya;

import java.util.Arrays;
import java.util.Scanner;

/***
 * Notes des Etudiants
 */
public class EX1 {


    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        // Saisie du nombre d'étudiants
        System.out.print("Entrez le nombre d'étudiants : ");
        int nombreEtudiants = scanner.nextInt();

        // Saisie des notes
        double[] notes = new double[nombreEtudiants];
        for (int i = 0; i < nombreEtudiants; i++) {
            System.out.print("Entrez la note de l'étudiant " + (i + 1) + " : ");
            notes[i] = scanner.nextDouble();
        }
        // 1. Trier et afficher la liste des notes
        Arrays.sort(notes);
        System.out.println("Liste des notes triées : " + Arrays.toString(notes));

        // 2. Calculer et afficher la note moyenne
        double somme = 0;
        for (double note : notes) {
            somme += note;
        }
        double moyenne = somme / nombreEtudiants;
        System.out.println("La note moyenne est : " + moyenne);

        // 3. Afficher la note maximale et minimale
        double noteMaximale = notes[nombreEtudiants - 1];
        double noteMinimale = notes[0];
        System.out.println("La note maximale est : " + noteMaximale);
        System.out.println("La note minimale est : " + noteMinimale);

        // 4. Afficher le nombre d'étudiants ayant une note saisie par l'utilisateur
        System.out.print("Entrez une note pour voir combien d'étudiants l'ont obtenue : ");
        double noteRecherchee = scanner.nextDouble();
        int compteur = 0;
        for (double note : notes) {
            if (note == noteRecherchee) {
                compteur++;
            }
        }
        System.out.println("Nombre d'étudiants ayant obtenu la note " + noteRecherchee + " : " + compteur);

        scanner.close();
    }


}
