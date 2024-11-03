package site.khouya.EX3;

import java.util.ArrayList;
import java.util.List;

public class Client {

    String nom;
    String prenom;
    String adresse;
    String email;
    String ville;
    String telephone;
    List<Commande> commandeList;

    void ajouterCommande(Commande ord) {
        if (!commandeList.contains(ord)) {
            commandeList.add(ord);
        }
    }

    void supprimerCommande(Commande ord) {
        commandeList.remove(ord);
    }

    public Client() {
    }

    public Client(String nom, String prenom, String adresse, String email, String ville, String telephone) {
        this.nom = nom;
        this.prenom = prenom;
        this.adresse = adresse;
        this.email = email;
        this.ville = ville;
        this.telephone = telephone;
        this.commandeList = new ArrayList<>();
    }

    @Override
    public String toString() {
        return "Client :"+
                "\n\t nom : '" + nom + '\'' +
                "\n\t prenom : '" + prenom + '\'' +
                "\n\t adresse : '" + adresse + '\'' +
                "\n\t email : '" + email + '\'' +
                "\n\t ville : '" + ville + '\'' +
                "\n\t telephone : '" + telephone + '\'' ;
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public String getPrenom() {
        return prenom;
    }

    public void setPrenom(String prenom) {
        this.prenom = prenom;
    }

    public String getAdresse() {
        return adresse;
    }

    public void setAdresse(String adresse) {
        this.adresse = adresse;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getVille() {
        return ville;
    }

    public void setVille(String ville) {
        this.ville = ville;
    }

    public String getTelephone() {
        return telephone;
    }

    public void setTelephone(String telephone) {
        this.telephone = telephone;
    }

    public List<Commande> getCommandeList() {
        return commandeList;
    }

    public void setCommandeList(List<Commande> commandeList) {
        this.commandeList = commandeList;
    }
}
