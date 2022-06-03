package application;

import javafx.beans.property.SimpleIntegerProperty;
import javafx.beans.property.SimpleStringProperty;

public class UserTableview {

	public SimpleIntegerProperty clnId;
	public SimpleStringProperty clnUsename;
	public SimpleStringProperty clnEposta;
	public SimpleIntegerProperty clnAdmin;

	public UserTableview(Integer clnId, String clnUsename, String clnEposta, Integer clnAdmin) {
	        this.clnId = new SimpleIntegerProperty(clnId);
	        this.clnUsename = new SimpleStringProperty(clnUsename);
	        this.clnEposta = new SimpleStringProperty(clnEposta);
	        this.clnAdmin = new SimpleIntegerProperty(clnAdmin);
	    }

	public int getClnId() {
		return clnId.get();
	}

	public void setClnId(int clnId) {
		this.clnId = new SimpleIntegerProperty(clnId);
	}

	public String getClnUsename() {
		return clnUsename.get();
	}

	public void setClnUsename(String clnUsename) {
		this.clnUsename = new SimpleStringProperty(clnUsename);
	}

	public String getClnEposta() {
		return clnEposta.get();
	}
	public int getClnAdmin() {
		return clnAdmin.get();
	}

	public void setClnAdmin(int clnAdmin) {
		this.clnId = new SimpleIntegerProperty(clnAdmin);
	}


	public void setClnEposta(String clnEposta) {
		this.clnEposta = new SimpleStringProperty(clnEposta);
	}
}
