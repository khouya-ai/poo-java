## Assignments 01
## Title: Arrays and Strings
- Student: **Oussama KHOUYA**
- Supervisor: **Prof. Loubna AMINOU**
- Course: **Object-Oriented Programming in Java**
- Submission Date: **26-10-2024**

### EX1: Managing Students' Grades
The program allows the user to enter the grades of a certain number of students and perform several operations on these grades, such as sorting them, calculating the average, finding the maximum and minimum grades, and counting how many students received a particular grade.
0. **Entering Grades**: The user inputs the number of students and the corresponding grades.
```java
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
```
1. **Sort and Display the List of Grades**: The program uses `Arrays.sort()` to sort the array of grades in ascending order.
```java 
// 1. Trier et afficher la liste des notes
Arrays.sort(notes);
System.out.println("Liste des notes triées : " + Arrays.toString(notes));
```
2. **Calculate and Display the Average Grade** : The average of the grades is calculated and displayed.
```java 
// 2. Calculer et afficher la note moyenne
double somme = 0;
for (double note : notes) {
    somme += note;
}
double moyenne = somme / nombreEtudiants;
System.out.println("La note moyenne est : " + moyenne);
```
3. **Display the Maximum and Minimum Grades**: The program displays the maximum and minimum grades after sorting the grades.
```java 
// 3. Afficher la note maximale et minimale
double noteMaximale = notes[nombreEtudiants - 1];
double noteMinimale = notes[0];
System.out.println("La note maximale est : " + noteMaximale);
System.out.println("La note minimale est : " + noteMinimale);
```
4. **Display the Number of Students with a Specific Grade** : The user enters a grade, and the program counts how many students received that grade.
```java
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

```
### Code source :
```java
import java.util.Arrays;
import java.util.Scanner;

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
```

### Exemple de sortie :
```java
Entrez le nombre d'étudiants : 5
Entrez la note de l'étudiant 1 : 12
Entrez la note de l'étudiant 2 : 14
Entrez la note de l'étudiant 3 : 10
Entrez la note de l'étudiant 4 : 16
Entrez la note de l'étudiant 5 : 18

Liste des notes triées : [10.0, 12.0, 14.0, 16.0, 18.0]
La note moyenne est : 14.0
La note maximale est : 18.0
La note minimale est : 10.0

Entrez une note pour voir combien d'étudiants l'ont obtenue : 14
Nombre d'étudiants ayant obtenu la note 14.0 : 1
```
---

### EX2 : Conjugaison d'un Verbe du Premier Groupe
Le programme permet à l'utilisateur de saisir un verbe du premier groupe et de conjuguer ce verbe au présent de l'indicatif. Il vérifie si le verbe appartient bien au premier groupe, et gère une exception pour la première personne du pluriel en fonction de la terminaison du radical.
1. **Saisie du verbe** : L'utilisateur est invité à entrer un verbe du premier groupe.
   ```java
   // Saisie du verbe
    System.out.print("Entrez un verbe du premier groupe : ");
    String verbe = scanner.nextLine().trim();
   ```
2. **Vérification de la terminaison** : Le programme vérifie si le verbe se termine par "er".
   ```java
   if (verbe.endsWith("er") && verbe.length() > 2) 
   ```
3. **Conjugaison** : Si le verbe est valide, il est conjugué au présent de l'indicatif pour toutes les personnes, en tenant compte d'une exception pour "nous" si le radical se termine par "g".
    ```java
    String radicale = verbe.substring(0, verbe.length() - 2);

    // Vérifier si le radical se termine par "g" (exception pour la conjugaison avec "nous")
    String conjugaisonNous = radicale.endsWith("g") ? "nous %seons" : "nous %sons";

    // Modèle de conjugaison avec insertion du radical
    String conjugaison = String.format(
            "je %se\n" +
                    "tu %ses\n" +
                    "il/elle/on %se\n" +
                    conjugaisonNous + "\n" +
                    "vous %sez\n" +
                    "ils/elles %sent",
            radicale, radicale, radicale, radicale, radicale, radicale
    );
   ```
4. **Affichage du résultat** : La conjugaison complète est affichée à l'utilisateur.

### Code source :
```java
import java.util.Scanner;

public class EX2 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Saisie du verbe
        System.out.print("Entrez un verbe du premier groupe : ");
        String verbe = scanner.nextLine().trim();

        // Vérification si c'est un verbe du premier groupe (se terminant par "er")
        if (verbe.endsWith("er") && verbe.length() > 2) {
            String radicale = verbe.substring(0, verbe.length() - 2);

            // Vérifier si le radical se termine par "g" (exception pour la conjugaison avec "nous")
            String conjugaisonNous = radicale.endsWith("g") ? "nous %seons" : "nous %sons";

            // Modèle de conjugaison avec insertion du radical
            String conjugaison = String.format(
                    "je %se\n" +
                            "tu %ses\n" +
                            "il/elle/on %se\n" +
                            conjugaisonNous + "\n" +
                            "vous %sez\n" +
                            "ils/elles %sent",
                    radicale, radicale, radicale, radicale, radicale, radicale
            );

            // Afficher la conjugaison complète
            System.out.println(conjugaison);
        } else {
            System.out.println("Ce mot n'est pas un verbe du premier groupe !");
        }

        scanner.close();
    }
}


```
### Exemple de sortie :
```java
Entrez un verbe du premier groupe : gagner
je gagne
tu gagnes
il/elle/on gagne
nous gagnons
vous gagnez
ils/elles gagnent
```
---
### EX3 : Gestion de Chaînes de Caractères
Le programme permet à l'utilisateur d'effectuer plusieurs opérations sur une chaîne de caractères saisie au clavier. Les opérations incluent la saisie, l'affichage, l'inversion de la chaîne, et le comptage du nombre de mots.

