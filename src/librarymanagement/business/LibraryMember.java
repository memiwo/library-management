package librarymanagement.business;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

@SuppressWarnings("serial")
public class LibraryMember extends Person implements Serializable{

	private int memberNumber;
	private List<Checkout> checkoutRecords = new ArrayList<>();
	
	public LibraryMember() {
	}
	
	public LibraryMember(int memberNumber){
		this.memberNumber = memberNumber;
	}

	public int getMemberNumber() {
		return memberNumber;
	}

	public void setMemberNumber(int memberNumber) {
		this.memberNumber = memberNumber;
	}

	public List<Checkout> getCheckoutRecords() {
		return checkoutRecords;
	}

	public void setCheckoutRecords(List<Checkout> checkoutRecords) {
		this.checkoutRecords = checkoutRecords;
	}
	
	
	
}
