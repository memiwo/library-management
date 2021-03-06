package librarymanagement.business;

import java.io.Serializable;

@SuppressWarnings("serial")
public class BookCopy implements Serializable{

	// TODO should Add new field copy availability
	// and due date if not available
	private int copyNumber;
	private boolean isAvailable;
	private Book book;

	public BookCopy() {
	}
	public BookCopy(int copyNumber, boolean isAvailable, Book book) {
		this.copyNumber = copyNumber;
		this.isAvailable = isAvailable;
		this.book = book;
	}

	public Book getBook() {
		return book;
	}
	public void setBook(Book book) {
		this.book = book;
	}
	public boolean isAvailable() {
		return isAvailable;
	}

	public void setAvailable(boolean isAvailable) {
		this.isAvailable = isAvailable;
	}

	public int getCopyNumber() {
		return copyNumber;
	}

	public void setCopyNumber(int copyNumber) {
		this.copyNumber = copyNumber;
	}
	
}