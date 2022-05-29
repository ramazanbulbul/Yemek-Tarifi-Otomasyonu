package dto.user;

public class CheckLoginRequest {
	private String Email;
	private String Password;
	public String getEmail() {
		return Email;
	}
	public void setEmail(String email) {
		this.Email = email;
	}
	public String getPassword() {
		return Password;
	}
	public void setPassword(String password) {
		Password = password;
	}
	public CheckLoginRequest(String email, String password) {
		this.Email = email;
		this.Password = password;
	}
	public CheckLoginRequest() {
		
	}
}
