package site.khouya.teachermanager.metier;

import java.util.List;

public interface IMetier {
    void ajouterProfesseur(Professeur p);
    void supprimerProfesseur(int id);
    void modifierProfesseur(Professeur p);
    Professeur rechercherProfesseur(int id);
    List<Professeur> listerProfesseurs();
    void affecterProfesseurADepartement(int idProf, int idDepart);

    void ajouterDepartement(Departement d);
    void supprimerDepartement(int id);
    void modifierDepartement(Departement d);
    Departement rechercherDepartement(int id);
    List<Departement> listerDepartements();
    List<Professeur> listerProfesseursParDepartement(int idDepart);
}
