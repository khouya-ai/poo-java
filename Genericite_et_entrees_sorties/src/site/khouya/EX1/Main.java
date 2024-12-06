package site.khouya.EX1;

import java.io.File;
import java.util.Scanner;

public class Main {

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

}
