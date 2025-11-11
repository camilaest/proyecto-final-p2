package org.uniquindio.edu.co.poo.sistemadeenviosp2;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;
import org.uniquindio.edu.co.poo.sistemadeenviosp2.controller.PrimaryController;
import org.uniquindio.edu.co.poo.sistemadeenviosp2.model.DataBase;
import org.uniquindio.edu.co.poo.sistemadeenviosp2.viewController.CrudClienteViewController;
import org.uniquindio.edu.co.poo.sistemadeenviosp2.viewController.IniciarSesionViewController;
import org.uniquindio.edu.co.poo.sistemadeenviosp2.viewController.PrimaryViewController;

import java.io.IOException;

public class App extends Application {

    private Stage primaryStage;
    private final DataBase db = new DataBase();
    private org.uniquindio.edu.co.poo.sistemadeenviosp2.model.Usuario currentUser;

    public DataBase getDb(){
        return db;
    }

    public void setCurrentUser(org.uniquindio.edu.co.poo.sistemadeenviosp2.model.Usuario user){
        this.currentUser = user;
    }
    public org.uniquindio.edu.co.poo.sistemadeenviosp2.model.Usuario getCurrentUser(){
        return currentUser;
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







    public void openIniciarSesion() {
        try {
            FXMLLoader loader = new FXMLLoader(getClass().getResource(
                    "/org/uniquindio/edu/co/poo/sistemadeenviosp2/iniciarSesion.fxml"));
            Parent root = loader.load();

            IniciarSesionViewController controller = loader.getController();
            controller.setApp(this);
            controller.setDataBase(db);

            Scene scene = new Scene(root);
            scene.getStylesheets().add(getClass().getResource("/org/uniquindio/edu/co/poo/sistemadeenviosp2/styles.css").toExternalForm());
            primaryStage.setScene(scene);
            primaryStage.show();

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void openCrudCliente() {
        try {
            FXMLLoader loader = new FXMLLoader(getClass().getResource(
                    "/org/uniquindio/edu/co/poo/sistemadeenviosp2/crudCliente.fxml"));
            Parent root = loader.load();

            CrudClienteViewController controller= loader.getController();
            controller.setApp(this);
            controller.setDataBase(db);

            Scene scene = new Scene(root);
            scene.getStylesheets().add(getClass().getResource("/org/uniquindio/edu/co/poo/sistemadeenviosp2/styles.css").toExternalForm());
            primaryStage.setScene(scene);
            primaryStage.show();

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void openAdminDashboard() {
        try {
            FXMLLoader loader = new FXMLLoader(getClass().getResource(
                    "/org/uniquindio/edu/co/poo/sistemadeenviosp2/adminDashboard.fxml"));
            Parent root = loader.load();
            org.uniquindio.edu.co.poo.sistemadeenviosp2.viewController.AdminDashboardViewController controller = loader.getController();
            controller.setApp(this);
            controller.setDataBase(db);
            Scene scene = new Scene(root);
            scene.getStylesheets().add(getClass().getResource("/org/uniquindio/edu/co/poo/sistemadeenviosp2/styles.css").toExternalForm());
            primaryStage.setScene(scene);
            primaryStage.show();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void openRepartidorDashboard() {
        try {
            FXMLLoader loader = new FXMLLoader(getClass().getResource(
                    "/org/uniquindio/edu/co/poo/sistemadeenviosp2/repartidorDashboard.fxml"));
            Parent root = loader.load();
            org.uniquindio.edu.co.poo.sistemadeenviosp2.viewController.RepartidorDashboardViewController controller = loader.getController();
            controller.setApp(this);
            controller.setDataBase(db);
            Scene scene = new Scene(root);
            scene.getStylesheets().add(getClass().getResource("/org/uniquindio/edu/co/poo/sistemadeenviosp2/styles.css").toExternalForm());
            primaryStage.setScene(scene);
            primaryStage.show();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void openClienteDashboard() {
        try {
            FXMLLoader loader = new FXMLLoader(getClass().getResource(
                    "/org/uniquindio/edu/co/poo/sistemadeenviosp2/clienteDashboard.fxml"));
            Parent root = loader.load();
            org.uniquindio.edu.co.poo.sistemadeenviosp2.viewController.ClienteDashboardViewController controller = loader.getController();
            controller.setApp(this);
            controller.setDataBase(db);
            Scene scene = new Scene(root);
            scene.getStylesheets().add(getClass().getResource("/org/uniquindio/edu/co/poo/sistemadeenviosp2/styles.css").toExternalForm());
            primaryStage.setScene(scene);
            primaryStage.show();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) { launch(args); }

    public void inicializarData(){

    }
}
