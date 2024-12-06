## Travaux Pratiques
## Titre : Généricité et Gestion des fichiers
- Etudiant : **Oussama KHOUYA**
- Encadrente : **Pr. Loubna AMINOU**
- Cours : **Programmation Orientée Objet Java** 
- Date de soumission : **06-12-2024**
- Code source sur [github](https://github.com/khouya-ai/poo-java)

La généricité et la gestion des fichiers sont des notions très importante dans la programmation Java. Elles permettent d'écrire du code réutilisable en assurant leur persistance.<br>
Ce TP permet d'apprendre ces notions avec des exercices pratiques: 
### Exercice 1 : la commande «ls» en Java
L'exercice consiste à créer un programme java permettant de simuler la commande «ls»:
   ```java
static int level = 0; // Niveau actuel de l'indentation

public static void main(String[] args) {
   // Définir le dossier à parcourir
   Scanner scanner = new Scanner(System.in);
   System.out.print("Définir le dossier à parcourir : ");
   String path = scanner.nextLine().trim();
   File folder = new File(path);
   listFilesInFolder(folder); // Appel de la méthode recursive pour lister les fichiers
}

static void listFilesInFolder(File folder) {
   // Liste des fichiers et dossiers dans le répertoire
   File[] listOfFiles = folder.listFiles();
   if (listOfFiles != null) {
      for (File file : listOfFiles) {
         // Chemin absolu du fichier/dossier
         String absolutePath = file.getAbsolutePath();
         // Déterminer si c'est un dossier (DIR) ou un fichier (FICH)
         String type = (file.isDirectory() ? "DIR" : "FICH");
         // Déterminer les permissions : lecture (r), écriture (w), caché (h)
         String mode = String.format("%s%s%s",
                 file.canRead() ? "r" : "-",
                 file.canWrite() ? "w" : "-",
                 file.isHidden() ? "h" : "-");
         // Afficher les informations avec l'indentation appropriée
         System.out.printf("%s %s <%s> %s \n", "\t".repeat(level), absolutePath, type, mode);
         // Si c'est un dossier, parcourir récursivement
         if (file.isDirectory()) {
            level++; // Augmenter le niveau d'indentation
            listFilesInFolder(file);  // Appel récursif
            level--; // Diminuer le niveau après le retour de la récursion
         }
      }
   }

}
   ```

### Exemple de sortie :
```text
Définir le dossier à parcourir : D:\TP6
 D:\TP6\.gitignore <FICH> rwh 
 D:\TP6\clients.dat <FICH> rw- 
 D:\TP6\contacts <DIR> rw- 
	 D:\TP6\contacts\ahmed.txt <FICH> rw- 
	 D:\TP6\contacts\Ismail.txt <FICH> rw- 
	 D:\TP6\contacts\oussama.txt <FICH> rw- 
	 D:\TP6\contacts\rachid.txt <FICH> rw- 
 D:\TP6\README.md <FICH> rw- 
 D:\TP6\src <DIR> rw- 
	 D:\TP6\src\site <DIR> rw- 
		 D:\TP6\src\site\khouya <DIR> rw- 
			 D:\TP6\src\site\khouya\EX1 <DIR> rw- 
				 D:\TP6\src\site\khouya\EX1\Main.java <FICH> rw- 
			 D:\TP6\src\site\khouya\EX2 <DIR> rw- 
				 D:\TP6\src\site\khouya\EX2\DossierContact.java <FICH> rw- 
				 D:\TP6\src\site\khouya\EX2\Main.java <FICH> rw- 
			 D:\TP6\src\site\khouya\EX3 <DIR> rw- 
				 D:\TP6\src\site\khouya\EX3\Client.java <FICH> rw- 
				 D:\TP6\src\site\khouya\EX3\IMetier.java <FICH> rw- 
				 D:\TP6\src\site\khouya\EX3\MainClient.java <FICH> rw- 
				 D:\TP6\src\site\khouya\EX3\MainProduit.java <FICH> rw- 
				 D:\TP6\src\site\khouya\EX3\MetierClientImpl.java <FICH> rw- 
				 D:\TP6\src\site\khouya\EX3\MetierProduitImpl.java <FICH> rw- 
				 D:\TP6\src\site\khouya\EX3\Produit.java <FICH> rw- 

```
---

### Exercice 2 : L'annuaire téléphonique
L'exercice consiste à créer un programme d'annuaire téléphonique qui conserve la liste de noms et de numéros de téléphone des contacts dans des fichiers.
1. La première méthode la plus importante dans ce programme est la methode qui permet de charger les contacts de dossier `contacts` est `chargerContacts`
   ```java
    private void chargerContacts() throws IOException {
         // Initialise la variable "contacts" comme une nouvelle HashMap pour stocker les noms et numéros.
         contacts = new HashMap<>();

        // Crée une référence au dossier contenant les fichiers de contacts.
        File dossier = new File("contacts");
        FileReader fr;

        // Vérifie si le dossier "contacts" existe.
        if (dossier.exists()) {
            // Récupère tous les fichiers contenus dans le dossier.
            File[] listOfContacts = dossier.listFiles();

            // Vérifie que la liste des fichiers n'est pas nulle.
            if (listOfContacts != null) {
                // Parcourt chaque fichier dans le dossier.
                for (File contact : listOfContacts) {
                    // Récupère le nom du fichier sans l'extension ".txt".
                    String nom = contact.getName().replace(".txt", "");

                    // Crée un tableau de caractères pour lire le contenu du fichier (25 caractères maximum).
                    char[] charArray = new char[25];

                    // Crée un FileReader pour lire le fichier actuel.
                    fr = new FileReader(String.format("contacts/%s.txt", nom));

                    // Lit les caractères du fichier dans le tableau "charArray".
                    fr.read(charArray);

                    // Convertit le tableau de caractères en chaîne de caractères (String).
                    String numero = new String(charArray);

                    // Ajoute l'entrée (nom, numéro) dans la HashMap, en supprimant les espaces inutiles.
                    contacts.put(nom.trim(), numero.trim());
                }
            }
        }
    }
    

   ```

2. La deuxième méthode la plus importante dans ce programme est la methode qui permet de sauvegarder les contacts de dossier `contacts` est `sauvegarderContacts` 
   ```java
   
   void sauvegarderContact(String nom, String numero) throws IOException {
        // Crée un FileWriter pour écrire dans un fichier nommé "nom.txt" dans le dossier "contacts".
        FileWriter fw = new FileWriter(String.format("contacts/%s.txt", nom));

        // Parcourt chaque caractère du numéro de téléphone et l'écrit dans le fichier.
        for (int i = 0; i < numero.length(); i++)
            fw.write(numero.charAt(i));

        // Ferme le FileWriter pour libérer les ressources.
        fw.close();

        // Ajoute ou met à jour l'entrée (nom, numéro) dans la HashMap "contacts".
        contacts.put(nom.trim(), numero.trim());
    }


    void sauvegarderContacts() throws IOException {
        // Parcourt chaque entrée (nom, numéro) de la HashMap "contacts".
        for (Map.Entry<String, String> entry : contacts.entrySet()) {
            // Sauvegarde chaque contact individuel en appelant la méthode "sauvegarderContact".
            sauvegarderContact(entry.getKey(), entry.getValue());
        }
    }

   ```

### Exemple de sortie :
```txt
******************************************** Menu *****************
1. Rechercher un numéro de téléphone.
2. Ajouter un nouveau contact.
3. Supprimer un contact.
4. Changer le numéro de téléphone d’un contact.
***********************************************************************
choisir une opération à effectuer (1, 2, 3 ou 4) :1
Entrez un nom  : oussama
0612345678
Frappez une touche pour revenir au menu (5 pour sauvegarder et quitter)
```
---


### Exercice 3 : sauvegarder et lire une collection d'objets
L'exercice consiste à créer une application pour sauvegarder et lire des listes d'objets produits et clients dans des fichiers *.dat.
1.  la methode `loadFromFile` permet de charger la liste des clients (produits) du fichier .dat
   ```java
    private void loadFromFile() {
   // Crée un objet File pour représenter le fichier.
   File file = new File(fileName);

   // Si le fichier n'existe pas, on quitte la méthode (aucune donnée à charger).
   if (!file.exists()) return;

   // Bloc try-with-resources pour gérer automatiquement la fermeture des flux.
   try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream(file))) {
      // Lit et désérialise l'objet depuis le fichier.
      // On suppose que le fichier contient une liste de clients.
      clients = (List<Client>) ois.readObject();
   } catch (IOException | ClassNotFoundException e) {
      // Capture et affiche les erreurs liées à la lecture ou à la désérialisation.
      e.printStackTrace();
   }
}
    

   ```

2. la methode `saveAll` permet de sauvegarder la liste des clients (produits) dans le fichier .dat
   ```java
    private void loadFromFile() {
        // Crée un objet File pour représenter le fichier.
        File file = new File(fileName);

        // Si le fichier n'existe pas, on quitte la méthode (aucune donnée à charger).
        if (!file.exists()) return;

        // Bloc try-with-resources pour gérer automatiquement la fermeture des flux.
        try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream(file))) {
            // Lit et désérialise l'objet depuis le fichier.
            // On suppose que le fichier contient une liste de clients.
            clients = (List<Client>) ois.readObject();
        } catch (IOException | ClassNotFoundException e) {
            // Capture et affiche les erreurs liées à la lecture ou à la désérialisation.
            e.printStackTrace();
        }
    }

   ```

### Exemple de sortie :
```txt
1. Afficher la liste des clients
2. Rechercher un client par son nom
3. Ajouter un nouveau client
4. Supprimer un client par nom
5. Sauvegarder les clients
6. Quitter
Choisissez une option : 3
Nom : Ali
Prénom : Samir
Adresse : Sale
Téléphone : 0666666
Email : g@gmail.com

1. Afficher la liste des clients
2. Rechercher un client par son nom
3. Ajouter un nouveau client
4. Supprimer un client par nom
5. Sauvegarder les clients
6. Quitter
Choisissez une option : 1
Client{nom='ahmed', prenom='khalid', adresse='A30 rue nada El Qods Sale', tel='066666', email='email@gmail.com'}
Client{nom='Ali', prenom='Samir', adresse='Sale', tel='0666666', email='g@gmail.com'}
```
---

En conclusion, ce TP a permis de mettre en pratique les concepts fondamentaux de la généricité (Exercice 3) et de la gestion des fichiers (Exercice 1 et 2) en Java 