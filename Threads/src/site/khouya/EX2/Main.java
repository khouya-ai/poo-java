package site.khouya.EX2;


import java.util.Arrays;

public class Main {
    public static void main(String[] args) throws InterruptedException {
        int[] tableau = new int[10];
        for (int i = 0; i < tableau.length; i++) {
            tableau[i] = i + 1;
        }

        // Définir les tâches Sommeur
        Sommeur som1 = new Sommeur(tableau, 0, 3);
        Sommeur som2 = new Sommeur(tableau, 4, 7);
        Sommeur som3 = new Sommeur(tableau, 7, 9);

        System.out.println("Tableau : " + Arrays.toString(tableau));

        // Créer et démarrer les threads
        Thread t1 = new Thread(som1);
        Thread t2 = new Thread(som2);
        Thread t3 = new Thread(som3);

        t1.start();
        t2.start();
        t3.start();

        // S'assurer que les threads terminent avant d'accéder aux résultats
        t1.join();
        t2.join();
        t3.join();

        // Afficher les sommes individuelles
        System.out.println("Somme 1 : " + som1.getSomme());
        System.out.println("Somme 2 : " + som2.getSomme());
        System.out.println("Somme 3 : " + som3.getSomme());

        // Calculer et afficher la somme totale
        int totalSum = som1.getSomme() + som2.getSomme() + som3.getSomme();
        System.out.println("Somme totale : " + totalSum);
    }



}