module site.khouya.teachermanager {
    requires javafx.controls;
    requires javafx.fxml;


    opens site.khouya.teachermanager to javafx.fxml;
    exports site.khouya.teachermanager;
}