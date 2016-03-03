package librarymanagement.dataaccess;

import java.util.Iterator;
import java.util.List;
import java.util.stream.Collectors;

import librarymanagement.business.Book;
import librarymanagement.business.BookCopy;
import librarymanagement.business.Checkout;
import librarymanagement.business.LibraryMember;

public class LibraryMemberService implements Dao<LibraryMember>{

	private static final String LIBRARYMEMBER_FILE = "library_members.bin";
	
	private SerializationPersistanceManager<LibraryMember> persistanceManager = new SerializationPersistanceManager<LibraryMember>(LIBRARYMEMBER_FILE);
	
	private List<LibraryMember> libraryMembers;
	
	public LibraryMemberService() {
		libraryMembers = persistanceManager.getEntityList();
	}
	
	@Override
	public void save(LibraryMember object) {
		libraryMembers.add(object);
		saveAll(libraryMembers);
	}
	
	private void saveAll(List<LibraryMember> list){
		persistanceManager.saveEntity(list);
	}

	@Override
	public void save(List<LibraryMember> object) {
		saveAll(object);
		libraryMembers = findAll();
		
	}

	@Override
	public LibraryMember get(int id) {
		
		return libraryMembers.stream().filter(m -> m.getMemberNumber() == id).findFirst().orElse(null);
	}

	@Override
	public void delete(int id) {
		libraryMembers = libraryMembers.stream().filter(m -> m.getMemberNumber() != id).collect(Collectors.toList());
		
	}

	@Override
	public List<LibraryMember> findAll() {
		return persistanceManager.getEntityList();
	}
	
	public boolean isMemberCheckedOutBook(LibraryMember member, Book book){
		if(member != null && book != null){
			for(Checkout ch : member.getCheckoutRecords()){
				if(ch.getBookCopy().getBook().getISBN() == book.getISBN()){
					return true;
				}
			}
		}
		return false;
	}
	
	public void addCheckout(LibraryMember member, Checkout checkout){		
		LibraryMember mem = libraryMembers.stream()
				.filter(m -> m.getMemberNumber() == member.getMemberNumber())
				.findFirst().get();
		
		if(mem != null){
			mem.getCheckoutRecords().add(checkout);
		}
		

		for(LibraryMember m: libraryMembers){
			if(m.getMemberNumber() == mem.getMemberNumber()){
				libraryMembers.set(libraryMembers.indexOf(m), mem);
			}
		}
		
		save(libraryMembers);
		
	}
	
	public void checkinBook(LibraryMember member, BookCopy copy){
		LibraryMember mem = libraryMembers.stream()
				.filter(m -> m.getMemberNumber() == member.getMemberNumber())
				.findFirst().get();
		if(mem != null){
			
			List<Checkout> checkouts = mem.getCheckoutRecords();
			
			/**
			 * It is strongly recommended to use Iterator when concurrently iterating and removing an item in a collection.
			 * Using for loop results in ConcurrentModificationException
			 */
			Iterator<Checkout> checkoutIterator = checkouts.iterator();
			
			while(checkoutIterator.hasNext()){
				Book book = checkoutIterator.next().getBookCopy().getBook();
				if(book.getISBN() == copy.getBook().getISBN()){
					checkoutIterator.remove();
				}
			}
						
			mem.setCheckoutRecords(checkouts);			
			
			for(LibraryMember m: libraryMembers){
				if(m.getMemberNumber() == mem.getMemberNumber()){
					libraryMembers.set(libraryMembers.indexOf(m), mem);
				}
			}
			
			save(libraryMembers);
		}
		
	}
	

}