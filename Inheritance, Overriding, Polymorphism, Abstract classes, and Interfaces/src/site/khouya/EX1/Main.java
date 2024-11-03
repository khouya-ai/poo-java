package site.khouya.EX1;

public class Main {
    public static void main(String[] args) {

        // déclarez et intentiez un adhèrent
        Adherent adherent = new Adherent("ALI", "Ahmed", "ahmed.ali@gmail.com", "0987654321", 25, "AD123");


        // déclarez et instanciez un livre qui est écrit par un auteur
        Auteur auteur = new Auteur("Martin", "Robert", "martin.robert@gmail.com", "1234567890", 45, "A001");
        Livre livre1 = new Livre(123, "Clean Code", auteur);


        // affichez les informations de l’adhèrent et du livre.
        System.out.println("*** Informations de l'adherent :");
        adherent.afficher();
        System.out.println();
        System.out.println("*** Informations du livre :");
        livre1.afficher();





    }
}
