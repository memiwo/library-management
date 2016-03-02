package librarymanagement.ui;

import java.util.List;

import javafx.fxml.FXML;
import javafx.scene.control.TableRow;
import javafx.scene.control.TableView;
import librarymanagement.business.Book;
import librarymanagement.dataaccess.BookService;

public class BookController {
Utility utility = new Utility();
@FXML
TableView<Book> tblBooks;
@FXML
//label 

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
	            System.out.println(rowData);
	        }
	    });
	    return row ;
	});
}

void showBookData(Book book){
	
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