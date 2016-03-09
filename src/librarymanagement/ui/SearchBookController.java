package librarymanagement.ui;

import java.io.IOException;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.AnchorPane;
import librarymanagement.application.Main;
import librarymanagement.business.Book;
import librarymanagement.business.LibraryMember;
import librarymanagement.dataaccess.BookService;
import librarymanagement.dataaccess.LibraryMemberService;

public class SearchBookController {

	@FXML
	TextField tfISBN = new TextField();
	@FXML
	Button btnSearch = new Button();	
	@FXML
	TextField tfMemberId;	
	@FXML
	Label message;	
	@FXML
	AnchorPane anchPane = new AnchorPane();
	
	public static Book searchedBook;
	
	public static LibraryMember member;
	

	Utility utility = new Utility();
	
	private LibraryMemberService memberService = new LibraryMemberService();
	
	private BookService bookService = new BookService();
	
	public void search(){
		LibraryMember member = memberService.get(Integer.valueOf(tfMemberId.getText()));
		
		if(member == null){
			//show member does not exist
			message.setText("member is not found");
			return;
		}else{
			Book book = bookService.isAvailableForCheckout(Integer.valueOf(tfISBN.getText()));
			
			if(book == null){
				message.setText("Book is not available");
				return;
			}
			//Prevent a library member from checking out the same book he/she already checkedout
			if(memberService.isMemberCheckedOutBook(member, book)){
				message.setText("You have already checked out this book");
				return;
			}
			if(book.getAvailableCopy() == null){
				message.setText("All Book copies are checked out");
				return;
			}
			SearchBookController.searchedBook = book;
			SearchBookController.member = member;
			
			anchPane.getChildren().clear();
			/*try {
				Parent root = FXMLLoader.load(getClass().getResource("/librarymanagement/ui/CheckOutBook.fxml"));
				AnchorPane a = (AnchorPane)root;
				a.getStylesheets().add(getClass().getResource("application.css").toExternalForm());
				anchPane.getChildren().add(a);
			} catch (IOException e) {
				e.printStackTrace();
			}*/
			utility.displayScreenInDashBoard(anchPane, "CheckOutBook.fxml");
			//utility.completeCheckoutBook();
			
		}		
	
	}
}
