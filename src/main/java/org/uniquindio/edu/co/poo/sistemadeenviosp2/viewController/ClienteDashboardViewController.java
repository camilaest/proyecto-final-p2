package org.uniquindio.edu.co.poo.sistemadeenviosp2.viewController;

import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.*;
import javafx.stage.FileChooser;
import org.apache.pdfbox.pdmodel.PDDocument;
import org.apache.pdfbox.pdmodel.PDPage;
import org.apache.pdfbox.pdmodel.PDPageContentStream;
import org.apache.pdfbox.pdmodel.font.PDType1Font;
import org.uniquindio.edu.co.poo.sistemadeenviosp2.App;
import org.uniquindio.edu.co.poo.sistemadeenviosp2.model.*;

import java.io.File;
import java.io.IOException;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.UUID;

public class ClienteDashboardViewController {
    private App app;
    private DataBase db;
    private Cliente cliente;

    private final ObservableList<Direccion> direcciones = FXCollections.observableArrayList();
    private final ObservableList<Pago> pagos = FXCollections.observableArrayList();

    // Header
    @FXML private Label lblMontoCliente;

    @FXML
    private Button btnGenerarPdf;

    @FXML
    void onGenererPdf(ActionEvent event) {
        generarPDF();
    }


    // Direcciones (CRUD)
    @FXML private TableView<Direccion> tblDirecciones;
    @FXML private TableColumn<Direccion, String> colDirId;
    @FXML private TableColumn<Direccion, String> colDirAlias;
    @FXML private TableColumn<Direccion, String> colDirOrigen;
    @FXML private TableColumn<Direccion, String> colDirDestino;
    @FXML private TextField txtAliasDir;
    @FXML private TextField txtOrigenDir;
    @FXML private TextField txtDestinoDir;

    // Solicitar envío (Tarifa)
    @FXML private TextField txtOrigen;
    @FXML private TextField txtDestino;
    @FXML private TextField txtDistancia;
    @FXML private TextField txtPeso;
    @FXML private TextField txtVolumen;
    @FXML private CheckBox chkPrioridad;
    @FXML private Label lblCostoEstimado;
    @FXML private ComboBox<MetodoDePago> cmbMetodoEnvio;

    // Pago manual y consignaciones
    @FXML private TextField txtMontoPago;
    @FXML private ComboBox<MetodoDePago> cmbMetodoPago;
    @FXML private TextField txtConsignar;
    @FXML private Label lblResultadoPago;

    // Historial de pagos
    @FXML private TableView<Pago> tblPagos;
    @FXML private TableColumn<Pago, String> colPagoId;
    @FXML private TableColumn<Pago, String> colPagoFecha;
    @FXML private TableColumn<Pago, String> colPagoMetodo;
    @FXML private TableColumn<Pago, Number> colPagoMonto;
    @FXML private TableColumn<Pago, Number> colPagoTributos;
    @FXML private TableColumn<Pago, Number> colPagoTotal;

