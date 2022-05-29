package application;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.image.ImageView;

public class ForgetPasswordController {

    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    @FXML
    private Button btnSend;

    @FXML
    private ImageView imgLogo;

    @FXML
    private TextField txtEmail;

    @FXML
    void btnSend_onClick(ActionEvent event) {

    }

    @FXML
    void initialize() {
        assert btnSend != null : "fx:id=\"btnSend\" was not injected: check your FXML file 'ForgetPassword.fxml'.";
        assert imgLogo != null : "fx:id=\"imgLogo\" was not injected: check your FXML file 'ForgetPassword.fxml'.";
        assert txtEmail != null : "fx:id=\"txtEmail\" was not injected: check your FXML file 'ForgetPassword.fxml'.";

    }

}
