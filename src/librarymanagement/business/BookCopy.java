package librarymanagement.business;

import java.io.Serializable;

@SuppressWarnings("serial")
public class BookCopy implements Serializable{

	private Integer copyNumber;

	public Integer getCopyNumber() {
		return copyNumber;
	}

	public void setCopyNumber(Integer copyNumber) {
		this.copyNumber = copyNumber;
	}
	
}