    @FXML
    private void initialize(){
        // Direcciones table setup
        if (tblDirecciones != null){
            tblDirecciones.setItems(direcciones);
            if (colDirId != null) colDirId.setCellValueFactory(cell -> new javafx.beans.property.SimpleStringProperty(cell.getValue().getId()));
            if (colDirAlias != null) colDirAlias.setCellValueFactory(cell -> new javafx.beans.property.SimpleStringProperty(cell.getValue().getAlias()));
            if (colDirOrigen != null) colDirOrigen.setCellValueFactory(cell -> new javafx.beans.property.SimpleStringProperty(cell.getValue().getOrigen()));
            if (colDirDestino != null) colDirDestino.setCellValueFactory(cell -> new javafx.beans.property.SimpleStringProperty(cell.getValue().getDestino()));
            tblDirecciones.getSelectionModel().selectedItemProperty().addListener((obs, oldSel, sel) -> {
                if (sel != null){
                    txtAliasDir.setText(sel.getAlias());
                    txtOrigenDir.setText(sel.getOrigen());
                    txtDestinoDir.setText(sel.getDestino());
                }
            });
        }
        // Métodos de pago
        if (cmbMetodoEnvio != null){
            cmbMetodoEnvio.setItems(FXCollections.observableArrayList(MetodoDePago.values()));
            cmbMetodoEnvio.getSelectionModel().select(MetodoDePago.EFECTIVO);
        }
        if (cmbMetodoPago != null){
            cmbMetodoPago.setItems(FXCollections.observableArrayList(MetodoDePago.values()));
            cmbMetodoPago.getSelectionModel().select(MetodoDePago.EFECTIVO);
        }
        // Pagos table
        if (tblPagos != null){
            tblPagos.setItems(pagos);
            if (colPagoId != null) colPagoId.setCellValueFactory(c -> new javafx.beans.property.SimpleStringProperty(c.getValue().getIdPago()));
            if (colPagoFecha != null) colPagoFecha.setCellValueFactory(c -> new javafx.beans.property.SimpleStringProperty(String.valueOf(c.getValue().getFechaPago())));
            if (colPagoMetodo != null) colPagoMetodo.setCellValueFactory(c -> new javafx.beans.property.SimpleStringProperty(String.valueOf(c.getValue().getMetodoDePago())));
            if (colPagoMonto != null) colPagoMonto.setCellValueFactory(c -> new javafx.beans.property.SimpleLongProperty(c.getValue().getMonto()));
            if (colPagoTributos != null) colPagoTributos.setCellValueFactory(c -> new javafx.beans.property.SimpleLongProperty(c.getValue().getTributos()));
            if (colPagoTotal != null) colPagoTotal.setCellValueFactory(c -> new javafx.beans.property.SimpleLongProperty(c.getValue().getTotal()));
        }
        // Listeners para recalcular costo estimado
        ChangeListener<String> recalcListener = (ObservableValue<? extends String> obs, String o, String n) -> actualizarCostoEstimado();
        if (txtDistancia != null) txtDistancia.textProperty().addListener(recalcListener);
        if (txtPeso != null) txtPeso.textProperty().addListener(recalcListener);
        if (txtVolumen != null) txtVolumen.textProperty().addListener(recalcListener);
        if (chkPrioridad != null) chkPrioridad.selectedProperty().addListener((o, ov, nv) -> actualizarCostoEstimado());
    }

    public void setApp(App app){
        this.app = app;
    }
    public void setDataBase(DataBase db){
        this.db = db;
        loadUser();
    }

    private void loadUser(){
        if (app == null) return;
        if (app.getCurrentUser() instanceof Cliente c){
            this.cliente = c;
            direcciones.setAll(cliente.getDirecciones());
            if (tblDirecciones != null) tblDirecciones.setItems(direcciones);
            pagos.setAll(cliente.getPagos());
            refreshSaldo();
        }
    }

    private void refreshSaldo(){
        if (lblMontoCliente != null && cliente != null){
            lblMontoCliente.setText("$ "+cliente.getMonto());
        }
    }

    // CRUD Direcciones
    @FXML
    private void onAgregarDireccion(){
        String alias = safeText(txtAliasDir);
        String origen = safeText(txtOrigenDir);
        String destino = safeText(txtDestinoDir);
        if (origen.isBlank()){
            new Alert(Alert.AlertType.WARNING, "El origen es requerido", ButtonType.OK).showAndWait();
            return;
        }
        Direccion d = new Direccion.Builder()
                .id(UUID.randomUUID().toString())
                .alias(alias.isBlank()?"Sin alias":alias)
                .origen(origen)
                .destino(destino)
                .build();
        cliente.setDirecciones(d);
        db.agregarDireccion(d);
        direcciones.add(d);
        limpiarCamposDireccion();
    }

