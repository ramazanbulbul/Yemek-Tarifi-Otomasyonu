package application;

import java.net.URL;
import java.util.ResourceBundle;

import DomainObject.User;
import business.UserBusiness;
import dto.user.AddUserRequest;
import dto.user.EditUserRequest;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.CheckBox;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.input.MouseEvent;

public class AdminController {

    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    @FXML
    private Button btnAdd;

    @FXML
    private Button btnEdit;

    @FXML
    private Button btnRemove;

    @FXML
    private Button btnReset;

    @FXML
    private TableColumn<UserTableview, Integer> clnAdmin;

    @FXML
    private TableColumn<UserTableview, String> clnEposta;

    @FXML
    private TableColumn<UserTableview, Integer> clnId;

    @FXML
    private TableColumn<UserTableview, String> clnUsename;

    @FXML
    private TableView<UserTableview> tvUser;

    @FXML
    private CheckBox cbAdmin;
    
    @FXML
    private TextField txtEmail;

    @FXML
    private TextField txtPassword;

    @FXML
    private TextField txtUsername;

    @FXML
    void btnAdd_onClick(ActionEvent event) {
    	UserBusiness business = new UserBusiness();
    	AddUserRequest request = new AddUserRequest();
    	request.setEmail(txtEmail.getText());
    	request.setPassword(txtPassword.getText());
    	request.setUsername(txtUsername.getText());
    	request.setPermission(cbAdmin.isSelected() == true ? 1 : 0);
    	business.AddUser(request);
    	
    	ObservableList<UserTableview> items = FXCollections.observableArrayList();
    	for (User user : new UserBusiness().GetAllUser()) {
    		items.add(new UserTableview(user.getId(), user.getUsername(), user.getEmail(), user.getPermission()));
		}
    	tvUser.setItems(items);
    }

    @FXML
    void btnEdit_onClick(ActionEvent event) {
    	UserBusiness business = new UserBusiness();
    	EditUserRequest request = new EditUserRequest();
    	request.setEmail(txtEmail.getText());
    	request.setPassword(txtPassword.getText());
    	request.setUsername(txtUsername.getText());
    	request.setPermission(cbAdmin.isSelected() == true ? 1 : 0);
    	request.setId(clnId.getCellData(tvUser.getSelectionModel().getSelectedIndex()));
    	business.EditUser(request);
    	
    	ObservableList<UserTableview> items = FXCollections.observableArrayList();
    	for (User user : new UserBusiness().GetAllUser()) {
    		items.add(new UserTableview(user.getId(), user.getUsername(), user.getEmail(), user.getPermission()));
		}
    	tvUser.setItems(items);
    }

    @FXML
    void btnRemove_onClick(ActionEvent event) {
    	UserBusiness business = new UserBusiness();
    	business.RemoveUser(clnId.getCellData(tvUser.getSelectionModel().getSelectedIndex()));
    	
    	ObservableList<UserTableview> items = FXCollections.observableArrayList();
    	for (User user : new UserBusiness().GetAllUser()) {
    		items.add(new UserTableview(user.getId(), user.getUsername(), user.getEmail(), user.getPermission()));
		}
    	tvUser.setItems(items);
    }

    @FXML
    void btnReset_onClick(ActionEvent event) {
    	
    }

    @FXML
    void tvUser_onClick(MouseEvent event) {
    	txtEmail.setText(clnEposta.getCellData(tvUser.getSelectionModel().getSelectedIndex()));
    	txtUsername.setText(clnUsename.getCellData(tvUser.getSelectionModel().getSelectedIndex()));
    	cbAdmin.setSelected(clnAdmin.getCellData(tvUser.getSelectionModel().getSelectedIndex()) == 1? true:false);
    	
    }

    @FXML
    void initialize() {
    	
    	
    	clnId.setCellValueFactory(new PropertyValueFactory<>("clnId"));
    	clnUsename.setCellValueFactory(new PropertyValueFactory<>("clnUsename"));
    	clnEposta.setCellValueFactory(new PropertyValueFactory<>("clnEposta"));
    	clnAdmin.setCellValueFactory(new PropertyValueFactory<>("clnAdmin"));
         //add your data to the table here.
    	ObservableList<UserTableview> items = FXCollections.observableArrayList();
    	for (User user : new UserBusiness().GetAllUser()) {
    		items.add(new UserTableview(user.getId(), user.getUsername(), user.getEmail(), user.getPermission()));
		}
    	tvUser.setItems(items);
    }

}
