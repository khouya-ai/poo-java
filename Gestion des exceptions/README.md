## Travaux Pratiques
## Titre : Gestion des exceptions
- Etudiant : **Oussama KHOUYA**
- Encadrente : **Pr. Loubna AMINOU**
- Cours : **Programmation Orientée Objet Java** 
- Date de soumission : **04-11-2024**
- Code source sur [github](https://github.com/khouya-ai/poo-java)

La gestion des exceptions est une notion très importante dans la programmation Java. Elle permet de gérer les événements inattendus qui peuvent se produire durant l'exécution d'un programme.<br>
Ce TP permet d'apprendre cette notion avec des exercices pratique: 
### Exercice 1 : TropViteException
L'exercice consiste à créer une exception `TropViteException` pour signaler une vitesse excessive. La classe `Vehicule` teste une vitesse, et si elle dépasse 90, l'exception est lancée et la pile d’appel s’affiche
1. Classe `TropViteException`  hérite de Exception et prend un entier (vitesse) comme paramètre. Elle passe un message personnalisé au super-constructeur.
   ```java
   package site.khouya.EX1;
   public class TropViteException extends Exception {
    TropViteException(int vitesse) {
        super("C'est une exception de type TropViteException. Vitesse en cause : " + vitesse);
        }
    }
   ```
2. Classe `Vehicule` a : 
   * une méthode `testVitesse(int vitesse)` qui lance une exception TropViteException si la vitesse est supérieure à 90.
   ```java
   package site.khouya.EX1;
    public void testVitesse(int vitesse) throws TropViteException {
        if (vitesse > 90) {
            throw new TropViteException(vitesse);
        }
    }
   ```
   * une méthode `main` crée un objet `Vehicule`, teste la méthode testVitesse() avec deux valeurs (80 et 100) et affiche la pile d'appel si l'exception est levée (vitesse 100).
   ```java
   public static void main(String[] args) {
        Vehicule vehicule = new Vehicule();

        try {
            // Test avec une vitesse en dessous de la limite
            vehicule.testVitesse(80);
            System.out.println("Vitesse 80 : Pas d'exception");

            // Test avec une vitesse au-dessus de la limite
            vehicule.testVitesse(100);
        } catch (TropViteException e) {
            // Affiche la pile d'appel de l'exception
            e.printStackTrace();
        }
    }
   ```

### Exemple de sortie :
```java
Vitesse 80 : Pas d'exception
site.khouya.EX1.TropViteException: C'est une exception de type TropViteException. Vitesse en cause : 100
at site.khouya.EX1.Vehicule.testVitesse(Vehicule.java:7)
at site.khouya.EX1.Vehicule.main(Vehicule.java:22)
```
---

### Exercice 2 : RacineCareeException
L'exercice consiste à créer une exception `RacineCareeException` pour signaler un entier négatif. La classe `Calculateur` teste une entier, et si il est négatif, l'exception est lancée et la pile d’appel s’affiche
1. Classe `RacineCareeException`  hérite de Exception et prend un entier comme paramètre. Elle passe un message personnalisé au super-constructeur.
   ```java
   package site.khouya.EX2;
   public class RacineCarreeException extends Exception{
    RacineCarreeException(int entier){
        super("C'est une exception de type RacineCarreeException. Nombre négatif : " + entier);
    }
   }

   ```
2. Classe `Calculateur` a :
   * une méthode `testRacineCarree(int entier)` qui lance une exception RacineCareeException si l'entier est négatif.
   ```java
   package site.khouya.EX2;
    public void testRacineCarree(int entier) throws RacineCarreeException {
        if (entier < 0) {
            throw new RacineCarreeException(entier);
        }
    }
   ```
   * une méthode `main` crée un objet `Calculateur`, teste la méthode testRacineCarree() avec deux valeurs (-5 et 25) et affiche la pile d'appel si l'exception est levée (entier -5).
   ```java
   public static void main(String[] args) {
        Calculateur calculateur = new Calculateur();

        try {
            // Test avec un entier positif
            calculateur.testRacineCarree(25);
            System.out.println("Entier 25 : Pas d'exception");

            // Test avec un entier negatif
            calculateur.testRacineCarree(-5);
        } catch (RacineCarreeException e) {
            // Affiche la pile d'appel de l'exception
            e.printStackTrace();
        }
    }
   ```

### Exemple de sortie :
```java
Entier 25 : Pas d'exception
site.khouya.EX2.RacineCarreeException: C'est une exception de type RacineCarreeException. Nombre négatif : -5
at site.khouya.EX2.Calculateur.testRacineCarree(Calculateur.java:10)
at site.khouya.EX2.Calculateur.main(Calculateur.java:23)
```
---


### Exercice 3 : NoteInvalideException
L'exercice consiste à créer une exception `NoteInvalideException` pour signaler une note non valid. La classe `Evaluateur` teste une entier, et si il n'est pas entre 0 et 20, l'exception est lancée et la pile d’appel s’affiche
1. Classe `NoteInvalideException`  hérite de Exception et prend un entier comme paramètre. Elle passe un message personnalisé au super-constructeur.
   ```java
   package site.khouya.EX3;
   
   public class NoteInvalideException extends Exception{
    public NoteInvalideException(int entier){
        super("Exception de type NoteInvalideException. Note invalide : " + entier);
        }
    }   

   ```
2. Classe `Evaluateur` a :
   * une méthode `verifierNote(int entier)` qui lance une exception NoteInvalideException si l'entier n'est pas entre 0 et 20.
   ```java
   public void verifierNote(int entier) throws Exception {
     if (entier < 0 || entier > 20) {
        throw new NoteInvalideException(entier);
     }
   }
   ```
   * une méthode `main` crée un objet `Evaluateur`, teste la méthode verifierNote() avec deux valeurs (15 et 25) et affiche la pile d'appel si l'exception est levée (entier 25).
   ```java
   public static void main(String[] args) {
    evaluateur evaluateur = new evaluateur();
        try {
            // Test avec une note valid
            evaluateur.verifierNote(15);
            System.out.println("Note 15 : Pas d'exception");

            // Test avec une note non valid
            evaluateur.verifierNote(25);
        } catch (Exception e) {
            // Affiche la pile d'appel de l'exception
            e.printStackTrace();
        }
       }
   ```

### Exemple de sortie :
```java
Note 15 : Pas d'exception
site.khouya.EX3.NoteInvalideException: Exception de type NoteInvalideException. Note invalide : 25
at site.khouya.EX3.Evaluateur.verifierNote(evaluateur.java:11)
at site.khouya.EX3.Evaluateur.main(evaluateur.java:24)
```
---