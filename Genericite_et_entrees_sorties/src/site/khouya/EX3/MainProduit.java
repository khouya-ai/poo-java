package site.khouya.EX3;
import java.util.Scanner;

public class MainProduit {

    public static void main(String[] args) {
        MetierProduitImpl metier = new MetierProduitImpl("produits.dat");
        Scanner scanner = new Scanner(System.in);
        boolean running = true;

        while (running) {
            System.out.println("\n1. Afficher la liste des produits");
            System.out.println("2. Rechercher un produit par son nom");
            System.out.println("3. Ajouter un nouveau produit");
            System.out.println("4. Supprimer un produit par nom");
            System.out.println("5. Sauvegarder les produits");
            System.out.println("6. Quitter");
            System.out.print("Choisissez une option : ");
            int choix = scanner.nextInt();
            scanner.nextLine(); // Consommer la ligne

            switch (choix) {
                case 1 -> metier.getAll().forEach(System.out::println);
                case 2 -> {
                    System.out.print("Entrez le nom du produit : ");
                    String nom = scanner.nextLine();
                    Produit produit = metier.findByNom(nom);
                    System.out.println(produit != null ? produit : "Produit introuvable.");
                }
                case 3 -> {
                    System.out.print("Nom : ");
                    String nom = scanner.nextLine();
                    System.out.print("Marque : ");
                    String marque = scanner.nextLine();
                    System.out.print("Prix : ");
                    double prix = scanner.nextDouble();
                    scanner.nextLine(); // Consommer la ligne
                    System.out.print("Description : ");
                    String description = scanner.nextLine();
                    System.out.print("Nombre en stock : ");
                    int stock = scanner.nextInt();
                    scanner.nextLine(); // Consommer la ligne
                    metier.add(new Produit(nom, marque, prix, description, stock));
                }
                case 4 -> {
                    System.out.print("Entrez le nom du produit à supprimer : ");
                    String nom = scanner.nextLine();
                    metier.delete(nom);
                }
                case 5 -> {
                    metier.saveAll();
                    System.out.println("Produits sauvegardés.");
                }
                case 6 -> running = false;
                default -> System.out.println("Option invalide.");
            }
        }

        scanner.close();
    }
}
