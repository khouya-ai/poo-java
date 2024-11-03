package site.khouya.EX1;

public class Auteur extends Personne {

    String numAuteur;

    public Auteur(String nom, String prenom, String email, String telephone, int age, String numAuteur) {
        super(nom, prenom, email, telephone, age);
        this.numAuteur = numAuteur;
    }


    public void afficher() {
        System.out.println("numAuteur: " + numAuteur);
        super.afficher();
    }
}
