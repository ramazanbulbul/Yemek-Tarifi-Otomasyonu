package application;

import java.net.URL;
import java.util.ResourceBundle;

import DomainObject.User;
import business.RecipeBusiness;
import dto.recipe.AddRecipeRequest;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import utility.StageManager;

public class AddRecipeController {

	public User _user;
    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    @FXML
    private Button btnEkle;

    @FXML
    private TextArea txtImageUrl;

    @FXML
    private TextField txtTitle;

    @FXML
    private TextArea txtDescr;

    @FXML
    void btnEkle_onClick(ActionEvent event) {
    	RecipeBusiness business = new RecipeBusiness();
    	AddRecipeRequest request = new AddRecipeRequest();
    	request.setName(txtTitle.getText());
    	request.setDescr(txtDescr.getText());
    	request.setImageUrl(txtImageUrl.getText());
    	request.setUserId(_user.getId());
    	business.AddRecipe(request);
    	StageManager.Close(txtDescr.getScene());
    }

    @FXML
    void initialize() {

    }

}
