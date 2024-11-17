package site.khouya.Collection.EX1;

import java.util.ArrayList;
import java.util.Scanner;

public class GestionProduitsApp extends Exception {
    public static void main(String[] args) {
        // Création de la liste de produits
        ArrayList<Produit> produits = new ArrayList<>();

        // Ajout de produits
        produits.add(new Produit(1, "Produit1", 100.0));
        produits.add(new Produit(2, "Produit2", 200.0));
        produits.add(new Produit(3, "Produit3", 150.0));

        System.out.println("Liste des produits après ajout : ");
        afficherProduits(produits);

        // Suppression d'un produit par indice
        produits.remove(1);

        System.out.println("\nListe des produits après suppression : ");
        afficherProduits(produits);

        // Modification d'un produit par indice
        Produit produitModifie = produits.get(0);
        produitModifie.setNom("ProduitModifie");
        produitModifie.setPrix(120.0);

        System.out.println("\nListe des produits après modification : ");
        afficherProduits(produits);

        // Recherche d'un produit par nom
        Scanner scanner = new Scanner(System.in);
        System.out.print("\nEntrez le nom du produit à rechercher : ");
        String nomRecherche = scanner.nextLine();

        boolean trouve = false;
        for (Produit produit : produits) {
            if (produit.getNom().equalsIgnoreCase(nomRecherche)) {
                System.out.println("Produit trouvé : " + produit);
                trouve = true;
                break;
            }
        }

        if (!trouve) {
            System.out.println("Aucun produit trouvé avec le nom '" + nomRecherche + "'.");
        }

        scanner.close();
    }

    // Méthode pour afficher tous les produits
    public static void afficherProduits(ArrayList<Produit> produits) {
        for (Produit produit : produits) {
            System.out.println(produit);
        }
    }
}
