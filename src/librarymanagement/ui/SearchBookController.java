package librarymanagement.ui;

import application.Main;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import librarymanagement.business.Book;

public class SearchBookController {

	@FXML
	TextField tfISBN = new TextField();
	@FXML
	Button btnSearch = new Button();
	@FXML
	Button btnBack = new Button();
	
	public static Book searchedBook;
	
	public void search(){
		//Perform book search by ISBN number
		//if book is found, show the Book information Window
		try{
			//set the scene to the dashboard and display
			Parent root  =  FXMLLoader.load(getClass().getResource("/librarymanagement/ui/CheckoutBook.fxml"));
			Scene scene = new Scene(root);
			scene.getStylesheets().add(getClass().getResource("application.css").toExternalForm());
			Main.mainStage.setScene(scene);
			Main.mainStage.show();
			Main.mainStage.setResizable(false);
		} catch(Exception e) {
			e.printStackTrace();
		}
	}
	
	public void back(){
		try{
			//set the scene to the dashboard and display
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
