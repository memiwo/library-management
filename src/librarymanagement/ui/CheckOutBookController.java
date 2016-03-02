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
import librarymanagement.business.Book;

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
	
	Utility utility = new Utility();
	
	@FXML
	public void initialize(){
		Book book = SearchBookController.searchedBook;	
		
		lblTitle.setText(book.getTitle());
		lblISBN.setText(book.getISBN().toString());
		String authors = "";
		for(Author a : book.getAuthors()){
			authors+=a.getFirstName()+" "+a.getLastName();
		}
		lblAuthors.setText(authors);
		//lblAllowableDaysToBorrow.setText(book.getAllowableDaysToBorrow().toString());*/
		
	}
	
	public void checkout(){
		//1. search for the library member id and get the library member object
		//2. get the librarymember checkoutrecord
		//3. create checout esntry using the information of the book
		//4. add the checkout entry into the list of checkouts in checkoutrecord of the library member
		//go back to dashboard
		utility.openDashboard();
	}
	
	public void back(){
		SearchBookController.searchedBook=null;
		utility.openDashboard();
	}
}
