package librarymanagement.business;

import java.io.Serializable;
import java.time.LocalDate;

@SuppressWarnings("serial")
public class Checkout implements Serializable{

	private LocalDate checkoutDate;
	private LocalDate dueDate;
	private Book book;
	
	
	public LocalDate getCheckoutDate() {
		return checkoutDate;
	}
	public void setCheckoutDate(LocalDate checkoutDate) {
		this.checkoutDate = checkoutDate;
	}
	public LocalDate getDueDate() {
		return dueDate;
	}
	public void setDueDate(LocalDate dueDate) {
		this.dueDate = dueDate;
	}
	public Book getBook() {
		return book;
	}
	public void setBook(Book book) {
		this.book = book;
	}
	
}
