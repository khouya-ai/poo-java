package site.khouya.EX1;

public abstract class Personne {
    private String nom;
    private String prenom;
    private String email;
    private String telephone;
    private int age;

    public Personne(String nom, String prenom, String email, String telephone, int age) {
        this.nom = nom;
        this.prenom = prenom;
        this.email = email;
        this.telephone = telephone;
        this.age = age;
    }


    public void afficher() {
        System.out.println("nom: " + nom);
        System.out.println("prenom: " + prenom);
        System.out.println("email: " + email);
        System.out.println("telephone: " + telephone);
        System.out.println("age: " + age);
    }
}
