package librarymanagement.ui;

import application.Main;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
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
		Main.setCurrentUser(datauser); 
		OpenDashboardWindow();
	 }
 }
 private void OpenDashboardWindow(){
	 try{
			Parent root  =  FXMLLoader.load(getClass().getResource("/librarymanagement/ui/Dashboard.fxml"));
			Scene scene = new Scene(root);
			scene.getStylesheets().add(getClass().getResource("application.css").toExternalForm());
			Main.mainStage.setScene(scene);
			Main.mainStage.show();
			Main.mainStage.setResizable(false);
		} catch(Exception e) {
			e.printStackTrace();
		}
 }
}
