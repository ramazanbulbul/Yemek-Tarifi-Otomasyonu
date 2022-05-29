package application;

import java.net.URL;
import java.util.ResourceBundle;

import DomainObject.MysqlUtility;
import DomainObject.User;
import dto.user.AddUserRequest;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.ListView;

public class HomepageController {

    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    @FXML
    private Button btnAdd;

    @FXML
    private Button btnHomepage;

    @FXML
    private Button btnProfile;

    @FXML
    private Button btnSearch;

    @FXML
    private ListView<?> lstHomepage;

    @FXML
    void btnAdd_onClick(ActionEvent event) {
    	
    }

    @FXML
    void btnHomepage_onClick(ActionEvent event) {

    }

    @FXML
    void btnProfile_onClick(ActionEvent event) {

    }

    @FXML
    void btnSearch_onClick(ActionEvent event) {
    	double pWidth = lstHomepage.getWidth();
		btnHomepage.setMinWidth(pWidth/3);
		btnHomepage.setLayoutX(0);
		btnSearch.setMinWidth(pWidth/3);
		btnSearch.setLayoutX(pWidth/3);
		btnProfile.setMinWidth(pWidth/3);
		btnProfile.setLayoutX((pWidth/3)*2);

    }

    @FXML
    void initialize() {
        assert btnAdd != null : "fx:id=\"btnAdd\" was not injected: check your FXML file 'Homepage.fxml'.";
        assert btnHomepage != null : "fx:id=\"btnHomepage\" was not injected: check your FXML file 'Homepage.fxml'.";
        assert btnProfile != null : "fx:id=\"btnProfile\" was not injected: check your FXML file 'Homepage.fxml'.";
        assert btnSearch != null : "fx:id=\"btnSearch\" was not injected: check your FXML file 'Homepage.fxml'.";
        assert lstHomepage != null : "fx:id=\"lstHomepage\" was not injected: check your FXML file 'Homepage.fxml'.";
        
    }

}
