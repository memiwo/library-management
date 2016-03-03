package librarymanagement.ui;

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
	//tfUniquNumber.setText(copyNumber);;
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
	this.copyNumber =Integer.parseInt(tfUniquNumber.getText());
	bookcopy.setCopyNumber(this.copyNumber);
	bookcopy.setAvailable(true);
	
	book.getBookCopy().add(bookcopy);
	BookService bs = new BookService();
	bs.save(this.book);
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
