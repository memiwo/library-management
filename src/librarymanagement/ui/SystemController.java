package librarymanagement.ui;

import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.FlowPane;

public class SystemController {
	@FXML
	Button addNewMember = new Button();
	@FXML
	Button editMember = new Button();
	@FXML
	Button addBook = new Button();
	@FXML
	Button checkOutBook = new Button();
	@FXML
	Button checkInBook = new Button();
	@FXML
	Button logout = new Button();
	@FXML
	Label welcomeLbl = new Label();
	@FXML
	FlowPane flowPane = new FlowPane();
	
	Utility utility = new Utility();
	
	@FXML
	public void initialize(){
		welcomeLbl.setText("Welcome");
		//if administrator
		//flowPane.getChildren().remove(checkOutBook);
		//flowPane.getChildren().remove(checkInBook);
		
		//if librarian
		//flowPane.getChildren().remove(addNewMember);
		//flowPane.getChildren().remove(editMember);
		//flowPane.getChildren().remove(addBook);
	}

	public SystemController(){
		
	}
	
	public void addNewLibraryMember(){
		utility.openAddNewLibraryMember();
	}
	
	public void editLibraryMemberInfo(){
		utility.openEditMemberSearch();
	}
	
	public void addBook(){
		utility.openAddBook();
	}
	
	public void checkOutBook(){
		utility.openSearchBook();
	}
	
	public void checkInBook(){

		utility.openCheckinBook();
	}
	
	public void logout(){

		utility.openLogin();
	}
	
}
