package BankATM;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;

public class Main extends Application {

    @Override
    public void start(Stage primaryStage) throws IOException {                              //stage-et hozza létre amelyen megjelenítésre kerül a scene
        Parent root = FXMLLoader.load(getClass().getResource("/login.fxml"));      //login.fxml fájlt tölti be a resources-ból
        Scene scene = new Scene(root);
        primaryStage.setTitle("Bejelentkezés");             //az ablak címsora
        primaryStage.setResizable(false);                   //nem átméretezhető
        primaryStage.setScene(scene);
        primaryStage.show();
    }


    public static void main(String[] args) {
        launch(args);
    }
}
