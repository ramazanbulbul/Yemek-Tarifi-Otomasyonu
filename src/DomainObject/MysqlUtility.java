package DomainObject;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import dto.recipe.AddRecipeRequest;
import dto.recipe.EditRecipeRequest;
import dto.user.AddUserRequest;
import dto.user.CheckLoginRequest;
import dto.user.EditUserRequest;
import dto.user.GetUserByUsernameRequest;

public class MysqlUtility {

	private static final String DATABASE_URL = "jdbc:mysql://localhost:3306/javafx_202503308?useSSL=false";
	private static final String DATABASE_USERNAME = "root";
	private static final String DATABASE_PASSWORD = "";

	private static final String QUERY_ADDUSER = "INSERT INTO user (username, email, password, permission) VALUES (?, ?, ?, ?)";
	private static final String QUERY_EDITUSER = "UPDATE user SET username = ?, email =?, permission=? WHERE id=?";
	private static final String QUERY_EDITUSERWITHPASSWORD = "UPDATE user SET username = ?, email =?, password=?, permission=? WHERE id=?";
	private static final String QUERY_GETALLUSERS = "SELECT * FROM user";
	private static final String QUERY_GETUSERBYUSERNAME = "SELECT * FROM user WHERE username = ?";
	private static final String QUERY_REMOVEUSER = "DELETE FROM user WHERE id = ?";
	private static final String QUERY_CHECKLOGIN = "SELECT * FROM user WHERE email = ? AND password = ?";

	private static final String QUERY_ADDRECIPE = "INSERT INTO recipe(name, descr, imageUrl, userId) values(?,?,?,?)";
	private static final String QUERY_EDITRECIPE = "update recipe set name = ?, descr = ?, imageUrl = ? where id = ?";
	private static final String QUERY_REMOVERECIPE = "DELETE FROM recipe WHERE id=?";
	private static final String QUERY_GETALLRECIPES = "SELECT * FROM recipe";
	private static final String QUERY_GETALLRECIPESBYUSER = "SELECT * FROM recipe where userId = ?";
	private static final String QUERY_GETALLRECIPESBYSEARCH = "SELECT * FROM recipe where name like ?";
	Connection _conn = null;

	public MysqlUtility() {
		try {
			Connection conn = DriverManager.getConnection(DATABASE_URL, DATABASE_USERNAME, DATABASE_PASSWORD);
			this._conn = conn;
		} catch (SQLException e) {
			printSQLException(e);
		}
	}

	public void AddUser(AddUserRequest user) {
		try {
			PreparedStatement preparedStatement = _conn.prepareStatement(QUERY_ADDUSER);
			preparedStatement.setString(1, user.getUsername());
			preparedStatement.setString(2, user.getEmail());
			preparedStatement.setString(3, user.getPassword());
			preparedStatement.setInt(4, user.getPermission());
			System.out.println(preparedStatement);
			preparedStatement.executeUpdate();
		} catch (SQLException e) {
			printSQLException(e);
		}
	}
	public void EditUser(EditUserRequest user) {
		try {
			PreparedStatement preparedStatement = _conn.prepareStatement(QUERY_EDITUSER);
			preparedStatement.setString(1, user.getUsername());
			preparedStatement.setString(2, user.getEmail());
			preparedStatement.setInt(3, user.getPermission());
			preparedStatement.setInt(4, user.getId());
			System.out.println(preparedStatement);
			preparedStatement.executeUpdate();
		} catch (SQLException e) {
			printSQLException(e);
		}
	}
	public void EditUserWithPassword(EditUserRequest user) {
		try {
			PreparedStatement preparedStatement = _conn.prepareStatement(QUERY_EDITUSERWITHPASSWORD);
			preparedStatement.setString(1, user.getUsername());
			preparedStatement.setString(2, user.getEmail());
			preparedStatement.setString(3, user.getPassword());
			preparedStatement.setInt(4, user.getPermission());
			preparedStatement.setInt(5, user.getId());
			System.out.println(preparedStatement);
			preparedStatement.executeUpdate();
		} catch (SQLException e) {
			printSQLException(e);
		}
	}
	public void RemoveUser(int id) {
		try {
			PreparedStatement preparedStatement = _conn.prepareStatement(QUERY_REMOVEUSER);
			preparedStatement.setInt(1, id);
			System.out.println(preparedStatement);
			preparedStatement.executeUpdate();
		} catch (SQLException e) {
			printSQLException(e);
		}
	}

	public User ChechLogin(CheckLoginRequest request) {
		try {
			PreparedStatement preparedStatement = _conn.prepareStatement(QUERY_CHECKLOGIN);
			preparedStatement.setString(1, request.getEmail());
			preparedStatement.setString(2, request.getPassword());
			ResultSet rs = preparedStatement.executeQuery();
			if (rs.next()) {
				User user = new User();
				user.setId(rs.getInt(1));
				user.setUsername(rs.getString(2));
				user.setPassword(rs.getString(3));
				user.setEmail(rs.getString(4));
				user.setPermission(rs.getInt(5));
				user.setCreatedAt(rs.getDate(6));
				return user;
			}
		} catch (SQLException e) {
			printSQLException(e);
		}
		return null;
	}

	public ArrayList<User> GetAllUser() {
		ArrayList<User> users = new ArrayList<User>();
		try {
			PreparedStatement preparedStatement = _conn.prepareStatement(QUERY_GETALLUSERS);
			ResultSet rs = preparedStatement.executeQuery();
			while (rs.next()) {
				User user = new User();
				user.setId(rs.getInt("id"));
				user.setUsername(rs.getString("username"));
				user.setEmail(rs.getString("email"));
				user.setPassword(rs.getString("password"));
				user.setPermission(rs.getInt("permission"));
				user.setCreatedAt(rs.getDate("createdAt"));
				users.add(user);
			}
			return users;
		} catch (SQLException e) {
			printSQLException(e);
		}
		return null;
	}

