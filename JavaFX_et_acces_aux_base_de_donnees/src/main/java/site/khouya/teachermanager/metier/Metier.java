package site.khouya.teachermanager.metier;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class Metier implements IMetier {
    private final Connection dbConnection = SingletonConnexionDB.getConnexion();

    @Override
    public void ajouterProfesseur(Professeur p) {
        try {
            String sql = "INSERT INTO Professeurs (nom, prenom, cin, adresse, telephone, email, date_recrutement, departement_id) VALUES (?, ?, ?, ?, ?, ?, ?, ?)";
            PreparedStatement ps = dbConnection.prepareStatement(sql);
            ps.setString(1, p.getNom());
            ps.setString(2, p.getPrenom());
            ps.setString(3, p.getCin());
            ps.setString(4, p.getAdresse());
            ps.setString(5, p.getTelephone());
            ps.setString(6, p.getEmail());
            ps.setDate(7, new java.sql.Date(p.getDateRecrutement().getTime()));
            ps.setInt(8, p.getDepartId());
            ps.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void supprimerProfesseur(int id) {
        try {
            String sql = "DELETE FROM Professeurs WHERE id = ?";
            PreparedStatement ps = dbConnection.prepareStatement(sql);
            ps.setInt(1, id);
            System.out.println(sql);
            System.out.println(id);
            ps.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void modifierProfesseur(Professeur p) {
        try {
            String sql = "UPDATE Professeurs SET nom = ?, prenom = ?, cin = ?, adresse = ?, telephone = ?, email = ?, date_recrutement = ?, departement_id = ? WHERE id = ?";
            PreparedStatement ps = dbConnection.prepareStatement(sql);
            ps.setString(1, p.getNom());
            ps.setString(2, p.getPrenom());
            ps.setString(3, p.getCin());
            ps.setString(4, p.getAdresse());
            ps.setString(5, p.getTelephone());
            ps.setString(6, p.getEmail());
            ps.setDate(7, new java.sql.Date(p.getDateRecrutement().getTime()));
            ps.setInt(8, p.getDepartId());
            ps.setInt(9, p.getId());
            ps.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public Professeur rechercherProfesseur(int id) {
        Professeur prof = null;
        try {
            String sql = "SELECT p.*,d.nom as departement_nom FROM Professeurs p, departements d where p.departement_id = d.id and p.id = ?";
            PreparedStatement ps = dbConnection.prepareStatement(sql);
            ps.setInt(1, id);
            ResultSet rs = ps.executeQuery();
            if (rs.next()) {
                prof = new Professeur();
                prof.setId(rs.getInt("id"));
                prof.setNom(rs.getString("nom"));
                prof.setPrenom(rs.getString("prenom"));
                prof.setCin(rs.getString("cin"));
                prof.setAdresse(rs.getString("adresse"));
                prof.setTelephone(rs.getString("telephone"));
                prof.setEmail(rs.getString("email"));
                prof.setDateRecrutement(rs.getDate("date_recrutement"));
                prof.setDepartId(rs.getInt("departement_id"));
                prof.setDepartNom(rs.getString("departement_nom"));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return prof;
    }

    @Override
    public List<Professeur> listerProfesseurs() {
        List<Professeur> professeurs = new ArrayList<>();
        try {
            String sql = "SELECT p.*,d.nom as departement_nom FROM Professeurs p, departements d where p.departement_id = d.id";
            Statement stmt = dbConnection.createStatement();
            ResultSet rs = stmt.executeQuery(sql);
            while (rs.next()) {
                Professeur prof = new Professeur();
                prof.setId(rs.getInt("id"));
                prof.setNom(rs.getString("nom"));
                prof.setPrenom(rs.getString("prenom"));
                prof.setCin(rs.getString("cin"));
                prof.setAdresse(rs.getString("adresse"));
                prof.setTelephone(rs.getString("telephone"));
                prof.setEmail(rs.getString("email"));
                prof.setDateRecrutement(rs.getDate("date_recrutement"));
                prof.setDepartId(rs.getInt("departement_id"));
                prof.setDepartNom(rs.getString("departement_nom"));
                professeurs.add(prof);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return professeurs;
    }

    @Override
    public void affecterProfesseurADepartement(int idProf, int idDepart) {
        try {
            String sql = "UPDATE Professeurs SET departement_id = ? WHERE id = ?";
            PreparedStatement ps = dbConnection.prepareStatement(sql);
            ps.setInt(1, idDepart);
            ps.setInt(2, idProf);
            ps.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void ajouterDepartement(Departement d) {
        try {
            String sql = "INSERT INTO Departements (nom) VALUES (?)";
            PreparedStatement ps = dbConnection.prepareStatement(sql);
            ps.setString(1, d.getNom());
            ps.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void supprimerDepartement(int id) {
        try {
            String sql = "DELETE FROM Departements WHERE id = ?";
            PreparedStatement ps = dbConnection.prepareStatement(sql);
            ps.setInt(1, id);
            ps.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void modifierDepartement(Departement d) {
        try {
            String sql = "UPDATE Departements SET nom = ? WHERE id = ?";
            PreparedStatement ps = dbConnection.prepareStatement(sql);
            ps.setString(1, d.getNom());
            ps.setInt(2, d.getId());
            ps.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public Departement rechercherDepartement(int id) {
        Departement dept = null;
        try {
            String sql = "SELECT * FROM Departements WHERE id = ?";
            PreparedStatement ps = dbConnection.prepareStatement(sql);
            ps.setInt(1, id);
            ResultSet rs = ps.executeQuery();
            if (rs.next()) {
                dept = new Departement();
                dept.setId(rs.getInt("id"));
                dept.setNom(rs.getString("nom"));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return dept;
    }

    @Override
    public List<Departement> listerDepartements() {
        List<Departement> departements = new ArrayList<>();
        try {
            String sql = "SELECT * FROM Departements";
            Statement stmt = dbConnection.createStatement();
            ResultSet rs = stmt.executeQuery(sql);
            while (rs.next()) {
                Departement dept = new Departement();
                dept.setId(rs.getInt("id"));
                dept.setNom(rs.getString("nom"));
                departements.add(dept);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return departements;
    }

    @Override
    public List<Professeur> listerProfesseursParDepartement(int idDepart) {
        List<Professeur> professeurs = new ArrayList<>();
        try {
            String sql = "SELECT * FROM Professeurs WHERE id = ?";
            PreparedStatement ps = dbConnection.prepareStatement(sql);
            ps.setInt(1, idDepart);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                Professeur prof = new Professeur();
                prof.setId(rs.getInt("id"));
                prof.setNom(rs.getString("nom"));
                prof.setPrenom(rs.getString("prenom"));
                prof.setCin(rs.getString("cin"));
                prof.setAdresse(rs.getString("adresse"));
                prof.setTelephone(rs.getString("telephone"));
                prof.setEmail(rs.getString("email"));
                prof.setDateRecrutement(rs.getDate("date_recrutement"));
                prof.setId(rs.getInt("departement_id"));
                professeurs.add(prof);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return professeurs;
    }
}
