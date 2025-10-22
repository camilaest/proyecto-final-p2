module org.uniquindio.edu.co.poo.sistemadeenviosp2 {
    requires javafx.controls;
    requires javafx.fxml;
    requires org.controlsfx.controls;

    exports org.uniquindio.edu.co.poo.sistemadeenviosp2;
    exports org.uniquindio.edu.co.poo.sistemadeenviosp2.model;

    opens org.uniquindio.edu.co.poo.sistemadeenviosp2.viewController to javafx.fxml;
    opens org.uniquindio.edu.co.poo.sistemadeenviosp2.model to javafx.base;
}