    @FXML
    private void onEditarDireccion(){
        Direccion sel = tblDirecciones.getSelectionModel().getSelectedItem();
        if (sel == null){
            new Alert(Alert.AlertType.WARNING, "Seleccione una dirección", ButtonType.OK).showAndWait();
            return;
        }
        String alias = safeText(txtAliasDir);
        String origen = safeText(txtOrigenDir);
        String destino = safeText(txtDestinoDir);
        Direccion actualizada = new Direccion.Builder()
                .id(sel.getId())
                .alias(alias.isBlank()?"Sin alias":alias)
                .origen(origen)
                .destino(destino)
                .build();
        // actualizar en DataBase
        db.actualizarDireccion(sel.getId(), actualizada);
        // actualizar en la lista del cliente
        for (Direccion d : cliente.getDirecciones()){
            if (d.getId().equals(sel.getId())){
                d.setAlias(actualizada.getAlias());
                d.setOrigen(actualizada.getOrigen());
                d.setDestino(actualizada.getDestino());
                break;
            }
        }
        // refrescar tabla
        int idx = direcciones.indexOf(sel);
        if (idx >= 0){
            direcciones.set(idx, actualizada);
        }
        limpiarCamposDireccion();
    }

    @FXML
    private void onEliminarDireccion(){
        Direccion sel = tblDirecciones.getSelectionModel().getSelectedItem();
        if (sel == null){
            new Alert(Alert.AlertType.WARNING, "Seleccione una dirección", ButtonType.OK).showAndWait();
            return;
        }
        if (db.eliminarDireccion(sel.getId())){
            // eliminar también de cliente
            cliente.getDirecciones().removeIf(d -> d.getId().equals(sel.getId()));
            direcciones.remove(sel);
            limpiarCamposDireccion();
            new Alert(Alert.AlertType.INFORMATION, "Dirección eliminada", ButtonType.OK).showAndWait();
        } else {
            new Alert(Alert.AlertType.ERROR, "No se pudo eliminar", ButtonType.OK).showAndWait();
        }
    }

    private void limpiarCamposDireccion(){
        if (txtAliasDir != null) txtAliasDir.clear();
        if (txtOrigenDir != null) txtOrigenDir.clear();
        if (txtDestinoDir != null) txtDestinoDir.clear();
        tblDirecciones.getSelectionModel().clearSelection();
    }

    private String safeText(TextField tf){
        return tf != null && tf.getText() != null ? tf.getText().trim() : "";
    }

    // Tarifa
    private void actualizarCostoEstimado(){
        try {
            double distancia = parseDoubleSafe(txtDistancia.getText());
            double peso = parseDoubleSafe(txtPeso.getText());
            double volumen = parseDoubleSafe(txtVolumen.getText());
            boolean prioridad = chkPrioridad != null && chkPrioridad.isSelected();
            Tarifa t = new Tarifa();
            double costo = t.calcularCostoEstimado(distancia, peso, volumen, prioridad);
            if (lblCostoEstimado != null) lblCostoEstimado.setText("$ "+(long)costo);
        } catch (Exception e){
            if (lblCostoEstimado != null) lblCostoEstimado.setText("$ 0");
        }
    }

    private double parseDoubleSafe(String s){
        if (s == null || s.isBlank()) return 0d;
        return Double.parseDouble(s.trim());
    }

