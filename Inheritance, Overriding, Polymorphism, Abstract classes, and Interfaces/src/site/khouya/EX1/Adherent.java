package site.khouya.EX1;

public class Adherent extends Personne {

    String numAdherent;

    public Adherent(String nom, String prenom, String email, String telephone, int age, String numAdherent) {
        super(nom, prenom, email, telephone, age);
        this.numAdherent = numAdherent;
    }


    public void afficher() {
        System.out.println("numAdherent: " + numAdherent);
        super.afficher();
    }
}
