package business;

import java.util.ArrayList;

import DomainObject.MysqlUtility;
import DomainObject.User;
import dto.user.AddUserRequest;
import dto.user.CheckLoginRequest;
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
	
	public boolean CheckLogin(CheckLoginRequest request) {
		request.setPassword(HashManager.PasswordToMD5(request.getPassword()));
		return _db.ChechLogin(request);
	}
	public ArrayList<User> GetUserByUsername(GetUserByUsernameRequest request){
		return _db.GetUserByUsername(request);
	}
}
