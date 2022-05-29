package DomainObject;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import dto.user.AddUserRequest;
import dto.user.CheckLoginRequest;
import dto.user.GetUserByUsernameRequest;

public class MysqlUtility {
	
	// Replace below database url, username and password with your actual database credentials
    private static final String DATABASE_URL = "jdbc:mysql://localhost:3306/javafx_202503308?useSSL=false";
    private static final String DATABASE_USERNAME = "root";
    private static final String DATABASE_PASSWORD = "";
    
    private static final String QUERY_ADDUSER = "INSERT INTO user (username, email, password) VALUES (?, ?, ?)";
    private static final String QUERY_GETALLUSERS = "SELECT * FROM user";
    private static final String QUERY_GETUSERBYUSERNAME = "SELECT * FROM user WHERE username = ?";
    
    private static final String QUERY_CHECKLOGIN = "SELECT * FROM user WHERE email = ? AND password = ?";
    
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

	        System.out.println(preparedStatement);
	        preparedStatement.executeUpdate();
		} catch (SQLException e) {
            printSQLException(e);
		}
	}
    public boolean ChechLogin(CheckLoginRequest request) {		
		try {
			PreparedStatement preparedStatement = _conn.prepareStatement(QUERY_CHECKLOGIN);
			preparedStatement.setString(1, request.getEmail());
	        preparedStatement.setString(2, request.getPassword());
	        ResultSet rs = preparedStatement.executeQuery();
	        if (rs.next()) {
				return true;
			}
		} catch (SQLException e) {
            printSQLException(e);
		}
		return false;
	}
    
    public ArrayList<User> GetAllUser() {
    	ArrayList<User> users = new ArrayList<User>();
    	try {
			PreparedStatement preparedStatement = _conn.prepareStatement(QUERY_GETALLUSERS);
	        ResultSet rs = preparedStatement.executeQuery();
	        while(rs.next()) {
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
	        while(rs.next()) {
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

    public static void printSQLException(SQLException ex) {
        for (Throwable e: ex) {
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
}
