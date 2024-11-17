package site.khouya.Collection.EX3;

import java.util.HashSet;
import java.util.Set;

public class GestionGroupAB {
    public static void main(String[] args) {
        // Création des HashSets pour les deux groupes
        Set<String> groupeA = new HashSet<>();
        Set<String> groupeB = new HashSet<>();

        // 1. Ajouter des noms d'étudiants à chaque groupe
        groupeA.add("Ahmed");
        groupeA.add("Samir");
        groupeA.add("Ali");
        groupeA.add("Sami");

        groupeB.add("Samira");
        groupeB.add("Hind");
        groupeB.add("Rim");
        groupeB.add("Hassna");

        // Affichage des groupes
        System.out.println("Groupe A : " + groupeA);
        System.out.println("Groupe B : " + groupeB);

        // 2. Afficher l'intersection des deux HashSets
        Set<String> intersection = new HashSet<>(groupeA);
        intersection.retainAll(groupeB);
        System.out.println("\nIntersection des deux groupes : " + intersection);

        // 3. Afficher l'union des deux HashSets
        Set<String> union = new HashSet<>(groupeA);
        union.addAll(groupeB);
        System.out.println("\nUnion des deux groupes : " + union);
    }
}
