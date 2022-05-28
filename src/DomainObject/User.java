package DomainObject;

import java.util.Date;

import utility.HashManager;

public class User {
	private int Id;
	private String Username;
	private String Email;
	private String Password;
	private int Permission;
	private Date CreatedAt;
	
	public User() {
		
	}
	public User(int id, String username, String email, String password, int permission, Date createdAt){
		this.Id = id;
		this.Username = username;
		this.Email = email;
		this.Password = HashManager.PasswordToMD5(password);
		this.Permission = permission;
		this.CreatedAt = createdAt;
	}
	
	public int getId() {
		return Id;
	}
	public void setId(int id) {
		Id = id;
	}
	public String getUsername() {
		return Username;
	}
	public void setUsername(String username) {
		Username = username;
	}
	public String getEmail() {
		return Email;
	}
	public void setEmail(String email) {
		Email = email;
	}
	public String getPassword() {
		return Password;
	}
	public void setPassword(String password) {
		password = HashManager.PasswordToMD5(password);
		Password = password;
	}
	public int getPermission() {
		return Permission;
	}
	public void setPermission(int permission) {
		Permission = permission;
	}
	public Date getCreatedAt() {
		return CreatedAt;
	}
	public void setCreatedAt(Date createdAt) {
		CreatedAt = createdAt;
	}
}
