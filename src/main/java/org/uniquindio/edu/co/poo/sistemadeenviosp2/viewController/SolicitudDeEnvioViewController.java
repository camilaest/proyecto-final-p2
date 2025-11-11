package org.uniquindio.edu.co.poo.sistemadeenviosp2.viewController;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.*;
import org.uniquindio.edu.co.poo.sistemadeenviosp2.App;
import org.uniquindio.edu.co.poo.sistemadeenviosp2.model.*;

import java.util.ArrayList;

public class SolicitudDeEnvioViewController {

    private App app;
    private DataBase db;
    private Cliente cliente;

    Tarifa tarifa = new Tarifa();
    private IEnvio envioBase;


    @FXML
    private Button btnCalcularTarifa;

    @FXML
    private Button btnRegresar;
    @FXML
    private TableColumn<Paquete, Double> columPeso;

    @FXML
    private TableColumn<Paquete, Double> columValor;

    @FXML
    private TableColumn<Paquete, Double> columVolumen;
    @FXML
    private TableView<Paquete> tblListaPaquetes;
    @FXML
    void onRegresar(ActionEvent event) {
        app.openFuncionesCliente(cliente);

    }

    @FXML
    private CheckBox chkConSeguro;

    @FXML
    private CheckBox chkFirma;

    @FXML
    private CheckBox chkFragil;

    @FXML
    private CheckBox chkPrioridad;

    @FXML
    private Label lblDescripcion;

    @FXML
    private TextField txtValorPaquete;




    @FXML
    void onAplicarDecoradores(ActionEvent event) {
        // contruir objeto
        IEnvio envio = envioBase;
        Tarifa tarifa= db.getTarifa();
        if (chkPrioridad.isSelected()) envio = new EnvioConPrioridad(envio);
        if (chkConSeguro.isSelected()) envio = new EnvioConSeguro(envio);
        if (chkFirma.isSelected()) envio = new EnvioConFirmaRequerida(envio);


        lblDescripcion.setText(envio.getDescripcion());
        String ciudadSeleccionada = txtDireccionDestino.getValue();
        //usar objeto
        double costoparcialenvio=envio.calcularCosto();
        //double costotarifa= tarifa.calcularCosto(envio.getListapaquetes, obtenerDistancia(txtDireccionDestino.getValue()));
        //double costototal= costoparcialenvio+ costotarifa;
        //envio.setCostototal= costototal;




        txtTarifaTotal.setText("$" + envio.calcularCosto() * obtenerDistancia(ciudadSeleccionada));

    }

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



        Tarifa tarifa = new Tarifa(2000, 1000, 50);
        ArrayList<Paquete> listaPaquetes = new ArrayList<>();

        listaPaquetes.add(new Paquete(2, 2,  1000));
        //listaPaquetes.add(new Paquete(3, 2, 10));
        envioBase = new EnvioBase("11", tarifa, listaPaquetes);


        txtDireccionDestino.getItems().addAll("Medellin", "Cali", "Quindio");
        txtDireccionDestino.setValue("Medellin");
        //btnCalcularTarifa.setOnAction(e -> calcularTarifa());



        txtDireccionDestino.setOnAction(event -> {
            String ciudadSeleccionada = txtDireccionDestino.getValue();
            double distancia = obtenerDistancia(ciudadSeleccionada);
            txtDistanciaTotal.setText(distancia + " km");
        });
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