	public ArrayList<User> GetUserByUsername(GetUserByUsernameRequest request) {
		ArrayList<User> users = new ArrayList<User>();
		try {
			PreparedStatement preparedStatement = _conn.prepareStatement(QUERY_GETUSERBYUSERNAME);
			preparedStatement.setString(1, request.getUsername());
			ResultSet rs = preparedStatement.executeQuery();
			while (rs.next()) {
				User user = new User();
				user.setId(rs.getInt("id"));
				user.setUsername(rs.getString("username"));
				user.setEmail(rs.getString("email"));
				user.setPassword(rs.getString("password"));
				user.setPermission(rs.getInt("permission"));
				user.setCreatedAt(rs.getDate("createdAt"));
				users.add(user);
			}
			return users;
		} catch (SQLException e) {
			printSQLException(e);
		}
		return null;
	}

	public void AddRecipe(AddRecipeRequest request) {
		try {
			PreparedStatement preparedStatement = _conn.prepareStatement(QUERY_ADDRECIPE);
			preparedStatement.setString(1, request.getName());
			preparedStatement.setString(2, request.getDescr());
			preparedStatement.setString(3, request.getImageUrl());
			preparedStatement.setInt(4, request.getUserId());

			System.out.println(preparedStatement);
			preparedStatement.executeUpdate();
		} catch (SQLException e) {
			printSQLException(e);
		}
	}
	public void RemoveRecipe(int id) {
		try {
			PreparedStatement preparedStatement = _conn.prepareStatement(QUERY_REMOVERECIPE);
			preparedStatement.setInt(1, id);
			System.out.println(preparedStatement);
			preparedStatement.executeUpdate();
		} catch (SQLException e) {
			printSQLException(e);
		}
	}
	public void EditRecipe(EditRecipeRequest request) {
		try {
			PreparedStatement preparedStatement = _conn.prepareStatement(QUERY_EDITRECIPE);
			preparedStatement.setString(1, request.getName());
			preparedStatement.setString(2, request.getDescr());
			preparedStatement.setString(3, request.getImageUrl());
			preparedStatement.setInt(4, request.getId());

			System.out.println(preparedStatement);
			preparedStatement.executeUpdate();
		} catch (SQLException e) {
			printSQLException(e);
		}
		
	}

	public ArrayList<Recipe> GetAllRecipe() {
		ArrayList<Recipe> recipes = new ArrayList<Recipe>();
		try {
			PreparedStatement preparedStatement = _conn.prepareStatement(QUERY_GETALLRECIPES);
			ResultSet rs = preparedStatement.executeQuery();
			while (rs.next()) {
				Recipe recipe = new Recipe();
				recipe.setId(rs.getInt("id"));
				recipe.setName(rs.getString("name"));
				recipe.setDescr(rs.getString("descr"));
				recipe.setImageUrl(rs.getString("imageUrl"));
				recipe.setUserId(rs.getInt("userId"));
				recipe.setCreatedAt(rs.getDate("createdAt"));
				recipes.add(recipe);
			}
			return recipes;
		} catch (SQLException e) {
			printSQLException(e);
		}
		return null;
	}
	public ArrayList<Recipe> GetAllRecipesByUser(User user) {
		ArrayList<Recipe> recipes = new ArrayList<Recipe>();
		try {
			PreparedStatement preparedStatement = _conn.prepareStatement(QUERY_GETALLRECIPESBYUSER);
			preparedStatement.setInt(1, user.getId());
			ResultSet rs = preparedStatement.executeQuery();
			while (rs.next()) {
				Recipe recipe = new Recipe();
				recipe.setId(rs.getInt("id"));
				recipe.setName(rs.getString("name"));
				recipe.setDescr(rs.getString("descr"));
				recipe.setImageUrl(rs.getString("imageUrl"));
				recipe.setUserId(rs.getInt("userId"));
				recipe.setCreatedAt(rs.getDate("createdAt"));
				recipes.add(recipe);
			}
			return recipes;
		} catch (SQLException e) {
			printSQLException(e);
		}
		return null;
	}
	public static void printSQLException(SQLException ex) {
		for (Throwable e : ex) {
			if (e instanceof SQLException) {
				e.printStackTrace(System.err);
				System.err.println("SQLState: " + ((SQLException) e).getSQLState());
				System.err.println("Error Code: " + ((SQLException) e).getErrorCode());
				System.err.println("Message: " + e.getMessage());
				Throwable t = ex.getCause();
				while (t != null) {
					System.out.println("Cause: " + t);
					t = t.getCause();
				}
			}
		}
	}

	public ArrayList<Recipe> GetAllRecipesBySearch(String search) {
		ArrayList<Recipe> recipes = new ArrayList<Recipe>();
		try {
			PreparedStatement preparedStatement = _conn.prepareStatement(QUERY_GETALLRECIPESBYSEARCH);
			
			preparedStatement.setString(1, "%" + search  + "%" );
			ResultSet rs = preparedStatement.executeQuery();
			while (rs.next()) {
				Recipe recipe = new Recipe();
				recipe.setId(rs.getInt("id"));
				recipe.setName(rs.getString("name"));
				recipe.setDescr(rs.getString("descr"));
				recipe.setImageUrl(rs.getString("imageUrl"));
				recipe.setUserId(rs.getInt("userId"));
				recipe.setCreatedAt(rs.getDate("createdAt"));
				recipes.add(recipe);
			}
			return recipes;
		} catch (SQLException e) {
			printSQLException(e);
		}
		return null;
	}

	

	
}
