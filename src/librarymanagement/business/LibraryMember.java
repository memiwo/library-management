package librarymanagement.business;

import java.io.Serializable;

@SuppressWarnings("serial")
public class LibraryMember extends Person implements Serializable{

	private Integer memberNumber;
	private CheckoutRecord checkoutRecord;

	public Integer getMemberNumber() {
		return memberNumber;
	}

	public void setMemberNumber(Integer memberNumber) {
		this.memberNumber = memberNumber;
	}

	public CheckoutRecord getCheckoutRecord() {
		return checkoutRecord;
	}

	public void setCheckoutRecord(CheckoutRecord checkoutRecord) {
		this.checkoutRecord = checkoutRecord;
	}
	
}
