package application;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.image.ImageView;

public class LoginController {

    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    @FXML
    private Button btnForgetPass;

    @FXML
    private Button btnLogin;

    @FXML
    private Button btnRegister;

    @FXML
    private ImageView imgLogo;

    @FXML
    private TextField txtEmail;

    @FXML
    private TextField txtPass;

    @FXML
    void btnForgetPass_onClick(ActionEvent event) {

    }

    @FXML
    void btnLogin_onClick(ActionEvent event) {

    }

    @FXML
    void btnRegister_onClick(ActionEvent event) {

    }

    @FXML
    void initialize() {
        assert btnForgetPass != null : "fx:id=\"btnForgetPass\" was not injected: check your FXML file 'Login.fxml'.";
        assert btnLogin != null : "fx:id=\"btnLogin\" was not injected: check your FXML file 'Login.fxml'.";
        assert btnRegister != null : "fx:id=\"btnRegister\" was not injected: check your FXML file 'Login.fxml'.";
        assert imgLogo != null : "fx:id=\"imgLogo\" was not injected: check your FXML file 'Login.fxml'.";
        assert txtEmail != null : "fx:id=\"txtEmail\" was not injected: check your FXML file 'Login.fxml'.";
        assert txtPass != null : "fx:id=\"txtPass\" was not injected: check your FXML file 'Login.fxml'.";

    }
}
