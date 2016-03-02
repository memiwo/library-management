package librarymanagement.ui;

import application.Main;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import librarymanagement.business.Author;

public class CheckOutBookController {
	
	@FXML
	Label lblTitle = new Label();
	@FXML
	Label lblISBN = new Label();
	@FXML
	Label lblAuthors = new Label();
	@FXML
	Label lblAllowableDaysToBorrow = new Label();
	@FXML
	TextField tfMemberID = new TextField();
	@FXML
	Button btnBack = new Button();
	@FXML
	Button btnCheckOut = new Button();
	
	@FXML
	public void initialize(){
		/*lblTitle.setText(SearchBookController.searchedBook.getTitle());
		lblISBN.setText(SearchBookController.searchedBook.getISBN().toString());
		String authors = "";
		for(Author a : SearchBookController.searchedBook.getAuthors()){
			authors+=a.getFirstName()+" "+a.getLastName();
		}
		lblAuthors.setText(authors);
		lblAllowableDaysToBorrow.setText(SearchBookController.searchedBook.getAllowableDaysToBorrow().toString());
		*/
	}
	
	public void checkout(){
		//1. search for the library member id and get the library member object
		//2. get the librarymember checkoutrecord
		//3. create checout entry using the information of the book
		//4. add the checkout entry into the list of checkouts in checkoutrecord of the library member
		//go back to dashboard
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
	
	public void back(){
		SearchBookController.searchedBook=null;
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
