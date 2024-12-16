## Travaux Pratiques
## Titre : Programmation réseau avec les sockets
- Etudiant : **Oussama KHOUYA**
- Encadrente : **Pr. Loubna AMINOU**
- Cours : **Programmation Orientée Objet Java** 
- Date de soumission : **16-12-2024**
- Code source sur [github](https://github.com/khouya-ai/poo-java)


Ce travail illustre les bases de la programmation réseau avec les sockets en Java à travers deux exercices : dans lesquels on implémente la communication client-serveur, gère les échanges de données en réseau et intègre le multi-threading pour prendre en charge plusieurs connexions simultanées.
### Exercice 1: Nombre magique
Dans cet exercice, on développe un jeu utilisant des sockets où les joueurs tentent de deviner un nombre magique. Le serveur génère un nombre magique aléatoire, et les joueurs essaient de le deviner en recevant des indices (au-dessus ou en dessous).
1. **Programme Serveur**: Le serveur :
   - Génère un nombre magique aléatoire entre 0 et 100.
   - Attend la connexion d'un joueur.
   - nvoie des indices au joueur après chaque tentative (c'est plus / c'est moins).
2. **Programme Client**: Le client :
    - Se connecte au serveur
    - Envoie des tentatives au serveur.
    - Affiche les indices reçus pour ajuster ses prochaines tentatives.
### Code source : Serveur
```java
public class Server {
   public static void main(String[] args) {
      try (ServerSocket serverSocket = new ServerSocket(123)) {
         out.println("Serveur démarré sur le port 123.");

         // Générer un nombre magique aléatoire entre 0 et 100
         int magicNumber = (int) (Math.random() * 100);
         out.println("Nombre magique généré : " + magicNumber);

         while (true) {
            out.println("En attente d'un joueur...");
            Socket socket = serverSocket.accept();
            out.println("Joueur connecté.");

            try  {
               InputStreamReader isr = new InputStreamReader(socket.getInputStream());
               BufferedReader br = new BufferedReader(isr);
               PrintWriter out = new PrintWriter(socket.getOutputStream(), true);

               out.println("Bienvenue au jeu ! Essayez de deviner le nombre entre 0 et 100.");

               boolean win = false;

               while (!win) {
                  // Lire la tentative du joueur
                  String input = br.readLine();
                  if (input == null) {
                     break;
                  }

                  try {
                     int guess = Integer.parseInt(input);

                     if (guess < magicNumber) {
                        out.println("C'est plus !");
                     } else if (guess > magicNumber) {
                        out.println("C'est moins !");
                     } else {
                        out.println("Félicitations ! Vous avez trouvé le nombre magique : " + magicNumber);
                        win = true;
                     }
                  } catch (NumberFormatException e) {
                     out.println("Veuillez entrer un nombre valide !");
                  }
               }

               out.println("Le joueur a terminé la partie.");
            } catch (IOException e) {
               System.err.println("Erreur de communication avec le joueur : " + e.getMessage());
            }
         }
      } catch (IOException e) {
         System.err.println("Erreur serveur : " + e.getMessage());
      }
   }
}

```
### Code source : Client
```java
public class Client {
    public static void main(String[] args) {
        try (Socket socket = new Socket("localhost", 123);
             BufferedReader br = new BufferedReader(new InputStreamReader(socket.getInputStream()));
             PrintWriter out = new PrintWriter(socket.getOutputStream(), true);
             Scanner scanner = new Scanner(System.in)) {

            System.out.println("Connecté au serveur du jeu.");

            // Lire les messages du serveur
            String message;
            while ((message = br.readLine()) != null) {
                System.out.println("Serveur : " + message);

                // Si le joueur a gagné, quitter la boucle
                if (message.startsWith("Félicitations")) {
                    break;
                }
                // Entrer une tentative
                System.out.print("Votre tentative : ");
                String guess = scanner.nextLine();
                out.println(guess);
            }
        } catch (IOException e) {
            System.err.println("Erreur client : " + e.getMessage());
        }
    }
}
````
### Sorties des programmes
```txt
*** Serveur ***
Serveur démarré sur le port 123.
Nombre magique généré : 11
En attente d'un joueur...
Joueur connecté.
En attente d'un joueur...
Joueur connecté.

*** Client 1 ***
Connecté au serveur du jeu.
Serveur : Bienvenue au jeu ! Essayez de deviner le nombre entre 0 et 100.
Votre tentative : 5
Serveur : C'est plus !
Votre tentative : 10
Serveur : C'est plus !
Votre tentative : 11
Serveur : Félicitations ! Vous avez trouvé le nombre magique : 11

*** Client 2 ***
Connecté au serveur du jeu.
Serveur : Bienvenue au jeu ! Essayez de deviner le nombre entre 0 et 100.
Votre tentative : 11
Serveur : Félicitations ! Vous avez trouvé le nombre magique : 11
```
### Observation 

Ce programme n'autorise plusieurs joueurs à se connecter simultanément.

---
### Exercice 2: serveur de fichiers
Dans cet exercice, on fait une implémentation simple pour un serveur de fichiers avec gestion multi-clients en Java
1. **Programme Serveur**: Le serveur :
   - Utilise ServerSocket pour écouter sur le port 123.
   - Pour chaque client, un thread distinct est créé (ClientThread).
   - Le serveur vérifie si le fichier demandé existe :
     - S'il existe, son contenu est envoyé ligne par ligne.
     - Sinon, un message d'erreur est retourné au client.
2. **Programme Client**: Le client :
   - Se connecte au serveur et envoie le nom du fichier qu’il souhaite recevoir.
   - Affiche la réponse du serveur (contenu du fichier ou message d’erreur).
### Code source : Serveur
```java
public class FileServer {

   public static void main(String[] args) {
      System.out.println("Serveur de fichiers démarré sur le port " + 123);

      try (ServerSocket serverSocket = new ServerSocket(123)) {
         while (true) {
            // Attendre une connexion client
            Socket clientSocket = serverSocket.accept();
            System.out.println("Nouveau client connecté : ");

            // Démarrer un nouveau thread pour gérer ce client
            new ClientThread(clientSocket).start();
         }
      } catch (IOException e) {
         System.err.println("Erreur sur le serveur : " + e.getMessage());
      }
   }
}

// Class ClientThread
class ClientThread extends Thread {
   private Socket clientSocket;

   public ClientThread(Socket clientSocket) {
      this.clientSocket = clientSocket;
   }

   @Override
   public void run() {
      try (BufferedReader in = new BufferedReader(new InputStreamReader(clientSocket.getInputStream()));
           PrintWriter out = new PrintWriter(clientSocket.getOutputStream(), true)) {

         // Envoyer un message de bienvenue au client
         out.println("Bienvenue sur le serveur de fichiers. Entrez le nom du fichier que vous souhaitez.");

         // Lire la demande du client
         String fileName = in.readLine();
         System.out.println("Demande reçue pour le fichier : " + fileName);

         File file = new File("files/%s".formatted(fileName));
         if (file.exists() && file.isFile()) {
            out.println("Fichier trouvé. Envoi en cours...");

            // Envoyer le contenu du fichier
            try (BufferedReader fileReader = new BufferedReader(new FileReader(file))) {
               String line;
               while ((line = fileReader.readLine()) != null) {
                  out.println(line);
               }
            }
            out.println("FIN"); // Indiquer la fin du fichier
            System.out.println("Fichier envoyé au client.");
         } else {
            out.println("Erreur : Le fichier demandé n'existe pas.");
         }
      } catch (IOException e) {
         System.err.println("Erreur avec le client : " + e.getMessage());
      } finally {
         try {
            clientSocket.close();
         } catch (IOException e) {
            System.err.println("Impossible de fermer la connexion : " + e.getMessage());
         }
      }
   }
}
```

### Code source : Client
```java
  try (Socket socket = new Socket("localhost", 123);
             BufferedReader in = new BufferedReader(new InputStreamReader(socket.getInputStream()));
             PrintWriter out = new PrintWriter(socket.getOutputStream(), true);
             Scanner scanner = new Scanner(System.in)) {

            System.out.println("Connecté au serveur de fichiers.");

            // Lire le message de bienvenue
            System.out.println("Serveur : " + in.readLine());

            // Envoyer le nom du fichier au serveur
            System.out.print("Entrez le nom du fichier à demander : ");
            String fileName = scanner.nextLine();
            out.println(fileName);

            // Lire la réponse et le contenu du fichier
            String response;
            while ((response = in.readLine()) != null) {
                if (response.equals("FIN")) {
                    break;
                }
                System.out.println(response);
            }
        } catch (IOException e) {
            System.err.println("Erreur client : " + e.getMessage());
        }
```

### Sorties des programmes
```txt
*** Serveur ***
Serveur de fichiers démarré sur le port 123
Nouveau client connecté : 
Nouveau client connecté : 
Demande reçue pour le fichier : mdp.txt
Fichier envoyé au client.
Demande reçue pour le fichier : mm.txt

*** Client 1 ***
Connecté au serveur de fichiers.
Serveur : Bienvenue sur le serveur de fichiers. Entrez le nom du fichier que vous souhaitez.
Entrez le nom du fichier à demander : mdp.txt
Fichier trouvé. Envoi en cours...
Mes mots de pass
gmail:12345
outlook:123456
github:77777

*** Client 2 ***
Connecté au serveur de fichiers.
Serveur : Bienvenue sur le serveur de fichiers. Entrez le nom du fichier que vous souhaitez.
Entrez le nom du fichier à demander : mm.txt
Erreur : Le fichier demandé n'existe pas.
```
---
En conclusion, ces exercices initient aux fondamentaux de la programmation réseau avec les sockets en Java, tout en explorant des concepts avancés comme le multi-threading, la gestion des connexions multiples, et la manipulation de fichiers entre client et serveur.