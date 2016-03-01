package librarymanagement.business;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

@SuppressWarnings("serial")
public class User extends Person implements Serializable{

	private String userName;
	private String password;
	private List<Authorization> roles = new ArrayList<Authorization>();
	
	public void Validate(){
		
	}

	public void addLibraryMember(){
		//TODO
	}
	
	public void editLibraryMemberInfo(){
		//TODO
	}
	
	public void checkOutBook(){
		//TODO
	}
	
	public void addBook(){
		//TODO
	}
	
	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public List<Authorization> getRoles() {
		return roles;
	}

	public void setRoles(List<Authorization> roles) {
		this.roles = roles;
	}
	
	
}
