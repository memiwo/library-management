package librarymanagement.business;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

@SuppressWarnings("serial")
public class CheckoutRecord implements Serializable{

	private List<Checkout> checkouts = new ArrayList<Checkout>();
	private List<RecordOfFine> recordOfFines = new ArrayList<RecordOfFine>();
	
	public List<Checkout> getCheckouts() {
		return checkouts;
	}
	public void setCheckouts(List<Checkout> checkouts) {
		this.checkouts = checkouts;
	}
	public List<RecordOfFine> getRecordOfFines() {
		return recordOfFines;
	}
	public void setRecordOfFines(List<RecordOfFine> recordOfFines) {
		this.recordOfFines = recordOfFines;
	}
	
	public void addCheckoutRecord(Checkout checkout){
		checkouts.add(checkout);
	}
	
}
