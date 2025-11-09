package org.uniquindio.edu.co.poo.sistemadeenviosp2.viewController;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.*;
import org.uniquindio.edu.co.poo.sistemadeenviosp2.App;
import org.uniquindio.edu.co.poo.sistemadeenviosp2.model.DataBase;
import org.uniquindio.edu.co.poo.sistemadeenviosp2.model.Disponibilidad;
import org.uniquindio.edu.co.poo.sistemadeenviosp2.model.Tarifa;

public class SolicitudDeEnvioViewController {

    private App app;
    private DataBase db;

    Tarifa tarifa = new Tarifa();


    @FXML
    private Button btnCalcularTarifa;

    @FXML
    private RadioButton btnPrioridad;
    @FXML
    private TextField txtPeso;
    @FXML
    private TextField txtVolumen;

    @FXML
    private Label lblDireccionDestino;

    @FXML
    private Label lblDistancia;

    @FXML
    private Label lblDoreccionDestino;

    @FXML
    private Label lblTarifa;

    @FXML
    private TextField txtDistanciaTotal;

    @FXML
    private TextField txtTarifaTotal;
    @FXML
    private ComboBox<String> txtDireccionDestino;

    @FXML
    void onCalcularTarifa(ActionEvent event) {
         SolicitudDeEnvioViewController solicitud = new SolicitudDeEnvioViewController();
         Tarifa tarifa = new Tarifa();

    }

    @FXML
    public void initialize() {
        txtDireccionDestino.getItems().addAll("Medellin", "Cali", "Quindio");
        txtDireccionDestino.setValue("Medellin");
        btnCalcularTarifa.setOnAction(e -> calcularTarifa());


        txtDireccionDestino.setOnAction(event -> {
            String ciudadSeleccionada = txtDireccionDestino.getValue();
            double distancia = obtenerDistancia(ciudadSeleccionada);
            txtDistanciaTotal.setText(distancia + " km");
        });
    }

    private void calcularTarifa() {

        String ciudadSeleccionada = txtDireccionDestino.getValue();
        double distancia = obtenerDistancia(ciudadSeleccionada);
        double peso = Double.parseDouble(txtPeso.getText());
        double volumen = Double.parseDouble(txtVolumen.getText());
        boolean prioridad = btnPrioridad.isSelected();

        double costo = tarifa.calcularCostoEstimado(distancia, peso, volumen, prioridad);

        txtTarifaTotal.setText(String.valueOf(costo));
    }


    private double obtenerDistancia(String ciudad) {
        switch (ciudad) {
            case "Medellin":
                return 415.0;
            case "Cali":
                return 460.0;
            case "Quindio":
                return 290.0;
            default:
                return 0.0;
        }
    }

    public void setDataBase(DataBase db) {
        this.db = db;
    }

    public void setApp(App app) {
    }
}
