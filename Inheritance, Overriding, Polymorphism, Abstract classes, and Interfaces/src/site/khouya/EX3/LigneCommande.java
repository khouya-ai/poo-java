package site.khouya.EX3;

public class LigneCommande {

    int quantite;
    Commande commande;
    Ordinateur ordinateur;

    public LigneCommande(int quantite, Commande commande, Ordinateur ordinateur) {
        this.quantite = quantite;
        this.commande = commande;
        this.ordinateur = ordinateur;
    }

    public LigneCommande() {
    }

    @Override
    public String toString() {
        return  ordinateur + "\t\t " + quantite + "\t\t\t " + ordinateur.prix * quantite ;
    }

    public int getQuantite() {
        return quantite;
    }

    public void setQuantite(int quantite) {
        this.quantite = quantite;
    }

    public Commande getCommande() {
        return commande;
    }

    public void setCommande(Commande commande) {
        this.commande = commande;
    }

    public Ordinateur getOrdinateur() {
        return ordinateur;
    }

    public void setOrdinateur(Ordinateur ordinateur) {
        this.ordinateur = ordinateur;
    }
}
