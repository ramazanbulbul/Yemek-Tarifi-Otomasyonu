package dto.user;

public class EditUserRequest extends AddUserRequest{
	private int Id;

	public int getId() {
		return Id;
	}

	public void setId(int id) {
		Id = id;
	}

	public EditUserRequest(String username, String password, String email, int Permission, int id) {
		super(username, password, email, Permission);
		Id = id;
	}

	public EditUserRequest() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	

}
