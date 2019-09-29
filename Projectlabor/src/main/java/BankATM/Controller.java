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

    @FXML
    private TextField newpass;

    @FXML
    private TextField oldpass;

    @FXML
    private Label passmsg;

    @FXML
    private Label newpassmsg;

    @FXML
    private Label succes;

    @FXML
    private TextField depositamount;

    @FXML
    private PasswordField DPass;

    @FXML
    private Label dipositinfo;

    @FXML
    private Label DPassInfo;

    @FXML
    private TextField withdrawamount;

    @FXML
    private PasswordField WPass;

    @FXML
    private Label withdrawinfo;

    @FXML
    private Label WPassInfo;

    Model balance = new Model();

    @FXML
    public void login(ActionEvent actionEvent) throws Exception {           //a bejelentkező ablakon lévő bejelentkezés actionevent-je, főmenüt hozza be

    balance.readJson();                                                 //beolvassa a felhasználót és a jelszót
    balance.writeJsonSimpleDemo("balance.json");

    if ((usern.getText()).equals(balance.getUsername()) && (passw.getText()).equals(balance.getPassword())) {
        //ha a beírt felh/jelszó egyezzik az eltaroltal akkor beenged a rendszer

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
    public void passch(ActionEvent event) throws IOException {          //főmenüben lévő opció, jelszó megváltoztatása ablakot hozza be
        Stage stage = new Stage();
        FXMLLoader loader = new FXMLLoader();
        loader.setLocation(getClass().getResource("/jelszo.fxml"));
        loader.load();
        Parent root = loader.getRoot();
        stage.setTitle("Jelszó megváltoztatása");
        stage.getIcons().add(new Image("/atmicon.png"));            //ikont ad hozzá a címsorba
        Scene scene = new Scene(root);
        stage.setScene(scene);
        stage.show();

    }

    @FXML
    public void chgomb(ActionEvent event) throws Exception {
            balance.readJson();                                     //json fájlból beolvassa az adatokat
        if (oldpass.getText().equals(balance.getPassword()) && !((newpass.getText()).isEmpty()) && ((newpass.getText()) != null))  {
            //megnézi, hogy egyenlő a két adat, illetve, hogy üres-e a mező
            balance.setPassword(newpass.getText());
            balance.writeJsonSimpleDemo("balance.json");
            passmsg.setText("");
            newpassmsg.setText("");
            oldpass.clear();
            newpass.clear();
            succes.setText("Jelszó sikeresen megváltozott");
        } else if ((newpass.getText() == null) || newpass.getText().isEmpty()) {        //megnézi, hogy üres ez új jelszó mező
            newpassmsg.setText("Ezt a mezőt nem hagyhatja üresen");
        } else {passmsg.setText("Helytelen jelszó");}
    }

    @FXML
    public void egyenlegNez(ActionEvent event) throws IOException {     //főmenüben lévő opció, egyeneleg ablakot hozza be
        Stage stage = new Stage();
        FXMLLoader loader = new FXMLLoader();
        loader.setLocation(getClass().getResource("/egyenleg.fxml"));
        loader.load();
        Parent root = loader.getRoot();
        stage.setTitle("ATM Egyenleg");
        stage.getIcons().add(new Image("/atmicon.png"));            //ikont ad hozzá a címsorba
        Scene scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
        balance.readJson();                                             //json fájlból beolvassa az adatokat
    }

    @FXML
    public void feltoltNez(ActionEvent event) throws IOException {      //főmenüben lévő opció, pénzfeltöltés ablakot hozza be
        Stage stage = new Stage();
        FXMLLoader loader = new FXMLLoader();
        loader.setLocation(getClass().getResource("/feltolt.fxml"));
        loader.load();
        Parent root = loader.getRoot();
        stage.setTitle("ATM Pénzfeltöltés");
        stage.getIcons().add(new Image("/atmicon.png"));            //ikont ad hozzá a címsorba
        Scene scene = new Scene(root);
        stage.setScene(scene);
        stage.show();

    }

    @FXML
    public void deposit(ActionEvent event) throws Exception {
        balance.readJson();                                         //json fájlból beolvassa az adatokat
        if (depositamount.getText().isEmpty() || Integer.parseInt(depositamount.getText()) < 0) { //amező nem lehet üres és negatív sem
            dipositinfo.setText("Helytelen érték");
        } else {
            if ((DPass.getText()).equals(balance.getPassword())) {
                int a = (balance.getBalance() + Integer.parseInt(depositamount.getText())) ; //meglévő összeghez hozzáadja a beírtat és az a változóba menti
                balance.setBalance(a);              //a számlán lévő összeget beállítja az a értékére
                depositamount.clear();
                DPass.clear();
                dipositinfo.setText("");
                DPassInfo.setText("");
                balance.writeJsonSimpleDemo("balance.json");    //json fájlba beírja az adatokat
            } else {
                DPassInfo.setText("Helytelen jelszó");
            }
        }
    }

    @FXML
    public void leveszNez(ActionEvent event) throws IOException {       //főmenüben lévő opció, pénzfelvétel ablakot hozza be
        Stage stage = new Stage();
        FXMLLoader loader = new FXMLLoader();
        loader.setLocation(getClass().getResource("/levesz.fxml"));
        loader.load();
        Parent root = loader.getRoot();
        stage.setTitle("ATM Pénzfelvétel");
        stage.getIcons().add(new Image("/atmicon.png"));            //ikont ad hozzá a címsorba
        Scene scene = new Scene(root);
        stage.setScene(scene);
        stage.show();

    }

    @FXML
    public void withdraw(ActionEvent event) throws Exception {
            balance.readJson();                                             //json fájlból beolvassa az adatokat
        if (withdrawamount.getText().isEmpty() || Integer.parseInt(withdrawamount.getText()) < 0 || (balance.getBalance() - Integer.parseInt(withdrawamount.getText()) < 0)) {
            //megnézi, hogy üres-e a mező vagy negatív-e szám van-e a mezőben vagy, hogy a számlán lévő összegnél nagyobb a beírt összeg
            withdrawinfo.setText("Helytelen érték");
        } else {
            if ((WPass.getText()).equals(balance.getPassword())) {
                int a = balance.getBalance() - Integer.parseInt(withdrawamount.getText());      //a meglévő összegből kivonja a beírt összeget és az a változóba menti
                balance.setBalance(a);          //a számlán lévő összeget beállítja az a értékére
                withdrawamount.clear();
                WPass.clear();
                withdrawinfo.setText("");
                WPassInfo.setText("");
                balance.writeJsonSimpleDemo("balance.json");
            } else {
                WPassInfo.setText("Helytelen jelszó");

            }
        }
    }

}
