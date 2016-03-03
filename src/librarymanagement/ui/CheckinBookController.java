package librarymanagement.ui;

import java.io.IOException;
import java.util.List;

import application.Main;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.AnchorPane;
import librarymanagement.business.Book;
import librarymanagement.business.BookCopy;
import librarymanagement.business.Checkout;
import librarymanagement.business.LibraryMember;
import librarymanagement.dataaccess.BookService;
import librarymanagement.dataaccess.LibraryMemberService;

public class CheckinBookController {

	@FXML
	TextField tfISBN = new TextField();
	@FXML
	Button btnSearch = new Button();
	@FXML
	Button btnBack = new Button();
	
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
	
	public void checkIn(){
		LibraryMember member = memberService.get(Integer.valueOf(tfMemberId.getText()));
		
		if(member == null){
			//show member does not exist
			message.setText("member is not found");
			return;
		}else{
			
			List<Checkout> checkedOuts = member.getCheckoutRecords();
			BookCopy checkedOutCopy = null;
			for(Checkout ch: checkedOuts){
				if(ch.getBookCopy().getBook().getISBN() == Integer.valueOf(tfISBN.getText())){
					checkedOutCopy = ch.getBookCopy();
				}
			}
			if(checkedOutCopy == null){
				message.setText("Member has not checked out this book");
				return;
			}
		
			bookService.checkinCopy(checkedOutCopy);
			
			memberService.checkinBook(member, checkedOutCopy);
			
			message.setText("You have successfully checked in a book");
						
			/*anchPane.getChildren().clear();
			try {
				Parent root = FXMLLoader.load(getClass().getResource("/librarymanagement/ui/CheckOutBook.fxml"));
				AnchorPane a = (AnchorPane)root;
				a.getStylesheets().add(getClass().getResource("application.css").toExternalForm());
				anchPane.getChildren().add(a);
			} catch (IOException e) {
				e.printStackTrace();
			}*/
			//utility.completeCheckoutBook();
			
		}		
	
	}
	
}
