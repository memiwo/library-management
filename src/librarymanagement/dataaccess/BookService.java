package librarymanagement.dataaccess;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import librarymanagement.business.Book;

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
	

}
