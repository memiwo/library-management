package librarymanagement.business;

import java.util.ArrayList;
import java.util.List;

public class UserServices {
	
public  User validate(String username,String password){
 
 String datauser = "as";
 String datapass = "as";
 if(username.equals(datauser) && password.equals(datapass)){
	 User result = new User();
	 result.setFirstName("ashraf");
	 result.setLastName("Ezzat");
	 List<Authorization> roles = new ArrayList<>();
	 
	 result.setRoles(roles);
	 return result;
 }
 return null;
		
		
		
}
	
}
