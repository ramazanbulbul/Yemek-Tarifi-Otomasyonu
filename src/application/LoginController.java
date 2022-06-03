package application;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

import DomainObject.User;
import business.UserBusiness;
import dto.user.CheckLoginRequest;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.control.Button;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import utility.AlertManager;
import utility.StageManager;

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
    private PasswordField txtPass;

    @FXML
    void btnForgetPass_onClick(ActionEvent event) {
    	
    	try {
    		Parent root = FXMLLoader.load(getClass().getResource("fxml/ForgetPassword.fxml"));
	    	StageManager.Show(root, 400,450);
		} catch (IOException e) {
			e.printStackTrace();
		}
    }

    @FXML
    void btnLogin_onClick(ActionEvent event) {
    	if (txtEmail.getText().isEmpty() || txtPass.getText().isEmpty()) {
    		AlertManager.ShowAlert(AlertType.ERROR, "Hata!", "Deðerler boþ býrakýlamaz!");
    		imgLogo.setImage(new Image("http://epetiste-001-site1.etempurl.com/javafx/warning.png"));
    		return;
		}
    	UserBusiness ub = new UserBusiness();
    	CheckLoginRequest request = new CheckLoginRequest();
    	request.setEmail(txtEmail.getText());
    	request.setPassword(txtPass.getText());
    	User user = ub.CheckLogin(request);
    	if (user != null) {
    		imgLogo.setImage(new Image("http://epetiste-001-site1.etempurl.com/javafx/checked.png"));
    		
    		try {
    			FXMLLoader loader = new FXMLLoader(getClass().getResource("fxml/Homepage.fxml"));
    	    	Parent root = loader.load();
    	    	HomepageController controller = loader.getController();
    	    	controller._user = user;
    	    	if (user.getPermission() == 0) {
					controller.btnAdmin.setVisible(false);
				}
    	    	StageManager.Show(root, 400,600, false, false); 
    	    	
    	    	
    	    	StageManager.Close(btnLogin.getScene());
    		} catch (IOException e) {
    			e.printStackTrace();
    		}
    		
    		
		}else {
			AlertManager.ShowAlert(AlertType.ERROR, "Hata!", "Epostanýz veya þifreniz yanlýþ!");
    		imgLogo.setImage(new Image("http://epetiste-001-site1.etempurl.com/javafx/warning.png"));
    		return;
		}
    }

    @FXML
    void btnRegister_onClick(ActionEvent event) {
    	
		try {
	    	Parent root = FXMLLoader.load(getClass().getResource("fxml/Register.fxml"));
	    	StageManager.Show(root, 400,450); 
		} catch (IOException e) {
			e.printStackTrace();
		}
    	
    	
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
