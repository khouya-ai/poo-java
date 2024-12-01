package site.khouya.teachermanager;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.stage.Stage;
import site.khouya.teachermanager.metier.IMetier;
import site.khouya.teachermanager.metier.Metier;
import site.khouya.teachermanager.metier.Professeur;

import java.io.IOException;
import java.net.URL;
import java.util.Date;
import java.util.ResourceBundle;

public class ProfController implements Initializable {
    @FXML
    private Button btnActualiser;

    @FXML
    private TableColumn<Professeur, String> tableColumnCIN;

    @FXML
    private TableColumn<Professeur, Date> tableColumnDate;

    @FXML
    private TableColumn<Professeur, String> tableColumnDepart;

    @FXML
    private TableColumn<Professeur, String> tableColumnEmail;

    @FXML
    private TableColumn<Professeur, Integer> tableColumnID;

    @FXML
    private TableColumn<Professeur, String> tableColumnNom;

    @FXML
    private TableColumn<Professeur, String> tableColumnPrenom;

    @FXML
    private TableView<Professeur> tableProf;

    IMetier metier = new Metier();


    @FXML
    void onActualiserButtonClick(ActionEvent event) {
        loadTable();
    }

    @FXML
    void onAjouterButtonClick(ActionEvent event) throws IOException {
            FXMLLoader fxmlLoader = new FXMLLoader(HelloApplication.class.getResource("prof-edit-view.fxml"));
            Scene scene = new Scene(fxmlLoader.load(), 850, 600);
            // Get the controller and pass the id
            ProfEditController controller = fxmlLoader.getController();
            controller.initializeForInsertion();
            controller.setParentController(this);
            Stage stage = new Stage();
            stage.setTitle("Ajouter un Professeur");
            stage.setScene(scene);
            stage.show();
    }

    @FXML
    void onModifierButtonClick(ActionEvent event) throws IOException {
        if(!tableProf.getSelectionModel().getSelectedItems().isEmpty()) {
            Professeur selectedProf = tableProf.getSelectionModel().getSelectedItem();
            int profId = selectedProf.getId();
            System.out.println(profId);
            FXMLLoader fxmlLoader = new FXMLLoader(HelloApplication.class.getResource("prof-edit-view.fxml"));
            Scene scene = new Scene(fxmlLoader.load(), 850, 600);
            // Get the controller and pass the id
            ProfEditController controller = fxmlLoader.getController();
            controller.initializeForUpdate(profId);
            controller.setParentController(this);
            Stage stage = new Stage();
            stage.setTitle("Modifier un Professeur");
            stage.setScene(scene);
            stage.show();
        }
    }

    @FXML
    void onSupprimerButtonClick(ActionEvent event) {
        if(!tableProf.getSelectionModel().getSelectedItems().isEmpty()) {
            Alert alert = new Alert(Alert.AlertType.WARNING);
            alert.setTitle("Attention!");
            alert.setHeaderText("Suppression du Professeur");
            alert.setContentText("Êtes-vous sûr de vouloir supprimer ce professeur ?");
            alert.showAndWait().ifPresent(response -> {
                if (response == ButtonType.OK) {
                    Professeur p = tableProf.getSelectionModel().getSelectedItem();
                    metier.supprimerProfesseur(p.getId());
                    loadTable();
                }
            });
        }
    }
    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        tableColumnID.setCellValueFactory(new PropertyValueFactory<>("id"));
        tableColumnNom.setCellValueFactory(new PropertyValueFactory<>("nom"));
        tableColumnPrenom.setCellValueFactory(new PropertyValueFactory<>("prenom"));
        tableColumnEmail.setCellValueFactory(new PropertyValueFactory<>("email"));
        tableColumnDate.setCellValueFactory(new PropertyValueFactory<>("dateRecrutement"));
        tableColumnCIN.setCellValueFactory(new PropertyValueFactory<>("cin"));
        tableColumnDepart.setCellValueFactory(new PropertyValueFactory<>("departNom"));
        loadTable();
    }

     void loadTable() {
        System.out.println("Table Reloading ...");
        ObservableList<Professeur> data = FXCollections.observableArrayList(
                metier.listerProfesseurs()
        );
        tableProf.setItems(data);
    }
}