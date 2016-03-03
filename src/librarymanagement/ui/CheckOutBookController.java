package librarymanagement.ui;

import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TableView;
import librarymanagement.business.Book;
import librarymanagement.business.BookCopy;
import librarymanagement.business.Checkout;
import librarymanagement.business.CheckoutDto;
import librarymanagement.business.LibraryMember;
import librarymanagement.dataaccess.BookService;
import librarymanagement.dataaccess.LibraryMemberService;

public class CheckOutBookController {
	
	@FXML
	Label lblMember = new Label();
	@FXML
	Button btnBack = new Button();
	
	Utility utility = new Utility();
	
	private LibraryMemberService memberService = new LibraryMemberService();
	
	BookService bookService = new BookService();
	
	@FXML
	TableView<CheckoutDto> tblCheckout;
	
	@FXML
	public void initialize(){
		Book book = SearchBookController.searchedBook;	
		LibraryMember member = SearchBookController.member;
		
		BookCopy copy = book.getAvailableCopy();
		
		Checkout checkout = new Checkout(copy);		
		memberService.addCheckout(member, checkout);
		
		//Gets updated member data with list of checked out books
		member = memberService.get(member.getMemberNumber());
		
		lblMember.setText("Member # "+member.getMemberNumber()+" First Name: "+member.getFirstName());
		

		tblCheckout.getItems().clear();
		int seq = 0;
		for (Checkout ch : member.getCheckoutRecords()) {
			tblCheckout.getItems().add(new CheckoutDto(++seq,ch.getBookCopy()));
		}
		
		//updates book info
		bookService.checkoutCopy(copy);
		
		
		
		
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
