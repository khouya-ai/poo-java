package site.khouya.EX2;

public class Manager extends Employe {

    String service;

    public Manager(String nom, String prenom, String email, String telephone, double salaire, String service) {
        super(nom, prenom, email, telephone, salaire);
        this.service = service;
    }

    @Override
    public double calculerSalaire() {
        return this.salaire * 1.2;
    }

    @Override
    public String toString() {
        return
                "service='" + service + '\'' +
                "\nnom='" + nom + '\'' +
                "\nprenom='" + prenom + '\'' +
                "\nemail='" + email + '\'' +
                "\ntelephone='" + telephone + '\'' +
                "\nsalaire=" + calculerSalaire() ;
    }
}
