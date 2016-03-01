package librarymanagement.ui;

import application.Main;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;

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
	
	public void save(){
		//TODO
	}
	
	public void back(){
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
