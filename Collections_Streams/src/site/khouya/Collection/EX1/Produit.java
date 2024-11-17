package site.khouya.Collection.EX1;

public class Produit {
    private long id;
    private String nom;
    private double prix;

    public Produit() {}

    public Produit(long id, String nom, double prix) {
        this.id = id;
        this.nom = nom;
        this.prix = prix;
    }

    // Getters
    public long getId() {
        return id;
    }

    public String getNom() {
        return nom;
    }

    public double getPrix() {
        return prix;
    }

    // Setters
    public void setId(long id) {
        this.id = id;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public void setPrix(double prix) {
        this.prix = prix;
    }

    // Méthode toString pour afficher les informations du produit
    @Override
    public String toString() {
        return "Produit{" +
                "id=" + id +
                ", nom='" + nom + '\'' +
                ", prix=" + prix +
                '}';
    }
}

