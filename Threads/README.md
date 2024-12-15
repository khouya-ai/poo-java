## Travaux Pratiques
## Titre : Les Threads
- Etudiant : **Oussama KHOUYA**
- Encadrente : **Pr. Loubna AMINOU**
- Cours : **Programmation Orientée Objet Java** 
- Date de soumission : **15-12-2024**
- Code source sur [github](https://github.com/khouya-ai/poo-java)


Ce projet illustre les bases du multithreading en Java avec deux exercices : l’un sur la création de threads et l’autre sur les calculs parallèles, en utilisant l’interface `Runnable`.
### Exercice 1: 
Dans cet exercice, nous créons une classe `Talkative` qui affiche un identifiant unique 100 fois. Plusieurs threads sont instanciés pour observer l'exécution concurrente.
1. **Définition de la classe :** La classe `Talkative` implémente l'interface `Runnable`, ce qui lui permet de définir une méthode `run` pour l'exécution des threads.
2. **Création des threads :** Dix instances de `Thread` sont créées, chacune encapsulant une instance de `Talkative` avec un entier unique.
3. **Exécution des threads :** En utilisant la méthode `start`, les threads s'exécutent, illustrant un ordre d'exécution non déterministe.
### Code source :
```java
public class Talkative implements Runnable {
   int val;

   public Talkative(int val) {
      this.val = val;
   }

   @Override
   public void run() {
      for (int i = 1; i <= 100; i++) {
         System.out.println(val);
      }
   }
}

public class Main {
   public static void main(String[] args) {
      for (int i = 1; i <= 10; i++) {
         new Thread(new Talkative(i)).start();
      }
   }
}
```
---

## Exercice 2: Addition d'un tableau en utilisant un pool de threads
Cet exercice calcule la somme d'un tableau en parallèle en utilisant un pool de threads. Il divise le tableau en segments, attribue chaque segment à un thread, puis combine les résultats pour obtenir la somme totale.
1. **Définition de la classe** : La classe `Sommeur` implémente `Runnable` pour calculer la somme d'une plage spécifique dans un tableau.
2. **Exécution parallèle** : Un pool de threads calcule les sommes pour différents segments du tableau de manière concurrente. 
3. **Sommer les résultats** : Après l'exécution des threads, leurs résultats sont combinés pour déterminer la somme totale.
### Code source :
```java
class Sommeur implements Runnable {
   private int[] tableau;
   private int debut;
   private int fin;
   private int somme;

   public Sommeur(int[] tableau, int debut, int fin) {
      this.tableau = tableau;
      this.debut = debut;
      this.fin = fin;
      this.somme = 0;
   }

   public int getSomme() {
      return somme;
   }

   @Override
   public void run() {
      for (int i=debut; i<=fin; i++)
      {
         somme+=tableau[i];
      }
   }
}

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
```
---

En conclusion, ce projet démontre l'efficacité du multithreading en Java pour améliorer les performances et exploiter les ressources système.