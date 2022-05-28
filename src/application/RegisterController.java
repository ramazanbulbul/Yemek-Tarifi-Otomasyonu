package application;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.image.ImageView;

public class RegisterController {

    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    @FXML
    private Button btnRegister;

    @FXML
    private ImageView imgLogo;

    @FXML
    private TextField txtCPass;

    @FXML
    private TextField txtEmail;

    @FXML
    private TextField txtNickname;

    @FXML
    private TextField txtPass;

    @FXML
    void btnRegister_onClick(ActionEvent event) {

    }

    @FXML
    void initialize() {
        assert btnRegister != null : "fx:id=\"btnRegister\" was not injected: check your FXML file 'Register.fxml'.";
        assert imgLogo != null : "fx:id=\"imgLogo\" was not injected: check your FXML file 'Register.fxml'.";
        assert txtCPass != null : "fx:id=\"txtCPass\" was not injected: check your FXML file 'Register.fxml'.";
        assert txtEmail != null : "fx:id=\"txtEmail\" was not injected: check your FXML file 'Register.fxml'.";
        assert txtNickname != null : "fx:id=\"txtNickname\" was not injected: check your FXML file 'Register.fxml'.";
        assert txtPass != null : "fx:id=\"txtPass\" was not injected: check your FXML file 'Register.fxml'.";

    }

}
