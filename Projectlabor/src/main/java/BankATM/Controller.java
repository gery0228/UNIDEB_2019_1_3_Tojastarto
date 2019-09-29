package BankATM;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.stage.Stage;

import javafx.event.ActionEvent;
import java.io.IOException;

public class Controller {

    @FXML                               //menükön található komponensek inicializálása
    private TextField usern;

    @FXML
    private PasswordField passw;

    @FXML
    private Button loginb;

    @FXML
    private Label loginmsg;

    Model balance = new Model();

    @FXML
    public void login(ActionEvent actionEvent) throws Exception {           //a bejelentkező ablakon lévő bejelentkezés actionevent-je, főmenüt hozza be

    balance.readJson();                                                 //beolvassa a felhasználót és a jelszót
    balance.writeJsonSimpleDemo("balance.json");

    if ((usern.getText()).equals(balance.getUsername()) && (passw.getText()).equals(balance.getPassword())) {
        Stage stage = new Stage();
        FXMLLoader loader = new FXMLLoader();
        loader.setLocation(getClass().getResource("/mainmenu.fxml"));
        loader.load();
        Parent root = loader.getRoot();
        stage.setTitle("ATM Felhasználói oldal");
        stage.getIcons().add(new Image("/atmicon.png"));
        Scene scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
        usern.clear();              //sikeres bejelentkezés esetét a mezőkből kitörli a beírt karaktereket
        passw.clear();
        loginmsg.setText("");       //ez a "Helytelen felhasználónév vagy jelszó" üzenetet törli ki ha előtte helytelenül adtuk meg az adatokat
    } else {
        loginmsg.setText("Helytelen felhasználónév vagy jelszó");
    }
}

    @FXML
    public void passch(ActionEvent event) throws IOException {      //főmenüben lévő opció, jelszó megváltoztatása ablakot hozza be
        Stage stage = new Stage();
        FXMLLoader loader = new FXMLLoader();
        loader.setLocation(getClass().getResource(""));
        loader.load();
        Parent root = loader.getRoot();
        stage.setTitle("Jelszó megváltoztatása");
        stage.getIcons().add(new Image("/atmicon.png"));
        Scene scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
        balance.readJson();
    }

    @FXML
    public void egyenlegNez(ActionEvent event) throws IOException {     //főmenüben lévő opció, egyeneleg ablakot hozza be
        Stage stage = new Stage();
        FXMLLoader loader = new FXMLLoader();
        loader.setLocation(getClass().getResource(""));
        loader.load();
        Parent root = loader.getRoot();
        stage.setTitle("ATM Egyenleg");
        stage.getIcons().add(new Image("/atmicon.png"));
        Scene scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
        balance.readJson();
    }

    @FXML
    public void feltoltNez(ActionEvent event) throws IOException {      //főmenüben lévő opció, pénzfeltöltés ablakot hozza be
        Stage stage = new Stage();
        FXMLLoader loader = new FXMLLoader();
        loader.setLocation(getClass().getResource(""));
        loader.load();
        Parent root = loader.getRoot();
        stage.setTitle("ATM Pénzfeltöltés");
        stage.getIcons().add(new Image("/atmicon.png"));
        Scene scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
        balance.readJson();
    }

    @FXML
    public void leveszNez(ActionEvent event) throws IOException {       //főmenüben lévő opció, pénzfelvétel ablakot hozza be
        Stage stage = new Stage();
        FXMLLoader loader = new FXMLLoader();
        loader.setLocation(getClass().getResource(""));
        loader.load();
        Parent root = loader.getRoot();
        stage.setTitle("ATM Pénzlevétel");
        stage.getIcons().add(new Image("/atmicon.png"));
        Scene scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
        balance.readJson();
    }
}
