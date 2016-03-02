package librarymanagement.ui;

import java.time.LocalDate;

import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import librarymanagement.business.Author;
import librarymanagement.business.Book;
import librarymanagement.business.BookCopy;
import librarymanagement.business.Checkout;
import librarymanagement.business.LibraryMember;
import librarymanagement.dataaccess.BookService;
import librarymanagement.dataaccess.LibraryMemberService;

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
	
	private LibraryMemberService memberService = new LibraryMemberService();
	
	BookService bookService = new BookService();
	
	@FXML
	public void initialize(){
		Book book = SearchBookController.searchedBook;	
		LibraryMember member = SearchBookController.member;
		
		BookCopy copy = book.getAvailableCopy();
		
		Checkout checkout = new Checkout(copy);		
		memberService.addCheckout(member, checkout);
		
		//Gets updated member data with list of checked out books
		member = memberService.get(member.getMemberNumber());
		
		//updates book info
		bookService.checkoutCopy(copy);
		
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
