package site.khouya.EX3;

public class Ordinateur {
    String nom;
    String marque;
    double prix;
    String description;
    int nbr_stock;
    Categorie categorie;

    public double prixQuantite(int quantite) {
        return prix * quantite;
    }

    @Override
    public String toString() {
        return nom + "\t " + prix;
    }

    public Ordinateur() {
    }

    public Ordinateur(String nom, String marque, double prix, String description, int nbr_stock) {
        this.nom = nom;
        this.marque = marque;
        this.prix = prix;
        this.description = description;
        this.nbr_stock = nbr_stock;
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public String getMarque() {
        return marque;
    }

    public void setMarque(String marque) {
        this.marque = marque;
    }

    public double getPrix() {
        return prix;
    }

    public void setPrix(double prix) {
        this.prix = prix;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public int getNbr_stock() {
        return nbr_stock;
    }

    public void setNbr_stock(int nbr_stock) {
        this.nbr_stock = nbr_stock;
    }



}
