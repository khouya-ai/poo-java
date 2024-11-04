package site.khouya.EX3;

public class Evaluateur {
    public Evaluateur() {}

    public void verifierNote(int entier) throws Exception {
        if (entier < 0 || entier > 20) {
            throw new NoteInvalideException(entier);
        }
    }

    public static void main(String[] args) {
        Evaluateur evaluateur = new Evaluateur();

        try {
            // Test avec une note valid
            evaluateur.verifierNote(15);
            System.out.println("Note 15 : Pas d'exception");

            // Test avec une note non valid
            evaluateur.verifierNote(25);
        } catch (Exception e) {
            // Affiche la pile d'appel de l'exception
            e.printStackTrace();
        }
    }
}
