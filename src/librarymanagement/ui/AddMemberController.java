package librarymanagement.ui;

import java.io.IOException;
import java.util.List;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.AnchorPane;
import librarymanagement.business.Address;
import librarymanagement.business.LibraryMember;
import librarymanagement.dataaccess.LibraryMemberService;

public class AddMemberController {

	@FXML
	TextField tfMemberID = new TextField();
	@FXML
	TextField tfFirstName = new TextField();
	@FXML
	TextField tfLastName = new TextField();
	@FXML
	TextField tfStreet = new TextField();
	@FXML
	TextField tfCity = new TextField();
	@FXML
	TextField tfState = new TextField();
	@FXML
	TextField tfZipCode = new TextField();
	@FXML
	TextField tfPhone = new TextField();
	@FXML
	Button btnSave = new Button();
	@FXML
	Button btnBack = new Button();
	@FXML
	Label title = new Label();
	@FXML
	Label error = new Label();
	@FXML
	AnchorPane anchPane = new AnchorPane();
	
	LibraryMemberService libMemberService = new LibraryMemberService();


	@FXML
	public void initialize(){
		if(EditMemberSearchController.memberToEdit!=null){
			tfMemberID.setText(EditMemberSearchController.memberToEdit.getMemberNumber().toString());
			tfFirstName.setText(EditMemberSearchController.memberToEdit.getFirstName());
			tfLastName.setText(EditMemberSearchController.memberToEdit.getLastName());
			tfStreet.setText(EditMemberSearchController.memberToEdit.getAddress().getStreet());
			tfCity.setText(EditMemberSearchController.memberToEdit.getAddress().getCity());
			tfState.setText(EditMemberSearchController.memberToEdit.getAddress().getState());
			tfZipCode.setText(EditMemberSearchController.memberToEdit.getAddress().getZip().toString());
			tfPhone.setText(EditMemberSearchController.memberToEdit.getPhoneNumber().toString());
			tfMemberID.setDisable(true);
			title.setText("Edit Library Member");
		}else{
			title.setText("Add Library Member");
			btnBack.setVisible(false);
		}
	}
	
	public void validate(){
		StringBuilder errorMsg = new StringBuilder();
		//All fields should not be empty
		if(tfFirstName.getText().equals("")||tfLastName.getText().equals("")||
				tfStreet.getText().equals("")||tfCity.getText().equals("")||tfState.getText().equals("")){
			errorMsg.append("Fields should not be empty.").append("\n");
		}
		//Check if ID number already exists
		List<LibraryMember> libMembers;
		if(EditMemberSearchController.memberToEdit==null){
			 libMembers = libMemberService.findAll();
			 for(LibraryMember l :  libMembers){
				 if(l.getMemberNumber().toString().equals(tfMemberID.getText())){
						errorMsg.append("ID number already exist.").append("\n");
						break;
					}
			 }
		}
		//Check format of member ID
		try{
			Integer.parseInt(tfMemberID.getText());
		}catch(NumberFormatException ex){
			errorMsg.append("Invalid number input in Member ID").append("\n");
		}
		//Check format of zip code
		try{
			Integer.parseInt(tfZipCode.getText());
		}catch(NumberFormatException ex){
			errorMsg.append("Invalid number input in Zip Code").append("\n");
		}
		//Check format of member ID
		try{
			Integer.parseInt(tfPhone.getText());
		}catch(NumberFormatException ex){
			errorMsg.append("Invalid number input in Phone #").append("\n");
		}
		error.setText(errorMsg.toString());
	}
	
	public void save(){
		//Do some validation and if all pass then
		validate();
		if(error.getText().equals("")){
			LibraryMember libMember = new LibraryMember();
			libMember.setMemberNumber(Integer.parseInt(tfMemberID.getText()));
			libMember.setFirstName(tfFirstName.getText());
			libMember.setLastName(tfLastName.getText());
			Address memberAddress = new Address();
			memberAddress.setStreet(tfStreet.getText());
			memberAddress.setCity(tfCity.getText());
			memberAddress.setState(tfState.getText());
			memberAddress.setZip(Integer.parseInt(tfZipCode.getText()));
			libMember.setAddress(memberAddress);
			libMember.setPhoneNumber(Integer.parseInt(tfPhone.getText()));
			
			//If memberToEdit is null means the functionality is Edit a Library Member Info
			//Else Add New library Member
			List<LibraryMember> libMembers = libMemberService.findAll();
			if(EditMemberSearchController.memberToEdit!=null){
				for(LibraryMember l : libMembers){
					if(l.getMemberNumber().toString().equals(libMember.getMemberNumber().toString())){
						libMembers.set(libMembers.indexOf(l), libMember);
						break;
					}
				}
			}else{
				libMembers.add(libMember);
			}
			//save the Member by accessing LibraryMemberSerivce
			libMemberService.save(libMembers);
			error.setText("Successfully saved library member.");
		}
	}
	
	public void back(){
		EditMemberSearchController.memberToEdit = null;
		//utility.openDashboard();
		anchPane.getChildren().clear();
		try {
			Parent root = FXMLLoader.load(getClass().getResource("/librarymanagement/ui/EditMemberSearch.fxml"));
			AnchorPane a = (AnchorPane)root;
			a.getStylesheets().add(getClass().getResource("application.css").toExternalForm());
			anchPane.getChildren().add(a);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}
