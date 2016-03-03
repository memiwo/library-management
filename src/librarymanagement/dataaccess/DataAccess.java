package librarymanagement.dataaccess;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import librarymanagement.business.Address;
import librarymanagement.business.Author;
import librarymanagement.business.Book;
import librarymanagement.business.BookCopy;
import librarymanagement.business.Checkout;
import librarymanagement.business.LibraryMember;

public class DataAccess {

	public static void main(String[] args) {

		System.out.println("Creating Library Members objects....");
		//create Library Members
		LibraryMember lib1 = new LibraryMember();
		lib1.setMemberNumber(1);
		lib1.setFirstName("firstname1");
		lib1.setLastName("lastname1");
		lib1.setPhoneNumber(12345);
		Address add1 = new Address();
		add1.setStreet("street1");
		add1.setCity("city1");
		add1.setState("state1");
		add1.setZip(123);
		lib1.setAddress(add1);
		lib1.setCheckoutRecords(new ArrayList<Checkout>());
		
		LibraryMember lib2 = new LibraryMember();
		lib2.setMemberNumber(2);
		lib2.setFirstName("firstname2");
		lib2.setLastName("lastname2");
		lib2.setPhoneNumber(12345);
		Address add2 = new Address();
		add2.setStreet("street2");
		add2.setCity("city2");
		add2.setState("state2");
		add2.setZip(123);
		lib2.setAddress(add2);
		lib2.setCheckoutRecords(new ArrayList<Checkout>());
		
		LibraryMember lib3 = new LibraryMember();
		lib3.setMemberNumber(3);
		lib3.setFirstName("firstname3");
		lib3.setLastName("lastname3");
		lib3.setPhoneNumber(12345);
		Address add3 = new Address();
		add3.setStreet("street3");
		add3.setCity("city3");
		add3.setState("state3");
		add3.setZip(123);
		lib3.setAddress(add3);
		lib3.setCheckoutRecords(new ArrayList<Checkout>());
		
		LibraryMember lib4 = new LibraryMember();
		lib4.setMemberNumber(4);
		lib4.setFirstName("firstname4");
		lib4.setLastName("lastname4");
		lib4.setPhoneNumber(12345);
		Address add4 = new Address();
		add4.setStreet("street4");
		add4.setCity("city4");
		add4.setState("state4");
		add4.setZip(123);
		lib4.setAddress(add4);
		lib4.setCheckoutRecords(new ArrayList<Checkout>());
		
		System.out.println("Creating book objects.");
		// Create books
		Book b1 = new Book();
		b1.setTitle("book1");
		b1.setISBN(1);
		b1.setAllowableDaysToBorrow(3);
		
		BookCopy bc11 = new BookCopy();
		bc11.setAvailable(false);
		bc11.setBook(b1);
		bc11.setCopyNumber(1);
		BookCopy bc12 = new BookCopy();
		bc11.setAvailable(true);
		bc11.setBook(b1);
		bc11.setCopyNumber(5);
		BookCopy bc13 = new BookCopy();
		bc11.setAvailable(true);
		bc11.setBook(b1);
		bc11.setCopyNumber(6);
		
		
		b1.getBookCopy().add(bc11);
		b1.getBookCopy().add(bc12);
		b1.getBookCopy().add(bc13);
		Author a1 = new Author();
		a1.setFirstName("authorfirstname1");
		a1.setLastName("authorfirstname1");
		b1.getAuthors().add(a1);
		Checkout c1 = new Checkout(bc11);
		lib1.getCheckoutRecords().add(c1);
		
		Book b2 = new Book();
		b2.setTitle("book2");
		b2.setISBN(2);
		b2.setAllowableDaysToBorrow(3);
		
		BookCopy bc21 = new BookCopy();
		bc21.setAvailable(false);
		bc21.setBook(b2);
		bc21.setCopyNumber(7);
		BookCopy bc22 = new BookCopy();
		bc21.setAvailable(false);
		bc21.setBook(b2);
		bc21.setCopyNumber(8);
		BookCopy bc23 = new BookCopy();
		bc21.setAvailable(false);
		bc21.setBook(b2);
		bc21.setCopyNumber(9);
		
		b2.getBookCopy().add(bc21);	
		b2.getBookCopy().add(bc22);
		b2.getBookCopy().add(bc23);	
		Author a2 = new Author();
		a2.setFirstName("authorfirstname2");
		a2.setLastName("authorfirstname2");
		b2.getAuthors().add(a2);
		Checkout c2 = new Checkout(bc21);
		lib2.getCheckoutRecords().add(c2);
		
		Book b3 = new Book();
		b3.setTitle("book3");
		b3.setISBN(3);
		b3.setAllowableDaysToBorrow(3);
		BookCopy bc3 = new BookCopy();
		bc3.setAvailable(false);
		bc3.setBook(b3);
		bc3.setCopyNumber(3);
		b3.getBookCopy().add(bc3);
		Author a3 = new Author();
		a3.setFirstName("authorfirstname3");
		a3.setLastName("authorfirstname3");
		b3.getAuthors().add(a3);
		Checkout c3 = new Checkout(bc3);
		lib3.getCheckoutRecords().add(c3);
		
		Book b4 = new Book();
		b4.setTitle("book4");
		b4.setISBN(4);
		b4.setAllowableDaysToBorrow(4);
		BookCopy bc4 = new BookCopy();
		bc4.setAvailable(false);
		bc4.setBook(b4);
		bc4.setCopyNumber(4);
		b4.getBookCopy().add(bc4);
		Author a4 = new Author();
		a4.setFirstName("authorfirstname4");
		a4.setLastName("authorfirstname4");
		b4.getAuthors().add(a4);
		Checkout c4 = new Checkout(bc4);
		lib4.getCheckoutRecords().add(c4);
		
		System.out.println("Savings library members");
		List<LibraryMember> libMembers = Arrays.asList(lib1, lib2, lib3, lib4);
		LibraryMemberService libService = new LibraryMemberService();
		libService.save(libMembers);
		
		System.out.println("Savings books");
		BookService bookService = new BookService();
		bookService.save(Arrays.asList(b1,b2,b3,b4));
		
	}

}
