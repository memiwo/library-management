package librarymanagement.dataaccess;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

import librarymanagement.business.Book;
import librarymanagement.business.BookCopy;

public class BookService implements Dao<Book> {
	private static final String BOOK_FILE = "book.bin";

	SerializationPersistanceManager<Book> persistanceManager = new SerializationPersistanceManager<Book>(BOOK_FILE);
	
	List<Book> books;
	
	@Override
	public void save(Book object) {
		save(Arrays.asList(object));
		
	}	

	@Override
	public void save(List<Book> object) {
		/*if(books == null){
			books = persistanceManager.getEntityList();
			if(books == null){
				books = new ArrayList<>();
				books.addAll(object);
			}
		}*/
		persistanceManager.saveEntity(object);
		
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
							bc.setAvailable(Boolean.FALSE);
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
