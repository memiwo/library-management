package librarymanagement.ui;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import librarymanagement.business.Authorization;
import librarymanagement.business.Book;
import librarymanagement.business.BookCopy;
import librarymanagement.business.LibraryMember;
import librarymanagement.business.User;
import librarymanagement.dataaccess.BookService;
import librarymanagement.dataaccess.LibraryMemberService;
import librarymanagement.dataaccess.UserService;

public class TestPersistance {
	public static void main(String[] args){
		Book b1 = new Book();
		b1.setTitle("Domain Driven Design 2");
		b1.setISBN(334455);
		Book b2 = new Book();
		b2.setISBN(2222);
		b2.setTitle("Core Java 2");
		List<BookCopy> copies = Arrays.asList(new BookCopy(1, Boolean.TRUE, b1), new BookCopy(2,Boolean.FALSE, b1), new BookCopy(3, Boolean.TRUE, b1));

		b1.setBookCopy(copies);
		
		BookService bookService = new BookService();
		bookService.save(Arrays.asList(b1,b2));
		
		for(Book b: bookService.findAll()){
			for(BookCopy bc : b.getBookCopy()){
				System.out.println("bc book "+bc.getBook().getTitle() +" copy number "+bc.getCopyNumber());
				for(BookCopy bcc: bc.getBook().getBookCopy()){
					System.out.println(bcc.getCopyNumber());
				}
			}
			System.out.println(b.getTitle());
		}
		
	/*UserService userService = new UserService();
		
		User user = new User();
		user.setFirstName("Issa");
		user.getRoles().add(Authorization.LIBRARIAN);
		user.setUserName("issa");
		user.setPassword("password");
		
		User user2 = new User();
		user2.setFirstName("Ashraf");
		user2.getRoles().add(Authorization.ADMINISTRATOR);
		user2.setUserName("admin");
		user2.setPassword("admin");
		User user3 = new User();
		user3.setFirstName("Pat");
		
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
		
		
		
		LibraryMember member = new LibraryMember();
		member.setMemberNumber(1234);
		LibraryMemberService libraryMemberService = new LibraryMemberService();
		libraryMemberService.save(member);
		
		*/
	}

}
