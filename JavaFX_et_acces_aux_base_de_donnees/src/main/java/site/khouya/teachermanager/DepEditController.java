package site.khouya.teachermanager;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.stage.Stage;
import site.khouya.teachermanager.metier.Metier;
import site.khouya.teachermanager.metier.Departement;

import java.text.ParseException;
import java.util.List;

public class DepEditController {

    @FXML
    private TextField txtNom;

    Metier metier = new Metier();
    Departement dep;
    List<Departement> departementList;
    boolean editMod = true;
    private DepController depController;

    public void setParentController(DepController depController) {
        this.depController = depController;
    }

    @FXML
    void Annuler(ActionEvent event) {
        Stage stage = (Stage) ((Button) event.getSource()).getScene().getWindow();
        stage.close();
    }

    @FXML
    void Valider(ActionEvent event) throws ParseException {
        if (!this.editMod) {
            dep = new Departement();
        }
        dep.setNom(txtNom.getText());
        if (this.editMod) {
            metier.modifierDepartement(dep);
        } else {
            metier.ajouterDepartement(dep);
        }
        this.depController.loadTable();
    }

    public void initializeForUpdate(int profId) {
        editMod = true;
        dep = metier.rechercherDepartement(profId);
        txtNom.setText(dep.getNom());
    }

    public void initializeForInsertion() {
        editMod = false;
    }
}
