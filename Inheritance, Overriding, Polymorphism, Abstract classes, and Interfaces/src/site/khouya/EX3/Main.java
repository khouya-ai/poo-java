package site.khouya.EX3;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;
import java.util.List;

public class Main {

    public static void main(String[] args) {
        //déclarez et intentiez une liste de trois ordinateurs
        Ordinateur ord1 = new Ordinateur("Lenovo ThinkCentre M83", "Lenovo", 1280, "Lenovo ThinkCentre M83 Mini Tower Desktop i3 4ème Gènèration", 20);
        Ordinateur ord2 = new Ordinateur("Lenovo T440 i5 4éme gen", "Lenovo", 1700, "Lenovo T440 i5 4éme generation",20);
        Ordinateur ord3 = new Ordinateur("DELL Optiplex 9020 i7", "Dell", 1650, "UNITE CENTRALE DELL Optiplex 9020 i7 - 4790 8go 128g ssd   dsza",20);
        List<Ordinateur> ordinateurList = new ArrayList<>(Arrays.asList(ord1, ord2, ord3));

        //déclarez et intentiez une catégorie
        Categorie categorie1 = new Categorie("Ordinateurs", "Electroniques", ordinateurList);

        //déclarez et intentiez une client
        Client client1 = new Client("ALI", "Mounir", "Massira Mohamadia", "mounir@gmail.com", "Mohamadia", "0123456789");

        // déclarez et instanciez une commande du client
        Commande commande1 = new Commande("123", client1, new Date(), "LIVRAIE");
        // associe la commande 1 au client 1
        client1.ajouterCommande(commande1);

        //déclarez et instanciez une liste de trois lignes de commandes pour la commande et les ordinateurs créés
        LigneCommande ligne1 = new LigneCommande(2,commande1, ord1);
        LigneCommande ligne2 = new LigneCommande(3,commande1, ord2);
        LigneCommande ligne3 = new LigneCommande(1,commande1, ord3);

        //affichez toutes les informations de la commande
        System.out.println();
        System.out.println(commande1.toString());
        System.out.println("\nDetails :");
        System.out.println("Produit \t\t\t\t Prix Unit \t Quantité \t Prix Total");
        System.out.println(ligne1.toString());
        System.out.println(ligne2.toString());
        System.out.println(ligne3.toString());

    }
}
