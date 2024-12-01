package site.khouya.teachermanager.metier;

import java.util.Date;
import java.util.List;

public class Test {
    public static void main(String[] args) {
        Metier metier = new Metier();


        // Ajouter des départements
        Departement d1 = new Departement(0, "Mathematics");
        Departement d2 = new Departement(0, "Computer Science");
        metier.ajouterDepartement(d1);
        metier.ajouterDepartement(d2);

        // Lister les départements
        System.out.println("Départements après l'ajout :");
        List<Departement> departements = metier.listerDepartements();
        departements.forEach(System.out::println);

        // Ajouter des professeurs
        Professeur p1 = new Professeur(0, "Smith", "John", "CIN123", "123 Rue Principale", "0612345678", "john.smith@example.com", new Date(), 0);
        Professeur p2 = new Professeur(0, "Doe", "Jane", "CIN456", "456 Rue de l'Orme", "0612345679", "jane.doe@example.com", new Date(), departements.getFirst().getId());
        metier.ajouterProfesseur(p1);
        metier.ajouterProfesseur(p2);

        // Lister les professeurs
        System.out.println("\nProfesseurs après l'ajout :");
        List<Professeur> professeurs = metier.listerProfesseurs();
        professeurs.forEach(System.out::println);

        // Modifier un professeur
        professeurs.getFirst().setNom("Johnson");
        metier.modifierProfesseur(professeurs.getFirst());

        // Rechercher et afficher le professeur modifié
        Professeur professeurRecherché = metier.rechercherProfesseur(professeurs.getFirst().getId());
        System.out.println("\nProfesseur après la modification :");
        System.out.println(professeurRecherché);

        // Affecter un professeur à un département
        metier.affecterProfesseurADepartement(professeurs.getFirst().getId(), departements.getLast().getId());
        System.out.printf("\nProfesseurs du département %d :\n",departements.getLast().getId());
        List<Professeur> profsDansDepartement = metier.listerProfesseursParDepartement(departements.getLast().getId());
        profsDansDepartement.forEach(System.out::println);

        // Supprimer un département
        System.out.printf("\nSupprimer le département %d :\n",departements.getLast().getId());
        metier.supprimerDepartement(departements.getLast().getId());

        // Supprimer un professeur
        System.out.printf("\nSupprimer le professeur %d :\n",professeurs.getFirst().getId());
        metier.supprimerProfesseur(professeurs.getFirst().getId());

        // Liste finale des professeurs et des départements
        System.out.println("\nListe finale des professeurs :");
        metier.listerProfesseurs().forEach(System.out::println);

        System.out.println("\nListe finale des départements :");
        metier.listerDepartements().forEach(System.out::println);
    }
}
