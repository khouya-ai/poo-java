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
import site.khouya.teachermanager.metier.Departement;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

public class DepController implements Initializable {
    @FXML
    private Button btnActualiser;

    @FXML
    private TableColumn<Departement, Integer> tableColumnID;

    @FXML
    private TableColumn<Departement, String> tableColumnNom;


    @FXML
    private TableView<Departement> tableDep;

    IMetier metier = new Metier();


    @FXML
    void onActualiserButtonClick(ActionEvent event) {
        loadTable();
    }

    @FXML
    void onAjouterButtonClick(ActionEvent event) throws IOException {
            FXMLLoader fxmlLoader = new FXMLLoader(HelloApplication.class.getResource("dep-edit-view.fxml"));
            Scene scene = new Scene(fxmlLoader.load(), 850, 600);
            // Get the controller and pass the id
            DepEditController controller = fxmlLoader.getController();
            controller.initializeForInsertion();
            controller.setParentController(this);
            Stage stage = new Stage();
            stage.setTitle("Ajouter un Departement");
            stage.setScene(scene);
            stage.show();
    }

    @FXML
    void onModifierButtonClick(ActionEvent event) throws IOException {
        if(!tableDep.getSelectionModel().getSelectedItems().isEmpty()) {
            Departement selectedDep = tableDep.getSelectionModel().getSelectedItem();
            int depId = selectedDep.getId();
            System.out.println(depId);
            FXMLLoader fxmlLoader = new FXMLLoader(HelloApplication.class.getResource("dep-edit-view.fxml"));
            Scene scene = new Scene(fxmlLoader.load(), 850, 600);
            // Get the controller and pass the id
            DepEditController controller = fxmlLoader.getController();
            controller.initializeForUpdate(depId);
            controller.setParentController(this);
            Stage stage = new Stage();
            stage.setTitle("Modifier un Departement");
            stage.setScene(scene);
            stage.show();
        }
    }

    @FXML
    void onSupprimerButtonClick(ActionEvent event) {
        if(!tableDep.getSelectionModel().getSelectedItems().isEmpty()) {
            Alert alert = new Alert(Alert.AlertType.WARNING);
            alert.setTitle("Attention!");
            alert.setHeaderText("Suppression du Departement");
            alert.setContentText("Êtes-vous sûr de vouloir supprimer ce departement ?");
            alert.showAndWait().ifPresent(response -> {
                if (response == ButtonType.OK) {
                    Departement p = tableDep.getSelectionModel().getSelectedItem();
                    metier.supprimerDepartement(p.getId());
                    loadTable();
                }
            });
        }
    }
    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        tableColumnID.setCellValueFactory(new PropertyValueFactory<>("id"));
        tableColumnNom.setCellValueFactory(new PropertyValueFactory<>("nom"));
        loadTable();
    }

     void loadTable() {
        System.out.println("Table Reloading ...");
        ObservableList<Departement> data = FXCollections.observableArrayList(
                metier.listerDepartements()
        );
        tableDep.setItems(data);
    }
}