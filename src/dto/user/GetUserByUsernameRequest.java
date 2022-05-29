package dto.user;

public class GetUserByUsernameRequest {
	String Username;

	public String getUsername() {
		return Username;
	}

	public void setUsername(String username) {
		Username = username;
	}

	public GetUserByUsernameRequest(String username) {
		Username = username;
	}

	public GetUserByUsernameRequest() {
	}

}
