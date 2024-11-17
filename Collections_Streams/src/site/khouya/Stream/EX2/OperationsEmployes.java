package site.khouya.Stream.EX2;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

public class OperationsEmployes {
    public static void main(String[] args) {
        List<Employe> employes = new ArrayList<>();
        employes.add(new Employe("Ali", "Informatique", 5000));
        employes.add(new Employe("Samira", "Marketing", 4000));
        employes.add(new Employe("Ahled", "Informatique", 7000));
        employes.add(new Employe("Rim", "Ressources Humaines", 3000));
        employes.add(new Employe("Zineb", "Finance", 4500));

        // 1. Calculer la somme totale des salaires de tous les employés
        double sommeSalaires = employes.stream()
                .mapToDouble(Employe::getSalaire)
                .sum();
        System.out.println("Somme totale des salaires : " + sommeSalaires);

        // 2. Trier la liste des employés par ordre alphabétique du nom
        List<Employe> employesTries = employes.stream()
                .sorted(Comparator.comparing(Employe::getNom))
                .toList();
        System.out.println("Employés triés par nom : " + employesTries);

        // 3. Trouver l'employé avec le salaire le plus bas
        Optional<Employe> employeSalaireMin = employes.stream()
                .min(Comparator.comparing(Employe::getSalaire));
        employeSalaireMin.ifPresent(e -> System.out.println("Employé avec le salaire le plus bas : " + e));

        // 4. Obtenir la liste des employés ayant un salaire supérieur à une valeur donnée (ex : 4500)
        double valeurDonnee = 4500;
        List<Employe> employesSalaireSuperieur = employes.stream()
                .filter(e -> e.getSalaire() > valeurDonnee)
                .toList();
        System.out.println("Employés avec un salaire supérieur à " + valeurDonnee + " : " + employesSalaireSuperieur);

        // 5. Trouver l'employé avec le salaire le plus élevé
        Optional<Employe> employeSalaireMax = employes.stream()
                .reduce((e1, e2) -> e1.getSalaire() > e2.getSalaire() ? e1 : e2);
        employeSalaireMax.ifPresent(e -> System.out.println("Employé avec le salaire le plus élevé : " + e));

        // 6. Concaténer les noms de tous les employés
        String nomsConcatenes = employes.stream()
                .map(Employe::getNom)
                .reduce((nom1, nom2) -> nom1 + ", " + nom2)
                .orElse("");
        System.out.println("Noms concaténés des employés : " + nomsConcatenes);
    }
}
