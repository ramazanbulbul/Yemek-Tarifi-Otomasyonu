package application;

import java.net.URL;
import java.util.ResourceBundle;

import DomainObject.Recipe;
import DomainObject.User;
import business.RecipeBusiness;
import dto.recipe.EditRecipeRequest;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import utility.StageManager;

public class EditRecipeController {

	public User _user;
	public Recipe _recipe;
    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    @FXML
    private Button btnEdit;

    @FXML
    public TextArea txtDescr;

    @FXML
    public TextArea txtImageUrl;

    @FXML
    public TextField txtTitle;

    @FXML
    void btnEdit_onClick(ActionEvent event) {
    	RecipeBusiness business= new RecipeBusiness();
    	EditRecipeRequest request = new EditRecipeRequest();
    	request.setDescr(txtDescr.getText());
    	request.setImageUrl(txtImageUrl.getText());
    	request.setName(txtTitle.getText());
    	request.setId(_recipe.getId());
    	business.EditRecipe(request);
    	
    	StageManager.Close(txtDescr.getScene());
    }

    @FXML
    void initialize() {
        assert btnEdit != null : "fx:id=\"btnEdit\" was not injected: check your FXML file 'EditRecipe.fxml'.";
        assert txtDescr != null : "fx:id=\"txtDescr\" was not injected: check your FXML file 'EditRecipe.fxml'.";
        assert txtImageUrl != null : "fx:id=\"txtImageUrl\" was not injected: check your FXML file 'EditRecipe.fxml'.";
        assert txtTitle != null : "fx:id=\"txtTitle\" was not injected: check your FXML file 'EditRecipe.fxml'.";

    }

}
