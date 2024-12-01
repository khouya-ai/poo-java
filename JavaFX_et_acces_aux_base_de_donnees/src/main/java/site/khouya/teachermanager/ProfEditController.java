package site.khouya.teachermanager;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.TextField;
import javafx.stage.Stage;
import site.khouya.teachermanager.metier.Departement;
import site.khouya.teachermanager.metier.Metier;
import site.khouya.teachermanager.metier.Professeur;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

public class ProfEditController {
    @FXML
    private Button btnCancel;

    @FXML
    private Button btnOK;

    @FXML
    private ChoiceBox<String> cboxDepart;

    @FXML
    private TextField txtAdresse;

    @FXML
    private TextField txtCIN;

    @FXML
    private TextField txtEmail;

    @FXML
    private TextField txtNom;

    @FXML
    private TextField txtPrenom;

    @FXML
    private TextField txtRecretement;

    @FXML
    private TextField txtTel;
    Metier metier = new Metier();
    Professeur professeur;
    List<Departement> departementList;
    boolean editMod = true;
    private ProfController professeurController;

    public void setParentController(ProfController professeurController) {
        this.professeurController = professeurController;
    }

    @FXML
    void Annuler(ActionEvent event) {
        Stage stage = (Stage) ((Button) event.getSource()).getScene().getWindow();
        stage.close();
    }

    @FXML
    void Valider(ActionEvent event) throws ParseException {
        if (!this.editMod) {
            professeur = new Professeur();
        }

        professeur.setNom(txtNom.getText());
        professeur.setPrenom(txtPrenom.getText());
        professeur.setEmail(txtEmail.getText());
        professeur.setCin(txtCIN.getText());
        professeur.setAdresse(txtAdresse.getText());
        // Parse Date
        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
        Date dateRecrutement = dateFormat.parse(txtRecretement.getText());
        professeur.setDateRecrutement(dateRecrutement);
        professeur.setTelephone(txtTel.getText());
        // Set Department based on selection
        String selectedDepartment = cboxDepart.getValue();
        professeur.setDepartNom(selectedDepartment);
        int id = departementList.stream().filter(departement -> departement.getNom().equals(selectedDepartment)).toList().getFirst().getId();
        professeur.setDepartId(id);
        System.out.println(professeur);
        if (this.editMod) {
            metier.modifierProfesseur(professeur);
        } else {
            metier.ajouterProfesseur(professeur);
        }
        this.professeurController.loadTable();
    }

    public void initializeForUpdate(int profId) {
        editMod = true;
        professeur = metier.rechercherProfesseur(profId);
        txtNom.setText(professeur.getNom());
        txtPrenom.setText(professeur.getPrenom());
        txtEmail.setText(professeur.getEmail());
        txtCIN.setText(professeur.getCin());
        txtAdresse.setText(professeur.getAdresse());
        txtRecretement.setText(professeur.getDateRecrutement().toString());
        txtTel.setText(professeur.getTelephone());
        departementList = metier.listerDepartements();
        ObservableList<String> data = FXCollections.observableArrayList(
                departementList.stream().map(Departement::getNom).toList()
        );
        cboxDepart.setItems(data);
        cboxDepart.getSelectionModel().select(professeur.getDepartNom());
    }


    public void initializeForInsertion() {
        editMod = false;
        departementList = metier.listerDepartements();
        ObservableList<String> data = FXCollections.observableArrayList(
                departementList.stream().map(Departement::getNom).toList()
        );
        cboxDepart.setItems(data);
        cboxDepart.getSelectionModel().selectFirst();
    }
}
