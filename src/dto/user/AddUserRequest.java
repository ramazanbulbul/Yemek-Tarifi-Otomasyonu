package dto.user;

public class AddUserRequest {
	private String Username;
	private String Password;
	private String Email;
	public String getUsername() {
		return Username;
	}
	public void setUsername(String username) {
		Username = username;
	}
	public String getPassword() {
		return Password;
	}
	public void setPassword(String password) {
		Password = password;
	}
	public String getEmail() {
		return Email;
	}
	public void setEmail(String email) {
		Email = email;
	}
	public AddUserRequest(String username, String password, String email) {
		this.Username = username;
		this.Password = password;
		this.Email = email;
	}
	
	
}
