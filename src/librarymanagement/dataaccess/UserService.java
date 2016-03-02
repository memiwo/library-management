package librarymanagement.dataaccess;

import java.util.Arrays;
import java.util.List;

import librarymanagement.business.User;

public class UserService  implements Dao<User> {
	
	private static final String USER_FILE = "user.bin";
	
	SerializationPersistanceManager<User> persistanceManager = new SerializationPersistanceManager<User>(USER_FILE);
	
	List<User> users;
	

	public UserService() {
		users = persistanceManager.getEntityList();
	}

	@Override
	public void save(List<User> object) {
		users.addAll(object);
		persistanceManager.saveEntity(users);
		
	}

	@Override
	public void save(User object) {
		users.add(object);
		persistanceManager.saveEntity(users);	
	}

	@Override
	public User get(int id) {
		Object obj = persistanceManager.getEntity();
		return (User) obj;
	}

	@Override
	public void delete(int id) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public List<User> findAll() {
		return persistanceManager.getEntityList();
	}
	public User validate(String username,String password){
		// 1 - first get all users from storage and loop
		for(User usr: findAll()){
			
			if(usr != null && username.equals(usr.getUserName())&& password.equals(usr.getPassword())){
				// 2 - this user is valid what about his roles;
				//TODO get user list of roles
				
				return usr;
			}
		}
		
		return null;
		
	}
	
	
	



}
