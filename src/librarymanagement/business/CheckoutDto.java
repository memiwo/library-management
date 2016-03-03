package librarymanagement.business;

@SuppressWarnings("serial")
public class CheckoutDto extends Checkout {
	private int sequence;
	private String bookTitle;
	private int copyNumber;
	

	public int getSequence(){
		return sequence;
	}
	public String getBookTitle() {		

		return getBookCopy().getBook().getTitle();
	}

	public int getCopyNumber() {
		return getBookCopy().getCopyNumber();
	}


	public CheckoutDto(int seq,BookCopy bookCopy) {		
		super(bookCopy);
		this.sequence = seq;
	}

}
