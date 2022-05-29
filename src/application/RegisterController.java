package application;

import java.net.URL;
import java.util.ResourceBundle;

import business.UserBusiness;
import dto.user.AddUserRequest;
import dto.user.GetUserByUsernameRequest;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import utility.AlertManager;

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
    private TextField txtUsername;

    @FXML
    private TextField txtPass;

    @FXML
    void btnRegister_onClick(ActionEvent event) {
    	if(txtUsername.getText().isEmpty() ||txtEmail.getText().isEmpty() ||txtPass.getText().isEmpty() ||txtCPass.getText().isEmpty()) {
    		AlertManager.ShowAlert(AlertType.ERROR, "Hata!", "Deðerler boþ býrakýlamaz!");
    		imgLogo.setImage(new Image("http://epetiste-001-site1.etempurl.com/javafx/warning.png"));
    		return;
		}
    	if (!txtPass.getText().equals(txtCPass.getText())) {
    		AlertManager.ShowAlert(AlertType.ERROR, "Hata!", "Þifreler uyuþmuyor!");
    		imgLogo.setImage(new Image("http://epetiste-001-site1.etempurl.com/javafx/warning.png"));
			return;
		}
    	if (!txtEmail.getText().contains("@")) {
    		AlertManager.ShowAlert(AlertType.ERROR, "Hata!", "Mail adresini düzgün bir þekilde giriniz!");
    		imgLogo.setImage(new Image("http://epetiste-001-site1.etempurl.com/javafx/warning.png"));
    		return;
		}
    	
    	
    	
    	UserBusiness ub = new UserBusiness();
    	if (ub.GetUserByUsername(new GetUserByUsernameRequest(txtUsername.getText())).size() > 0) {
    		AlertManager.ShowAlert(AlertType.ERROR, "Hata!", "Ayný kullanýcý adýna sahip baþka bir kullanýcý bulunmakta lütfen kullanýcý adýnýzý deðiþtiriniz!!");
    		imgLogo.setImage(new Image("http://epetiste-001-site1.etempurl.com/javafx/warning.png"));
			return;
		}
    	imgLogo.setImage(new Image("http://epetiste-001-site1.etempurl.com/javafx/checked.png"));
		AddUserRequest request = new AddUserRequest();
		request.setEmail(txtEmail.getText());
		request.setPassword(txtPass.getText());
		request.setUsername(txtUsername.getText());
		ub.AddUser(request);
		
    }

    @FXML
    void initialize() {
        assert btnRegister != null : "fx:id=\"btnRegister\" was not injected: check your FXML file 'Register.fxml'.";
        assert imgLogo != null : "fx:id=\"imgLogo\" was not injected: check your FXML file 'Register.fxml'.";
        assert txtCPass != null : "fx:id=\"txtCPass\" was not injected: check your FXML file 'Register.fxml'.";
        assert txtEmail != null : "fx:id=\"txtEmail\" was not injected: check your FXML file 'Register.fxml'.";
        assert txtUsername != null : "fx:id=\"txtUsername\" was not injected: check your FXML file 'Register.fxml'.";
        assert txtPass != null : "fx:id=\"txtPass\" was not injected: check your FXML file 'Register.fxml'.";

    }

}
