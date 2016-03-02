package librarymanagement.ui;

import java.util.List;

import javafx.fxml.FXML;
import javafx.scene.control.TableView;
import librarymanagement.business.Book;
import librarymanagement.dataaccess.BookService;

public class BookController {

@FXML
TableView<Book> tblBooks;
@FXML
public void initialize(){
	loadBooksData();
}

public void loadBooksData(){
	tblBooks.getItems().clear();
	BookService bookService =new BookService();
	
	List<Book> books =	bookService.findAll();
	
	for (Book book : books) {
		tblBooks.getItems().add(book);
	}
}

public void openAddBook(){
	
}

}