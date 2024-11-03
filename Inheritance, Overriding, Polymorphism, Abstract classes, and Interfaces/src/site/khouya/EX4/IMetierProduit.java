package site.khouya.EX4;

import java.util.List;

public interface IMetierProduit {
    public Produit add(Produit p);

    public List<Produit> getAll();

    public List<Produit> findByNom(String motCle);

    public Produit findById(long id);

    public void delete(long id);
}
