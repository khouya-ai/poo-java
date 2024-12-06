package site.khouya.EX3;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class MetierClientImpl implements IMetier<Client> {
    private List<Client> clients;
    private final String fileName;

    public MetierClientImpl(String fileName) {
        this.fileName = fileName;
        this.clients = new ArrayList<>();
        loadFromFile();
    }

    @Override
    public Client add(Client c) {
        clients.add(c);
        return c;
    }

    @Override
    public List<Client> getAll() {
        return clients;
    }

    @Override
    public Client findByNom(String nom) {
        return clients.stream()
                .filter(c -> c.getNom().equalsIgnoreCase(nom))
                .findFirst()
                .orElse(null);
    }

    @Override
    public void delete(String nom) {
        clients.removeIf(c -> c.getNom().equalsIgnoreCase(nom));
    }

    @Override
    public void saveAll() {
        try (
                // Création d'un flux pour écrire un objet dans un fichier.
                // FileOutputStream ouvre/écrit dans le fichier spécifié par "fileName".
                // ObjectOutputStream permet de sérialiser les objets.
                ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(fileName))
        ) {
            // Sérialise et écrit l'objet "clients" (liste de clients) dans le fichier.
            oos.writeObject(clients);
        } catch (IOException e) {
            // Capture et affiche les erreurs liées à la sérialisation ou à l'écriture dans le fichier.
            e.printStackTrace();
        }
    }


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

}

