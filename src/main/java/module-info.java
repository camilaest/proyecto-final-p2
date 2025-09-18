module org.uniquindio.edu.co.poo.sistemadeenviosp2 {
    requires javafx.controls;
    requires javafx.fxml;

    requires org.controlsfx.controls;

    opens org.uniquindio.edu.co.poo.sistemadeenviosp2 to javafx.fxml;
    exports org.uniquindio.edu.co.poo.sistemadeenviosp2;
}