package librarymanagement.ui;

import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import librarymanagement.business.Book;
import librarymanagement.business.BookCopy;

public class AddBookCopyController {

@FXML
TextField tfUniquNumber;
@FXML
Label lblTitle;

int copyNumber;
Book book;

void initData(int copyNumber,Book book) {
    this.copyNumber = copyNumber;
    this.book = book;
    lblTitle.setText(this.book.getTitle());
  }

public void addCopy(){
	BookCopy bookcopy = new BookCopy();
	bookcopy.setCopyNumber(this.copyNumber);
	book.setBookCopy(bookcopy);
}

public void back(){
	Utility utility = new Utility();
	utility.openSearchBook();
}
}
