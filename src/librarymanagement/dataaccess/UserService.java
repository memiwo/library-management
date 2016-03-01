package librarymanagement.dataaccess;

import librarymanagement.business.User;

public class UserService implements DAO {
	
	private static final String USER_FILE = "storage/user.bin";

	@Override
	public void save(Object object) {
		User user = (User) object;
				
		
	}

	@Override
	public User get(int id) {
		return null;
	}
	

}
