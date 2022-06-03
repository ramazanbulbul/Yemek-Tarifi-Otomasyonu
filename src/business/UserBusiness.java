package business;

import java.util.ArrayList;

import DomainObject.MysqlUtility;
import DomainObject.User;
import dto.user.AddUserRequest;
import dto.user.CheckLoginRequest;
import dto.user.EditUserRequest;
import dto.user.GetUserByUsernameRequest;
import utility.HashManager;

public class UserBusiness {
	MysqlUtility _db;

	public UserBusiness() {
		_db = new MysqlUtility();
	}

	public void AddUser(AddUserRequest request) {
		request.setPassword(HashManager.PasswordToMD5(request.getPassword()));
		_db.AddUser(request);
	}
	public void EditUser(EditUserRequest request) {
		if (request.getPassword() != "") {
			request.setPassword(HashManager.PasswordToMD5(request.getPassword()));
			_db.EditUserWithPassword(request);
		}else {
			_db.EditUser(request);
		}
	}
	public void RemoveUser(int id) {
		_db.RemoveUser(id);
	}
	
	public User CheckLogin(CheckLoginRequest request) {
		request.setPassword(HashManager.PasswordToMD5(request.getPassword()));
		return _db.ChechLogin(request);
	}
	public ArrayList<User> GetUserByUsername(GetUserByUsernameRequest request){
		return _db.GetUserByUsername(request);
	}
	public ArrayList<User> GetAllUser(){
		return _db.GetAllUser();
	}
}
