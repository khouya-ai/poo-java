package site.khouya.Stream.EX2;

class Employe {
    private String nom;
    private String departement;
    private double salaire;

    public Employe(String nom, String departement, double salaire) {
        this.nom = nom;
        this.departement = departement;
        this.salaire = salaire;
    }

    public String getNom() {
        return nom;
    }

    public String getDepartement() {
        return departement;
    }

    public double getSalaire() {
        return salaire;
    }

    @Override
    public String toString() {
        return "Employe{" +
                "nom='" + nom + '\'' +
                ", departement='" + departement + '\'' +
                ", salaire=" + salaire +
                '}';
    }
}