    @FXML
    private void onSolicitarEnvio(){
        try {
            String origen = safeText(txtOrigen);
            String destino = safeText(txtDestino);
            double distancia = parseDoubleSafe(txtDistancia.getText());
            double peso = parseDoubleSafe(txtPeso.getText());
            double volumen = parseDoubleSafe(txtVolumen.getText());
            boolean prioridad = chkPrioridad != null && chkPrioridad.isSelected();
            MetodoDePago metodo = cmbMetodoEnvio != null ? cmbMetodoEnvio.getValue() : MetodoDePago.EFECTIVO;
            if (metodo == null) metodo = MetodoDePago.EFECTIVO;
            // Calcular costo con Tarifa
            Tarifa t = new Tarifa();
            long costoBase = (long) t.calcularCostoEstimado(distancia, peso, volumen, prioridad);
            if (lblCostoEstimado != null) lblCostoEstimado.setText("$ "+costoBase);

            // Cobrar de una vez con tributos (Cliente construye Pago con tributos)
            Pago pago = cliente.construirPago(costoBase, metodo);
            pago.setIdPago(UUID.randomUUID().toString());
            pago.setFechaPago(LocalDate.now());
            String resultado = cliente.realizarPago(pago);
            if (!"Pago realizado con éxito".equals(resultado)){
                new Alert(Alert.AlertType.ERROR, resultado, ButtonType.OK).showAndWait();
                return; // no crear envío si no pudo pagar
            }

            Envio envio = new Envio.Builder()
                    .idEnvio(UUID.randomUUID().toString())
                    .direccionOrigen(origen)
                    .direccionDestino(destino)
                    .costo(costoBase)
                    .estadoEnvio(EstadoEnvio.SOLICITADO)
                    .build();
            if (db.agregarEnvio(envio)){
                new Alert(Alert.AlertType.INFORMATION, "Envío solicitado y cobrado exitosamente", ButtonType.OK).showAndWait();
                txtOrigen.clear(); txtDestino.clear();
                if (txtDistancia != null) txtDistancia.clear();
                if (txtPeso != null) txtPeso.clear();
                if (txtVolumen != null) txtVolumen.clear();
                if (chkPrioridad != null) chkPrioridad.setSelected(false);
                actualizarCostoEstimado();
                refreshSaldo();
                pagos.setAll(cliente.getPagos());
            } else {
                new Alert(Alert.AlertType.ERROR, "No se pudo registrar el envío", ButtonType.OK).showAndWait();
            }
        } catch (Exception ex){
            new Alert(Alert.AlertType.ERROR, "Datos inválidos: "+ex.getMessage(), ButtonType.OK).showAndWait();
        }
    }

    @FXML
    private void onConsignar(){
        try {
            long valor = Long.parseLong(txtConsignar.getText());
            String res = cliente.consignar(valor);
            refreshSaldo();
            new Alert(Alert.AlertType.INFORMATION, res, ButtonType.OK).showAndWait();
            txtConsignar.clear();
        } catch (Exception e){
            new Alert(Alert.AlertType.ERROR, "Valor inválido", ButtonType.OK).showAndWait();
        }
    }

    @FXML
    private void onPagar(){
        try {
            long base = Long.parseLong(txtMontoPago.getText());
            MetodoDePago metodo = cmbMetodoPago != null ? cmbMetodoPago.getValue() : MetodoDePago.EFECTIVO;
            if (metodo == null) metodo = MetodoDePago.EFECTIVO;
            Pago pago = cliente.construirPago(base, metodo);
            pago.setIdPago(UUID.randomUUID().toString());
            pago.setFechaPago(LocalDate.now());
            String resultado = cliente.realizarPago(pago);
            lblResultadoPago.setText(resultado);
            if ("Pago realizado con éxito".equals(resultado)){
                refreshSaldo();
                pagos.setAll(cliente.getPagos());
            }
            txtMontoPago.clear();
        } catch (Exception ex){
            lblResultadoPago.setText("Monto inválido");
        }
    }

    @FXML
    private void onLogout(){
        app.openIniciarSesion();
    }




    private void generarPDF() {
        FileChooser fileChooser = new FileChooser();
        fileChooser.setTitle("Guardar historial de pagos");
        fileChooser.getExtensionFilters().add(new FileChooser.ExtensionFilter("PDF", "*.pdf"));
        fileChooser.setInitialFileName("historial_pagos.pdf");

        File file = fileChooser.showSaveDialog(null);
        if (file == null) return;

        ObservableList<Pago> pagos = tblPagos.getItems();
        if (pagos.isEmpty()) return;

        GeneradorDocumentoPDF generador = new GeneradorHistorialPagosPDF(new ArrayList<>(pagos));

        try {
            generador.generar(file);  // Template Method
            System.out.println("PDF generado con Template Method");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    }
















