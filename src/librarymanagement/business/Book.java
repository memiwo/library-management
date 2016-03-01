package librarymanagement.business;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

@SuppressWarnings("serial")
public class Book implements Serializable{

	private String title;
	private Integer ISBN;
	private List<Author> authors = new ArrayList<Author>();
	private boolean isAvailable;
	private Integer allowableDaysToBorrow;
	private BookCopy bookCopy;
	
	
	
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public Integer getISBN() {
		return ISBN;
	}
	public void setISBN(Integer iSBN) {
		ISBN = iSBN;
	}
	public List<Author> getAuthors() {
		return authors;
	}
	public void setAuthors(List<Author> authors) {
		this.authors = authors;
	}
	public boolean isAvailable() {
		return isAvailable;
	}
	public void setAvailable(boolean isAvailable) {
		this.isAvailable = isAvailable;
	}
	public Integer getAllowableDaysToBorrow() {
		return allowableDaysToBorrow;
	}
	public void setAllowableDaysToBorrow(Integer allowableDaysToBorrow) {
		this.allowableDaysToBorrow = allowableDaysToBorrow;
	}
	public BookCopy getBookCopy() {
		return bookCopy;
	}
	public void setBookCopy(BookCopy bookCopy) {
		this.bookCopy = bookCopy;
	}
	
}
