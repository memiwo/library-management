package librarymanagement.dataaccess;

import java.util.Arrays;
import java.util.List;

import librarymanagement.business.Checkout;
import librarymanagement.business.CheckoutRecord;

public class CheckoutRecordService implements Dao<Checkout> {

	private static final String CHECKOUT_RECORD_FILE = "checkout_record.bin";
	
	private CheckoutRecord checkoutRecord;
	
	private SerializationPersistanceManager<CheckoutRecord> persistanceManager = new SerializationPersistanceManager<>(CHECKOUT_RECORD_FILE);;
	
	public CheckoutRecordService() {
		List<CheckoutRecord> checkoutRecords = persistanceManager.getEntityList();
		
		if(checkoutRecords.size() >= 1){

			checkoutRecord = persistanceManager.getEntityList().get(0);
		}else{
			checkoutRecord = new CheckoutRecord();
		}
	}

	@Override
	public void save(Checkout checkout) {
		checkoutRecord.addCheckoutRecord(checkout);
		persistanceManager.saveEntity(Arrays.asList(checkoutRecord));
		
	}

	@Override
	public void save(List<Checkout> object) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public Checkout get(int id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void delete(int id) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public List<Checkout> findAll() {
		// TODO Auto-generated method stub
		return null;
	}
	
	public CheckoutRecord getCheckoutRecord(){
		return checkoutRecord;
	}

}
