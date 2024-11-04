package site.khouya.EX2;

public class RacineCarreeException extends Exception{

    RacineCarreeException(int entier){
        super("C'est une exception de type RacineCarreeException. Nombre négatif : " + entier);
    }
}
