package librarymanagement.ui;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.stage.Stage;

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
	
	private Stage addMemberStage = new Stage();
	
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
			this.addMemberStage.setScene(scene);
			addMemberStage.show();
			addMemberStage.setResizable(false);
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
		//TODO
		
	}
	
}
