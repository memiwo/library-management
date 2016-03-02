package librarymanagement.ui;

import application.Main;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.FlowPane;
import librarymanagement.business.Authorization;

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
		welcomeLbl.setText("Welcome "+Main.currentUser.getFirstName()+" "+Main.currentUser.getLastName());
		
		
		//if administrator
		if(Main.currentUser.getRoles().size()==1 && Main.currentUser.getRoles().contains(Authorization.ADMINISTRATOR)){
			flowPane.getChildren().remove(checkOutBook);
			flowPane.getChildren().remove(checkInBook);
		}
		
		//if librarian
		if(Main.currentUser.getRoles().size()==1 && Main.currentUser.getRoles().contains(Authorization.LIBRARIAN)){
			flowPane.getChildren().remove(addNewMember);
			flowPane.getChildren().remove(editMember);
			flowPane.getChildren().remove(addBook);
		}
		
		//if both
		//by default all the functionalities are available
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
