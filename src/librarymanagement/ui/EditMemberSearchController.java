package librarymanagement.ui;

import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import librarymanagement.business.LibraryMember;
import librarymanagement.dataaccess.LibraryMemberService;

public class EditMemberSearchController {

	@FXML
	TextField tfMemberID = new TextField();
	@FXML
	Button btnBack = new Button();
	@FXML
	Button btnSearch = new Button();
	@FXML
	Label error = new Label();
	
	public static LibraryMember memberToEdit;
	private LibraryMemberService libMemberService = new LibraryMemberService();
	
	Utility utility = new Utility();
	
	public void back(){
		memberToEdit = null;
		utility.openDashboard();
	}
	
	public void search(){
		validate();
		if(error.getText().equals("")){
			utility.openAddNewLibraryMember();	
		}
	}
	
	public void validate(){
		StringBuilder errorMsg = new StringBuilder();
		//Check if the number format is valid
		//Check if the ID number exist.
		try{
			memberToEdit = libMemberService.get(Integer.parseInt(tfMemberID.getText()));
			if(memberToEdit==null){
				errorMsg.append("Member does not exist.").append("\n");
			}
		}catch(NumberFormatException ex){
			errorMsg.append("Input a valid ID number.").append("\n");
		}
		error.setText(errorMsg.toString());
	}
}