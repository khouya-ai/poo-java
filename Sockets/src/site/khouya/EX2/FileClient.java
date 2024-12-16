package site.khouya.EX2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;
import java.util.Scanner;

public class FileClient {

    public static void main(String[] args) {
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
    }
}
