## Travaux Pratiques :  Collection et Stream
- Etudiant : **Oussama KHOUYA**
- Encadrente : **Pr. Loubna AMINOU**
- Cours : **Programmation Orientée Objet Java** 
- Date de soumission : **17-11-2024**
- Code source sur [github](https://github.com/khouya-ai/poo-java)


## Collection
Les collections en Java sont des structures de données dynamiques permettant de stocker et de manipuler des ensembles d'objets. les trois exercices suivants permet de mieux comprendre le fonctionnement des List, Map, Set. 
### Exercice 1 : Les listes
L'exercice consiste à créer une simple application pour manipuler une liste d’objets de type produit.
1. Classe `Produit`  prend id, nom, prix comme paramètres.
   ```java
   public class Produit {
    private long id;
    private String nom;
    private double prix;
   }
   ```
2. Classe `GestionProduitsApp` contient la methode `main` qui permet de: 
   * Ajouter des produits:
   ```java
   // Création de la liste de produits
        ArrayList<Produit> produits = new ArrayList<>();

        // Ajout de produits
        produits.add(new Produit(1, "Produit1", 100.0));
        produits.add(new Produit(2, "Produit2", 200.0));
        produits.add(new Produit(3, "Produit3", 150.0));
   ```
   * Supprimer un produit par indice:
   ```java
   // Suppression d'un produit par indice
        produits.remove(1);
   ```
   * Modifier un produit par indice.:
   ```java
   // Modification d'un produit par indice
        Produit produitModifie = produits.get(0);
        produitModifie.setNom("ProduitModifie");
        produitModifie.setPrix(120.0);
   ```
### Exercice 2 : Les Maps
L'exercice consiste à créer un Hashmap qui stocke les notes des étudiants et les methodes pour les manipuler.
1. Créer un map qde type Hashmap
   ```java
   Map<String, Double> qde = new HashMap<>();
   ```
2. Insérer des notes des étudiants.
   ```java
     qde.put("Ahmed", 17.0);
     qde.put("Samira", 15.0);
     qde.put("Ali", 16.0);
     qde.put("Khalid", 20.0);
   ```
3. Augmenter la note d’un étudiant.
   ```java
    qde.put("Ahmed", qde.get("Ahmed") + 1);
   ```
4. Supprimer la note d’un étudiant.
   ```java
    qde.remove("Ahmed");
   ```
5. Afficher la taille du map.
   ```java
   System.out.printf("\nLa taille du map : %d", qde.size());
   ```
6. Afficher la note moyenne, max et min.
   ```java
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
   ```
7. Vérifier s’il y a une note égale à 20.
   ```java
   boolean aNoteEgaleVingt = qde.containsValue(20.0);
     System.out.println("\n\nY a-t-il une note égale à 20 ? " + (aNoteEgaleVingt ? "Oui" : "Non"));
   ```
8. Afficher la liste en utilisant la boucle forEach avec l’expression lambda.
   ```java
   afficherProduits(qde);
   public static void afficherProduits(Map<String, Double> map1) {
        //afficher les valeurs avec foreach et l'expression l'ambda
        map1.forEach((v,w) -> System.out.println("("+ v + ", "+ w +")"));
    }
   ```
### Exercice 3 : Les Sets
L'exercice consiste à créer deux objets de type HashSet et de calculer leurs interdections et unions.
1. Créer deux Sets de type HashSet nommées groupeA et groupeB, contenant les nom des étudiants des deux groupes A et B.
   ```java
   Set<String> groupeA = new HashSet<>();
   Set<String> groupeB = new HashSet<>();
   ```
2. Ajouter des noms des étudiants à chaque HashSet.
   ```java
   groupeA.add("Ahmed");
   groupeA.add("Samir");
   groupeA.add("Ali");
   groupeA.add("Sami");
   
   groupeB.add("Samira");
   groupeB.add("Hind");
   groupeB.add("Rim");
   groupeB.add("Hassna");
   ```
3. Afficher l’intersection des deux HashSets.
   ```java
     Set<String> intersection = new HashSet<>(groupeA);
     intersection.retainAll(groupeB);
     System.out.println("\nIntersection des deux groupes : " + intersection);
   ```
4. Afficher l’union des deux HashSets.
   ```java
   Set<String> union = new HashSet<>(groupeA);
   union.addAll(groupeB);
   System.out.println("\nUnion des deux groupes : " + union);
   ```
## Stream
Un Stream est une séquence d'éléments qui prend en charge diverses opérations, comme filter, map, et reduce. Ces opérations peuvent être exécutées en mode séquentiel ou parallèle, ce qui rend les streams particulièrement utiles.
### Exercice 1 :
L'exercice consiste à créer une simple application pour effectuer des opérations sur une liste de mots en utilisant les Streams.
1. Filtrer les mots qui contiennent la lettre "a".
   ```java
     List<String> mots = Arrays.asList("pomme", "banane", "cerise", "date", "figue", "raisin");

     List<String> contientA = mots.stream()
             .filter(mot -> mot.contains("a"))
             .toList();
     System.out.println("Mots contenant 'a' : " + contientA);
   ```
2. Filtrer les mots qui ont une longueur supérieure à 3 et transformer chaque mot en son inverse.
   ```java
        List<String> motsInverses = mots.stream()
                .filter(mot -> mot.length() > 3)
                .map(mot -> new StringBuilder(mot).reverse().toString())
                .toList();
        System.out.println("Mots inversés de longueur > 3 : " + motsInverses);
   ```
3. Filtrer les chaînes qui contiennent la lettre "e" et aplatir chaque chaîne en une liste de ses caractères.
   ```java
        List<Character> caracteresAvecE = mots.stream()
                .filter(mot -> mot.contains("e"))
                .flatMap(mot -> mot.chars().mapToObj(c -> (char) c))
                .toList();
        System.out.println("Caractères de mots contenant 'e' : " + caracteresAvecE);
   ```
4. Transformer chaque chaîne en sa version en majuscules.
   ```java
        List<String> motsMajuscules = mots.stream()
                .map(String::toUpperCase)
                .toList();
        System.out.println("Mots en majuscules : " + motsMajuscules);
   ```
5. Convertir chaque chaîne en sa longueur.
   ```java
     List<Integer> longueursMots = mots.stream()
                .map(String::length)
                .toList();
        System.out.println("Longueurs des mots : " + longueursMots);
   ```
6. Transformer chaque chaîne en une liste de ses caractères, puis aplatir toutes les listes en une seule liste de caractères.
   ```java
    List<Character> tousCaracteres = mots.stream()
                .flatMap(mot -> mot.chars().mapToObj(c -> (char) c))
                .toList();
        System.out.println("Liste aplatie de tous les caractères : " + tousCaracteres);
   ```
7. À partir d'une liste de mots, transformer chaque nom en une chaîne de la forme "Nom - Index" où l'index représente la position du nom dans la liste.
   ```java
   List<String> motsAvecIndex = IntStream.range(0, mots.size())
                .mapToObj(i -> mots.get(i) + " - " + i)
                .toList();
        System.out.println("Mots avec index : " + motsAvecIndex);
   ```
### Exercice 1 :
L'exercice consiste à créer une simple application pour crée une liste d'employés dans une ArrayList et effectue les opérations demandées.
1. Calculer la somme totale des salaires de tous les employés
   ```java
   double sommeSalaires = employes.stream()
                .mapToDouble(Employe::getSalaire)
                .sum();
        System.out.println("Somme totale des salaires : " + sommeSalaires);
   ```
2. Trier la liste des employés par ordre alphabétique du nom
   ```java
        List<Employe> employesTries = employes.stream()
                .sorted(Comparator.comparing(Employe::getNom))
                .toList();
        System.out.println("Employés triés par nom : " + employesTries);
   ```
3. Trouver l'employé avec le salaire le plus bas
   ```java
        Optional<Employe> employeSalaireMin = employes.stream()
                .min(Comparator.comparing(Employe::getSalaire));
        employeSalaireMin.ifPresent(e -> System.out.println("Employé avec le salaire le plus bas : " + e));
   ```
4. Obtenir la liste des employés ayant un salaire supérieur à une valeur donnée (ex : 4500)
   ```java
        double valeurDonnee = 4500;
        List<Employe> employesSalaireSuperieur = employes.stream()
                .filter(e -> e.getSalaire() > valeurDonnee)
                .toList();
        System.out.println("Employés avec un salaire supérieur à " + valeurDonnee + " : " + employesSalaireSuperieur);
   ```
5. Trouver l'employé avec le salaire le plus élevé
   ```java
        Optional<Employe> employeSalaireMax = employes.stream()
                .reduce((e1, e2) -> e1.getSalaire() > e2.getSalaire() ? e1 : e2);
        employeSalaireMax.ifPresent(e -> System.out.println("Employé avec le salaire le plus élevé : " + e));
   ```
6. Concaténer les noms de tous les employés
   ```java
        String nomsConcatenes = employes.stream()
                .map(Employe::getNom)
                .reduce((nom1, nom2) -> nom1 + ", " + nom2)
                .orElse("");
        System.out.println("Noms concaténés des employés : " + nomsConcatenes);
   ```
   

