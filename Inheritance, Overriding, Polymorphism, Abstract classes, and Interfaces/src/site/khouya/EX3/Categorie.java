package site.khouya.EX3;

import java.util.ArrayList;
import java.util.List;

public class Categorie {

    String nom;
    String description;
    List<Ordinateur> ordinateurlist;

    public Categorie(String nom, String description, List<Ordinateur> ordinateurlist) {
        this.nom = nom;
        this.description = description;
        this.ordinateurlist = ordinateurlist;
    }

    void ajouterOrdinateur(Ordinateur ord) {
        if (!ordinateurlist.contains(ord)) {
            ordinateurlist.add(ord);
        }
    }

    void supprimerOrdinateur(Ordinateur ord) {
        ordinateurlist.remove(ord);
    }

    List<Ordinateur> rechercherParPrix(double prixDonnee) {
        List<Ordinateur> resultat = new ArrayList<>();
        for (Ordinateur ord : ordinateurlist) {
            if (ord.prix == prixDonnee) {
                resultat.add(ord);
            }
        }
        return resultat;
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public List<Ordinateur> getOrdinateurlist() {
        return ordinateurlist;
    }

    public void setOrdinateurlist(List<Ordinateur> ordinateurlist) {
        this.ordinateurlist = ordinateurlist;
    }

    @Override
    public String toString() {
        return "Categorie{" +
                "nom='" + nom + '\'' +
                ", description='" + description + '\'' +
                ", ordinateurlist=" + ordinateurlist.toString() +
                '}';
    }

}
