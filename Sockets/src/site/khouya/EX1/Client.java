package site.khouya.EX1;


import java.io.*;
import java.net.Socket;
import java.util.Scanner;

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
