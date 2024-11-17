package site.khouya.Collection.EX2;

import site.khouya.Collection.EX1.Produit;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class GestionNoteEtudiantsApp extends Exception {
    public static void main(String[] args) {
        // Création de la Hashmap
        Map<String, Double> qde = new HashMap<>();

        // Ajout des notes des étudiants.
        qde.put("Ahmed", 17.0);
        qde.put("Samira", 15.0);
        qde.put("Ali", 16.0);
        qde.put("Khalid", 20.0);

        System.out.println("Liste des notes après insertion : ");
        afficherProduits(qde);

        // Augmenter la note d’un étudiant
        qde.put("Ahmed", qde.get("Ahmed") + 1);

        System.out.println("\nListe des notes après Augmentation de la note de Ahmed : ");
        afficherProduits(qde);

        // Supprimer la note d’un étudiant.
        qde.remove("Ahmed");
        System.out.println("\nListe des notes après Suppression de la note de Ahmed : ");
        afficherProduits(qde);

        //Afficher la taille du map.
        System.out.printf("\nLa taille du map : %d", qde.size());

        // Afficher la note moyenne, max et min.
        double somme = 0.0;
        double max = Double.MIN_VALUE;
        double min = Double.MAX_VALUE;
        String etud_max = "",etud_min = "";

        for (String etud : qde.keySet()) {
            double note =  qde.get(etud);
            somme += note;
            if (note > max) {
                max = note;
                etud_max = etud;
            }
            if (note < min) {
                min = note;
                etud_min = etud;
            };
        }

        double moyenne = somme / qde.size();
        System.out.println("\n\nNote moyenne : " + moyenne);
        System.out.printf("Note maximale : %s => %.2f" ,etud_max, max);
        System.out.printf("\nNote minimale : %s => %.2f" ,etud_min, min);

        // 6. Vérifier s’il y a une note égale à 20
        boolean aNoteEgaleVingt = qde.containsValue(20.0);
        System.out.println("\n\nY a-t-il une note égale à 20 ? " + (aNoteEgaleVingt ? "Oui" : "Non"));


    }

    // Méthode pour afficher tous les produits
    public static void afficherProduits(Map<String, Double> map1) {
        //afficher les valeurs avec foreach et l'expression l'ambda
        map1.forEach((v,w) -> System.out.println("("+ v + ", "+ w +")"));
    }
}
