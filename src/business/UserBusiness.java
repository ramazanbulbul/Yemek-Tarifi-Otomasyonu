package business;

import DomainObject.MysqlUtility;
import dto.user.AddUserRequest;

public class UserBusiness {
	MysqlUtility _db;

	public UserBusiness() {
		_db = new MysqlUtility();
	}

	public void AddUser(AddUserRequest request) {

	}
}
