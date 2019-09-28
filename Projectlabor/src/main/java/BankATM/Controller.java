package BankATM;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
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

public void login(ActionEvent actionEvent) throws IOException {          //a bejelentkező ablakon lévő bejelentkezés actionevent-je, főmenüt hozza be
    Stage stage = new Stage();
    FXMLLoader loader = new FXMLLoader();
    loader.setLocation(getClass().getResource("/mainmenu.fxml"));
    loader.load();
    Parent root = loader.getRoot();
    stage.setTitle("ATM Felhasználói oldal");
    Scene scene = new Scene(root);
    stage.setScene(scene);
    stage.show();
}

}
