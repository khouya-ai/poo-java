package site.khouya.EX1;

public class Livre {

    private int isbn;
    private String titre;
    private Auteur auteur;

    public Livre(int isbn, String titre, Auteur auteur) {
        this.isbn = isbn;
        this.titre = titre;
        this.auteur = auteur;
    }

    public void afficher() {
        System.out.println("isbn: " + isbn);
        System.out.println("titre: " + titre);
        auteur.afficher();
    }
}
