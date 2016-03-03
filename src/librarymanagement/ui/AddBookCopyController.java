package librarymanagement.ui;

import java.util.List;

import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.stage.Stage;
import librarymanagement.business.Book;
import librarymanagement.business.BookCopy;
import librarymanagement.dataaccess.BookService;

public class AddBookCopyController {

@FXML
TextField tfUniquNumber;
@FXML
Label lblTitle;
@FXML 
Button btnCancel;
int copyNumber;
Book book;

void initData(int copyNumber,Book book) {
    this.copyNumber = copyNumber;
    this.book = book;
    lblTitle.setText(this.book.getTitle());
  }

void initData(Book book) {
    this.book = book;
    lblTitle.setText(this.book.getTitle());
  }

public void addCopy(){
	BookCopy bookcopy = new BookCopy();
	bookcopy.setCopyNumber(Integer.valueOf(tfUniquNumber.getText()));
	bookcopy.setAvailable(true);
	//book.getBookCopy().add(bookcopy);
	BookService bs = new BookService();
	//bs.save(this.book);
	System.out.println("copy ...." + bookcopy+" and book is "+this.book);
	bs.addBookCopy(this.book, bookcopy);
	close();
}

public void back(){
	close();
}
void close(){
	Stage stage = (Stage) btnCancel.getScene().getWindow();

    stage.close();
}
}
