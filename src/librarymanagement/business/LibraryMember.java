package librarymanagement.business;

import java.io.Serializable;
import java.util.List;

@SuppressWarnings("serial")
public class LibraryMember extends Person implements Serializable{

	private Integer memberNumber;
	private List<Checkout> checkoutRecords;
	//private CheckoutRecord checkoutRecord;

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
