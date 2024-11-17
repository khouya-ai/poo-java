package site.khouya.Stream;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class EX1 {

    public static void main(String[] args) {
        List<String> mots = Arrays.asList("pomme", "banane", "cerise", "date", "figue", "raisin");
        System.out.println(mots);

        // 1. Filtrer les mots qui contiennent la lettre "a".
        List<String> contientA = mots.stream()
                .filter(mot -> mot.contains("a"))
                .toList();
        System.out.println("Mots contenant 'a' : " + contientA);

        // 2. Filtrer les mots qui ont une longueur supérieure à 3 et transformer chaque mot en son inverse.
        List<String> motsInverses = mots.stream()
                .filter(mot -> mot.length() > 3)
                .map(mot -> new StringBuilder(mot).reverse().toString())
                .toList();
        System.out.println("Mots inversés de longueur > 3 : " + motsInverses);

        // 3. Filtrer les chaînes qui contiennent la lettre "e" et aplatir chaque chaîne en une liste de ses caractères.
        List<Character> caracteresAvecE = mots.stream()
                .filter(mot -> mot.contains("e"))
                .flatMap(mot -> mot.chars().mapToObj(c -> (char) c))
                .toList();
        System.out.println("Caractères de mots contenant 'e' : " + caracteresAvecE);

        // 4. Transformer chaque chaîne en sa version en majuscules.
        List<String> motsMajuscules = mots.stream()
                .map(String::toUpperCase)
                .toList();
        System.out.println("Mots en majuscules : " + motsMajuscules);

        // 5. Convertir chaque chaîne en sa longueur.
        List<Integer> longueursMots = mots.stream()
                .map(String::length)
                .toList();
        System.out.println("Longueurs des mots : " + longueursMots);

        // 6. Transformer chaque chaîne en une liste de ses caractères, puis aplatir toutes les listes en une seule liste de caractères.
        List<Character> tousCaracteres = mots.stream()
                .flatMap(mot -> mot.chars().mapToObj(c -> (char) c))
                .toList();
        System.out.println("Liste aplatie de tous les caractères : " + tousCaracteres);

        // 7. À partir d'une liste de mots, transformer chaque nom en une chaîne de la forme "Nom - Index" où l'index représente la position du nom dans la liste.
        List<String> motsAvecIndex = IntStream.range(0, mots.size())
                .mapToObj(i -> mots.get(i) + " - " + i)
                .toList();
        System.out.println("Mots avec index : " + motsAvecIndex);
    }
}
