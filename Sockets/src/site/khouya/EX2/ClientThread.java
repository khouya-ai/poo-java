package site.khouya.EX2;
import java.io.*;
import java.net.Socket;


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
