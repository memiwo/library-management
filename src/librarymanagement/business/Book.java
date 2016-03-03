package librarymanagement.business;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

@SuppressWarnings("serial")
public class Book implements Serializable{

	private String title;
	private int ISBN;
	private List<Author> authors = new ArrayList<Author>();
	//private boolean isAvailable;
	private int allowableDaysToBorrow;
	// TODO is this should be a list of bookCopy?
	private List<BookCopy> bookCopy = new ArrayList<>();
	
	public  Book(){
		
	}
	public  Book(String title,int isbn,int allowableDaysToBorrow){
		this.title= title;
		this.ISBN = isbn;
		this.allowableDaysToBorrow = allowableDaysToBorrow;
	}
	
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public int getISBN() {
		return ISBN;
	}
	public void setISBN(int iSBN) {
		ISBN = iSBN;
	}
	public List<Author> getAuthors() {
		return authors;
	}
	public void setAuthors(List<Author> authors) {
		this.authors = authors;
	}
	/*public boolean isAvailable() {
		return isAvailable;
	}
	public void setAvailable(boolean isAvailable) {
		this.isAvailable = isAvailable;
	}*/
	public int getAllowableDaysToBorrow() {
		return allowableDaysToBorrow;
	}
	public void setAllowableDaysToBorrow(int allowableDaysToBorrow) {
		this.allowableDaysToBorrow = allowableDaysToBorrow;
	}
	public List<BookCopy> getBookCopy() {
		return bookCopy;
	}
	public void setBookCopy(List<BookCopy> bookCopy) {
		this.bookCopy = bookCopy;
	}
	
	public BookCopy getAvailableCopy(){
		for(BookCopy bc: bookCopy){
			if(bc.isAvailable()){
				return bc;
			}
		}
		return null;
	}
	
}
