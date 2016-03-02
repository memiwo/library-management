package librarymanagement.ui;

import java.io.IOException;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.AnchorPane;
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
	@FXML
	AnchorPane anchPane = new AnchorPane();
	
	public static LibraryMember memberToEdit;
	private LibraryMemberService libMemberService = new LibraryMemberService();

	public void search(){
		validate();
		if(error.getText().equals("")){
			//utility.openAddNewLibraryMember();
			anchPane.getChildren().clear();
			try {
				Parent root = FXMLLoader.load(getClass().getResource("/librarymanagement/ui/AddNewLibraryMember.fxml"));
				AnchorPane a = (AnchorPane)root;
				a.getStylesheets().add(getClass().getResource("application.css").toExternalForm());
				anchPane.getChildren().add(a);
			} catch (IOException e) {
				e.printStackTrace();
			}
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