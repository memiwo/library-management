package librarymanagement.ui;

import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;

public class EditMemberSearchController {

	@FXML
	TextField tfMemberID = new TextField();
	@FXML
	Button btnBack = new Button();
	@FXML
	Button btnSearch = new Button();
	
	Utility utility = new Utility();
	
	public void back(){
		utility.openDashboard();
	}
	
	public void search(){
		utility.openAddNewLibraryMember();
	}
}
