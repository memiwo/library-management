package librarymanagement.ui;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.List;
import java.util.stream.Collectors;

import librarymanagement.business.Authorization;
import librarymanagement.business.Book;
import librarymanagement.business.Checkout;
import librarymanagement.business.CheckoutRecord;
import librarymanagement.business.LibraryMember;
import librarymanagement.business.User;
import librarymanagement.dataaccess.BookService;
import librarymanagement.dataaccess.CheckoutRecordService;
import librarymanagement.dataaccess.LibraryMemberService;
import librarymanagement.dataaccess.UserService;

public class TestPersistance {
	public static void main(String[] args){
	/*UserService userService = new UserService();
		
		User user = new User();
		user.setFirstName("Issa");
		user.getRoles().add(Authorization.LIBRARIAN);
		user.setUserName("issa");
		user.setPassword("issa123");
		
		User user2 = new User();
		user2.setFirstName("Ashraf");
		user2.getRoles().add(Authorization.ADMINISTRATOR);
		user2.setUserName("admin");
		user2.setPassword("admin");
		User user3 = new User();
		user3.setFirstName("Pat");
		user3.getRoles().add(Authorization.ADMINISTRATOR);
		user3.getRoles().add(Authorization.LIBRARIAN);
		user3.setUserName("pat");
		user3.setPassword("pat123");
		
		User u2 = new User();
		u2.setFirstName("John");
		
		ArrayList<User> users = new ArrayList<User>();
		
		users.add(user2);
		users.add(user);
		users.add(user3);
		users.add(u2);
		
		userService.save(users);
		List<User> user22 = userService.findAll();
		for(User u: user22){
			System.out.println(u.getFirstName());
		}
		
		Book b1 = new Book();
		b1.setTitle("Domain Driven Design");
		Book b2 = new Book();
		b2.setTitle("Core Java");
		
		BookService bookService = new BookService();
		bookService.save(Arrays.asList(b1,b2));
		
		for(Book b: bookService.findAll()){
			System.out.println(b.getTitle());
		}
		
		LibraryMember member = new LibraryMember();
		member.setMemberNumber(1234);
		LibraryMemberService libraryMemberService = new LibraryMemberService();
		libraryMemberService.save(member);
		
		List<String> asList = Arrays.asList("hello", "my", "dear", "world");
		asList = asList.stream().filter(s -> !s.contains("ll")).collect(Collectors.toList());
		asList.stream().forEach(System.out::println);
		*/
		Book book = new Book();
		book.setTitle("Design pattern");
		book.setISBN(123456789);
		
		
		
		Checkout ch = new Checkout();
		ch.setBook(book);
		ch.setCheckoutDate(LocalDate.of(2016, 3, 02));
		ch.setDueDate(LocalDate.of(2016, 03, 10));
		
		CheckoutRecordService recordService = new CheckoutRecordService();
		recordService.save(ch);
		
		CheckoutRecord record = recordService.getCheckoutRecord();
		List<Checkout> checkouts = record.getCheckouts();
		//System.out.println(record.get);
		checkouts.stream().forEach( c -> System.out.println(c.getBook().getTitle()));
		
		
	}

}
