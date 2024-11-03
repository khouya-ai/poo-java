package site.khouya.EX3;

import java.util.Date;

public class Commande {
    String reference;
    Client client;
    Date date;
    String etat;

    public Commande(String reference, Client client, Date date, String etat) {
        this.reference = reference;
        this.client = client;
        this.date = date;
        this.etat = etat;
    }

    @Override
    public String toString() {
        return  "Commande : "+
                "\nreference : '" + reference + '\'' +
                "\nclient : " + client +
                "\ndate : " + date +
                "\netat : '" + etat + '\'';
    }

    public String getReference() {
        return reference;
    }

    public void setReference(String reference) {
        this.reference = reference;
    }

    public Client getClient() {
        return client;
    }

    public void setClient(Client client) {
        this.client = client;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public String getEtat() {
        return etat;
    }

    public void setEtat(String etat) {
        this.etat = etat;
    }

}
