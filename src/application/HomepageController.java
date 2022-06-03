package application;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

import DomainObject.Recipe;
import DomainObject.User;
import business.RecipeBusiness;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.control.Button;
import javafx.scene.control.ListCell;
import javafx.scene.control.ListView;
import javafx.scene.control.TextInputDialog;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import utility.StageManager;

public class HomepageController {

	public User _user;

	@FXML
	private ResourceBundle resources;

	@FXML
	private URL location;

	@FXML
	private Button btnAdd;

	@FXML
	private Button btnHomepage;

	@FXML
	private Button btnProfile;

	@FXML
	private Button btnSearch;

    @FXML
    public Button btnAdmin;
    
	@FXML
	private ListView<Recipe> lstRecipes;

	@FXML
	void btnAdd_onClick(ActionEvent event) {
		try {
			FXMLLoader loader = new FXMLLoader(getClass().getResource("fxml/AddRecipe.fxml"));
			Parent root = loader.load();
			AddRecipeController controller = loader.getController();
			controller._user = _user;
			StageManager.Show(root, 400, 600);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	@FXML
	void btnHomepage_onClick(ActionEvent event) {
		RecipeBusiness business = new RecipeBusiness();
		ObservableList<Recipe> items = FXCollections.observableArrayList();
		for (Recipe item : business.GetAllRecipes()) {
			items.add(item);
		}
		lstRecipes.setItems(items);
		lstRecipes.setCellFactory(param -> new ListCell<Recipe>() {
			private ImageView imageView = new ImageView();

			@Override
			public void updateItem(Recipe recipe, boolean empty) {
				super.updateItem(recipe, empty);
				if (empty) {
					setText(null);
					setGraphic(null);
				} else {
					imageView.setImage(recipe.getImage());
					imageView.setFitHeight(150);
					imageView.setFitWidth(150);
					setText(recipe.getName());
					setGraphic(imageView);
				}
			}
		});
	}

	@FXML
	void btnProfile_onClick(ActionEvent event) {
		RecipeBusiness business = new RecipeBusiness();
		ObservableList<Recipe> items = FXCollections.observableArrayList();
		for (Recipe item : business.GetAllRecipesByUser(_user)) {
			items.add(item);
		}
		lstRecipes.setItems(items);
		lstRecipes.setCellFactory(param -> new ListCell<Recipe>() {
			private ImageView imageView = new ImageView();

			@Override
			public void updateItem(Recipe recipe, boolean empty) {
				super.updateItem(recipe, empty);
				if (empty) {
					setText(null);
					setGraphic(null);
				} else {
					imageView.setImage(recipe.getImage());
					imageView.setFitHeight(150);
					imageView.setFitWidth(150);
					setText(recipe.getName());
					setGraphic(imageView);
				}
			}
		});
	}

	@FXML
	void btnSearch_onClick(ActionEvent event) {
		TextInputDialog dialog = new TextInputDialog();
		dialog.setHeaderText("Aranacak kelimeyi giriniz");
		String search = dialog.showAndWait().get();
		RecipeBusiness business = new RecipeBusiness();
		ObservableList<Recipe> items = FXCollections.observableArrayList();
		for (Recipe item : business.GetAllRecipesBySearch(search)) {
			items.add(item);
		}
		lstRecipes.setItems(items);
		lstRecipes.setCellFactory(param -> new ListCell<Recipe>() {
			private ImageView imageView = new ImageView();

			@Override
			public void updateItem(Recipe recipe, boolean empty) {
				super.updateItem(recipe, empty);
				if (empty) {
					setText(null);
					setGraphic(null);
				} else {
					imageView.setImage(recipe.getImage());
					imageView.setFitHeight(150);
					imageView.setFitWidth(150);
					setText(recipe.getName());
					setGraphic(imageView);
				}
			}
		});
	}

	@FXML
	void lstRecipes_onClick(MouseEvent event) {
		if (event.getClickCount() == 2) {
			FXMLLoader loader = new FXMLLoader(getClass().getResource("fxml/RecipeDetail.fxml"));
			Parent root = null;
			try {
				root = loader.load();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			RecipeDetailController controller = loader.getController();

			Recipe recipe = (Recipe) lstRecipes.getSelectionModel().getSelectedItem();
			controller._user = _user;
			controller._recipe = recipe;
			controller.imgImage.setImage(recipe.getImage());
			controller.lblTitle.setText(recipe.getName());
			controller.lblDescr.setText(recipe.getDescr());
			if (_user.getId() != recipe.getUserId() && _user.getPermission() == 0) {
				controller.btnEdit.setVisible(false);
				controller.btnRemove.setVisible(false);
			}
			StageManager.Show(root, 400, 600, false, false);
		}
	}

    @FXML
    void btnAdmin_onClick(ActionEvent event) {
    	try {
    		Parent root = FXMLLoader.load(getClass().getResource("fxml/Admin.fxml"));
        	StageManager.Show(root, 400,600); 
		} catch (Exception e) {
			// TODO: handle exception
		}
    	
    }

	@FXML
	void initialize() {
		RecipeBusiness business = new RecipeBusiness();
		ObservableList<Recipe> items = FXCollections.observableArrayList();
		for (Recipe item : business.GetAllRecipes()) {
			items.add(item);
		}
		lstRecipes.setItems(items);
		lstRecipes.setCellFactory(param -> new ListCell<Recipe>() {
			private ImageView imageView = new ImageView();

			@Override
			public void updateItem(Recipe recipe, boolean empty) {
				super.updateItem(recipe, empty);
				if (empty) {
					setText(null);
					setGraphic(null);
				} else {
					imageView.setImage(recipe.getImage());
					imageView.setFitHeight(150);
					imageView.setFitWidth(150);
					setText(recipe.getName());
					setGraphic(imageView);
				}
			}
		});
	}

}
