package librarymanagement.dataaccess;

import java.util.List;

import librarymanagement.business.LibraryMember;
import librarymanagement.business.User;

public class LibraryMemberService implements Dao<LibraryMember>{

	private static final String LIBRARYMEMBER_FILE = "library_members.bin";
	
	SerializationPersistanceManager<LibraryMember> persistanceManager = new SerializationPersistanceManager<LibraryMember>(LIBRARYMEMBER_FILE);
	
	List<LibraryMember> libraryMembers;
	
	public LibraryMemberService() {
		libraryMembers = persistanceManager.getEntityList();
	}
	
	@Override
	public void save(LibraryMember object) {
		libraryMembers.add(object);
	}

	@Override
	public void save(List<LibraryMember> object) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public LibraryMember get(int id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void delete(int id) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public List<LibraryMember> findAll() {
		// TODO Auto-generated method stub
		return null;
	}

}
