package application;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

import DomainObject.Recipe;
import DomainObject.User;
import business.RecipeBusiness;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.image.ImageView;
import utility.StageManager;

public class RecipeDetailController {

	public User _user;
	public Recipe _recipe;
    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    @FXML
    public Button btnEdit;

    @FXML
    public Button btnRemove;

    @FXML
    public ImageView imgImage;

    @FXML
    public Label lblDescr;

    @FXML
    public Label lblTitle;

    @FXML
    void btnEdit_onClick(ActionEvent event) {
    	try {
			FXMLLoader loader = new FXMLLoader(getClass().getResource("fxml/EditRecipe.fxml"));
			Parent root = loader.load();
			EditRecipeController controller = loader.getController();
			controller._user = _user;
			controller._recipe = _recipe;
			controller.txtDescr.setText(_recipe.getDescr());
			controller.txtTitle.setText(_recipe.getName());
			controller.txtImageUrl.setText(_recipe.getImageUrl());
			StageManager.Show(root, 400, 600);
		} catch (IOException e) {
			e.printStackTrace();
		}
    }

    @FXML
    void btnRemove_onClick(ActionEvent event) {
    	RecipeBusiness business = new RecipeBusiness();
    	business.RemoveRecipe(_recipe.getId());
    }

    @FXML
    void initialize() {
        assert btnEdit != null : "fx:id=\"btnEdit\" was not injected: check your FXML file 'RecipeDetail.fxml'.";
        assert btnRemove != null : "fx:id=\"btnRemove\" was not injected: check your FXML file 'RecipeDetail.fxml'.";
        assert imgImage != null : "fx:id=\"imgImage\" was not injected: check your FXML file 'RecipeDetail.fxml'.";
        assert lblDescr != null : "fx:id=\"lblDescr\" was not injected: check your FXML file 'RecipeDetail.fxml'.";
        assert lblTitle != null : "fx:id=\"lblTitle\" was not injected: check your FXML file 'RecipeDetail.fxml'.";

    }

}
