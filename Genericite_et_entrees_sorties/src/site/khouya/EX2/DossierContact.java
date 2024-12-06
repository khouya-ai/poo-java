package site.khouya.EX2;

import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.*;

public class DossierContact {

    private Map<String, String> contacts;

    public DossierContact() throws IOException {
        chargerContacts();
    }

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



    void ajouterContact(String nom, String numero) throws IOException {

        contacts.put(nom.trim(), numero.trim());
    }

    void supprimerContact(String nom) throws IOException {
        contacts.remove(nom.trim());
    }


    String chercherNumero(String nom) throws IOException {

        if(contacts.containsKey(nom.trim())) {
            return contacts.get(nom.trim());
        }
        return "Le contact n'existe pas";
    }

    void changerNumero(String nom, String nouveauNumero) throws IOException {
        if (contacts.containsKey(nom)) {
            contacts.put(nom, nouveauNumero);
        }
    }


}





































































