package librarymanagement.dataaccess;

import java.util.List;

import librarymanagement.business.LibraryMember;

public class LibraryMemberService implements Dao<LibraryMember>{

	private static final String LIBRARYMEMBER_FILE = "library_members.bin";
	
	SerializationPersistanceManager<LibraryMember> persistanceManager = new SerializationPersistanceManager<LibraryMember>(LIBRARYMEMBER_FILE);
	
	private List<LibraryMember> libraryMembers;
	
	public LibraryMemberService() {
		libraryMembers = persistanceManager.getEntityList();
	}
	
	@Override
	public void save(LibraryMember object) {
		persistanceManager.saveEntity(libraryMembers);	
	}

	@Override
	public void save(List<LibraryMember> object) {
		persistanceManager.saveEntity(libraryMembers);
		
	}
	@Override
	public LibraryMember get(int id) {
		LibraryMember member = null;
		for(LibraryMember libMem : libraryMembers){
			if(id == libMem.getMemberNumber()){
				member = libMem;
			}
		}
		return member;
	}

	@Override
	public void delete(int id) {
		for(LibraryMember libMem : libraryMembers){
			if(id == libMem.getMemberNumber()){
				libraryMembers.remove(libMem);
			}
		}
	}

	@Override
	public List<LibraryMember> findAll() {
		return libraryMembers;
	}

}
