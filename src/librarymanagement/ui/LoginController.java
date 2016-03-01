package librarymanagement.ui;

import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import librarymanagement.business.User;
import librarymanagement.business.UserServices;

public class LoginController {
@FXML
TextField userName;
@FXML
PasswordField password;
@FXML
Label error;

 public void validateUserlogin(){
	 String txtuser = userName.getText();
	 String txtpass = password.getText();
	 UserServices usersrv = new UserServices();
	
	 User datauser = usersrv.validate(txtuser, txtpass);
	 if(datauser == null){
		 error.setText("Invalid Username or Password");
	 }else{
		 //Create Session
		 // Open New windows
		 
		 
	 }
	 
	 
	 
 }
}
