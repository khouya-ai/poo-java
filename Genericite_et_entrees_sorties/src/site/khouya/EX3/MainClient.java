package site.khouya.EX3;

import java.util.Scanner;

public class MainClient {
    public static void main(String[] args) {
        MetierClientImpl metier = new MetierClientImpl("clients.dat");
        Scanner scanner = new Scanner(System.in);
        boolean running = true;

        while (running) {
            System.out.println("\n1. Afficher la liste des clients");
            System.out.println("2. Rechercher un client par son nom");
            System.out.println("3. Ajouter un nouveau client");
            System.out.println("4. Supprimer un client par nom");
            System.out.println("5. Sauvegarder les clients");
            System.out.println("6. Quitter");
            System.out.print("Choisissez une option : ");
            int choix = scanner.nextInt();
            scanner.nextLine(); // Consommer la ligne

            switch (choix) {
                case 1 -> metier.getAll().forEach(System.out::println);
                case 2 -> {
                    System.out.print("Entrez le nom du client : ");
                    String nom = scanner.nextLine();
                    Client client = metier.findByNom(nom);
                    System.out.println(client != null ? client : "Client introuvable.");
                }
                case 3 -> {
                    System.out.print("Nom : ");
                    String nom = scanner.nextLine();
                    System.out.print("Prénom : ");
                    String prenom = scanner.nextLine();
                    System.out.print("Adresse : ");
                    String adresse = scanner.nextLine();
                    System.out.print("Téléphone : ");
                    String tel = scanner.nextLine();
                    System.out.print("Email : ");
                    String email = scanner.nextLine();
                    metier.add(new Client(nom, prenom, adresse, tel, email));
                }
                case 4 -> {
                    System.out.print("Entrez le nom du client à supprimer : ");
                    String nom = scanner.nextLine();
                    metier.delete(nom);
                }
                case 5 -> {
                    metier.saveAll();
                    System.out.println("Clients sauvegardés.");
                }
                case 6 -> running = false;
                default -> System.out.println("Option invalide.");
            }
        }

        scanner.close();
    }
}

