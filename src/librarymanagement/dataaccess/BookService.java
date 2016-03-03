package librarymanagement.dataaccess;

import java.util.ArrayList;
import java.util.List;

import librarymanagement.business.Book;
import librarymanagement.business.BookCopy;

public class BookService implements Dao<Book> {
	private static final String BOOK_FILE = "book.bin";

	SerializationPersistanceManager<Book> persistanceManager = new SerializationPersistanceManager<Book>(BOOK_FILE);
	
	List<Book> books= new ArrayList<Book>();
	
	@Override
	public void save(Book object) {
	
		books.add(object);
		
		save(books);
		
	}	
	
	public void addBookCopy(Book book, BookCopy copy){
		List<Book> books = findAll();
		for(Book b : books){
			if(b.getISBN() == book.getISBN()){
				List<BookCopy> copies = b.getBookCopy();
				copies.add(copy);
				b.setBookCopy(copies);
				//b.getBookCopy().add(copy);
				books.set(books.indexOf(b), b);
			}
		}
		
		save(books);
	}

	@Override
	public void save(List<Book> object) {
	
		persistanceManager.saveEntity(object);
		books = findAll();
	}
	
	public Book isAvailableForCheckout(int isbn){
		
		List<Book> books = findAll();
		for(Book book : books){
			if(book.getISBN() == isbn)
				return book;
		}

		return null;
	}



	@Override
	public Book get(int id) {
		Object obj = persistanceManager.getEntity();
		return (Book) obj;
	}

	@Override
	public void delete(int id) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public List<Book> findAll() {
		return persistanceManager.getEntityList();
	}
	
	public void checkoutCopy(BookCopy copy){
		if(copy != null){
		
			Book book = copy.getBook();
		
			List<Book> books = findAll();
			for(Book b: books){
				if(b.getISBN() == book.getISBN()){
					List<BookCopy> copies = b.getBookCopy();
					for(BookCopy bc: copies){
						if(bc.getCopyNumber() == copy.getCopyNumber()){
							bc.setAvailable(false);
							copies.set(copies.indexOf(bc), bc);
						}
					}
					books.set(books.indexOf(b), b);
				}
			}
			
			save(books);
		}
		
	}
	

}
