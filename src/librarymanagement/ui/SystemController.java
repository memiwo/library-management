package librarymanagement.ui;

import application.Main;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;

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
	
	public SystemController(){
		welcomeLbl.setText("Welcome");
	}
	
	public SystemController(String name){
		welcomeLbl.setText("Welcome "+name);
	}

	public void addNewLibraryMember(){
		try{
			Parent root  =  FXMLLoader.load(getClass().getResource("/librarymanagement/ui/AddNewLibraryMember.fxml"));
			Scene scene = new Scene(root);
			scene.getStylesheets().add(getClass().getResource("application.css").toExternalForm());
			Main.mainStage.setScene(scene);
			Main.mainStage.show();
			Main.mainStage.setResizable(false);
		} catch(Exception e) {
			e.printStackTrace();
		}
	}
	
	public void editLibraryMemberInfo(){
		//TODO
	}
	
	public void addBook(){
		//TODO
		
	}
	
	public void checkOutBook(){
		//TODO
	}
	
	public void checkInBook(){

		//TODO
	}
	
	public void logout(){
		try{
			Parent root  =  FXMLLoader.load(getClass().getResource("/librarymanagement/ui/Login.fxml"));
			Scene scene = new Scene(root);
			scene.getStylesheets().add(getClass().getResource("application.css").toExternalForm());
			Main.mainStage.setScene(scene);
			Main.mainStage.show();
			Main.mainStage.setResizable(false);
			//Set LoginController.LoginUer to null
		} catch(Exception e) {
			e.printStackTrace();
		}
	}
	
}
