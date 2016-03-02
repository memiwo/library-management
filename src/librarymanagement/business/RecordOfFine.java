package librarymanagement.business;

import java.io.Serializable;
import java.time.LocalDate;

@SuppressWarnings("serial")
public class RecordOfFine implements Serializable{

	private LocalDate paidDate;
	private Double amount;
	
	public LocalDate getPaidDate() {
		return paidDate;
	}
	public void setPaidDate(LocalDate paidDate) {
		this.paidDate = paidDate;
	}
	public Double getAmount() {
		return amount;
	}
	public void setAmount(Double amount) {
		this.amount = amount;
	}
	
}
