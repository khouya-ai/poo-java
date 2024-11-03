package site.khouya.EX4;
import java.util.List;
import java.util.Scanner;

public class Application {
    public static void main(String[] args) {
        MetierProduitImpl metierProduit = new MetierProduitImpl();
        Scanner scanner = new Scanner(System.in);

        while (true) {
            System.out.println("***** Menu *****");
            System.out.println("1. Afficher la liste des produits");
            System.out.println("2. Rechercher des produits par mot clé");
            System.out.println("3. Ajouter un nouveau produit dans la liste");
            System.out.println("4. Récupérer et afficher un produit par ID");
            System.out.println("5. Supprimer un produit par id");
            System.out.println("0. Quitter");
            System.out.print("Choisissez une option: ");
            int choix = scanner.nextInt();
            scanner.nextLine(); // Consomme la nouvelle ligne

            switch (choix) {
                case 1:
                    System.out.println("Liste des produits:");
                    for (Produit p : metierProduit.getAll()) {
                        System.out.println(p);
                    }
                    break;

                case 2:
                    System.out.print("Entrez le mot clé de recherche: ");
                    String motCle = scanner.nextLine();
                    List<Produit> produitsTrouves = metierProduit.findByNom(motCle);
                    if (produitsTrouves.isEmpty()) {
                        System.out.println("Aucun produit trouvé avec ce mot clé.");
                    } else {
                        for (Produit p : produitsTrouves) {
                            System.out.println(p);
                        }
                    }
                    break;

                case 3:
                    System.out.print("Entrez l'ID du produit: ");
                    int id = scanner.nextInt();
                    scanner.nextLine(); // Consomme la nouvelle ligne

                    System.out.print("Entrez le nom du produit: ");
                    String nom = scanner.nextLine();

                    System.out.print("Entrez la marque du produit: ");
                    String marque = scanner.nextLine();

                    System.out.print("Entrez le prix du produit: ");
                    double prix = scanner.nextDouble();
                    scanner.nextLine();

                    System.out.print("Entrez la description du produit: ");
                    String description = scanner.nextLine();

                    System.out.print("Entrez le nombre en stock: ");
                    int nombreEnStock = scanner.nextInt();
                    scanner.nextLine();

                    Produit produit = new Produit(id, nom, marque, prix, description, nombreEnStock);
                    metierProduit.add(produit);
                    System.out.println("Produit ajouté avec succès!");
                    break;

                case 4:
                    System.out.print("Entrez l'ID du produit à afficher: ");
                    int idRecherche = scanner.nextInt();
                    scanner.nextLine();

                    Produit produitTrouve = metierProduit.findById(idRecherche);
                    if (produitTrouve != null) {
                        System.out.println(produitTrouve);
                    } else {
                        System.out.println("Produit non trouvé.");
                    }
                    break;

                case 5:
                    System.out.print("Entrez l'ID du produit à supprimer: ");
                    int idSupprimer = scanner.nextInt();
                    scanner.nextLine();

                    metierProduit.delete(idSupprimer);
                    System.out.println("Produit supprimé avec succès!");
                    break;

                case 0:
                    System.out.println("Au revoir!");
                    scanner.close();
                    return;

                default:
                    System.out.println("Option invalide. Veuillez réessayer.");
            }
        }
    }
}

