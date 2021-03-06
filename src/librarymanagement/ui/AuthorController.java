package librarymanagement.ui;

import java.util.List;

import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.stage.Stage;
import librarymanagement.business.Author;
import librarymanagement.business.Book;
import librarymanagement.dataaccess.BookService;

public class AuthorController {

	@FXML
	TextField tfFirstName;
	@FXML
	TextField tfLastName;
	@FXML
	Button btnCancel;
	@FXML
	Label lblTitle;
	Book book;
	
	

	void initData(Book book) {
	    this.book = book;
	    lblTitle.setText(this.book.getTitle());
	  }
	
	public void addAuthor(){
		Author newAuthor =new Author();
		newAuthor.setFirstName(tfFirstName.getText());
		newAuthor.setLastName(tfLastName.getText());
		this.book.getAuthors().add(newAuthor);
		BookService bs = new BookService();
		List<Book> books = bs.findAll();
		for(Book b : books){
			if(b.getISBN() == this.book.getISBN()){
				books.set(books.indexOf(b),this.book);
			}
		}
		bs.save(books);
		close();
	}
	
	public void cancel(){
		close();
	}
	
	private void close(){
		Stage stage = (Stage) btnCancel.getScene().getWindow();

	    stage.close();
	}
}
