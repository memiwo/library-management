package librarymanagement.ui;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.List;
import java.util.stream.Collectors;

import librarymanagement.business.Authorization;
import librarymanagement.business.Book;
import librarymanagement.business.BookCopy;
import librarymanagement.business.Checkout;
import librarymanagement.business.LibraryMember;
import librarymanagement.business.User;
import librarymanagement.dataaccess.BookService;
import librarymanagement.dataaccess.LibraryMemberService;
import librarymanagement.dataaccess.UserService;

public class TestPersistance {
	public static void main(String[] args){
	UserService userService = new UserService();
		
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
		
		Book book = new Book();
		book.setTitle("Design pattern");
		book.setISBN(123456789);
		
		
		
		
		Book b11 = new Book();
		b11.setTitle("Domain Driven Design 2");
		b11.setISBN(334455);
		Book b21 = new Book();
		b21.setISBN(2222);
		b21.setTitle("Core Java 2");
		List<BookCopy> copies = Arrays.asList(new BookCopy(1, Boolean.TRUE, b11), new BookCopy(2,Boolean.FALSE, b11), new BookCopy(3, Boolean.TRUE, b11));

		b11.setBookCopy(copies);
		
		BookService bookService1 = new BookService();
		bookService1.save(Arrays.asList(b11,b21));
		
		for(Book b: bookService1.findAll()){
			for(BookCopy bc : b.getBookCopy()){
				System.out.println("bc book "+bc.getBook().getTitle() +" copy number "+bc.getCopyNumber());
				for(BookCopy bcc: bc.getBook().getBookCopy()){
					System.out.println(bcc.getCopyNumber());
				}
			}
			System.out.println(b.getTitle());
		}
		
		LibraryMember member1 = new LibraryMember();
		member1.setMemberNumber(1234);
		LibraryMemberService libraryMemberService1 = new LibraryMemberService();
		libraryMemberService1.save(member1);
		
	}

}