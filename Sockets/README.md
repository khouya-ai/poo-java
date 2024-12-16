## Travaux Pratiques
## Titre : Programmation réseau avec les sockets
- Etudiant : **Oussama KHOUYA**
- Encadrente : **Pr. Loubna AMINOU**
- Cours : **Programmation Orientée Objet Java** 
- Date de soumission : **16-12-2024**
- Code source sur [github](https://github.com/khouya-ai/poo-java)


Ce travail illustre les bases du programmation réseau avec les sockets en Java avec deux exercices : À travers lesquel on implémente la communication client-serveur, gére les échanges de données en réseau, et intégre le multi-threading pour prendre en charge plusieurs connexions simultanées.
### Exercice 1: Nombre magique
Dans cet exercice,  on développe un jeu utilisant des sockets où les joueurs tentent de deviner un nombre magique. Le serveur génère un nombre magique aléatoire, et les joueurs essaient de le deviner en recevant des indices (au-dessus ou en dessous).
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


## Exercice 2: 

