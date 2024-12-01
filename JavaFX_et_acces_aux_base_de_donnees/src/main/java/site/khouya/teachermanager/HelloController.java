package site.khouya.teachermanager;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;

public class HelloController {
    @FXML
    void goToDep(ActionEvent event) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(HelloApplication.class.getResource("dep-view.fxml"));
        Scene scene = new Scene(fxmlLoader.load(), 850, 600);
        Stage stage = new Stage();
        stage.setTitle("Gestion des Departements");
        stage.setScene(scene);
        stage.show();
    }

    @FXML
    void goToProf(ActionEvent event) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(HelloApplication.class.getResource("prof-view.fxml"));
        Scene scene = new Scene(fxmlLoader.load(), 850, 600);
        Stage stage = new Stage();
        stage.setTitle("Gestion des Professeurs");
        stage.setScene(scene);
        stage.show();
    }

}