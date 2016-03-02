package librarymanagement.business;

import java.io.Serializable;
import java.time.LocalDate;

@SuppressWarnings("serial")
public class Checkout implements Serializable{
	
	private static final int NUMBER_OF_ALLOWED_BORROWED_DAYS = 21;

	private LocalDate checkoutDate;
	private LocalDate dueDate;
	private BookCopy bookCopy;
	
	public Checkout(BookCopy bookCopy) {

		this.bookCopy = bookCopy;
		
		this.checkoutDate = LocalDate.now();
		
		Book book = bookCopy.getBook();
		
		if(book.getAllowableDaysToBorrow() == null || book.getAllowableDaysToBorrow() == 0){
			this.dueDate = this.checkoutDate.plusDays(NUMBER_OF_ALLOWED_BORROWED_DAYS);
		}else{
			this.dueDate = this.checkoutDate.plusDays(book.getAllowableDaysToBorrow());
		}
	}
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
	public BookCopy getBookCopy() {
		return bookCopy;
	}
	public void setBookCopy(BookCopy bookCopy) {
		this.bookCopy = bookCopy;
	}
	
	
}