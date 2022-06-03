package business;

import java.util.ArrayList;

import DomainObject.MysqlUtility;
import DomainObject.Recipe;
import DomainObject.User;
import dto.recipe.AddRecipeRequest;
import dto.recipe.EditRecipeRequest;

public class RecipeBusiness {
	MysqlUtility _db;

	public RecipeBusiness() {
		_db = new MysqlUtility();
	}

	public void AddRecipe(AddRecipeRequest request) {
		_db.AddRecipe(request);
	}

	public void EditRecipe(EditRecipeRequest request) {
		_db.EditRecipe(request);
	}

	public void RemoveRecipe(int id) {
		_db.RemoveRecipe(id);
	}

	public ArrayList<Recipe> GetAllRecipes() {
		return _db.GetAllRecipe();
	}

	public ArrayList<Recipe> GetAllRecipesByUser(User user) {
		return _db.GetAllRecipesByUser(user);
	}

	public ArrayList<Recipe> GetAllRecipesBySearch(String search) {
		return _db.GetAllRecipesBySearch(search);
	}

}
