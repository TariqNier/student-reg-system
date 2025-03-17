module com.tariqtesting {
    requires javafx.controls;
    requires javafx.fxml;
    requires java.desktop;


    opens com.tariqtesting to javafx.fxml;
    exports com.tariqtesting;
}