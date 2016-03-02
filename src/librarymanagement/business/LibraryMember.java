package librarymanagement.business;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

@SuppressWarnings("serial")
public class LibraryMember extends Person implements Serializable{

	private Integer memberNumber;
	private List<Checkout> checkoutRecords = new ArrayList<>();
	
	public LibraryMember() {
	}
	
	public LibraryMember(int memberNumber){
		this.memberNumber = memberNumber;
	}

	public Integer getMemberNumber() {
		return memberNumber;
	}

	public void setMemberNumber(Integer memberNumber) {
		this.memberNumber = memberNumber;
	}

	public List<Checkout> getCheckoutRecords() {
		return checkoutRecords;
	}

	public void setCheckoutRecords(List<Checkout> checkoutRecords) {
		this.checkoutRecords = checkoutRecords;
	}
	
	
	
}
