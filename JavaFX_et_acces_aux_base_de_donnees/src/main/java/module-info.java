module site.khouya.teachermanager {
    requires javafx.controls;
    requires javafx.fxml;
    requires java.sql;


    opens site.khouya.teachermanager to javafx.fxml;
    opens site.khouya.teachermanager.metier to javafx.base;
    exports site.khouya.teachermanager;
}