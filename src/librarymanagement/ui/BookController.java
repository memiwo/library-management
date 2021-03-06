package librarymanagement.ui;

import java.util.List;

import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.control.TableRow;
import javafx.scene.control.TableView;
import librarymanagement.business.Author;
import librarymanagement.business.Book;
import librarymanagement.business.BookCopy;
import librarymanagement.dataaccess.BookService;
import javafx.scene.layout.AnchorPane;

public class BookController {
Utility utility = new Utility();
@FXML
TableView<Book> tblBooks;
@FXML
TableView<BookCopy> tblBookCopies;
@FXML
TableView<Author> tblAuthors;


@FXML
Label lbltitle;
@FXML
Label lblISBN;
@FXML
Label lblNumberOfCopy;
@FXML
Label lblAllowableDaysToBorrow;

@FXML
AnchorPane ap1;

Book rowData;

@FXML
public void initialize(){
	loadBooksData();
	getSelecteditem();
}

public void loadBooksData(){
	tblBooks.getItems().clear();
	BookService bookService =new BookService();
	
	List<Book> books =	bookService.findAll();
	
	for (Book book : books) {		
		tblBooks.getItems().add(book);
	}
}
private void getSelecteditem(){
	tblBooks.setRowFactory( tv -> {
	    TableRow<Book> row = new TableRow<>();
	    row.setOnMouseClicked(event -> {
	        if (event.getClickCount() == 1 && (! row.isEmpty()) ) {
	             rowData = row.getItem();
	             showBookData(rowData);
	        }
	    });
	    return row ;
	});
}

void showBookData(Book book){
	lbltitle.setText(book.getTitle());
	lblAllowableDaysToBorrow.setText(String.valueOf(book.getAllowableDaysToBorrow()));
	lblISBN.setText(String.valueOf(book.getISBN()));
	
	Integer size= book.getBookCopy().size();
	lblNumberOfCopy.setText(size.toString());
	
	tblBookCopies.getItems().clear();
	tblBookCopies.getItems().setAll(book.getBookCopy());
	tblAuthors.getItems().clear();
	tblAuthors.getItems().setAll(book.getAuthors());
}


public void refresh(){
	loadBooksData();
	getSelecteditem();
}

@FXML
public void openAddBookCopy(){
	
	utility.lunchAddBookCopy(rowData);
}
@FXML
public void openAddBookAuthor(){
	if(rowData != null)
	utility.lunchAddBookAutor(rowData);
}
@FXML
public void openAddBook(){
	utility.lunchAddBook();
}

}