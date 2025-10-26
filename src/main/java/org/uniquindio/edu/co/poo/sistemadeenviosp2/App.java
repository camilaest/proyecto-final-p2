package org.uniquindio.edu.co.poo.sistemadeenviosp2;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;
import org.uniquindio.edu.co.poo.sistemadeenviosp2.controller.PrimaryController;
import org.uniquindio.edu.co.poo.sistemadeenviosp2.model.Administrador;
import org.uniquindio.edu.co.poo.sistemadeenviosp2.model.Cliente;
import org.uniquindio.edu.co.poo.sistemadeenviosp2.model.DataBase;
import org.uniquindio.edu.co.poo.sistemadeenviosp2.viewController.CrudClienteViewController;
import org.uniquindio.edu.co.poo.sistemadeenviosp2.viewController.PrimaryViewController;

import java.io.IOException;

public class App extends Application {

    private Stage primaryStage;
    private final DataBase db = new DataBase();

    public DataBase getDb(){
        return db;
    }

    @Override
    public void start(Stage stage) throws Exception {
        this.primaryStage = stage;
        this.primaryStage.setTitle("Sistema de Envíos");
        openPrimary();
    }


    public void openPrimary() {
        inicializarData();
        try {
            FXMLLoader loader = new FXMLLoader();
            loader.setLocation(App.class.getResource("primary.fxml"));
            AnchorPane rootLayout = (AnchorPane) loader.load();
            PrimaryViewController primaryViewController = loader.getController();
            PrimaryController primaryController = new PrimaryController(db);
            primaryViewController.setPrimaryController(primaryController);
            primaryViewController.setApp(this);


            Scene scene = new Scene(rootLayout);
            primaryStage.setScene(scene);
            primaryStage.show();
        } catch (IOException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }}







    public void openCrudCliente() {
        try {
            FXMLLoader loader = new FXMLLoader(getClass().getResource(
                    "/org/uniquindio/edu/co/poo/sistemadeenviosp2/crudCliente.fxml"));
            Parent root = loader.load();

            CrudClienteViewController controller = loader.getController();
            controller.setApp(this);
            controller.setDataBase(db);

            Scene scene = new Scene(root);
            primaryStage.setScene(scene);
            primaryStage.show();

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) { launch(args); }

    public void inicializarData(){
        Administrador admin1 = new Administrador("Maria", "123", "300273", "maria@", 20, "mar57", "666");
        Cliente cliente1 = new Cliente ("santiago", "444", "555", "santi@", 24, "santi21", "2021");
        db.agregarCliente(cliente1);



    }
}
