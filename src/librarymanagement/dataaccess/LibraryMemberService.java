package librarymanagement.dataaccess;

import java.util.List;
import java.util.stream.Collectors;

import librarymanagement.business.Checkout;
import librarymanagement.business.LibraryMember;

public class LibraryMemberService implements Dao<LibraryMember>{

	private static final String LIBRARYMEMBER_FILE = "library_members.bin";
	
	private SerializationPersistanceManager<LibraryMember> persistanceManager = new SerializationPersistanceManager<LibraryMember>(LIBRARYMEMBER_FILE);
	
	private List<LibraryMember> libraryMembers;
	
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
	
	public void addCheckout(LibraryMember member, Checkout checkout){
		//System.out.println("checkout  "+checkout.getBookCopy().getCopyNumber());
		//libraryMembers.stream().forEach(m->System.out.println(m.getMemberNumber()));
		/*LibraryMember mem = null;
		for(LibraryMember m : libraryMembers){
			if(m.getMemberNumber() == member.getMemberNumber()){
				mem = m;
			}
		}*/
		LibraryMember mem = libraryMembers.stream()
				.filter(m -> m.getMemberNumber() == member.getMemberNumber())
				.findFirst().get();
		
		if(mem != null){
			mem.getCheckoutRecords().add(checkout);
		}
		
		//System.out.println("mem = "+mem.getMemberNumber());

		for(LibraryMember m: libraryMembers){
			if(m.getMemberNumber() == mem.getMemberNumber()){
				libraryMembers.set(libraryMembers.indexOf(m), mem);
			}
		}
		
		save(libraryMembers);
		
	}
	

}