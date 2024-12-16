package site.khouya.EX2;
import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;
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
