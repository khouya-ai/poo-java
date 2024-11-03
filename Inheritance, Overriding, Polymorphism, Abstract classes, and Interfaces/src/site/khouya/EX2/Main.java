package site.khouya.EX2;

public class Main {
    public static void main(String[] args) {

        // déclarez et intentiez un ingénieur
        Ingenieur ingenieur = new Ingenieur("ALI", "Ahmed", "ahmed@gmail.com","06-77-77-77-77",10000,"Securite");
        //déclarez et intentiez un manager
        Manager manager = new Manager("MOUNIR", "Samira", "samira@gmail.com","06-99-99-99-99",15000,"Service IT");
        //affichez les informations de l’ingénieur et du manager
        System.out.println("*** Informations de l’ingénieur");
        System.out.println(ingenieur);
        System.out.println();
        System.out.println("*** Informations du manager");
        System.out.println(manager);

    }
}
