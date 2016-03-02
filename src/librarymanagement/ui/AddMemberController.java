package librarymanagement.ui;

import java.util.List;

import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
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
	
	Utility utility = new Utility();
	LibraryMemberService libMemberService = new LibraryMemberService();
	
	public void save(){
		//Do some validation and if all pass then
		//save the Member by accessing LibraryMemberSerivce
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
		List<LibraryMember> libMembers = libMemberService.findAll();
		libMembers.add(libMember);
		libMemberService.save(libMembers);
		utility.openDashboard();
	}
	
	public void back(){
		utility.openDashboard();
	}
}
