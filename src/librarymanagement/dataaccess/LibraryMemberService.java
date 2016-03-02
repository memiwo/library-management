package librarymanagement.dataaccess;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collector;
import java.util.stream.Collectors;

import application.Main;
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
	

}