Le programme présente un menu contenant quatre options :
1. **Saisir** : L'utilisateur peut entrer une chaîne de caractères, qui est ensuite stockée dans la variable chaine.
2. **Afficher** : Cette option affiche la chaîne actuellement stockée.
3. **Inverser** : Inverse la chaîne saisie et affiche le résultat. On déclare `chaine` comme un objet `StringBuilder` pour profiter de la methode `reverse()`
    ```java
   // Inverser la chaîne saisie
    System.out.println("L'inverse de chaine saisie: " + chaine.reverse());
   ```
4. **Nombre de mots** : Compte et affiche le nombre de mots dans la chaîne, en considérant les espaces comme séparateurs. On utilise l'expression régulière `\\s+` pour inclure un ou plusieurs espaces dans la division.
    ```java
    // Nombre de mots
    int nbr = chaine.toString().split("\\s+").length;
    System.out.println("Le nombre de mots: " + nbr);
   ```
### Code source
```java
package site.khouya;

import java.util.Scanner;

public class EX3 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int choix;
        StringBuilder chaine = new StringBuilder();
        boolean quit;
        do {
            System.out.println(
                    """
            ******************************************** Menu *****************                
            1. saisir : lire une chaîne de caractères à partir du clavier et 
                la stocker dans une variable.
            2. afficher : afficher la chaîne saisie.
            3. inverser : inverser la chaîne saisie.
            4. Nombre de mots : compter le nombre de mots de la chaîne.
                On considère le caractère ‘ ’ (blanc) comme le caractère séparateur
                de mots. Il peut y avoir plusieurs blancs consécutifs dans la chaîne.
            ***********************************************************************""");
            System.out.print("choisir une opération à effectuer (1, 2, 3 ou 4) :");
            choix = scanner.nextInt();
            // pour consommer le retour à la ligne restante Après l'utilisation de Scanner.nextInt()
            scanner.nextLine(); 
            switch (choix) {
                case 1:
                    // Saisie de chaine
                    System.out.print("Entrez une chaine de caractères quelconque : ");
                    chaine = new StringBuilder(scanner.nextLine().trim());
                    break;
                case 2:
                    // Afficher la chaine saisie
                    System.out.println("la chaine saisie: " + chaine);
                    break;
                case 3:
                    // Inverser la chaîne saisie
                    System.out.println("L'inverse de chaine saisie: " + chaine.reverse());
                    break;
                case 4:
                    // Nombre de mots
                    int nbr = chaine.toString().split("\\s+").length;
                    System.out.println("Le nombre de mots: " + nbr);
                    break;
                default:
                    System.out.println("Choix invalide. Veuillez réessayer.");
                    break;

            }
            // tapper la lettre q pour quitter
            quit = false;
            System.out.println("Frappez une touche pour revenir au menu (q pour quitter)");
            if (scanner.nextLine().trim().equals("q")) {
                quit = true;
            }

        } while (!quit);

        scanner.close();
    }
}


```

### EX4 : Comptage des Occurrences de Lettres
Le programme permet à l'utilisateur de compter les occurrences des lettres de l'alphabet dans une chaîne de caractères, sans tenir compte de la casse (majuscules/minuscules). L'utilisateur entre une ligne de texte, et le programme affiche le nombre d'occurrences de chaque lettre présente dans le texte. Les lettres qui n'apparaissent pas ne sont pas affichées.
1. **Saisie de la chaîne de caractères** :
   Le programme commence par demander à l'utilisateur de saisir une ligne de texte, avec une longueur maximale de 100 caractères. Cette chaîne est ensuite stockée dans la variable text.

2. **Initialisation** :
   Un tableau nb_occurrences de taille 26 est utilisé pour stocker le nombre d'occurrences des lettres de l'alphabet (A-Z). Le programme initialise aussi une chaîne de référence AZ qui contient toutes les lettres majuscules de l'alphabet pour faciliter la correspondance.

3. **Comptage des occurrences** :
   Le programme parcourt chaque lettre de l'alphabet (contenue dans AZ), puis vérifie la présence de cette lettre dans la chaîne de caractères saisie (text).
   Pour chaque occurrence d'une lettre dans text, le compteur correspondant dans le tableau nb_occurrences est incrémenté.
4. **Affichage des résultats** :
   Le programme parcourt ensuite le tableau nb_occurrences et affiche le nombre d'occurrences pour chaque lettre qui est apparue au moins une fois dans le texte.
### Code source
```java
import java.util.Scanner;

public class EX4 {
    public static void main(String[] args) {
        //Saisie de la chaine
        System.out.print("Entrez une ligne de texte (max. 100 caractères) : ");
        String text = new Scanner(System.in).nextLine().trim();

        // Compte les occurrences des lettres dans 'text'
        String AZ = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";
        int[] nb_occurrences = new int[26];
        for (int i = 0; i < 26; i++) {
            char c = AZ.charAt(i);
            // compter l'ocurrence de lettre 'c' dans 'text'
            for (int j = 0; j < text.length(); j++) {
                if(text.charAt(j) == c) {
                    nb_occurrences[i]++;
                }
            }
        }
        // Afficher les résultats
        System.out.printf("La chaine \"%s\" contient : \n",text);
        for (int i = 0; i < 26; i++) {
            if(nb_occurrences[i] != 0) {
                System.out.printf("%d fois la lettre '%s'\n", nb_occurrences[i], AZ.charAt(i));
            }
        }

    }
}

```

### Exemple de sortie :
```java
Entrez une ligne de texte (max. 100 caractères) : Jeanne
La chaîne "JEANNE" contient :
1 fois la lettre 'A'
2 fois la lettre 'E'
1 fois la lettre 'J'
3 fois la lettre 'N'

```