package site.khouya.EX2;

public class Ingenieur extends Employe {

    String specialite;

    public Ingenieur(String nom, String prenom, String email, String telephone, double salaire, String specialite) {
        super(nom, prenom, email, telephone, salaire);
        this.specialite = specialite;
    }

    @Override
    public double calculerSalaire() {
        return this.salaire * 1.15;
    }

    @Override
    public String toString() {
        return
                "specialite='" + specialite + '\'' +
                "\nnom='" + nom + '\'' +
                "\nprenom='" + prenom + '\'' +
                "\nemail='" + email + '\'' +
                "\ntelephone='" + telephone + '\'' +
                "\nsalaire=" + calculerSalaire() ;
    }
}
