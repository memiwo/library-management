package librarymanagement.ui;

import java.util.List;

import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.stage.Stage;
import librarymanagement.business.Book;
import librarymanagement.dataaccess.BookService;

public class AddBookController {

	@FXML
	TextField tfTitle;
	@FXML
	Label lblError;
	@FXML
	TextField tfISBN;
	@FXML
	TextField tfAllowableDaysToBorrow;
	@FXML
	Button btnCancel;
	@FXML
	Button btnSave;
	
BookService bookService = new BookService();
	
	@FXML
	public void addBook(){
		try{
		
		
		String title = tfTitle.getText();
		int isbn = Integer.parseInt(tfISBN.getText());
		int allowable = Integer.parseInt(tfAllowableDaysToBorrow.getText());
		Book newBook = new Book(title,isbn,allowable);
		//System.out.println("On Save");
		List<Book> books = bookService.findAll();
		books.add(newBook);
		bookService.save(books);
		close();
		}catch(Exception ex)
		{
			lblError.setText(ex.getMessage());
		}
		
	}
	@FXML
	public void cancel(){
		
		close();
		
	}
	
	void close(){
		Stage stage = (Stage) btnCancel.getScene().getWindow();

        stage.close();
	}
}
