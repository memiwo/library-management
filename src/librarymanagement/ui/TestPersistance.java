package librarymanagement.ui;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import librarymanagement.business.Authorization;
import librarymanagement.business.Book;
import librarymanagement.business.User;
import librarymanagement.dataaccess.BookService;
import librarymanagement.dataaccess.UserService;

public class TestPersistance {
	public static void main(String[] args){
	UserService userService = new UserService();
		
		User user = new User();
		user.setFirstName("Issa");
		
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
		
		Book b1 = new Book();
		b1.setTitle("Domain Driven Design");
		Book b2 = new Book();
		b2.setTitle("Core Java");
		
		BookService bookService = new BookService();
		bookService.save(Arrays.asList(b1,b2));
		
		for(Book b: bookService.findAll()){
			System.out.println(b.getTitle());
		}
		
		
	}

}
